package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthRealNameProxyEmptyUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "", "()V", "perform", "", "Companion", "None", "OpenRealNameVerifyPage", "OpenUrl", "OpenWxa", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenRealNameVerifyPage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "plugin-appbrand-integration_release"})
public abstract class h$b
{
  public static final a oBk = new a((byte)0);
  
  public static final b a(Context paramContext, MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo)
  {
    p.k(paramContext, "context");
    p.k(paramMMAuthScopeRiskInfo, "info");
    if (paramMMAuthScopeRiskInfo.oDI != 0)
    {
      switch (paramMMAuthScopeRiskInfo.oDI)
      {
      }
      for (c localc = null; localc != null; localc = new c(paramContext)) {
        return (b)localc;
      }
    }
    switch (paramMMAuthScopeRiskInfo.oDH)
    {
    }
    do
    {
      return (b)b.oBl;
      return (b)new d(paramContext, "");
      return (b)new d(paramContext, paramMMAuthScopeRiskInfo.oDL);
      paramMMAuthScopeRiskInfo = paramMMAuthScopeRiskInfo.oDM;
    } while (paramMMAuthScopeRiskInfo == null);
    return (b)new e(paramContext, paramMMAuthScopeRiskInfo.username, paramMMAuthScopeRiskInfo.type, paramMMAuthScopeRiskInfo.path, paramMMAuthScopeRiskInfo.scene, paramMMAuthScopeRiskInfo.version);
  }
  
  public abstract void perform();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "()V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class b
    extends h.b
  {
    public static final b oBl;
    
    static
    {
      AppMethodBeat.i(280146);
      oBl = new b();
      AppMethodBeat.o(280146);
    }
    
    private b()
    {
      super();
    }
    
    public final void perform() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenRealNameVerifyPage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class c
    extends h.b
  {
    private final Context context;
    
    public c(Context paramContext)
    {
      super();
      AppMethodBeat.i(275048);
      this.context = paramContext;
      AppMethodBeat.o(275048);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(275047);
      Object localObject1;
      if ((BuildInfo.DEBUG) && (!(this.context instanceof Activity)))
      {
        localObject1 = (Throwable)new IllegalStateException("context must be Activity".toString());
        AppMethodBeat.o(275047);
        throw ((Throwable)localObject1);
      }
      if ((this.context instanceof Activity))
      {
        localObject1 = AppBrandAuthRealNameProxyEmptyUI.qSO;
        localObject1 = (Activity)this.context;
        p.k(localObject1, "context");
        Object localObject2 = new Intent((Context)localObject1, AppBrandAuthRealNameProxyEmptyUI.class);
        ((Intent)localObject2).putExtra("action", "startRealNameVerify");
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI$Companion", "startRealNameVerify", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI$Companion", "startRealNameVerify", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(275047);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class d
    extends h.b
  {
    private final Context context;
    private final String url;
    
    public d(Context paramContext, String paramString)
    {
      super();
      AppMethodBeat.i(272648);
      this.context = paramContext;
      this.url = paramString;
      AppMethodBeat.o(272648);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(272647);
      Context localContext = this.context;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.url);
      c.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent.putExtra("forceHideShare", true));
      AppMethodBeat.o(272647);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "userName", "", "versionType", "", "path", "scene", "version", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;II)V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class e
    extends h.b
  {
    private final int cBU;
    private final Context context;
    private final String path;
    private final int scene;
    private final String userName;
    private final int version;
    
    public e(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      super();
      AppMethodBeat.i(280732);
      this.context = paramContext;
      this.userName = paramString1;
      this.cBU = paramInt1;
      this.path = paramString2;
      this.scene = paramInt2;
      this.version = paramInt3;
      AppMethodBeat.o(280732);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(280731);
      g localg = new g();
      localg.username = this.userName;
      localg.nBq = this.path;
      localg.scene = this.scene;
      localg.cBU = this.cBU;
      localg.version = this.version;
      ((r)h.ae(r.class)).a(this.context, localg);
      AppMethodBeat.o(280731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h.b
 * JD-Core Version:    0.7.0.1
 */