package com.tencent.mm.plugin.appbrand.ui.a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a mGS;
  
  static
  {
    AppMethodBeat.i(180690);
    mGS = new a((byte)0);
    AppMethodBeat.o(180690);
  }
  
  public static final void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(180691);
    a.a(paramContext, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
    AppMethodBeat.o(180691);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper$Companion;", "", "()V", "showCloseAuthorizeAlert", "", "cxt", "Landroid/content/Context;", "onPositiveClick", "Landroid/content/DialogInterface$OnClickListener;", "onNegativeCLick", "onCancelCLick", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(180689);
      p.h(paramContext, "cxt");
      p.h(paramOnClickListener1, "onPositiveClick");
      p.h(paramOnClickListener2, "onNegativeCLick");
      p.h(paramOnCancelListener, "onCancelCLick");
      d.a locala = new d.a(paramContext);
      locala.aXG(paramContext.getString(2131755321));
      locala.aXM(paramContext.getString(2131755320));
      locala.c(paramOnClickListener1);
      locala.aXN(paramContext.getString(2131755691));
      locala.d(paramOnClickListener2);
      locala.e(paramOnCancelListener);
      paramContext = locala.fMb();
      paramContext.setCanceledOnTouchOutside(false);
      paramContext.show();
      AppMethodBeat.o(180689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a.a
 * JD-Core Version:    0.7.0.1
 */