package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class b
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(107311);
    paramContext = new c(paramContext, paramb, paramInt);
    AppMethodBeat.o(107311);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 2147483647;
  }
  
  public final int getType()
  {
    return 4192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.b
 * JD-Core Version:    0.7.0.1
 */