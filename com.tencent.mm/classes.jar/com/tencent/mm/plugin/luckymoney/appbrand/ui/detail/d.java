package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String appId;
  boolean isLoading = false;
  b lMf;
  private String lMg;
  int lMh = 0;
  final List<aog> lMi = new LinkedList();
  
  private static bcf aB(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      return null;
    }
    bcf localbcf = new bcf();
    try
    {
      localbcf.aH(paramArrayOfByte);
      y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      return localbcf;
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
    }
    return null;
  }
  
  private void tg(int paramInt)
  {
    new c(this.appId, this.lMg, paramInt).b(new d.1(this, paramInt));
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.lMf = null;
  }
  
  public final void te(int paramInt)
  {
    if (this.lMf == null)
    {
      y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      return;
    }
    if (paramInt < this.lMi.size())
    {
      y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lMi.size()) });
      return;
    }
    if (this.isLoading)
    {
      y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      return;
    }
    if (this.lMh == 0)
    {
      y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      return;
    }
    y.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    tg(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */