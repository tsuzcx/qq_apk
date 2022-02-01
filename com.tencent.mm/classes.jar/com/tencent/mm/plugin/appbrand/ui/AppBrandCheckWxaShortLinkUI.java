package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.of;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "isTimeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "timeOutChecker", "Ljava/lang/Runnable;", "cancelTimeoutChecking", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "parseLinkAndLaunch", "url", "", "scene", "Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "ui", "Ljava/lang/ref/WeakReference;", "chatType", "parseLinkAndLaunchNoCheck", "reportForDialogWxaTag", "actionType", "shortLinkInfo", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "showProgressDialog", "startCheckTimeout", "toCgiScene", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandCheckWxaShortLinkUI
  extends MMActivity
{
  public static final AppBrandCheckWxaShortLinkUI.a qTS;
  private HashMap _$_findViewCache;
  private Runnable fgj;
  private AtomicBoolean fgl;
  private s iYE;
  
  static
  {
    AppMethodBeat.i(267892);
    qTS = new AppBrandCheckWxaShortLinkUI.a((byte)0);
    AppMethodBeat.o(267892);
  }
  
  public AppBrandCheckWxaShortLinkUI()
  {
    AppMethodBeat.i(267891);
    this.fgl = new AtomicBoolean(false);
    AppMethodBeat.o(267891);
  }
  
  public static a.b a(t.b paramb)
  {
    AppMethodBeat.i(267889);
    p.k(paramb, "$this$toCgiScene");
    switch (c.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramb = (Throwable)new Error(paramb.name() + " can not convert into CgiCheckWxaShortLink.TYPE");
        AppMethodBeat.o(267889);
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
      paramb = a.b.qQt;
      AppMethodBeat.o(267889);
      return paramb;
    case 12: 
      paramb = a.b.qQv;
      AppMethodBeat.o(267889);
      return paramb;
    }
    paramb = a.b.qQs;
    AppMethodBeat.o(267889);
    return paramb;
  }
  
  public static final void a(Context paramContext, String paramString, t.b paramb, int paramInt)
  {
    AppMethodBeat.i(267896);
    p.k(paramContext, "context");
    p.k(paramString, "url");
    p.k(paramb, "scene");
    if (!n.ba((CharSequence)paramString))
    {
      Intent localIntent = new Intent(paramContext, AppBrandCheckWxaShortLinkUI.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("scene", paramb.name());
      localIntent.putExtra("need_check", true);
      localIntent.putExtra("chatType", paramInt);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(267896);
  }
  
  public static final void a(Context paramContext, String paramString, t.b paramb, WxaShortLinkInfo paramWxaShortLinkInfo, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(267897);
    p.k(paramContext, "context");
    p.k(paramString, "url");
    p.k(paramb, "scene");
    p.k(paramWxaShortLinkInfo, "shortLinkInfo");
    p.k(paramHashMap, "map");
    Intent localIntent;
    if (!n.ba((CharSequence)paramString))
    {
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "startCheckLink noneedcheck");
      localIntent = new Intent(paramContext, AppBrandCheckWxaShortLinkUI.class);
      localIntent.addFlags(536870912);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("scene", paramb.name());
      localIntent.putExtra("need_check", false);
      localIntent.putExtra("shortLinkInfo", (Parcelable)paramWxaShortLinkInfo);
      localIntent.putExtra("requestId", (String)paramHashMap.get("requestId"));
      localIntent.putExtra("message", (String)paramHashMap.get("message"));
      localIntent.putExtra("prescene_for_report", (String)paramHashMap.get("prescene_for_report"));
      localIntent.putExtra("scene_for_report", (String)paramHashMap.get("scene_for_report"));
      localIntent.putExtra("presceneNote_for_report", (String)paramHashMap.get("presceneNote_for_report"));
      paramString = (String)paramHashMap.get("chatType");
      if (paramString == null) {
        break label315;
      }
    }
    label315:
    for (int i = Integer.parseInt(paramString);; i = -1)
    {
      localIntent.putExtra("chatType", i);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;ZLcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;Ljava/util/HashMap;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;ZLcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;Ljava/util/HashMap;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(267897);
      return;
    }
  }
  
  private final void cjw()
  {
    AppMethodBeat.i(267883);
    Runnable localRunnable = this.fgj;
    if (localRunnable != null)
    {
      MMHandlerThread.removeRunnable(localRunnable);
      AppMethodBeat.o(267883);
      return;
    }
    AppMethodBeat.o(267883);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(267895);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(267895);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(267894);
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
    AppMethodBeat.o(267894);
    return localView1;
  }
  
  public final void a(int paramInt, WxaShortLinkInfo paramWxaShortLinkInfo)
  {
    AppMethodBeat.i(267884);
    p.k(paramWxaShortLinkInfo, "shortLinkInfo");
    of localof = new of();
    localof.od(paramInt);
    localof.Fd(paramWxaShortLinkInfo.appId);
    localof.Fc(getIntent().getStringExtra("message"));
    localof.Fb(getIntent().getStringExtra("requestId"));
    paramWxaShortLinkInfo = getIntent().getStringExtra("scene_for_report");
    try
    {
      localof.oc(Integer.parseInt(paramWxaShortLinkInfo));
      label85:
      localof.aoe();
      localof.bpa();
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "reportForDialogWxaTag toShowString = " + localof.agI());
      AppMethodBeat.o(267884);
      return;
    }
    catch (Exception paramWxaShortLinkInfo)
    {
      break label85;
    }
  }
  
  public int getLayoutId()
  {
    return au.g.activity_app_brand_check_short_link_ui;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(267882);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    paramBundle = getIntent();
    label53:
    Object localObject2;
    label77:
    final int i;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringExtra("url");
      localObject1 = getIntent();
      if (localObject1 == null) {
        break label186;
      }
      localObject1 = ((Intent)localObject1).getStringExtra("scene");
      localObject2 = getIntent();
      if (localObject2 == null) {
        break label192;
      }
      localObject2 = Boolean.valueOf(((Intent)localObject2).getBooleanExtra("need_check", true));
      localObject3 = getIntent();
      if (localObject3 == null) {
        break label198;
      }
      i = ((Intent)localObject3).getIntExtra("chatType", -1);
      label97:
      localObject3 = (CharSequence)paramBundle;
      if ((localObject3 != null) && (!n.ba((CharSequence)localObject3))) {
        break label203;
      }
      j = 1;
      label118:
      if (j == 0)
      {
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label208;
        }
      }
    }
    label186:
    label192:
    label198:
    label203:
    label208:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        break label213;
      }
      setResult(-1, new Intent());
      finish();
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "url empty or invalid scene, finish");
      AppMethodBeat.o(267882);
      return;
      paramBundle = null;
      break;
      localObject1 = null;
      break label53;
      localObject2 = null;
      break label77;
      i = -1;
      break label97;
      j = 0;
      break label118;
    }
    label213:
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "start check short link");
    Object localObject3 = new WeakReference(this);
    Object localObject1 = t.b.valueOf((String)localObject1);
    if (p.h(localObject2, Boolean.TRUE))
    {
      this.fgj = ((Runnable)new f(this, (WeakReference)localObject3));
      MMHandlerThread.postToMainThreadDelayed(this.fgj, 10000L);
      localObject2 = this.iYE;
      if (localObject2 != null) {
        ((s)localObject2).dismiss();
      }
      this.iYE = s.a((Context)getContext(), (CharSequence)getString(au.i.app_waiting), true, 3, null);
      localObject2 = this.iYE;
      if (localObject2 != null) {
        ((s)localObject2).setCancelable(false);
      }
      new b(this, (t.b)localObject1, i, (WeakReference)localObject3).b((Activity)this, paramBundle, (kotlin.g.a.b)new c((WeakReference)localObject3));
      AppMethodBeat.o(267882);
      return;
    }
    new d(this, (WxaShortLinkInfo)getIntent().getParcelableExtra("shortLinkInfo"), i, (t.b)localObject1, paramBundle).c((Activity)this, paramBundle, (kotlin.g.a.b)new e((WeakReference)localObject3));
    AppMethodBeat.o(267882);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(267888);
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "onDestroy");
    cjw();
    s locals = this.iYE;
    if (locals != null) {
      locals.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(267888);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(267886);
    super.onResume();
    x.e(getWindow());
    x.d(getWindow(), false);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    AppMethodBeat.o(267886);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$parseLinkAndLaunch$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "launch", "", "ctx", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onLinkDecodeDone", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class b
    extends AbsWxaShortLinkLauncher
  {
    b(t.b paramb, int paramInt, WeakReference paramWeakReference) {}
    
    public final void a(Context paramContext, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
    {
      AppMethodBeat.i(271704);
      p.k(paramContext, "ctx");
      p.k(paramWxaShortLinkLaunchParams, "params");
      p.k(paramb, "launchResultCallback");
      g localg = new g();
      localg.appId = paramWxaShortLinkLaunchParams.appId;
      localg.nBq = paramWxaShortLinkLaunchParams.path;
      localg.version = paramWxaShortLinkLaunchParams.version;
      localg.cBU = paramWxaShortLinkLaunchParams.cBU;
      localg.nBJ = paramWxaShortLinkLaunchParams.nBJ;
      localg.scene = this.qTU.Rtz;
      localg.nBt = this.qTU.RtA;
      localg.nBt = this.qTU.RtA;
      localg.chatType = i;
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "launchWxa  appId=" + localg.appId + " \nenterPath=" + localg.nBq + " \nversion=" + localg.version + " \nversionType=" + localg.cBU + " \nshortLink=" + localg.nBJ + " \nscene=" + localg.scene + " \nprescene=" + localg.nBt + '\n');
      ((r)h.ae(r.class)).a(paramContext, localg);
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(271704);
    }
    
    public final boolean a(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(271706);
      p.k(paramActivity, "ctx");
      super.a(paramActivity, paramBoolean);
      Object localObject = (AppBrandCheckWxaShortLinkUI)this.qTW.get();
      if (localObject == null)
      {
        AppMethodBeat.o(271706);
        return false;
      }
      if (AppBrandCheckWxaShortLinkUI.a((AppBrandCheckWxaShortLinkUI)localObject).get())
      {
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  callback , timeout, ignore cgi result");
        AppMethodBeat.o(271706);
        return false;
      }
      AppBrandCheckWxaShortLinkUI.b(this.qTT);
      localObject = AppBrandCheckWxaShortLinkUI.c(this.qTT);
      if (localObject != null) {
        ((s)localObject).dismiss();
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  CGI fail , go to fail H5 page");
        localObject = new Intent();
        af localaf = af.aaBG;
        paramActivity = String.format("https://mp.weixin.qq.com/mp/waerrpage?appid=wx40f8626ddf43d362&type=tips&title=%s&msg=%s#wechat_redirect", Arrays.copyOf(new Object[] { com.tencent.mm.compatible.util.q.an(paramActivity.getString(au.i.appbrand_shortlink_parse_fail_webview_title), "UTF-8"), com.tencent.mm.compatible.util.q.an(paramActivity.getString(au.i.appbrand_shortlink_parse_fail_webview_msg), "UTF-8") }, 2));
        p.j(paramActivity, "java.lang.String.format(format, *args)");
        ((Intent)localObject).putExtra("rawUrl", paramActivity);
        ((Intent)localObject).putExtra("forceHideShare", true);
        c.b((Context)this.qTT.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
      AppMethodBeat.o(271706);
      return true;
    }
    
    public final a.b ciE()
    {
      AppMethodBeat.i(271705);
      a.b localb = AppBrandCheckWxaShortLinkUI.a(this.qTU);
      AppMethodBeat.o(271705);
      return localb;
    }
    
    public final com.tencent.mm.plugin.appbrand.shortlink.a ciF()
    {
      return (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.qQj;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<WxaShortLinkLaunchErrorCode, kotlin.x>
  {
    c(WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$parseLinkAndLaunchNoCheck$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "launch", "", "ctx", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onLaunchDone", "Landroid/app/Activity;", "url", "", "onLinkDecodeDone", "onUserCancel", "plugin-appbrand-integration_release"})
  public static final class d
    extends AbsWxaShortLinkLauncher
  {
    d(WxaShortLinkInfo paramWxaShortLinkInfo, int paramInt, t.b paramb, String paramString)
    {
      AppMethodBeat.i(247872);
      if (paramInt != null)
      {
        paramWxaShortLinkInfo = (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.qQj;
        if (paramWxaShortLinkInfo != null)
        {
          paramWxaShortLinkInfo.a(str, paramInt);
          AppMethodBeat.o(247872);
          return;
        }
      }
      AppMethodBeat.o(247872);
    }
    
    public final void a(Context paramContext, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
    {
      AppMethodBeat.i(247864);
      p.k(paramContext, "ctx");
      p.k(paramWxaShortLinkLaunchParams, "params");
      p.k(paramb, "launchResultCallback");
      Object localObject = this.qTT.getIntent().getStringExtra("prescene_for_report");
      String str1 = this.qTT.getIntent().getStringExtra("message");
      String str2 = this.qTT.getIntent().getStringExtra("presceneNote_for_report");
      int i = 0;
      try
      {
        int j = Integer.parseInt((String)localObject);
        i = j;
      }
      catch (Exception localException)
      {
        label79:
        break label79;
      }
      localObject = new g();
      ((g)localObject).appId = paramWxaShortLinkLaunchParams.appId;
      ((g)localObject).nBq = paramWxaShortLinkLaunchParams.path;
      ((g)localObject).version = paramWxaShortLinkLaunchParams.version;
      ((g)localObject).cBU = paramWxaShortLinkLaunchParams.cBU;
      ((g)localObject).nBJ = paramWxaShortLinkLaunchParams.nBJ;
      ((g)localObject).scene = 1179;
      ((g)localObject).nBt = i;
      ((g)localObject).fvd = str1;
      ((g)localObject).nBu = str2;
      ((g)localObject).chatType = i;
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "launchWxa  appId=" + ((g)localObject).appId + " \nenterPath=" + ((g)localObject).nBq + " \nversion=" + ((g)localObject).version + " \nversionType=" + ((g)localObject).cBU + " \nshortLink=" + ((g)localObject).nBJ + " \nscene=" + ((g)localObject).scene + " \nsceneNote=" + ((g)localObject).fvd + " \npresceneNote=" + ((g)localObject).nBu + " \nprescene=" + i + '\n');
      ((r)h.ae(r.class)).a(paramContext, (g)localObject);
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(247864);
    }
    
    public final boolean a(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(247869);
      p.k(paramActivity, "ctx");
      AppMethodBeat.o(247869);
      return true;
    }
    
    public final void b(Activity paramActivity, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(247855);
      p.k(paramActivity, "ctx");
      p.k(paramString, "url");
      super.b(paramActivity, paramString, paramBoolean);
      paramActivity = this.qTT;
      paramString = this.qTX;
      p.j(paramString, "shortLinkInfo");
      paramActivity.a(1, paramString);
      AppMethodBeat.o(247855);
    }
    
    public final a.b ciE()
    {
      AppMethodBeat.i(247866);
      a.b localb = AppBrandCheckWxaShortLinkUI.a(this.qTU);
      AppMethodBeat.o(247866);
      return localb;
    }
    
    public final com.tencent.mm.plugin.appbrand.shortlink.a ciF()
    {
      return (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.qQj;
    }
    
    public final void f(Activity paramActivity, String paramString)
    {
      AppMethodBeat.i(247859);
      p.k(paramActivity, "ctx");
      p.k(paramString, "url");
      super.f(paramActivity, paramString);
      paramActivity = this.qTT;
      paramString = this.qTX;
      p.j(paramString, "shortLinkInfo");
      paramActivity.a(2, paramString);
      AppMethodBeat.o(247859);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<WxaShortLinkLaunchErrorCode, kotlin.x>
  {
    e(WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(AppBrandCheckWxaShortLinkUI paramAppBrandCheckWxaShortLinkUI, WeakReference paramWeakReference) {}
    
    public final void run()
    {
      AppMethodBeat.i(263965);
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "check short link timeout");
      AppBrandCheckWxaShortLinkUI.a(this.qTT).set(true);
      w.makeText((Context)this.qTT, (CharSequence)this.qTT.getContext().getString(au.i.appbrand_shortlink_parse_time_out_msg), 1).show();
      AppBrandCheckWxaShortLinkUI localAppBrandCheckWxaShortLinkUI = (AppBrandCheckWxaShortLinkUI)this.qTW.get();
      if (localAppBrandCheckWxaShortLinkUI != null)
      {
        localAppBrandCheckWxaShortLinkUI.finish();
        AppMethodBeat.o(263965);
        return;
      }
      AppMethodBeat.o(263965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI
 * JD-Core Version:    0.7.0.1
 */