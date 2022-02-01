package com.tencent.mm.plugin.appbrand.ui.a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lEx;
  
  static
  {
    AppMethodBeat.i(180690);
    lEx = new a((byte)0);
    AppMethodBeat.o(180690);
  }
  
  public static final void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(180691);
    a.a(paramContext, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
    AppMethodBeat.o(180691);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper$Companion;", "", "()V", "showCloseAuthorizeAlert", "", "cxt", "Landroid/content/Context;", "onPositiveClick", "Landroid/content/DialogInterface$OnClickListener;", "onNegativeCLick", "onCancelCLick", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(180689);
      k.h(paramContext, "cxt");
      k.h(paramOnClickListener1, "onPositiveClick");
      k.h(paramOnClickListener2, "onNegativeCLick");
      k.h(paramOnCancelListener, "onCancelCLick");
      d.a locala = new d.a(paramContext);
      locala.aMg(paramContext.getString(2131755321));
      locala.aMm(paramContext.getString(2131755320));
      locala.b(paramOnClickListener1);
      locala.aMn(paramContext.getString(2131755691));
      locala.c(paramOnClickListener2);
      locala.e(paramOnCancelListener);
      paramContext = locala.fft();
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