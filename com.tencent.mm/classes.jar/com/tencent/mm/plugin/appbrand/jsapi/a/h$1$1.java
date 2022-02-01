package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import d.g.a.b;

final class h$1$1
  implements DialogInterface.OnClickListener
{
  h$1$1(h.1 param1, Context paramContext, b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46113);
    paramDialogInterface = new Intent(this.val$context, AppBrandRedirectUI.class);
    paramDialogInterface.putExtra("key_from_scene", 0);
    e.az(this.val$context).a(paramDialogInterface, new e.a()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46112);
        h.1.1.this.jrW.aA(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(46112);
      }
    });
    AppMethodBeat.o(46113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.h.1.1
 * JD-Core Version:    0.7.0.1
 */