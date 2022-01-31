package com.tencent.mm.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class c
  extends j<b>
{
  public static final String[] fkl;
  public static final String[] fkm;
  
  static
  {
    AppMethodBeat.i(51124);
    fkl = new String[] { j.getCreateSQLs(b.fkk, "WxaUpdateableMsg") };
    fkm = new String[0];
    AppMethodBeat.o(51124);
  }
  
  public c(e parame)
  {
    super(parame, b.fkk, "WxaUpdateableMsg", fkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.af.a.c
 * JD-Core Version:    0.7.0.1
 */