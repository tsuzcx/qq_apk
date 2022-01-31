package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(62040);
    paramContext = new com.tencent.mm.plugin.fts.ui.d.a(paramContext, paramb, paramInt);
    AppMethodBeat.o(62040);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 2147483647;
  }
  
  public final int getType()
  {
    return 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */