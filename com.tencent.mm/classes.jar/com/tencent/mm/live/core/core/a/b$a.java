package com.tencent.mm.live.core.core.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
public final class b$a
{
  public static boolean aiN()
  {
    AppMethodBeat.i(209130);
    if (b.aiM() != null)
    {
      AppMethodBeat.o(209130);
      return true;
    }
    AppMethodBeat.o(209130);
    return false;
  }
  
  public static b ct(Context paramContext)
  {
    AppMethodBeat.i(209129);
    k.h(paramContext, "context");
    if (b.aiM() == null) {
      b.d(new b(paramContext));
    }
    paramContext = b.aiM();
    if (paramContext == null) {
      k.fOy();
    }
    AppMethodBeat.o(209129);
    return paramContext;
  }
  
  public static void releaseInstance()
  {
    AppMethodBeat.i(209131);
    b localb = b.aiM();
    if (localb != null) {
      localb.release();
    }
    b.d(null);
    AppMethodBeat.o(209131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b.a
 * JD-Core Version:    0.7.0.1
 */