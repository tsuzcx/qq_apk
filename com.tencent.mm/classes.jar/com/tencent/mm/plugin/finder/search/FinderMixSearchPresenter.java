package com.tencent.mm.plugin.finder.search;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isFromHistory", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastSearchResult", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "jumpToLive", "feed", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearch", "isAccountEmpty", "isFeedEmpty", "reportSearchExpose", "needClear", "startSearchQuery", "isFromHot", "sessionBuffer", "plugin-finder_release"})
public final class FinderMixSearchPresenter
  implements i, e.a
{
  private final String TAG;
  private int continueFlag;
  private String dPI;
  private ArrayList<BaseFinderFeed> feedList;
  private MMActivity gte;
  private int offset;
  private String query;
  private com.tencent.mm.bw.b tVM;
  private boolean twi;
  private ArrayList<bbz> uae;
  private HashMap<String, a> vtH;
  private cf vtL;
  private String vus;
  private e.b vut;
  private final a vuu;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(166815);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.dPI = "";
    this.uae = new ArrayList();
    this.feedList = new ArrayList();
    this.vtH = new HashMap();
    this.vus = "";
    this.vuu = new a(this);
    this.gte = paramMMActivity;
    AppMethodBeat.o(166815);
  }
  
  private final void ov(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!Util.isNullOrNil(this.dPI)) {
      if (((Map)this.vtH).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.l locall = com.tencent.mm.plugin.finder.report.l.vfB;
        com.tencent.mm.plugin.finder.report.l.a(this.dPI, this.query, this.vtH, 1);
        if (paramBoolean) {
          this.vtH.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void K(long paramLong, int paramInt)
  {
    AppMethodBeat.i(166813);
    k localk = k.vfA;
    ae(k.Fg(paramLong), paramInt, 2);
    AppMethodBeat.o(166813);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(166807);
    p.h(paramb, "callback");
    this.vut = paramb;
    this.vuu.alive();
    AppMethodBeat.o(166807);
  }
  
  public final void a(bbz parambbz, int paramInt)
  {
    AppMethodBeat.i(166809);
    p.h(parambbz, "finderSearchInfo");
    Object localObject3 = new Intent();
    Object localObject1 = parambbz.contact;
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
    localObject1 = FinderReporterUIC.wzC;
    FinderReporterUIC.a.a((Context)this.gte, (Intent)localObject3, 0L, 7, false, 64);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.gte, (Intent)localObject3);
    int i;
    String str1;
    String str2;
    if (this.twi)
    {
      i = 2;
      localObject1 = k.vfA;
      localObject3 = this.dPI;
      str1 = this.query;
      localObject1 = parambbz.contact;
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
      localObject2 = k.vfA;
      str2 = k.dob();
      localObject2 = FinderReporterUIC.wzC;
      localObject2 = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject2 == null) {
        break label400;
      }
      localObject2 = ((FinderReporterUIC)localObject2).dIx();
      label197:
      k.a((String)localObject3, str1, 0, 1, (String)localObject1, paramInt, 1, str2, i, (bbn)localObject2);
      localObject1 = k.vfA;
      localObject3 = this.dPI;
      str1 = this.query;
      localObject1 = parambbz.contact;
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
      localObject2 = k.vfA;
      str2 = k.dob();
      localObject2 = FinderReporterUIC.wzC;
      localObject2 = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject2 == null) {
        break label406;
      }
    }
    label400:
    label406:
    for (Object localObject2 = ((FinderReporterUIC)localObject2).dIx();; localObject2 = null)
    {
      k.a((String)localObject3, str1, 0, 1, (String)localObject1, paramInt, 1, str2, 2, i, (bbn)localObject2);
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject1 == null) {
        break label412;
      }
      localObject2 = k.vfA;
      paramInt = ((FinderReporterUIC)localObject1).tCE;
      parambbz = parambbz.contact;
      if (parambbz != null)
      {
        localObject1 = parambbz.username;
        parambbz = (bbz)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parambbz = "";
      }
      k.a(6, 0L, paramInt, 1, parambbz);
      AppMethodBeat.o(166809);
      return;
      i = 1;
      break;
      localObject2 = null;
      break label197;
    }
    label412:
    AppMethodBeat.o(166809);
  }
  
  public final void ae(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    p.h(paramString, "id");
    if (!this.vtH.containsKey(paramString))
    {
      Log.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      localObject = new a();
      ((a)localObject).setId(paramString);
      ((a)localObject).position = paramInt1;
      ((a)localObject).type = paramInt2;
      ((a)localObject).timeStamp = System.currentTimeMillis();
      ((Map)this.vtH).put(paramString, localObject);
      if (this.vtH.size() % 30 == 0) {
        ov(false);
      }
    }
    int i;
    String str1;
    String str2;
    String str3;
    if (this.twi)
    {
      i = 2;
      localObject = k.vfA;
      str1 = this.dPI;
      str2 = this.query;
      localObject = k.vfA;
      str3 = k.dob();
      localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject == null) {
        break label233;
      }
    }
    label233:
    for (Object localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      k.a(str1, str2, 0, paramInt2, paramString, paramInt1, 1, str3, 1, i, (bbn)localObject);
      AppMethodBeat.o(166814);
      return;
      i = 1;
      break;
    }
  }
  
  public final void br(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(251311);
    p.h(paramString, "query");
    e.Cxv.idkeyStat(1265L, 3L, 1L, false);
    ov(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.tVM = null;
    this.uae.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    p.g(str, "UUID.randomUUID().toString()");
    this.dPI = str;
    if (this.vtL != null)
    {
      g.azz().a((com.tencent.mm.ak.q)this.vtL);
      this.vtL = null;
    }
    if (!Util.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.dPI;
      com.tencent.mm.bw.b localb = this.tVM;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      this.vtL = new cf(paramString, i, str, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx(), null);
      g.azz().b((com.tencent.mm.ak.q)this.vtL);
      g.azz().a(3820, (i)this);
      paramString = this.vut;
      if (paramString != null) {
        paramString.dpE();
      }
    }
    this.twi = paramBoolean;
    AppMethodBeat.o(251311);
  }
  
  public final List<bbz> dpA()
  {
    return (List)this.uae;
  }
  
  public final void dpB()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    aqw localaqw = new aqw();
    localaqw.dPI = this.dPI;
    localaqw.query = this.query;
    localaqw.offset = this.offset;
    localaqw.continueFlag = 1;
    localaqw.tVM = this.tVM;
    Object localObject2 = (Iterable)this.uae;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bbz localbbz = (bbz)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localaqw.LCI.add(localbbz)));
    }
    try
    {
      localIntent.putExtra("request_type", 1);
      label148:
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject1 = this.gte.getContext();
      p.g(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localaqw, localIntent);
      AppMethodBeat.o(166810);
      return;
    }
    catch (Exception localException)
    {
      break label148;
    }
  }
  
  public final boolean dpC()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.dPI;
        com.tencent.mm.bw.b localb = this.tVM;
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        this.vtL = new cf(str1, i, str2, localb, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx(), 64);
        g.azz().b((com.tencent.mm.ak.q)this.vtL);
        g.azz().a(3820, (i)this);
        AppMethodBeat.o(166811);
        return true;
      }
      AppMethodBeat.o(166811);
      return false;
    }
    AppMethodBeat.o(166811);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166806);
    g.azz().b(3820, (i)this);
    ov(true);
    this.vuu.dead();
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(166805);
    g.azz().b(3820, (i)this);
    paramString = this.vut;
    if (paramString == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchViewCallback");
      AppMethodBeat.o(166805);
      throw paramString;
    }
    ((f)paramString).dpF();
    int j = this.uae.size();
    int k = this.feedList.size();
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.Cxv.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.vtL;
      if (paramString != null) {}
      for (paramString = paramString.twl; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramq = paramString.zns;
      p.g(paramq, "response.infoList");
      localObject1 = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bbz)((Iterator)localObject1).next();
        if (((bbz)localObject2).contact != null) {
          this.uae.add(localObject2);
        }
        paramq.add(x.SXb);
      }
      paramq = paramString.tbD;
      p.g(paramq, "response.objectList");
      localObject1 = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.Companion;
        p.g(localObject2, "it");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, 16);
        localObject3 = c.vGN;
        localObject2 = c.a.s((FinderItem)localObject2);
        paramq.add(Boolean.valueOf(this.feedList.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.tVM = paramString.tVM;
      Log.i(this.TAG, "onSceneEnd " + paramString.zns.size() + ' ' + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.uae.size() + ' ' + this.feedList.size());
      localObject2 = this.vus;
      localObject1 = this.query;
      paramq = (com.tencent.mm.ak.q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      if ((p.j(localObject2, paramq) ^ true))
      {
        paramq = com.tencent.mm.plugin.finder.report.l.vfB;
        paramq = this.query;
        if (paramq != null) {
          break label832;
        }
        paramq = "";
      }
    }
    label694:
    label702:
    label832:
    for (;;)
    {
      localObject2 = (Iterable)this.feedList;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getUnsignedId());
      }
      com.tencent.mm.plugin.finder.report.l.t(paramq, (List)localObject1);
      localObject1 = this.query;
      paramq = (com.tencent.mm.ak.q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      this.vus = paramq;
      localObject1 = this.query;
      paramq = (com.tencent.mm.ak.q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      boolean bool1 = paramString.zns.isEmpty();
      boolean bool2 = paramString.tbD.isEmpty();
      int i;
      if (this.twi)
      {
        paramInt1 = 2;
        if (!bool1) {
          break label792;
        }
        paramInt2 = 1;
        if (!bool2) {
          break label797;
        }
        i = 1;
        paramString = k.vfA;
        paramString = k.vfA;
        localObject1 = k.dob();
        localObject2 = this.dPI;
        paramString = FinderReporterUIC.wzC;
        paramString = FinderReporterUIC.a.fH((Context)this.gte);
        if (paramString == null) {
          break label803;
        }
        paramString = paramString.dIx();
        label745:
        k.a((String)localObject1, (String)localObject2, paramq, 1, paramInt1, 2, paramInt2, i, paramString);
      }
      for (;;)
      {
        paramString = this.vut;
        if (paramString == null) {
          break label825;
        }
        paramString.gg(j, k);
        AppMethodBeat.o(166805);
        return;
        paramInt1 = 1;
        break;
        paramInt2 = 2;
        break label694;
        i = 2;
        break label702;
        paramString = null;
        break label745;
        e.Cxv.idkeyStat(1265L, 5L, 1L, false);
      }
      AppMethodBeat.o(166805);
      return;
    }
  }
  
  public final void q(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(251312);
    p.h(paramBaseFinderFeed, "feed");
    Object localObject2;
    Object localObject3;
    if (Util.isEqual(paramBaseFinderFeed.feedObject.getFeedObject().username, z.aUg()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localContext = (Context)this.gte;
      l1 = paramBaseFinderFeed.feedObject.getFeedObject().id;
      localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new awe();
      }
      com.tencent.mm.plugin.finder.utils.a.a(localContext, l1, (String)localObject1, (awe)localObject2, false, null, null, null, null, null, paramBaseFinderFeed.getSessionBuffer(), null, 6128);
      AppMethodBeat.o(251312);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    Context localContext = (Context)this.gte;
    long l2 = paramBaseFinderFeed.feedObject.getFeedObject().id;
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
    if (localObject1 != null) {}
    for (long l1 = ((awe)localObject1).liveId;; l1 = 0L)
    {
      localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      com.tencent.mm.plugin.finder.utils.a.a(localContext, l2, l1, (String)localObject1, (String)localObject2, "", "", paramBaseFinderFeed.getSessionBuffer());
      AppMethodBeat.o(251312);
      return;
    }
  }
  
  public final void r(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166812);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramBaseFinderFeed);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    p.h(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new aqw();
    ((aqw)localObject1).dPI = this.dPI;
    ((aqw)localObject1).query = this.query;
    ((aqw)localObject1).offset = this.offset;
    ((aqw)localObject1).continueFlag = 1;
    ((aqw)localObject1).tVM = this.tVM;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((aqw)localObject1).tbD.add(((BaseFinderFeed)localObject4).feedObject.getFeedObject())));
    }
    int i = 0;
    localObject2 = ((aqw)localObject1).tbD;
    p.g(localObject2, "finderFeedSearchObj.objectList");
    localObject3 = ((Iterable)localObject2).iterator();
    for (;;)
    {
      int j;
      String str;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id != ((FinderObject)localObject2).id) {
          break label506;
        }
        ((aqw)localObject1).LCH = i;
        if (!this.twi) {
          break label491;
        }
        j = 2;
        paramBaseFinderFeed = k.vfA;
        localObject2 = k.Fg(((FinderObject)localObject2).id);
        paramBaseFinderFeed = k.vfA;
        localObject3 = this.dPI;
        localObject4 = this.query;
        paramBaseFinderFeed = k.vfA;
        str = k.dob();
        paramBaseFinderFeed = FinderReporterUIC.wzC;
        paramBaseFinderFeed = FinderReporterUIC.a.fH((Context)this.gte);
        if (paramBaseFinderFeed == null) {
          break label496;
        }
        paramBaseFinderFeed = paramBaseFinderFeed.dIx();
        label337:
        k.a((String)localObject3, (String)localObject4, 0, 2, (String)localObject2, i, 1, str, j, paramBaseFinderFeed);
        paramBaseFinderFeed = k.vfA;
        localObject3 = this.dPI;
        localObject4 = this.query;
        paramBaseFinderFeed = k.vfA;
        str = k.dob();
        paramBaseFinderFeed = FinderReporterUIC.wzC;
        paramBaseFinderFeed = FinderReporterUIC.a.fH((Context)this.gte);
        if (paramBaseFinderFeed == null) {
          break label501;
        }
      }
      label491:
      label496:
      label501:
      for (paramBaseFinderFeed = paramBaseFinderFeed.dIx();; paramBaseFinderFeed = null)
      {
        k.a((String)localObject3, (String)localObject4, 0, 2, (String)localObject2, i, 1, str, 2, j, paramBaseFinderFeed);
        paramBaseFinderFeed = new Intent();
        localObject2 = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.gte, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.gte, (aqw)localObject1, paramBaseFinderFeed);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V");
        AppMethodBeat.o(166812);
        return;
        j = 1;
        break;
        paramBaseFinderFeed = null;
        break label337;
      }
      label506:
      i += 1;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hf>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderMixSearchPresenter.a parama, hf paramhf)
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