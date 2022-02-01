package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.b;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.cc;>;
import com.tencent.mm.plugin.finder.feed.model.internal.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fkp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;I)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "exposeItem", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "isEnablePreloadRefreshContent", "", "()Z", "isEnablePreloadRefreshContent$delegate", "Lkotlin/Lazy;", "isPreloadContenting", "isRefreshing", "itemView", "Landroid/view/View;", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1;", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Lkotlin/collections/ArrayList;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshContentPreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1;", "singleTaskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "viewRect", "fetchContent", "", "isRefresh", "item", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "call", "Lkotlin/Function1;", "genStat", "getLayoutId", "isViewExposed", "view", "jumpRelatedTimelineUI", "context", "Landroid/content/Context;", "action", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "preloadContent", "reportStat", "Companion", "ExposeItem", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cq
  extends com.tencent.mm.view.recyclerview.f<au>
{
  public static final a AMr;
  private b AMA;
  private boolean AMB;
  private final com.tencent.mm.plugin.finder.feed.bg AMs;
  private final kotlin.j AMt;
  private final kotlin.j AMu;
  private final com.tencent.mm.loader.f.h AMv;
  private final q<cc> AMw;
  private final Rect AMx;
  private final k AMy;
  private final FinderStreamCardAlbumConvert.lifecycleObserver.1 AMz;
  private bui Auc;
  private View caK;
  private final int hJx;
  private boolean isRefreshing;
  private RecyclerView mkw;
  private final ArrayList<dji> ofu;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(350098);
    AMr = new a((byte)0);
    AppMethodBeat.o(350098);
  }
  
  public cq(com.tencent.mm.plugin.finder.feed.bg parambg, int paramInt)
  {
    AppMethodBeat.i(349927);
    this.AMs = parambg;
    this.hJx = paramInt;
    this.AMt = kotlin.k.cm((kotlin.g.a.a)j.AMP);
    this.AMu = kotlin.k.cm((kotlin.g.a.a)d.AML);
    parambg = new com.tencent.mm.loader.f.h("StreamCardFeedLoader");
    parambg.start();
    ah localah = ah.aiuX;
    this.AMv = parambg;
    this.AMw = new q((byte)0);
    parambg = new ArrayList(4);
    paramInt = 0;
    int i;
    do
    {
      i = paramInt + 1;
      parambg.add(new dji());
      paramInt = i;
    } while (i < 4);
    localah = ah.aiuX;
    this.ofu = parambg;
    this.viewRect = new Rect();
    this.AMx = new Rect();
    this.AMy = new k(this);
    this.AMz = new FinderStreamCardAlbumConvert.lifecycleObserver.1(this);
    this.AMA = new b();
    AppMethodBeat.o(349927);
  }
  
  private final fhp a(au paramau)
  {
    AppMethodBeat.i(349942);
    fhp localfhp = new fhp();
    localfhp.abIi = new fvu();
    localfhp.abIh = new ni();
    localfhp.abIj = new dzj();
    localfhp.hKN = paramau.AYW.id;
    localfhp.sessionBuffer = paramau.AYW.sessionBuffer;
    av localav = av.GiL;
    localfhp.AJo = av.Uc(this.hJx);
    localfhp.finderUsername = z.bAW();
    localfhp.abIn = paramau.AYY;
    localfhp.abIk = cn.bDw();
    localfhp.mediaType = 11;
    AppMethodBeat.o(349942);
    return localfhp;
  }
  
  private final void a(Context paramContext, int paramInt, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(349971);
    au localau = (au)paramj.CSA;
    LinkedList localLinkedList = localau.rvFeedList;
    if (!Util.isNullOrNil((List)localLinkedList))
    {
      int i = this.AMs.AZs.getDataListJustForAdapter().indexOf(localau);
      paramj = aj.FtF;
      Object localObject1 = localau.AYW.Wqu;
      paramj = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 == null) {
        paramj = "";
      }
      long l1 = localau.AYW.id;
      long l2 = ((BaseFinderFeed)localLinkedList.get(0)).bZA();
      Object localObject2 = this.Auc;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("contextObj");
        localObject1 = null;
      }
      aj.a(paramj, l1, paramInt, l2, (bui)localObject1, i);
      Log.i("Finder.FinderStreamCardAlbumConvert", "[jumpRelatedTimelineUI] parentIndex=" + i + " cardBuffer=" + localau.AYW.AEA);
      if (((BaseFinderFeed)localLinkedList.get(0)).bZA() == 0L)
      {
        AppMethodBeat.o(349971);
        return;
      }
      paramj = new Intent();
      paramj.putExtra("TITLE_WORDING", localau.AYW.Wqu);
      paramj.putExtra("CARD_ID", localau.AYW.id);
      paramj.putExtra("GET_REL_SCENE", localau.AYW.aadQ);
      paramj.putExtra("STREAM_CARD", localau.AYW.toByteArray());
      paramj.putExtra("COMMENT_SCENE", 51);
      localObject1 = new LinkedList((Collection)localLinkedList);
      localObject2 = av.GiL;
      av.a(0, (List)localObject1, localau.AYW.AEA, paramj);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterAlbumRelatedTimelineUI(paramContext, paramj);
    }
    AppMethodBeat.o(349971);
  }
  
  private static final void a(cq paramcq)
  {
    AppMethodBeat.i(350025);
    s.u(paramcq, "this$0");
    paramcq = paramcq.AMs.AJn.GpZ;
    if (paramcq != null) {
      paramcq.aCs("Finder.FinderStreamCardAlbumConvert");
    }
    AppMethodBeat.o(350025);
  }
  
  private static final void a(final cq paramcq, final com.tencent.mm.view.recyclerview.j paramj, final int paramInt, View paramView)
  {
    AppMethodBeat.i(349992);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramcq);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramcq, "this$0");
    s.u(paramj, "$holder");
    if (paramcq.isRefreshing)
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "isRefreshing");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349992);
      return;
    }
    paramcq.isRefreshing = true;
    au localau = (au)paramj.CSA;
    long l1 = System.currentTimeMillis();
    long l2 = paramcq.AMA.startTimeMs;
    int i = paramcq.AMs.AZs.getDataListJustForAdapter().indexOf(localau);
    localObject1 = aj.FtF;
    localObject2 = localau.AYW.Wqu;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    s.s(localau, "item");
    Object localObject3 = paramcq.Auc;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("contextObj");
      localObject2 = null;
    }
    aj.a((String)localObject1, localau, i, l1 - l2, (bui)localObject2);
    localObject1 = aj.FtF;
    localObject2 = localau.AYW.Wqu;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    l1 = localau.AYW.id;
    localObject3 = paramcq.Auc;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("contextObj");
      localObject2 = null;
    }
    aj.a((String)localObject1, l1, 3, 0L, (bui)localObject2, i);
    ((WeImageView)paramView.findViewById(e.e.refreshIcon)).setVisibility(8);
    ((ProgressBar)paramView.findViewById(e.e.refreshLoding)).setVisibility(0);
    localObject3 = paramcq.a(localau);
    List localList = kotlin.a.p.listOf(localObject3);
    localObject2 = paramcq.Auc;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("contextObj");
      localObject1 = null;
    }
    localObject1 = new ap(localList, (bui)localObject1);
    ((com.tencent.mm.am.b)localObject1).otr = true;
    ((com.tencent.mm.am.b)localObject1).bFJ();
    paramcq.a(true, localau, (fhp)localObject3, (kotlin.g.a.b)new f(paramView, paramcq, paramj, paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349992);
  }
  
  private final void a(final au paramau, final fhp paramfhp)
  {
    long l2 = 0L;
    AppMethodBeat.i(349952);
    if (!dYc())
    {
      AppMethodBeat.o(349952);
      return;
    }
    Object localObject1 = (CharSequence)paramau.AYW.Zsy;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(349952);
      return;
    }
    if (this.AMw.eee())
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "has cache never use. just return.");
      AppMethodBeat.o(349952);
      return;
    }
    if (this.AMB)
    {
      Log.w("Finder.FinderStreamCardAlbumConvert", "isPreloadContenting. just return.");
      AppMethodBeat.o(349952);
      return;
    }
    this.AMB = true;
    localObject1 = new StringBuilder("[preloadContent] now title=").append(paramau.AYW.Wqu).append(" stats=");
    long l1;
    Object localObject2;
    if (paramfhp == null)
    {
      l1 = 0L;
      localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.ae.d.hF(l1)).append(" card request id=");
      localObject2 = paramau.AYW.aadY;
      if (localObject2 != null) {
        break label270;
      }
      l1 = l2;
    }
    for (;;)
    {
      Log.i("Finder.FinderStreamCardAlbumConvert", com.tencent.mm.ae.d.hF(l1) + ' ' + com.tencent.mm.plugin.finder.cgi.interceptor.f.a(paramau.AYW));
      this.AMv.a(new g((kotlin.g.a.b)new i(this, paramau, paramfhp)));
      AppMethodBeat.o(349952);
      return;
      l1 = paramfhp.hKN;
      break;
      label270:
      localObject2 = ((bwb)localObject2).aaec;
      l1 = l2;
      if (localObject2 != null)
      {
        localObject2 = ((bav)localObject2).ZLH;
        l1 = l2;
        if (localObject2 != null) {
          l1 = ((fkp)localObject2).id;
        }
      }
    }
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, cq paramcq, View paramView)
  {
    AppMethodBeat.i(350009);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramcq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramcq, "this$0");
    if (!((Collection)((au)paramj.CSA).rvFeedList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = paramj.context;
        s.s(paramView, "holder.context");
        paramcq.a(paramView, 4, paramj);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350009);
      return;
    }
  }
  
  private final void a(boolean paramBoolean, final au paramau, final fhp paramfhp, final kotlin.g.a.b<? super au, ah> paramb)
  {
    long l2 = 0L;
    AppMethodBeat.i(349961);
    Object localObject1 = new StringBuilder("[fetchContent] isRefresh=").append(paramBoolean).append(" hasCache=").append(this.AMw.eee()).append(" card request id=");
    Object localObject2 = paramau.AYW.aadY;
    long l1;
    if (localObject2 == null) {
      l1 = l2;
    }
    for (;;)
    {
      Log.i("Finder.FinderStreamCardAlbumConvert", com.tencent.mm.ae.d.hF(l1) + com.tencent.mm.plugin.finder.cgi.interceptor.f.a(paramau.AYW));
      localObject2 = this.Auc;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("contextObj");
        localObject1 = null;
      }
      localObject1 = new FinderStreamCardAlbumConvert.fetchContent.loader.1(paramfhp, (bui)localObject1);
      ((FinderStreamCardAlbumConvert.fetchContent.loader.1)localObject1).register((com.tencent.mm.view.k)new c());
      this.AMv.a(new g((kotlin.g.a.b)new c(paramBoolean, paramau, (FinderStreamCardAlbumConvert.fetchContent.loader.1)localObject1, this, paramfhp, paramb)));
      AppMethodBeat.o(349961);
      return;
      localObject2 = ((bwb)localObject2).aaec;
      l1 = l2;
      if (localObject2 != null)
      {
        localObject2 = ((bav)localObject2).ZLH;
        l1 = l2;
        if (localObject2 != null) {
          l1 = ((fkp)localObject2).id;
        }
      }
    }
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, cq paramcq, View paramView)
  {
    AppMethodBeat.i(350015);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramcq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramcq, "this$0");
    if (!((Collection)((au)paramj.CSA).rvFeedList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = paramj.context;
        s.s(paramView, "holder.context");
        paramcq.a(paramView, 2, paramj);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350015);
      return;
    }
  }
  
  private static final void c(LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(349980);
    Rect localRect = new Rect();
    paramLinearLayout.getHitRect(localRect);
    localRect.inset(localRect.width(), -localRect.height() / 2);
    ViewParent localViewParent = paramLinearLayout.getParent();
    if (localViewParent == null)
    {
      paramLinearLayout = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(349980);
      throw paramLinearLayout;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, (View)paramLinearLayout));
    AppMethodBeat.o(349980);
  }
  
  private final boolean dYc()
  {
    AppMethodBeat.i(349933);
    boolean bool = ((Boolean)this.AMu.getValue()).booleanValue();
    AppMethodBeat.o(349933);
    return bool;
  }
  
  private static final void f(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(349997);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    ((LinearLayout)paramj.caK.findViewById(e.e.cardLayout)).callOnClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349997);
  }
  
  private static final void g(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(350005);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    ((LinearLayout)paramj.caK.findViewById(e.e.cardLayout)).callOnClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350005);
  }
  
  private static final boolean h(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(350019);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramj, "$holder");
    paramView = (au)paramj.CSA;
    paramj = new StringBuilder("FinderStreamCardFeed=").append(com.tencent.mm.plugin.finder.cgi.interceptor.f.a(paramView.AYW)).append(' ');
    localObject = com.tencent.mm.plugin.finder.cgi.bg.ABl;
    paramView = paramView.AYW.object.getFirst();
    s.s(paramView, "item.card.`object`.first");
    Log.i("Finder.FinderStreamCardAlbumConvert", com.tencent.mm.plugin.finder.cgi.bg.c((FinderObject)paramView));
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(350019);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350154);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    this.mkw = paramRecyclerView;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = paramRecyclerView.getContext();
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350154);
      throw paramRecyclerView;
    }
    this.Auc = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(as.class)).Vl(this.hJx);
    paramRecyclerView.b((RecyclerView.l)this.AMy);
    paramRecyclerView.a((RecyclerView.l)this.AMy);
    localObject = paramRecyclerView.getContext();
    if (localObject == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350154);
      throw paramRecyclerView;
    }
    ((MMActivity)localObject).getLifecycle().removeObserver((androidx.lifecycle.p)this.AMz);
    paramRecyclerView = paramRecyclerView.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350154);
      throw paramRecyclerView;
    }
    ((MMActivity)paramRecyclerView).getLifecycle().addObserver((androidx.lifecycle.p)this.AMz);
    paramRecyclerView = (LinearLayout)paramj.caK.findViewById(e.e.refreshLayout);
    paramRecyclerView.post(new cq..ExternalSyntheticLambda6(paramRecyclerView));
    paramRecyclerView.setOnClickListener(new cq..ExternalSyntheticLambda0(this, paramj, paramInt));
    ((LinearLayout)paramj.caK.findViewById(e.e.see_more_layout)).setOnClickListener(new cq..ExternalSyntheticLambda1(paramj));
    ((TextView)paramj.caK.findViewById(e.e.cardHeader)).setOnClickListener(new cq..ExternalSyntheticLambda2(paramj));
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.cardHeader)).getPaint(), 0.8F);
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.refreshContent)).getPaint(), 0.8F);
    ((TextView)paramj.caK.findViewById(e.e.seeMoreTv)).setOnClickListener(new cq..ExternalSyntheticLambda4(paramj, this));
    ((LinearLayout)paramj.caK.findViewById(e.e.cardLayout)).setOnClickListener(new cq..ExternalSyntheticLambda3(paramj, this));
    paramRecyclerView = (FinderFeedAlbumView)paramj.caK.findViewById(e.e.feedAlbumView);
    localObject = new g(paramj, this, this.ofu);
    ((com.tencent.mm.plugin.finder.view.adapter.b)localObject).GGb = ((b.c)new h(paramj, this));
    ah localah = ah.aiuX;
    paramRecyclerView.setAdapter((FinderFeedAlbumView.a)localObject);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
      paramj.caK.setOnLongClickListener(new cq..ExternalSyntheticLambda5(paramj));
    }
    AppMethodBeat.o(350154);
  }
  
  public final void a(final com.tencent.mm.view.recyclerview.j paramj, au paramau, final int paramInt1, final int paramInt2, final boolean paramBoolean, final List<Object> paramList)
  {
    AppMethodBeat.i(350162);
    s.u(paramj, "holder");
    s.u(paramau, "item");
    Log.i("Finder.FinderStreamCardAlbumConvert", "[onBindViewHolder] isHotPatch=" + paramBoolean + " pos=" + paramInt1 + " item=" + com.tencent.mm.plugin.finder.cgi.interceptor.f.a(paramau.AYW) + " rvFeedList isEmpty=" + paramau.rvFeedList.isEmpty());
    this.caK = paramj.caK;
    this.AMA.feedId = paramau.AYW.id;
    this.AMA.position = paramInt1;
    this.AMA.AMC = paramau;
    paramau.position = paramInt1;
    Object localObject1;
    int i;
    if ((!paramBoolean) && (paramau.rvFeedList.isEmpty()))
    {
      localObject1 = paramau.AYW.aadX;
      if ((localObject1 != null) && (((bwb)localObject1).type == 1))
      {
        i = 1;
        if (i != 0) {
          a(false, paramau, null, (kotlin.g.a.b)new e(this, paramj, paramInt1, paramInt2, paramBoolean, paramList));
        }
        label201:
        ((NeatTextView)paramj.caK.findViewById(e.e.title)).aZ((CharSequence)paramau.AYW.Wqu);
        ((TextView)paramj.caK.findViewById(e.e.subTitle)).setText((CharSequence)paramau.AYW.aadS);
        paramau = paramau.AYW.Zsy;
        if (paramau != null) {
          break label506;
        }
      }
    }
    for (paramau = null;; paramau = ah.aiuX)
    {
      if (paramau == null) {
        ((LinearLayout)paramj.caK.findViewById(e.e.refreshLayout)).setVisibility(8);
      }
      AppMethodBeat.o(350162);
      return;
      i = 0;
      break;
      if (!((Collection)paramau.rvFeedList).isEmpty()) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        this.ofu.clear();
        paramList = this.ofu;
        Object localObject2 = (Iterable)paramau.rvFeedList;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add((dji)((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getMediaList().getFirst());
        }
      }
      break label201;
      paramList.addAll((Collection)((List)localObject1).subList(0, Math.min(4, paramau.rvFeedList.size())));
      ((FinderFeedAlbumView)paramj.caK.findViewById(e.e.feedAlbumView)).deo();
      ((FinderFeedAlbumView)paramj.caK.findViewById(e.e.feedAlbumView)).post(new cq..ExternalSyntheticLambda7(this));
      a(paramau, a(paramau));
      break label201;
      label506:
      ((LinearLayout)paramj.caK.findViewById(e.e.refreshLayout)).setVisibility(0);
      ((TextView)paramj.caK.findViewById(e.e.refreshContent)).setText((CharSequence)paramau);
    }
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(350170);
    s.u(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    boolean bool = this.AMw.clearCache();
    Log.i("Finder.FinderStreamCardAlbumConvert", "[onDetachedFromRecyclerView] ret=" + bool + " report unReadItem");
    paramRecyclerView = this.AMw.BkO;
    if (paramRecyclerView != null)
    {
      Object localObject = av.GiL;
      int i = this.hJx;
      localObject = paramRecyclerView.getIncrementList();
      paramRecyclerView = (RecyclerView)localObject;
      if (localObject == null) {
        paramRecyclerView = (List)new LinkedList();
      }
      bui localbui = this.Auc;
      localObject = localbui;
      if (localbui == null)
      {
        s.bIx("contextObj");
        localObject = null;
      }
      av.a(i, paramRecyclerView, (bui)localObject);
    }
    AppMethodBeat.o(350170);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_card_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$ExposeItem;", "", "item", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "feedId", "", "sumTimeMs", "startTimeMs", "position", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;JJJI)V", "getFeedId", "()J", "setFeedId", "(J)V", "getItem", "()Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "setItem", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;)V", "getPosition", "()I", "setPosition", "(I)V", "getStartTimeMs", "setStartTimeMs", "getSumTimeMs", "setSumTimeMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    au AMC = null;
    private long AMD = 0L;
    long feedId = 0L;
    int position = -1;
    long startTimeMs = 0L;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(349691);
      if (this == paramObject)
      {
        AppMethodBeat.o(349691);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(349691);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.AMC, paramObject.AMC))
      {
        AppMethodBeat.o(349691);
        return false;
      }
      if (this.feedId != paramObject.feedId)
      {
        AppMethodBeat.o(349691);
        return false;
      }
      if (this.AMD != paramObject.AMD)
      {
        AppMethodBeat.o(349691);
        return false;
      }
      if (this.startTimeMs != paramObject.startTimeMs)
      {
        AppMethodBeat.o(349691);
        return false;
      }
      if (this.position != paramObject.position)
      {
        AppMethodBeat.o(349691);
        return false;
      }
      AppMethodBeat.o(349691);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(349683);
      if (this.AMC == null) {}
      for (int i = 0;; i = this.AMC.hashCode())
      {
        int j = q.a..ExternalSyntheticBackport0.m(this.feedId);
        int k = q.a..ExternalSyntheticBackport0.m(this.AMD);
        int m = q.a..ExternalSyntheticBackport0.m(this.startTimeMs);
        int n = this.position;
        AppMethodBeat.o(349683);
        return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(349679);
      String str = "ExposeItem(item=" + this.AMC + ", feedId=" + this.feedId + ", sumTimeMs=" + this.AMD + ", startTimeMs=" + this.startTimeMs + ", position=" + this.position + ')';
      AppMethodBeat.o(349679);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<g, ah>
  {
    c(boolean paramBoolean, au paramau, FinderStreamCardAlbumConvert.fetchContent.loader.1 param1, cq paramcq, fhp paramfhp, kotlin.g.a.b<? super au, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final d AML;
    
    static
    {
      AppMethodBeat.i(349668);
      AML = new d();
      AppMethodBeat.o(349668);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<au, ah>
  {
    e(cq paramcq, com.tencent.mm.view.recyclerview.j paramj, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<au, ah>
  {
    f(View paramView, cq paramcq, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$7", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends com.tencent.mm.plugin.finder.view.adapter.b
  {
    g(com.tencent.mm.view.recyclerview.j paramj, cq paramcq, ArrayList<dji> paramArrayList)
    {
      super(true);
      AppMethodBeat.i(349657);
      AppMethodBeat.o(349657);
    }
    
    public final au dYd()
    {
      return (au)this.wHm.CSA;
    }
    
    public final l dYe()
    {
      AppMethodBeat.i(349669);
      l locall = cq.b(jdField_this).AJn;
      AppMethodBeat.o(349669);
      return locall;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$onCreateViewHolder$8$1", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements b.c
  {
    h(com.tencent.mm.view.recyclerview.j paramj, cq paramcq) {}
    
    public final void h(int paramInt, View paramView)
    {
      AppMethodBeat.i(349666);
      s.u(paramView, "view");
      au localau = (au)this.wHm.CSA;
      if (localau != null)
      {
        cq localcq = jdField_this;
        com.tencent.mm.view.recyclerview.j localj = this.wHm;
        Log.i("Finder.FinderStreamCardAlbumConvert", "[onClick] position=" + paramInt + ' ' + localau.AYW.id);
        paramView = paramView.getContext();
        s.s(paramView, "view.context");
        cq.a(localcq, paramView, localj);
      }
      AppMethodBeat.o(349666);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<g, ah>
  {
    i(cq paramcq, au paramau, fhp paramfhp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final j AMP;
    
    static
    {
      AppMethodBeat.i(349654);
      AMP = new j();
      AppMethodBeat.o(349654);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends RecyclerView.l
  {
    private boolean AMQ;
    
    k(cq paramcq) {}
    
    private static final void a(cq paramcq, k paramk)
    {
      AppMethodBeat.i(349656);
      s.u(paramcq, "this$0");
      s.u(paramk, "this$1");
      Object localObject = cq.k(paramcq);
      if (localObject != null)
      {
        boolean bool = cq.a(paramcq, (View)localObject);
        if ((!paramk.AMQ) && (bool))
        {
          paramk.AMQ = true;
          cq.i(paramcq).startTimeMs = System.currentTimeMillis();
          AppMethodBeat.o(349656);
          return;
        }
        if ((paramk.AMQ) && (!bool))
        {
          paramk.AMQ = false;
          au localau = cq.i(paramcq).AMC;
          if (localau != null)
          {
            long l1 = System.currentTimeMillis();
            long l2 = cq.i(paramcq).startTimeMs;
            int i = cq.b(paramcq).AZs.getDataListJustForAdapter().indexOf(localau);
            paramk = aj.FtF;
            localObject = localau.AYW.Wqu;
            paramk = (k)localObject;
            if (localObject == null) {
              paramk = "";
            }
            localObject = cq.c(paramcq);
            paramcq = (cq)localObject;
            if (localObject == null)
            {
              s.bIx("contextObj");
              paramcq = null;
            }
            aj.a(paramk, localau, i, l1 - l2, paramcq);
          }
        }
      }
      AppMethodBeat.o(349656);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(349670);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post(new cq.k..ExternalSyntheticLambda0(this.AMH, this));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(349670);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(349676);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(349676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cq
 * JD-Core Version:    0.7.0.1
 */