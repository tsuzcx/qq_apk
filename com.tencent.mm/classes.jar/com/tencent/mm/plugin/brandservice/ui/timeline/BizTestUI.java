package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.api.ab;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.k.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "getDialog", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "setDialog", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "preAuthUrl", "getPreAuthUrl", "()Ljava/lang/String;", "url", "getUrl", "addToPreFetch", "", "copyText", "text", "finderLive", "getLayoutId", "", "goLuancherUI", "onClick", "view", "Landroid/view/View;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "preCreateWebView", "preInitWebView", "reboot", "setHalfScreenCallback", "setPreviewMode", "mode", "testAd", "testBiz", "testCanvas", "testFastLoad", "testPkg", "testPrefetch", "testProfile", "testRec", "testWebView", "videoChannel", "immersiveStyle", "showBottomSheet", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function0;", "TestItem", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTestUI
  extends MMActivity
{
  private final String TAG;
  final MultiProcessMMKV eMf;
  final String url;
  com.tencent.mm.plugin.webview.ui.tools.widget.a vFp;
  final String vFq;
  
  public BizTestUI()
  {
    AppMethodBeat.i(301795);
    this.TAG = "MicroMsg.BizTestUI";
    this.eMf = MultiProcessMMKV.getSingleMMKV("brandService");
    this.url = "https://channels.weixin.qq.com/mobile-support/pages/anchor-tasks/op?activity_id=2";
    this.vFq = "https://view.inews.qq.com/w/WXN20210728007064020?refer=nwx&bat_id=1110161934&cur_pos=0&grp_type=region&rg=2&grp_index=3&grp_id=1310161938&rate=0&ft=0&pushid=2021072801&bkt=0&openid=o04IBANPdC07VqdylGZi5oszSVnY&tbkt=D&lrg=2&groupid=1627447890&msgid=0&key=&version=28000f0e&devicetype=android-29&wuid=oDdoCtzMgtW9K5DGWnd8OkNC-kEY";
    AppMethodBeat.o(301795);
  }
  
  private static void a(List<a> paramList, Context paramContext, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(301809);
    paramContext = new f(paramContext, 1, false);
    paramContext.Vtg = new BizTestUI..ExternalSyntheticLambda1(paramList);
    paramContext.GAC = new BizTestUI..ExternalSyntheticLambda2(paramList, parama);
    paramContext.h((CharSequence)" ", 1, 0);
    paramContext.sRz = true;
    paramContext.dDn();
    AppMethodBeat.o(301809);
  }
  
  private static final void a(List paramList, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(301831);
    kotlin.g.b.s.u(paramList, "$this_showBottomSheet");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (CharSequence)((a)localObject).name;
      t localt = new t(params.mContext, i, 0);
      localt.setTitle((CharSequence)localObject);
      localt.disable = false;
      params.adRW.add(localt);
      i += 1;
    }
    AppMethodBeat.o(301831);
  }
  
  private static final void a(List paramList, kotlin.g.a.a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(301842);
    kotlin.g.b.s.u(paramList, "$this_showBottomSheet");
    kotlin.g.b.s.u(parama, "$block");
    ((a)paramList.get(paramInt)).vFr.invoke();
    parama.invoke();
    AppMethodBeat.o(301842);
  }
  
  private static final boolean a(BizTestUI paramBizTestUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(301825);
    kotlin.g.b.s.u(paramBizTestUI, "this$0");
    paramBizTestUI.finish();
    AppMethodBeat.o(301825);
    return true;
  }
  
  private final void dcH()
  {
    AppMethodBeat.i(301804);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 0);
    com.tencent.mm.br.c.g((Context)this, ".ui.LauncherUI", localIntent);
    AppMethodBeat.o(301804);
  }
  
  private final void dcI()
  {
    AppMethodBeat.i(301820);
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new i(this));
    AppMethodBeat.o(301820);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return d.f.biz_test_activity;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(301976);
    kotlin.g.b.s.u(paramView, "view");
    int i = paramView.getId();
    if (i == d.e.pkg_info)
    {
      a(p.listOf(new a[] { new a("预览状态", (kotlin.g.a.a)new ab(this)), new a("发布状态-忽略频控", (kotlin.g.a.a)new ac(this)), new a("发布状态", (kotlin.g.a.a)new ad(this)), new a("清理本地代码包", (kotlin.g.a.a)new ae(this)), new a("代码包版本", (kotlin.g.a.a)new af(this)), new a("代码包版本-小程序DSL", (kotlin.g.a.a)new ag(this)) }), (Context)this, (kotlin.g.a.a)ah.vFy);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.video_channel_canvas_open)
    {
      paramView = MultiProcessMMKV.getSingleMMKV("brandService");
      a(p.listOf(new a[] { new a("开启频道入口动态化", (kotlin.g.a.a)new bb(paramView)), new a("关闭频道入口动态化", (kotlin.g.a.a)new bc(paramView)), new a("使用后台开关", (kotlin.g.a.a)new bd(paramView)) }), (Context)this, (kotlin.g.a.a)new be(paramView, this));
      AppMethodBeat.o(301976);
      return;
    }
    Object localObject;
    if (i == d.e.ad_finder_live)
    {
      a locala1 = new a("清除数据", (kotlin.g.a.a)new b(this));
      paramView = com.tencent.mm.pluginsdk.model.c.XPt;
      a locala2;
      a locala3;
      a locala4;
      if (!com.tencent.mm.pluginsdk.model.c.iHi())
      {
        paramView = new a("强制开启所有直播入口", (kotlin.g.a.a)new c(this));
        locala2 = new a("插入直播红点", (kotlin.g.a.a)new e(this));
        locala3 = new a("检查直播红点", (kotlin.g.a.a)new f(this));
        locala4 = new a("Profile显示直播中", (kotlin.g.a.a)g.vFt);
        localObject = com.tencent.mm.pluginsdk.model.c.XPt;
        if (!com.tencent.mm.pluginsdk.model.c.iHg()) {
          break label548;
        }
      }
      label548:
      for (localObject = "直播Bar曝光后不再显示";; localObject = "直播Bar曝光后仍然显示")
      {
        a(p.listOf(new a[] { locala1, paramView, locala2, locala3, locala4, new a((String)localObject, (kotlin.g.a.a)new h(this)) }), (Context)this);
        AppMethodBeat.o(301976);
        return;
        paramView = new a("恢复现网直播入口开关", (kotlin.g.a.a)new d(this));
        break;
      }
    }
    if (i == d.e.fast_load_test)
    {
      paramView = MultiProcessMMKV.getMMKV("_webview_tmpl_command");
      a(p.listOf(new a[] { new a("清理模板", (kotlin.g.a.a)new v(this)), new a("清理数据", (kotlin.g.a.a)new w(this)), new a("检查模板更新", (kotlin.g.a.a)new x(paramView, this)), new a("关闭超时跳转", (kotlin.g.a.a)new y(paramView, this)), new a("恢复超时跳转", (kotlin.g.a.a)new z(paramView, this)), new a("清理上报KV", (kotlin.g.a.a)new aa(this)) }), (Context)this);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.ad_canvas_open)
    {
      paramView = MultiProcessMMKV.getSingleMMKV("brandService");
      localObject = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
      a(p.listOf(new a[] { new a("预览广告", (kotlin.g.a.a)new l(this)), new a("退出预览广告", (kotlin.g.a.a)new m(this)), new a("正常模式", (kotlin.g.a.a)new n(paramView, this)), new a("测试模式", (kotlin.g.a.a)new o(paramView, this)), new a("Mock视频模式", (kotlin.g.a.a)new p(paramView, this)), new a("Mock图片模式", (kotlin.g.a.a)new q(paramView, this)), new a("清理广告曝光", (kotlin.g.a.a)new r((MultiProcessMMKV)localObject, this)) }), (Context)this, (kotlin.g.a.a)s.vFw);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.rec_canvas_open)
    {
      a(p.listOf(new a[] { new a("插入canvas推荐卡片", (kotlin.g.a.a)ap.vFB), new a("插入原生推荐卡片", (kotlin.g.a.a)aq.vFC), new a("插入视频号推荐卡片", (kotlin.g.a.a)ar.vFD), new a("允许前端回收动态推荐卡片", (kotlin.g.a.a)new as(this)), new a("禁止前端回收动态推荐卡片", (kotlin.g.a.a)new at(this)), new a("打开推荐流", (kotlin.g.a.a)new au(this)), new a("关闭推荐流", (kotlin.g.a.a)new av(this)) }), (Context)this);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.biz_test)
    {
      a(p.listOf(new a[] { new a("乱序忽略频控", (kotlin.g.a.a)new t(this)), new a("乱序恢复频控", (kotlin.g.a.a)new u(this)) }), (Context)this);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.comm_prefetcher)
    {
      a(p.listOf(new a[] { new a("打开大秒开使用pkg", (kotlin.g.a.a)new ai(this)), new a("关闭大秒开使用pkg", (kotlin.g.a.a)new aj(this)), new a("x系统控制大秒开使用pkg", (kotlin.g.a.a)new ak(this)), new a("打开大秒开测试", (kotlin.g.a.a)new al(this)), new a("关闭大秒开测试", (kotlin.g.a.a)new am(this)) }), (Context)this);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.webview_test)
    {
      a(p.listOf(new a[] { new a("打开url传参指定渲染方式", (kotlin.g.a.a)new aw(this)), new a("关闭url传参指定渲染方式", (kotlin.g.a.a)new ax(this)), new a("弹出半屏WebView", (kotlin.g.a.a)new ay(this)), new a("弹出半屏WebView-沉浸式", (kotlin.g.a.a)new az(this)), new a("弹出半屏WebView-秒开", (kotlin.g.a.a)new ba(this)) }), (Context)this);
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.canvas_test)
    {
      com.tencent.mm.br.c.ai((Context)this, "brandservice", ".ui.timeline.BizTestCanvasUI");
      AppMethodBeat.o(301976);
      return;
    }
    if (i == d.e.profile_test) {
      a(p.listOf(new a[] { new a("打开profile不使用缓存", (kotlin.g.a.a)an.vFz), new a("打开profile使用缓存", (kotlin.g.a.a)ao.vFA) }), (Context)this);
    }
    AppMethodBeat.o(301976);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(301992);
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(301992);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(301931);
    super.onCreate(paramBundle);
    com.tencent.mm.pluginsdk.h.x((MMActivity)this);
    setMMTitle(d.i.menu_show_app_msg_content);
    paramBundle = com.tencent.mm.plugin.biz.b.c.vtp;
    if (!com.tencent.mm.plugin.biz.b.c.daD())
    {
      Log.e(this.TAG, "Not test env, finish now!!!");
      finish();
      AppMethodBeat.o(301931);
      return;
    }
    com.tencent.mm.xwebutil.c.a(null);
    ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).a(this.vFq, 10000, "wx073f4a4daff0abe8", "", "", "singlemessage", 2);
    dcI();
    setBackBtn(new BizTestUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(301931);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(301938);
    super.onDestroy();
    l locall = l.Xtf;
    l.clear();
    AppMethodBeat.o(301938);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "", "name", "", "execute", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExecute", "()Lkotlin/jvm/functions/Function0;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    final String name;
    final kotlin.g.a.a<ah> vFr;
    
    public a(String paramString, kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(301987);
      this.name = paramString;
      this.vFr = parama;
      AppMethodBeat.o(301987);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(302024);
      if (this == paramObject)
      {
        AppMethodBeat.o(302024);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(302024);
        return false;
      }
      paramObject = (a)paramObject;
      if (!kotlin.g.b.s.p(this.name, paramObject.name))
      {
        AppMethodBeat.o(302024);
        return false;
      }
      if (!kotlin.g.b.s.p(this.vFr, paramObject.vFr))
      {
        AppMethodBeat.o(302024);
        return false;
      }
      AppMethodBeat.o(302024);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(302014);
      int i = this.name.hashCode();
      int j = this.vFr.hashCode();
      AppMethodBeat.o(302014);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(302004);
      String str = "TestItem(name=" + this.name + ", execute=" + this.vFr + ')';
      AppMethodBeat.o(302004);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    aa(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ab(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ac(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ad(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ae
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ae(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class af
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    af(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ag
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ag(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final ah vFy;
    
    static
    {
      AppMethodBeat.i(301871);
      vFy = new ah();
      AppMethodBeat.o(301871);
    }
    
    ah()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ai
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ai(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aj
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    aj(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ak
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ak(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class al
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    al(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class am
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    am(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class an
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final an vFz;
    
    static
    {
      AppMethodBeat.i(301909);
      vFz = new an();
      AppMethodBeat.o(301909);
    }
    
    an()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ao
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final ao vFA;
    
    static
    {
      AppMethodBeat.i(301907);
      vFA = new ao();
      AppMethodBeat.o(301907);
    }
    
    ao()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ap
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final ap vFB;
    
    static
    {
      AppMethodBeat.i(301906);
      vFB = new ap();
      AppMethodBeat.o(301906);
    }
    
    ap()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aq
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final aq vFC;
    
    static
    {
      AppMethodBeat.i(301772);
      vFC = new aq();
      AppMethodBeat.o(301772);
    }
    
    aq()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ar
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final ar vFD;
    
    static
    {
      AppMethodBeat.i(301773);
      vFD = new ar();
      AppMethodBeat.o(301773);
    }
    
    ar()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class as
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    as(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class at
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    at(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class au
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    au(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class av
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    av(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aw
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    aw(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ax
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ax(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ay
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ay(BizTestUI paramBizTestUI)
    {
      super();
    }
    
    private static final void a(BizTestUI paramBizTestUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(301780);
      kotlin.g.b.s.u(paramBizTestUI, "this$0");
      label30:
      Context localContext;
      if ((paramDialogInterface instanceof e))
      {
        paramDialogInterface = (e)paramDialogInterface;
        if (paramDialogInterface != null) {
          break label143;
        }
        paramDialogInterface = "";
        localObject = paramBizTestUI.getContext();
        kotlin.g.b.s.s(localObject, "context");
        localContext = (Context)localObject;
        localObject = paramDialogInterface;
        if (!n.i((CharSequence)paramDialogInterface, (CharSequence)"http")) {
          if (!n.i((CharSequence)paramDialogInterface, (CharSequence)"www")) {
            break label160;
          }
        }
      }
      label143:
      label160:
      for (Object localObject = paramDialogInterface;; localObject = paramBizTestUI.url)
      {
        paramBizTestUI.vFp = new com.tencent.mm.plugin.webview.ui.tools.widget.a(localContext, (String)localObject, null, 12);
        BizTestUI.c(paramBizTestUI);
        paramDialogInterface = paramBizTestUI.vFp;
        if (paramDialogInterface != null) {
          paramDialogInterface.show();
        }
        d.a(2000L, (kotlin.g.a.a)new a(paramBizTestUI));
        AppMethodBeat.o(301780);
        return;
        paramDialogInterface = null;
        break;
        localObject = paramDialogInterface.jHE();
        paramDialogInterface = (DialogInterface)localObject;
        if (localObject != null) {
          break label30;
        }
        paramDialogInterface = "";
        break label30;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(BizTestUI paramBizTestUI)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class az
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    az(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ba
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ba(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class bb
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    bb(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class bc
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    bc(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class bd
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    bd(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class be
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    be(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final g vFt;
    
    static
    {
      AppMethodBeat.i(302218);
      vFt = new g();
      AppMethodBeat.o(302218);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements MessageQueue.IdleHandler
  {
    public i(BizTestUI paramBizTestUI) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(302424);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      Object localObject1 = l.Xtf;
      Object localObject2;
      if (l.bmX(this.vFs.url))
      {
        localObject1 = ((ab)com.tencent.mm.kernel.h.ax(ab.class)).a(MMWebView.a.nL((Context)new MutableContextWrapper((Context)this.vFs.getContext())), new BaseWebViewController.d(null, false, false, false, false, false, 105), null);
        localObject2 = l.Xtf;
        localObject2 = this.vFs.url;
        kotlin.g.b.s.s(localObject1, "controller");
        l.a((String)localObject2, (BaseWebViewController)localObject1);
      }
      localObject1 = l.Xtf;
      if (l.bmX(BizTestUI.aiV(this.vFs.url)))
      {
        localObject1 = ((ab)com.tencent.mm.kernel.h.ax(ab.class)).a(MMWebView.a.nL((Context)new MutableContextWrapper((Context)this.vFs.getContext())), new BaseWebViewController.d(null, false, false, false, false, false, 105), null);
        localObject2 = l.Xtf;
        localObject2 = BizTestUI.aiV(this.vFs.url);
        kotlin.g.b.s.s(localObject1, "controller");
        l.a((String)localObject2, (BaseWebViewController)localObject1);
      }
      AppMethodBeat.o(302424);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$setHalfScreenCallback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewHalfScreenCallback;", "onMenuClick", "", "url", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.plugin.webview.ui.tools.widget.u
  {
    j(BizTestUI paramBizTestUI) {}
    
    public final void dcJ()
    {
      AppMethodBeat.i(302852);
      aa.makeText((Context)this.vFs.getContext(), (CharSequence)"menu click", 1).show();
      AppMethodBeat.o(302852);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final k vFu;
    
    static
    {
      AppMethodBeat.i(302426);
      vFu = new k();
      AppMethodBeat.o(302426);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    l(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    m(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    n(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    o(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    p(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    q(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    r(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final s vFw;
    
    static
    {
      AppMethodBeat.i(302223);
      vFw = new s();
      AppMethodBeat.o(302223);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    t(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    u(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    v(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    w(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    x(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    y(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    z(MultiProcessMMKV paramMultiProcessMMKV, BizTestUI paramBizTestUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI
 * JD-Core Version:    0.7.0.1
 */