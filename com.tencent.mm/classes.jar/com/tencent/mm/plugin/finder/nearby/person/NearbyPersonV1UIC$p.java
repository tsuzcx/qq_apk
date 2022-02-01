package com.tencent.mm.plugin.finder.nearby.person;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class NearbyPersonV1UIC$p
  implements DialogInterface.OnClickListener
{
  NearbyPersonV1UIC$p(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(249294);
    this.uST.invoke();
    AppMethodBeat.o(249294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.p
 * JD-Core Version:    0.7.0.1
 */