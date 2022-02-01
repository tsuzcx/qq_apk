package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "", "()V", "perform", "", "Companion", "None", "OpenUrl", "OpenWxa", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "plugin-appbrand-integration_release"})
public abstract class h$b
{
  public static final a kBs = new a((byte)0);
  
  public static final b a(Context paramContext, MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo)
  {
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramMMAuthScopeRiskInfo, "info");
    switch (paramMMAuthScopeRiskInfo.kCY)
    {
    }
    do
    {
      return (b)b.kBt;
      return (b)new c(paramContext, "");
      return (b)new c(paramContext, paramMMAuthScopeRiskInfo.kDb);
      paramMMAuthScopeRiskInfo = paramMMAuthScopeRiskInfo.kDc;
    } while (paramMMAuthScopeRiskInfo == null);
    return (b)new d(paramContext, paramMMAuthScopeRiskInfo.username, paramMMAuthScopeRiskInfo.type, paramMMAuthScopeRiskInfo.path, paramMMAuthScopeRiskInfo.scene, paramMMAuthScopeRiskInfo.version);
  }
  
  public abstract void perform();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "()V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class b
    extends h.b
  {
    public static final b kBt;
    
    static
    {
      AppMethodBeat.i(223331);
      kBt = new b();
      AppMethodBeat.o(223331);
    }
    
    private b()
    {
      super();
    }
    
    public final void perform() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class c
    extends h.b
  {
    private final Context context;
    private final String url;
    
    public c(Context paramContext, String paramString)
    {
      super();
      AppMethodBeat.i(223333);
      this.context = paramContext;
      this.url = paramString;
      AppMethodBeat.o(223333);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(223332);
      Context localContext = this.context;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.url);
      d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent.putExtra("forceHideShare", true));
      AppMethodBeat.o(223332);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "userName", "", "versionType", "", "path", "scene", "version", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;II)V", "perform", "", "plugin-appbrand-integration_release"})
  public static final class d
    extends h.b
  {
    private final Context context;
    private final int hSZ;
    private final String path;
    private final int scene;
    private final String userName;
    private final int version;
    
    public d(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
    {
      super();
      AppMethodBeat.i(223335);
      this.context = paramContext;
      this.userName = paramString1;
      this.hSZ = paramInt1;
      this.path = paramString2;
      this.scene = paramInt2;
      this.version = paramInt3;
      AppMethodBeat.o(223335);
    }
    
    public final void perform()
    {
      AppMethodBeat.i(223334);
      f localf = new f();
      localf.username = this.userName;
      localf.jFL = this.path;
      localf.scene = this.scene;
      localf.hSZ = this.hSZ;
      localf.version = this.version;
      ((com.tencent.mm.plugin.appbrand.service.p)g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(this.context, localf);
      AppMethodBeat.o(223334);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.h.b
 * JD-Core Version:    0.7.0.1
 */