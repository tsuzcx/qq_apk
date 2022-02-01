package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.protocal.protobuf.xm;

public final class a
  extends c<xm>
{
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213301);
    xl localxl = new xl();
    d.a locala = new d.a();
    locala.iLN = localxl;
    locala.iLO = new xm();
    locala.funcId = 4193;
    locala.uri = "/cgi-bin/micromsg-bin/checkandusetimelimitpromo";
    localxl.iwu = paramString1;
    localxl.signature = paramString2;
    c(locala.aXF());
    AppMethodBeat.o(213301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a
 * JD-Core Version:    0.7.0.1
 */