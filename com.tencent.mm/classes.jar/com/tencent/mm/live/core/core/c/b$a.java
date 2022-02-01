package com.tencent.mm.live.core.core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
public final class b$a
{
  public static boolean aiN()
  {
    AppMethodBeat.i(209197);
    if (b.ajw() != null)
    {
      AppMethodBeat.o(209197);
      return true;
    }
    AppMethodBeat.o(209197);
    return false;
  }
  
  public static b cu(Context paramContext)
  {
    AppMethodBeat.i(209196);
    k.h(paramContext, "context");
    if (b.ajw() == null) {
      b.e(new b(paramContext));
    }
    paramContext = b.ajw();
    if (paramContext == null) {
      k.fOy();
    }
    AppMethodBeat.o(209196);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b.a
 * JD-Core Version:    0.7.0.1
 */