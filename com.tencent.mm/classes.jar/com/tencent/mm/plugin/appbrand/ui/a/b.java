package com.tencent.mm.plugin.appbrand.ui.a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a ugG;
  
  static
  {
    AppMethodBeat.i(180690);
    ugG = new a((byte)0);
    AppMethodBeat.o(180690);
  }
  
  public static final void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(180691);
    a.a(paramContext, paramOnClickListener1, paramOnClickListener2, paramOnCancelListener);
    AppMethodBeat.o(180691);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/WxaAuthorizeUIHelper$Companion;", "", "()V", "showCloseAuthorizeAlert", "", "cxt", "Landroid/content/Context;", "onPositiveClick", "Landroid/content/DialogInterface$OnClickListener;", "onNegativeCLick", "onCancelCLick", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(180689);
      s.u(paramContext, "cxt");
      s.u(paramOnClickListener1, "onPositiveClick");
      s.u(paramOnClickListener2, "onNegativeCLick");
      s.u(paramOnCancelListener, "onCancelCLick");
      e.a locala = new e.a(paramContext);
      locala.bDw(paramContext.getString(ba.i.app_brand_auth_close_tips));
      locala.bDC(paramContext.getString(ba.i.app_brand_auth_close_auth));
      locala.c(paramOnClickListener1);
      locala.bDD(paramContext.getString(ba.i.app_cancel));
      locala.d(paramOnClickListener2);
      locala.e(paramOnCancelListener);
      paramContext = locala.jHH();
      paramContext.setCanceledOnTouchOutside(false);
      paramContext.show();
      AppMethodBeat.o(180689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a.b
 * JD-Core Version:    0.7.0.1
 */