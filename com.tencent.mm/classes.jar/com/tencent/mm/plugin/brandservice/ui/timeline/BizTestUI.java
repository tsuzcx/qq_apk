package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "copyText", "", "text", "getLayoutId", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reboot", "testAd", "testFastLoad", "testPrefetch", "testRec", "videoChannel", "showBottomSheet", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function0;", "TestItem", "plugin-brandservice_release"})
public final class BizTestUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.BizTestUI";
  private HashMap _$_findViewCache;
  
  private static void a(List<a> paramList, Context paramContext, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(195209);
    paramContext = new e(paramContext, 1, false);
    paramContext.a((o.f)new d(paramList));
    paramContext.a((o.g)new e(paramList, parama));
    paramContext.o((CharSequence)" ", 1);
    paramContext.Do(true);
    paramContext.dGm();
    AppMethodBeat.o(195209);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195213);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195213);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195212);
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
    AppMethodBeat.o(195212);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131493248;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(195208);
    p.h(paramView, "view");
    int i = paramView.getId();
    Object localObject1;
    if (i == 2131305943)
    {
      d locald = new d((Context)this);
      locald.setTitle((CharSequence)"Pkg Info");
      localObject1 = "";
      Object localObject3;
      if (MultiProcessMMKV.getMMKV("WebCanvasStorage").decodeInt("BizTimeLineAdPreviewMode", 0) != 1)
      {
        paramView = com.tencent.mm.plugin.webcanvas.m.IAG;
        paramView = com.tencent.mm.plugin.webcanvas.m.aWJ("wxfedb0854e2b1820d");
        if (paramView != null)
        {
          localObject1 = "" + "BasePkg:md5=" + paramView.md5 + "\tversion=" + paramView.version + '\n';
          paramView = com.tencent.mm.plugin.webcanvas.m.IAG;
          localObject2 = com.tencent.mm.plugin.webcanvas.m.aWJ("wxf337cbaa27790d8e");
          paramView = (View)localObject1;
          if (localObject2 != null) {
            paramView = (String)localObject1 + "BizPkg:md5=" + ((tu)localObject2).md5 + " \tversion=" + ((tu)localObject2).version + '\n';
          }
          localObject1 = com.tencent.mm.plugin.webcanvas.m.IAG;
          localObject1 = com.tencent.mm.plugin.webcanvas.m.aWJ("wx97b7aebac2183fd2");
          if (localObject1 == null) {
            break label383;
          }
          paramView = paramView + "PrefetchBasePkg:md5=" + ((tu)localObject1).md5 + " \tversion=" + ((tu)localObject1).version + '\n';
        }
        label383:
        for (;;)
        {
          localObject1 = com.tencent.mm.plugin.webcanvas.m.IAG;
          localObject2 = ((Iterable)com.tencent.mm.plugin.webcanvas.m.fWI()).iterator();
          for (;;)
          {
            localObject1 = paramView;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (String)((Iterator)localObject2).next();
            localObject3 = com.tencent.mm.plugin.webcanvas.m.IAG;
            localObject3 = com.tencent.mm.plugin.webcanvas.m.aWJ((String)localObject1);
            if (localObject3 != null) {
              paramView = paramView + "PrefetchBizPkg:appId = " + (String)localObject1 + ", md5=" + ((tu)localObject3).md5 + " \tversion=" + ((tu)localObject3).version + '\n';
            }
          }
          localObject1 = "";
          break;
        }
      }
      paramView = ((v)g.af(v.class)).H("wxfedb0854e2b1820d", 2, 0);
      if (paramView != null) {
        localObject1 = "" + "BasePkg:md5=" + paramView.field_versionMd5 + "\tversion=" + paramView.field_version + '\n';
      }
      Object localObject2 = ((v)g.af(v.class)).H("wxf337cbaa27790d8e", 2, 0);
      paramView = (View)localObject1;
      if (localObject2 != null) {
        paramView = (String)localObject1 + "BizPkg:md5=" + ((bd)localObject2).field_versionMd5 + " \tversion=" + ((bd)localObject2).field_version + '\n';
      }
      localObject2 = ((v)g.af(v.class)).H("wx97b7aebac2183fd2", 2, 0);
      localObject1 = paramView;
      if (localObject2 != null) {
        localObject1 = paramView + "PrefetchBasePkg:md5=" + ((bd)localObject2).field_versionMd5 + " \tversion=" + ((bd)localObject2).field_version + '\n';
      }
      paramView = com.tencent.mm.plugin.webcanvas.m.IAG;
      localObject2 = ((Iterable)com.tencent.mm.plugin.webcanvas.m.fWI()).iterator();
      paramView = (View)localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        localObject3 = ((v)g.af(v.class)).H((String)localObject1, 2, 0);
        if (localObject3 != null) {
          paramView = paramView + "PrefetchBizPkg:appId = " + (String)localObject1 + ", md5=" + ((bd)localObject3).field_versionMd5 + " \tversion=" + ((bd)localObject3).field_version + '\n';
        }
      }
      localObject1 = paramView;
      locald.setMessage((CharSequence)localObject1);
      locald.aoN(3);
      locald.aoM(3);
      locald.a((CharSequence)getString(2131761757), true, null);
      locald.show();
      ClipboardHelper.setText((Context)getContext(), null, (CharSequence)localObject1);
      AppMethodBeat.o(195208);
      return;
    }
    if (i == 2131309732)
    {
      paramView = MultiProcessMMKV.getSingleMMKV("brandService");
      a(j.listOf(new a[] { new a("开启频道入口动态化", (kotlin.g.a.a)new ac(paramView)), new a("关闭频道入口动态化", (kotlin.g.a.a)new ad(paramView)), new a("使用后台开关", (kotlin.g.a.a)new ae(paramView)) }), (Context)this, (kotlin.g.a.a)new af(this, paramView));
      AppMethodBeat.o(195208);
      return;
    }
    if (i == 2131296506)
    {
      paramView = new Intent((Context)getContext(), BizTestCanvasUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(195208);
      return;
    }
    if (i == 2131300430)
    {
      paramView = MultiProcessMMKV.getMMKV("_webview_tmpl_command");
      a(j.listOf(new a[] { new a("清理模板", (kotlin.g.a.a)new q(this)), new a("清理数据", (kotlin.g.a.a)new r(this)), new a("检查模板更新", (kotlin.g.a.a)new s(this, paramView)), new a("关闭超时跳转", (kotlin.g.a.a)new t(this, paramView)), new a("恢复超时跳转", (kotlin.g.a.a)new u(this, paramView)) }), (Context)this);
      AppMethodBeat.o(195208);
      return;
    }
    if (i == 2131296483)
    {
      paramView = MultiProcessMMKV.getSingleMMKV("brandService");
      localObject1 = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
      a(j.listOf(new a[] { new a("预览状态", (kotlin.g.a.a)f.pqQ), new a("发布状态-忽略频控", (kotlin.g.a.a)i.pqS), new a("发布状态", (kotlin.g.a.a)j.pqT), new a("打开广告", (kotlin.g.a.a)new k(paramView)), new a("关闭广告", (kotlin.g.a.a)new l(paramView)), new a("正常模式", (kotlin.g.a.a)new m(paramView)), new a("测试模式", (kotlin.g.a.a)new n(paramView)), new a("Mock视频模式", (kotlin.g.a.a)new o(paramView)), new a("Mock图片模式", (kotlin.g.a.a)new p(paramView)), new a("清理广告曝光", (kotlin.g.a.a)new g((MultiProcessMMKV)localObject1)) }), (Context)this, (kotlin.g.a.a)new h(this));
      AppMethodBeat.o(195208);
      return;
    }
    if (i == 2131306601)
    {
      a(j.listOf(new a[] { new a("插入推荐卡片", (kotlin.g.a.a)z.pqV), new a("打开推荐流", (kotlin.g.a.a)new aa(this)), new a("关闭推荐流", (kotlin.g.a.a)new ab(this)) }), (Context)this);
      AppMethodBeat.o(195208);
      return;
    }
    if (i == 2131298926) {
      a(j.listOf(new a[] { new a("打开大秒开使用pkg", (kotlin.g.a.a)new v(this)), new a("关闭大秒开使用pkg", (kotlin.g.a.a)new w(this)), new a("打开大秒开测试", (kotlin.g.a.a)new x(this)), new a("关闭大秒开测试", (kotlin.g.a.a)new y(this)) }), (Context)this);
    }
    AppMethodBeat.o(195208);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195207);
    super.onCreate(paramBundle);
    setMMTitle(2131763040);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(195207);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTestUI$TestItem;", "", "name", "", "execute", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExecute", "()Lkotlin/jvm/functions/Function0;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  static final class a
  {
    final String name;
    final kotlin.g.a.a<x> pqM;
    
    public a(String paramString, kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(195168);
      this.name = paramString;
      this.pqM = parama;
      AppMethodBeat.o(195168);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195171);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.j(this.name, paramObject.name)) || (!p.j(this.pqM, paramObject.pqM))) {}
        }
      }
      else
      {
        AppMethodBeat.o(195171);
        return true;
      }
      AppMethodBeat.o(195171);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(195170);
      Object localObject = this.name;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.pqM;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(195170);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195169);
      String str = "TestItem(name=" + this.name + ", execute=" + this.pqM + ")";
      AppMethodBeat.o(195169);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.a<x>
  {
    aa(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements kotlin.g.a.a<x>
  {
    ab(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ac
    extends q
    implements kotlin.g.a.a<x>
  {
    ac(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<x>
  {
    ad(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<x>
  {
    ae(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.a<x>
  {
    af(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(BizTestUI paramBizTestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(195172);
      this.pqN.finish();
      AppMethodBeat.o(195172);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c pqO;
    
    static
    {
      AppMethodBeat.i(195173);
      pqO = new c();
      AppMethodBeat.o(195173);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    d(List paramList) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(195174);
      Object localObject1 = (Iterable)this.pqP;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.hxH();
        }
        paramm.c(i, (CharSequence)((BizTestUI.a)localObject2).name);
        i += 1;
      }
      AppMethodBeat.o(195174);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements o.g
  {
    e(List paramList, kotlin.g.a.a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(195175);
      ((BizTestUI.a)this.pqP.get(paramInt)).pqM.invoke();
      parama.invoke();
      AppMethodBeat.o(195175);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final f pqQ;
    
    static
    {
      AppMethodBeat.i(195177);
      pqQ = new f();
      AppMethodBeat.o(195177);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final i pqS;
    
    static
    {
      AppMethodBeat.i(195181);
      pqS = new i();
      AppMethodBeat.o(195181);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final j pqT;
    
    static
    {
      AppMethodBeat.i(195183);
      pqT = new j();
      AppMethodBeat.o(195183);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<x>
  {
    r(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<x>
  {
    s(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<x>
  {
    t(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<x>
  {
    u(BizTestUI paramBizTestUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<x>
  {
    v(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<x>
  {
    w(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<x>
  {
    x(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.a<x>
  {
    y(BizTestUI paramBizTestUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final z pqV;
    
    static
    {
      AppMethodBeat.i(195200);
      pqV = new z();
      AppMethodBeat.o(195200);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestUI
 * JD-Core Version:    0.7.0.1
 */