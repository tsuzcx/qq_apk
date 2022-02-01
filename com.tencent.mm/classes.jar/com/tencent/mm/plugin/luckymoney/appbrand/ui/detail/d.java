package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String appId;
  boolean isLoading;
  b sZm;
  private String sZn;
  int sZo;
  final List<bez> sZp;
  
  public d()
  {
    AppMethodBeat.i(64933);
    this.sZo = 0;
    this.isLoading = false;
    this.sZp = new LinkedList();
    AppMethodBeat.o(64933);
  }
  
  private void FL(final int paramInt)
  {
    AppMethodBeat.i(64937);
    new c(this.appId, this.sZn, paramInt).b(new f() {});
    AppMethodBeat.o(64937);
  }
  
  private static bwu bp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64934);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(64934);
      return null;
    }
    bwu localbwu = new bwu();
    try
    {
      localbwu.parseFrom(paramArrayOfByte);
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(64934);
      return localbwu;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(64934);
    }
    return null;
  }
  
  public final void FJ(int paramInt)
  {
    AppMethodBeat.i(64936);
    if (this.sZm == null)
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(64936);
      return;
    }
    if (paramInt < this.sZp.size())
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sZp.size()) });
      AppMethodBeat.o(64936);
      return;
    }
    if (this.isLoading)
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(64936);
      return;
    }
    if (this.sZo == 0)
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(64936);
      return;
    }
    ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    FL(paramInt);
    AppMethodBeat.o(64936);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64935);
    ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.sZm = null;
    AppMethodBeat.o(64935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */