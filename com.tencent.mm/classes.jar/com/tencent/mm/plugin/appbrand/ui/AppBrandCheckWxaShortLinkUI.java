package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "isTimeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "timeOutChecker", "Ljava/lang/Runnable;", "cancelTimeoutChecking", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "parseLinkAndLaunch", "url", "", "scene", "Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "ui", "Ljava/lang/ref/WeakReference;", "showProgressDialog", "startCheckTimeout", "toCgiScene", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandCheckWxaShortLinkUI
  extends MMActivity
{
  public static final a nSr;
  private HashMap _$_findViewCache;
  private com.tencent.mm.ui.base.q gut;
  private Runnable nSp;
  private AtomicBoolean nSq;
  
  static
  {
    AppMethodBeat.i(229468);
    nSr = new a((byte)0);
    AppMethodBeat.o(229468);
  }
  
  public AppBrandCheckWxaShortLinkUI()
  {
    AppMethodBeat.i(229467);
    this.nSq = new AtomicBoolean(false);
    AppMethodBeat.o(229467);
  }
  
  public static a.b a(t.b paramb)
  {
    AppMethodBeat.i(229466);
    p.h(paramb, "$this$toCgiScene");
    switch (e.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramb = (Throwable)new Error(paramb.name() + " can not convert into CgiCheckWxaShortLink.TYPE");
        AppMethodBeat.o(229466);
        throw paramb;
      }
      break;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      paramb = a.b.nNX;
      AppMethodBeat.o(229466);
      return paramb;
    case 12: 
      paramb = a.b.nNZ;
      AppMethodBeat.o(229466);
      return paramb;
    }
    paramb = a.b.nNW;
    AppMethodBeat.o(229466);
    return paramb;
  }
  
  public static final void a(Context paramContext, String paramString, t.b paramb)
  {
    AppMethodBeat.i(229472);
    p.h(paramContext, "context");
    p.h(paramString, "url");
    p.h(paramb, "scene");
    if (!n.aL((CharSequence)paramString))
    {
      Intent localIntent = new Intent(paramContext, AppBrandCheckWxaShortLinkUI.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("scene", paramb.name());
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(229472);
  }
  
  private final void bWS()
  {
    AppMethodBeat.i(229463);
    Runnable localRunnable = this.nSp;
    if (localRunnable != null)
    {
      MMHandlerThread.removeRunnable(localRunnable);
      AppMethodBeat.o(229463);
      return;
    }
    AppMethodBeat.o(229463);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229471);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229471);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229470);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(229470);
    return localView1;
  }
  
  public int getLayoutId()
  {
    return 2131492951;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(229462);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringExtra("url");
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label138;
      }
      localObject1 = ((Intent)localObject1).getStringExtra("scene");
      label49:
      localObject2 = (CharSequence)paramBundle;
      if ((localObject2 != null) && (!n.aL((CharSequence)localObject2))) {
        break label143;
      }
      i = 1;
      label70:
      if (i == 0)
      {
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label148;
        }
      }
    }
    label138:
    label143:
    label148:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label153;
      }
      setResult(-1, new Intent());
      finish();
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "url empty or invalid scene, finish");
      AppMethodBeat.o(229462);
      return;
      paramBundle = null;
      break;
      localObject1 = null;
      break label49;
      i = 0;
      break label70;
    }
    label153:
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "start check short link");
    Object localObject2 = new WeakReference(this);
    Object localObject1 = t.b.valueOf((String)localObject1);
    this.nSp = ((Runnable)new d(this, (WeakReference)localObject2));
    MMHandlerThread.postToMainThreadDelayed(this.nSp, 10000L);
    com.tencent.mm.ui.base.q localq = this.gut;
    if (localq != null) {
      localq.dismiss();
    }
    this.gut = com.tencent.mm.ui.base.q.a((Context)getContext(), (CharSequence)getString(2131756029), true, 3, null);
    localq = this.gut;
    if (localq != null) {
      localq.setCancelable(false);
    }
    new b(this, (t.b)localObject1, (WeakReference)localObject2).a((Activity)this, paramBundle, (kotlin.g.a.b)new c((WeakReference)localObject2));
    AppMethodBeat.o(229462);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(229465);
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "onDestroy");
    bWS();
    com.tencent.mm.ui.base.q localq = this.gut;
    if (localq != null) {
      localq.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(229465);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(229464);
    super.onResume();
    y.e(getWindow());
    y.d(getWindow(), false);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    AppMethodBeat.o(229464);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion;", "", "()V", "CHECK_RESULT_TIMEOUT_MILL_SECOND", "", "KEY_SCENE", "", "KEY_URL", "PARSE_FAIL_TIP_URL", "TAG", "startCheckLink", "", "context", "Landroid/content/Context;", "url", "scene", "Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$parseLinkAndLaunch$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "launch", "", "ctx", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onLinkDecodeDone", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class b
    extends AbsWxaShortLinkLauncher
  {
    b(t.b paramb, WeakReference paramWeakReference) {}
    
    public final void a(Context paramContext, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, x> paramb)
    {
      AppMethodBeat.i(229457);
      p.h(paramContext, "ctx");
      p.h(paramWxaShortLinkLaunchParams, "params");
      p.h(paramb, "launchResultCallback");
      com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
      localg.appId = paramWxaShortLinkLaunchParams.appId;
      localg.kHw = paramWxaShortLinkLaunchParams.path;
      localg.version = paramWxaShortLinkLaunchParams.version;
      localg.iOo = paramWxaShortLinkLaunchParams.iOo;
      localg.kHQ = paramWxaShortLinkLaunchParams.kHQ;
      localg.scene = this.nSt.Kss;
      localg.kHz = this.nSt.Kst;
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "launchWxa  appId=" + localg.appId + " \nenterPath=" + localg.kHw + " \nversion=" + localg.version + " \nversionType=" + localg.iOo + " \nshortLink=" + localg.kHQ + " \nscene=" + localg.scene + " \nprescene=" + localg.kHz + '\n');
      ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, localg);
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(229457);
    }
    
    public final boolean a(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(229459);
      p.h(paramActivity, "ctx");
      super.a(paramActivity, paramBoolean);
      Object localObject = (AppBrandCheckWxaShortLinkUI)this.nSu.get();
      if (localObject == null)
      {
        AppMethodBeat.o(229459);
        return false;
      }
      if (AppBrandCheckWxaShortLinkUI.a((AppBrandCheckWxaShortLinkUI)localObject).get())
      {
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  callback , timeout, ignore cgi result");
        AppMethodBeat.o(229459);
        return false;
      }
      AppBrandCheckWxaShortLinkUI.b(this.nSs);
      localObject = AppBrandCheckWxaShortLinkUI.c(this.nSs);
      if (localObject != null) {
        ((com.tencent.mm.ui.base.q)localObject).dismiss();
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  CGI fail , go to fail H5 page");
        localObject = new Intent();
        ae localae = ae.SYK;
        paramActivity = String.format("https://mp.weixin.qq.com/mp/waerrpage?appid=wx40f8626ddf43d362&type=tips&title=%s&msg=%s#wechat_redirect", Arrays.copyOf(new Object[] { com.tencent.mm.compatible.util.q.encode(paramActivity.getString(2131756176), "UTF-8"), com.tencent.mm.compatible.util.q.encode(paramActivity.getString(2131756175), "UTF-8") }, 2));
        p.g(paramActivity, "java.lang.String.format(format, *args)");
        ((Intent)localObject).putExtra("rawUrl", paramActivity);
        ((Intent)localObject).putExtra("forceHideShare", true);
        c.b((Context)this.nSs.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
      AppMethodBeat.o(229459);
      return true;
    }
    
    public final a.b bVx()
    {
      AppMethodBeat.i(229458);
      a.b localb = AppBrandCheckWxaShortLinkUI.a(this.nSt);
      AppMethodBeat.o(229458);
      return localb;
    }
    
    public final com.tencent.mm.plugin.appbrand.shortlink.a bVy()
    {
      return (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.nNN;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<WxaShortLinkLaunchErrorCode, x>
  {
    c(WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(AppBrandCheckWxaShortLinkUI paramAppBrandCheckWxaShortLinkUI, WeakReference paramWeakReference) {}
    
    public final void run()
    {
      AppMethodBeat.i(229461);
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "check short link timeout");
      AppBrandCheckWxaShortLinkUI.a(this.nSs).set(true);
      u.makeText((Context)this.nSs, (CharSequence)this.nSs.getContext().getString(2131756177), 1).show();
      AppBrandCheckWxaShortLinkUI localAppBrandCheckWxaShortLinkUI = (AppBrandCheckWxaShortLinkUI)this.nSu.get();
      if (localAppBrandCheckWxaShortLinkUI != null)
      {
        localAppBrandCheckWxaShortLinkUI.finish();
        AppMethodBeat.o(229461);
        return;
      }
      AppMethodBeat.o(229461);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI
 * JD-Core Version:    0.7.0.1
 */