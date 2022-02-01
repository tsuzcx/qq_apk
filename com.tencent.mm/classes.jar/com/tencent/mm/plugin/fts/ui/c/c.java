package com.tencent.mm.plugin.fts.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class c
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(112135);
    paramContext = new com.tencent.mm.plugin.fts.ui.e.c(paramContext, paramb, paramInt);
    AppMethodBeat.o(112135);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 48;
  }
  
  public final int getType()
  {
    return 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.c
 * JD-Core Version:    0.7.0.1
 */