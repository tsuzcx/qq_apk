package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import kotlin.g.a.b;

final class j$1$1
  implements DialogInterface.OnClickListener
{
  j$1$1(j.1 param1, Context paramContext, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46113);
    paramDialogInterface = new Intent(this.val$context, AppBrandRedirectUI.class);
    paramDialogInterface.putExtra("key_from_scene", 0);
    f.aI(this.val$context).a(paramDialogInterface, new f.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46112);
        j.1.1.this.ooA.invoke(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(46112);
      }
    });
    AppMethodBeat.o(46113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.j.1.1
 * JD-Core Version:    0.7.0.1
 */