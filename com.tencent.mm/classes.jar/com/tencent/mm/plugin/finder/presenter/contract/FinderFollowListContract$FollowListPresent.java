package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "doGetFollowScene", "", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListPresent
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowListContract.FollowListViewCallback>
{
  private final String TAG;
  boolean hasMore;
  public final ArrayList<t> jfg;
  private com.tencent.mm.bx.b rHF;
  private FinderFollowListContract.FollowListViewCallback slZ;
  private final com.tencent.mm.plugin.finder.storage.data.f sma;
  private boolean smb;
  private long smc;
  
  public FinderFollowListContract$FollowListPresent()
  {
    AppMethodBeat.i(203118);
    this.TAG = ("Finder.FinderFollowListContract.FollowListPresent." + hashCode());
    this.jfg = new ArrayList();
    FinderFollowListUIC.a locala = FinderFollowListUIC.tby;
    this.sma = new com.tencent.mm.plugin.finder.storage.data.f(FinderFollowListUIC.cOo());
    this.hasMore = true;
    this.smc = SystemClock.uptimeMillis();
    AppMethodBeat.o(203118);
  }
  
  public final void a(FinderFollowListContract.FollowListViewCallback paramFollowListViewCallback)
  {
    AppMethodBeat.i(203113);
    p.h(paramFollowListViewCallback, "callback");
    this.slZ = paramFollowListViewCallback;
    g.aiU().a(713, (com.tencent.mm.al.f)this);
    g.aiU().a(3867, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(203113);
  }
  
  public final void lX(boolean paramBoolean)
  {
    AppMethodBeat.i(203117);
    this.smc = SystemClock.uptimeMillis();
    this.smb = paramBoolean;
    ak localak = new ak(this.rHF);
    g.aiU().b((n)localak);
    AppMethodBeat.o(203117);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(203115);
    g.aiU().b(713, (com.tencent.mm.al.f)this);
    g.aiU().b(3867, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(203115);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(203116);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null)
    {
      paramString = Integer.valueOf(paramn.getType());
      ad.i((String)localObject1, paramString);
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
        AppMethodBeat.o(203116);
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
          paramString.MLV = null;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject1 = new y.a();
            ((y.a)localObject1).MLQ = false;
            if (paramn == null)
            {
              paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
              AppMethodBeat.o(203116);
              throw paramString;
            }
            localObject2 = ((ak)paramn).cym();
            if ((p.i(this.rHF, localObject2) ^ true))
            {
              ad.i(this.TAG, "not my buf, ignore!");
              AppMethodBeat.o(203116);
              return;
            }
            if (this.rHF == null)
            {
              localObject2 = this.slZ;
              if (localObject2 == null) {
                p.bcb("viewCallback");
              }
              ((FinderFollowListContract.FollowListViewCallback)localObject2).cDe();
              ((y.a)localObject1).MLQ = true;
              c.a(c.akP(), (d.g.a.b)new d.g.b.q((y.a)localObject1) {});
            }
            this.hasMore = ((ak)paramn).cyj();
            this.rHF = ((ak)paramn).cyh();
            paramString.MLV = ((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203110);
                FinderFollowListContract.FollowListPresent.a(this.smd, this.smg.MLQ, (List)((ak)paramn).cyl(), FinderFollowListContract.FollowListPresent.b(this.smd));
                AppMethodBeat.o(203110);
              }
            });
          }
          long l = SystemClock.uptimeMillis() - this.smc;
          if (!this.smb)
          {
            paramn = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (l < ((Number)com.tencent.mm.plugin.finder.storage.b.cHI().value()).longValue()) {
              break label397;
            }
          }
          for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.b.cHI().value()).longValue() - l)
          {
            c.a(l, (d.g.a.a)new d.g.b.q(paramString) {});
            AppMethodBeat.o(203116);
            return;
            paramn = com.tencent.mm.plugin.finder.storage.b.sxa;
          }
        }
      }
    }
    if ((paramString.intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderFollow");
        AppMethodBeat.o(203116);
        throw paramString;
      }
      paramInt1 = ((ae)paramn).opType;
      paramString = ae.rJh;
      if (paramInt1 == ae.cye())
      {
        j.b((List)this.jfg, (d.g.a.b)new d.g.b.q(paramn) {});
        paramString = this.slZ;
        if (paramString == null) {
          p.bcb("viewCallback");
        }
        FinderFollowListContract.FollowListViewCallback.b(paramString);
        paramString = g.ajC();
        p.g(paramString, "MMKernel.storage()");
        paramInt1 = paramString.ajl().getInt(al.a.IHU, 0);
        ad.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0)
        {
          paramString = g.ajC();
          p.g(paramString, "MMKernel.storage()");
          paramString.ajl().set(al.a.IHU, Integer.valueOf(paramInt1 - 1));
        }
        paramString = this.slZ;
        if (paramString == null) {
          p.bcb("viewCallback");
        }
        paramString.cDe();
      }
    }
    AppMethodBeat.o(203116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent
 * JD-Core Version:    0.7.0.1
 */