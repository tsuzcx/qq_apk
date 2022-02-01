package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper;", "", "()V", "Companion", "IPositivePerformer", "plugin-appbrand-integration_release"})
public final class h
{
  private static final String TAG = "MicroMsg.ReceiptQrCodeRiskInterceptionLogic";
  public static final a kya;
  
  static
  {
    AppMethodBeat.i(189077);
    kya = new a((byte)0);
    TAG = "MicroMsg.ReceiptQrCodeRiskInterceptionLogic";
    AppMethodBeat.o(189077);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool2 = true;
    AppMethodBeat.i(189078);
    p.h(paramContext, "context");
    p.h(paramString1, "content");
    p.h(paramString2, "positiveBtnText");
    p.h(paramString3, "negativeBtnText");
    p.h(paramb, "positivePerformer");
    paramContext = new f.a(paramContext);
    paramContext.aXO(paramString1);
    paramContext.aXS(paramString2);
    int i;
    if (((CharSequence)paramString3).length() > 0)
    {
      i = 1;
      if (i != 0) {
        paramContext.aXT(paramString3);
      }
      paramContext.a((f.c)h.a.a.kyb, (f.c)new h.a.b(paramb));
      paramContext.b(paramOnDismissListener);
      paramContext.show();
      paramString1 = paramContext.fMk();
      if (((CharSequence)paramString3).length() <= 0) {
        break label188;
      }
      bool1 = true;
      label140:
      paramString1.bl(-2, bool1);
      paramContext = paramContext.fMk();
      if (((CharSequence)paramString2).length() <= 0) {
        break label194;
      }
    }
    label188:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.bl(-1, bool1);
      AppMethodBeat.o(189078);
      return;
      i = 0;
      break;
      bool1 = false;
      break label140;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "showDialog", "", "context", "Landroid/content/Context;", "content", "positiveBtnText", "negativeBtnText", "positivePerformer", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class b
      implements f.c
    {
      b(h.b paramb) {}
      
      public final void d(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(189071);
        this.kyc.perform();
        AppMethodBeat.o(189071);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "", "()V", "perform", "", "Companion", "None", "OpenUrl", "OpenWxa", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "plugin-appbrand-integration_release"})
  public static abstract class b
  {
    public static final a kyd = new a((byte)0);
    
    public static final b a(Context paramContext, MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo)
    {
      p.h(paramContext, "context");
      p.h(paramMMAuthScopeRiskInfo, "info");
      switch (paramMMAuthScopeRiskInfo.kzJ)
      {
      }
      do
      {
        return (b)b.kye;
        return (b)new c(paramContext, "");
        return (b)new c(paramContext, paramMMAuthScopeRiskInfo.kzM);
        paramMMAuthScopeRiskInfo = paramMMAuthScopeRiskInfo.kzN;
      } while (paramMMAuthScopeRiskInfo == null);
      return (b)new d(paramContext, paramMMAuthScopeRiskInfo.username, paramMMAuthScopeRiskInfo.type, paramMMAuthScopeRiskInfo.path, paramMMAuthScopeRiskInfo.scene, paramMMAuthScopeRiskInfo.version);
    }
    
    public abstract void perform();
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "()V", "perform", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends h.b
    {
      public static final b kye;
      
      static
      {
        AppMethodBeat.i(189072);
        kye = new b();
        AppMethodBeat.o(189072);
      }
      
      private b()
      {
        super();
      }
      
      public final void perform() {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "perform", "", "plugin-appbrand-integration_release"})
    public static final class c
      extends h.b
    {
      private final Context context;
      private final String url;
      
      public c(Context paramContext, String paramString)
      {
        super();
        AppMethodBeat.i(189074);
        this.context = paramContext;
        this.url = paramString;
        AppMethodBeat.o(189074);
      }
      
      public final void perform()
      {
        AppMethodBeat.i(189073);
        Context localContext = this.context;
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", this.url);
        com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent.putExtra("forceHideShare", true));
        AppMethodBeat.o(189073);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "userName", "", "versionType", "", "path", "scene", "version", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;II)V", "perform", "", "plugin-appbrand-integration_release"})
    public static final class d
      extends h.b
    {
      private final Context context;
      private final int hQh;
      private final String path;
      private final int scene;
      private final String userName;
      private final int version;
      
      public d(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
      {
        super();
        AppMethodBeat.i(189076);
        this.context = paramContext;
        this.userName = paramString1;
        this.hQh = paramInt1;
        this.path = paramString2;
        this.scene = paramInt2;
        this.version = paramInt3;
        AppMethodBeat.o(189076);
      }
      
      public final void perform()
      {
        AppMethodBeat.i(189075);
        f localf = new f();
        localf.username = this.userName;
        localf.jCN = this.path;
        localf.scene = this.scene;
        localf.hQh = this.hQh;
        localf.version = this.version;
        ((o)g.ab(o.class)).a(this.context, localf);
        AppMethodBeat.o(189075);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */