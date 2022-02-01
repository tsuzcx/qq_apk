package com.tencent.mm.plugin.appbrand.game.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.h.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class t$c
  implements DialogInterface.OnClickListener
{
  public static final c kos;
  
  static
  {
    AppMethodBeat.i(50394);
    kos = new c();
    AppMethodBeat.o(50394);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(50393);
    paramDialogInterface = a.krR;
    a.bin();
    a.suicide();
    AppMethodBeat.o(50393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.t.c
 * JD-Core Version:    0.7.0.1
 */