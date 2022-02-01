package com.tencent.mm.plugin.finder.nearby.person;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
final class b$v
  implements e.b
{
  public static final v zIl;
  
  static
  {
    AppMethodBeat.i(203121);
    zIl = new v();
    AppMethodBeat.o(203121);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(203120);
    Log.i("NearbyPersonUIC", "showLiveBottomSheet dismiss");
    AppMethodBeat.o(203120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.b.v
 * JD-Core Version:    0.7.0.1
 */