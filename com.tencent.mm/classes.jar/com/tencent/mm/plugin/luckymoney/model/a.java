package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.wallet_core.model.z;

public final class a
  extends z<zn>
{
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(283910);
    zm localzm = new zm();
    c.a locala = new c.a();
    locala.otE = localzm;
    locala.otF = new zn();
    locala.funcId = 4193;
    locala.uri = "/cgi-bin/micromsg-bin/checkandusetimelimitpromo";
    localzm.nQE = paramString1;
    localzm.signature = paramString2;
    c(locala.bEF());
    AppMethodBeat.o(283910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a
 * JD-Core Version:    0.7.0.1
 */