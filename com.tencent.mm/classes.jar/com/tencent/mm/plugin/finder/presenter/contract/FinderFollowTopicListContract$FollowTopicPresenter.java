package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.cgi.dp;
import com.tencent.mm.plugin.finder.model.bx;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "doGetFollowScene", "", "fakeTopicInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFollowTopicListContract$FollowTopicPresenter
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowTopicListContract.FollowTopicViewCallback>
{
  public static final Companion EXM;
  private static final String EXP;
  private long AXD;
  private boolean AYD;
  private com.tencent.mm.bx.b AyB;
  private FinderFollowTopicListContract.FollowTopicViewCallback EXN;
  private final l EXO;
  boolean hasMore;
  public final ArrayList<bx> pUj;
  
  static
  {
    AppMethodBeat.i(343737);
    EXM = new Companion((byte)0);
    EXP = "topicFollowList.fp";
    AppMethodBeat.o(343737);
  }
  
  public FinderFollowTopicListContract$FollowTopicPresenter()
  {
    AppMethodBeat.i(343693);
    this.EXO = new l(EXP);
    this.pUj = new ArrayList();
    this.hasMore = true;
    this.AXD = SystemClock.uptimeMillis();
    AppMethodBeat.o(343693);
  }
  
  private static final void a(FollowTopicPresenter paramFollowTopicPresenter, ah.a parama, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(343705);
    kotlin.g.b.s.u(paramFollowTopicPresenter, "this$0");
    kotlin.g.b.s.u(parama, "$firstPage");
    boolean bool1 = parama.aiwY;
    paramp = (List)((ck)paramp).dVS();
    boolean bool2 = paramFollowTopicPresenter.AYD;
    kotlin.g.b.s.u(paramp, "dataList");
    Log.i("Finder.FollowTopicPresenter", "firstPage " + bool1 + ", get follow contact " + paramp.size());
    int j = paramFollowTopicPresenter.pUj.size();
    int i = paramp.size();
    if (bool1)
    {
      paramFollowTopicPresenter.pUj.clear();
      i = -1;
      j = -1;
    }
    parama = paramFollowTopicPresenter.pUj;
    Object localObject = (Iterable)paramp;
    paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramp.add(new bx((bxv)((Iterator)localObject).next()));
    }
    parama.addAll((Collection)paramp);
    parama = paramFollowTopicPresenter.EXN;
    paramFollowTopicPresenter = parama;
    if (parama == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      paramFollowTopicPresenter = null;
    }
    paramFollowTopicPresenter.i(bool2, j, i);
    AppMethodBeat.o(343705);
  }
  
  public final void a(FinderFollowTopicListContract.FollowTopicViewCallback paramFollowTopicViewCallback)
  {
    AppMethodBeat.i(343751);
    kotlin.g.b.s.u(paramFollowTopicViewCallback, "callback");
    this.EXN = paramFollowTopicViewCallback;
    com.tencent.mm.kernel.h.aZW().a(712, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3844, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(343751);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(343758);
    com.tencent.mm.kernel.h.aZW().b(712, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3844, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(343758);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    FinderFollowTopicListContract.FollowTopicViewCallback localFollowTopicViewCallback = null;
    ah.f localf = null;
    Object localObject1 = null;
    AppMethodBeat.i(343774);
    Object localObject2 = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramp == null)
    {
      paramString = null;
      Log.i("Finder.FollowTopicPresenter", paramString);
      if (paramp != null) {
        break label112;
      }
      paramString = null;
      label85:
      if (paramString != null) {
        break label124;
      }
    }
    label256:
    label452:
    label459:
    for (;;)
    {
      label112:
      label248:
      if (paramString == null)
      {
        AppMethodBeat.o(343774);
        return;
        paramString = Integer.valueOf(paramp.getType());
        break;
        paramString = Integer.valueOf(paramp.getType());
        break label85;
        label124:
        if (paramString.intValue() == 712)
        {
          localf = new ah.f();
          boolean bool;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject2 = new ah.a();
            if (paramp == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowTopicList");
              AppMethodBeat.o(343774);
              throw paramString;
            }
            paramString = c.b.b(((ck)paramp).rr.otB);
            if ((paramString instanceof aza))
            {
              paramString = (aza)paramString;
              if (paramString != null) {
                break label248;
              }
            }
            for (paramString = null;; paramString = paramString.ZEQ)
            {
              if (kotlin.g.b.s.p(this.AyB, paramString)) {
                break label256;
              }
              Log.i("Finder.FollowTopicPresenter", "not my buf, ignore!");
              AppMethodBeat.o(343774);
              return;
              paramString = null;
              break;
            }
            if (this.AyB == null)
            {
              ((ah.a)localObject2).aiwY = true;
              com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new u(paramp) {});
            }
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adcO, Integer.valueOf(((ck)paramp).dVT()));
            paramString = this.EXN;
            if (paramString == null)
            {
              kotlin.g.b.s.bIx("viewCallback");
              paramString = null;
            }
            for (;;)
            {
              paramString.Rw(((ck)paramp).dVT());
              localFollowTopicViewCallback = this.EXN;
              paramString = localFollowTopicViewCallback;
              if (localFollowTopicViewCallback == null)
              {
                kotlin.g.b.s.bIx("viewCallback");
                paramString = null;
              }
              paramString.eIb();
              paramString = c.c.b(((ck)paramp).rr.otC);
              if (paramString != null) {
                break;
              }
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
              AppMethodBeat.o(343774);
              throw paramString;
            }
            if (((azb)paramString).BeA != 0)
            {
              bool = true;
              this.hasMore = bool;
              paramString = c.c.b(((ck)paramp).rr.otC);
              if (!(paramString instanceof azb)) {
                break label553;
              }
              paramString = (azb)paramString;
              if (paramString != null) {
                break label558;
              }
              paramString = localObject1;
              this.AyB = paramString;
              localf.aqH = new FinderFollowTopicListContract.FollowTopicPresenter..ExternalSyntheticLambda0(this, (ah.a)localObject2, paramp);
            }
          }
          else
          {
            l = SystemClock.uptimeMillis() - this.AXD;
            if (!this.AYD)
            {
              paramString = com.tencent.mm.plugin.finder.storage.d.FAy;
              if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue()) {
                break label566;
              }
            }
          }
          for (long l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() - l)
          {
            com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new u(localf) {});
            AppMethodBeat.o(343774);
            return;
            bool = false;
            break;
            paramString = null;
            break label452;
            paramString = paramString.ZEQ;
            break label459;
            paramString = com.tencent.mm.plugin.finder.storage.d.FAy;
          }
        }
      }
    }
    label553:
    label558:
    label566:
    if ((paramString.intValue() == 3844) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderTopicFollow");
        AppMethodBeat.o(343774);
        throw paramString;
      }
      paramString = (dp)paramp;
      paramInt1 = paramString.opType;
      paramp = dp.ADn;
      if (paramInt1 == dp.dVe()) {
        kotlin.a.p.e((List)this.pUj, (kotlin.g.a.b)new u(paramString) {});
      }
      paramp = this.EXN;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        paramString = null;
      }
      FinderFollowTopicListContract.FollowTopicViewCallback.b(paramString);
      paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcO, 0);
      if (paramInt1 > 0)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adcO, Integer.valueOf(paramInt1 - 1));
        paramp = this.EXN;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          paramString = null;
        }
        paramString.Rw(paramInt1 - 1);
        paramString = this.EXN;
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          paramString = localFollowTopicViewCallback;
        }
        for (;;)
        {
          paramString.eIb();
          AppMethodBeat.o(343774);
          return;
        }
      }
      paramp = this.EXN;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        paramString = null;
      }
      paramString.Rw(0);
      paramString = this.EXN;
      if (paramString != null) {
        break label851;
      }
      kotlin.g.b.s.bIx("viewCallback");
      paramString = localf;
    }
    label851:
    for (;;)
    {
      paramString.eIb();
      AppMethodBeat.o(343774);
      return;
    }
  }
  
  public final void tc(boolean paramBoolean)
  {
    AppMethodBeat.i(343779);
    this.AXD = SystemClock.uptimeMillis();
    this.AYD = paramBoolean;
    Object localObject = this.AyB;
    String str = z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    localObject = new ck((com.tencent.mm.bx.b)localObject, str);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    AppMethodBeat.o(343779);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter
 * JD-Core Version:    0.7.0.1
 */