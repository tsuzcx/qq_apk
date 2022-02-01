package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import d.a.j;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scene", "", "requestScene", "msgTypes", "", "(II[I)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getMsgTypes", "()[I", "getRequestScene", "()I", "getScene", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderMsgUIItemBrowseStruct;", "unreadMention", "", "viewCallback", "getData", "loadMoreData", "mentionId", "limit", "mergeData", "", "increment", "", "raw", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestRefresh", "plugin-finder_release"})
public final class FinderMsgContract$MsgPresenter
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.finder.presenter.base.a<FinderMsgContract.MsgViewCallback>
{
  final int KJH;
  private final hs KUv;
  private final String TAG;
  final ArrayList<com.tencent.mm.plugin.finder.model.a> dataList;
  private FinderMsgContract.MsgViewCallback qEY;
  private long qEZ;
  private final int[] qFa;
  final int scene;
  
  public FinderMsgContract$MsgPresenter(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(198760);
    this.scene = paramInt1;
    this.KJH = paramInt2;
    this.qFa = paramArrayOfInt;
    this.TAG = ("Finder.FinderFinderMsgContract.MsgPresenter." + hashCode());
    this.dataList = new ArrayList();
    this.KUv = new hs();
    AppMethodBeat.o(198760);
  }
  
  public final void a(FinderMsgContract.MsgViewCallback paramMsgViewCallback)
  {
    AppMethodBeat.i(166533);
    k.h(paramMsgViewCallback, "callback");
    this.qEY = paramMsgViewCallback;
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onAttach " + this.KJH);
    com.tencent.mm.kernel.g.aeS().a(978, (com.tencent.mm.al.g)this);
    if (this.scene == 1)
    {
      hs localhs = this.KUv;
      String str = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      paramMsgViewCallback = str;
      if (str == null) {
        paramMsgViewCallback = "";
      }
      localhs.aSb(paramMsgViewCallback);
    }
    AppMethodBeat.o(166533);
  }
  
  public final int al(long paramLong, int paramInt)
  {
    AppMethodBeat.i(198759);
    FinderMsgContract.MsgViewCallback localMsgViewCallback = this.qEY;
    if (localMsgViewCallback != null)
    {
      Object localObject2 = new ArrayList();
      Object localObject1 = d.qKK;
      localObject1 = (Iterable)d.a.a(paramLong, paramInt, this.qFa, this.scene);
      Object localObject3 = (Collection)new ArrayList();
      Object localObject4 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.finder.storage.l)((Iterator)localObject4).next();
        d.a locala = d.qKK;
        k.h(localObject1, "mention");
        switch (((com.tencent.mm.plugin.finder.storage.l)localObject1).field_type)
        {
        case 6: 
        default: 
          localObject1 = null;
        }
        while (localObject1 != null)
        {
          ((Collection)localObject3).add(localObject1);
          break;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new u((com.tencent.mm.plugin.finder.storage.l)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new t((com.tencent.mm.plugin.finder.storage.l)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new com.tencent.mm.plugin.finder.model.s((com.tencent.mm.plugin.finder.storage.l)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new com.tencent.mm.plugin.finder.model.ad((com.tencent.mm.plugin.finder.storage.l)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new aa((com.tencent.mm.plugin.finder.storage.l)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new ac((com.tencent.mm.plugin.finder.storage.l)localObject1);
          continue;
          localObject1 = (com.tencent.mm.plugin.finder.model.a)new ab((com.tencent.mm.plugin.finder.storage.l)localObject1);
        }
      }
      localObject1 = (List)localObject3;
      com.tencent.mm.sdk.platformtools.ad.d(this.TAG, "loadMoreData mentionId:" + paramLong + " limit:" + paramInt + " list:" + ((List)localObject1).size());
      ((ArrayList)localObject2).addAll((Collection)localObject1);
      if (this.scene == 1)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.plugin.finder.model.a)((Iterator)localObject3).next();
          if ((((com.tencent.mm.plugin.finder.model.a)localObject4).qDo.field_id >= this.qEZ) && (this.qEZ != 0L))
          {
            switch (((com.tencent.mm.plugin.finder.model.a)localObject4).qDo.field_type)
            {
            }
            for (;;)
            {
              localObject4 = this.KUv;
              ((hs)localObject4).yR(((hs)localObject4).aod() + 1L);
              localObject4 = this.KUv;
              ((hs)localObject4).yQ(((hs)localObject4).aky() + 1L);
              break;
              localObject4 = this.KUv;
              ((hs)localObject4).yU(((hs)localObject4).aKM() + 1L);
              continue;
              localObject4 = this.KUv;
              ((hs)localObject4).yV(((hs)localObject4).aKN() + 1L);
              continue;
              localObject4 = this.KUv;
              ((hs)localObject4).yW(((hs)localObject4).aLF() + 1L);
              continue;
              localObject4 = this.KUv;
              ((hs)localObject4).yT(((hs)localObject4).aFC() + 1L);
            }
          }
          switch (((com.tencent.mm.plugin.finder.model.a)localObject4).qDo.field_type)
          {
          }
          for (;;)
          {
            localObject4 = this.KUv;
            ((hs)localObject4).yS(((hs)localObject4).azA() + 1L);
            break;
            localObject4 = this.KUv;
            ((hs)localObject4).yY(((hs)localObject4).aQW() + 1L);
            continue;
            localObject4 = this.KUv;
            ((hs)localObject4).yZ(((hs)localObject4).aRc() + 1L);
            continue;
            localObject4 = this.KUv;
            ((hs)localObject4).za(((hs)localObject4).aRd() + 1L);
            continue;
            localObject4 = this.KUv;
            ((hs)localObject4).yX(((hs)localObject4).aQV() + 1L);
          }
        }
      }
      localObject2 = (List)localObject2;
      k.h(localObject2, "msgList");
      com.tencent.mm.ad.c.g((d.g.a.a)new FinderMsgContract.MsgViewCallback.finishLoadMore.1(localMsgViewCallback, (List)localObject2));
      paramInt = ((List)localObject1).size();
      AppMethodBeat.o(198759);
      return paramInt;
    }
    AppMethodBeat.o(198759);
    return -1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166535);
    if (this.scene == 1)
    {
      this.KUv.aBj();
      b localb = b.qFq;
      b.a((com.tencent.mm.plugin.report.a)this.KUv);
    }
    this.qEY = null;
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onDetach " + this.KJH);
    com.tencent.mm.kernel.g.aeS().b(978, (com.tencent.mm.al.g)this);
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
    com.tencent.mm.sdk.platformtools.ad.i(str, ((com.tencent.mm.plugin.finder.cgi.s)paramn).KJH);
    if ((((com.tencent.mm.plugin.finder.cgi.s)paramn).scene != this.scene) || (this.KJH != ((com.tencent.mm.plugin.finder.cgi.s)paramn).KJH))
    {
      com.tencent.mm.sdk.platformtools.ad.w(this.TAG, "not my scene or type, ignore");
      AppMethodBeat.o(166540);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.finder.cgi.s)paramn).fOL;
      paramn = (com.tencent.mm.plugin.finder.storage.l)j.iB((List)paramString);
      long l;
      if (paramn != null)
      {
        l = paramn.field_id;
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "newUnreadMention " + l + ", unreadMention " + this.qEZ);
        if (l > 0L)
        {
          if (this.qEZ != 0L) {
            break label310;
          }
          this.qEZ = l;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "unreadMention " + this.qEZ + " newMenList:" + paramString.size());
        al(9223372036854775807L, paramString.size());
        AppMethodBeat.o(166540);
        return;
        l = 0L;
        break;
        label310:
        if (l < this.qEZ) {
          this.qEZ = l;
        }
      }
    }
    paramString = this.qEY;
    if (paramString != null)
    {
      if (this.dataList.isEmpty())
      {
        paramString.kY(false);
        paramString.n(b.a.a(paramString).getString(2131759246), b.a.a(paramString).getColor(2131099664), true);
        AppMethodBeat.o(166540);
        return;
      }
      paramString.kY(true);
      AppMethodBeat.o(166540);
      return;
    }
    AppMethodBeat.o(166540);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166538);
    FinderMsgContract.MsgViewCallback localMsgViewCallback = this.qEY;
    if (localMsgViewCallback != null) {
      localMsgViewCallback.n(null, 0, false);
    }
    localMsgViewCallback = this.qEY;
    if (localMsgViewCallback != null) {
      com.tencent.mm.ad.c.g((d.g.a.a)new FinderMsgContract.MsgViewCallback.showLoadingBar.1(localMsgViewCallback));
    }
    com.tencent.mm.kernel.g.aeS().b((n)new com.tencent.mm.plugin.finder.cgi.s(this.scene, this.KJH));
    AppMethodBeat.o(166538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter
 * JD-Core Version:    0.7.0.1
 */