package com.tencent.mm.plugin.finder.search;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearchExpose", "needClear", "startSearchQuery", "plugin-finder_release"})
public final class FinderMixSearchPresenter
  implements f, e.a
{
  private final String TAG;
  private int continueFlag;
  private String dwW;
  private MMActivity fLP;
  private ArrayList<BaseFinderFeed> feedList;
  private int offset;
  private String query;
  private com.tencent.mm.bx.b sbF;
  private ArrayList<ard> sec;
  private HashMap<String, a> ssI;
  private az ssM;
  private e.b stm;
  private final a stn;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(166815);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.dwW = "";
    this.sec = new ArrayList();
    this.feedList = new ArrayList();
    this.ssI = new HashMap();
    this.stn = new a(this);
    this.fLP = paramMMActivity;
    AppMethodBeat.o(166815);
  }
  
  private final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!bt.isNullOrNil(this.dwW)) {
      if (((Map)this.ssI).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i locali = i.soN;
        i.a(this.dwW, this.query, this.ssI, 1);
        if (paramBoolean) {
          this.ssI.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void L(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166813);
    h localh = h.soM;
    ac(h.wu(paramLong), paramInt, 2);
    AppMethodBeat.o(166813);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(166807);
    p.h(paramb, "callback");
    this.stm = paramb;
    this.stn.alive();
    AppMethodBeat.o(166807);
  }
  
  public final void a(ard paramard, int paramInt)
  {
    AppMethodBeat.i(166809);
    p.h(paramard, "finderSearchInfo");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramard.contact.username);
    Object localObject2 = FinderReporterUIC.tcM;
    FinderReporterUIC.a.a((Context)this.fLP, (Intent)localObject1, 0L, 7, false, 64);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.fLP, (Intent)localObject1);
    localObject1 = i.soN;
    localObject1 = this.dwW;
    localObject2 = this.query;
    String str = paramard.contact.username;
    p.g(str, "finderSearchInfo.contact.username");
    i.b((String)localObject1, (String)localObject2, 1, str, paramInt, 1);
    localObject1 = FinderReporterUIC.tcM;
    localObject1 = FinderReporterUIC.a.eY((Context)this.fLP);
    if (localObject1 != null)
    {
      localObject2 = h.soM;
      paramInt = ((FinderReporterUIC)localObject1).rTD;
      paramard = paramard.contact.username;
      p.g(paramard, "finderSearchInfo.contact.username");
      h.a(6, 0L, paramInt, 1, paramard);
      AppMethodBeat.o(166809);
      return;
    }
    AppMethodBeat.o(166809);
  }
  
  public final void ac(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    p.h(paramString, "id");
    if (!this.ssI.containsKey(paramString))
    {
      ad.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      a locala = new a();
      locala.setId(paramString);
      locala.position = paramInt1;
      locala.type = paramInt2;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.ssI).put(paramString, locala);
      if (this.ssI.size() % 30 == 0) {
        mb(false);
      }
    }
    AppMethodBeat.o(166814);
  }
  
  public final void ahU(String paramString)
  {
    AppMethodBeat.i(166803);
    p.h(paramString, "query");
    e.ygI.idkeyStat(1265L, 3L, 1L, false);
    mb(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.sbF = null;
    this.sec.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    p.g(str, "UUID.randomUUID().toString()");
    this.dwW = str;
    if (this.ssM != null)
    {
      g.aiU().a((n)this.ssM);
      this.ssM = null;
    }
    if (!bt.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.dwW;
      com.tencent.mm.bx.b localb = this.sbF;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
      this.ssM = new az(paramString, i, str, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class)).cOu(), 16);
      g.aiU().b((n)this.ssM);
      g.aiU().a(3820, (f)this);
      paramString = this.stm;
      if (paramString != null)
      {
        paramString.cEJ();
        AppMethodBeat.o(166803);
        return;
      }
    }
    AppMethodBeat.o(166803);
  }
  
  public final List<ard> cEG()
  {
    return (List)this.sec;
  }
  
  public final void cEH()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    amu localamu = new amu();
    localamu.dwW = this.dwW;
    localamu.query = this.query;
    localamu.offset = this.offset;
    localamu.continueFlag = 1;
    localamu.sbF = this.sbF;
    Object localObject2 = (Iterable)this.sec;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ard localard = (ard)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localamu.Gmj.add(localard)));
    }
    try
    {
      localIntent.putExtra("request_type", 1);
      label148:
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject1 = this.fLP.getContext();
      p.g(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localamu, localIntent);
      AppMethodBeat.o(166810);
      return;
    }
    catch (Exception localException)
    {
      break label148;
    }
  }
  
  public final boolean cEI()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.dwW;
        com.tencent.mm.bx.b localb = this.sbF;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
        this.ssM = new az(str1, i, str2, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class)).cOu());
        g.aiU().b((n)this.ssM);
        g.aiU().a(3820, (f)this);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    p.h(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new amu();
    ((amu)localObject1).dwW = this.dwW;
    ((amu)localObject1).query = this.query;
    ((amu)localObject1).offset = this.offset;
    ((amu)localObject1).continueFlag = 1;
    ((amu)localObject1).sbF = this.sbF;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((amu)localObject1).rtM.add(localBaseFinderFeed.feedObject.getFeedObject())));
    }
    localObject2 = ((amu)localObject1).rtM;
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
          ((amu)localObject1).Gmi = i;
          paramBaseFinderFeed = i.soN;
          paramBaseFinderFeed = this.dwW;
          localObject3 = this.query;
          long l = ((FinderObject)localObject2).id;
          p.h(paramBaseFinderFeed, "requestId");
          localObject2 = h.soM;
          i.b(paramBaseFinderFeed, (String)localObject3, 2, h.wu(l), i, 1);
        }
      }
      else
      {
        paramBaseFinderFeed = new Intent();
        localObject2 = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)this.fLP, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.fLP, (amu)localObject1, paramBaseFinderFeed);
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
    g.aiU().b(3820, (f)this);
    mb(true);
    this.stn.dead();
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166805);
    g.aiU().b(3820, (f)this);
    int i = this.sec.size();
    int j = this.feedList.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.ygI.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.ssM;
      if (paramString != null) {}
      for (paramString = paramString.rJS; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramn = paramString.vHi;
      p.g(paramn, "response.infoList");
      Object localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ard)((Iterator)localObject1).next();
        if (((ard)localObject2).contact != null) {
          this.sec.add(localObject2);
        }
        paramn.add(z.MKo);
      }
      paramn = paramString.rtM;
      p.g(paramn, "response.objectList");
      localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.syk;
        p.g(localObject2, "it");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 16);
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        localObject2 = b.a.j((FinderItem)localObject2);
        paramn.add(Boolean.valueOf(this.feedList.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.sbF = paramString.sbF;
      ad.i(this.TAG, "onSceneEnd " + paramString.vHi.size() + ' ' + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.sec.size() + ' ' + this.feedList.size());
    }
    for (;;)
    {
      paramString = this.stm;
      if (paramString == null) {
        break;
      }
      paramString.fM(i, j);
      AppMethodBeat.o(166805);
      return;
      e.ygI.idkeyStat(1265L, 5L, 1L, false);
    }
    AppMethodBeat.o(166805);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends c<ha>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(FinderMixSearchPresenter.a parama, ha paramha)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter
 * JD-Core Version:    0.7.0.1
 */