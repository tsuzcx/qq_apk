package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String appId;
  boolean isLoading;
  b uhA;
  private String uhB;
  int uhC;
  final List<bir> uhD;
  
  public d()
  {
    AppMethodBeat.i(64933);
    this.uhC = 0;
    this.isLoading = false;
    this.uhD = new LinkedList();
    AppMethodBeat.o(64933);
  }
  
  private void HG(final int paramInt)
  {
    AppMethodBeat.i(64937);
    new c(this.appId, this.uhB, paramInt).b(new f() {});
    AppMethodBeat.o(64937);
  }
  
  private static cbo bo(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64934);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ac.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(64934);
      return null;
    }
    cbo localcbo = new cbo();
    try
    {
      localcbo.parseFrom(paramArrayOfByte);
      ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(64934);
      return localcbo;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(64934);
    }
    return null;
  }
  
  public final void HE(int paramInt)
  {
    AppMethodBeat.i(64936);
    if (this.uhA == null)
    {
      ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(64936);
      return;
    }
    if (paramInt < this.uhD.size())
    {
      ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uhD.size()) });
      AppMethodBeat.o(64936);
      return;
    }
    if (this.isLoading)
    {
      ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(64936);
      return;
    }
    if (this.uhC == 0)
    {
      ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(64936);
      return;
    }
    ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    HG(paramInt);
    AppMethodBeat.o(64936);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64935);
    ac.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.uhA = null;
    AppMethodBeat.o(64935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */