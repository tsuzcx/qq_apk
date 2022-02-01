package com.tencent.mm.plugin.finder.search;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearchExpose", "needClear", "startSearchQuery", "plugin-finder_release"})
public final class FinderMixSearchPresenter
  implements com.tencent.mm.al.g, f.a
{
  private final String TAG;
  private int continueFlag;
  private String dnB;
  private ArrayList<BaseFinderFeed> feedList;
  private MMActivity imP;
  private int offset;
  private ArrayList<aky> qHA;
  private HashMap<String, a> qHC;
  private aa qHF;
  private f.b qHX;
  private com.tencent.mm.bx.b qHz;
  private String query;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(166815);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.dnB = "";
    this.qHA = new ArrayList();
    this.feedList = new ArrayList();
    this.qHC = new HashMap();
    this.imP = paramMMActivity;
    AppMethodBeat.o(166815);
  }
  
  private final void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!bt.isNullOrNil(this.dnB)) {
      if (((Map)this.qHC).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        d locald = d.qFr;
        d.a(this.dnB, this.query, this.qHC, 1);
        if (paramBoolean) {
          this.qHC.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void G(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166813);
    com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
    ab(com.tencent.mm.plugin.finder.report.b.qi(paramLong), paramInt, 2);
    AppMethodBeat.o(166813);
  }
  
  public final void Zn(String paramString)
  {
    AppMethodBeat.i(166803);
    k.h(paramString, "query");
    e.vIY.idkeyStat(1265L, 3L, 1L, false);
    lc(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.qHz = null;
    this.qHA.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    k.g(str, "UUID.randomUUID().toString()");
    this.dnB = str;
    if (this.qHF != null)
    {
      com.tencent.mm.kernel.g.aeS().a((n)this.qHF);
      this.qHF = null;
    }
    if (!bt.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.dnB;
      com.tencent.mm.bx.b localb = this.qHz;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
      this.qHF = new aa(paramString, i, str, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).fXs(), 16);
      com.tencent.mm.kernel.g.aeS().b((n)this.qHF);
      com.tencent.mm.kernel.g.aeS().a(3820, (com.tencent.mm.al.g)this);
      paramString = this.qHX;
      if (paramString != null)
      {
        paramString.cop();
        AppMethodBeat.o(166803);
        return;
      }
    }
    AppMethodBeat.o(166803);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(166807);
    k.h(paramb, "callback");
    this.qHX = paramb;
    AppMethodBeat.o(166807);
  }
  
  public final void a(aky paramaky, int paramInt)
  {
    AppMethodBeat.i(166809);
    k.h(paramaky, "finderSearchInfo");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramaky.contact.username);
    Object localObject2 = FinderReporterUIC.Ljl;
    FinderReporterUIC.a.a((Context)this.imP, (Intent)localObject1, 0L, 7, false, 64);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.imP, (Intent)localObject1);
    localObject1 = d.qFr;
    localObject1 = this.dnB;
    localObject2 = this.query;
    String str = paramaky.contact.username;
    k.g(str, "finderSearchInfo.contact.username");
    d.b((String)localObject1, (String)localObject2, 1, str, paramInt, 1);
    localObject1 = FinderReporterUIC.Ljl;
    localObject1 = FinderReporterUIC.a.lB((Context)this.imP);
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
      paramInt = ((FinderReporterUIC)localObject1).qqE;
      paramaky = paramaky.contact.username;
      k.g(paramaky, "finderSearchInfo.contact.username");
      com.tencent.mm.plugin.finder.report.b.a(6, 0L, paramInt, 1, paramaky);
      AppMethodBeat.o(166809);
      return;
    }
    AppMethodBeat.o(166809);
  }
  
  public final void ab(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    k.h(paramString, "id");
    if (!this.qHC.containsKey(paramString))
    {
      ad.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      a locala = new a();
      locala.Zm(paramString);
      locala.position = paramInt1;
      locala.type = paramInt2;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.qHC).put(paramString, locala);
      if (this.qHC.size() % 30 == 0) {
        lc(false);
      }
    }
    AppMethodBeat.o(166814);
  }
  
  public final List<aky> com()
  {
    return (List)this.qHA;
  }
  
  public final void con()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    aik localaik = new aik();
    localaik.dnB = this.dnB;
    localaik.query = this.query;
    localaik.offset = this.offset;
    localaik.continueFlag = 1;
    localaik.qHz = this.qHz;
    Object localObject2 = (Iterable)this.qHA;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aky localaky = (aky)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localaik.qMq.add(localaky)));
    }
    try
    {
      localIntent.putExtra("request_type", 1);
      label148:
      localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject1 = this.imP.getContext();
      k.g(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localaik, localIntent);
      AppMethodBeat.o(166810);
      return;
    }
    catch (Exception localException)
    {
      break label148;
    }
  }
  
  public final boolean coo()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.dnB;
        com.tencent.mm.bx.b localb = this.qHz;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
        this.qHF = new aa(str1, i, str2, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).fXs());
        com.tencent.mm.kernel.g.aeS().b((n)this.qHF);
        com.tencent.mm.kernel.g.aeS().a(3820, (com.tencent.mm.al.g)this);
        AppMethodBeat.o(166811);
        return true;
      }
      AppMethodBeat.o(166811);
      return false;
    }
    AppMethodBeat.o(166811);
    return false;
  }
  
  public final void j(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166812);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).be(paramBaseFinderFeed);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ado());
    k.h(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new aik();
    ((aik)localObject1).dnB = this.dnB;
    ((aik)localObject1).query = this.query;
    ((aik)localObject1).offset = this.offset;
    ((aik)localObject1).continueFlag = 1;
    ((aik)localObject1).qHz = this.qHz;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((aik)localObject1).qbe.add(localBaseFinderFeed.feedObject.getFeedObject())));
    }
    localObject2 = ((aik)localObject1).qbe;
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
          ((aik)localObject1).Dlc = i;
          paramBaseFinderFeed = d.qFr;
          paramBaseFinderFeed = this.dnB;
          localObject3 = this.query;
          long l = ((FinderObject)localObject2).id;
          k.h(paramBaseFinderFeed, "requestId");
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          d.b(paramBaseFinderFeed, (String)localObject3, 2, com.tencent.mm.plugin.finder.report.b.qi(l), i, 1);
        }
      }
      else
      {
        paramBaseFinderFeed = new Intent();
        localObject2 = FinderReporterUIC.Ljl;
        FinderReporterUIC.a.a((Context)this.imP, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.imP, (aik)localObject1, paramBaseFinderFeed);
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
    com.tencent.mm.kernel.g.aeS().b(3820, (com.tencent.mm.al.g)this);
    lc(true);
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(166805);
    com.tencent.mm.kernel.g.aeS().b(3820, (com.tencent.mm.al.g)this);
    int i = this.qHA.size();
    int j = this.feedList.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.vIY.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.qHF;
      if (paramString != null) {}
      for (paramString = paramString.qpw; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramn = paramString.tvP;
      k.g(paramn, "response.infoList");
      Object localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aky)((Iterator)localObject1).next();
        if (((aky)localObject2).contact != null) {
          this.qHA.add(localObject2);
        }
        paramn.add(y.JfV);
      }
      paramn = paramString.qbe;
      k.g(paramn, "response.objectList");
      localObject1 = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.qJU;
        k.g(localObject2, "it");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 16);
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        localObject2 = b.a.h((FinderItem)localObject2);
        paramn.add(Boolean.valueOf(this.feedList.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.qHz = paramString.qHz;
      ad.i(this.TAG, "onSceneEnd " + paramString.tvP.size() + ' ' + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.qHA.size() + ' ' + this.feedList.size());
    }
    for (;;)
    {
      paramString = this.qHX;
      if (paramString == null) {
        break;
      }
      paramString.fv(i, j);
      AppMethodBeat.o(166805);
      return;
      e.vIY.idkeyStat(1265L, 5L, 1L, false);
    }
    AppMethodBeat.o(166805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter
 * JD-Core Version:    0.7.0.1
 */