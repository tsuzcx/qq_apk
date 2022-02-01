package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.hm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.live.report.h.a;
import com.tencent.mm.plugin.finder.live.report.h.b;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
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
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "searchScene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fromType", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lastSearchResult", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "offset", "query", "requestId", "safetyHint", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$ViewCallback;", "addExposeItem", "", "id", "", "position", "type", "getContactList", "", "getFeedList", "getQuery", "getSafetyHint", "isFinderLiveSearch", "", "jumpToLive", "feed", "intent", "Landroid/content/Intent;", "onAttach", "callback", "onContactItemClick", "finderSearchInfo", "onContactMoreClick", "onDetach", "onFeedItemClick", "finderFeedObj", "onLoadMoreData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSearch", "isAccountEmpty", "isFeedEmpty", "reportSearchExpose", "needClear", "startSearchQuery", "isFromHot", "sessionBuffer", "plugin-finder_release"})
public final class FinderMixSearchPresenter
  implements i, f.a
{
  private String Abm;
  private String Abn;
  private f.b Abo;
  private final a Abp;
  private final String TAG;
  private int continueFlag;
  private String fIY;
  private ArrayList<BaseFinderFeed> feedList;
  private int fromType;
  private MMActivity iXq;
  private int offset;
  private int ptD;
  private String query;
  private com.tencent.mm.cd.b xHE;
  private ArrayList<bip> xMG;
  private cj xNG;
  private HashMap<String, a> zZV;
  
  public FinderMixSearchPresenter(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(287540);
    this.TAG = "Finder.FinderMixSearchPresenter";
    this.fIY = "";
    this.xMG = new ArrayList();
    this.feedList = new ArrayList();
    this.fromType = 1;
    this.zZV = new HashMap();
    this.Abm = "";
    this.Abn = "";
    this.Abp = new a(this);
    this.iXq = paramMMActivity;
    this.ptD = paramInt;
    AppMethodBeat.o(287540);
  }
  
  private final void qF(boolean paramBoolean)
  {
    AppMethodBeat.i(166804);
    if (!Util.isNullOrNil(this.fIY)) {
      if (((Map)this.zZV).isEmpty()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        o localo = o.zWG;
        o.a(this.fIY, this.query, this.zZV, 1);
        if (paramBoolean) {
          this.zZV.clear();
        }
      }
      AppMethodBeat.o(166804);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, Intent paramIntent)
  {
    AppMethodBeat.i(287538);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramIntent, "intent");
    Object localObject1 = new ass();
    ((ass)localObject1).fIY = this.fIY;
    ((ass)localObject1).query = this.query;
    ((ass)localObject1).offset = this.offset;
    ((ass)localObject1).continueFlag = 1;
    ((ass)localObject1).xHE = this.xHE;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((ass)localObject1).wHI.add(((BaseFinderFeed)localObject4).feedObject.getFeedObject())));
    }
    int i = 0;
    localObject2 = ((ass)localObject1).wHI;
    p.j(localObject2, "finderFeedSearchObj.objectList");
    localObject3 = ((Iterable)localObject2).iterator();
    long l1;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id != ((FinderObject)localObject2).id) {
          break label463;
        }
        ((ass)localObject1).SFT = i;
        j = this.fromType;
        localObject1 = n.zWF;
        localObject2 = n.Mp(((FinderObject)localObject2).id);
        localObject1 = n.zWF;
        localObject3 = this.fIY;
        localObject4 = this.query;
        localObject1 = n.zWF;
        localObject5 = n.dPC();
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = aj.a.fZ((Context)this.iXq);
        if (localObject1 == null) {
          break label457;
        }
      }
      label457:
      for (localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();; localObject1 = null)
      {
        n.a((String)localObject3, (String)localObject4, 3, 3, (String)localObject2, i, 4, (String)localObject5, 2, j, (bid)localObject1);
        if (!Util.isEqual(paramBaseFinderFeed.feedObject.getFeedObject().username, z.bdh())) {
          break;
        }
        paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject3 = (Context)this.iXq;
        l1 = paramBaseFinderFeed.feedObject.getFeedObject().id;
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = "";
        }
        localObject2 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new bac();
        }
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject3, l1, paramIntent, (bac)localObject1, null, null, null, null, null, paramBaseFinderFeed.getSessionBuffer(), null, null, 7152);
        AppMethodBeat.o(287538);
        return;
      }
      label463:
      i += 1;
    }
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    int j = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).xkX;
    Object localObject4 = com.tencent.mm.plugin.finder.utils.a.ACH;
    Object localObject5 = (Context)this.iXq;
    long l2 = paramBaseFinderFeed.feedObject.getFeedObject().id;
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
    String str1;
    label631:
    String str2;
    if (localObject1 != null)
    {
      l1 = ((bac)localObject1).liveId;
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
      str1 = String.valueOf(paramBaseFinderFeed.feedObject.getDescriptionFullSpan());
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject3 == null) {
        break label731;
      }
      i = ((bac)localObject3).SLO;
      str2 = paramBaseFinderFeed.getSessionBuffer();
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (localObject3 == null) {
        break label736;
      }
      localObject3 = ((bac)localObject3).kih;
      label658:
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null) {
        break label742;
      }
      paramBaseFinderFeed = paramBaseFinderFeed.SLN;
      if (paramBaseFinderFeed == null) {
        break label742;
      }
    }
    label731:
    label736:
    label742:
    for (paramBaseFinderFeed = Integer.valueOf(paramBaseFinderFeed.kmi);; paramBaseFinderFeed = null)
    {
      com.tencent.mm.plugin.finder.utils.a.a((com.tencent.mm.plugin.finder.utils.a)localObject4, paramIntent, (Context)localObject5, l2, l1, (String)localObject1, (String)localObject2, str1, "", i, str2, null, (String)localObject3, paramBaseFinderFeed, j, 1024);
      AppMethodBeat.o(287538);
      return;
      l1 = 0L;
      break;
      i = 0;
      break label631;
      localObject3 = null;
      break label658;
    }
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(166807);
    p.k(paramb, "callback");
    this.Abo = paramb;
    this.Abp.alive();
    AppMethodBeat.o(166807);
  }
  
  public final void a(bip parambip, int paramInt)
  {
    AppMethodBeat.i(166809);
    p.k(parambip, "finderSearchInfo");
    Object localObject3 = new Intent();
    Object localObject1 = parambip.contact;
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
    localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    aj.a.a((Context)this.iXq, (Intent)localObject3, 0L, 7, false, 64);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.iXq, (Intent)localObject3);
    int i = this.fromType;
    localObject1 = n.zWF;
    localObject3 = this.fIY;
    String str1 = this.query;
    localObject1 = parambip.contact;
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
    Object localObject2 = n.zWF;
    String str2 = n.dPC();
    localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject2 = aj.a.fZ((Context)this.iXq);
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();
      n.a((String)localObject3, str1, 0, 1, (String)localObject1, paramInt, 1, str2, i, (bid)localObject2);
      localObject1 = n.zWF;
      localObject3 = this.fIY;
      str1 = this.query;
      localObject1 = parambip.contact;
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
      localObject2 = n.zWF;
      str2 = n.dPC();
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = aj.a.fZ((Context)this.iXq);
      if (localObject2 == null) {
        break label401;
      }
    }
    label401:
    for (localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).ekY();; localObject2 = null)
    {
      n.a((String)localObject3, str1, 0, 1, (String)localObject1, paramInt, 1, str2, 2, i, (bid)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ((Context)this.iXq);
      if (localObject1 == null) {
        break label407;
      }
      localObject2 = n.zWF;
      paramInt = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).xkX;
      parambip = parambip.contact;
      if (parambip != null)
      {
        localObject1 = parambip.username;
        parambip = (bip)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parambip = "";
      }
      n.a(6, 0L, paramInt, 1, parambip);
      AppMethodBeat.o(166809);
      return;
      localObject2 = null;
      break;
    }
    label407:
    AppMethodBeat.o(166809);
  }
  
  public final void ag(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287537);
    p.k(paramString, "query");
    f.Iyx.idkeyStat(1265L, 3L, 1L, false);
    qF(true);
    this.offset = 0;
    this.continueFlag = 0;
    this.xHE = null;
    this.xMG.clear();
    this.feedList.clear();
    this.query = paramString;
    String str = UUID.randomUUID().toString();
    p.j(str, "UUID.randomUUID().toString()");
    this.fIY = str;
    if (this.xNG != null)
    {
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)this.xNG);
      this.xNG = null;
    }
    if (!Util.isNullOrNil(paramString))
    {
      int i = this.offset;
      str = this.fIY;
      com.tencent.mm.cd.b localb = this.xHE;
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      this.xNG = new cj(paramString, i, str, localb, paramInt2, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), null, null, 384);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.xNG);
      com.tencent.mm.kernel.h.aGY().a(3820, (i)this);
      paramString = this.Abo;
      if (paramString != null) {
        paramString.dQR();
      }
    }
    this.fromType = paramInt1;
    AppMethodBeat.o(287537);
  }
  
  public final void ah(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166814);
    p.k(paramString, "id");
    if (!this.zZV.containsKey(paramString))
    {
      Log.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt1 + ' ' + paramInt2);
      localObject1 = new a();
      ((a)localObject1).setId(paramString);
      ((a)localObject1).position = paramInt1;
      ((a)localObject1).type = paramInt2;
      ((a)localObject1).timeStamp = System.currentTimeMillis();
      ((Map)this.zZV).put(paramString, localObject1);
      if (this.zZV.size() % 30 == 0) {
        qF(false);
      }
    }
    int j = this.fromType;
    if (this.ptD == 13)
    {
      long l1;
      label358:
      int i;
      if (paramInt2 == 3)
      {
        if ((paramInt1 < 0) || (paramInt1 >= this.feedList.size())) {
          break label552;
        }
        localObject1 = (BaseFinderFeed)this.feedList.get(paramInt1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.w((BaseFinderFeed)localObject1))
          {
            localObject2 = com.tencent.mm.ui.component.g.Xox;
            int k = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).xkX;
            localObject2 = com.tencent.mm.ui.component.g.Xox;
            localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).wmz;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = com.tencent.mm.ui.component.g.Xox;
            str = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).yAU;
            localObject3 = str;
            if (str == null) {
              localObject3 = "";
            }
            long l2 = ((BaseFinderFeed)localObject1).mf();
            str = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l2);
            p.j(str, "HellhoundUtil.long2UnsignedString(feedIdL)");
            Object localObject4 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
            if (localObject4 == null) {
              break label558;
            }
            l1 = ((bac)localObject4).liveId;
            localObject4 = ((BaseFinderFeed)localObject1).feedObject.getUserName();
            Object localObject5 = ((BaseFinderFeed)localObject1).feedObject.getLiveInfo();
            if (localObject5 == null) {
              break label564;
            }
            i = ((bac)localObject5).yYz;
            label390:
            localObject5 = new com.tencent.mm.plugin.finder.live.report.a();
            bu localbu = (bu)localObject1;
            s.t localt = s.t.yGN;
            h.a locala = com.tencent.mm.plugin.finder.live.report.h.yAW;
            ((com.tencent.mm.plugin.finder.live.report.a)localObject5).a(new com.tencent.mm.plugin.finder.live.report.h(localbu, (String)localObject4, paramInt1, str, l2, l1, localt, String.valueOf(k), i, h.a.b((bu)localObject1), h.b.yAX, true, false, 0, (String)localObject2, (String)localObject3, null, 77824));
          }
        }
      }
      localObject1 = n.zWF;
      localObject2 = this.fIY;
      localObject3 = this.query;
      localObject1 = n.zWF;
      str = n.dPC();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ((Context)this.iXq);
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();; localObject1 = null)
      {
        n.a((String)localObject2, (String)localObject3, 3, paramInt2, paramString, paramInt1, 4, str, 1, j, (bid)localObject1);
        AppMethodBeat.o(166814);
        return;
        label552:
        localObject1 = null;
        break;
        label558:
        l1 = 0L;
        break label358;
        label564:
        i = 0;
        break label390;
      }
    }
    Object localObject1 = n.zWF;
    Object localObject2 = this.fIY;
    Object localObject3 = this.query;
    localObject1 = n.zWF;
    String str = n.dPC();
    localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject1 = aj.a.fZ((Context)this.iXq);
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();; localObject1 = null)
    {
      n.a((String)localObject2, (String)localObject3, 0, paramInt2, paramString, paramInt1, 1, str, 1, j, (bid)localObject1);
      AppMethodBeat.o(166814);
      return;
    }
  }
  
  public final List<bip> dQN()
  {
    return (List)this.xMG;
  }
  
  public final String dQO()
  {
    return this.Abm;
  }
  
  public final void dQP()
  {
    AppMethodBeat.i(166810);
    Intent localIntent = new Intent();
    ass localass = new ass();
    localass.fIY = this.fIY;
    localass.query = this.query;
    localass.offset = this.offset;
    localass.continueFlag = 1;
    localass.xHE = this.xHE;
    Object localObject2 = (Iterable)this.xMG;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bip localbip = (bip)((Iterator)localObject2).next();
      ((Collection)localObject1).add(Boolean.valueOf(localass.SFU.add(localbip)));
    }
    for (;;)
    {
      try
      {
        if (this.ptD != 13) {
          continue;
        }
        localIntent.putExtra("request_type", 17);
        if (this.ptD != 13) {
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
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = this.iXq.getContext();
      p.j(localObject1, "context.context");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, localass, localIntent);
      AppMethodBeat.o(166810);
      return;
      localIntent.putExtra("request_type", 1);
    }
  }
  
  public final boolean dQQ()
  {
    AppMethodBeat.i(166811);
    if (this.continueFlag == 1)
    {
      String str1 = this.query;
      if (str1 != null)
      {
        int i = this.offset;
        String str2 = this.fIY;
        com.tencent.mm.cd.b localb = this.xHE;
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        this.xNG = new cj(str1, i, str2, localb, 0, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), null, null, 448);
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.xNG);
        com.tencent.mm.kernel.h.aGY().a(3820, (i)this);
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
  
  public final void k(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287539);
    n localn = n.zWF;
    ah(n.Mp(paramLong), paramInt1, paramInt2);
    AppMethodBeat.o(287539);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166806);
    com.tencent.mm.kernel.h.aGY().b(3820, (i)this);
    qF(true);
    this.Abp.dead();
    AppMethodBeat.o(166806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(166805);
    com.tencent.mm.kernel.h.aGY().b(3820, (i)this);
    paramString = this.Abo;
    if (paramString == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchViewCallback");
      AppMethodBeat.o(166805);
      throw paramString;
    }
    ((g)paramString).dQS();
    int i = this.xMG.size();
    int j = this.feedList.size();
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      f.Iyx.idkeyStat(1265L, 4L, 1L, false);
      paramString = this.xNG;
      if (paramString != null) {}
      for (paramString = paramString.xea; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166805);
        throw paramString;
      }
      paramq = paramString.ESJ;
      p.j(paramq, "response.infoList");
      localObject1 = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bip)((Iterator)localObject1).next();
        if (((bip)localObject2).contact != null) {
          this.xMG.add(localObject2);
        }
        paramq.add(x.aazN);
      }
      paramq = com.tencent.mm.ui.component.g.Xox;
      paramInt1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).xkX;
      paramq = paramString.wHI;
      p.j(paramq, "response.objectList");
      localObject1 = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        Object localObject3 = FinderItem.Companion;
        p.j(localObject2, "it");
        localObject2 = FinderItem.a.b((FinderObject)localObject2, 16);
        localObject3 = c.AnK;
        localObject2 = c.a.a((FinderItem)localObject2);
        this.feedList.add(localObject2);
        if ((localObject2 instanceof w))
        {
          localObject3 = n.zWF;
          n.d(((BaseFinderFeed)localObject2).mf(), paramInt1, ((BaseFinderFeed)localObject2).getSessionBuffer());
        }
        paramq.add(x.aazN);
      }
      paramq = paramString.SSZ;
      if (paramq != null)
      {
        localObject1 = paramq.STa;
        paramq = (com.tencent.mm.an.q)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramq = "";
      }
      this.Abm = paramq;
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.xHE = paramString.xHE;
      Log.i(this.TAG, "onSceneEnd " + paramString.ESJ.size() + ' ' + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.xMG.size() + ' ' + this.feedList.size());
      localObject2 = this.Abn;
      localObject1 = this.query;
      paramq = (com.tencent.mm.an.q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      if ((p.h(localObject2, paramq) ^ true))
      {
        paramq = o.zWG;
        paramq = this.query;
        if (paramq != null) {
          break label915;
        }
        paramq = "";
      }
    }
    label908:
    label915:
    for (;;)
    {
      localObject2 = (Iterable)this.feedList;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getUnsignedId());
      }
      o.u(paramq, (List)localObject1);
      localObject1 = this.query;
      paramq = (com.tencent.mm.an.q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      this.Abn = paramq;
      localObject1 = this.query;
      paramq = (com.tencent.mm.an.q)localObject1;
      if (localObject1 == null) {
        paramq = "";
      }
      boolean bool1 = paramString.ESJ.isEmpty();
      boolean bool2 = paramString.wHI.isEmpty();
      int k = this.fromType;
      if (bool1)
      {
        paramInt1 = 1;
        if (!bool2) {
          break label881;
        }
        paramInt2 = 1;
        label791:
        paramString = n.zWF;
        paramString = n.zWF;
        localObject1 = n.dPC();
        localObject2 = this.fIY;
        paramString = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramString = aj.a.fZ((Context)this.iXq);
        if (paramString == null) {
          break label886;
        }
        paramString = paramString.ekY();
        label834:
        n.a((String)localObject1, (String)localObject2, paramq, 1, k, 2, paramInt1, paramInt2, paramString);
      }
      for (;;)
      {
        paramString = this.Abo;
        if (paramString == null) {
          break label908;
        }
        paramString.gS(i, j);
        AppMethodBeat.o(166805);
        return;
        paramInt1 = 2;
        break;
        label881:
        paramInt2 = 2;
        break label791;
        label886:
        paramString = null;
        break label834;
        f.Iyx.idkeyStat(1265L, 5L, 1L, false);
      }
      AppMethodBeat.o(166805);
      return;
    }
  }
  
  public final void s(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166812);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramBaseFinderFeed);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    p.k(paramBaseFinderFeed, "finderFeedObj");
    localObject1 = new ass();
    ((ass)localObject1).fIY = this.fIY;
    ((ass)localObject1).query = this.query;
    ((ass)localObject1).offset = this.offset;
    ((ass)localObject1).continueFlag = 1;
    ((ass)localObject1).xHE = this.xHE;
    Object localObject3 = (Iterable)this.feedList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (BaseFinderFeed)((Iterator)localObject3).next();
      ((Collection)localObject2).add(Boolean.valueOf(((ass)localObject1).wHI.add(((BaseFinderFeed)localObject4).feedObject.getFeedObject())));
    }
    int i = 0;
    localObject2 = ((ass)localObject1).wHI;
    p.j(localObject2, "finderFeedSearchObj.objectList");
    localObject3 = ((Iterable)localObject2).iterator();
    for (;;)
    {
      int j;
      String str;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject3).next();
        if (paramBaseFinderFeed.feedObject.getFeedObject().id != ((FinderObject)localObject2).id) {
          break label497;
        }
        ((ass)localObject1).SFT = i;
        j = this.fromType;
        paramBaseFinderFeed = n.zWF;
        localObject2 = n.Mp(((FinderObject)localObject2).id);
        paramBaseFinderFeed = n.zWF;
        localObject3 = this.fIY;
        localObject4 = this.query;
        paramBaseFinderFeed = n.zWF;
        str = n.dPC();
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramBaseFinderFeed = aj.a.fZ((Context)this.iXq);
        if (paramBaseFinderFeed == null) {
          break label487;
        }
        paramBaseFinderFeed = paramBaseFinderFeed.ekY();
        n.a((String)localObject3, (String)localObject4, 0, 2, (String)localObject2, i, 1, str, j, paramBaseFinderFeed);
        paramBaseFinderFeed = n.zWF;
        localObject3 = this.fIY;
        localObject4 = this.query;
        paramBaseFinderFeed = n.zWF;
        str = n.dPC();
        paramBaseFinderFeed = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramBaseFinderFeed = aj.a.fZ((Context)this.iXq);
        if (paramBaseFinderFeed == null) {
          break label492;
        }
      }
      label487:
      label492:
      for (paramBaseFinderFeed = paramBaseFinderFeed.ekY();; paramBaseFinderFeed = null)
      {
        n.a((String)localObject3, (String)localObject4, 0, 2, (String)localObject2, i, 1, str, 2, j, paramBaseFinderFeed);
        paramBaseFinderFeed = new Intent();
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a((Context)this.iXq, paramBaseFinderFeed, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.b((Context)this.iXq, (ass)localObject1, paramBaseFinderFeed);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", "com/tencent/mm/plugin/finder/search/FinderMixSearchPresentercom/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", "onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V");
        AppMethodBeat.o(166812);
        return;
        paramBaseFinderFeed = null;
        break;
      }
      label497:
      i += 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hm>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderMixSearchPresenter.a parama, hm paramhm)
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