package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper;", "", "()V", "Companion", "IPositivePerformer", "plugin-appbrand-integration_release"})
public final class h
{
  private static final String TAG = "MicroMsg.ReceiptQrCodeRiskInterceptionLogic";
  public static final h.a kBp;
  
  static
  {
    AppMethodBeat.i(223336);
    kBp = new h.a((byte)0);
    TAG = "MicroMsg.ReceiptQrCodeRiskInterceptionLogic";
    AppMethodBeat.o(223336);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, h.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool2 = true;
    AppMethodBeat.i(223337);
    p.h(paramContext, "context");
    p.h(paramString1, "content");
    p.h(paramString2, "positiveBtnText");
    p.h(paramString3, "negativeBtnText");
    p.h(paramb, "positivePerformer");
    paramContext = new f.a(paramContext);
    paramContext.aZq(paramString1);
    paramContext.aZu(paramString2);
    int i;
    if (((CharSequence)paramString3).length() > 0)
    {
      i = 1;
      if (i != 0) {
        paramContext.aZv(paramString3);
      }
      paramContext.a((f.c)h.a.a.kBq, (f.c)new h.a.b(paramb));
      paramContext.b(paramOnDismissListener);
      paramContext.show();
      paramString1 = paramContext.fQE();
      if (((CharSequence)paramString3).length() <= 0) {
        break label188;
      }
      bool1 = true;
      label140:
      paramString1.bu(-2, bool1);
      paramContext = paramContext.fQE();
      if (((CharSequence)paramString2).length() <= 0) {
        break label194;
      }
    }
    label188:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.bu(-1, bool1);
      AppMethodBeat.o(223337);
      return;
      i = 0;
      break;
      bool1 = false;
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */