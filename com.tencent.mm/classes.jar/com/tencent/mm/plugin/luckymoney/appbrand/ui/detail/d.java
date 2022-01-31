package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements a
{
  private String appId;
  boolean isLoading;
  private String ojA;
  int ojB;
  final List<aty> ojC;
  b ojz;
  
  public d()
  {
    AppMethodBeat.i(42042);
    this.ojB = 0;
    this.isLoading = false;
    this.ojC = new LinkedList();
    AppMethodBeat.o(42042);
  }
  
  private static bji aZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42043);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
      AppMethodBeat.o(42043);
      return null;
    }
    bji localbji = new bji();
    try
    {
      localbji.parseFrom(paramArrayOfByte);
      ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
      AppMethodBeat.o(42043);
      return localbji;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", new Object[] { paramArrayOfByte });
      AppMethodBeat.o(42043);
    }
    return null;
  }
  
  private void yi(int paramInt)
  {
    AppMethodBeat.i(42046);
    new c(this.appId, this.ojA, paramInt).b(new d.1(this, paramInt));
    AppMethodBeat.o(42046);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(42044);
    ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
    this.ojz = null;
    AppMethodBeat.o(42044);
  }
  
  public final void yg(int paramInt)
  {
    AppMethodBeat.i(42045);
    if (this.ojz == null)
    {
      ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
      AppMethodBeat.o(42045);
      return;
    }
    if (paramInt < this.ojC.size())
    {
      ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ojC.size()) });
      AppMethodBeat.o(42045);
      return;
    }
    if (this.isLoading)
    {
      ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
      AppMethodBeat.o(42045);
      return;
    }
    if (this.ojB == 0)
    {
      ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
      AppMethodBeat.o(42045);
      return;
    }
    ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
    this.isLoading = true;
    yi(paramInt);
    AppMethodBeat.o(42045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d
 * JD-Core Version:    0.7.0.1
 */