package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class d
  extends a
{
  public final com.tencent.mm.plugin.fts.a.d.e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(14092);
    paramContext = new e(paramContext, paramb, paramInt);
    AppMethodBeat.o(14092);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 96;
  }
  
  public final int getType()
  {
    return 96;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.d
 * JD-Core Version:    0.7.0.1
 */