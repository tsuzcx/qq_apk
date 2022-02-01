package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "MENU_ID_SHARE_TO_CHAT", "", "MENU_ID_SHARE_TO_SNS", "cardId", "", "getCardId", "()J", "cardId$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "feedLoader", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$feedLoader$2$1", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$feedLoader$2$1;", "feedLoader$delegate", "fromShareScene", "getFromShareScene", "()I", "fromShareScene$delegate", "getRelatedScene", "getGetRelatedScene", "getRelatedScene$delegate", "p", "getP", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "p$delegate", "relatedRequest", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "getRelatedRequest", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "relatedRequest$delegate", "sharedUsername", "", "getSharedUsername", "()Ljava/lang/String;", "sharedUsername$delegate", "streamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getStreamCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "streamCard$delegate", "title", "txtCardIndex", "getTxtCardIndex", "txtCardIndex$delegate", "vc", "getVc", "()Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "vc$delegate", "clickMoreMenu", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "Companion", "RelatedRequest", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAlbumTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a>
{
  public static final a Bla;
  private static final String TAG;
  private final kotlin.j AYa;
  private final int Auf;
  private final kotlin.j Blb;
  private final kotlin.j Blc;
  private final kotlin.j Bld;
  private final kotlin.j Ble;
  private final kotlin.j Blf;
  private final kotlin.j Blg;
  private final kotlin.j Blh;
  private final kotlin.j Bli;
  private final kotlin.j Blj;
  private final kotlin.j Blk;
  private final int Bll;
  private String title;
  
  static
  {
    AppMethodBeat.i(365477);
    Bla = new a((byte)0);
    TAG = "Finder.AlbumTimelineUI";
    AppMethodBeat.o(365477);
  }
  
  public FinderAlbumTimelineUI()
  {
    AppMethodBeat.i(365328);
    this.Blb = k.cm((kotlin.g.a.a)new l(this));
    this.Blc = k.cm((kotlin.g.a.a)new q(this));
    this.Bld = k.cm((kotlin.g.a.a)new d(this));
    this.Ble = k.cm((kotlin.g.a.a)new g(this));
    this.Blf = k.cm((kotlin.g.a.a)new o(this));
    this.Blg = k.cm((kotlin.g.a.a)new p(this));
    this.Blh = k.cm((kotlin.g.a.a)new c(this));
    this.Bli = k.cm((kotlin.g.a.a)new f(this));
    this.Blj = k.cm((kotlin.g.a.a)new n(this));
    this.Blk = k.cm((kotlin.g.a.a)new m(this));
    this.AYa = k.cm((kotlin.g.a.a)new e(this));
    this.Auf = 101;
    this.Bll = 102;
    AppMethodBeat.o(365328);
  }
  
  private static final void a(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
  {
    AppMethodBeat.i(365422);
    kotlin.g.b.s.u(paramFinderAlbumTimelineUI, "this$0");
    z localz = z.FrZ;
    z.a(paramFinderAlbumTimelineUI.een(), 0, 3L, "", 0L, paramFinderAlbumTimelineUI.getContextObj());
    AppMethodBeat.o(365422);
  }
  
  private static final void a(FinderAlbumTimelineUI paramFinderAlbumTimelineUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(365416);
    kotlin.g.b.s.u(paramFinderAlbumTimelineUI, "this$0");
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder("[clickMoreMenu] itemId=").append(paramMenuItem.getItemId()).append(" getRelatedScene=").append(paramFinderAlbumTimelineUI.eel()).append(" streamCard=");
    if (paramFinderAlbumTimelineUI.eem() != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject1, bool);
      if (paramMenuItem.getItemId() != paramFinderAlbumTimelineUI.Auf) {
        break label267;
      }
      if ((paramFinderAlbumTimelineUI.eel() != 10) && (paramFinderAlbumTimelineUI.eel() != 11)) {
        break;
      }
      paramMenuItem = paramFinderAlbumTimelineUI.eem();
      if (paramMenuItem == null) {
        break label416;
      }
      localObject1 = an.GhR;
      localObject1 = (MMActivity)paramFinderAlbumTimelineUI;
      paramFinderAlbumTimelineUI = paramFinderAlbumTimelineUI.getContextObj();
      kotlin.g.b.s.u(localObject1, "context");
      kotlin.g.b.s.u(paramMenuItem, "card");
      localObject2 = new com.tencent.mm.plugin.findersdk.a.d();
      paramMenuItem = an.a.b(paramMenuItem);
      kotlin.g.b.s.u(paramMenuItem, "<set-?>");
      ((com.tencent.mm.plugin.findersdk.a.d)localObject2).oUa = paramMenuItem;
      an.a.a((MMActivity)localObject1, (com.tencent.mm.plugin.findersdk.a.d)localObject2, paramFinderAlbumTimelineUI);
      AppMethodBeat.o(365416);
      return;
    }
    if (paramFinderAlbumTimelineUI.eel() == 14)
    {
      paramMenuItem = new com.tencent.mm.plugin.findersdk.a.d();
      localObject1 = paramFinderAlbumTimelineUI.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
      if (localObject1 != null) {
        paramMenuItem.oUa.parseFrom((byte[])localObject1);
      }
      localObject1 = an.GhR;
      an.a.a((MMActivity)paramFinderAlbumTimelineUI, paramMenuItem, paramFinderAlbumTimelineUI.getContextObj());
      AppMethodBeat.o(365416);
      return;
      label267:
      if (paramMenuItem.getItemId() == paramFinderAlbumTimelineUI.Bll)
      {
        if ((paramFinderAlbumTimelineUI.eel() == 10) || (paramFinderAlbumTimelineUI.eel() == 11))
        {
          paramMenuItem = new c();
          localObject1 = paramFinderAlbumTimelineUI.eem();
          if (localObject1 != null)
          {
            localObject2 = an.GhR;
            paramMenuItem.oUa = an.a.b((bwa)localObject1);
          }
          localObject1 = an.GhR;
          an.a.a((MMActivity)paramFinderAlbumTimelineUI, paramMenuItem, paramFinderAlbumTimelineUI.getContextObj());
          AppMethodBeat.o(365416);
          return;
        }
        if (paramFinderAlbumTimelineUI.eel() == 14)
        {
          paramMenuItem = new c();
          localObject1 = paramFinderAlbumTimelineUI.getIntent().getByteArrayExtra("FINDER_SHARE_ALBUM");
          if (localObject1 != null) {
            paramMenuItem.oUa.parseFrom((byte[])localObject1);
          }
          localObject1 = an.GhR;
          an.a.a((MMActivity)paramFinderAlbumTimelineUI, paramMenuItem, paramFinderAlbumTimelineUI.getContextObj());
        }
      }
    }
    label416:
    AppMethodBeat.o(365416);
  }
  
  private static final void a(FinderAlbumTimelineUI paramFinderAlbumTimelineUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(365402);
    kotlin.g.b.s.u(paramFinderAlbumTimelineUI, "this$0");
    if (params.jmw())
    {
      params.a(paramFinderAlbumTimelineUI.Auf, (CharSequence)paramFinderAlbumTimelineUI.getContext().getString(e.h.app_share_to_weixin), e.g.finder_icons_filled_share, paramFinderAlbumTimelineUI.getContext().getResources().getColor(e.b.Brand), false);
      params.a(paramFinderAlbumTimelineUI.Bll, (CharSequence)paramFinderAlbumTimelineUI.getContext().getString(e.h.finder_share_timeline), e.g.bottomsheet_icon_moment, 0, false);
    }
    AppMethodBeat.o(365402);
  }
  
  private static final boolean a(FinderAlbumTimelineUI paramFinderAlbumTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365395);
    kotlin.g.b.s.u(paramFinderAlbumTimelineUI, "this$0");
    paramMenuItem = new f((Context)paramFinderAlbumTimelineUI, 0, false);
    paramMenuItem.Vtg = new FinderAlbumTimelineUI..ExternalSyntheticLambda1(paramFinderAlbumTimelineUI);
    paramMenuItem.GAC = new FinderAlbumTimelineUI..ExternalSyntheticLambda2(paramFinderAlbumTimelineUI);
    paramMenuItem.aeLi = new FinderAlbumTimelineUI..ExternalSyntheticLambda3(paramFinderAlbumTimelineUI);
    paramMenuItem.dDn();
    AppMethodBeat.o(365395);
    return true;
  }
  
  private final m.a eej()
  {
    AppMethodBeat.i(365334);
    m.a locala = (m.a)this.Blb.getValue();
    AppMethodBeat.o(365334);
    return locala;
  }
  
  private final m.b eek()
  {
    AppMethodBeat.i(365344);
    m.b localb = (m.b)this.Blc.getValue();
    AppMethodBeat.o(365344);
    return localb;
  }
  
  private final int eel()
  {
    AppMethodBeat.i(365357);
    int i = ((Number)this.Ble.getValue()).intValue();
    AppMethodBeat.o(365357);
    return i;
  }
  
  private final bwa eem()
  {
    AppMethodBeat.i(365364);
    bwa localbwa = (bwa)this.Blf.getValue();
    AppMethodBeat.o(365364);
    return localbwa;
  }
  
  private final long een()
  {
    AppMethodBeat.i(365372);
    long l = ((Number)this.Blh.getValue()).longValue();
    AppMethodBeat.o(365372);
    return l;
  }
  
  private final b eeo()
  {
    AppMethodBeat.i(365379);
    b localb = (b)this.Blk.getValue();
    AppMethodBeat.o(365379);
    return localb;
  }
  
  private final feedLoader.2.1 eep()
  {
    AppMethodBeat.i(365388);
    FinderFeedRelTimelineLoader local1 = (feedLoader.2.1)this.AYa.getValue();
    AppMethodBeat.o(365388);
    return local1;
  }
  
  private final bui getContextObj()
  {
    AppMethodBeat.i(365351);
    bui localbui = (bui)this.Bld.getValue();
    AppMethodBeat.o(365351);
    return localbui;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 51;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_feed_related_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    int j = 0;
    Object localObject2 = null;
    boolean bool2 = true;
    AppMethodBeat.i(365519);
    Object localObject3 = getIntent().getStringExtra("TITLE_WORDING");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    localObject3 = this.title;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("title");
      localObject1 = null;
    }
    setMMTitle((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUI().bmg()).intValue() == 1) {
      addIconOptionMenu(0, e.g.icons_outlined_more, new FinderAlbumTimelineUI..ExternalSyntheticLambda0(this));
    }
    localObject1 = eem();
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = e.FMN;
      localObject3 = ((bwa)localObject1).object;
      kotlin.g.b.s.s(localObject3, "it.`object`");
      e.a.H(51, (List)localObject3);
      localObject1 = ((bwa)localObject1).object;
      kotlin.g.b.s.s(localObject1, "it.`object`");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject1).next();
        localObject4 = z.FrZ;
        kotlin.g.b.s.s(localObject3, "it");
        z.a((FinderObject)localObject3, 51);
      }
    }
    localObject1 = eeo();
    int i;
    long l;
    if ((localObject1 != null) && (((b)localObject1).scene == 3))
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = z.FrZ;
        i = ((Number)this.Bli.getValue()).intValue();
        localObject4 = (String)this.Blj.getValue();
        kotlin.g.b.s.checkNotNull(localObject4);
        kotlin.g.b.s.s(localObject4, "sharedUsername!!");
        l = een();
        kotlin.g.b.s.u(localObject4, "fromUser");
        localObject5 = new dh();
        localObject3 = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((dh)localObject5).ni((String)localObject1);
        ((dh)localObject5).izg = i;
        ((dh)localObject5).izh = 5L;
        ((dh)localObject5).nj((String)localObject4);
        ((dh)localObject5).izo = ((dh)localObject5).F("ColumnId", com.tencent.mm.ae.d.hF(l), true);
        ((dh)localObject5).bMH();
        z.a((com.tencent.mm.plugin.report.a)localObject5);
      }
      localObject4 = TAG;
      localObject3 = new StringBuilder("[initOnCreate] relatedRequest=");
      localObject1 = eeo();
      if (localObject1 != null) {
        break label800;
      }
      localObject1 = null;
      label448:
      Object localObject5 = ((StringBuilder)localObject3).append(localObject1).append(" getRelatedScene=").append(eel()).append(" title=");
      localObject3 = this.title;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("title");
        localObject1 = null;
      }
      localObject1 = ((StringBuilder)localObject5).append((String)localObject1).append(" streamCardId=");
      localObject3 = eem();
      if (localObject3 != null) {
        break label813;
      }
      l = 0L;
      label529:
      localObject3 = ((StringBuilder)localObject1).append(com.tencent.mm.ae.d.hF(l)).append(" cardId=").append(com.tencent.mm.ae.d.hF(een())).append(" continueAtTheEnd=");
      localObject1 = eem();
      if (localObject1 != null) {
        break label823;
      }
      localObject1 = null;
      label577:
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" streamCard cardBuffer=");
      localObject1 = eem();
      if (localObject1 != null) {
        break label836;
      }
      localObject1 = localObject2;
      label607:
      if (localObject1 == null) {
        break label846;
      }
      bool1 = true;
      label614:
      Log.i((String)localObject4, bool1);
      localObject1 = eep();
      localObject2 = getIntent();
      kotlin.g.b.s.s(localObject2, "intent");
      ((feedLoader.2.1)localObject1).initFromCache((Intent)localObject2);
      ((feedLoader.2.1)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new h(this, (feedLoader.2.1)localObject1));
      ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new i(this));
      ((FinderFeedRelTimelineLoader)localObject1).BfX = ((kotlin.g.a.b)new j((feedLoader.2.1)localObject1, this));
      ((FinderFeedRelTimelineLoader)localObject1).BfY = ((kotlin.g.a.b)new k((feedLoader.2.1)localObject1, this));
      localObject1 = eeo();
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((b)localObject1).scene == 3) {
          i = 1;
        }
      }
      if (i != 0) {
        eep().requestRefresh();
      }
      localObject1 = eep();
      localObject2 = eem();
      if (localObject2 != null) {
        break label851;
      }
    }
    label800:
    label813:
    label823:
    label836:
    label846:
    label851:
    for (boolean bool1 = bool2;; bool1 = ((bwa)localObject2).ECL)
    {
      ((FinderFeedRelTimelineLoader)localObject1).BfS = bool1;
      AppMethodBeat.o(365519);
      return;
      i = 0;
      break;
      localObject1 = Integer.valueOf(((b)localObject1).scene);
      break label448;
      l = ((bwa)localObject3).id;
      break label529;
      localObject1 = Boolean.valueOf(((bwa)localObject1).ECL);
      break label577;
      localObject1 = ((bwa)localObject1).AEA;
      break label607;
      bool1 = false;
      break label614;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$Companion;", "", "()V", "REQUEST_TYPE_SHARE", "", "REQUEST_TYPE_TAB_STREAM", "REQUEST_TYPE_TXT_CARD", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;", "", "scene", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "(ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getScene", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final bav BfW;
    final int scene;
    
    public b(int paramInt, bav parambav)
    {
      AppMethodBeat.i(364660);
      this.scene = paramInt;
      this.BfW = parambav;
      AppMethodBeat.o(364660);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(364692);
      if (this == paramObject)
      {
        AppMethodBeat.o(364692);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(364692);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.scene != paramObject.scene)
      {
        AppMethodBeat.o(364692);
        return false;
      }
      if (!kotlin.g.b.s.p(this.BfW, paramObject.BfW))
      {
        AppMethodBeat.o(364692);
        return false;
      }
      AppMethodBeat.o(364692);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(364680);
      int i = this.scene;
      int j = this.BfW.hashCode();
      AppMethodBeat.o(364680);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(364670);
      String str = "RelatedRequest(scene=" + this.scene + ", request=" + this.BfW + ')';
      AppMethodBeat.o(364670);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Long>
  {
    c(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<bui>
  {
    d(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$feedLoader$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<FinderAlbumTimelineUI.feedLoader.2.1>
  {
    e(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    f(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Integer>
  {
    g(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$initOnCreate$3$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    h(FinderAlbumTimelineUI paramFinderAlbumTimelineUI, FinderAlbumTimelineUI.feedLoader.2.1 param1) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364598);
      if (paramInt == 0) {
        ((FrameLayout)this.Blm.findViewById(e.e.emptyView)).setVisibility(0);
      }
      for (;;)
      {
        RecyclerView.LayoutManager localLayoutManager = FinderAlbumTimelineUI.b(this.Blm).ATx.getRecyclerView().getLayoutManager();
        if (localLayoutManager != null)
        {
          FinderAlbumTimelineUI.feedLoader.2.1 local1 = this.Bln;
          ((FinderLinearLayoutManager)localLayoutManager).bo(local1.getInitPos(), 0);
        }
        AppMethodBeat.o(364598);
        return;
        ((FrameLayout)this.Blm.findViewById(e.e.emptyView)).setVisibility(8);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    i(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    j(FinderAlbumTimelineUI.feedLoader.2.1 param1, FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    k(FinderAlbumTimelineUI.feedLoader.2.1 param1, FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<m.a>
  {
    l(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$RelatedRequest;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<FinderAlbumTimelineUI.b>
  {
    m(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<String>
  {
    n(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<bwa>
  {
    o(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<Integer>
  {
    p(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<m.b>
  {
    q(FinderAlbumTimelineUI paramFinderAlbumTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI
 * JD-Core Version:    0.7.0.1
 */