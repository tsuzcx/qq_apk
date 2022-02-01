package com.tencent.mm.plugin.finder.search;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearchExpose", "needClear", "startSearchQuery", "plugin-finder_release"})
public final class FinderMixSearchPresenter
  implements com.tencent.mm.ak.g, e.a
{
  private final String TAG;
  private int continueFlag;
  private String dlj;
  private ArrayList<BaseFinderFeed> feedList;
  private MMActivity iMV;
  private int offset;
  private String query;
  private as rAB;
  private e.b rAZ;
  private HashMap<String, a> rAx;
  private com.tencent.mm.bw.b rmJ;
  private ArrayList<anr> rpr;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(166815);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.dlj = "";
    this.rpr = new ArrayList();
    this.feedList = new ArrayList();
    this.rAx = new HashMap();
    this.iMV = paramMMActivity;
    AppMethodBeat.o(166815);
  }
  
  private final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!bs.isNullOrNil(this.dlj)) {
      if (((Map)this.rAx).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.rxs;
        com.tencent.mm.plugin.finder.report.e.a(this.dlj, this.query, this.rAx, 1);
        if (paramBoolean) {
          this.rAx.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void J(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166813);
    d locald = d.rxr;
    Z(d.ut(paramLong), paramInt, 2);
    AppMethodBeat.o(166813);
  }
  
  public final void Z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    k.h(paramString, "id");
    if (!this.rAx.containsKey(paramString))
    {
      ac.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      a locala = new a();
      locala.adU(paramString);
      locala.position = paramInt1;
      locala.type = paramInt2;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.rAx).put(paramString, locala);
      if (this.rAx.size() % 30 == 0) {
        lG(false);
      }
    }
    AppMethodBeat.o(166814);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(166807);
    k.h(paramb, "callback");
    this.rAZ = paramb;
    AppMethodBeat.o(166807);
  }
  
  public final void a(anr paramanr, int paramInt)
  {
    AppMethodBeat.i(166809);
    k.h(paramanr, "finderSearchInfo");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramanr.contact.username);
    Object localObject2 = FinderReporterUIC.seQ;
    FinderReporterUIC.a.a((Context)this.iMV, (Intent)localObject1, 0L, 7, false, 64);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.iMV, (Intent)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.report.e.rxs;
    localObject1 = this.dlj;
    localObject2 = this.query;
    String str = paramanr.contact.username;
    k.g(str, "finderSearchInfo.contact.username");
    com.tencent.mm.plugin.finder.report.e.b((String)localObject1, (String)localObject2, 1, str, paramInt, 1);
    localObject1 = FinderReporterUIC.seQ;
    localObject1 = FinderReporterUIC.a.eV((Context)this.iMV);
    if (localObject1 != null)
    {
      localObject2 = d.rxr;
      paramInt = ((FinderReporterUIC)localObject1).rfR;
      paramanr = paramanr.contact.username;
      k.g(paramanr, "finderSearchInfo.contact.username");
      d.a(6, 0L, paramInt, 1, paramanr);
      AppMethodBeat.o(166809);
      return;
    }
    AppMethodBeat.o(166809);
  }
  
  public final void adV(String paramString)
  {
    AppMethodBeat.i(166803);
    k.h(paramString, "query");
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 3L, 1L, false);
    lG(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.rmJ = null;
    this.rpr.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    k.g(str, "UUID.randomUUID().toString()");
    this.dlj = str;
    if (this.rAB != null)
    {
      com.tencent.mm.kernel.g.agi().a((n)this.rAB);
      this.rAB = null;
    }
    if (!bs.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.dlj;
      com.tencent.mm.bw.b localb = this.rmJ;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
      this.rAB = new as(paramString, i, str, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).cGb(), 16);
      com.tencent.mm.kernel.g.agi().b((n)this.rAB);
      com.tencent.mm.kernel.g.agi().a(3820, (com.tencent.mm.ak.g)this);
      paramString = this.rAZ;
      if (paramString != null)
      {
        paramString.cxM();
        AppMethodBeat.o(166803);
        return;
      }
    }
    AppMethodBeat.o(166803);
  }
  
  public final List<anr> cxJ()
  {
    return (List)this.rpr;
  }
  
  public final void cxK()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    ajw localajw = new ajw();
    localajw.dlj = this.dlj;
    localajw.query = this.query;
    localajw.offset = this.offset;
    localajw.continueFlag = 1;
    localajw.rmJ = this.rmJ;
    Object localObject2 = (Iterable)this.rpr;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      anr localanr = (anr)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localajw.rHC.add(localanr)));
    }
    try
    {
      localIntent.putExtra("request_type", 1);
      label148:
      localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
      localObject1 = this.iMV.getContext();
      k.g(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localajw, localIntent);
      AppMethodBeat.o(166810);
      return;
    }
    catch (Exception localException)
    {
      break label148;
    }
  }
  
  public final boolean cxL()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.dlj;
        com.tencent.mm.bw.b localb = this.rmJ;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
        this.rAB = new as(str1, i, str2, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).cGb());
        com.tencent.mm.kernel.g.agi().b((n)this.rAB);
        com.tencent.mm.kernel.g.agi().a(3820, (com.tencent.mm.ak.g)this);
        AppMethodBeat.o(166811);
        return true;
      }
      AppMethodBeat.o(166811);
      return false;
    }
    AppMethodBeat.o(166811);
    return false;
  }
  
  public final void k(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166812);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bb(paramBaseFinderFeed);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aeE());
    k.h(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new ajw();
    ((ajw)localObject1).dlj = this.dlj;
    ((ajw)localObject1).query = this.query;
    ((ajw)localObject1).offset = this.offset;
    ((ajw)localObject1).continueFlag = 1;
    ((ajw)localObject1).rmJ = this.rmJ;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((ajw)localObject1).qJK.add(localBaseFinderFeed.feedObject.getFeedObject())));
    }
    localObject2 = ((ajw)localObject1).qJK;
    k.g(localObject2, "finderFeedSearchObj.objectList");
    localObject3 = ((Iterable)localObject2).iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id == ((FinderObject)localObject2).id)
        {
          ((ajw)localObject1).EEt = i;
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.e.rxs;
          paramBaseFinderFeed = this.dlj;
          localObject3 = this.query;
          long l = ((FinderObject)localObject2).id;
          k.h(paramBaseFinderFeed, "requestId");
          localObject2 = d.rxr;
          com.tencent.mm.plugin.finder.report.e.b(paramBaseFinderFeed, (String)localObject3, 2, d.ut(l), i, 1);
        }
      }
      else
      {
        paramBaseFinderFeed = new Intent();
        localObject2 = FinderReporterUIC.seQ;
        FinderReporterUIC.a.a((Context)this.iMV, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.iMV, (ajw)localObject1, paramBaseFinderFeed);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V");
        AppMethodBeat.o(166812);
        return;
      }
      i += 1;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166806);
    com.tencent.mm.kernel.g.agi().b(3820, (com.tencent.mm.ak.g)this);
    lG(true);
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166805);
    com.tencent.mm.kernel.g.agi().b(3820, (com.tencent.mm.ak.g)this);
    int i = this.rpr.size();
    int j = this.feedList.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.rAB;
      if (paramString != null) {}
      for (paramString = paramString.qYC; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramn = paramString.uEi;
      k.g(paramn, "response.infoList");
      Object localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anr)((Iterator)localObject1).next();
        if (((anr)localObject2).contact != null) {
          this.rpr.add(localObject2);
        }
        paramn.add(y.KTp);
      }
      paramn = paramString.qJK;
      k.g(paramn, "response.objectList");
      localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.rDA;
        k.g(localObject2, "it");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 16);
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        localObject2 = b.a.i((FinderItem)localObject2);
        paramn.add(Boolean.valueOf(this.feedList.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.rmJ = paramString.rmJ;
      ac.i(this.TAG, "onSceneEnd " + paramString.uEi.size() + ' ' + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.rpr.size() + ' ' + this.feedList.size());
    }
    for (;;)
    {
      paramString = this.rAZ;
      if (paramString == null) {
        break;
      }
      paramString.fz(i, j);
      AppMethodBeat.o(166805);
      return;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 5L, 1L, false);
    }
    AppMethodBeat.o(166805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter
 * JD-Core Version:    0.7.0.1
 */