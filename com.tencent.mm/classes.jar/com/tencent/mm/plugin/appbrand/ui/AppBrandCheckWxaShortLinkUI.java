package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rx;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "isTimeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "timeOutChecker", "Ljava/lang/Runnable;", "cancelTimeoutChecking", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "parseLinkAndLaunch", "url", "", "scene", "Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "ui", "Ljava/lang/ref/WeakReference;", "chatType", "parseLinkAndLaunchNoCheck", "reportForDialogWxaTag", "actionType", "shortLinkInfo", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "showProgressDialog", "startCheckTimeout", "toCgiScene", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class AppBrandCheckWxaShortLinkUI
  extends MMActivity
{
  public static final AppBrandCheckWxaShortLinkUI.a tYS;
  private Runnable hkt;
  private AtomicBoolean hkv;
  private w psR;
  
  static
  {
    AppMethodBeat.i(321998);
    tYS = new AppBrandCheckWxaShortLinkUI.a((byte)0);
    AppMethodBeat.o(321998);
  }
  
  public AppBrandCheckWxaShortLinkUI()
  {
    AppMethodBeat.i(321971);
    this.hkv = new AtomicBoolean(false);
    AppMethodBeat.o(321971);
  }
  
  public static a.b a(x.b paramb)
  {
    AppMethodBeat.i(321978);
    s.u(paramb, "<this>");
    switch (AppBrandCheckWxaShortLinkUI.b.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      if (BuildInfo.IS_FLAVOR_RED)
      {
        paramb = new Error(s.X(paramb.name(), " can not convert into CgiCheckWxaShortLink.TYPE"));
        AppMethodBeat.o(321978);
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
      paramb = a.b.tVf;
      AppMethodBeat.o(321978);
      return paramb;
    case 12: 
      paramb = a.b.tVh;
      AppMethodBeat.o(321978);
      return paramb;
    }
    paramb = a.b.tVe;
    AppMethodBeat.o(321978);
    return paramb;
  }
  
  public static final void a(Context paramContext, String paramString, x.b paramb, int paramInt)
  {
    AppMethodBeat.i(321989);
    s.u(paramContext, "context");
    s.u(paramString, "url");
    s.u(paramb, "scene");
    if (!n.bp((CharSequence)paramString))
    {
      Intent localIntent = new Intent(paramContext, AppBrandCheckWxaShortLinkUI.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("scene", paramb.name());
      localIntent.putExtra("need_check", true);
      localIntent.putExtra("chatType", paramInt);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(321989);
  }
  
  public static final void a(Context paramContext, String paramString, x.b paramb, WxaShortLinkInfo paramWxaShortLinkInfo, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(321993);
    s.u(paramContext, "context");
    s.u(paramString, "url");
    s.u(paramb, "scene");
    s.u(paramWxaShortLinkInfo, "shortLinkInfo");
    s.u(paramHashMap, "map");
    Intent localIntent;
    if (!n.bp((CharSequence)paramString))
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
      if (paramString != null) {
        break label312;
      }
    }
    label312:
    for (int i = -1;; i = Integer.parseInt(paramString))
    {
      localIntent.putExtra("chatType", i);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;ZLcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;Ljava/util/HashMap;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;ZLcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;Ljava/util/HashMap;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(321993);
      return;
    }
  }
  
  private static final void a(AppBrandCheckWxaShortLinkUI paramAppBrandCheckWxaShortLinkUI, WeakReference paramWeakReference)
  {
    AppMethodBeat.i(321982);
    s.u(paramAppBrandCheckWxaShortLinkUI, "this$0");
    s.u(paramWeakReference, "$ui");
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "check short link timeout");
    paramAppBrandCheckWxaShortLinkUI.hkv.set(true);
    aa.makeText((Context)paramAppBrandCheckWxaShortLinkUI, (CharSequence)paramAppBrandCheckWxaShortLinkUI.getContext().getString(ba.i.appbrand_shortlink_parse_time_out_msg), 1).show();
    paramAppBrandCheckWxaShortLinkUI = (AppBrandCheckWxaShortLinkUI)paramWeakReference.get();
    if (paramAppBrandCheckWxaShortLinkUI != null) {
      paramAppBrandCheckWxaShortLinkUI.finish();
    }
    AppMethodBeat.o(321982);
  }
  
  private final void cKH()
  {
    AppMethodBeat.i(321974);
    Runnable localRunnable = this.hkt;
    if (localRunnable != null) {
      MMHandlerThread.removeRunnable(localRunnable);
    }
    AppMethodBeat.o(321974);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final void a(int paramInt, WxaShortLinkInfo paramWxaShortLinkInfo)
  {
    AppMethodBeat.i(322014);
    s.u(paramWxaShortLinkInfo, "shortLinkInfo");
    rx localrx = new rx();
    localrx.jwU = paramInt;
    localrx.ipx = localrx.F("appid", paramWxaShortLinkInfo.appId, true);
    localrx.jwT = localrx.F("message", getIntent().getStringExtra("message"), true);
    localrx.jwS = localrx.F("requestid", getIntent().getStringExtra("requestId"), true);
    paramWxaShortLinkInfo = getIntent().getStringExtra("scene_for_report");
    try
    {
      localrx.iuF = Integer.parseInt(paramWxaShortLinkInfo);
      label104:
      localrx.jwV = 1;
      localrx.bMH();
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", s.X("reportForDialogWxaTag toShowString = ", localrx.aIF()));
      AppMethodBeat.o(322014);
      return;
    }
    catch (Exception paramWxaShortLinkInfo)
    {
      break label104;
    }
  }
  
  public int getLayoutId()
  {
    return ba.g.activity_app_brand_check_short_link_ui;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(322010);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    paramBundle = getIntent();
    label42:
    Object localObject2;
    label56:
    final int i;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject1 = getIntent();
      if (localObject1 != null) {
        break label163;
      }
      localObject1 = null;
      localObject2 = getIntent();
      if (localObject2 != null) {
        break label175;
      }
      localObject2 = null;
      localObject3 = getIntent();
      if (localObject3 != null) {
        break label191;
      }
      i = -1;
      label69:
      localObject3 = (CharSequence)paramBundle;
      if ((localObject3 != null) && (!n.bp((CharSequence)localObject3))) {
        break label203;
      }
      j = 1;
      label90:
      if (j == 0)
      {
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label208;
        }
      }
    }
    label163:
    label175:
    label191:
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
      AppMethodBeat.o(322010);
      return;
      paramBundle = paramBundle.getStringExtra("url");
      break;
      localObject1 = ((Intent)localObject1).getStringExtra("scene");
      break label42;
      localObject2 = Boolean.valueOf(((Intent)localObject2).getBooleanExtra("need_check", true));
      break label56;
      i = ((Intent)localObject3).getIntExtra("chatType", -1);
      break label69;
      j = 0;
      break label90;
    }
    label213:
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "start check short link");
    Object localObject3 = new WeakReference(this);
    Object localObject1 = x.b.valueOf((String)localObject1);
    if (s.p(localObject2, Boolean.TRUE))
    {
      this.hkt = new AppBrandCheckWxaShortLinkUI..ExternalSyntheticLambda0(this, (WeakReference)localObject3);
      MMHandlerThread.postToMainThreadDelayed(this.hkt, 10000L);
      localObject2 = this.psR;
      if (localObject2 != null) {
        ((w)localObject2).dismiss();
      }
      this.psR = w.a((Context)getContext(), (CharSequence)getString(ba.i.app_waiting), true, 3, null);
      localObject2 = this.psR;
      if (localObject2 != null) {
        ((w)localObject2).setCancelable(false);
      }
      new c((x.b)localObject1, i, this, (WeakReference)localObject3).b((Activity)this, paramBundle, (kotlin.g.a.b)new d((WeakReference)localObject3));
      AppMethodBeat.o(322010);
      return;
    }
    new e((WxaShortLinkInfo)getIntent().getParcelableExtra("shortLinkInfo"), paramBundle, this, i, (x.b)localObject1).c((Activity)this, paramBundle, (kotlin.g.a.b)new f((WeakReference)localObject3));
    AppMethodBeat.o(322010);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(322023);
    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "onDestroy");
    cKH();
    w localw = this.psR;
    if (localw != null) {
      localw.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(322023);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(322021);
    super.onResume();
    ae.g(getWindow());
    ae.c(getWindow(), false);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    AppMethodBeat.o(322021);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$parseLinkAndLaunch$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "launch", "", "ctx", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onLinkDecodeDone", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AbsWxaShortLinkLauncher
  {
    c(x.b paramb, int paramInt, AppBrandCheckWxaShortLinkUI paramAppBrandCheckWxaShortLinkUI, WeakReference<AppBrandCheckWxaShortLinkUI> paramWeakReference) {}
    
    public final void a(Context paramContext, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      AppMethodBeat.i(321911);
      s.u(paramContext, "ctx");
      s.u(paramWxaShortLinkLaunchParams, "params");
      s.u(paramb, "launchResultCallback");
      g localg = new g();
      x.b localb = this.tYT;
      int i = i;
      localg.appId = paramWxaShortLinkLaunchParams.appId;
      localg.qAF = paramWxaShortLinkLaunchParams.path;
      localg.version = paramWxaShortLinkLaunchParams.version;
      localg.euz = paramWxaShortLinkLaunchParams.euz;
      localg.qAX = paramWxaShortLinkLaunchParams.qAX;
      localg.scene = localb.CKA;
      localg.qAI = localb.YpH;
      localg.qAI = localb.YpH;
      localg.chatType = i;
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "launchWxa  appId=" + localg.appId + " \nenterPath=" + localg.qAF + " \nversion=" + localg.version + " \nversionType=" + localg.euz + " \nshortLink=" + localg.qAX + " \nscene=" + localg.scene + " \nprescene=" + localg.qAI + '\n');
      ((t)h.ax(t.class)).a(paramContext, localg);
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(321911);
    }
    
    public final boolean a(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(321915);
      s.u(paramActivity, "ctx");
      super.a(paramActivity, paramBoolean);
      Object localObject = (AppBrandCheckWxaShortLinkUI)this.tYW.get();
      if (localObject == null)
      {
        AppMethodBeat.o(321915);
        return false;
      }
      if (AppBrandCheckWxaShortLinkUI.a((AppBrandCheckWxaShortLinkUI)localObject).get())
      {
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  callback , timeout, ignore cgi result");
        AppMethodBeat.o(321915);
        return false;
      }
      AppBrandCheckWxaShortLinkUI.b(jdField_this);
      localObject = AppBrandCheckWxaShortLinkUI.c(jdField_this);
      if (localObject != null) {
        ((w)localObject).dismiss();
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  CGI fail , go to fail H5 page");
        localObject = new Intent();
        am localam = am.aixg;
        paramActivity = String.format("https://mp.weixin.qq.com/mp/waerrpage?appid=wx40f8626ddf43d362&type=tips&title=%s&msg=%s#wechat_redirect", Arrays.copyOf(new Object[] { r.as(paramActivity.getString(ba.i.appbrand_shortlink_parse_fail_webview_title), "UTF-8"), r.as(paramActivity.getString(ba.i.appbrand_shortlink_parse_fail_webview_msg), "UTF-8") }, 2));
        s.s(paramActivity, "java.lang.String.format(format, *args)");
        ((Intent)localObject).putExtra("rawUrl", paramActivity);
        ((Intent)localObject).putExtra("forceHideShare", true);
        c.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
      AppMethodBeat.o(321915);
      return true;
    }
    
    public final a.b cJw()
    {
      AppMethodBeat.i(321913);
      a.b localb = AppBrandCheckWxaShortLinkUI.a(this.tYT);
      AppMethodBeat.o(321913);
      return localb;
    }
    
    public final com.tencent.mm.plugin.appbrand.shortlink.a cJx()
    {
      return (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.tUW;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<WxaShortLinkLaunchErrorCode, ah>
  {
    d(WeakReference<AppBrandCheckWxaShortLinkUI> paramWeakReference)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$parseLinkAndLaunchNoCheck$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "launch", "", "ctx", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onLaunchDone", "Landroid/app/Activity;", "url", "", "onLinkDecodeDone", "onUserCancel", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AbsWxaShortLinkLauncher
  {
    e(WxaShortLinkInfo paramWxaShortLinkInfo, String paramString, AppBrandCheckWxaShortLinkUI paramAppBrandCheckWxaShortLinkUI, int paramInt, x.b paramb)
    {
      AppMethodBeat.i(321909);
      if (this.tYX != null)
      {
        paramWxaShortLinkInfo = (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.tUW;
        if (paramWxaShortLinkInfo != null) {
          paramWxaShortLinkInfo.a(paramBundle, this.tYX);
        }
      }
      AppMethodBeat.o(321909);
    }
    
    public final void a(Context paramContext, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      AppMethodBeat.i(321916);
      s.u(paramContext, "ctx");
      s.u(paramWxaShortLinkLaunchParams, "params");
      s.u(paramb, "launchResultCallback");
      Object localObject = jdField_this.getIntent().getStringExtra("prescene_for_report");
      String str1 = jdField_this.getIntent().getStringExtra("message");
      String str2 = jdField_this.getIntent().getStringExtra("presceneNote_for_report");
      int i = 0;
      try
      {
        j = Integer.parseInt((String)localObject);
        i = j;
      }
      catch (Exception localException)
      {
        int j;
        label79:
        break label79;
      }
      localObject = new g();
      j = i;
      ((g)localObject).appId = paramWxaShortLinkLaunchParams.appId;
      ((g)localObject).qAF = paramWxaShortLinkLaunchParams.path;
      ((g)localObject).version = paramWxaShortLinkLaunchParams.version;
      ((g)localObject).euz = paramWxaShortLinkLaunchParams.euz;
      ((g)localObject).qAX = paramWxaShortLinkLaunchParams.qAX;
      ((g)localObject).scene = 1179;
      ((g)localObject).qAI = i;
      ((g)localObject).hzx = str1;
      ((g)localObject).qAJ = str2;
      ((g)localObject).chatType = j;
      Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "launchWxa  appId=" + ((g)localObject).appId + " \nenterPath=" + ((g)localObject).qAF + " \nversion=" + ((g)localObject).version + " \nversionType=" + ((g)localObject).euz + " \nshortLink=" + ((g)localObject).qAX + " \nscene=" + ((g)localObject).scene + " \nsceneNote=" + ((g)localObject).hzx + " \npresceneNote=" + ((g)localObject).qAJ + " \nprescene=" + i + '\n');
      ((t)h.ax(t.class)).a(paramContext, (g)localObject);
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(321916);
    }
    
    public final boolean a(Activity paramActivity, boolean paramBoolean)
    {
      AppMethodBeat.i(321921);
      s.u(paramActivity, "ctx");
      AppMethodBeat.o(321921);
      return true;
    }
    
    public final void b(Activity paramActivity, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(321910);
      s.u(paramActivity, "ctx");
      s.u(paramString, "url");
      super.b(paramActivity, paramString, paramBoolean);
      paramActivity = jdField_this;
      paramString = this.tYX;
      s.checkNotNull(paramString);
      paramActivity.a(1, paramString);
      AppMethodBeat.o(321910);
    }
    
    public final a.b cJw()
    {
      AppMethodBeat.i(321918);
      a.b localb = AppBrandCheckWxaShortLinkUI.a(this.tYT);
      AppMethodBeat.o(321918);
      return localb;
    }
    
    public final com.tencent.mm.plugin.appbrand.shortlink.a cJx()
    {
      return (com.tencent.mm.plugin.appbrand.shortlink.a)com.tencent.mm.plugin.appbrand.shortlink.b.tUW;
    }
    
    public final void g(Activity paramActivity, String paramString)
    {
      AppMethodBeat.i(321912);
      s.u(paramActivity, "ctx");
      s.u(paramString, "url");
      super.g(paramActivity, paramString);
      paramActivity = jdField_this;
      paramString = this.tYX;
      s.checkNotNull(paramString);
      paramActivity.a(2, paramString);
      AppMethodBeat.o(321912);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<WxaShortLinkLaunchErrorCode, ah>
  {
    f(WeakReference<AppBrandCheckWxaShortLinkUI> paramWeakReference)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI
 * JD-Core Version:    0.7.0.1
 */