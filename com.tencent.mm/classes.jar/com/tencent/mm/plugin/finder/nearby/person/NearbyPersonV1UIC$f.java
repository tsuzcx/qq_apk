package com.tencent.mm.plugin.finder.nearby.person;

import android.arch.lifecycle.ViewModelProvider;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC;
import com.tencent.mm.ui.component.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class NearbyPersonV1UIC$f
  implements DialogInterface.OnClickListener
{
  NearbyPersonV1UIC$f(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(249281);
    paramDialogInterface = a.PRN;
    ((NearbyHomeUIC)a.b(this.uSA.getActivity()).get(NearbyHomeUIC.class)).Jz(1001);
    AppMethodBeat.o(249281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.f
 * JD-Core Version:    0.7.0.1
 */