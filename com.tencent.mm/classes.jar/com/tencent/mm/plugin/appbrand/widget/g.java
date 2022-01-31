package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class g
  extends j<f>
{
  public static final String[] fkl;
  public static final String[] fkm;
  
  static
  {
    AppMethodBeat.i(70650);
    fkl = new String[] { j.getCreateSQLs(f.fkk, "DynamicMsgCacheData") };
    fkm = new String[0];
    AppMethodBeat.o(70650);
  }
  
  public g(e parame)
  {
    super(parame, f.fkk, "DynamicMsgCacheData", fkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g
 * JD-Core Version:    0.7.0.1
 */