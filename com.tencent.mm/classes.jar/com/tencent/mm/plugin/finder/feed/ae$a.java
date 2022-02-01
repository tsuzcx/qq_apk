package com.tencent.mm.plugin.finder.feed;

import android.os.SystemClock;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.f;
import com.tencent.mm.g.a.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.cgi.cm;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.d;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isUserActivityList", "", "posterUserName", "", "(ZLjava/lang/String;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "Lkotlin/collections/ArrayList;", "firstPage", "Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "isDown", "()Z", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getPosterUserName", "()Ljava/lang/String;", "removeEvent", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1;", "startLoadingTime", "", "viewCallback", "doGetActivityScene", "", "fakeHasMore", "fakeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getData", "handleSceneEnd", "requestBuffer", "continueCount", "", "eventList", "lastResponseBuffer", "loadStart", "mergeData", "eventInfoList", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "optEventInfo", "eventName", "participantCount", "description", "optValidEventInfo", "Companion", "plugin-finder_release"})
public final class ae$a
  implements i, com.tencent.mm.plugin.finder.presenter.base.a<ae.b>
{
  public static final a tQs;
  ArrayList<com.tencent.mm.plugin.finder.model.l> kgc;
  private boolean tQl;
  private ae.b tQm;
  private com.tencent.mm.plugin.finder.storage.data.c tQn;
  private long tQo;
  private final g tQp;
  private final boolean tQq;
  private final String tQr;
  private com.tencent.mm.bw.b tsO;
  
  static
  {
    AppMethodBeat.i(244133);
    tQs = new a((byte)0);
    AppMethodBeat.o(244133);
  }
  
  public ae$a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(244131);
    this.tQq = paramBoolean;
    this.tQr = paramString;
    this.kgc = new ArrayList();
    this.tQn = new com.tencent.mm.plugin.finder.storage.data.c("activityList.fp");
    this.tQo = SystemClock.uptimeMillis();
    this.tQp = new g(this);
    AppMethodBeat.o(244131);
  }
  
  private final void a(final com.tencent.mm.bw.b paramb1, final int paramInt, final LinkedList<aqk> paramLinkedList, com.tencent.mm.bw.b paramb2)
  {
    AppMethodBeat.i(244129);
    if ((p.j(this.tsO, paramb1) ^ true))
    {
      Log.i("Finder.SelectPresenter", "not my buf, ignore!");
      AppMethodBeat.o(244129);
      return;
    }
    paramb1 = new z.a();
    paramb1.SYB = false;
    if (this.tsO == null)
    {
      paramb1.SYB = true;
      com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new b(this, paramb1, paramLinkedList));
    }
    this.tsO = paramb2;
    final int i = this.kgc.size();
    long l = SystemClock.uptimeMillis() - this.tQo;
    if (!this.tQl)
    {
      paramb2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (l < ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue()) {
        break label171;
      }
    }
    for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue() - l)
    {
      com.tencent.mm.ac.d.a(l, (kotlin.g.a.a)new c((Runnable)new d(this, paramb1, paramLinkedList, i, paramInt)));
      AppMethodBeat.o(244129);
      return;
      label171:
      paramb2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    }
  }
  
  public final void a(ae.b paramb)
  {
    AppMethodBeat.i(244125);
    p.h(paramb, "callback");
    this.tQm = paramb;
    com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new e(this)), (kotlin.g.a.b)new f(this));
    na(false);
    if (this.tQq) {
      g.azz().a(6833, (i)this);
    }
    for (;;)
    {
      this.tQp.alive();
      AppMethodBeat.o(244125);
      return;
      g.azz().a(5839, (i)this);
    }
  }
  
  public final void na(boolean paramBoolean)
  {
    AppMethodBeat.i(244130);
    this.tQl = paramBoolean;
    this.tQo = SystemClock.uptimeMillis();
    if (this.tQq)
    {
      g.azz().b((com.tencent.mm.ak.q)new cm(this.tsO, this.tQr));
      AppMethodBeat.o(244130);
      return;
    }
    g.azz().b((com.tencent.mm.ak.q)new bd(this.tsO));
    AppMethodBeat.o(244130);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(244127);
    if (this.tQq) {
      g.azz().b(6833, (i)this);
    }
    for (;;)
    {
      this.tQp.dead();
      this.tQm = null;
      AppMethodBeat.o(244127);
      return;
      g.azz().b(5839, (i)this);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(244128);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof bd))
      {
        localObject2 = ((bd)paramq).rr.aYJ();
        paramString = (String)localObject2;
        if (!(localObject2 instanceof bbb)) {
          paramString = null;
        }
        localObject2 = (bbb)paramString;
        paramString = (String)localObject1;
        if (localObject2 != null) {
          paramString = ((bbb)localObject2).LDs;
        }
        localObject1 = ((bd)paramq).rr.aYK();
        if (localObject1 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
          AppMethodBeat.o(244128);
          throw paramString;
        }
        a(paramString, ((bbc)localObject1).tUC, ((bd)paramq).cYl(), ((bd)paramq).cYm());
        AppMethodBeat.o(244128);
        return;
      }
      if ((paramq instanceof cm))
      {
        localObject1 = ((cm)paramq).rr.aYJ();
        paramString = (String)localObject1;
        if (!(localObject1 instanceof aql)) {
          paramString = null;
        }
        localObject1 = (aql)paramString;
        paramString = (String)localObject2;
        if (localObject1 != null) {
          paramString = ((aql)localObject1).lastBuffer;
        }
        localObject1 = ((cm)paramq).rr.aYK();
        if (localObject1 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
          AppMethodBeat.o(244128);
          throw paramString;
        }
        a(paramString, ((aqm)localObject1).continueFlag, ((cm)paramq).cYl(), ((cm)paramq).cYm());
      }
      AppMethodBeat.o(244128);
      return;
    }
    if (this.tsO == null)
    {
      paramString = this.tQm;
      if (paramString != null)
      {
        paramq = paramString.progressBar;
        if (paramq == null) {
          p.btv("progressBar");
        }
        paramq.setVisibility(8);
        paramString = paramString.tQE;
        if (paramString == null) {
          p.btv("retryTextView");
        }
        paramString.setVisibility(0);
        AppMethodBeat.o(244128);
        return;
      }
    }
    AppMethodBeat.o(244128);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$handleSceneEnd$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, x>
  {
    b(ae.a parama, z.a parama1, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(Runnable paramRunnable)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ae.a parama, z.a parama1, LinkedList paramLinkedList, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(244119);
      ae.a.a(this.tQt, paramb1.SYB, paramLinkedList);
      Object localObject1 = ae.a.b(this.tQt);
      if (localObject1 != null)
      {
        boolean bool2 = ae.a.c(this.tQt);
        int i = i;
        int j = paramLinkedList.size();
        boolean bool1;
        if (paramInt > 0)
        {
          bool1 = true;
          boolean bool3 = paramb1.SYB;
          ((ae.b)localObject1).hasMore = bool1;
          localObject2 = ((ae.b)localObject1).tQF;
          if (localObject2 == null) {
            p.btv("progressContainer");
          }
          ((FrameLayout)localObject2).setVisibility(8);
          localObject2 = ((ae.b)localObject1).progressBar;
          if (localObject2 == null) {
            p.btv("progressBar");
          }
          ((ProgressBar)localObject2).setVisibility(8);
          localObject2 = ((ae.b)localObject1).tQE;
          if (localObject2 == null) {
            p.btv("retryTextView");
          }
          ((TextView)localObject2).setVisibility(8);
          localObject2 = ((ae.b)localObject1).tFp;
          if (localObject2 != null)
          {
            if (!bool3) {
              break label257;
            }
            ((WxRecyclerAdapter)localObject2).notifyDataSetChanged();
          }
        }
        for (;;)
        {
          if (!bool2) {
            break label269;
          }
          localObject2 = new RefreshLoadMoreLayout.c(0);
          ((RefreshLoadMoreLayout.c)localObject2).Rmj = ((ae.b)localObject1).hasMore;
          ((RefreshLoadMoreLayout.c)localObject2).Rmk = j;
          if (((RefreshLoadMoreLayout.c)localObject2).Rmk > 0) {
            ((RefreshLoadMoreLayout.c)localObject2).jLE = false;
          }
          localObject1 = ((ae.b)localObject1).tLS;
          if (localObject1 == null) {
            p.btv("rlLayout");
          }
          ((RefreshLoadMoreLayout)localObject1).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject2);
          AppMethodBeat.o(244119);
          return;
          bool1 = false;
          break;
          label257:
          ((WxRecyclerAdapter)localObject2).as(i + 1, j);
        }
        label269:
        Object localObject2 = ((ae.b)localObject1).tLS;
        if (localObject2 == null) {
          p.btv("rlLayout");
        }
        ((RefreshLoadMoreLayout)localObject2).apS(0);
        if (!((ae.b)localObject1).hasMore)
        {
          localObject1 = ((ae.b)localObject1).tLS;
          if (localObject1 == null) {
            p.btv("rlLayout");
          }
          RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
        }
        AppMethodBeat.o(244119);
        return;
      }
      AppMethodBeat.o(244119);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "it", "Ljava/lang/Void;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, LinkedList<aqk>>
  {
    e(ae.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<LinkedList<aqk>, Object>
  {
    f(ae.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends IListener<f>
  {
    private boolean a(final f paramf)
    {
      AppMethodBeat.i(244123);
      if (paramf != null)
      {
        final z.d locald = new z.d();
        locald.SYE = 0;
        Iterator localIterator = ((Iterable)ae.a.e(this.tQt)).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.finder.model.l locall = (com.tencent.mm.plugin.finder.model.l)localIterator.next();
          if ((locall.tqo.twd == paramf.dBS.dBT) && (locall.tqo.LCy > 0))
          {
            aqk localaqk = locall.tqo;
            localaqk.LCy -= 1;
            ae.a.a(this.tQt).blr();
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(locall, locald, this, paramf));
          }
          else
          {
            locald.SYE += 1;
          }
        }
      }
      AppMethodBeat.o(244123);
      return false;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1$callback$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1$$special$$inlined$forEach$lambda$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(com.tencent.mm.plugin.finder.model.l paraml, z.d paramd, ae.a.g paramg, f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae.a
 * JD-Core Version:    0.7.0.1
 */