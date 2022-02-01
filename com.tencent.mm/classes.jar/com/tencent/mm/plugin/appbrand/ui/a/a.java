package com.tencent.mm.plugin.appbrand.ui.a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a raP;
  
  static
  {
    AppMethodBeat.i(180690);
    raP = new a((byte)0);
    AppMethodBeat.o(180690);
  }
  
  public static final void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(180691);
    a.a(paramContext, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
    AppMethodBeat.o(180691);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper$Companion;", "", "()V", "showCloseAuthorizeAlert", "", "cxt", "Landroid/content/Context;", "onPositiveClick", "Landroid/content/DialogInterface$OnClickListener;", "onNegativeCLick", "onCancelCLick", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(180689);
      p.k(paramContext, "cxt");
      p.k(paramOnClickListener1, "onPositiveClick");
      p.k(paramOnClickListener2, "onNegativeCLick");
      p.k(paramOnCancelListener, "onCancelCLick");
      d.a locala = new d.a(paramContext);
      locala.bBd(paramContext.getString(au.i.app_brand_auth_close_tips));
      locala.bBj(paramContext.getString(au.i.app_brand_auth_close_auth));
      locala.c(paramOnClickListener1);
      locala.bBk(paramContext.getString(au.i.app_cancel));
      locala.d(paramOnClickListener2);
      locala.f(paramOnCancelListener);
      paramContext = locala.icu();
      paramContext.setCanceledOnTouchOutside(false);
      paramContext.show();
      AppMethodBeat.o(180689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a.a
 * JD-Core Version:    0.7.0.1
 */