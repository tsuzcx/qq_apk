package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String appId;
  boolean isLoading;
  b vkk;
  private String vkl;
  int vkm;
  final List<bmz> vkn;
  
  public d()
  {
    AppMethodBeat.i(64933);
    this.vkm = 0;
    this.isLoading = false;
    this.vkn = new LinkedList();
    AppMethodBeat.o(64933);
  }
  
  private void Jc(final int paramInt)
  {
    AppMethodBeat.i(64937);
    new c(this.appId, this.vkl, paramInt).b(new f() {});
    AppMethodBeat.o(64937);
  }
  
  private static cgf br(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64934);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(64934);
      return null;
    }
    cgf localcgf = new cgf();
    try
    {
      localcgf.parseFrom(paramArrayOfByte);
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(64934);
      return localcgf;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(64934);
    }
    return null;
  }
  
  public final void Ja(int paramInt)
  {
    AppMethodBeat.i(64936);
    if (this.vkk == null)
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(64936);
      return;
    }
    if (paramInt < this.vkn.size())
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vkn.size()) });
      AppMethodBeat.o(64936);
      return;
    }
    if (this.isLoading)
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(64936);
      return;
    }
    if (this.vkm == 0)
    {
      ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(64936);
      return;
    }
    ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    Jc(paramInt);
    AppMethodBeat.o(64936);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64935);
    ad.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.vkk = null;
    AppMethodBeat.o(64935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */