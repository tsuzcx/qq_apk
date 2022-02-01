package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.cgi.dd;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.bq;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManagePresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "currentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "auditList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderPoiData;", "Lkotlin/collections/ArrayList;", "getCurrentReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "dataList", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isFirstPage", "setFirstPage", "isLoadMore", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "getUsername", "()Ljava/lang/String;", "viewCallback", "clearLastBuff", "", "createPoiDataForTitle", "pullType", "", "titleType", "doGetPoiListScene", "doPoiUnbind", "poiId", "getAuditData", "getData", "getPoiDataList", "poiInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderBindPoiInfo;", "handleBindPoiStream", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "loadInitData", "onAttach", "callback", "onDetach", "onSceneEnd", "refreshPoi", "requestBindPoi", "poiList", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj$b
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.presenter.base.a<aj.c>
{
  private aj.c AXA;
  private final ArrayList<bq> AXB;
  private boolean AXC;
  private long AXD;
  boolean AXE;
  private final bui AXz;
  com.tencent.mm.bx.b AyB;
  boolean hasMore;
  public final ArrayList<bq> pUj;
  public final String username;
  
  public aj$b(String paramString, bui parambui)
  {
    AppMethodBeat.i(363563);
    this.username = paramString;
    this.AXz = parambui;
    this.pUj = new ArrayList();
    this.AXB = new ArrayList();
    this.AXD = SystemClock.uptimeMillis();
    this.hasMore = true;
    this.AXE = true;
    AppMethodBeat.o(363563);
  }
  
  private static final void a(b paramb, ArrayList paramArrayList)
  {
    AppMethodBeat.i(363587);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramArrayList, "$newData");
    boolean bool = paramb.AXC;
    if (bool) {}
    for (int i = paramb.pUj.size();; i = paramb.AXB.size() + 1)
    {
      int j = paramArrayList.size();
      if (paramb.AXE)
      {
        paramb.AXE = false;
        j = -1;
        i = -1;
      }
      paramb.pUj.addAll((Collection)paramArrayList);
      paramArrayList = paramb.AXA;
      paramb = paramArrayList;
      if (paramArrayList == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        paramb = null;
      }
      paramb.i(bool, i, j);
      AppMethodBeat.o(363587);
      return;
    }
  }
  
  private static ArrayList<bq> g(LinkedList<aue> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(363581);
    ArrayList localArrayList = new ArrayList();
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext()) {
        localArrayList.add(new bq((aue)paramLinkedList.next(), 2, paramInt));
      }
    }
    AppMethodBeat.o(363581);
    return localArrayList;
  }
  
  private static bq hv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363572);
    bq localbq = new bq(new aue(), 1, paramInt1);
    localbq.EDx = paramInt2;
    AppMethodBeat.o(363572);
    return localbq;
  }
  
  public final void L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(363634);
    this.AXD = SystemClock.uptimeMillis();
    this.AXC = paramBoolean;
    dd localdd = new dd(this.username, this.AyB, paramInt, this.AXz);
    com.tencent.mm.kernel.h.aZW().a((p)localdd, 0);
    AppMethodBeat.o(363634);
  }
  
  public final void a(aj.c paramc)
  {
    AppMethodBeat.i(363597);
    kotlin.g.b.s.u(paramc, "callback");
    this.AXA = paramc;
    com.tencent.mm.kernel.h.aZW().a(6850, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(6495, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(4078, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(363597);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(363643);
    this.AyB = null;
    L(false, 1);
    AppMethodBeat.o(363643);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363603);
    com.tencent.mm.kernel.h.aZW().b(6850, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(6495, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(4078, (com.tencent.mm.am.h)this);
    this.AXB.clear();
    this.pUj.clear();
    AppMethodBeat.o(363603);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    int j = 1;
    AppMethodBeat.i(363628);
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    Object localObject1;
    if (paramp == null)
    {
      localObject1 = null;
      Log.i("Finder.FinderPoiManageUIContract", localObject1);
      if ((paramp == null) || (paramp.getType() != 6495)) {
        break label128;
      }
    }
    label128:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label134;
      }
      AppMethodBeat.o(363628);
      return;
      localObject1 = Integer.valueOf(paramp.getType());
      break;
    }
    label134:
    if ((paramp != null) && (paramp.getType() == 4078))
    {
      i = 1;
      if (i == 0) {
        break label632;
      }
      localObject1 = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
      if (paramp != null) {
        break label304;
      }
      paramString = null;
      label207:
      Log.i("MMFinderFunc_FinderBindPoiStream", paramString);
      if ((!(paramp instanceof bv)) || (paramInt2 >= 0)) {
        break label408;
      }
      paramString = MMApplicationContext.getContext().getResources().getString(e.h.finder_poi_bind_submit_err);
      kotlin.g.b.s.s(paramString, "getContext().resources.g…nder_poi_bind_submit_err)");
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      aa.showTextToast(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(363628);
      return;
      i = 0;
      break;
      label304:
      paramString = Integer.valueOf(paramp.getType());
      break label207;
      paramString = MMApplicationContext.getContext().getResources().getString(e.h.finder_poi_bind_failed);
      kotlin.g.b.s.s(paramString, "getContext().resources.g…g.finder_poi_bind_failed)");
      continue;
      paramString = MMApplicationContext.getContext().getResources().getString(e.h.finder_poi_bind_already);
      kotlin.g.b.s.s(paramString, "getContext().resources.g….finder_poi_bind_already)");
      continue;
      paramString = MMApplicationContext.getContext().getResources().getString(e.h.finder_poi_bind_account_info_err);
      kotlin.g.b.s.s(paramString, "getContext().resources.g…oi_bind_account_info_err)");
      continue;
      paramString = MMApplicationContext.getContext().getResources().getString(e.h.finder_poi_bind_submit_err);
      kotlin.g.b.s.s(paramString, "getContext().resources.g…nder_poi_bind_submit_err)");
    }
    label408:
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof bv)))
    {
      paramString = ((bv)paramp).dVE();
      if ((paramString != null) && (!((Collection)paramString).isEmpty()))
      {
        paramInt1 = 1;
        if (!this.AXB.isEmpty()) {
          break label562;
        }
        if (paramInt1 == 0) {
          break label622;
        }
        this.AXB.add(hv(1, 1));
        this.AXB.addAll((Collection)g(((bv)paramp).dVE(), 1));
        this.pUj.addAll(0, (Collection)this.AXB);
        paramString = this.AXA;
        if (paramString != null) {
          break label559;
        }
        kotlin.g.b.s.bIx("viewCallback");
        paramString = localObject4;
      }
      label559:
      for (;;)
      {
        paramString.i(false, 0, this.AXB.size());
        AppMethodBeat.o(363628);
        return;
        paramInt1 = 0;
        break;
      }
      label562:
      if (paramInt1 != 0)
      {
        paramp = g(((bv)paramp).dVE(), 1);
        this.pUj.addAll(1, (Collection)paramp);
        paramString = this.AXA;
        if (paramString != null) {
          break label629;
        }
        kotlin.g.b.s.bIx("viewCallback");
        paramString = localObject2;
      }
    }
    label622:
    label629:
    for (;;)
    {
      paramString.i(false, 1, paramp.size());
      AppMethodBeat.o(363628);
      return;
    }
    label632:
    paramString = new ah.f();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof dd))
      {
        localObject1 = c.b.b(((dd)paramp).rr.otB);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderPoiListRequest");
          AppMethodBeat.o(363628);
          throw paramString;
        }
        localObject1 = ((ckc)localObject1).ZEQ;
        if (!kotlin.g.b.s.p(this.AyB, localObject1))
        {
          Log.i("Finder.FinderPoiManageUIContract", "not my buf, ignore!");
          AppMethodBeat.o(363628);
          return;
        }
        localObject1 = c.c.b(((dd)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderPoiListResponse");
          AppMethodBeat.o(363628);
          throw paramString;
        }
        if (((ckd)localObject1).BeA != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.hasMore = bool;
          localObject1 = c.c.b(((dd)paramp).rr.otC);
          if (localObject1 != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderPoiListResponse");
          AppMethodBeat.o(363628);
          throw paramString;
        }
        this.AyB = ((ckd)localObject1).ZEQ;
        localObject1 = c.c.b(((dd)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderPoiListResponse");
          AppMethodBeat.o(363628);
          throw paramString;
        }
        localObject1 = g(((ckd)localObject1).ZEK, ((dd)paramp).pullType);
        Log.i("Finder.FinderPoiManageUIContract", "newData： " + ((dd)paramp).pullType + ", " + localObject1 + ", " + ((ArrayList)localObject1).size());
        if (((dd)paramp).pullType == 1)
        {
          if (this.AXB.isEmpty()) {
            if (((Collection)localObject1).isEmpty()) {
              break label1062;
            }
          }
          label1062:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              this.AXB.add(hv(((dd)paramp).pullType, 1));
            }
            this.AXB.addAll((Collection)localObject1);
            if (!this.hasMore) {
              break;
            }
            L(true, 1);
            AppMethodBeat.o(363628);
            return;
          }
          Log.i("Finder.FinderPoiManageUIContract", kotlin.g.b.s.X("init audit data done, ", Integer.valueOf(this.AXB.size())));
          this.pUj.addAll((Collection)this.AXB);
          L(false, 2);
          AppMethodBeat.o(363628);
          return;
        }
        if ((((dd)paramp).pullType == 2) && (this.AXE))
        {
          if (((Collection)localObject1).isEmpty()) {
            break label1256;
          }
          paramInt1 = j;
          if (paramInt1 != 0) {
            this.pUj.add(hv(((dd)paramp).pullType, 2));
          }
        }
        paramString.aqH = new aj.b..ExternalSyntheticLambda0(this, (ArrayList)localObject1);
      }
      else
      {
        l = SystemClock.uptimeMillis() - this.AXD;
        if (!this.AXC)
        {
          paramp = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue()) {
            break label1261;
          }
        }
      }
      for (long l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() - l)
      {
        com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new a(paramString));
        AppMethodBeat.o(363628);
        return;
        label1256:
        paramInt1 = 0;
        break;
        label1261:
        paramp = com.tencent.mm.plugin.finder.storage.d.FAy;
      }
    }
    Log.i("Finder.FinderPoiManageUIContract", "net error");
    paramString = this.AXA;
    if (paramString == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      paramString = null;
      paramp = new RefreshLoadMoreLayout.d(0);
      paramp.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
      paramp.agJs = -1;
      paramString = paramString.ATx;
      if (paramString != null) {
        break label1381;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramString = localObject3;
    }
    label1381:
    for (;;)
    {
      paramString.k(paramp);
      AppMethodBeat.o(363628);
      return;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(ah.f<Runnable> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aj.b
 * JD-Core Version:    0.7.0.1
 */