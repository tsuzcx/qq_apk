package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper;", "", "()V", "Companion", "IPositivePerformer", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a rEU;
  
  static
  {
    AppMethodBeat.i(326882);
    rEU = new a((byte)0);
    AppMethodBeat.o(326882);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, i.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(326881);
    a.a(paramContext, paramString1, paramString2, paramString3, paramb, paramOnDismissListener);
    AppMethodBeat.o(326881);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$Companion;", "", "()V", "TAG", "", "showDialog", "", "context", "Landroid/content/Context;", "content", "positiveBtnText", "negativeBtnText", "positivePerformer", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void E(boolean paramBoolean, String paramString) {}
    
    public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, i.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      boolean bool2 = true;
      AppMethodBeat.i(326733);
      s.u(paramContext, "context");
      s.u(paramString1, "content");
      s.u(paramString2, "positiveBtnText");
      s.u(paramString3, "negativeBtnText");
      s.u(paramb, "positivePerformer");
      paramContext = new g.a(paramContext);
      paramContext.bDE(paramString1);
      paramContext.bDI(paramString2);
      int i;
      if (((CharSequence)paramString3).length() > 0)
      {
        i = 1;
        if (i != 0) {
          paramContext.bDJ(paramString3);
        }
        paramContext.a(i.a..ExternalSyntheticLambda1.INSTANCE, new i.a..ExternalSyntheticLambda0(paramb));
        paramContext.d(paramOnDismissListener);
        paramContext.show();
        paramString1 = paramContext.pRv;
        if (((CharSequence)paramString3).length() <= 0) {
          break label182;
        }
        bool1 = true;
        label134:
        paramString1.cX(-2, bool1);
        paramContext = paramContext.pRv;
        if (((CharSequence)paramString2).length() <= 0) {
          break label188;
        }
      }
      label182:
      label188:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramContext.cX(-1, bool1);
        AppMethodBeat.o(326733);
        return;
        i = 0;
        break;
        bool1 = false;
        break label134;
      }
    }
    
    private static final void a(i.b paramb, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(326745);
      s.u(paramb, "$positivePerformer");
      paramb.perform();
      AppMethodBeat.o(326745);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.i
 * JD-Core Version:    0.7.0.1
 */