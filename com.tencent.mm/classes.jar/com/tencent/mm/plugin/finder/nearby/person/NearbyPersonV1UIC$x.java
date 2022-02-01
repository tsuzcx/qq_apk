package com.tencent.mm.plugin.finder.nearby.person;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class NearbyPersonV1UIC$x
  implements DialogInterface.OnCancelListener
{
  NearbyPersonV1UIC$x(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(249305);
    g.azz().a((q)this.uSA.uRX);
    AppMethodBeat.o(249305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.x
 * JD-Core Version:    0.7.0.1
 */