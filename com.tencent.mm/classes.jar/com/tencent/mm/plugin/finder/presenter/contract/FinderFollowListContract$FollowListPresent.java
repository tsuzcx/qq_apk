package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.w;
import com.tencent.mm.plugin.finder.viewmodel.component.w.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "clearLastBuff", "", "doGetFollowScene", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "printDebugFinderContactList", "firstPage", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refresh", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListPresent
  implements i, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowListContract.FollowListViewCallback>
{
  private final String TAG;
  boolean hasMore;
  public final ArrayList<ah> mXB;
  private boolean xBb;
  private long xBe;
  com.tencent.mm.cd.b xaw;
  private FinderFollowListContract.FollowListViewCallback zMQ;
  private final com.tencent.mm.plugin.finder.storage.data.g zMR;
  
  public FinderFollowListContract$FollowListPresent()
  {
    AppMethodBeat.i(290208);
    this.TAG = ("Finder.FinderFollowListContract.FollowListPresent." + hashCode());
    this.mXB = new ArrayList();
    w.a locala = w.Bkt;
    this.zMR = new com.tencent.mm.plugin.finder.storage.data.g(w.ekC());
    this.hasMore = true;
    this.xBe = SystemClock.uptimeMillis();
    AppMethodBeat.o(290208);
  }
  
  private void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(290207);
    p.k(paramList, "dataList");
    Object localObject = aj.AGc;
    if (!aj.eej())
    {
      AppMethodBeat.o(290207);
      return;
    }
    localObject = new StringBuilder("firstPage:" + paramBoolean + ';');
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append("[" + i + "]:").append(com.tencent.mm.ae.g.bN(paramList.get(i))).append(";");
      i += 1;
    }
    Log.i(this.TAG, "printFinderContactList :".concat(String.valueOf(localObject)));
    AppMethodBeat.o(290207);
  }
  
  public final void a(FinderFollowListContract.FollowListViewCallback paramFollowListViewCallback)
  {
    AppMethodBeat.i(290201);
    p.k(paramFollowListViewCallback, "callback");
    this.zMQ = paramFollowListViewCallback;
    h.aGY().a(713, (i)this);
    h.aGY().a(3867, (i)this);
    AppMethodBeat.o(290201);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(290203);
    h.aGY().b(713, (i)this);
    h.aGY().b(3867, (i)this);
    FinderFollowListContract.FollowListViewCallback localFollowListViewCallback = this.zMQ;
    if (localFollowListViewCallback == null) {
      p.bGy("viewCallback");
    }
    RecyclerView localRecyclerView = localFollowListViewCallback.jLl;
    if (localRecyclerView == null) {
      p.bGy("recyclerView");
    }
    localRecyclerView.b((RecyclerView.l)localFollowListViewCallback.zMY);
    AppMethodBeat.o(290203);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(290205);
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
        AppMethodBeat.o(290205);
        return;
        paramString = null;
        break;
        label116:
        paramString = null;
        break label96;
        label121:
        if (paramString.intValue() == 713)
        {
          paramString = new aa.f();
          paramString.aaBC = null;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            localObject1 = new aa.a();
            ((aa.a)localObject1).aaBx = false;
            if (paramq == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
              AppMethodBeat.o(290205);
              throw paramString;
            }
            localObject2 = ((bm)paramq).dob();
            if ((p.h(this.xaw, localObject2) ^ true))
            {
              Log.i(this.TAG, "not my buf, ignore!");
              AppMethodBeat.o(290205);
              return;
            }
            if (this.xaw == null)
            {
              localObject2 = this.zMQ;
              if (localObject2 == null) {
                p.bGy("viewCallback");
              }
              ((FinderFollowListContract.FollowListViewCallback)localObject2).dMV();
              ((aa.a)localObject1).aaBx = true;
              com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new kotlin.g.b.q((aa.a)localObject1) {});
            }
            this.hasMore = ((bm)paramq).dod();
            this.xaw = ((bm)paramq).doa();
            paramString.aaBC = ((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(271740);
                FinderFollowListContract.FollowListPresent.a(this.zMS, this.zMV.aaBx, (List)((bm)paramq).doh(), FinderFollowListContract.FollowListPresent.b(this.zMS));
                AppMethodBeat.o(271740);
              }
            });
          }
          long l = SystemClock.uptimeMillis() - this.xBe;
          if (!this.xBb)
          {
            paramq = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue()) {
              break label397;
            }
          }
          for (l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() - l)
          {
            com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
            AppMethodBeat.o(290205);
            return;
            paramq = com.tencent.mm.plugin.finder.storage.d.AjH;
          }
        }
      }
    }
    if ((paramString.intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = paramq.getReqResp();
      paramString = paramq;
      if (!(paramq instanceof com.tencent.mm.an.d)) {
        paramString = null;
      }
      paramString = (com.tencent.mm.an.d)paramString;
      if (paramString == null) {
        break label666;
      }
      paramString = paramString.bhX();
      paramq = paramString;
      if (!(paramString instanceof atb)) {
        paramq = null;
      }
      paramString = (atb)paramq;
      if (paramString == null) {
        break label671;
      }
      paramInt1 = paramString.opType;
      paramq = an.xci;
      if (paramInt1 != an.dnM()) {
        break label671;
      }
    }
    label666:
    label671:
    for (paramString = paramString.SFp;; paramString = "")
    {
      if (!Util.isNullOrNil(paramString))
      {
        j.c((List)this.mXB, (kotlin.g.a.b)new kotlin.g.b.q(paramString) {});
        paramString = this.zMQ;
        if (paramString == null) {
          p.bGy("viewCallback");
        }
        FinderFollowListContract.FollowListViewCallback.b(paramString);
        paramString = h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramInt1 = paramString.aHp().getInt(ar.a.VAv, 0);
        Log.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0)
        {
          paramString = h.aHG();
          p.j(paramString, "MMKernel.storage()");
          paramString.aHp().set(ar.a.VAv, Integer.valueOf(paramInt1 - 1));
        }
        paramString = this.zMQ;
        if (paramString == null) {
          p.bGy("viewCallback");
        }
        paramString.dMV();
      }
      AppMethodBeat.o(290205);
      return;
      paramString = null;
      break;
    }
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(290206);
    this.xBe = SystemClock.uptimeMillis();
    this.xBb = paramBoolean;
    bm localbm = new bm(this.xaw);
    h.aGY().b((com.tencent.mm.an.q)localbm);
    AppMethodBeat.o(290206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListPresent
 * JD-Core Version:    0.7.0.1
 */