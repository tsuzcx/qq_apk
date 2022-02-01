package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hx;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.aa;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "searchScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fromType", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastSearchResult", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "safetyHint", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "getQuery", "getSafetyHint", "isFinderLiveSearch", "", "jumpToLive", "feed", "intent", "Landroid/content/Intent;", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearch", "isAccountEmpty", "isFeedEmpty", "reportSearchExpose", "needClear", "startSearchQuery", "isFromHot", "sessionBuffer", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMixSearchPresenter
  implements com.tencent.mm.am.h, g.a
{
  private com.tencent.mm.bx.b BgS;
  private ArrayList<buy> BmO;
  private dk BnD;
  private HashMap<String, a> FvE;
  private String Fxc;
  private String Fxd;
  private g.b Fxe;
  private final contactChangelistener.1 Fxf;
  private final String TAG;
  private int continueFlag;
  public ArrayList<BaseFinderFeed> feedList;
  private int fromType;
  private String hOG;
  private MMActivity lzt;
  private int offset;
  private String query;
  private int syO;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(342464);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.hOG = "";
    this.BmO = new ArrayList();
    this.feedList = new ArrayList();
    this.fromType = 1;
    this.FvE = new HashMap();
    this.Fxc = "";
    this.Fxd = "";
    this.Fxf = new IListener(com.tencent.mm.app.f.hfK)
    {
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(hx paramhx, FinderMixSearchPresenter paramFinderMixSearchPresenter)
        {
          super();
        }
      }
    };
    this.lzt = paramMMActivity;
    this.syO = paramInt;
    AppMethodBeat.o(342464);
  }
  
  private final void tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!Util.isNullOrNil(this.hOG)) {
      if (((Map)this.FvE).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aa localaa = aa.Fsi;
        aa.b(this.hOG, this.query, this.FvE, 1);
        if (paramBoolean) {
          this.FvE.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, Intent paramIntent)
  {
    AppMethodBeat.i(342583);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramIntent, "intent");
    Object localObject1 = new axg();
    ((axg)localObject1).hOG = this.hOG;
    ((axg)localObject1).query = this.query;
    ((axg)localObject1).offset = this.offset;
    ((axg)localObject1).continueFlag = 1;
    ((axg)localObject1).BgS = this.BgS;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((axg)localObject1).AdW.add(((BaseFinderFeed)localObject4).feedObject.getFeedObject())));
    }
    localObject3 = ((axg)localObject1).AdW.iterator();
    int i = 0;
    for (;;)
    {
      Object localObject5;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id != ((FinderObject)localObject2).id) {
          break label885;
        }
        ((axg)localObject1).ERV = i;
        j = this.fromType;
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject2 = com.tencent.mm.plugin.finder.report.z.pL(((FinderObject)localObject2).id);
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject3 = this.hOG;
        localObject4 = this.query;
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject5 = com.tencent.mm.plugin.finder.report.z.eMW();
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)this.lzt);
        if (localObject1 != null) {
          break label454;
        }
      }
      long l1;
      label454:
      for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
      {
        com.tencent.mm.plugin.finder.report.z.a((String)localObject3, (String)localObject4, 3, 3, (String)localObject2, i, 4, (String)localObject5, 2, j, (bui)localObject1);
        if (!Util.isEqual(paramBaseFinderFeed.feedObject.getFeedObject().username, com.tencent.mm.model.z.bAW())) {
          break;
        }
        paramIntent = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        kotlin.g.b.s.s(paramIntent, "service(IActivityRouter::class.java)");
        localObject3 = (com.tencent.mm.plugin.f)paramIntent;
        localObject4 = (Context)this.lzt;
        l1 = paramBaseFinderFeed.feedObject.getFeedObject().id;
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = "";
        }
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new bip();
        }
        f.a.a((com.tencent.mm.plugin.f)localObject3, (Context)localObject4, l1, paramIntent, (bip)localObject1, null, null, null, null, null, paramBaseFinderFeed.getSessionBuffer(), null, null, 7152);
        AppMethodBeat.o(342583);
        return;
      }
      localObject1 = k.aeZF;
      int j = ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).AJo;
      com.tencent.mm.plugin.expt.hellhound.a.aqz(q.n.Dtw.scene);
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
      Context localContext;
      long l2;
      label621:
      String str1;
      label699:
      String str2;
      if (localObject1 == null)
      {
        i = 0;
        paramIntent.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", i);
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
        if (localObject1 != null)
        {
          localObject1 = ((bip)localObject1).ZSn;
          if (localObject1 != null) {
            paramIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", ((bgr)localObject1).toByteArray());
          }
        }
        localObject5 = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
        localContext = (Context)this.lzt;
        l2 = paramBaseFinderFeed.feedObject.getFeedObject().id;
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
        if (localObject1 != null) {
          break label803;
        }
        l1 = 0L;
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().username;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        str1 = String.valueOf(paramBaseFinderFeed.feedObject.getDescriptionFullSpan());
        localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (localObject1 != null) {
          break label813;
        }
        i = 0;
        str2 = paramBaseFinderFeed.getSessionBuffer();
        localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (localObject1 != null) {
          break label822;
        }
        localObject4 = null;
        label722:
        localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (localObject1 != null) {
          break label832;
        }
        localObject1 = null;
        label739:
        paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramBaseFinderFeed != null) {
          break label863;
        }
        paramBaseFinderFeed = null;
      }
      for (;;)
      {
        f.a.a((com.tencent.mm.plugin.f)localObject5, paramIntent, localContext, l2, l1, (String)localObject2, (String)localObject3, str1, "", i, str2, null, (String)localObject4, (Integer)localObject1, j, paramBaseFinderFeed, false, 33792);
        AppMethodBeat.o(342583);
        return;
        i = ((bip)localObject1).ZSl;
        break;
        label803:
        l1 = ((bip)localObject1).liveId;
        break label621;
        label813:
        i = ((bip)localObject1).ZRR;
        break label699;
        label822:
        localObject4 = ((bip)localObject1).mIE;
        break label722;
        label832:
        localObject1 = ((bip)localObject1).ZRQ;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label739;
        }
        localObject1 = Integer.valueOf(((bmi)localObject1).mNn);
        break label739;
        label863:
        paramBaseFinderFeed = paramBaseFinderFeed.ZOg;
        if (paramBaseFinderFeed == null) {
          paramBaseFinderFeed = null;
        } else {
          paramBaseFinderFeed = paramBaseFinderFeed.toByteArray();
        }
      }
      label885:
      i += 1;
    }
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(166807);
    kotlin.g.b.s.u(paramb, "callback");
    this.Fxe = paramb;
    this.Fxf.alive();
    AppMethodBeat.o(166807);
  }
  
  public final void a(buy parambuy, int paramInt)
  {
    AppMethodBeat.i(166809);
    kotlin.g.b.s.u(parambuy, "finderSearchInfo");
    Object localObject3 = new Intent();
    Object localObject1 = parambuy.contact;
    boolean bool;
    label70:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "";
      ((Intent)localObject3).putExtra("finder_username", (String)localObject1);
      localObject1 = parambuy.contact;
      if ((localObject1 == null) || (c.c((FinderContact)localObject1))) {
        break label379;
      }
      bool = true;
      ((Intent)localObject3).putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", bool);
      localObject1 = as.GSQ;
      as.a.a((Context)this.lzt, (Intent)localObject3, 0L, 7, false, 64);
      com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)this.lzt, (Intent)localObject3);
      int i = this.fromType;
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject3 = this.hOG;
      String str1 = this.query;
      localObject1 = parambuy.contact;
      if (localObject1 != null) {
        break label385;
      }
      localObject1 = "";
      label156:
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      String str2 = com.tencent.mm.plugin.finder.report.z.eMW();
      localObject2 = as.GSQ;
      localObject2 = as.a.hu((Context)this.lzt);
      if (localObject2 != null) {
        break label408;
      }
      localObject2 = null;
      label191:
      com.tencent.mm.plugin.finder.report.z.a((String)localObject3, str1, 0, 1, (String)localObject1, paramInt, 1, str2, i, (bui)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject3 = this.hOG;
      str1 = this.query;
      localObject1 = parambuy.contact;
      if (localObject1 != null) {
        break label418;
      }
      localObject1 = "";
      label241:
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      str2 = com.tencent.mm.plugin.finder.report.z.eMW();
      localObject2 = as.GSQ;
      localObject2 = as.a.hu((Context)this.lzt);
      if (localObject2 != null) {
        break label441;
      }
      localObject2 = null;
      label276:
      com.tencent.mm.plugin.finder.report.z.a((String)localObject3, str1, 0, 1, (String)localObject1, paramInt, 1, str2, 2, i, (bui)localObject2);
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramInt = ((as)localObject1).AJo;
        parambuy = parambuy.contact;
        if (parambuy != null) {
          break label451;
        }
        parambuy = "";
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(6, 0L, paramInt, 1, parambuy);
      AppMethodBeat.o(166809);
      return;
      localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label379:
      bool = false;
      break label70;
      label385:
      localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label156;
      }
      localObject1 = "";
      break label156;
      label408:
      localObject2 = ((as)localObject2).fou();
      break label191;
      label418:
      localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label241;
      }
      localObject1 = "";
      break label241;
      label441:
      localObject2 = ((as)localObject2).fou();
      break label276;
      label451:
      localObject1 = parambuy.username;
      parambuy = (buy)localObject1;
      if (localObject1 == null) {
        parambuy = "";
      }
    }
  }
  
  public final void al(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(342494);
    kotlin.g.b.s.u(paramString, "query");
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 3L, 1L, false);
    tZ(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.BgS = null;
    this.BmO.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    kotlin.g.b.s.s(str, "randomUUID().toString()");
    this.hOG = str;
    if (this.BnD != null)
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD);
      this.BnD = null;
    }
    if (!Util.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.hOG;
      com.tencent.mm.bx.b localb = this.BgS;
      k localk = k.aeZF;
      this.BnD = new dk(paramString, i, str, localb, paramInt2, ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).fou(), null, null, 384);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD, 0);
      com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
      paramString = this.Fxe;
      if (paramString != null) {
        paramString.eOL();
      }
    }
    this.fromType = paramInt1;
    AppMethodBeat.o(342494);
  }
  
  public final void am(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    kotlin.g.b.s.u(paramString, "id");
    if (!this.FvE.containsKey(paramString))
    {
      Log.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      localObject1 = new a();
      ((a)localObject1).setId(paramString);
      ((a)localObject1).position = paramInt1;
      ((a)localObject1).type = paramInt2;
      ((a)localObject1).timeStamp = System.currentTimeMillis();
      ((Map)this.FvE).put(paramString, localObject1);
      if (this.FvE.size() % 30 == 0) {
        tZ(false);
      }
    }
    int j = this.fromType;
    if (this.syO == 13)
    {
      Object localObject4;
      long l1;
      label354:
      Object localObject5;
      int i;
      if (paramInt2 == 3)
      {
        if ((paramInt1 < 0) || (paramInt1 >= this.feedList.size())) {
          break label545;
        }
        localObject1 = (BaseFinderFeed)this.feedList.get(paramInt1);
        if (localObject1 != null)
        {
          localObject2 = aw.Gjk;
          if (aw.s((BaseFinderFeed)localObject1))
          {
            localObject2 = k.aeZF;
            int k = ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).AJo;
            localObject2 = k.aeZF;
            localObject3 = ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).zIB;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = k.aeZF;
            str = ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).DnS;
            localObject3 = str;
            if (str == null) {
              localObject3 = "";
            }
            long l2 = ((BaseFinderFeed)localObject1).bZA();
            str = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l2);
            kotlin.g.b.s.s(str, "long2UnsignedString(feedIdL)");
            localObject4 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
            if (localObject4 != null) {
              break label551;
            }
            l1 = 0L;
            localObject4 = ((BaseFinderFeed)localObject1).feedObject.getUserName();
            localObject5 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
            if (localObject5 != null) {
              break label561;
            }
            i = 0;
            label382:
            localObject5 = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
            cc localcc = (cc)localObject1;
            q.w localw = q.w.DwP;
            com.tencent.mm.plugin.finder.live.report.g.a locala = com.tencent.mm.plugin.finder.live.report.g.DnK;
            ((com.tencent.mm.plugin.g)localObject5).a(new com.tencent.mm.plugin.finder.live.report.g(localcc, (String)localObject4, paramInt1, str, l2, l1, localw, String.valueOf(k), i, com.tencent.mm.plugin.finder.live.report.g.a.b((cc)localObject1), com.tencent.mm.plugin.finder.live.report.g.b.DnU, true, false, 0, (String)localObject2, (String)localObject3, null, null, 208896));
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = this.hOG;
      localObject3 = this.query;
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      str = com.tencent.mm.plugin.finder.report.z.eMW();
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
      {
        com.tencent.mm.plugin.finder.report.z.a((String)localObject2, (String)localObject3, 3, paramInt2, paramString, paramInt1, 4, str, 1, j, (bui)localObject1);
        AppMethodBeat.o(166814);
        return;
        label545:
        localObject1 = null;
        break;
        label551:
        l1 = ((bip)localObject4).liveId;
        break label354;
        label561:
        i = ((bip)localObject5).DSe;
        break label382;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    Object localObject2 = this.hOG;
    Object localObject3 = this.query;
    localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    String str = com.tencent.mm.plugin.finder.report.z.eMW();
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)this.lzt);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      com.tencent.mm.plugin.finder.report.z.a((String)localObject2, (String)localObject3, 0, paramInt2, paramString, paramInt1, 1, str, 1, j, (bui)localObject1);
      AppMethodBeat.o(166814);
      return;
    }
  }
  
  public final List<buy> eOH()
  {
    return (List)this.BmO;
  }
  
  public final String eOI()
  {
    return this.Fxc;
  }
  
  public final void eOJ()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    axg localaxg = new axg();
    localaxg.hOG = this.hOG;
    localaxg.query = this.query;
    localaxg.offset = this.offset;
    localaxg.continueFlag = 1;
    localaxg.BgS = this.BgS;
    Object localObject2 = (Iterable)this.BmO;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      buy localbuy = (buy)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localaxg.ZIt.add(localbuy)));
    }
    for (;;)
    {
      try
      {
        if (this.syO != 13) {
          continue;
        }
        localIntent.putExtra("request_type", 17);
        if (this.syO != 13) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        continue;
        boolean bool = false;
        continue;
      }
      localIntent.putExtra("is_force_night_mode", bool);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = this.lzt.getContext();
      kotlin.g.b.s.s(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localaxg, localIntent);
      AppMethodBeat.o(166810);
      return;
      localIntent.putExtra("request_type", 1);
    }
  }
  
  public final boolean eOK()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.hOG;
        com.tencent.mm.bx.b localb = this.BgS;
        k localk = k.aeZF;
        this.BnD = new dk(str1, i, str2, localb, 0, ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).fou(), null, null, 448);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD, 0);
        com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
        AppMethodBeat.o(166811);
        return true;
      }
      AppMethodBeat.o(166811);
      return false;
    }
    AppMethodBeat.o(166811);
    return false;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public final void k(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166812);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramBaseFinderFeed);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    kotlin.g.b.s.u(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new axg();
    ((axg)localObject1).hOG = this.hOG;
    ((axg)localObject1).query = this.query;
    ((axg)localObject1).offset = this.offset;
    ((axg)localObject1).continueFlag = 1;
    ((axg)localObject1).BgS = this.BgS;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((axg)localObject1).AdW.add(((BaseFinderFeed)localObject4).feedObject.getFeedObject())));
    }
    localObject3 = ((axg)localObject1).AdW.iterator();
    int i = 0;
    for (;;)
    {
      int j;
      String str;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id != ((FinderObject)localObject2).id) {
          break label480;
        }
        ((axg)localObject1).ERV = i;
        j = this.fromType;
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject2 = com.tencent.mm.plugin.finder.report.z.pL(((FinderObject)localObject2).id);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject3 = this.hOG;
        localObject4 = this.query;
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
        str = com.tencent.mm.plugin.finder.report.z.eMW();
        paramBaseFinderFeed = as.GSQ;
        paramBaseFinderFeed = as.a.hu((Context)this.lzt);
        if (paramBaseFinderFeed != null) {
          break label464;
        }
        paramBaseFinderFeed = null;
        com.tencent.mm.plugin.finder.report.z.a((String)localObject3, (String)localObject4, 0, 2, (String)localObject2, i, 1, str, j, paramBaseFinderFeed);
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject3 = this.hOG;
        localObject4 = this.query;
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.report.z.FrZ;
        str = com.tencent.mm.plugin.finder.report.z.eMW();
        paramBaseFinderFeed = as.GSQ;
        paramBaseFinderFeed = as.a.hu((Context)this.lzt);
        if (paramBaseFinderFeed != null) {
          break label472;
        }
      }
      label464:
      label472:
      for (paramBaseFinderFeed = null;; paramBaseFinderFeed = paramBaseFinderFeed.fou())
      {
        com.tencent.mm.plugin.finder.report.z.a((String)localObject3, (String)localObject4, 0, 2, (String)localObject2, i, 1, str, 2, j, paramBaseFinderFeed);
        paramBaseFinderFeed = new Intent();
        localObject2 = as.GSQ;
        as.a.a((Context)this.lzt, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.lzt, (axg)localObject1, paramBaseFinderFeed);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V");
        AppMethodBeat.o(166812);
        return;
        paramBaseFinderFeed = paramBaseFinderFeed.fou();
        break;
      }
      label480:
      i += 1;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166806);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    tZ(true);
    this.Fxf.dead();
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(166805);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    paramString = this.Fxe;
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchViewCallback");
      AppMethodBeat.o(166805);
      throw paramString;
    }
    ((h)paramString).eOM();
    int i = this.BmO.size();
    int j = this.feedList.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.BnD;
      if (paramString == null) {}
      for (paramp = null; paramp == null; paramp = paramString.ADk)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramString = paramp.KNn;
      kotlin.g.b.s.s(paramString, "response.infoList");
      Object localObject1 = (Iterable)paramString;
      paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (buy)((Iterator)localObject1).next();
        if (((buy)localObject2).contact != null) {
          this.BmO.add(localObject2);
        }
        paramString.add(ah.aiuX);
      }
      paramString = k.aeZF;
      paramInt2 = ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).AJo;
      paramString = paramp.AdW;
      kotlin.g.b.s.s(paramString, "response.objectList");
      localObject1 = (Iterable)paramString;
      paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.Companion;
        kotlin.g.b.s.s(localObject2, "it");
        localObject2 = FinderItem.a.e((FinderObject)localObject2, 16);
        localObject3 = d.FND;
        localObject2 = d.a.a((FinderItem)localObject2);
        if (!((Collection)((BaseFinderFeed)localObject2).feedObject.getMediaList()).isEmpty()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            this.feedList.add(localObject2);
          }
          if ((localObject2 instanceof x))
          {
            localObject3 = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.d(((BaseFinderFeed)localObject2).bZA(), paramInt2, ((BaseFinderFeed)localObject2).getSessionBuffer());
          }
          paramString.add(ah.aiuX);
          break;
        }
      }
      paramString = paramp.aacB;
      if (paramString == null)
      {
        paramString = "";
        this.Fxc = paramString;
        this.offset = paramp.offset;
        this.continueFlag = paramp.continueFlag;
        this.BgS = paramp.BgS;
        Log.i(this.TAG, "onSceneEnd " + paramp.KNn.size() + ' ' + paramp.offset + ' ' + paramp.continueFlag + ' ' + this.BmO.size() + ' ' + this.feedList.size());
        localObject2 = this.Fxd;
        localObject1 = this.query;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        if (kotlin.g.b.s.p(localObject2, paramString)) {
          break label755;
        }
        paramString = aa.Fsi;
        paramString = this.query;
        if (paramString != null) {
          break label721;
        }
        paramString = "";
      }
      label721:
      for (;;)
      {
        localObject2 = (Iterable)this.feedList;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getUnsignedId());
        }
        localObject1 = paramString.aacD;
        paramString = (String)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramString = "";
        break;
      }
      aa.z(paramString, (List)localObject1);
      localObject1 = this.query;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      this.Fxd = paramString;
      label755:
      localObject1 = this.query;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      boolean bool1 = paramp.KNn.isEmpty();
      boolean bool2 = paramp.AdW.isEmpty();
      int k = this.fromType;
      if (bool1)
      {
        paramInt1 = 1;
        if (!bool2) {
          break label905;
        }
        paramInt2 = 1;
        label812:
        paramp = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramp = com.tencent.mm.plugin.finder.report.z.FrZ;
        localObject1 = com.tencent.mm.plugin.finder.report.z.eMW();
        localObject2 = this.hOG;
        paramp = as.GSQ;
        paramp = as.a.hu((Context)this.lzt);
        if (paramp != null) {
          break label910;
        }
        paramp = null;
        label858:
        com.tencent.mm.plugin.finder.report.z.a((String)localObject1, (String)localObject2, paramString, 1, k, 2, paramInt1, paramInt2, paramp);
      }
    }
    for (;;)
    {
      paramString = this.Fxe;
      if (paramString != null) {
        paramString.ii(i, j);
      }
      AppMethodBeat.o(166805);
      return;
      paramInt1 = 2;
      break;
      label905:
      paramInt2 = 2;
      break label812;
      label910:
      paramp = paramp.fou();
      break label858;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 5L, 1L, false);
    }
  }
  
  public final void s(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(342600);
    com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
    am(com.tencent.mm.plugin.finder.report.z.pL(paramLong), paramInt1, paramInt2);
    AppMethodBeat.o(342600);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class contactChangelistener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    contactChangelistener$1$a(hx paramhx, FinderMixSearchPresenter paramFinderMixSearchPresenter)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter
 * JD-Core Version:    0.7.0.1
 */