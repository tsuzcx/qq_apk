package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class g
  extends j<f>
{
  public static final String[] hGX;
  public static final String[] hGY;
  
  static
  {
    AppMethodBeat.i(76399);
    hGX = new String[] { j.getCreateSQLs(f.hGW, "DynamicMsgCacheData") };
    hGY = new String[0];
    AppMethodBeat.o(76399);
  }
  
  public g(e parame)
  {
    super(parame, f.hGW, "DynamicMsgCacheData", hGY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g
 * JD-Core Version:    0.7.0.1
 */