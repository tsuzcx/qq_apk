package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.xs;

public final class a
  extends c<xs>
{
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(270086);
    xr localxr = new xr();
    d.a locala = new d.a();
    locala.lBU = localxr;
    locala.lBV = new xs();
    locala.funcId = 4193;
    locala.uri = "/cgi-bin/micromsg-bin/checkandusetimelimitpromo";
    localxr.llH = paramString1;
    localxr.signature = paramString2;
    c(locala.bgN());
    AppMethodBeat.o(270086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a
 * JD-Core Version:    0.7.0.1
 */