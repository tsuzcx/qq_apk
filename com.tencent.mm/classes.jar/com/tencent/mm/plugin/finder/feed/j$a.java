package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.s.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.t;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZZI)V", "encryptedObjectId", "", "getEncryptedObjectId", "()Ljava/lang/String;", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "isPostingScene", "()Z", "setPostingScene", "(Z)V", "needRelatedList", "getNeedRelatedList", "setNeedRelatedList", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "checkGetFeedDetail", "next", "Lkotlin/Function0;", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "ifSafeMode", "isFinderSelfScene", "loadFirstFeed", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class j$a
  extends ae.a
{
  public String AUV;
  public boolean AUW;
  public m<? super Integer, ? super String, ah> AUX;
  public kotlin.g.a.b<? super FinderObject, ah> AUY;
  public BaseFinderFeed AUZ;
  public boolean AVa;
  private final boolean hHq;
  public long hKN;
  private String objectNonceId;
  public final boolean safeMode;
  private final int scene;
  
  private j$a(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean, int paramInt2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(363116);
    this.scene = paramInt1;
    this.safeMode = paramBoolean;
    this.hHq = false;
    this.hJx = paramInt2;
    this.objectNonceId = "";
    this.AUV = "";
    this.AUW = true;
    AppMethodBeat.o(363116);
  }
  
  private static final ah a(a parama, a parama1, com.tencent.mm.am.b.a parama2)
  {
    AppMethodBeat.i(363143);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(parama1, "$next");
    Object localObject;
    long l;
    if ((parama2.errType == 0) && (parama2.errCode == 0))
    {
      localObject = ((dnj)parama2.ott).ZXx;
      if (localObject == null)
      {
        l = 0L;
        if (l == 0L) {
          break label206;
        }
        localObject = ((dnj)parama2.ott).ZXx;
        if (localObject != null) {
          break label145;
        }
        l = 0L;
        label75:
        parama.hKN = l;
        parama2 = ((dnj)parama2.ott).ZXx;
        if (parama2 != null) {
          break label171;
        }
        parama2 = "";
        label98:
        parama.setObjectNonceId(parama2);
        parama.aQ(parama1);
      }
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(363143);
      return parama;
      localObject = ((dne)localObject).aaUv;
      if (localObject == null)
      {
        l = 0L;
        break;
      }
      l = ((dno)localObject).hKN;
      break;
      label145:
      localObject = ((dne)localObject).aaUv;
      if (localObject == null)
      {
        l = 0L;
        break label75;
      }
      l = ((dno)localObject).hKN;
      break label75;
      label171:
      parama2 = parama2.aaUv;
      if (parama2 == null)
      {
        parama2 = "";
        break label98;
      }
      localObject = parama2.objectNonceId;
      parama2 = (com.tencent.mm.am.b.a)localObject;
      if (localObject != null) {
        break label98;
      }
      parama2 = "";
      break label98;
      label206:
      parama1 = parama.AUX;
      if (parama1 != null) {
        parama1.invoke(Integer.valueOf(parama2.errCode), parama2.errMsg);
      }
      com.tencent.mm.plugin.finder.report.s.e(com.tencent.mm.plugin.finder.report.s.Fqv, parama.hJx);
    }
  }
  
  private final void aQ(a<ah> parama)
  {
    AppMethodBeat.i(363133);
    long l = this.hKN;
    Object localObject2 = this.objectNonceId;
    int i = this.AJo;
    int j = this.scene;
    String str = this.AUV;
    Object localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)this.lzt);
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = new az(l, (String)localObject2, i, j, "", true, null, null, 0L, null, false, false, str, (bui)localObject1, 0, null, 53184);
      localObject2 = com.tencent.mm.plugin.finder.report.s.Fqv;
      i = this.hJx;
      if (this.hKN == 0L) {
        break label184;
      }
      bool1 = true;
      label113:
      if (((CharSequence)this.AUV).length() <= 0) {
        break label190;
      }
    }
    label184:
    label190:
    for (boolean bool2 = true;; bool2 = false)
    {
      com.tencent.mm.plugin.finder.report.s.b(i, true, bool1, bool2);
      ((az)localObject1).bFJ().a((com.tencent.mm.vending.e.b)this.lzt).b(new j.a..ExternalSyntheticLambda1(this, parama));
      AppMethodBeat.o(363133);
      return;
      localObject1 = ((as)localObject1).fou();
      break;
      bool1 = false;
      break label113;
    }
  }
  
  private static final ah b(a parama, a parama1, com.tencent.mm.am.b.a parama2)
  {
    int i = 1;
    Object localObject1 = null;
    AppMethodBeat.i(363162);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(parama1, "$next");
    com.tencent.mm.plugin.finder.report.s.c(com.tencent.mm.plugin.finder.report.s.Fqv, parama.hJx);
    Object localObject2;
    if ((parama2.errType != 0) || (parama2.errCode != 0))
    {
      localObject2 = aw.Gjk;
      if (!aw.iv(parama2.errType, parama2.errCode)) {}
    }
    else
    {
      Object localObject3 = ((ayl)parama2.ott).feedObject;
      if (localObject3 == null)
      {
        AppMethodBeat.o(363162);
        return null;
      }
      Log.i(parama.getTAG(), "get feed detail success");
      localObject2 = new FinderContact();
      parama2 = ((FinderObject)localObject3).contact;
      if (parama2 == null)
      {
        parama2 = null;
        ((FinderContact)localObject2).username = parama2;
        parama2 = ((FinderObject)localObject3).contact;
        if (parama2 != null) {
          break label596;
        }
        parama2 = null;
        label140:
        ((FinderContact)localObject2).nickname = parama2;
        parama2 = ((FinderObject)localObject3).contact;
        if (parama2 != null) {
          break label604;
        }
        parama2 = null;
        label158:
        ((FinderContact)localObject2).headUrl = parama2;
        parama2 = ((FinderObject)localObject3).contact;
        if (parama2 != null) {
          break label612;
        }
        parama2 = null;
        label176:
        ((FinderContact)localObject2).authInfo = parama2;
        parama2 = ((FinderObject)localObject3).contact;
        if (parama2 != null) {
          break label620;
        }
        parama2 = null;
        label194:
        ((FinderContact)localObject2).extInfo = parama2;
        parama2 = com.tencent.mm.plugin.finder.api.d.AwY;
        com.tencent.mm.plugin.finder.api.d.a.e((FinderContact)localObject2);
        parama2 = FinderItem.Companion;
        parama2 = FinderItem.a.e((FinderObject)localObject3, 1);
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.a.a(parama2);
        Object localObject4 = parama.AUY;
        if (localObject4 != null) {
          ((kotlin.g.a.b)localObject4).invoke(localObject3);
        }
        parama.hKN = ((FinderObject)localObject3).id;
        localObject3 = com.tencent.mm.plugin.finder.feed.component.d.Bca;
        com.tencent.mm.plugin.finder.feed.component.d.a.edf().gb(p.listOf(parama2));
        localObject3 = e.FMN;
        e.a.s(parama2);
        if (parama.AUZ != null) {
          break label638;
        }
        parama2 = parama.ALH;
        if (parama2 != null)
        {
          parama2 = parama2.getDataList();
          if (parama2 != null) {
            parama2.clear();
          }
        }
        parama2 = parama.ALH;
        if (parama2 != null)
        {
          parama2 = parama2.getDataList();
          if (parama2 != null) {
            parama2.add(localObject2);
          }
        }
        parama2 = parama.ATo;
        if (parama2 != null)
        {
          parama2 = parama2.ATx.getRecyclerView();
          if (parama2 != null)
          {
            parama2 = parama2.getAdapter();
            if (parama2 != null) {
              parama2.bZE.notifyChanged();
            }
          }
        }
        parama2 = com.tencent.mm.plugin.finder.report.s.Fqv;
        parama2 = com.tencent.mm.plugin.finder.report.s.Sk(parama.hJx);
        if (parama2 != null)
        {
          if ((!parama2.hS) || (parama2.FqA)) {
            break label628;
          }
          label408:
          if (i == 0) {
            break label633;
          }
          label412:
          if (parama2 != null) {
            parama2.FqO = cn.bDw();
          }
        }
        label423:
        localObject3 = parama.getTAG();
        localObject4 = new StringBuilder("[loadFirstFeed] feed=");
        parama2 = parama.AUZ;
        if (parama2 != null) {
          break label840;
        }
        parama2 = null;
        label452:
        localObject4 = ((StringBuilder)localObject4).append(parama2).append(" => ");
        parama2 = parama.AUZ;
        if (parama2 != null) {
          break label865;
        }
        parama2 = null;
        label477:
        localObject4 = ((StringBuilder)localObject4).append(parama2).append(" updateFeed=").append(((BaseFinderFeed)localObject2).feedObject.getId()).append(" => ");
        parama2 = (dji)p.oL((List)((BaseFinderFeed)localObject2).feedObject.getMediaList());
        if (parama2 != null) {
          break label921;
        }
        parama2 = localObject1;
        label533:
        Log.i((String)localObject3, parama2);
        if (kotlin.g.b.s.p("WeApp", parama.lzt.getIntent().getStringExtra("KEY_FROM_SOURCE"))) {
          break label929;
        }
        parama1.invoke();
      }
      for (;;)
      {
        parama = ah.aiuX;
        AppMethodBeat.o(363162);
        return parama;
        parama2 = parama2.username;
        break;
        label596:
        parama2 = parama2.nickname;
        break label140;
        label604:
        parama2 = parama2.headUrl;
        break label158;
        label612:
        parama2 = parama2.authInfo;
        break label176;
        label620:
        parama2 = parama2.extInfo;
        break label194;
        label628:
        i = 0;
        break label408;
        label633:
        parama2 = null;
        break label412;
        label638:
        parama2 = parama.ALH;
        if (parama2 == null) {
          break label423;
        }
        parama2 = parama2.getDataList();
        if (parama2 == null) {
          break label423;
        }
        parama2 = (cc)p.ae((List)parama2, 0);
        if (parama2 == null) {
          break label423;
        }
        if ((parama2 instanceof BaseFinderFeed)) {}
        for (;;)
        {
          if (parama2 == null) {
            break label838;
          }
          parama2 = (BaseFinderFeed)parama2;
          parama2.feedObject.setCommentCount(((BaseFinderFeed)localObject2).feedObject.getCommentCount());
          parama2.feedObject.setLikeCount(((BaseFinderFeed)localObject2).feedObject.getLikeCount());
          parama2.feedObject.setForwardCount(((BaseFinderFeed)localObject2).feedObject.getForwardCount());
          localObject3 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject().contact;
          if (localObject3 != null)
          {
            parama2.feedObject.getFeedObject().contact = ((FinderContact)localObject3);
            parama2.contact = c.a((FinderContact)localObject3, null, false);
          }
          parama2 = parama.ATo;
          if (parama2 != null)
          {
            parama2 = parama2.ATx.getRecyclerView();
            if (parama2 != null)
            {
              parama2 = parama2.getAdapter();
              if (parama2 != null) {
                parama2.t(0, new r(Integer.valueOf(12), null));
              }
            }
          }
          Log.d(parama.getTAG(), "cache exit,refresh apart");
          break;
          parama2 = null;
        }
        label838:
        break label423;
        label840:
        parama2 = parama2.feedObject;
        if (parama2 == null)
        {
          parama2 = null;
          break label452;
        }
        parama2 = Long.valueOf(parama2.getId());
        break label452;
        label865:
        parama2 = parama2.feedObject;
        if (parama2 == null)
        {
          parama2 = null;
          break label477;
        }
        parama2 = parama2.getMediaList();
        if (parama2 == null)
        {
          parama2 = null;
          break label477;
        }
        parama2 = (dji)p.oL((List)parama2);
        if (parama2 == null)
        {
          parama2 = null;
          break label477;
        }
        parama2 = parama2.url;
        break label477;
        label921:
        parama2 = parama2.url;
        break label533;
        label929:
        Log.i(parama.getTAG(), "小程序拦截");
        parama1 = parama.ATo;
        if (parama1 != null)
        {
          parama1 = parama1.ATx;
          if (parama1 != null)
          {
            parama1 = parama1.getLoadMoreFooter();
            if (parama1 != null)
            {
              parama2 = parama1.findViewById(e.e.rl_loading_icon);
              if (parama2 != null) {
                parama2.setVisibility(8);
              }
              parama1 = parama1.findViewById(e.e.load_finish);
              if (parama1 != null) {
                parama1.setVisibility(0);
              }
            }
          }
        }
        parama.AUW = false;
      }
    }
    if ((parama2.errCode == -4011) || (parama2.errCode == -4033) || (parama2.errCode == -4036))
    {
      parama1 = e.FMN;
      e.a.ky(parama.hKN);
      parama1 = parama.AUX;
      if (parama1 != null) {
        parama1.invoke(Integer.valueOf(parama2.errCode), parama2.errMsg);
      }
      com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, parama.hJx, false, null, 12);
      parama = ah.aiuX;
      AppMethodBeat.o(363162);
      return parama;
    }
    parama1 = parama.AUX;
    if (parama1 != null) {
      parama1.invoke(Integer.valueOf(parama2.errCode), parama2.errMsg);
    }
    com.tencent.mm.plugin.finder.report.s.e(com.tencent.mm.plugin.finder.report.s.Fqv, parama.hJx);
    parama = ah.aiuX;
    AppMethodBeat.o(363162);
    return parama;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(363231);
    kotlin.g.b.s.u(paramb, "callback");
    super.a(paramb);
    k localk = k.aeZF;
    ((t)k.d((AppCompatActivity)this.lzt).q(t.class)).E(paramb.ATx.getRecyclerView());
    AppMethodBeat.o(363231);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(363217);
    if (this.AUW)
    {
      Object localObject = com.tencent.mm.plugin.finder.report.s.Fqv;
      int i = this.hJx;
      localObject = k.aeZF;
      com.tencent.mm.plugin.finder.report.s.a(i, 2, ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).fou(), 4L);
      com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx, true, null, 12);
      localObject = this.ALH;
      if (localObject != null) {
        BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localObject, false, 1, null);
      }
    }
    AppMethodBeat.o(363217);
  }
  
  public final boolean ebw()
  {
    return this.hHq;
  }
  
  public final boolean ecb()
  {
    return this.safeMode;
  }
  
  public final ArrayList<cc> ecc()
  {
    AppMethodBeat.i(363224);
    Object localObject = this.ALH;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter())
    {
      localObject = (ArrayList)localObject;
      AppMethodBeat.o(363224);
      return localObject;
    }
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(363237);
    super.onDetach();
    AppMethodBeat.o(363237);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(363212);
    Object localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
    int i = this.hJx;
    localObject1 = k.aeZF;
    com.tencent.mm.plugin.finder.report.s.a(i, 0, ((as)k.d((AppCompatActivity)this.lzt).q(as.class)).fou(), 4L);
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx, true, null, 12);
    a locala = (a)new c(this);
    Object localObject2;
    if (this.AVa)
    {
      localObject2 = getTAG();
      localObject1 = this.AUZ;
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        Log.i((String)localObject2, kotlin.g.b.s.X("loadFirstFeed objectId = 0, localId = ", localObject1));
        if (this.AUZ == null) {
          com.tencent.mm.ae.d.uiThread((a)new a(this));
        }
        AppMethodBeat.o(363212);
        return;
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Long.valueOf(((FinderItem)localObject1).getLocalId());
        }
      }
    }
    if (((bw)h.ax(bw.class)).eZF())
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXV().bmg()).intValue() == 1)
      {
        com.tencent.mm.ae.d.uiThread((a)new b(this));
        AppMethodBeat.o(363212);
        return;
      }
    }
    if (this.lzt.getIntent().getIntExtra("business_type", 0) == 1)
    {
      localObject2 = this.lzt.getIntent().getStringExtra("finder_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      long l = this.hKN;
      String str = this.objectNonceId;
      localObject2 = as.GSQ;
      localObject2 = as.a.hu((Context)this.lzt);
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((as)localObject2).fou())
      {
        new bd(l, (String)localObject1, str, 1, (bui)localObject2).bFJ().a((com.tencent.mm.vending.e.b)this.lzt).b(new j.a..ExternalSyntheticLambda0(this, locala));
        AppMethodBeat.o(363212);
        return;
      }
    }
    aQ(locala);
    AppMethodBeat.o(363212);
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(363183);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.objectNonceId = paramString;
    AppMethodBeat.o(363183);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(j.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(j.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.a
 * JD-Core Version:    0.7.0.1
 */