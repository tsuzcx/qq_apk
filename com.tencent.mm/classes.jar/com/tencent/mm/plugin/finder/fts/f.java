package com.tencent.mm.plugin.finder.fts;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class f
  extends a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(330970);
    paramContext = new g(paramContext, paramb, paramInt);
    AppMethodBeat.o(330970);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 97;
  }
  
  public final int getType()
  {
    return 133;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.f
 * JD-Core Version:    0.7.0.1
 */