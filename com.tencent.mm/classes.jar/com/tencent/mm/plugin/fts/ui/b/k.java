package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.m;

public final class k
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(62050);
    paramContext = new m(paramContext, paramb, paramInt);
    AppMethodBeat.o(62050);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 16;
  }
  
  public final int getType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.k
 * JD-Core Version:    0.7.0.1
 */