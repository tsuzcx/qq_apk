package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "copyText", "", "text", "finderLive", "getLayoutId", "", "goLuancherUI", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reboot", "testAd", "testFastLoad", "testPkg", "testPrefetch", "testRec", "testWebView", "videoChannel", "showBottomSheet", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function0;", "TestItem", "plugin-brandservice_release"})
public final class BizTestUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestUI";
  private HashMap _$_findViewCache;
  
  private static void a(List<a> paramList, Context paramContext, final a<x> parama)
  {
    AppMethodBeat.i(264367);
    paramContext = new e(paramContext, 1, false);
    paramContext.a((q.f)new k(paramList));
    paramContext.a((q.g)new l(paramList, parama));
    paramContext.q((CharSequence)" ", 1);
    paramContext.HJ(true);
    paramContext.eik();
    AppMethodBeat.o(264367);
  }
  
  private final void czP()
  {
    AppMethodBeat.i(264366);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.putExtra("preferred_tab", 0);
    c.f((Context)this, ".ui.LauncherUI", localIntent);
    AppMethodBeat.o(264366);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(264374);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(264374);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(264373);
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
    AppMethodBeat.o(264373);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return d.f.stF;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(264365);
    p.k(paramView, "view");
    int i = paramView.getId();
    if (i == d.e.ssr)
    {
      a(j.listOf(new a[] { new a("预览状态", (a)new ab(this)), new a("发布状态-忽略频控", (a)new ac(this)), new a("发布状态", (a)new ad(this)), new a("代码包版本", (a)new ae(this)) }), (Context)this, (a)af.szU);
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.stm)
    {
      paramView = MultiProcessMMKV.getSingleMMKV("brandService");
      a(j.listOf(new a[] { new a("开启频道入口动态化", (a)new aq(paramView)), new a("关闭频道入口动态化", (a)new ar(paramView)), new a("使用后台开关", (a)new as(paramView)) }), (Context)this, (a)new at(this, paramView));
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.spM)
    {
      a(j.listOf(new a[] { new a("清除数据", (a)new b(this)), new a("开启跳转直播", (a)new c(this)), new a("跳转直播-看后台开关", (a)new d(this)), new a("插入直播红点", (a)new e(this)), new a("检查直播红点", (a)new f(this)), new a("跳转垂类直播广场", (a)g.szN), new a("Profile显示直播中", (a)h.szO) }), (Context)this);
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.srR)
    {
      paramView = MultiProcessMMKV.getMMKV("_webview_tmpl_command");
      a(j.listOf(new a[] { new a("清理模板", (a)new w(this)), new a("清理数据", (a)new x(this)), new a("检查模板更新", (a)new y(this, paramView)), new a("关闭超时跳转", (a)new z(this, paramView)), new a("恢复超时跳转", (a)new aa(this, paramView)) }), (Context)this);
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.spL)
    {
      paramView = MultiProcessMMKV.getSingleMMKV("brandService");
      final MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
      a(j.listOf(new a[] { new a("预览广告", (a)new m(this)), new a("退出预览广告", (a)new o(this)), new a("打开广告", (a)new p(this, paramView)), new a("关闭广告", (a)new q(this, paramView)), new a("正常模式", (a)new r(this, paramView)), new a("测试模式", (a)new s(this, paramView)), new a("Mock视频模式", (a)new t(this, paramView)), new a("Mock图片模式", (a)new u(this, paramView)), new a("清理广告曝光", (a)new v(this, localMultiProcessMMKV)) }), (Context)this, (a)n.szR);
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.ssA)
    {
      a(j.listOf(new a[] { new a("插入推荐卡片", (a)al.szV), new a("打开推荐流", (a)new am(this)), new a("关闭推荐流", (a)new an(this)) }), (Context)this);
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.srJ)
    {
      a(j.listOf(new a[] { new a("打开大秒开使用pkg", (a)new ag(this)), new a("关闭大秒开使用pkg", (a)new ah(this)), new a("x系统控制大秒开使用pkg", (a)new ai(this)), new a("打开大秒开测试", (a)new aj(this)), new a("关闭大秒开测试", (a)new ak(this)) }), (Context)this);
      AppMethodBeat.o(264365);
      return;
    }
    if (i == d.e.stC) {
      a(j.listOf(new a[] { new a("打开url传参指定渲染方式", (a)new ao(this)), new a("关闭url传参指定渲染方式", (a)new ap(this)) }), (Context)this);
    }
    AppMethodBeat.o(264365);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264361);
    super.onCreate(paramBundle);
    setMMTitle(d.i.menu_show_app_msg_content);
    setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
    AppMethodBeat.o(264361);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "", "name", "", "execute", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExecute", "()Lkotlin/jvm/functions/Function0;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class a
  {
    final String name;
    final a<x> szL;
    
    public a(String paramString, a<x> parama)
    {
      AppMethodBeat.i(258791);
      this.name = paramString;
      this.szL = parama;
      AppMethodBeat.o(258791);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(258797);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.name, paramObject.name)) || (!p.h(this.szL, paramObject.szL))) {}
        }
      }
      else
      {
        AppMethodBeat.o(258797);
        return true;
      }
      AppMethodBeat.o(258797);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(258794);
      Object localObject = this.name;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.szL;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(258794);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(258792);
      String str = "TestItem(name=" + this.name + ", execute=" + this.szL + ")";
      AppMethodBeat.o(258792);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements a<x>
  {
    aa(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements a<x>
  {
    ab(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ac
    extends q
    implements a<x>
  {
    ac(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ad
    extends q
    implements a<x>
  {
    ad(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ae
    extends q
    implements a<x>
  {
    ae(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class af
    extends q
    implements a<x>
  {
    public static final af szU;
    
    static
    {
      AppMethodBeat.i(257656);
      szU = new af();
      AppMethodBeat.o(257656);
    }
    
    af()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ag
    extends q
    implements a<x>
  {
    ag(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ah
    extends q
    implements a<x>
  {
    ah(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ai
    extends q
    implements a<x>
  {
    ai(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aj
    extends q
    implements a<x>
  {
    aj(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ak
    extends q
    implements a<x>
  {
    ak(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class al
    extends q
    implements a<x>
  {
    public static final al szV;
    
    static
    {
      AppMethodBeat.i(265847);
      szV = new al();
      AppMethodBeat.o(265847);
    }
    
    al()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class am
    extends q
    implements a<x>
  {
    am(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class an
    extends q
    implements a<x>
  {
    an(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ao
    extends q
    implements a<x>
  {
    ao(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ap
    extends q
    implements a<x>
  {
    ap(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aq
    extends q
    implements a<x>
  {
    aq(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ar
    extends q
    implements a<x>
  {
    ar(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class as
    extends q
    implements a<x>
  {
    as(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class at
    extends q
    implements a<x>
  {
    at(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    public static final g szN;
    
    static
    {
      AppMethodBeat.i(264851);
      szN = new g();
      AppMethodBeat.o(264851);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    public static final h szO;
    
    static
    {
      AppMethodBeat.i(264799);
      szO = new h();
      AppMethodBeat.o(264799);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(BizTestUI paramBizTestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(262928);
      this.szM.finish();
      AppMethodBeat.o(262928);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    public static final j szP;
    
    static
    {
      AppMethodBeat.i(266197);
      szP = new j();
      AppMethodBeat.o(266197);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements q.f
  {
    k(List paramList) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(257212);
      Object localObject1 = (Iterable)this.szQ;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        paramo.c(i, (CharSequence)((BizTestUI.a)localObject2).name);
        i += 1;
      }
      AppMethodBeat.o(257212);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements q.g
  {
    l(List paramList, a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(266098);
      ((BizTestUI.a)this.szQ.get(paramInt)).szL.invoke();
      parama.invoke();
      AppMethodBeat.o(266098);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements a<x>
  {
    m(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements a<x>
  {
    public static final n szR;
    
    static
    {
      AppMethodBeat.i(259248);
      szR = new n();
      AppMethodBeat.o(259248);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements a<x>
  {
    o(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements a<x>
  {
    p(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements a<x>
  {
    q(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements a<x>
  {
    r(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements a<x>
  {
    s(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements a<x>
  {
    t(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements a<x>
  {
    u(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements a<x>
  {
    v(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements a<x>
  {
    w(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements a<x>
  {
    x(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements a<x>
  {
    y(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements a<x>
  {
    z(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI
 * JD-Core Version:    0.7.0.1
 */