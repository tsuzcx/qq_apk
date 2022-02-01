package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  b EuC;
  int EuD;
  final List<cih> EuE;
  private String appId;
  boolean isLoading;
  private String ybP;
  
  public d()
  {
    AppMethodBeat.i(64933);
    this.EuD = 0;
    this.isLoading = false;
    this.EuE = new LinkedList();
    AppMethodBeat.o(64933);
  }
  
  private void VM(final int paramInt)
  {
    AppMethodBeat.i(64937);
    new c(this.appId, this.ybP, paramInt).b(new f() {});
    AppMethodBeat.o(64937);
  }
  
  private static dgq bW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64934);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(64934);
      return null;
    }
    dgq localdgq = new dgq();
    try
    {
      localdgq.parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(64934);
      return localdgq;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(64934);
    }
    return null;
  }
  
  public final void VK(int paramInt)
  {
    AppMethodBeat.i(64936);
    if (this.EuC == null)
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(64936);
      return;
    }
    if (paramInt < this.EuE.size())
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.EuE.size()) });
      AppMethodBeat.o(64936);
      return;
    }
    if (this.isLoading)
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(64936);
      return;
    }
    if (this.EuD == 0)
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(64936);
      return;
    }
    Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    VM(paramInt);
    AppMethodBeat.o(64936);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64935);
    Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.EuC = null;
    AppMethodBeat.o(64935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */