package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String appId;
  boolean isLoading;
  b vwp;
  private String vwq;
  int vwr;
  final List<bnr> vws;
  
  public d()
  {
    AppMethodBeat.i(64933);
    this.vwr = 0;
    this.isLoading = false;
    this.vws = new LinkedList();
    AppMethodBeat.o(64933);
  }
  
  private void JB(final int paramInt)
  {
    AppMethodBeat.i(64937);
    new c(this.appId, this.vwq, paramInt).b(new f() {});
    AppMethodBeat.o(64937);
  }
  
  private static cgz bq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64934);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ae.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(64934);
      return null;
    }
    cgz localcgz = new cgz();
    try
    {
      localcgz.parseFrom(paramArrayOfByte);
      ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(64934);
      return localcgz;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(64934);
    }
    return null;
  }
  
  public final void Jz(int paramInt)
  {
    AppMethodBeat.i(64936);
    if (this.vwp == null)
    {
      ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(64936);
      return;
    }
    if (paramInt < this.vws.size())
    {
      ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vws.size()) });
      AppMethodBeat.o(64936);
      return;
    }
    if (this.isLoading)
    {
      ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(64936);
      return;
    }
    if (this.vwr == 0)
    {
      ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(64936);
      return;
    }
    ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    JB(paramInt);
    AppMethodBeat.o(64936);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64935);
    ae.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.vwp = null;
    AppMethodBeat.o(64935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */