package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.j;

public final class i
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(112141);
    paramContext = new j(paramContext, paramb, paramInt);
    AppMethodBeat.o(112141);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 2147483647;
  }
  
  public final int getType()
  {
    return 4176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.i
 * JD-Core Version:    0.7.0.1
 */