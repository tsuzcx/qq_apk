package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  private static final a iBZ;
  private static final a iCa;
  private static final a iCb;
  private static final a iCc;
  private static final a iCd;
  public final String bjm;
  public final int ret;
  
  static
  {
    AppMethodBeat.i(102284);
    iBZ = new a(-1, "fail:auth canceled");
    iCa = new a(-1, "fail:auth denied");
    iCb = new a(-2, "");
    iCc = new a(-1, "fail:access denied");
    iCd = new a(0, "");
    AppMethodBeat.o(102284);
  }
  
  public e$a(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.bjm = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.e.a
 * JD-Core Version:    0.7.0.1
 */