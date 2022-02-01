package com.tencent.mm.plugin.finder.nearby.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.cp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.bk;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.model.v;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePreviewView;
import com.tencent.mm.plugin.finder.nearby.live.play.e;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewItemClick;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "source", "", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;ILcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;)V", "getBaseContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFragment", "()Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "myFollowFoldCardIndex", "getMyFollowFoldCardIndex", "()I", "setMyFollowFoldCardIndex", "(I)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "getSource", "sourceList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSourceList", "()Ljava/util/ArrayList;", "setSourceList", "(Ljava/util/ArrayList;)V", "enterLiveRoom", "", "pos", "feed", "data", "view", "Landroid/view/View;", "contextId", "", "clickTabContextId", "launchWithAnim", "", "getActivity", "getChnlExtra", "invokeSource", "getMaskViewResolutionForHeight", "", "width", "height", "ratio", "", "getStringCommentScene", "handleClick", "position", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handleClickReport", "isFoldFollowFeed", "saveCurrentClickFeedData", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setDataList", "list", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private final MMActivity AZo;
  private final bui Auc;
  private final b.a<cc> EIR;
  ArrayList<cc> EJA;
  final AbsNearByFragment EJl;
  private int EJz;
  private final int source;
  
  public g(bui parambui, MMActivity paramMMActivity, AbsNearByFragment paramAbsNearByFragment, int paramInt, b.a<cc> parama)
  {
    AppMethodBeat.i(340666);
    this.Auc = parambui;
    this.AZo = paramMMActivity;
    this.EJl = paramAbsNearByFragment;
    this.source = paramInt;
    this.EIR = parama;
    this.EJz = -1;
    AppMethodBeat.o(340666);
  }
  
  private final boolean QC(int paramInt)
  {
    AppMethodBeat.i(340726);
    if (this.EJz <= 0)
    {
      AppMethodBeat.o(340726);
      return false;
    }
    if (paramInt < this.EJz)
    {
      AppMethodBeat.o(340726);
      return false;
    }
    Object localObject = this.EJA;
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      i = 0;
      if (((Iterator)localObject).hasNext())
      {
        cc localcc = (cc)((Iterator)localObject).next();
        if (((localcc instanceof bn)) && (((bn)localcc).index > this.EJz))
        {
          j = 1;
          label106:
          if (j == 0) {
            break label134;
          }
        }
      }
    }
    for (;;)
    {
      if ((i > 0) || (paramInt < this.EJz)) {
        break label146;
      }
      AppMethodBeat.o(340726);
      return true;
      j = 0;
      break label106;
      label134:
      i += 1;
      break;
      i = -1;
    }
    label146:
    if (this.EJz <= paramInt) {
      if (paramInt < i) {
        paramInt = 1;
      }
    }
    while (paramInt != 0)
    {
      AppMethodBeat.o(340726);
      return true;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
    AppMethodBeat.o(340726);
    return false;
  }
  
  private final void a(int paramInt, cc paramcc, ArrayList<cc> paramArrayList, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(340708);
    Intent localIntent = new Intent();
    Object localObject2;
    Object localObject1;
    label155:
    label253:
    long l;
    if ((paramcc instanceof bk))
    {
      localObject2 = new bcg();
      ((bcg)localObject2).ZIQ = new LinkedList((Collection)((bk)paramcc).BbK);
      localObject1 = ((bk)paramcc).BbL;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((bcg)localObject2).ZNm = ((FinderJumpInfo)localObject1);
        localIntent.putExtra("FINDER_JUMP_INFO_WITH_OUTSIDE", ((bcg)localObject2).toByteArray());
      }
    }
    else
    {
      if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgG()) {
        break label1068;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramcc);
      localIntent.putExtra("key_chnl_extra", a(paramInt, paramView, "onItemClick"));
      paramArrayList = this.EJl;
      if (paramArrayList != null) {
        break label865;
      }
      paramArrayList = "";
      localIntent.putExtra("key_click_sub_tab_context_id", paramArrayList);
      localIntent.putExtra("LAUNCH_WITH_ANIM", paramBoolean);
      paramArrayList = b.k.ahpq;
      localIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWk());
      paramView = new bkt();
      localObject2 = new bks();
      bcc localbcc = new bcc();
      paramArrayList = com.tencent.mm.ui.component.k.aeZF;
      ap localap = (ap)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AZo).cq(ap.class);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label885;
      }
      paramArrayList = (BaseFinderFeed)paramcc;
      if (paramArrayList != null) {
        break label890;
      }
      l = 0L;
      label260:
      paramArrayList = localap.nw(l);
      if (paramArrayList != null) {
        break label914;
      }
      paramArrayList = null;
      label276:
      localbcc.ZNk = paramArrayList;
      paramArrayList = ah.aiuX;
      ((bks)localObject2).ZMQ = localbcc;
      paramArrayList = ah.aiuX;
      paramView.ZTQ = ((bks)localObject2);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label922;
      }
      paramArrayList = (BaseFinderFeed)paramcc;
      label316:
      if (paramArrayList != null) {
        break label927;
      }
      paramArrayList = null;
      label322:
      paramView.ZTR = paramArrayList;
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label949;
      }
      paramArrayList = (BaseFinderFeed)paramcc;
      label340:
      if (paramArrayList != null) {
        break label954;
      }
      paramArrayList = null;
      label346:
      paramView.location = paramArrayList;
      localIntent.putExtra("PRE_JOIN_LIVE_INFO", paramView.toByteArray());
      localIntent.putExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", true);
      localObject2 = new Bundle();
      paramArrayList = this.EJl;
      if (!(paramArrayList instanceof NearbyLiveSquareTabFragment)) {
        break label976;
      }
      paramArrayList = (NearbyLiveSquareTabFragment)paramArrayList;
      label402:
      if (paramArrayList != null) {
        break label981;
      }
      paramArrayList = "";
      label409:
      ((Bundle)localObject2).putString("tab_id", paramArrayList);
      paramArrayList = this.EJl;
      if (!(paramArrayList instanceof NearbyLiveSquareTabFragment)) {
        break label1022;
      }
      paramArrayList = (NearbyLiveSquareTabFragment)paramArrayList;
      label435:
      if (paramArrayList != null) {
        break label1027;
      }
      paramArrayList = "";
      label442:
      ((Bundle)localObject2).putString("sub_tab_id", paramArrayList);
      ((Bundle)localObject2).putString("card_index", String.valueOf(paramInt));
      paramArrayList = ah.aiuX;
      localIntent.putExtra("KEY_PARAMS_ENTRANCE_REPORT_INFO", (Bundle)localObject2);
      paramArrayList = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramView = (Context)this.AZo;
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramArrayList.a(paramView, com.tencent.mm.plugin.finder.live.utils.a.b((ArrayList)localObject1, paramcc, this.Auc.AJo), paramString1, paramString2, localIntent, false);
      label523:
      s.u(paramcc, "feed");
      paramString1 = new com.tencent.mm.ad.i();
      paramArrayList = this.EJl;
      if (!(paramArrayList instanceof NearbyLiveSquareTabFragment)) {
        break label1125;
      }
      paramArrayList = (NearbyLiveSquareTabFragment)paramArrayList;
      label556:
      if (paramArrayList != null) {
        break label1130;
      }
      paramArrayList = "";
      label563:
      paramString1.n("tab_id", paramArrayList);
      paramArrayList = this.EJl;
      if (!(paramArrayList instanceof NearbyLiveSquareTabFragment)) {
        break label1171;
      }
      paramArrayList = (NearbyLiveSquareTabFragment)paramArrayList;
      label590:
      if (paramArrayList != null) {
        break label1176;
      }
      paramArrayList = "";
      label597:
      paramString1.n("sub_tab_id", paramArrayList);
      paramString1.n("card_type", Integer.valueOf(1));
      paramString1.n("card_index", Integer.valueOf(paramInt));
      if (!(paramcc instanceof x)) {
        break label1217;
      }
      paramcc = (x)paramcc;
      label645:
      if (paramcc != null) {
        break label1222;
      }
      paramcc = "";
    }
    for (;;)
    {
      paramString1.n("liveid", paramcc);
      paramView = new cp();
      paramView.ixo = Util.nowMilliSecond();
      paramView.lV("");
      paramView.lW("");
      paramView.lX("");
      paramView.lY("");
      paramArrayList = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      paramcc = paramArrayList;
      if (paramArrayList == null) {
        paramcc = "";
      }
      paramView.lZ(paramcc);
      paramArrayList = this.Auc.zIO;
      paramcc = paramArrayList;
      if (paramArrayList == null) {
        paramcc = "";
      }
      paramView.ma(paramcc);
      paramView.mb(eEO());
      paramView.mc("");
      paramView.md("");
      paramView.me("");
      paramView.mf("more_page_card");
      paramcc = paramString1.toString();
      s.s(paramcc, "eldUdfKv.toString()");
      paramView.mg(n.bV(paramcc, ",", ";"));
      paramView.bMH();
      paramcc = com.tencent.mm.plugin.finder.live.fluent.i.CCI;
      com.tencent.mm.plugin.finder.live.fluent.i.ejv().gF("startActivity");
      AppMethodBeat.o(340708);
      return;
      localObject1 = ((blx)localObject1).ZNl;
      break;
      label865:
      paramView = paramArrayList.eEv();
      paramArrayList = paramView;
      if (paramView != null) {
        break label155;
      }
      paramArrayList = "";
      break label155;
      label885:
      paramArrayList = null;
      break label253;
      label890:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        l = 0L;
        break label260;
      }
      l = paramArrayList.getId();
      break label260;
      label914:
      paramArrayList = paramArrayList.ZNk;
      break label276;
      label922:
      paramArrayList = null;
      break label316;
      label927:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramArrayList = null;
        break label322;
      }
      paramArrayList = paramArrayList.getDescription();
      break label322;
      label949:
      paramArrayList = null;
      break label340;
      label954:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramArrayList = null;
        break label346;
      }
      paramArrayList = paramArrayList.getLocation();
      break label346;
      label976:
      paramArrayList = null;
      break label402;
      label981:
      paramArrayList = paramArrayList.EIq;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        break label409;
      }
      paramView = Integer.valueOf(paramArrayList.ZVZ).toString();
      paramArrayList = paramView;
      if (paramView != null) {
        break label409;
      }
      paramArrayList = "";
      break label409;
      label1022:
      paramArrayList = null;
      break label435;
      label1027:
      paramArrayList = paramArrayList.ELV;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        break label442;
      }
      paramView = Integer.valueOf(paramArrayList.ZVZ).toString();
      paramArrayList = paramView;
      if (paramView != null) {
        break label442;
      }
      paramArrayList = "";
      break label442;
      label1068:
      paramView = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = (Context)this.AZo;
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      f.a.a(paramView, (Context)localObject1, com.tencent.mm.plugin.finder.live.utils.a.a(paramArrayList, paramcc, 1001, this.Auc.AJo), paramString1, paramString2, localIntent, false, 32);
      break label523;
      label1125:
      paramArrayList = null;
      break label556;
      label1130:
      paramArrayList = paramArrayList.EIq;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        break label563;
      }
      paramView = Integer.valueOf(paramArrayList.ZVZ).toString();
      paramArrayList = paramView;
      if (paramView != null) {
        break label563;
      }
      paramArrayList = "";
      break label563;
      label1171:
      paramArrayList = null;
      break label590;
      label1176:
      paramArrayList = paramArrayList.ELV;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        break label597;
      }
      paramView = Integer.valueOf(paramArrayList.ZVZ).toString();
      paramArrayList = paramView;
      if (paramView != null) {
        break label597;
      }
      paramArrayList = "";
      break label597;
      label1217:
      paramcc = null;
      break label645;
      label1222:
      paramcc = paramcc.feedObject;
      if (paramcc == null)
      {
        paramcc = "";
      }
      else
      {
        paramcc = paramcc.getLiveInfo();
        if (paramcc == null)
        {
          paramcc = "";
        }
        else
        {
          paramArrayList = Long.valueOf(paramcc.liveId).toString();
          paramcc = paramArrayList;
          if (paramArrayList == null) {
            paramcc = "";
          }
        }
      }
    }
  }
  
  private final String eEO()
  {
    AppMethodBeat.i(340673);
    if (this.source == 15)
    {
      String str = q.n.DtM.scene;
      AppMethodBeat.o(340673);
      return str;
    }
    int i = this.Auc.AJo;
    AppMethodBeat.o(340673);
    return String.valueOf(i);
  }
  
  private final void g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(340680);
    com.tencent.d.a.b.a.a.a.a locala = com.tencent.d.a.b.a.a.a.a.ahqb;
    com.tencent.d.a.b.a.a.a.a.cl((kotlin.g.a.a)new c(paramFinderItem, this));
    AppMethodBeat.o(340680);
  }
  
  private static int[] g(int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramInt1 = (int)(paramInt2 * paramFloat);
      }
      return new int[] { paramInt1, paramInt2 };
    }
  }
  
  public final String a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(340787);
    s.u(paramString, "invokeSource");
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    if (!com.tencent.mm.plugin.finder.nearby.live.square.page.b.QN(this.Auc.AJo))
    {
      if (s.p(paramString, "onExpose"))
      {
        if (paramView != null)
        {
          paramString = paramView.getTag(e.e.nearby_live_card_is_enhanced_expose);
          if ((paramString != null) && ((paramString instanceof String)) && (!s.p(paramString, "")))
          {
            locali.m("card_style", "{if_enhanced:1}");
            paramView.setTag(e.e.nearby_live_card_is_enhanced_expose, "");
          }
        }
        if (!QC(paramInt)) {
          break label523;
        }
        locali.au("my_follow_fold", 1);
        label121:
        paramView = this.EJl;
        if (!(paramView instanceof NearbyLiveSquareTabFragment)) {
          break label536;
        }
        paramView = (NearbyLiveSquareTabFragment)paramView;
        label138:
        if (paramView != null) {
          break label541;
        }
        paramView = "";
        label145:
        paramString = this.EJl;
        if (!(paramString instanceof NearbyLiveSquareTabFragment)) {
          break label580;
        }
        paramString = (NearbyLiveSquareTabFragment)paramString;
        label162:
        if (paramString != null) {
          break label585;
        }
        paramString = "";
      }
      for (;;)
      {
        locali.m("tab_id", paramView);
        locali.m("sub_tab_id", paramString);
        paramView = com.tencent.mm.ui.component.k.aeZF;
        paramView = ((com.tencent.mm.plugin.finder.nearby.b)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AZo).q(com.tencent.mm.plugin.finder.nearby.b.class)).EFi;
        paramString = com.tencent.mm.ui.component.k.aeZF;
        localObject = ((com.tencent.mm.plugin.finder.nearby.b)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AZo).q(com.tencent.mm.plugin.finder.nearby.b.class)).EFj;
        if ((localObject != null) && (paramView != null))
        {
          FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = ((p)localObject).eav();
          paramString = com.tencent.mm.ae.f.dg(localFinderTipsShowEntranceExtInfo);
          locali.n("reddotctrltype", Long.valueOf(((p)localObject).field_ctrInfo.type));
          locali.n("reddottipsid", ((p)localObject).field_tipsId);
          locali.n("reddotshowinfopath", paramView.path);
          paramString = paramString.opt("report_ext_info");
          paramView = paramString;
          if (paramString == null) {
            paramView = "";
          }
          locali.n("reddotshowinfoext", paramView);
          locali.n("feedid", com.tencent.mm.ae.d.hF(localFinderTipsShowEntranceExtInfo.object_id));
          locali.n("username", ((p)localObject).ASz.YIZ);
        }
        locali.m("enter_immerse_type", eEO());
        locali.m("square_index", String.valueOf(paramInt));
        paramView = locali.toString();
        s.s(paramView, "chnlExtra.toString()");
        paramView = n.m(paramView, ",", ";", false);
        if (paramView != null) {
          break label730;
        }
        AppMethodBeat.o(340787);
        return "";
        if ((!s.p(paramString, "onItemClick")) || (paramView == null)) {
          break;
        }
        paramString = paramView.getTag(f.d.nearby_live_card_click_timing);
        if ((paramString == null) || (!(paramString instanceof String)) || (s.p(paramString, ""))) {
          break;
        }
        locali.m("card_style", "{if_enhanced:1}");
        locali.m("click_timing", paramString);
        paramView.setTag(e.e.nearby_live_card_click_timing, "");
        paramView.setTag(e.e.nearby_live_card_is_enhanced_click, "");
        break;
        label523:
        locali.au("my_follow_fold", 0);
        break label121;
        label536:
        paramView = null;
        break label138;
        label541:
        paramView = paramView.EIq;
        if (paramView == null)
        {
          paramView = "";
          break label145;
        }
        paramView = Integer.valueOf(paramView.ZVZ).toString();
        if (paramView == null)
        {
          paramView = "";
          break label145;
        }
        break label145;
        label580:
        paramString = null;
        break label162;
        label585:
        paramString = paramString.ELV;
        if (paramString == null)
        {
          paramString = "";
        }
        else
        {
          localObject = Integer.valueOf(paramString.ZVZ).toString();
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = "";
          }
        }
      }
    }
    paramView = this.EJl;
    if (paramView == null)
    {
      paramView = "";
      label638:
      paramString = this.EJl;
      if (paramString != null) {
        break label710;
      }
      paramString = "";
    }
    for (;;)
    {
      locali.m("tab_id", paramView);
      locali.m("sub_tab_id", paramString);
      locali.m("tag", "");
      paramView = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      com.tencent.mm.plugin.finder.nearby.live.report.a.b(locali);
      break;
      paramString = paramView.eEt();
      paramView = paramString;
      if (paramString != null) {
        break label638;
      }
      paramView = "";
      break label638;
      label710:
      localObject = paramString.eEu();
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
    label730:
    AppMethodBeat.o(340787);
    return paramView;
  }
  
  public final void a(final cc paramcc, int paramInt1, final int paramInt2, final View paramView, final ArrayList<cc> paramArrayList, final String paramString1, final String paramString2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(340766);
    s.u(paramcc, "feed");
    s.u(paramView, "view");
    s.u(paramArrayList, "data");
    s.u(paramString1, "contextId");
    s.u(paramString2, "clickTabContextId");
    s.u(paramRecyclerView, "recyclerView");
    Object localObject1 = aw.Gjk;
    if (aw.isFastClick())
    {
      Log.i("NearbyLiveViewCallback", "onItemClick pos:" + paramInt1 + " feed:" + paramcc + " return for fastClick");
      AppMethodBeat.o(340766);
      return;
    }
    Log.i("NearbyLiveViewCallback", "onItemClick pos:" + paramInt1 + " feed:" + paramcc);
    if ((paramcc instanceof BaseFinderFeed))
    {
      localObject1 = aw.Gjk;
      label385:
      label650:
      label658:
      label1046:
      label1177:
      if (aw.s((BaseFinderFeed)paramcc))
      {
        Object localObject4 = j.Dob;
        Object localObject5 = (BaseFinderFeed)paramcc;
        long l = paramInt1;
        q.w localw = q.w.DwU;
        String str = eEO();
        localObject1 = this.Auc.zIB;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = this.EJl;
        if (localObject1 == null)
        {
          localObject1 = "";
          ((j)localObject4).a((BaseFinderFeed)localObject5, l, localw, str, (String)localObject2, (String)localObject1, a(paramInt2, paramView, "onItemClick"));
          g(((BaseFinderFeed)paramcc).feedObject);
          if (!Util.isEqual(((BaseFinderFeed)paramcc).feedObject.getUserName(), z.bAW())) {
            break label501;
          }
          paramString1 = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
          paramString2 = (Context)this.AZo;
          l = ((BaseFinderFeed)paramcc).feedObject.getId();
          paramRecyclerView = ((BaseFinderFeed)paramcc).feedObject.getObjectNonceId();
          paramArrayList = ((BaseFinderFeed)paramcc).feedObject.getLiveInfo();
          paramView = paramArrayList;
          if (paramArrayList == null) {
            paramView = new bip();
          }
          f.a.a(paramString1, paramString2, l, paramRecyclerView, paramView, null, null, null, null, null, ((BaseFinderFeed)paramcc).getSessionBuffer(), null, null, 7152);
          paramView = this.EIR;
          if (paramView == null) {
            break label1469;
          }
          paramView = paramView.eEx();
          if ((paramView == null) || (paramView.QH(paramInt2) != true)) {
            break label1469;
          }
        }
        label1052:
        label1469:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0)
          {
            paramView = com.tencent.mm.plugin.finder.nearby.report.a.EQq;
            com.tencent.mm.plugin.finder.nearby.report.a.b((x)paramcc, paramInt2);
          }
          paramView = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
          com.tencent.mm.plugin.finder.nearby.live.report.a.eFw();
          paramView = a.EIi;
          if (a.kLo()) {
            break label1672;
          }
          paramView = com.tencent.mm.plugin.finder.report.k.Fpu;
          com.tencent.mm.plugin.finder.report.k.a(this.Auc, paramcc);
          AppMethodBeat.o(340766);
          return;
          Object localObject3 = ((AbsNearByFragment)localObject1).eEv();
          localObject1 = localObject3;
          if (localObject3 != null) {
            break;
          }
          localObject1 = "";
          break;
          label501:
          localObject1 = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
          if ((com.tencent.mm.plugin.finder.live.fluent.a.isEnable()) && (!com.tencent.mm.n.a.r((Context)this.AZo, false)) && (v.CGh.ekX()))
          {
            localObject2 = (NearbyLivePreviewView)paramView.findViewWithTag("nearby-live-preview-view-tag");
            localObject3 = paramView.findViewById(f.d.thumb_iv);
            localObject1 = ((BaseFinderFeed)paramcc).feedObject.getFeedObject().liveInfo;
            label580:
            boolean bool5;
            boolean bool1;
            label605:
            boolean bool2;
            label634:
            boolean bool3;
            if (localObject1 == null)
            {
              paramInt1 = 0;
              bool5 = com.tencent.mm.ae.d.ee(paramInt1, 256);
              if ((localObject2 == null) || (!((NearbyLivePreviewView)localObject2).isPlaying())) {
                break label982;
              }
              bool1 = true;
              localObject1 = ((BaseFinderFeed)paramcc).feedObject.getLiveInfo();
              if ((localObject1 == null) || (((bip)localObject1).liveStatus != 1)) {
                break label988;
              }
              bool2 = true;
              if ((localObject2 == null) || (!((NearbyLivePreviewView)localObject2).ELh)) {
                break label994;
              }
              bool3 = true;
              if (localObject2 != null) {
                break label1000;
              }
              localObject1 = null;
              if (localObject1 == null) {
                break label1046;
              }
            }
            for (boolean bool4 = true;; bool4 = false)
            {
              Log.i("NearbyLiveViewCallback", "startSwitchOutFromSquare animation for feed:" + com.tencent.mm.ae.d.hF(paramcc.bZA()) + " liveStatusOpen:" + bool2 + " isPlaying:" + bool1 + " isAudioMode" + bool5 + " isFirstFrameRendered:" + bool3 + " isSurfaceTextureAvailable:" + bool4);
              if ((!bool1) || (!bool3) || (bool5) || (!bool2) || (!bool4)) {
                break label1052;
              }
              Log.w("NearbyLiveViewCallback", "startSwitchOutFromSquare video animation for feed:" + com.tencent.mm.ae.d.hF(paramcc.bZA()) + " liveView:" + localObject2);
              l = ((BaseFinderFeed)paramcc).feedObject.getId();
              paramRecyclerView = h.a.CCE;
              localObject1 = ((NearbyLivePreviewView)localObject2).getRenderView().getVideoView();
              s.s(localObject1, "liveView.renderView.videoView");
              paramRecyclerView = new com.tencent.mm.plugin.finder.live.fluent.f(paramRecyclerView, false, l, paramView, (TextureView)localObject1, ((NearbyLivePreviewView)localObject2).eFj(), ((NearbyLivePreviewView)localObject2).getVideoWidth(), ((NearbyLivePreviewView)localObject2).getVideoHeight(), ((NearbyLivePreviewView)localObject2).getVideoRatioWH(), g(paramView.getWidth(), paramView.getHeight(), ((NearbyLivePreviewView)localObject2).getVideoRatioWH()));
              paramRecyclerView.mUN = paramView.findViewById(e.e.live_player_container);
              localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
              com.tencent.mm.plugin.finder.live.fluent.g.a((Context)this.AZo, (com.tencent.mm.plugin.finder.live.fluent.h)paramRecyclerView).aX((kotlin.g.a.a)new a(this, paramInt2, paramcc, paramArrayList, paramView, paramString1, paramString2));
              break;
              paramInt1 = (int)((bip)localObject1).ZFH;
              break label580;
              label982:
              bool1 = false;
              break label605;
              label988:
              bool2 = false;
              break label634;
              label994:
              bool3 = false;
              break label650;
              label1000:
              localObject1 = ((NearbyLivePreviewView)localObject2).getRenderView();
              if (localObject1 == null)
              {
                localObject1 = null;
                break label658;
              }
              localObject1 = ((com.tencent.mm.plugin.finder.video.d)localObject1).getVideoView();
              if (localObject1 == null)
              {
                localObject1 = null;
                break label658;
              }
              localObject1 = ((TextureView)localObject1).getSurfaceTexture();
              break label658;
            }
            if ((bool2) && (localObject3 != null))
            {
              l = ((BaseFinderFeed)paramcc).feedObject.getId();
              localObject1 = ((BaseFinderFeed)paramcc).feedObject.getFeedObject().liveInfo;
              if ((localObject1 != null) && (((bip)localObject1).ZSl == 1))
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label1177;
                }
                localObject1 = "";
              }
              int i;
              float f;
              for (;;)
              {
                paramInt1 = ((View)localObject3).getWidth();
                i = ((View)localObject3).getHeight();
                f = 1.0F * paramInt1 / i;
                localObject4 = h.a.CCE;
                localObject5 = ((View)localObject3).getParent();
                if (localObject5 != null) {
                  break label1213;
                }
                paramcc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(340766);
                throw paramcc;
                paramInt1 = 0;
                break;
                localObject1 = ((BaseFinderFeed)paramcc).feedObject.getFeedObject().liveInfo;
                if (localObject1 == null) {
                  localObject1 = null;
                } else {
                  localObject1 = ((bip)localObject1).mIE;
                }
              }
              label1213:
              localObject5 = (ViewGroup)localObject5;
              if (localObject1 == null)
              {
                localObject1 = "";
                label1229:
                paramRecyclerView = new com.tencent.mm.plugin.finder.live.fluent.c((h.a)localObject4, l, paramRecyclerView, (ViewGroup)localObject5, (View)localObject3, paramInt1, i, f, (String)localObject1);
                localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
                localObject1 = com.tencent.mm.plugin.finder.live.fluent.g.a((Context)this.AZo, (com.tencent.mm.plugin.finder.live.fluent.h)paramRecyclerView);
                localObject3 = new StringBuilder("startSwitchOutFromSquare image animation for feed:").append(com.tencent.mm.ae.d.hF(paramcc.bZA())).append(" liveView:").append(localObject2).append(" maskViewRes[").append(paramInt1).append(", ").append(i).append("] isFirstFrameRendered:");
                if (localObject2 != null) {
                  break label1397;
                }
              }
              label1397:
              for (paramRecyclerView = null;; paramRecyclerView = Boolean.valueOf(((NearbyLivePreviewView)localObject2).ELh))
              {
                Log.w("NearbyLiveViewCallback", paramRecyclerView);
                ((com.tencent.mm.plugin.finder.live.fluent.k)localObject1).aX((kotlin.g.a.a)new b(this, paramInt2, paramcc, paramArrayList, paramView, paramString1, paramString2));
                break;
                break label1229;
              }
            }
            Log.w("NearbyLiveViewCallback", "startSwitchOutFromSquare no animation for feed:" + com.tencent.mm.ae.d.hF(paramcc.bZA()) + " liveView:" + localObject2);
          }
          a(this, paramInt2, paramcc, paramArrayList, paramView, paramString1, paramString2);
          break label385;
        }
      }
    }
    if ((paramcc instanceof au))
    {
      this.EJz = ((au)paramcc).position;
      paramArrayList = this.EIR;
      if (paramArrayList != null) {
        paramArrayList.b((au)paramcc);
      }
      paramArrayList = new cp();
      paramArrayList.ixo = Util.nowMilliSecond();
      paramArrayList.lV("");
      paramArrayList.lW(a(paramInt2, paramView, "onItemClick"));
      paramArrayList.lX("");
      paramArrayList.lY("");
      paramView = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      paramcc = paramView;
      if (paramView == null) {
        paramcc = "";
      }
      paramArrayList.lZ(paramcc);
      paramArrayList.ma(this.Auc.zIO);
      paramArrayList.mb(String.valueOf(this.Auc.AJo));
      paramArrayList.mc(paramString2);
      paramArrayList.md("");
      paramArrayList.me("");
      paramArrayList.mf("all_my_follow");
      paramArrayList.mg("");
      paramArrayList.bMH();
    }
    label1672:
    AppMethodBeat.o(340766);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(g paramg, int paramInt, cc paramcc, ArrayList<cc> paramArrayList, View paramView, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(g paramg, int paramInt, cc paramcc, ArrayList<cc> paramArrayList, View paramView, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(FinderItem paramFinderItem, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.g
 * JD-Core Version:    0.7.0.1
 */