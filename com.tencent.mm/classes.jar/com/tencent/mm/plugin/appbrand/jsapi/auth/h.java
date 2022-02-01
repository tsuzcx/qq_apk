package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper;", "", "()V", "Companion", "IPositivePerformer", "plugin-appbrand-integration_release"})
public final class h
{
  private static final String TAG = "MicroMsg.ReceiptQrCodeRiskInterceptionLogic";
  public static final a lFG;
  
  static
  {
    AppMethodBeat.i(228309);
    lFG = new a((byte)0);
    TAG = "MicroMsg.ReceiptQrCodeRiskInterceptionLogic";
    AppMethodBeat.o(228309);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool2 = true;
    AppMethodBeat.i(228310);
    p.h(paramContext, "context");
    p.h(paramString1, "content");
    p.h(paramString2, "positiveBtnText");
    p.h(paramString3, "negativeBtnText");
    p.h(paramb, "positivePerformer");
    paramContext = new f.a(paramContext);
    paramContext.bow(paramString1);
    paramContext.boA(paramString2);
    int i;
    if (((CharSequence)paramString3).length() > 0)
    {
      i = 1;
      if (i != 0) {
        paramContext.boB(paramString3);
      }
      paramContext.a((f.c)h.a.a.lFH, (f.c)new h.a.b(paramb));
      paramContext.b(paramOnDismissListener);
      paramContext.show();
      paramString1 = paramContext.hbv();
      if (((CharSequence)paramString3).length() <= 0) {
        break label188;
      }
      bool1 = true;
      label140:
      paramString1.bT(-2, bool1);
      paramContext = paramContext.hbv();
      if (((CharSequence)paramString2).length() <= 0) {
        break label194;
      }
    }
    label188:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.bT(-1, bool1);
      AppMethodBeat.o(228310);
      return;
      i = 0;
      break;
      bool1 = false;
      break label140;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "showDialog", "", "context", "Landroid/content/Context;", "content", "positiveBtnText", "negativeBtnText", "positivePerformer", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b
      implements f.c
    {
      b(h.b paramb) {}
      
      public final void e(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(228303);
        this.lFI.perform();
        AppMethodBeat.o(228303);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "", "()V", "perform", "", "Companion", "None", "OpenUrl", "OpenWxa", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "plugin-appbrand-integration_release"})
  public static abstract class b
  {
    public static final a lFJ = new a((byte)0);
    
    public static final b a(Context paramContext, MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo)
    {
      p.h(paramContext, "context");
      p.h(paramMMAuthScopeRiskInfo, "info");
      switch (paramMMAuthScopeRiskInfo.lHz)
      {
      }
      do
      {
        return (b)b.lFK;
        return (b)new c(paramContext, "");
        return (b)new c(paramContext, paramMMAuthScopeRiskInfo.lHC);
        paramMMAuthScopeRiskInfo = paramMMAuthScopeRiskInfo.lHD;
      } while (paramMMAuthScopeRiskInfo == null);
      return (b)new d(paramContext, paramMMAuthScopeRiskInfo.username, paramMMAuthScopeRiskInfo.type, paramMMAuthScopeRiskInfo.path, paramMMAuthScopeRiskInfo.scene, paramMMAuthScopeRiskInfo.version);
    }
    
    public abstract void perform();
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "()V", "perform", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends h.b
    {
      public static final b lFK;
      
      static
      {
        AppMethodBeat.i(228304);
        lFK = new b();
        AppMethodBeat.o(228304);
      }
      
      private b()
      {
        super();
      }
      
      public final void perform() {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "perform", "", "plugin-appbrand-integration_release"})
    public static final class c
      extends h.b
    {
      private final Context context;
      private final String url;
      
      public c(Context paramContext, String paramString)
      {
        super();
        AppMethodBeat.i(228306);
        this.context = paramContext;
        this.url = paramString;
        AppMethodBeat.o(228306);
      }
      
      public final void perform()
      {
        AppMethodBeat.i(228305);
        Context localContext = this.context;
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", this.url);
        c.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent.putExtra("forceHideShare", true));
        AppMethodBeat.o(228305);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "userName", "", "versionType", "", "path", "scene", "version", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;II)V", "perform", "", "plugin-appbrand-integration_release"})
    public static final class d
      extends h.b
    {
      private final Context context;
      private final int iOo;
      private final String path;
      private final int scene;
      private final String userName;
      private final int version;
      
      public d(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
      {
        super();
        AppMethodBeat.i(228308);
        this.context = paramContext;
        this.userName = paramString1;
        this.iOo = paramInt1;
        this.path = paramString2;
        this.scene = paramInt2;
        this.version = paramInt3;
        AppMethodBeat.o(228308);
      }
      
      public final void perform()
      {
        AppMethodBeat.i(228307);
        com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
        localg.username = this.userName;
        localg.kHw = this.path;
        localg.scene = this.scene;
        localg.iOo = this.iOo;
        localg.version = this.version;
        ((r)com.tencent.mm.kernel.g.af(r.class)).a(this.context, localg);
        AppMethodBeat.o(228307);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */