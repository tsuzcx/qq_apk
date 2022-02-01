package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.a.j;
import d.g.b.p;
import d.g.b.y.a;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "doGetFollowScene", "", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListPresent
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowListContract.FollowListViewCallback>
{
  private final String TAG;
  boolean hasMore;
  public final ArrayList<u> jhZ;
  private com.tencent.mm.bw.b rPQ;
  private FinderFollowListContract.FollowListViewCallback svQ;
  private final com.tencent.mm.plugin.finder.storage.data.f svR;
  private boolean svS;
  private long svT;
  
  public FinderFollowListContract$FollowListPresent()
  {
    AppMethodBeat.i(203659);
    this.TAG = ("Finder.FinderFollowListContract.FollowListPresent." + hashCode());
    this.jhZ = new ArrayList();
    FinderFollowListUIC.a locala = FinderFollowListUIC.tmn;
    this.svR = new com.tencent.mm.plugin.finder.storage.data.f(FinderFollowListUIC.cQT());
    this.hasMore = true;
    this.svT = SystemClock.uptimeMillis();
    AppMethodBeat.o(203659);
  }
  
  public final void a(FinderFollowListContract.FollowListViewCallback paramFollowListViewCallback)
  {
    AppMethodBeat.i(203654);
    p.h(paramFollowListViewCallback, "callback");
    this.svQ = paramFollowListViewCallback;
    g.ajj().a(713, (com.tencent.mm.ak.f)this);
    g.ajj().a(3867, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(203654);
  }
  
  public final void lY(boolean paramBoolean)
  {
    AppMethodBeat.i(203658);
    this.svT = SystemClock.uptimeMillis();
    this.svS = paramBoolean;
    al localal = new al(this.rPQ);
    g.ajj().b((n)localal);
    AppMethodBeat.o(203658);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(203656);
    g.ajj().b(713, (com.tencent.mm.ak.f)this);
    g.ajj().b(3867, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(203656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(203657);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null)
    {
      paramString = Integer.valueOf(paramn.getType());
      ae.i((String)localObject1, paramString);
      if (paramn == null) {
        break label116;
      }
      paramString = Integer.valueOf(paramn.getType());
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
        AppMethodBeat.o(203657);
        return;
        paramString = null;
        break;
        label116:
        paramString = null;
        break label96;
        label121:
        if (paramString.intValue() == 713)
        {
          paramString = new y.f();
          paramString.NiY = null;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject1 = new y.a();
            ((y.a)localObject1).NiT = false;
            if (paramn == null)
            {
              paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
              AppMethodBeat.o(203657);
              throw paramString;
            }
            localObject2 = ((al)paramn).czN();
            if ((p.i(this.rPQ, localObject2) ^ true))
            {
              ae.i(this.TAG, "not my buf, ignore!");
              AppMethodBeat.o(203657);
              return;
            }
            if (this.rPQ == null)
            {
              localObject2 = this.svQ;
              if (localObject2 == null) {
                p.bdF("viewCallback");
              }
              ((FinderFollowListContract.FollowListViewCallback)localObject2).cEW();
              ((y.a)localObject1).NiT = true;
              c.a(c.ale(), (d.g.a.b)new d.g.b.q((y.a)localObject1) {});
            }
            this.hasMore = ((al)paramn).czK();
            this.rPQ = ((al)paramn).czI();
            paramString.NiY = ((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203651);
                FinderFollowListContract.FollowListPresent.a(this.svU, this.svX.NiT, (List)((al)paramn).czM(), FinderFollowListContract.FollowListPresent.b(this.svU));
                AppMethodBeat.o(203651);
              }
            });
          }
          long l = SystemClock.uptimeMillis() - this.svT;
          if (!this.svS)
          {
            paramn = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (l < ((Number)com.tencent.mm.plugin.finder.storage.b.cJH().value()).longValue()) {
              break label397;
            }
          }
          for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.b.cJH().value()).longValue() - l)
          {
            c.a(l, (d.g.a.a)new FinderFollowListContract.FollowListPresent.onSceneEnd.3(paramString));
            AppMethodBeat.o(203657);
            return;
            paramn = com.tencent.mm.plugin.finder.storage.b.sHP;
          }
        }
      }
    }
    if ((paramString.intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderFollow");
        AppMethodBeat.o(203657);
        throw paramString;
      }
      paramInt1 = ((af)paramn).opType;
      paramString = af.rRv;
      if (paramInt1 == af.czF())
      {
        j.c((List)this.jhZ, (d.g.a.b)new FinderFollowListContract.FollowListPresent.onSceneEnd.4.1(paramn));
        paramString = this.svQ;
        if (paramString == null) {
          p.bdF("viewCallback");
        }
        FinderFollowListContract.FollowListViewCallback.b(paramString);
        paramString = g.ajR();
        p.g(paramString, "MMKernel.storage()");
        paramInt1 = paramString.ajA().getInt(am.a.Jcx, 0);
        ae.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0)
        {
          paramString = g.ajR();
          p.g(paramString, "MMKernel.storage()");
          paramString.ajA().set(am.a.Jcx, Integer.valueOf(paramInt1 - 1));
        }
        paramString = this.svQ;
        if (paramString == null) {
          p.bdF("viewCallback");
        }
        paramString.cEW();
      }
    }
    AppMethodBeat.o(203657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent
 * JD-Core Version:    0.7.0.1
 */