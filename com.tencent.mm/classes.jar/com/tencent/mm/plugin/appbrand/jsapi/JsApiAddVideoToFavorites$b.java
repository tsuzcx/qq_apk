package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.a.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class JsApiAddVideoToFavorites$b
  extends u
  implements a<ah>
{
  JsApiAddVideoToFavorites$b(int paramInt, Activity paramActivity)
  {
    super(0);
  }
  
  private static final void J(Activity paramActivity)
  {
    AppMethodBeat.i(325727);
    s.u(paramActivity, "$activity");
    b.I(paramActivity);
    AppMethodBeat.o(325727);
  }
  
  private static final void e(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(325724);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(325724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddVideoToFavorites.b
 * JD-Core Version:    0.7.0.1
 */