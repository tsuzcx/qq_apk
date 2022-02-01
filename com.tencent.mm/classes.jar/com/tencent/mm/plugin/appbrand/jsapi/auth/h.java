package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper;", "", "()V", "Companion", "IPositivePerformer", "plugin-appbrand-integration_release"})
public final class h
{
  public static final a oBh;
  
  static
  {
    AppMethodBeat.i(269450);
    oBh = new a((byte)0);
    AppMethodBeat.o(269450);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, h.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool2 = true;
    AppMethodBeat.i(269451);
    p.k(paramContext, "context");
    p.k(paramString1, "content");
    p.k(paramString2, "positiveBtnText");
    p.k(paramString3, "negativeBtnText");
    p.k(paramb, "positivePerformer");
    paramContext = new f.a(paramContext);
    paramContext.bBl(paramString1);
    paramContext.bBp(paramString2);
    int i;
    if (((CharSequence)paramString3).length() > 0)
    {
      i = 1;
      if (i != 0) {
        paramContext.bBq(paramString3);
      }
      paramContext.a((f.c)h.a.a.oBi, (f.c)new h.a.b(paramb));
      paramContext.b(paramOnDismissListener);
      paramContext.show();
      paramString1 = paramContext.icE();
      if (((CharSequence)paramString3).length() <= 0) {
        break label188;
      }
      bool1 = true;
      label140:
      paramString1.cg(-2, bool1);
      paramContext = paramContext.icE();
      if (((CharSequence)paramString2).length() <= 0) {
        break label194;
      }
    }
    label188:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.cg(-1, bool1);
      AppMethodBeat.o(269451);
      return;
      i = 0;
      break;
      bool1 = false;
      break label140;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$Companion;", "", "()V", "TAG", "", "showDialog", "", "context", "Landroid/content/Context;", "content", "positiveBtnText", "negativeBtnText", "positivePerformer", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */