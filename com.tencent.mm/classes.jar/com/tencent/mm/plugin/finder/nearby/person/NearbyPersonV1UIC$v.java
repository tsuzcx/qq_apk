package com.tencent.mm.plugin.finder.nearby.person;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
final class NearbyPersonV1UIC$v
  implements e.b
{
  public static final v uSX;
  
  static
  {
    AppMethodBeat.i(249303);
    uSX = new v();
    AppMethodBeat.o(249303);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(249302);
    Log.i("NearbyPersonUIC", "showLiveBottomSheet dismiss");
    AppMethodBeat.o(249302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.v
 * JD-Core Version:    0.7.0.1
 */