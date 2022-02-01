package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "MENU_ID_SHARE_TO_CHAT", "", "MENU_ID_SHARE_TO_SNS", "cardId", "", "getCardId", "()J", "cardId$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "feedLoader$delegate", "fromShareScene", "getFromShareScene", "()I", "fromShareScene$delegate", "getRelatedScene", "getGetRelatedScene", "getRelatedScene$delegate", "p", "getP", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "p$delegate", "relatedRequest", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "getRelatedRequest", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "relatedRequest$delegate", "sharedUsername", "", "kotlin.jvm.PlatformType", "getSharedUsername", "()Ljava/lang/String;", "sharedUsername$delegate", "streamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getStreamCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "streamCard$delegate", "title", "txtCardIndex", "getTxtCardIndex", "txtCardIndex$delegate", "vc", "getVc", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "vc$delegate", "clickMoreMenu", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "Companion", "RelatedRequest", "plugin-finder_release"})
public final class FinderAlbumTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a>
{
  private static final String TAG = "Finder.AlbumTimelineUI";
  public static final a tZc;
  private HashMap _$_findViewCache;
  private final f tPy;
  private final f tYS;
  private final f tYT;
  private final f tYU;
  private final f tYV;
  private final f tYW;
  private final f tYX;
  private final f tYY;
  private final f tYZ;
  private final f tZa;
  private final f tZb;
  private String title;
  private final int tqv;
  private final int tzY;
  
  static
  {
    AppMethodBeat.i(245078);
    tZc = new a((byte)0);
    TAG = "Finder.AlbumTimelineUI";
    AppMethodBeat.o(245078);
  }
  
  public FinderAlbumTimelineUI()
  {
    AppMethodBeat.i(245077);
    this.tYS = kotlin.g.ah((kotlin.g.a.a)new p(this));
    this.tYT = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.tYU = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.tYV = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.tYW = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.tYX = kotlin.g.ah((kotlin.g.a.a)new t(this));
    this.tYY = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.tYZ = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.tZa = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.tZb = kotlin.g.ah((kotlin.g.a.a)new q(this));
    this.tPy = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.tqv = 101;
    this.tzY = 102;
    AppMethodBeat.o(245077);
  }
  
  private final m.a ddD()
  {
    AppMethodBeat.i(245066);
    m.a locala = (m.a)this.tYS.getValue();
    AppMethodBeat.o(245066);
    return locala;
  }
  
  private final m.b ddE()
  {
    AppMethodBeat.i(245067);
    m.b localb = (m.b)this.tYT.getValue();
    AppMethodBeat.o(245067);
    return localb;
  }
  
  private final int ddF()
  {
    AppMethodBeat.i(245068);
    int i = ((Number)this.tYV.getValue()).intValue();
    AppMethodBeat.o(245068);
    return i;
  }
  
  private final bcu ddG()
  {
    AppMethodBeat.i(245069);
    bcu localbcu = (bcu)this.tYW.getValue();
    AppMethodBeat.o(245069);
    return localbcu;
  }
  
  private final long ddH()
  {
    AppMethodBeat.i(245070);
    long l = ((Number)this.tYY.getValue()).longValue();
    AppMethodBeat.o(245070);
    return l;
  }
  
  private final b ddI()
  {
    AppMethodBeat.i(245071);
    b localb = (b)this.tZb.getValue();
    AppMethodBeat.o(245071);
    return localb;
  }
  
  private final FinderFeedRelTimelineLoader ddJ()
  {
    AppMethodBeat.i(245072);
    FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = (FinderFeedRelTimelineLoader)this.tPy.getValue();
    AppMethodBeat.o(245072);
    return localFinderFeedRelTimelineLoader;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245090);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245090);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245089);
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
    AppMethodBeat.o(245089);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 51;
  }
  
  public final int getLayoutId()
  {
    return 2131494299;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    boolean bool2 = true;
    AppMethodBeat.i(245073);
    Object localObject3 = getIntent().getStringExtra("TITLE_WORDING");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    localObject1 = this.title;
    if (localObject1 == null) {
      p.btv("title");
    }
    setMMTitle((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dvy().value()).intValue() == 1) {
      addIconOptionMenu(0, 2131690843, (MenuItem.OnMenuItemClickListener)new o(this));
    }
    localObject1 = ddG();
    if (localObject1 != null)
    {
      localObject3 = e.vFX;
      localObject3 = ((bcu)localObject1).object;
      p.g(localObject3, "it.`object`");
      e.a.k(51, (List)localObject3);
      localObject1 = ((bcu)localObject1).object;
      p.g(localObject1, "it.`object`");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject1).next();
        localObject4 = k.vfA;
        k.e(((FinderObject)localObject3).id, 51, ((FinderObject)localObject3).sessionBuffer);
      }
    }
    localObject1 = ddI();
    long l;
    Object localObject5;
    if ((localObject1 != null) && (((b)localObject1).scene == 3))
    {
      localObject1 = k.vfA;
      int i = ((Number)this.tYZ.getValue()).intValue();
      localObject4 = (String)this.tZa.getValue();
      p.g(localObject4, "sharedUsername");
      l = ddH();
      p.h(localObject4, "fromUser");
      localObject5 = new bq();
      localObject3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      ((bq)localObject5).jP((String)localObject1);
      ((bq)localObject5).eq(i);
      ((bq)localObject5).er(5L);
      ((bq)localObject5).jQ((String)localObject4);
      ((bq)localObject5).jV(com.tencent.mm.ac.d.zs(l));
      ((bq)localObject5).bfK();
      k.a((com.tencent.mm.plugin.report.a)localObject5);
    }
    localObject3 = TAG;
    Object localObject4 = new StringBuilder("[initOnCreate] relatedRequest=");
    localObject1 = ddI();
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((b)localObject1).scene);
      localObject1 = ((StringBuilder)localObject4).append(localObject1).append(" getRelatedScene=").append(ddF()).append(" title=");
      localObject4 = this.title;
      if (localObject4 == null) {
        p.btv("title");
      }
      localObject1 = ((StringBuilder)localObject1).append((String)localObject4).append(' ').append("streamCardId=");
      localObject4 = ddG();
      if (localObject4 == null) {
        break label800;
      }
      l = ((bcu)localObject4).id;
      label514:
      localObject4 = ((StringBuilder)localObject1).append(com.tencent.mm.ac.d.zs(l)).append(" cardId=").append(com.tencent.mm.ac.d.zs(ddH())).append(' ').append("continueAtTheEnd=");
      localObject1 = ddG();
      if (localObject1 == null) {
        break label806;
      }
      localObject1 = Boolean.valueOf(((bcu)localObject1).uOm);
      label574:
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" streamCard cardBuffer=");
      localObject5 = ddG();
      localObject1 = localObject2;
      if (localObject5 != null) {
        localObject1 = ((bcu)localObject5).tVe;
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
      localObject1 = ddJ();
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderFeedRelTimelineLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderFeedRelTimelineLoader)localObject1).setInitDone((h)new k((FinderFeedRelTimelineLoader)localObject1, this));
      ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new l(this));
      ((FinderFeedRelTimelineLoader)localObject1).tVa = ((kotlin.g.a.b)new m((FinderFeedRelTimelineLoader)localObject1, this));
      ((FinderFeedRelTimelineLoader)localObject1).tVb = ((kotlin.g.a.b)new n((FinderFeedRelTimelineLoader)localObject1, this));
      localObject1 = ddI();
      if ((localObject1 != null) && (((b)localObject1).scene == 3)) {
        ddJ().requestRefresh();
      }
      localObject1 = ddJ();
      localObject2 = ddG();
      bool1 = bool2;
      if (localObject2 != null) {
        bool1 = ((bcu)localObject2).uOm;
      }
      ((FinderFeedRelTimelineLoader)localObject1).tVc = bool1;
      AppMethodBeat.o(245073);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$Companion;", "", "()V", "REQUEST_TYPE_SHARE", "", "REQUEST_TYPE_TAB_STREAM", "REQUEST_TYPE_TXT_CARD", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "", "scene", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getScene", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final int scene;
    final ato tta;
    
    public b(int paramInt, ato paramato)
    {
      AppMethodBeat.i(245042);
      this.scene = paramInt;
      this.tta = paramato;
      AppMethodBeat.o(245042);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(245045);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.scene != paramObject.scene) || (!p.j(this.tta, paramObject.tta))) {}
        }
      }
      else
      {
        AppMethodBeat.o(245045);
        return true;
      }
      AppMethodBeat.o(245045);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(245044);
      int j = this.scene;
      ato localato = this.tta;
      if (localato != null) {}
      for (int i = localato.hashCode();; i = 0)
      {
        AppMethodBeat.o(245044);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245043);
      String str = "RelatedRequest(scene=" + this.scene + ", request=" + this.tta + ")";
      AppMethodBeat.o(245043);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Long>
  {
    c(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    d(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(245047);
      p.g(paramm, "menu");
      if (paramm.gKQ())
      {
        int i = FinderAlbumTimelineUI.c(this.tZd);
        CharSequence localCharSequence = (CharSequence)this.tZd.getContext().getString(2131755985);
        AppCompatActivity localAppCompatActivity = this.tZd.getContext();
        p.g(localAppCompatActivity, "context");
        paramm.a(i, localCharSequence, 2131690251, localAppCompatActivity.getResources().getColor(2131099710), false);
        paramm.a(FinderAlbumTimelineUI.d(this.tZd), (CharSequence)this.tZd.getContext().getString(2131760572), 2131689830, 0, false);
      }
      AppMethodBeat.o(245047);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements o.g
  {
    e(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245048);
      Object localObject1 = FinderAlbumTimelineUI.access$getTAG$cp();
      Object localObject2 = new StringBuilder("[clickMoreMenu] itemId=");
      p.g(paramMenuItem, "menuItem");
      localObject2 = ((StringBuilder)localObject2).append(paramMenuItem.getItemId()).append(" getRelatedScene=").append(FinderAlbumTimelineUI.e(this.tZd)).append(" streamCard=");
      if (FinderAlbumTimelineUI.f(this.tZd) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject1, bool);
        if (paramMenuItem.getItemId() != FinderAlbumTimelineUI.c(this.tZd)) {
          break label312;
        }
        if ((FinderAlbumTimelineUI.e(this.tZd) != 10) && (FinderAlbumTimelineUI.e(this.tZd) != 11)) {
          break label236;
        }
        Object localObject3 = FinderAlbumTimelineUI.f(this.tZd);
        if (localObject3 == null) {
          break;
        }
        paramMenuItem = s.vWt;
        localObject1 = (MMActivity)this.tZd;
        localObject2 = FinderAlbumTimelineUI.g(this.tZd);
        p.h(localObject1, "context");
        p.h(localObject3, "card");
        com.tencent.mm.plugin.i.a.d locald = new com.tencent.mm.plugin.i.a.d();
        localObject3 = s.a.b((bcu)localObject3);
        p.h(localObject3, "<set-?>");
        locald.jle = ((bcf)localObject3);
        ((s.a)paramMenuItem).a((MMActivity)localObject1, locald, (bbn)localObject2);
        AppMethodBeat.o(245048);
        return;
      }
      AppMethodBeat.o(245048);
      return;
      label236:
      if (FinderAlbumTimelineUI.e(this.tZd) == 14)
      {
        paramMenuItem = new com.tencent.mm.plugin.i.a.d();
        localObject1 = this.tZd.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
        if (localObject1 != null) {
          paramMenuItem.jle.parseFrom((byte[])localObject1);
        }
        s.vWt.a((MMActivity)this.tZd, paramMenuItem, FinderAlbumTimelineUI.g(this.tZd));
      }
      AppMethodBeat.o(245048);
      return;
      label312:
      if (paramMenuItem.getItemId() == FinderAlbumTimelineUI.d(this.tZd))
      {
        if ((FinderAlbumTimelineUI.e(this.tZd) == 10) || (FinderAlbumTimelineUI.e(this.tZd) == 11))
        {
          paramMenuItem = new com.tencent.mm.modelsns.c();
          localObject1 = FinderAlbumTimelineUI.f(this.tZd);
          if (localObject1 != null)
          {
            localObject2 = s.vWt;
            paramMenuItem.jle = s.a.b((bcu)localObject1);
          }
          s.vWt.a((MMActivity)this.tZd, paramMenuItem, FinderAlbumTimelineUI.g(this.tZd));
          AppMethodBeat.o(245048);
          return;
        }
        if (FinderAlbumTimelineUI.e(this.tZd) == 14)
        {
          paramMenuItem = new com.tencent.mm.modelsns.c();
          localObject1 = this.tZd.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
          if (localObject1 != null) {
            paramMenuItem.jle.parseFrom((byte[])localObject1);
          }
          s.vWt.a((MMActivity)this.tZd, paramMenuItem, FinderAlbumTimelineUI.g(this.tZd));
        }
      }
      AppMethodBeat.o(245048);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class f
    implements e.b
  {
    f(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(245049);
      k localk = k.vfA;
      k.a(FinderAlbumTimelineUI.h(this.tZd), 0, 3L, "", 0L, FinderAlbumTimelineUI.g(this.tZd));
      AppMethodBeat.o(245049);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<bbn>
  {
    g(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<FinderFeedRelTimelineLoader>
  {
    h(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Integer>
  {
    i(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<Integer>
  {
    j(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class k
    implements h
  {
    k(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245055);
      Object localObject;
      if (paramInt == 0)
      {
        localObject = (FrameLayout)jdField_this._$_findCachedViewById(2131300078);
        p.g(localObject, "emptyView");
        ((FrameLayout)localObject).setVisibility(0);
      }
      for (;;)
      {
        localObject = FinderAlbumTimelineUI.b(jdField_this).tLS.getRecyclerView().getLayoutManager();
        if (localObject == null) {
          break label124;
        }
        if (localObject != null) {
          break;
        }
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
        AppMethodBeat.o(245055);
        throw ((Throwable)localObject);
        localObject = (FrameLayout)jdField_this._$_findCachedViewById(2131300078);
        p.g(localObject, "emptyView");
        ((FrameLayout)localObject).setVisibility(8);
      }
      ((FinderLinearLayoutManager)localObject).ah(this.tZf.getInitPos(), 0);
      AppMethodBeat.o(245055);
      return;
      label124:
      AppMethodBeat.o(245055);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$2"})
  static final class l
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    l(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$3"})
  static final class m
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    m(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$4"})
  static final class n
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    n(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(FinderAlbumTimelineUI paramFinderAlbumTimelineUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245059);
      FinderAlbumTimelineUI.a(this.tZd);
      AppMethodBeat.o(245059);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<m.a>
  {
    p(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<FinderAlbumTimelineUI.b>
  {
    q(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<String>
  {
    r(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<bcu>
  {
    s(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<Integer>
  {
    t(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<m.b>
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