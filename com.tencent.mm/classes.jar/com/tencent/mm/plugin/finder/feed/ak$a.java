package com.tencent.mm.plugin.finder.feed;

import android.os.SystemClock;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.f;
import com.tencent.mm.f.a.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.cgi.cq;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isUserActivityList", "", "posterUserName", "", "(ZLjava/lang/String;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "Lkotlin/collections/ArrayList;", "firstPage", "Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "isDown", "()Z", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getPosterUserName", "()Ljava/lang/String;", "removeEvent", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1;", "startLoadingTime", "", "viewCallback", "doGetActivityScene", "", "fakeHasMore", "fakeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getData", "handleSceneEnd", "requestBuffer", "continueCount", "", "eventList", "lastResponseBuffer", "loadStart", "mergeData", "eventInfoList", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "optEventInfo", "eventName", "participantCount", "description", "optValidEventInfo", "Companion", "plugin-finder_release"})
public final class ak$a
  implements i, com.tencent.mm.plugin.finder.presenter.base.a<ak.b>
{
  public static final a xBi;
  ArrayList<com.tencent.mm.plugin.finder.model.l> mXB;
  private boolean xBb;
  private ak.b xBc;
  private c xBd;
  private long xBe;
  private final g xBf;
  private final boolean xBg;
  private final String xBh;
  private com.tencent.mm.cd.b xaw;
  
  static
  {
    AppMethodBeat.i(271642);
    xBi = new a((byte)0);
    AppMethodBeat.o(271642);
  }
  
  public ak$a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(271640);
    this.xBg = paramBoolean;
    this.xBh = paramString;
    this.mXB = new ArrayList();
    this.xBd = new c("activityList.fp");
    this.xBe = SystemClock.uptimeMillis();
    this.xBf = new g(this);
    AppMethodBeat.o(271640);
  }
  
  private final void a(final com.tencent.mm.cd.b paramb1, final int paramInt, final LinkedList<asg> paramLinkedList, com.tencent.mm.cd.b paramb2)
  {
    AppMethodBeat.i(271638);
    if ((p.h(this.xaw, paramb1) ^ true))
    {
      Log.i("Finder.SelectPresenter", "not my buf, ignore!");
      AppMethodBeat.o(271638);
      return;
    }
    paramb1 = new aa.a();
    paramb1.aaBx = false;
    if (this.xaw == null)
    {
      paramb1.aaBx = true;
      com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new b(this, paramb1, paramLinkedList));
    }
    this.xaw = paramb2;
    final int i = this.mXB.size();
    long l = SystemClock.uptimeMillis() - this.xBe;
    if (!this.xBb)
    {
      paramb2 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue()) {
        break label171;
      }
    }
    for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() - l)
    {
      com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new c((Runnable)new d(this, paramb1, paramLinkedList, i, paramInt)));
      AppMethodBeat.o(271638);
      return;
      label171:
      paramb2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    }
  }
  
  public final void a(ak.b paramb)
  {
    AppMethodBeat.i(271630);
    p.k(paramb, "callback");
    this.xBc = paramb;
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new e(this)), (kotlin.g.a.b)new f(this));
    ou(false);
    if (this.xBg) {
      h.aGY().a(6833, (i)this);
    }
    for (;;)
    {
      this.xBf.alive();
      AppMethodBeat.o(271630);
      return;
      h.aGY().a(5839, (i)this);
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(271634);
    if (this.xBg) {
      h.aGY().b(6833, (i)this);
    }
    for (;;)
    {
      this.xBf.dead();
      this.xBc = null;
      AppMethodBeat.o(271634);
      return;
      h.aGY().b(5839, (i)this);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(271637);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof bg))
      {
        localObject2 = ((bg)paramq).rr.bhX();
        paramString = (String)localObject2;
        if (!(localObject2 instanceof bhp)) {
          paramString = null;
        }
        localObject2 = (bhp)paramString;
        paramString = (String)localObject1;
        if (localObject2 != null) {
          paramString = ((bhp)localObject2).SDI;
        }
        localObject1 = ((bg)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
          AppMethodBeat.o(271637);
          throw paramString;
        }
        a(paramString, ((bhq)localObject1).xFI, ((bg)paramq).dnZ(), ((bg)paramq).doa());
        AppMethodBeat.o(271637);
        return;
      }
      if ((paramq instanceof cq))
      {
        localObject1 = ((cq)paramq).rr.bhX();
        paramString = (String)localObject1;
        if (!(localObject1 instanceof ash)) {
          paramString = null;
        }
        localObject1 = (ash)paramString;
        paramString = (String)localObject2;
        if (localObject1 != null) {
          paramString = ((ash)localObject1).lastBuffer;
        }
        localObject1 = ((cq)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
          AppMethodBeat.o(271637);
          throw paramString;
        }
        a(paramString, ((asi)localObject1).continueFlag, ((cq)paramq).dnZ(), ((cq)paramq).doa());
      }
      AppMethodBeat.o(271637);
      return;
    }
    if (this.xaw == null)
    {
      paramString = this.xBc;
      if (paramString != null)
      {
        paramq = paramString.progressBar;
        if (paramq == null) {
          p.bGy("progressBar");
        }
        paramq.setVisibility(8);
        paramString = paramString.xBu;
        if (paramString == null) {
          p.bGy("retryTextView");
        }
        paramString.setVisibility(0);
        AppMethodBeat.o(271637);
        return;
      }
    }
    AppMethodBeat.o(271637);
  }
  
  public final void ou(boolean paramBoolean)
  {
    AppMethodBeat.i(271639);
    this.xBb = paramBoolean;
    this.xBe = SystemClock.uptimeMillis();
    if (this.xBg)
    {
      h.aGY().b((com.tencent.mm.an.q)new cq(this.xaw, this.xBh));
      AppMethodBeat.o(271639);
      return;
    }
    h.aGY().b((com.tencent.mm.an.q)new bg(this.xaw));
    AppMethodBeat.o(271639);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$handleSceneEnd$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, x>
  {
    b(ak.a parama, aa.a parama1, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(Runnable paramRunnable)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ak.a parama, aa.a parama1, LinkedList paramLinkedList, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(277950);
      ak.a.a(this.xBj, paramb1.aaBx, paramLinkedList);
      Object localObject1 = ak.a.b(this.xBj);
      if (localObject1 != null)
      {
        boolean bool2 = ak.a.c(this.xBj);
        int i = i;
        int j = paramLinkedList.size();
        boolean bool1;
        if (paramInt > 0)
        {
          bool1 = true;
          boolean bool3 = paramb1.aaBx;
          ((ak.b)localObject1).hasMore = bool1;
          localObject2 = ((ak.b)localObject1).xBv;
          if (localObject2 == null) {
            p.bGy("progressContainer");
          }
          ((FrameLayout)localObject2).setVisibility(8);
          localObject2 = ((ak.b)localObject1).progressBar;
          if (localObject2 == null) {
            p.bGy("progressBar");
          }
          ((ProgressBar)localObject2).setVisibility(8);
          localObject2 = ((ak.b)localObject1).xBu;
          if (localObject2 == null) {
            p.bGy("retryTextView");
          }
          ((TextView)localObject2).setVisibility(8);
          localObject2 = ((ak.b)localObject1).xnR;
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
          ((RefreshLoadMoreLayout.c)localObject2).YNF = ((ak.b)localObject1).hasMore;
          ((RefreshLoadMoreLayout.c)localObject2).YNG = j;
          if (((RefreshLoadMoreLayout.c)localObject2).YNG > 0) {
            ((RefreshLoadMoreLayout.c)localObject2).mCI = false;
          }
          localObject1 = ((ak.b)localObject1).xvJ;
          if (localObject1 == null) {
            p.bGy("rlLayout");
          }
          ((RefreshLoadMoreLayout)localObject1).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject2);
          AppMethodBeat.o(277950);
          return;
          bool1 = false;
          break;
          label257:
          ((WxRecyclerAdapter)localObject2).aG(i + 1, j);
        }
        label269:
        Object localObject2 = ((ak.b)localObject1).xvJ;
        if (localObject2 == null) {
          p.bGy("rlLayout");
        }
        ((RefreshLoadMoreLayout)localObject2).azr(0);
        if (!((ak.b)localObject1).hasMore)
        {
          localObject1 = ((ak.b)localObject1).xvJ;
          if (localObject1 == null) {
            p.bGy("rlLayout");
          }
          RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
        }
        AppMethodBeat.o(277950);
        return;
      }
      AppMethodBeat.o(277950);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "it", "Ljava/lang/Void;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, LinkedList<asg>>
  {
    e(ak.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<LinkedList<asg>, Object>
  {
    f(ak.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ActivityFeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends IListener<f>
  {
    private boolean a(final f paramf)
    {
      AppMethodBeat.i(227563);
      if (paramf != null)
      {
        final aa.d locald = new aa.d();
        locald.aaBA = 0;
        Iterator localIterator = ((Iterable)ak.a.e(this.xBj)).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.finder.model.l locall = (com.tencent.mm.plugin.finder.model.l)localIterator.next();
          if ((locall.wWV.xdR == paramf.fuu.fuv) && (locall.wWV.SFG > 0))
          {
            asg localasg = locall.wWV;
            localasg.SFG -= 1;
            ak.a.a(this.xBj).bvh();
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(locall, locald, this, paramf));
          }
          else
          {
            locald.aaBA += 1;
          }
        }
      }
      AppMethodBeat.o(227563);
      return false;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1$callback$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1$$special$$inlined$forEach$lambda$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(com.tencent.mm.plugin.finder.model.l paraml, aa.d paramd, ak.a.g paramg, f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ak.a
 * JD-Core Version:    0.7.0.1
 */