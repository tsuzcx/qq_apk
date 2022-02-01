package com.tencent.mm.plugin.finder.nearby.person;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class NearbyPersonV1UIC$s
  implements o.f
{
  public static final s uSV;
  
  static
  {
    AppMethodBeat.i(249298);
    uSV = new s();
    AppMethodBeat.o(249298);
  }
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(249297);
    p.g(paramm, "it");
    if (paramm.gKQ())
    {
      paramm.kV(1, 2131763481);
      paramm.kV(2, 2131763482);
      paramm.kV(3, 2131763478);
      paramm.kV(4, 2131763483);
      paramm.kV(5, 2131763480);
    }
    Log.i("NearbyPersonUIC", "showLiveBottomSheet create menu.");
    AppMethodBeat.o(249297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.s
 * JD-Core Version:    0.7.0.1
 */