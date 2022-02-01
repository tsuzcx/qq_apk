package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.storage.u;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scene", "", "requestScene", "msgTypes", "", "(II[I)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getMsgTypes", "()[I", "getRequestScene", "()I", "getScene", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderMsgUIItemBrowseStruct;", "unreadMention", "", "viewCallback", "getData", "loadMoreData", "mentionId", "limit", "mergeData", "", "increment", "", "raw", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestRefresh", "sortMentionList", "plugin-finder_release"})
public final class FinderMsgContract$MsgPresenter
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.finder.presenter.base.a<FinderMsgContract.MsgViewCallback>
{
  private final String TAG;
  final ArrayList<com.tencent.mm.plugin.finder.model.a> dataList;
  final int qYe;
  private FinderMsgContract.MsgViewCallback rwH;
  private long rwI;
  private final av rwJ;
  private final int[] rwK;
  final int scene;
  
  public FinderMsgContract$MsgPresenter(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(202696);
    this.scene = paramInt1;
    this.qYe = paramInt2;
    this.rwK = paramArrayOfInt;
    this.TAG = ("Finder.FinderFinderMsgContract.MsgPresenter." + hashCode());
    this.dataList = new ArrayList();
    this.rwJ = new av();
    AppMethodBeat.o(202696);
  }
  
  public final int F(long paramLong, int paramInt)
  {
    AppMethodBeat.i(202695);
    FinderMsgContract.MsgViewCallback localMsgViewCallback = this.rwH;
    if (localMsgViewCallback != null)
    {
      Object localObject2 = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.rFp;
      localObject1 = (Iterable)d.a.a(paramLong, paramInt, this.rwK, this.scene);
      Object localObject3 = (Collection)new ArrayList();
      Object localObject4 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (u)((Iterator)localObject4).next();
        d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.rFp;
        k.h(localObject1, "mention");
        switch (((u)localObject1).field_type)
        {
        case 6: 
        default: 
          localObject1 = null;
        }
        while (localObject1 != null)
        {
          ((Collection)localObject3).add(localObject1);
          break;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new ad((u)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new ab((u)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new x((u)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new com.tencent.mm.plugin.finder.model.ac((u)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new y((u)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new aa((u)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new z((u)localObject1);
        }
      }
      localObject1 = (List)localObject3;
      com.tencent.mm.sdk.platformtools.ac.d(this.TAG, "loadMoreData mentionId:" + paramLong + " limit:" + paramInt + " list:" + ((List)localObject1).size());
      ((ArrayList)localObject2).addAll((Collection)localObject1);
      if (this.scene == 1)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.model.a)((Iterator)localObject3).next();
          if ((((com.tencent.mm.plugin.finder.model.a)localObject4).ruv.field_id >= this.rwI) && (this.rwI != 0L))
          {
            switch (((com.tencent.mm.plugin.finder.model.a)localObject4).ruv.field_type)
            {
            }
            for (;;)
            {
              localObject4 = this.rwJ;
              ((av)localObject4).ek(((av)localObject4).Qk() + 1L);
              localObject4 = this.rwJ;
              ((av)localObject4).ej(((av)localObject4).Qj() + 1L);
              break;
              localObject4 = this.rwJ;
              ((av)localObject4).en(((av)localObject4).Qn() + 1L);
              continue;
              localObject4 = this.rwJ;
              ((av)localObject4).eo(((av)localObject4).Qo() + 1L);
              continue;
              localObject4 = this.rwJ;
              ((av)localObject4).ep(((av)localObject4).Qp() + 1L);
              continue;
              localObject4 = this.rwJ;
              ((av)localObject4).em(((av)localObject4).Qm() + 1L);
            }
          }
          switch (((com.tencent.mm.plugin.finder.model.a)localObject4).ruv.field_type)
          {
          }
          for (;;)
          {
            localObject4 = this.rwJ;
            ((av)localObject4).el(((av)localObject4).Ql() + 1L);
            break;
            localObject4 = this.rwJ;
            ((av)localObject4).er(((av)localObject4).Qr() + 1L);
            continue;
            localObject4 = this.rwJ;
            ((av)localObject4).es(((av)localObject4).Qs() + 1L);
            continue;
            localObject4 = this.rwJ;
            ((av)localObject4).et(((av)localObject4).Qt() + 1L);
            continue;
            localObject4 = this.rwJ;
            ((av)localObject4).eq(((av)localObject4).Qq() + 1L);
          }
        }
      }
      localObject2 = (List)localObject2;
      k.h(localObject2, "msgList");
      com.tencent.mm.ac.c.g((d.g.a.a)new FinderMsgContract.MsgViewCallback.finishLoadMore.1(localMsgViewCallback, (List)localObject2));
      paramInt = ((List)localObject1).size();
      AppMethodBeat.o(202695);
      return paramInt;
    }
    AppMethodBeat.o(202695);
    return -1;
  }
  
  public final void a(FinderMsgContract.MsgViewCallback paramMsgViewCallback)
  {
    AppMethodBeat.i(166533);
    k.h(paramMsgViewCallback, "callback");
    this.rwH = paramMsgViewCallback;
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "onAttach " + this.qYe);
    com.tencent.mm.kernel.g.agi().a(978, (com.tencent.mm.ak.g)this);
    if (this.scene == 1)
    {
      av localav = this.rwJ;
      String str = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      paramMsgViewCallback = str;
      if (str == null) {
        paramMsgViewCallback = "";
      }
      localav.ic(paramMsgViewCallback);
    }
    AppMethodBeat.o(166533);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166535);
    if (this.scene == 1)
    {
      this.rwJ.aHZ();
      com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a((com.tencent.mm.plugin.report.a)this.rwJ);
    }
    this.rwH = null;
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "onDetach " + this.qYe);
    com.tencent.mm.kernel.g.agi().b(978, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(166535);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166540);
    String str = this.TAG;
    paramString = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(" errMsg ").append(paramString).append(" requestScene ");
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionList");
      AppMethodBeat.o(166540);
      throw paramString;
    }
    com.tencent.mm.sdk.platformtools.ac.i(str, ((ag)paramn).qYe);
    if ((((ag)paramn).scene != this.scene) || (this.qYe != ((ag)paramn).qYe))
    {
      com.tencent.mm.sdk.platformtools.ac.w(this.TAG, "not my scene or type, ignore");
      AppMethodBeat.o(166540);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((ag)paramn).fSw;
      paramn = (u)j.iR((List)paramString);
      long l;
      if (paramn != null)
      {
        l = paramn.field_id;
        com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "newUnreadMention " + l + ", unreadMention " + this.rwI);
        if (l > 0L)
        {
          if (this.rwI != 0L) {
            break label310;
          }
          this.rwI = l;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "unreadMention " + this.rwI + " newMenList:" + paramString.size());
        F(9223372036854775807L, paramString.size());
        AppMethodBeat.o(166540);
        return;
        l = 0L;
        break;
        label310:
        if (l < this.rwI) {
          this.rwI = l;
        }
      }
    }
    paramString = this.rwH;
    if (paramString != null)
    {
      if (this.dataList.isEmpty())
      {
        paramString.lC(false);
        paramString.n(c.a.a(paramString).getString(2131759246), c.a.a(paramString).getColor(2131099664), true);
        AppMethodBeat.o(166540);
        return;
      }
      paramString.lC(true);
      AppMethodBeat.o(166540);
      return;
    }
    AppMethodBeat.o(166540);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166538);
    FinderMsgContract.MsgViewCallback localMsgViewCallback = this.rwH;
    if (localMsgViewCallback != null) {
      localMsgViewCallback.n(null, 0, false);
    }
    localMsgViewCallback = this.rwH;
    if (localMsgViewCallback != null) {
      com.tencent.mm.ac.c.g((d.g.a.a)new FinderMsgContract.MsgViewCallback.showLoadingBar.1(localMsgViewCallback));
    }
    com.tencent.mm.kernel.g.agi().b((n)new ag(this.scene, this.qYe));
    AppMethodBeat.o(166538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter
 * JD-Core Version:    0.7.0.1
 */