package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.cg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.n.b;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "MENU_ID_SHARE_TO_CHAT", "", "MENU_ID_SHARE_TO_SNS", "cardId", "", "getCardId", "()J", "cardId$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "feedLoader$delegate", "fromShareScene", "getFromShareScene", "()I", "fromShareScene$delegate", "getRelatedScene", "getGetRelatedScene", "getRelatedScene$delegate", "p", "getP", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "p$delegate", "relatedRequest", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "getRelatedRequest", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "relatedRequest$delegate", "sharedUsername", "", "kotlin.jvm.PlatformType", "getSharedUsername", "()Ljava/lang/String;", "sharedUsername$delegate", "streamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getStreamCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "streamCard$delegate", "title", "txtCardIndex", "getTxtCardIndex", "txtCardIndex$delegate", "vc", "getVc", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "vc$delegate", "clickMoreMenu", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "Companion", "RelatedRequest", "plugin-finder_release"})
public final class FinderAlbumTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, n.b, n.a>
{
  private static final String TAG = "Finder.AlbumTimelineUI";
  public static final a xLr;
  private HashMap _$_findViewCache;
  private String title;
  private final int wXf;
  private final f xAp;
  private final f xLh;
  private final f xLi;
  private final f xLj;
  private final f xLk;
  private final f xLl;
  private final f xLm;
  private final f xLn;
  private final f xLo;
  private final f xLp;
  private final f xLq;
  private final int xhK;
  
  static
  {
    AppMethodBeat.i(273917);
    xLr = new a((byte)0);
    TAG = "Finder.AlbumTimelineUI";
    AppMethodBeat.o(273917);
  }
  
  public FinderAlbumTimelineUI()
  {
    AppMethodBeat.i(273916);
    this.xLh = g.ar((kotlin.g.a.a)new p(this));
    this.xLi = g.ar((kotlin.g.a.a)new u(this));
    this.xLj = g.ar((kotlin.g.a.a)new g(this));
    this.xLk = g.ar((kotlin.g.a.a)new j(this));
    this.xLl = g.ar((kotlin.g.a.a)new s(this));
    this.xLm = g.ar((kotlin.g.a.a)new t(this));
    this.xLn = g.ar((kotlin.g.a.a)new c(this));
    this.xLo = g.ar((kotlin.g.a.a)new i(this));
    this.xLp = g.ar((kotlin.g.a.a)new r(this));
    this.xLq = g.ar((kotlin.g.a.a)new q(this));
    this.xAp = g.ar((kotlin.g.a.a)new h(this));
    this.wXf = 101;
    this.xhK = 102;
    AppMethodBeat.o(273916);
  }
  
  private final n.a duH()
  {
    AppMethodBeat.i(273902);
    n.a locala = (n.a)this.xLh.getValue();
    AppMethodBeat.o(273902);
    return locala;
  }
  
  private final n.b duI()
  {
    AppMethodBeat.i(273903);
    n.b localb = (n.b)this.xLi.getValue();
    AppMethodBeat.o(273903);
    return localb;
  }
  
  private final int duJ()
  {
    AppMethodBeat.i(273904);
    int i = ((Number)this.xLk.getValue()).intValue();
    AppMethodBeat.o(273904);
    return i;
  }
  
  private final bjp duK()
  {
    AppMethodBeat.i(273905);
    bjp localbjp = (bjp)this.xLl.getValue();
    AppMethodBeat.o(273905);
    return localbjp;
  }
  
  private final long duL()
  {
    AppMethodBeat.i(273907);
    long l = ((Number)this.xLn.getValue()).longValue();
    AppMethodBeat.o(273907);
    return l;
  }
  
  private final b duM()
  {
    AppMethodBeat.i(273908);
    b localb = (b)this.xLq.getValue();
    AppMethodBeat.o(273908);
    return localb;
  }
  
  private final FinderFeedRelTimelineLoader duN()
  {
    AppMethodBeat.i(273909);
    FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = (FinderFeedRelTimelineLoader)this.xAp.getValue();
    AppMethodBeat.o(273909);
    return localFinderFeedRelTimelineLoader;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(273930);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(273930);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(273929);
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
    AppMethodBeat.o(273929);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 51;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_feed_related_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    boolean bool2 = true;
    AppMethodBeat.i(273912);
    Object localObject3 = getIntent().getStringExtra("TITLE_WORDING");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    localObject1 = this.title;
    if (localObject1 == null) {
      p.bGy("title");
    }
    setMMTitle((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dVY().aSr()).intValue() == 1) {
      addIconOptionMenu(0, b.i.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new o(this));
    }
    localObject1 = duK();
    if (localObject1 != null)
    {
      localObject3 = e.AmW;
      localObject3 = ((bjp)localObject1).object;
      p.j(localObject3, "it.`object`");
      e.a.m(51, (List)localObject3);
      localObject1 = ((bjp)localObject1).object;
      p.j(localObject1, "it.`object`");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject1).next();
        localObject4 = n.zWF;
        p.j(localObject3, "it");
        n.a((FinderObject)localObject3, 51);
      }
    }
    localObject1 = duM();
    long l;
    Object localObject5;
    if ((localObject1 != null) && (((b)localObject1).scene == 3))
    {
      localObject1 = n.zWF;
      int i = ((Number)this.xLo.getValue()).intValue();
      localObject4 = (String)this.xLp.getValue();
      p.j(localObject4, "sharedUsername");
      l = duL();
      p.k(localObject4, "fromUser");
      localObject5 = new cg();
      localObject3 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      ((cg)localObject5).lZ((String)localObject1);
      ((cg)localObject5).fe(i);
      ((cg)localObject5).ff(5L);
      ((cg)localObject5).ma((String)localObject4);
      ((cg)localObject5).mf(com.tencent.mm.ae.d.Fw(l));
      ((cg)localObject5).bpa();
      n.a((com.tencent.mm.plugin.report.a)localObject5);
    }
    localObject3 = TAG;
    Object localObject4 = new StringBuilder("[initOnCreate] relatedRequest=");
    localObject1 = duM();
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((b)localObject1).scene);
      localObject1 = ((StringBuilder)localObject4).append(localObject1).append(" getRelatedScene=").append(duJ()).append(" title=");
      localObject4 = this.title;
      if (localObject4 == null) {
        p.bGy("title");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject4).append(' ').append("streamCardId=");
      localObject4 = duK();
      if (localObject4 == null) {
        break label800;
      }
      l = ((bjp)localObject4).id;
      label514:
      localObject4 = ((StringBuilder)localObject1).append(com.tencent.mm.ae.d.Fw(l)).append(" cardId=").append(com.tencent.mm.ae.d.Fw(duL())).append(' ').append("continueAtTheEnd=");
      localObject1 = duK();
      if (localObject1 == null) {
        break label806;
      }
      localObject1 = Boolean.valueOf(((bjp)localObject1).zAC);
      label574:
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" streamCard cardBuffer=");
      localObject5 = duK();
      localObject1 = localObject2;
      if (localObject5 != null) {
        localObject1 = ((bjp)localObject5).xGO;
      }
      if (localObject1 == null) {
        break label812;
      }
    }
    label800:
    label806:
    label812:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i((String)localObject3, bool1);
      localObject1 = duN();
      localObject2 = getIntent();
      p.j(localObject2, "intent");
      ((FinderFeedRelTimelineLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderFeedRelTimelineLoader)localObject1).setInitDone((j)new k((FinderFeedRelTimelineLoader)localObject1, this));
      ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new l(this));
      ((FinderFeedRelTimelineLoader)localObject1).xGJ = ((kotlin.g.a.b)new m((FinderFeedRelTimelineLoader)localObject1, this));
      ((FinderFeedRelTimelineLoader)localObject1).xGK = ((kotlin.g.a.b)new n((FinderFeedRelTimelineLoader)localObject1, this));
      localObject1 = duM();
      if ((localObject1 != null) && (((b)localObject1).scene == 3)) {
        duN().requestRefresh();
      }
      localObject1 = duN();
      localObject2 = duK();
      bool1 = bool2;
      if (localObject2 != null) {
        bool1 = ((bjp)localObject2).zAC;
      }
      ((FinderFeedRelTimelineLoader)localObject1).xGM = bool1;
      AppMethodBeat.o(273912);
      return;
      localObject1 = null;
      break;
      l = 0L;
      break label514;
      localObject1 = null;
      break label574;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$Companion;", "", "()V", "REQUEST_TYPE_SHARE", "", "REQUEST_TYPE_TAB_STREAM", "REQUEST_TYPE_TXT_CARD", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "", "scene", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getScene", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final int scene;
    final avr xGR;
    
    public b(int paramInt, avr paramavr)
    {
      AppMethodBeat.i(281462);
      this.scene = paramInt;
      this.xGR = paramavr;
      AppMethodBeat.o(281462);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(281466);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.scene != paramObject.scene) || (!p.h(this.xGR, paramObject.xGR))) {}
        }
      }
      else
      {
        AppMethodBeat.o(281466);
        return true;
      }
      AppMethodBeat.o(281466);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(281464);
      int j = this.scene;
      avr localavr = this.xGR;
      if (localavr != null) {}
      for (int i = localavr.hashCode();; i = 0)
      {
        AppMethodBeat.o(281464);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(281463);
      String str = "RelatedRequest(scene=" + this.scene + ", request=" + this.xGR + ")";
      AppMethodBeat.o(281463);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Long>
  {
    c(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(279658);
      p.j(paramo, "menu");
      if (paramo.hJO())
      {
        int i = FinderAlbumTimelineUI.c(this.xLs);
        CharSequence localCharSequence = (CharSequence)this.xLs.getContext().getString(b.j.app_share_to_weixin);
        int j = b.i.finder_icons_filled_share;
        AppCompatActivity localAppCompatActivity = this.xLs.getContext();
        p.j(localAppCompatActivity, "context");
        paramo.a(i, localCharSequence, j, localAppCompatActivity.getResources().getColor(b.c.Brand), false);
        paramo.a(FinderAlbumTimelineUI.d(this.xLs), (CharSequence)this.xLs.getContext().getString(b.j.finder_share_timeline), b.i.bottomsheet_icon_moment, 0, false);
      }
      AppMethodBeat.o(279658);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(281500);
      Object localObject1 = FinderAlbumTimelineUI.access$getTAG$cp();
      Object localObject2 = new StringBuilder("[clickMoreMenu] itemId=");
      p.j(paramMenuItem, "menuItem");
      localObject2 = ((StringBuilder)localObject2).append(paramMenuItem.getItemId()).append(" getRelatedScene=").append(FinderAlbumTimelineUI.e(this.xLs)).append(" streamCard=");
      if (FinderAlbumTimelineUI.f(this.xLs) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject1, bool);
        if (paramMenuItem.getItemId() != FinderAlbumTimelineUI.c(this.xLs)) {
          break label312;
        }
        if ((FinderAlbumTimelineUI.e(this.xLs) != 10) && (FinderAlbumTimelineUI.e(this.xLs) != 11)) {
          break label236;
        }
        Object localObject3 = FinderAlbumTimelineUI.f(this.xLs);
        if (localObject3 == null) {
          break;
        }
        paramMenuItem = ac.AEJ;
        localObject1 = (MMActivity)this.xLs;
        localObject2 = FinderAlbumTimelineUI.g(this.xLs);
        p.k(localObject1, "context");
        p.k(localObject3, "card");
        com.tencent.mm.plugin.findersdk.a.d locald = new com.tencent.mm.plugin.findersdk.a.d();
        localObject3 = ac.a.b((bjp)localObject3);
        p.k(localObject3, "<set-?>");
        locald.mbg = ((bja)localObject3);
        ((ac.a)paramMenuItem).a((MMActivity)localObject1, locald, (bid)localObject2);
        AppMethodBeat.o(281500);
        return;
      }
      AppMethodBeat.o(281500);
      return;
      label236:
      if (FinderAlbumTimelineUI.e(this.xLs) == 14)
      {
        paramMenuItem = new com.tencent.mm.plugin.findersdk.a.d();
        localObject1 = this.xLs.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
        if (localObject1 != null) {
          paramMenuItem.mbg.parseFrom((byte[])localObject1);
        }
        ac.AEJ.a((MMActivity)this.xLs, paramMenuItem, FinderAlbumTimelineUI.g(this.xLs));
      }
      AppMethodBeat.o(281500);
      return;
      label312:
      if (paramMenuItem.getItemId() == FinderAlbumTimelineUI.d(this.xLs))
      {
        if ((FinderAlbumTimelineUI.e(this.xLs) == 10) || (FinderAlbumTimelineUI.e(this.xLs) == 11))
        {
          paramMenuItem = new com.tencent.mm.modelsns.c();
          localObject1 = FinderAlbumTimelineUI.f(this.xLs);
          if (localObject1 != null)
          {
            localObject2 = ac.AEJ;
            paramMenuItem.mbg = ac.a.b((bjp)localObject1);
          }
          ac.AEJ.a((MMActivity)this.xLs, paramMenuItem, FinderAlbumTimelineUI.g(this.xLs));
          AppMethodBeat.o(281500);
          return;
        }
        if (FinderAlbumTimelineUI.e(this.xLs) == 14)
        {
          paramMenuItem = new com.tencent.mm.modelsns.c();
          localObject1 = this.xLs.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
          if (localObject1 != null) {
            paramMenuItem.mbg.parseFrom((byte[])localObject1);
          }
          ac.AEJ.a((MMActivity)this.xLs, paramMenuItem, FinderAlbumTimelineUI.g(this.xLs));
        }
      }
      AppMethodBeat.o(281500);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class f
    implements e.b
  {
    f(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(288668);
      n localn = n.zWF;
      n.a(FinderAlbumTimelineUI.h(this.xLs), 0, 3L, "", 0L, FinderAlbumTimelineUI.g(this.xLs));
      AppMethodBeat.o(288668);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<bid>
  {
    g(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<FinderFeedRelTimelineLoader>
  {
    h(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Integer>
  {
    i(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<Integer>
  {
    j(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class k
    implements j
  {
    k(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(272272);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = (FrameLayout)jdField_this._$_findCachedViewById(b.f.emptyView);
        p.j(localObject, "emptyView");
        ((FrameLayout)localObject).setVisibility(0);
      }
      for (;;)
      {
        localObject = FinderAlbumTimelineUI.b(jdField_this).xvJ.getRecyclerView().getLayoutManager();
        if (localObject == null) {
          break label126;
        }
        if (localObject != null) {
          break;
        }
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(272272);
        throw ((Throwable)localObject);
        localObject = (FrameLayout)jdField_this._$_findCachedViewById(b.f.emptyView);
        p.j(localObject, "emptyView");
        ((FrameLayout)localObject).setVisibility(8);
      }
      ((FinderLinearLayoutManager)localObject).au(this.xLu.getInitPos(), 0);
      AppMethodBeat.o(272272);
      return;
      label126:
      AppMethodBeat.o(272272);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$2"})
  static final class l
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    l(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$3"})
  static final class m
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    m(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$4"})
  static final class n
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    n(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(291536);
      FinderAlbumTimelineUI.a(this.xLs);
      AppMethodBeat.o(291536);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<n.a>
  {
    p(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<FinderAlbumTimelineUI.b>
  {
    q(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<String>
  {
    r(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<bjp>
  {
    s(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<Integer>
  {
    t(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<n.b>
  {
    u(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI
 * JD-Core Version:    0.7.0.1
 */