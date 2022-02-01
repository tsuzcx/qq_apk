package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthRealNameProxyEmptyUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "", "()V", "perform", "", "Companion", "None", "OpenRealNameVerifyPage", "OpenUrl", "OpenWxa", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenRealNameVerifyPage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i$b
{
  public static final a rEV = new a((byte)0);
  
  public static final b a(Context paramContext, MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo)
  {
    s.u(paramContext, "context");
    s.u(paramMMAuthScopeRiskInfo, "info");
    if (paramMMAuthScopeRiskInfo.rGT != 0)
    {
      if (paramMMAuthScopeRiskInfo.rGT == 1) {}
      for (c localc = new c(paramContext); localc != null; localc = null) {
        return (b)localc;
      }
    }
    switch (paramMMAuthScopeRiskInfo.rGS)
    {
    }
    for (;;)
    {
      return (b)b.rEW;
      return (b)new d(paramContext, "");
      return (b)new d(paramContext, paramMMAuthScopeRiskInfo.rGV);
      paramMMAuthScopeRiskInfo = paramMMAuthScopeRiskInfo.rGW;
      if (paramMMAuthScopeRiskInfo == null) {}
      for (paramContext = null; paramContext != null; paramContext = new e(paramContext, paramMMAuthScopeRiskInfo.username, paramMMAuthScopeRiskInfo.type, paramMMAuthScopeRiskInfo.path, paramMMAuthScopeRiskInfo.scene, paramMMAuthScopeRiskInfo.version)) {
        return (b)paramContext;
      }
    }
  }
  
  public abstract void perform();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "()V", "perform", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends i.b
  {
    public static final b rEW;
    
    static
    {
      AppMethodBeat.i(326723);
      rEW = new b();
      AppMethodBeat.o(326723);
    }
    
    private b()
    {
      super();
    }
    
    public final void perform() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenRealNameVerifyPage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "perform", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends i.b
  {
    private final Context context;
    
    public c(Context paramContext)
    {
      super();
      AppMethodBeat.i(326720);
      this.context = paramContext;
      AppMethodBeat.o(326720);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(326728);
      Object localObject1;
      if ((BuildInfo.DEBUG) && (!(this.context instanceof Activity)))
      {
        localObject1 = (Throwable)new IllegalStateException("context must be Activity".toString());
        AppMethodBeat.o(326728);
        throw ((Throwable)localObject1);
      }
      if ((this.context instanceof Activity))
      {
        localObject1 = AppBrandAuthRealNameProxyEmptyUI.tXt;
        localObject1 = (Activity)this.context;
        s.u(localObject1, "context");
        Object localObject2 = new Intent((Context)localObject1, AppBrandAuthRealNameProxyEmptyUI.class);
        ((Intent)localObject2).putExtra("action", "startRealNameVerify");
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI$Companion", "startRealNameVerify", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI$Companion", "startRealNameVerify", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(326728);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "perform", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends i.b
  {
    private final Context context;
    private final String url;
    
    public d(Context paramContext, String paramString)
    {
      super();
      AppMethodBeat.i(326719);
      this.context = paramContext;
      this.url = paramString;
      AppMethodBeat.o(326719);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(326726);
      Context localContext = this.context;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.url);
      c.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent.putExtra("forceHideShare", true));
      AppMethodBeat.o(326726);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "userName", "", "versionType", "", "path", "scene", "version", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;II)V", "perform", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends i.b
  {
    private final Context context;
    private final int euz;
    private final String path;
    private final int scene;
    private final String userName;
    private final int version;
    
    public e(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      super();
      AppMethodBeat.i(326731);
      this.context = paramContext;
      this.userName = paramString1;
      this.euz = paramInt1;
      this.path = paramString2;
      this.scene = paramInt2;
      this.version = paramInt3;
      AppMethodBeat.o(326731);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(326739);
      g localg = new g();
      localg.username = this.userName;
      localg.qAF = this.path;
      localg.scene = this.scene;
      localg.euz = this.euz;
      localg.version = this.version;
      ((t)h.ax(t.class)).a(this.context, localg);
      AppMethodBeat.o(326739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.i.b
 * JD-Core Version:    0.7.0.1
 */