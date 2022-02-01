package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.ela;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String CAf;
  b Knj;
  int Knk;
  final List<cyk> Knl;
  private String appId;
  boolean isLoading;
  
  public d()
  {
    AppMethodBeat.i(64933);
    this.Knk = 0;
    this.isLoading = false;
    this.Knl = new LinkedList();
    AppMethodBeat.o(64933);
  }
  
  private void ZI(final int paramInt)
  {
    AppMethodBeat.i(64937);
    new c(this.appId, this.CAf, paramInt).b(new f() {});
    AppMethodBeat.o(64937);
  }
  
  private static dyx bY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64934);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(64934);
      return null;
    }
    dyx localdyx = new dyx();
    try
    {
      localdyx.parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(64934);
      return localdyx;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(64934);
    }
    return null;
  }
  
  public final void ZG(int paramInt)
  {
    AppMethodBeat.i(64936);
    if (this.Knj == null)
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(64936);
      return;
    }
    if (paramInt < this.Knl.size())
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Knl.size()) });
      AppMethodBeat.o(64936);
      return;
    }
    if (this.isLoading)
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(64936);
      return;
    }
    if (this.Knk == 0)
    {
      Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(64936);
      return;
    }
    Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    ZI(paramInt);
    AppMethodBeat.o(64936);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64935);
    Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.Knj = null;
    AppMethodBeat.o(64935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */