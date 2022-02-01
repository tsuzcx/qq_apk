package com.tencent.mm.plugin.finder.nearby.person;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class b$s
  implements q.f
{
  public static final s zIj;
  
  static
  {
    AppMethodBeat.i(202756);
    zIj = new s();
    AppMethodBeat.o(202756);
  }
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(202754);
    p.j(paramo, "it");
    if (paramo.hJO())
    {
      paramo.mn(1, f.h.nearby_person_female);
      paramo.mn(2, f.h.nearby_person_male);
      paramo.mn(3, f.h.nearby_person_all);
      paramo.mn(4, f.h.nearby_person_say_hi);
      paramo.mn(5, f.h.nearby_person_clear_location_exit);
    }
    Log.i("NearbyPersonUIC", "showLiveBottomSheet create menu.");
    AppMethodBeat.o(202754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.b.s
 * JD-Core Version:    0.7.0.1
 */