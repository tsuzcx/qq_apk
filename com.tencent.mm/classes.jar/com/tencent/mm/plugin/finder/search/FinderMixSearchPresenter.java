package com.tencent.mm.plugin.finder.search;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastSearchResult", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearchExpose", "needClear", "startSearchQuery", "plugin-finder_release"})
public final class FinderMixSearchPresenter
  implements f, e.a
{
  private final String TAG;
  private int continueFlag;
  private String dyb;
  private MMActivity fNT;
  private ArrayList<BaseFinderFeed> feedList;
  private int offset;
  private String query;
  private HashMap<String, a> sCS;
  private ba sCW;
  private String sDw;
  private e.b sDx;
  private final a sDy;
  private com.tencent.mm.bw.b skw;
  private ArrayList<ars> smS;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(166815);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.dyb = "";
    this.smS = new ArrayList();
    this.feedList = new ArrayList();
    this.sCS = new HashMap();
    this.sDw = "";
    this.sDy = new a(this);
    this.fNT = paramMMActivity;
    AppMethodBeat.o(166815);
  }
  
  private final void mc(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!bu.isNullOrNil(this.dyb)) {
      if (((Map)this.sCS).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.syU;
        com.tencent.mm.plugin.finder.report.j.a(this.dyb, this.query, this.sCS, 1);
        if (paramBoolean) {
          this.sCS.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void L(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166813);
    i locali = i.syT;
    ac(i.wL(paramLong), paramInt, 2);
    AppMethodBeat.o(166813);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(166807);
    p.h(paramb, "callback");
    this.sDx = paramb;
    this.sDy.alive();
    AppMethodBeat.o(166807);
  }
  
  public final void a(ars paramars, int paramInt)
  {
    AppMethodBeat.i(166809);
    p.h(paramars, "finderSearchInfo");
    Object localObject3 = new Intent();
    Object localObject1 = paramars.contact;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((Intent)localObject3).putExtra("finder_username", (String)localObject1);
    localObject1 = FinderReporterUIC.tnG;
    FinderReporterUIC.a.a((Context)this.fNT, (Intent)localObject3, 0L, 7, false, 64);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.fNT, (Intent)localObject3);
    localObject1 = com.tencent.mm.plugin.finder.report.j.syU;
    localObject3 = this.dyb;
    String str = this.query;
    localObject1 = paramars.contact;
    if (localObject1 != null)
    {
      localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    com.tencent.mm.plugin.finder.report.j.b((String)localObject3, str, 1, (String)localObject1, paramInt, 1);
    localObject1 = FinderReporterUIC.tnG;
    localObject1 = FinderReporterUIC.a.fc((Context)this.fNT);
    if (localObject1 != null)
    {
      localObject2 = i.syT;
      paramInt = ((FinderReporterUIC)localObject1).sch;
      paramars = paramars.contact;
      if (paramars != null)
      {
        localObject1 = paramars.username;
        paramars = (ars)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramars = "";
      }
      i.a(6, 0L, paramInt, 1, paramars);
      AppMethodBeat.o(166809);
      return;
    }
    AppMethodBeat.o(166809);
  }
  
  public final void ac(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    p.h(paramString, "id");
    if (!this.sCS.containsKey(paramString))
    {
      ae.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      a locala = new a();
      locala.setId(paramString);
      locala.position = paramInt1;
      locala.type = paramInt2;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.sCS).put(paramString, locala);
      if (this.sCS.size() % 30 == 0) {
        mc(false);
      }
    }
    AppMethodBeat.o(166814);
  }
  
  public final void aiS(String paramString)
  {
    AppMethodBeat.i(166803);
    p.h(paramString, "query");
    e.ywz.idkeyStat(1265L, 3L, 1L, false);
    mc(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.skw = null;
    this.smS.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    p.g(str, "UUID.randomUUID().toString()");
    this.dyb = str;
    if (this.sCW != null)
    {
      g.ajj().a((n)this.sCW);
      this.sCW = null;
    }
    if (!bu.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.dyb;
      com.tencent.mm.bw.b localb = this.skw;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
      this.sCW = new ba(paramString, i, str, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderReporterUIC.class)).cQZ(), 16);
      g.ajj().b((n)this.sCW);
      g.ajj().a(3820, (f)this);
      paramString = this.sDx;
      if (paramString != null)
      {
        paramString.cGF();
        AppMethodBeat.o(166803);
        return;
      }
    }
    AppMethodBeat.o(166803);
  }
  
  public final List<ars> cGC()
  {
    return (List)this.smS;
  }
  
  public final void cGD()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    ang localang = new ang();
    localang.dyb = this.dyb;
    localang.query = this.query;
    localang.offset = this.offset;
    localang.continueFlag = 1;
    localang.skw = this.skw;
    Object localObject2 = (Iterable)this.smS;
    Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ars localars = (ars)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localang.GFl.add(localars)));
    }
    try
    {
      localIntent.putExtra("request_type", 1);
      label148:
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject1 = this.fNT.getContext();
      p.g(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localang, localIntent);
      AppMethodBeat.o(166810);
      return;
    }
    catch (Exception localException)
    {
      break label148;
    }
  }
  
  public final boolean cGE()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.dyb;
        com.tencent.mm.bw.b localb = this.skw;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
        this.sCW = new ba(str1, i, str2, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderReporterUIC.class)).cQZ());
        g.ajj().b((n)this.sCW);
        g.ajj().a(3820, (f)this);
        AppMethodBeat.o(166811);
        return true;
      }
      AppMethodBeat.o(166811);
      return false;
    }
    AppMethodBeat.o(166811);
    return false;
  }
  
  public final void m(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166812);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramBaseFinderFeed);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    p.h(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new ang();
    ((ang)localObject1).dyb = this.dyb;
    ((ang)localObject1).query = this.query;
    ((ang)localObject1).offset = this.offset;
    ((ang)localObject1).continueFlag = 1;
    ((ang)localObject1).skw = this.skw;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((ang)localObject1).rBY.add(localBaseFinderFeed.feedObject.getFeedObject())));
    }
    localObject2 = ((ang)localObject1).rBY;
    p.g(localObject2, "finderFeedSearchObj.objectList");
    localObject3 = ((Iterable)localObject2).iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id == ((FinderObject)localObject2).id)
        {
          ((ang)localObject1).GFk = i;
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.j.syU;
          paramBaseFinderFeed = this.dyb;
          localObject3 = this.query;
          long l = ((FinderObject)localObject2).id;
          p.h(paramBaseFinderFeed, "requestId");
          localObject2 = i.syT;
          com.tencent.mm.plugin.finder.report.j.b(paramBaseFinderFeed, (String)localObject3, 2, i.wL(l), i, 1);
        }
      }
      else
      {
        paramBaseFinderFeed = new Intent();
        localObject2 = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.fNT, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.fNT, (ang)localObject1, paramBaseFinderFeed);
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
    g.ajj().b(3820, (f)this);
    mc(true);
    this.sDy.dead();
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166805);
    g.ajj().b(3820, (f)this);
    int i = this.smS.size();
    int j = this.feedList.size();
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.ywz.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.sCW;
      if (paramString != null) {}
      for (paramString = paramString.rSg; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramn = paramString.vTm;
      p.g(paramn, "response.infoList");
      localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ars)((Iterator)localObject1).next();
        if (((ars)localObject2).contact != null) {
          this.smS.add(localObject2);
        }
        paramn.add(z.Nhr);
      }
      paramn = paramString.rBY;
      p.g(paramn, "response.objectList");
      localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.sJb;
        p.g(localObject2, "it");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 16);
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        localObject2 = b.a.j((FinderItem)localObject2);
        paramn.add(Boolean.valueOf(this.feedList.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.skw = paramString.skw;
      ae.i(this.TAG, "onSceneEnd " + paramString.vTm.size() + ' ' + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.smS.size() + ' ' + this.feedList.size());
      localObject1 = this.sDw;
      paramn = this.query;
      paramString = paramn;
      if (paramn == null) {
        paramString = "";
      }
      if ((p.i(localObject1, paramString) ^ true))
      {
        paramString = com.tencent.mm.plugin.finder.report.j.syU;
        paramString = this.query;
        if (paramString != null) {
          break label645;
        }
        paramString = "";
      }
    }
    label645:
    for (;;)
    {
      localObject1 = (Iterable)this.feedList;
      paramn = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramn.add(((BaseFinderFeed)((Iterator)localObject1).next()).feedObject.getUnsignedId());
      }
      com.tencent.mm.plugin.finder.report.j.r(paramString, (List)paramn);
      paramn = this.query;
      paramString = paramn;
      if (paramn == null) {
        paramString = "";
      }
      this.sDw = paramString;
      for (;;)
      {
        paramString = this.sDx;
        if (paramString == null) {
          break;
        }
        paramString.fM(i, j);
        AppMethodBeat.o(166805);
        return;
        e.ywz.idkeyStat(1265L, 5L, 1L, false);
      }
      AppMethodBeat.o(166805);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<hb>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(FinderMixSearchPresenter.a parama, hb paramhb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter
 * JD-Core Version:    0.7.0.1
 */