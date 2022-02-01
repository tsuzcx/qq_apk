package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class d
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(112136);
    paramContext = new com.tencent.mm.plugin.fts.ui.d.d(paramContext, paramb, paramInt);
    AppMethodBeat.o(112136);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 2147483647;
  }
  
  public final int getType()
  {
    return 4112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.d
 * JD-Core Version:    0.7.0.1
 */