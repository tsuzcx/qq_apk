package com.tencent.mm.plugin.finder.feed;

import android.os.SystemClock;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.cgi.ds;
import com.tencent.mm.plugin.finder.model.l;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isUserActivityList", "", "posterUserName", "", "(ZLjava/lang/String;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "Lkotlin/collections/ArrayList;", "firstPage", "Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "isDown", "()Z", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getPosterUserName", "()Ljava/lang/String;", "removeEvent", "com/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$removeEvent$1;", "startLoadingTime", "", "viewCallback", "doGetActivityScene", "", "fakeHasMore", "fakeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getData", "handleSceneEnd", "requestBuffer", "continueCount", "", "eventList", "lastResponseBuffer", "loadStart", "mergeData", "eventInfoList", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "optEventInfo", "eventName", "participantCount", "description", "optValidEventInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar$a
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.presenter.base.a<ar.b>
{
  public static final a AYA;
  private long AXD;
  private final boolean AYB;
  private final String AYC;
  private boolean AYD;
  private ar.b AYE;
  private com.tencent.mm.plugin.finder.storage.data.c AYF;
  private final FinderSelectContract.SelectPresenter.removeEvent.1 AYG;
  private com.tencent.mm.bx.b AyB;
  ArrayList<l> pUj;
  
  static
  {
    AppMethodBeat.i(363359);
    AYA = new a((byte)0);
    AppMethodBeat.o(363359);
  }
  
  public ar$a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(363307);
    this.AYB = paramBoolean;
    this.AYC = paramString;
    this.pUj = new ArrayList();
    this.AYF = new com.tencent.mm.plugin.finder.storage.data.c("activityList.fp");
    this.AXD = SystemClock.uptimeMillis();
    this.AYG = new FinderSelectContract.SelectPresenter.removeEvent.1(this, f.hfK);
    AppMethodBeat.o(363307);
  }
  
  private final void a(com.tencent.mm.bx.b paramb1, int paramInt, final LinkedList<awt> paramLinkedList, com.tencent.mm.bx.b paramb2)
  {
    AppMethodBeat.i(363322);
    if (!kotlin.g.b.s.p(this.AyB, paramb1))
    {
      Log.i("Finder.SelectPresenter", "not my buf, ignore!");
      AppMethodBeat.o(363322);
      return;
    }
    paramb1 = new ah.a();
    if (this.AyB == null)
    {
      paramb1.aiwY = true;
      com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new b(this, paramLinkedList));
    }
    this.AyB = paramb2;
    int i = this.pUj.size();
    long l = SystemClock.uptimeMillis() - this.AXD;
    if (!this.AYD)
    {
      paramb2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue()) {
        break label160;
      }
    }
    for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() - l)
    {
      com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new c(new ar.a..ExternalSyntheticLambda0(this, paramb1, paramLinkedList, i, paramInt)));
      AppMethodBeat.o(363322);
      return;
      label160:
      paramb2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    }
  }
  
  private static final void a(a parama, ah.a parama1, LinkedList paramLinkedList, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(363334);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(parama1, "$isFirstPage");
    kotlin.g.b.s.u(paramLinkedList, "$eventList");
    boolean bool1 = parama1.aiwY;
    Log.i("Finder.SelectPresenter", "firstPage " + bool1 + ", get activity list " + paramLinkedList.size());
    if (bool1) {
      parama.pUj.clear();
    }
    Object localObject3 = parama.pUj;
    Object localObject4 = (Iterable)paramLinkedList;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      localCollection.add(new l((awt)((Iterator)localObject4).next()));
    }
    ((ArrayList)localObject3).addAll((Collection)localCollection);
    localObject3 = parama.AYE;
    if (localObject3 != null)
    {
      boolean bool2 = parama.AYD;
      int i = paramLinkedList.size();
      if (paramInt2 > 0)
      {
        bool1 = true;
        boolean bool3 = parama1.aiwY;
        ((ar.b)localObject3).hasMore = bool1;
        parama1 = ((ar.b)localObject3).AYP;
        parama = parama1;
        if (parama1 == null)
        {
          kotlin.g.b.s.bIx("progressContainer");
          parama = null;
        }
        parama.setVisibility(8);
        parama1 = ((ar.b)localObject3).progressBar;
        parama = parama1;
        if (parama1 == null)
        {
          kotlin.g.b.s.bIx("progressBar");
          parama = null;
        }
        parama.setVisibility(8);
        parama1 = ((ar.b)localObject3).AYO;
        parama = parama1;
        if (parama1 == null)
        {
          kotlin.g.b.s.bIx("retryTextView");
          parama = null;
        }
        parama.setVisibility(8);
        parama = ((ar.b)localObject3).ALE;
        if (parama != null)
        {
          if (!bool3) {
            break label401;
          }
          parama.bZE.notifyChanged();
        }
        label323:
        if (!bool2) {
          break label416;
        }
        parama1 = new RefreshLoadMoreLayout.d(0);
        parama1.agJu = ((ar.b)localObject3).hasMore;
        parama1.agJv = i;
        if (parama1.agJv > 0) {
          parama1.pzq = false;
        }
        parama = ((ar.b)localObject3).ATx;
        if (parama != null) {
          break label413;
        }
        kotlin.g.b.s.bIx("rlLayout");
        parama = localObject2;
      }
      label401:
      label413:
      for (;;)
      {
        parama.onPreFinishLoadMoreSmooth(parama1);
        AppMethodBeat.o(363334);
        return;
        bool1 = false;
        break;
        parama.bA(paramInt1 + 1, i);
        break label323;
      }
      label416:
      parama1 = ((ar.b)localObject3).ATx;
      parama = parama1;
      if (parama1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        parama = null;
      }
      parama.aFV(0);
      if (!((ar.b)localObject3).hasMore)
      {
        parama = ((ar.b)localObject3).ATx;
        if (parama != null) {
          break label479;
        }
        kotlin.g.b.s.bIx("rlLayout");
        parama = localObject1;
      }
    }
    label479:
    for (;;)
    {
      RefreshLoadMoreLayout.e(parama);
      AppMethodBeat.o(363334);
      return;
    }
  }
  
  public final void a(ar.b paramb)
  {
    AppMethodBeat.i(363371);
    kotlin.g.b.s.u(paramb, "callback");
    this.AYE = paramb;
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new d(this)), (kotlin.g.a.b)new e(this));
    pX(false);
    if (this.AYB) {
      com.tencent.mm.kernel.h.aZW().a(6833, (com.tencent.mm.am.h)this);
    }
    for (;;)
    {
      this.AYG.alive();
      AppMethodBeat.o(363371);
      return;
      com.tencent.mm.kernel.h.aZW().a(5839, (com.tencent.mm.am.h)this);
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363380);
    if (this.AYB) {
      com.tencent.mm.kernel.h.aZW().b(6833, (com.tencent.mm.am.h)this);
    }
    for (;;)
    {
      this.AYG.dead();
      this.AYE = null;
      AppMethodBeat.o(363380);
      return;
      com.tencent.mm.kernel.h.aZW().b(5839, (com.tencent.mm.am.h)this);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject = null;
    com.tencent.mm.bx.a locala = null;
    ar.b localb = null;
    AppMethodBeat.i(363390);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof cd))
      {
        paramString = c.b.b(((cd)paramp).rr.otB);
        if ((paramString instanceof btp))
        {
          paramString = (btp)paramString;
          if (paramString != null) {
            break label110;
          }
        }
        label110:
        for (paramString = localb;; paramString = paramString.ZEQ)
        {
          locala = c.c.b(((cd)paramp).rr.otC);
          if (locala != null) {
            break label118;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderRecommendEventResponse");
          AppMethodBeat.o(363390);
          throw paramString;
          paramString = null;
          break;
        }
        label118:
        a(paramString, ((btq)locala).BeA, ((cd)paramp).dVI(), ((cd)paramp).dVJ());
        AppMethodBeat.o(363390);
        return;
      }
      if ((paramp instanceof ds))
      {
        paramString = c.b.b(((ds)paramp).rr.otB);
        if ((paramString instanceof awv))
        {
          paramString = (awv)paramString;
          if (paramString != null) {
            break label241;
          }
        }
        label241:
        for (paramString = localObject;; paramString = paramString.lastBuffer)
        {
          locala = c.c.b(((ds)paramp).rr.otC);
          if (locala != null) {
            break label249;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderEventUserPageResponse");
          AppMethodBeat.o(363390);
          throw paramString;
          paramString = null;
          break;
        }
        label249:
        a(paramString, ((aww)locala).continueFlag, ((ds)paramp).dVI(), ((ds)paramp).dVJ());
        AppMethodBeat.o(363390);
      }
    }
    else if (this.AyB == null)
    {
      localb = this.AYE;
      if (localb != null)
      {
        paramp = localb.progressBar;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("progressBar");
          paramString = null;
        }
        paramString.setVisibility(8);
        paramString = localb.AYO;
        if (paramString != null) {
          break label363;
        }
        kotlin.g.b.s.bIx("retryTextView");
        paramString = locala;
      }
    }
    label363:
    for (;;)
    {
      paramString.setVisibility(0);
      AppMethodBeat.o(363390);
      return;
    }
  }
  
  public final void pX(boolean paramBoolean)
  {
    AppMethodBeat.i(363395);
    this.AYD = paramBoolean;
    this.AXD = SystemClock.uptimeMillis();
    if (this.AYB)
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new ds(this.AyB, this.AYC), 0);
      AppMethodBeat.o(363395);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new cd(this.AyB), 0);
    AppMethodBeat.o(363395);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Void, ah>
  {
    b(ar.a parama, LinkedList<awt> paramLinkedList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(Runnable paramRunnable)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Void, LinkedList<awt>>
  {
    d(ar.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<LinkedList<awt>, Object>
  {
    e(ar.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ar.a
 * JD-Core Version:    0.7.0.1
 */