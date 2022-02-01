package com.tencent.magicbrush;

import com.tencent.magicbrush.internal.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class e$a
{
  public static e b(f paramf)
  {
    AppMethodBeat.i(228740);
    s.t(paramf, "builder");
    if (!a.d(paramf))
    {
      AppMethodBeat.o(228740);
      return null;
    }
    paramf = new e(paramf, (byte)0);
    AppMethodBeat.o(228740);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.e.a
 * JD-Core Version:    0.7.0.1
 */