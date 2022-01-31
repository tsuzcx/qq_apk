package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pluginsdk.ui.tools.f;

public final class e
  extends f
{
  public e(int paramInt)
  {
    super(paramInt);
  }
  
  public final v i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74000);
    paramString1 = new d(paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(74000);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e
 * JD-Core Version:    0.7.0.1
 */