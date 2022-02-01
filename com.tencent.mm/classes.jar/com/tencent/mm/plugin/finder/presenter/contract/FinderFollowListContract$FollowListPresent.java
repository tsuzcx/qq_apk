package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.aa;
import com.tencent.mm.plugin.finder.viewmodel.component.aa.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "clearLastBuff", "", "doGetFollowScene", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "printDebugFinderContactList", "firstPage", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFollowListContract$FollowListPresent
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowListContract.FollowListViewCallback>
{
  private long AXD;
  private boolean AYD;
  com.tencent.mm.bx.b AyB;
  private FinderFollowListContract.FollowListViewCallback EXE;
  private final g EXF;
  private final String TAG;
  boolean hasMore;
  final ArrayList<aj> pUj;
  
  public FinderFollowListContract$FollowListPresent()
  {
    AppMethodBeat.i(343756);
    this.TAG = kotlin.g.b.s.X("Finder.FinderFollowListContract.FollowListPresent.", Integer.valueOf(hashCode()));
    this.pUj = new ArrayList();
    aa.a locala = aa.GQm;
    this.EXF = new g(aa.fnH());
    this.hasMore = true;
    this.AXD = SystemClock.uptimeMillis();
    AppMethodBeat.o(343756);
  }
  
  private static final void a(FollowListPresent paramFollowListPresent, ah.a parama, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(343769);
    kotlin.g.b.s.u(paramFollowListPresent, "this$0");
    kotlin.g.b.s.u(parama, "$firstPage");
    boolean bool1 = parama.aiwY;
    List localList = (List)((cj)paramp).dVR();
    boolean bool2 = paramFollowListPresent.AYD;
    Log.i(paramFollowListPresent.TAG, "firstPage " + bool1 + ", get follow contact " + localList.size());
    int j = paramFollowListPresent.pUj.size();
    int i = localList.size();
    if (bool1)
    {
      paramFollowListPresent.pUj.clear();
      i = -1;
      j = -1;
    }
    for (;;)
    {
      parama = paramFollowListPresent.pUj;
      Object localObject = (Iterable)localList;
      paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramp.add(new aj(com.tencent.mm.plugin.finder.api.c.a((FinderContact)((Iterator)localObject).next())));
      }
      parama.addAll((Collection)paramp);
      paramp = paramFollowListPresent.EXE;
      parama = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("viewCallback");
        parama = null;
      }
      parama.i(bool2, j, i);
      paramFollowListPresent.e(bool1, localList);
      AppMethodBeat.o(343769);
      return;
    }
  }
  
  private void e(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(343762);
    kotlin.g.b.s.u(paramList, "dataList");
    Object localObject = av.GiL;
    if (!av.bgV())
    {
      AppMethodBeat.o(343762);
      return;
    }
    localObject = new StringBuilder("firstPage:" + paramBoolean + ';');
    int k = paramList.size();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      ((StringBuilder)localObject).append("[" + i + "]:").append(com.tencent.mm.ae.f.dg(paramList.get(i))).append(";");
      if (j >= k)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("printFinderContactList :", localObject));
        AppMethodBeat.o(343762);
        return;
      }
      i = j;
    }
  }
  
  public final void a(FinderFollowListContract.FollowListViewCallback paramFollowListViewCallback)
  {
    AppMethodBeat.i(343794);
    kotlin.g.b.s.u(paramFollowListViewCallback, "callback");
    this.EXE = paramFollowListViewCallback;
    com.tencent.mm.kernel.h.aZW().a(713, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3867, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(343794);
  }
  
  public final void onDetach()
  {
    Object localObject2 = null;
    AppMethodBeat.i(343799);
    com.tencent.mm.kernel.h.aZW().b(713, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3867, (com.tencent.mm.am.h)this);
    Object localObject3 = this.EXE;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    localObject3 = localObject1.mkw;
    if (localObject3 == null) {
      kotlin.g.b.s.bIx("recyclerView");
    }
    for (;;)
    {
      localObject2.b((RecyclerView.l)localObject1.EXK);
      AppMethodBeat.o(343799);
      return;
      localObject2 = localObject3;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    ah.f localf = null;
    Object localObject1 = null;
    AppMethodBeat.i(343814);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramp == null)
    {
      paramString = null;
      Log.i((String)localObject2, paramString);
      if (paramp != null) {
        break label115;
      }
      paramString = null;
      label88:
      if (paramString != null) {
        break label127;
      }
    }
    for (;;)
    {
      label389:
      if (paramString == null)
      {
        AppMethodBeat.o(343814);
        return;
        paramString = Integer.valueOf(paramp.getType());
        break;
        label115:
        paramString = Integer.valueOf(paramp.getType());
        break label88;
        label127:
        if (paramString.intValue() == 713)
        {
          localf = new ah.f();
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject2 = new ah.a();
            if (paramp == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
              AppMethodBeat.o(343814);
              throw paramString;
            }
            paramString = ((cj)paramp).dVL();
            if (!kotlin.g.b.s.p(this.AyB, paramString))
            {
              Log.i(this.TAG, "not my buf, ignore!");
              AppMethodBeat.o(343814);
              return;
            }
            if (this.AyB == null)
            {
              paramString = this.EXE;
              if (paramString == null)
              {
                kotlin.g.b.s.bIx("viewCallback");
                paramString = localObject1;
                paramString.eHZ();
                ((ah.a)localObject2).aiwY = true;
                com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new u(paramp) {});
              }
            }
            else
            {
              this.hasMore = ((cj)paramp).dVN();
              this.AyB = ((cj)paramp).dVJ();
              localf.aqH = new FinderFollowListContract.FollowListPresent..ExternalSyntheticLambda0(this, (ah.a)localObject2, paramp);
            }
          }
          else
          {
            l = SystemClock.uptimeMillis() - this.AXD;
            if (!this.AYD)
            {
              paramString = com.tencent.mm.plugin.finder.storage.d.FAy;
              if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue()) {
                break label389;
              }
            }
          }
          for (long l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.eTh().bmg()).longValue() - l)
          {
            com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new u(localf) {});
            AppMethodBeat.o(343814);
            return;
            break;
            paramString = com.tencent.mm.plugin.finder.storage.d.FAy;
          }
        }
      }
    }
    if ((paramString.intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = paramp.getReqResp();
      if (!(paramString instanceof com.tencent.mm.am.c)) {
        break label634;
      }
      paramString = (com.tencent.mm.am.c)paramString;
      if (paramString != null) {
        break label639;
      }
      paramString = null;
      label455:
      if (!(paramString instanceof axp)) {
        break label650;
      }
      paramString = (axp)paramString;
      label467:
      if (paramString == null) {
        break label655;
      }
      paramInt1 = paramString.opType;
      paramp = bh.ABm;
      if (paramInt1 != bh.dVs()) {
        break label655;
      }
      paramString = paramString.ZHf;
      label493:
      if (!Util.isNullOrNil(paramString))
      {
        kotlin.a.p.e((List)this.pUj, (kotlin.g.a.b)new u(paramString) {});
        paramp = this.EXE;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("viewCallback");
          paramString = null;
        }
        FinderFollowListContract.FollowListViewCallback.b(paramString);
        paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcN, 0);
        Log.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adcN, Integer.valueOf(paramInt1 - 1));
        }
        paramString = this.EXE;
        if (paramString != null) {
          break label662;
        }
        kotlin.g.b.s.bIx("viewCallback");
        paramString = localf;
      }
    }
    label650:
    label655:
    label662:
    for (;;)
    {
      paramString.eHZ();
      AppMethodBeat.o(343814);
      return;
      label634:
      paramString = null;
      break;
      label639:
      paramString = c.b.b(paramString.otB);
      break label455;
      paramString = null;
      break label467;
      paramString = "";
      break label493;
    }
  }
  
  public final void tc(boolean paramBoolean)
  {
    AppMethodBeat.i(343823);
    this.AXD = SystemClock.uptimeMillis();
    this.AYD = paramBoolean;
    cj localcj = new cj(this.AyB);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localcj, 0);
    AppMethodBeat.o(343823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent
 * JD-Core Version:    0.7.0.1
 */