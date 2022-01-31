package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class d
  extends a
{
  public final com.tencent.mm.plugin.fts.a.d.e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(130083);
    paramContext = new e(paramContext, paramb, paramInt);
    AppMethodBeat.o(130083);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 2147483647;
  }
  
  public final int getType()
  {
    return 4240;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.d
 * JD-Core Version:    0.7.0.1
 */