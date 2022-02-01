package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "clearLastBuff", "", "doGetFollowScene", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "printDebugFinderContactList", "firstPage", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refresh", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListPresent
  implements i, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowListContract.FollowListViewCallback>
{
  private final String TAG;
  boolean hasMore;
  public final ArrayList<af> kgc;
  private boolean tQl;
  private long tQo;
  com.tencent.mm.bw.b tsO;
  private FinderFollowListContract.FollowListViewCallback uWC;
  private final com.tencent.mm.plugin.finder.storage.data.g uWD;
  
  public FinderFollowListContract$FollowListPresent()
  {
    AppMethodBeat.i(249725);
    this.TAG = ("Finder.FinderFollowListContract.FollowListPresent." + hashCode());
    this.kgc = new ArrayList();
    FinderFollowListUIC.a locala = FinderFollowListUIC.wwp;
    this.uWD = new com.tencent.mm.plugin.finder.storage.data.g(FinderFollowListUIC.dIb());
    this.hasMore = true;
    this.tQo = SystemClock.uptimeMillis();
    AppMethodBeat.o(249725);
  }
  
  private void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(249724);
    p.h(paramList, "dataList");
    Object localObject = y.vXH;
    if (!y.dCM())
    {
      AppMethodBeat.o(249724);
      return;
    }
    localObject = new StringBuilder("firstPage:" + paramBoolean + ';');
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append("[" + i + "]:").append(com.tencent.mm.ac.g.bN(paramList.get(i))).append(";");
      i += 1;
    }
    Log.i(this.TAG, "printFinderContactList :".concat(String.valueOf(localObject)));
    AppMethodBeat.o(249724);
  }
  
  public final void a(FinderFollowListContract.FollowListViewCallback paramFollowListViewCallback)
  {
    AppMethodBeat.i(249719);
    p.h(paramFollowListViewCallback, "callback");
    this.uWC = paramFollowListViewCallback;
    com.tencent.mm.kernel.g.azz().a(713, (i)this);
    com.tencent.mm.kernel.g.azz().a(3867, (i)this);
    AppMethodBeat.o(249719);
  }
  
  public final void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(249723);
    this.tQo = SystemClock.uptimeMillis();
    this.tQl = paramBoolean;
    bj localbj = new bj(this.tsO);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localbj);
    AppMethodBeat.o(249723);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(249721);
    com.tencent.mm.kernel.g.azz().b(713, (i)this);
    com.tencent.mm.kernel.g.azz().b(3867, (i)this);
    FinderFollowListContract.FollowListViewCallback localFollowListViewCallback = this.uWC;
    if (localFollowListViewCallback == null) {
      p.btv("viewCallback");
    }
    RecyclerView localRecyclerView = localFollowListViewCallback.hak;
    if (localRecyclerView == null) {
      p.btv("recyclerView");
    }
    localRecyclerView.b((RecyclerView.l)localFollowListViewCallback.uWK);
    AppMethodBeat.o(249721);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(249722);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramq != null)
    {
      paramString = Integer.valueOf(paramq.getType());
      Log.i((String)localObject1, paramString);
      if (paramq == null) {
        break label116;
      }
      paramString = Integer.valueOf(paramq.getType());
      label96:
      if (paramString != null) {
        break label121;
      }
    }
    for (;;)
    {
      label397:
      if (paramString == null)
      {
        AppMethodBeat.o(249722);
        return;
        paramString = null;
        break;
        label116:
        paramString = null;
        break label96;
        label121:
        if (paramString.intValue() == 713)
        {
          paramString = new z.f();
          paramString.SYG = null;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject1 = new z.a();
            ((z.a)localObject1).SYB = false;
            if (paramq == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
              AppMethodBeat.o(249722);
              throw paramString;
            }
            localObject2 = ((bj)paramq).cYn();
            if ((p.j(this.tsO, localObject2) ^ true))
            {
              Log.i(this.TAG, "not my buf, ignore!");
              AppMethodBeat.o(249722);
              return;
            }
            if (this.tsO == null)
            {
              localObject2 = this.uWC;
              if (localObject2 == null) {
                p.btv("viewCallback");
              }
              ((FinderFollowListContract.FollowListViewCallback)localObject2).dlR();
              ((z.a)localObject1).SYB = true;
              com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new kotlin.g.b.q((z.a)localObject1) {});
            }
            this.hasMore = ((bj)paramq).cYp();
            this.tsO = ((bj)paramq).cYm();
            paramString.SYG = ((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249716);
                FinderFollowListContract.FollowListPresent.a(this.uWE, this.uWH.SYB, (List)((bj)paramq).cYt(), FinderFollowListContract.FollowListPresent.b(this.uWE));
                AppMethodBeat.o(249716);
              }
            });
          }
          long l = SystemClock.uptimeMillis() - this.tQo;
          if (!this.tQl)
          {
            paramq = c.vCb;
            if (l < ((Number)c.dty().value()).longValue()) {
              break label397;
            }
          }
          for (l = 0L;; l = ((Number)c.dty().value()).longValue() - l)
          {
            com.tencent.mm.ac.d.a(l, (kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
            AppMethodBeat.o(249722);
            return;
            paramq = c.vCb;
          }
        }
      }
    }
    if ((paramString.intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = paramq.getReqResp();
      paramString = paramq;
      if (!(paramq instanceof com.tencent.mm.ak.d)) {
        paramString = null;
      }
      paramString = (com.tencent.mm.ak.d)paramString;
      if (paramString == null) {
        break label666;
      }
      paramString = paramString.aYJ();
      paramq = paramString;
      if (!(paramString instanceof arf)) {
        paramq = null;
      }
      paramString = (arf)paramq;
      if (paramString == null) {
        break label671;
      }
      paramInt1 = paramString.opType;
      paramq = bb.tve;
      if (paramInt1 != bb.cYj()) {
        break label671;
      }
    }
    label666:
    label671:
    for (paramString = paramString.LCo;; paramString = "")
    {
      if (!Util.isNullOrNil(paramString))
      {
        j.c((List)this.kgc, (kotlin.g.a.b)new kotlin.g.b.q(paramString) {});
        paramString = this.uWC;
        if (paramString == null) {
          p.btv("viewCallback");
        }
        FinderFollowListContract.FollowListViewCallback.b(paramString);
        paramString = com.tencent.mm.kernel.g.aAh();
        p.g(paramString, "MMKernel.storage()");
        paramInt1 = paramString.azQ().getInt(ar.a.OlA, 0);
        Log.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0)
        {
          paramString = com.tencent.mm.kernel.g.aAh();
          p.g(paramString, "MMKernel.storage()");
          paramString.azQ().set(ar.a.OlA, Integer.valueOf(paramInt1 - 1));
        }
        paramString = this.uWC;
        if (paramString == null) {
          p.btv("viewCallback");
        }
        paramString.dlR();
      }
      AppMethodBeat.o(249722);
      return;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent
 * JD-Core Version:    0.7.0.1
 */