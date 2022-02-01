package com.tencent.mm.plugin.fts.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.e.h;

public final class g
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(112139);
    paramContext = new h(paramContext, paramb, paramInt);
    AppMethodBeat.o(112139);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 64;
  }
  
  public final int getType()
  {
    return 4160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.g
 * JD-Core Version:    0.7.0.1
 */