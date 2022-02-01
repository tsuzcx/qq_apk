package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.cp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.live.fluent.g;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.model.v;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePreviewView;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bna;
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
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick;", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "source", "", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;ILcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;)V", "getBaseContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFragment", "()Landroidx/fragment/app/Fragment;", "myFollowFoldCardIndex", "getMyFollowFoldCardIndex", "()I", "setMyFollowFoldCardIndex", "(I)V", "getOutsideOperator", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "getSource", "sourceList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getSourceList", "()Ljava/util/ArrayList;", "setSourceList", "(Ljava/util/ArrayList;)V", "bundleToString", "", "bundle", "Landroid/os/Bundle;", "enterLiveRoom", "", "pos", "feed", "data", "view", "Landroid/view/View;", "contextId", "clickTabContextId", "launchWithAnim", "", "scene", "extraInfo", "getActivity", "getChnlExtra", "invokeSource", "getMaskViewResolutionForHeight", "", "width", "height", "ratio", "", "getStringCommentScene", "handleClick", "position", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isFoldFollowFeed", "saveCurrentClickFeedData", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setDataList", "list", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ENf;
  private static boolean akhC;
  private final MMActivity AZo;
  private final bui Auc;
  private ArrayList<cc> EJA;
  private int EJz;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  private final Fragment fragment;
  private final int source;
  
  static
  {
    AppMethodBeat.i(340437);
    ENf = new a((byte)0);
    AppMethodBeat.o(340437);
  }
  
  public a(bui parambui, MMActivity paramMMActivity, Fragment paramFragment, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb)
  {
    AppMethodBeat.i(340357);
    this.Auc = parambui;
    this.AZo = paramMMActivity;
    this.fragment = paramFragment;
    this.source = 0;
    this.ENg = paramb;
    this.EJz = -1;
    AppMethodBeat.o(340357);
  }
  
  private final boolean QC(int paramInt)
  {
    AppMethodBeat.i(340428);
    if (this.EJz <= 0)
    {
      AppMethodBeat.o(340428);
      return false;
    }
    if (paramInt < this.EJz)
    {
      AppMethodBeat.o(340428);
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
      AppMethodBeat.o(340428);
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
      AppMethodBeat.o(340428);
      return true;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
    AppMethodBeat.o(340428);
    return false;
  }
  
  private final void a(int paramInt1, cc paramcc, ArrayList<cc> paramArrayList, View paramView, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(340409);
    Intent localIntent = new Intent();
    label202:
    long l;
    if ((paramcc instanceof l))
    {
      localObject2 = new bcg();
      ((bcg)localObject2).ZIQ = new LinkedList((Collection)((l)paramcc).BbK);
      localObject1 = ((l)paramcc).BbL;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((bcg)localObject2).ZNm = ((FinderJumpInfo)localObject1);
        localIntent.putExtra("FINDER_JUMP_INFO_WITH_OUTSIDE", ((bcg)localObject2).toByteArray());
      }
    }
    else
    {
      if (paramInt2 != 3) {
        break label551;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramcc);
      localIntent.putExtra("key_chnl_extra", a(paramInt1, paramView, "onItemClick"));
      localIntent.putExtra("LAUNCH_WITH_ANIM", paramBoolean);
      paramView = new bkt();
      localObject2 = new bks();
      localObject3 = new bcc();
      paramArrayList = com.tencent.mm.ui.component.k.aeZF;
      ap localap = (ap)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AZo).cq(ap.class);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label460;
      }
      paramArrayList = (BaseFinderFeed)paramcc;
      if (paramArrayList != null) {
        break label465;
      }
      l = 0L;
      label209:
      paramArrayList = localap.nw(l);
      if (paramArrayList != null) {
        break label489;
      }
      paramArrayList = null;
      label225:
      ((bcc)localObject3).ZNk = paramArrayList;
      paramArrayList = ah.aiuX;
      ((bks)localObject2).ZMQ = ((bcc)localObject3);
      paramArrayList = ah.aiuX;
      paramView.ZTQ = ((bks)localObject2);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label497;
      }
      paramArrayList = (BaseFinderFeed)paramcc;
      label265:
      if (paramArrayList != null) {
        break label502;
      }
      paramArrayList = null;
      label271:
      paramView.ZTR = paramArrayList;
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label524;
      }
      paramArrayList = (BaseFinderFeed)paramcc;
      label289:
      if (paramArrayList != null) {
        break label529;
      }
      paramArrayList = null;
    }
    for (;;)
    {
      paramView.location = paramArrayList;
      localIntent.putExtra("PRE_JOIN_LIVE_INFO", paramView.toByteArray());
      if ((paramcc instanceof BaseFinderFeed)) {
        localIntent.putExtra("CURRENT_FEED_ID", ((BaseFinderFeed)paramcc).feedObject.getId());
      }
      localIntent.putExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", true);
      if (paramBundle != null)
      {
        localIntent.putExtra("KEY_PARAMS_ENTRANCE_REPORT_INFO", paramBundle);
        localIntent.putExtra("key_chnl_extra", aj(paramBundle));
      }
      com.tencent.mm.plugin.expt.hellhound.a.aqz("135");
      paramArrayList = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramView = (Context)this.AZo;
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramArrayList.a(paramView, com.tencent.mm.plugin.finder.live.utils.a.b((ArrayList)localObject1, paramcc, this.Auc.AJo), paramString1, paramString2, localIntent, false);
      paramcc = com.tencent.mm.plugin.finder.live.fluent.i.CCI;
      com.tencent.mm.plugin.finder.live.fluent.i.ejv().gF("startActivity");
      AppMethodBeat.o(340409);
      return;
      localObject1 = ((blx)localObject1).ZNl;
      break;
      label460:
      paramArrayList = null;
      break label202;
      label465:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        l = 0L;
        break label209;
      }
      l = paramArrayList.getId();
      break label209;
      label489:
      paramArrayList = paramArrayList.ZNk;
      break label225;
      label497:
      paramArrayList = null;
      break label265;
      label502:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramArrayList = null;
        break label271;
      }
      paramArrayList = paramArrayList.getDescription();
      break label271;
      label524:
      paramArrayList = null;
      break label289;
      label529:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null) {
        paramArrayList = null;
      } else {
        paramArrayList = paramArrayList.getLocation();
      }
    }
    label551:
    localIntent.putExtra("key_chnl_extra", a(paramInt1, paramView, "onItemClick"));
    localIntent.putExtra("LAUNCH_WITH_ANIM", paramBoolean);
    if ((paramcc instanceof BaseFinderFeed)) {
      localIntent.putExtra("CURRENT_FEED_ID", ((BaseFinderFeed)paramcc).feedObject.getId());
    }
    localIntent.putExtra("key_enter_live_param_pull_more_type", 1);
    if (paramBundle != null)
    {
      localIntent.putExtra("KEY_PARAMS_ENTRANCE_REPORT_INFO", paramBundle);
      localIntent.putExtra("key_chnl_extra", aj(paramBundle));
    }
    com.tencent.mm.plugin.expt.hellhound.a.aqz("135");
    paramBundle = new bkt();
    Object localObject1 = new bks();
    Object localObject2 = new bcc();
    paramView = com.tencent.mm.ui.component.k.aeZF;
    Object localObject3 = (ap)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AZo).cq(ap.class);
    if ((paramcc instanceof BaseFinderFeed))
    {
      paramView = (BaseFinderFeed)paramcc;
      if (paramView != null) {
        break label951;
      }
      l = 0L;
      label723:
      paramView = ((ap)localObject3).nw(l);
      if (paramView != null) {
        break label979;
      }
      paramView = null;
      label742:
      ((bcc)localObject2).ZNk = paramView;
      paramView = ah.aiuX;
      ((bks)localObject1).ZMQ = ((bcc)localObject2);
      paramView = ah.aiuX;
      paramBundle.ZTQ = ((bks)localObject1);
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label989;
      }
      paramView = (BaseFinderFeed)paramcc;
      label786:
      if (paramView != null) {
        break label995;
      }
      paramView = null;
      label794:
      paramBundle.ZTR = paramView;
      if (!(paramcc instanceof BaseFinderFeed)) {
        break label1023;
      }
      paramView = (BaseFinderFeed)paramcc;
      label814:
      if (paramView != null) {
        break label1029;
      }
      paramView = null;
    }
    for (;;)
    {
      paramBundle.location = paramView;
      localIntent.putExtra("PRE_JOIN_LIVE_INFO", paramBundle.toByteArray());
      localIntent.putExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", true);
      paramBundle = new bmx();
      paramView = ((Iterable)paramArrayList).iterator();
      while (paramView.hasNext())
      {
        localObject1 = (cc)paramView.next();
        if (((localObject1 instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)) && (((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)localObject1).feedObject.field_id != 0L)) {
          paramBundle.ZVD.add(Long.valueOf(((com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)localObject1).feedObject.field_id));
        }
      }
      paramView = null;
      break;
      label951:
      paramView = paramView.feedObject;
      if (paramView == null)
      {
        l = 0L;
        break label723;
      }
      l = paramView.getId();
      break label723;
      label979:
      paramView = paramView.ZNk;
      break label742;
      label989:
      paramView = null;
      break label786;
      label995:
      paramView = paramView.feedObject;
      if (paramView == null)
      {
        paramView = null;
        break label794;
      }
      paramView = paramView.getDescription();
      break label794;
      label1023:
      paramView = null;
      break label814;
      label1029:
      paramView = paramView.feedObject;
      if (paramView == null) {
        paramView = null;
      } else {
        paramView = paramView.getLocation();
      }
    }
    if ((paramcc instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b))
    {
      paramView = (com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)paramcc;
      label1070:
      if (paramView != null) {
        break label1194;
      }
      paramView = null;
      label1078:
      paramBundle.ZKM = paramView;
      paramView = this.ENg;
      if (paramView != null) {
        break label1222;
      }
    }
    label1194:
    label1222:
    for (paramView = null;; paramView = paramView.eFK())
    {
      paramBundle.ZKL = paramView;
      if (!paramBundle.ZVD.isEmpty()) {
        localIntent.putExtra("KEY_ENTER_LIVE_PARAM_SQUARE_EXTRA_INFO", paramBundle.toByteArray());
      }
      paramView = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
      paramBundle = (Context)this.AZo;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      f.a.a(paramView, paramBundle, com.tencent.mm.plugin.finder.live.utils.a.a(paramArrayList, paramcc, 1001, this.Auc.AJo), paramString1, paramString2, localIntent, false, 32);
      break;
      paramView = null;
      break label1070;
      paramView = paramView.ENs;
      if (paramView == null)
      {
        paramView = null;
        break label1078;
      }
      paramView = paramView.Zpn;
      break label1078;
    }
  }
  
  private static String aj(Bundle paramBundle)
  {
    AppMethodBeat.i(370498);
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramBundle.keySet();
        if (localObject != null) {
          break label98;
        }
        localObject = null;
      }
      catch (Exception paramBundle)
      {
        String str;
        Log.w("NewEntranceViewItemClick", s.X("bundleToString err:", paramBundle.getMessage()));
        paramBundle = locali.toString();
        s.s(paramBundle, "json.toString()");
        AppMethodBeat.o(370498);
        return paramBundle;
      }
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        locali.n(str, paramBundle.get(str));
      }
      else
      {
        label98:
        localObject = ((Set)localObject).iterator();
        if (localObject == null) {}
      }
    }
  }
  
  private final String eEO()
  {
    AppMethodBeat.i(340382);
    if (this.source == 15)
    {
      String str = q.n.DtM.scene;
      AppMethodBeat.o(340382);
      return str;
    }
    int i = this.Auc.AJo;
    AppMethodBeat.o(340382);
    return String.valueOf(i);
  }
  
  private static void g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(340389);
    com.tencent.d.a.b.a.a.a.a locala = com.tencent.d.a.b.a.a.a.a.ahqb;
    com.tencent.d.a.b.a.a.a.a.cl((kotlin.g.a.a)new a.d(paramFinderItem));
    AppMethodBeat.o(340389);
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
    AppMethodBeat.i(340467);
    s.u(paramString, "invokeSource");
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    if (!com.tencent.mm.plugin.finder.nearby.live.square.page.b.QN(this.Auc.AJo)) {
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
          break label462;
        }
        locali.au("my_follow_fold", 1);
        label123:
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
      }
    }
    for (;;)
    {
      locali.m("enter_immerse_type", eEO());
      locali.m("square_index", String.valueOf(paramInt));
      paramView = locali.toString();
      s.s(paramView, "chnlExtra.toString()");
      paramView = n.m(paramView, ",", ";", false);
      if (paramView != null) {
        break label499;
      }
      AppMethodBeat.o(340467);
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
      label462:
      locali.au("my_follow_fold", 0);
      break label123;
      locali.m("tag", "");
      paramView = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      com.tencent.mm.plugin.finder.nearby.live.report.a.b(locali);
    }
    label499:
    AppMethodBeat.o(340467);
    return paramView;
  }
  
  public final void a(final cc paramcc, int paramInt1, final int paramInt2, final View paramView, final ArrayList<cc> paramArrayList, final String paramString, RecyclerView paramRecyclerView, final int paramInt3, final Bundle paramBundle)
  {
    AppMethodBeat.i(370507);
    s.u(paramcc, "feed");
    s.u(paramView, "view");
    s.u(paramArrayList, "data");
    s.u(paramString, "clickTabContextId");
    s.u(paramRecyclerView, "recyclerView");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = paramView.getContext();
    s.s(localObject1, "view.context");
    localObject1 = (as)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(as.class);
    final String str;
    if (localObject1 == null) {
      str = "";
    }
    for (;;)
    {
      localObject1 = aw.Gjk;
      if (!aw.isFastClick()) {
        break;
      }
      Log.i("NewEntranceViewItemClick", "onItemClick pos:" + paramInt1 + " feed:" + paramcc + " return for fastClick");
      AppMethodBeat.o(370507);
      return;
      str = ((as)localObject1).zIO;
      if (str == null) {
        str = "";
      }
    }
    Log.i("NewEntranceViewItemClick", "onItemClick pos:" + paramInt1 + " feed:" + paramcc);
    if ((paramcc instanceof BaseFinderFeed))
    {
      localObject1 = aw.Gjk;
      if (aw.s((BaseFinderFeed)paramcc))
      {
        ce.a.a((ce)j.Dob, (BaseFinderFeed)paramcc, paramInt1, q.w.DwU, "0", null, null, null, 112);
        g(((BaseFinderFeed)paramcc).feedObject);
        long l;
        if (Util.isEqual(((BaseFinderFeed)paramcc).feedObject.getUserName(), z.bAW()))
        {
          paramString = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
          paramRecyclerView = (Context)this.AZo;
          l = ((BaseFinderFeed)paramcc).feedObject.getId();
          paramBundle = ((BaseFinderFeed)paramcc).feedObject.getObjectNonceId();
          paramArrayList = ((BaseFinderFeed)paramcc).feedObject.getLiveInfo();
          paramView = paramArrayList;
          if (paramArrayList == null) {
            paramView = new bip();
          }
          f.a.a(paramString, paramRecyclerView, l, paramBundle, paramView, null, null, null, null, null, ((BaseFinderFeed)paramcc).getSessionBuffer(), null, null, 7152);
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
          com.tencent.mm.plugin.finder.nearby.live.report.a.eFw();
          if (akhC) {
            break;
          }
          paramView = com.tencent.mm.plugin.finder.report.k.Fpu;
          com.tencent.mm.plugin.finder.report.k.a(this.Auc, paramcc);
          AppMethodBeat.o(370507);
          return;
          localObject1 = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
          label520:
          label549:
          label1322:
          if ((com.tencent.mm.plugin.finder.live.fluent.a.isEnable()) && (!com.tencent.mm.n.a.r((Context)this.AZo, false)) && (v.CGh.ekX()))
          {
            NearbyLivePreviewView localNearbyLivePreviewView = (NearbyLivePreviewView)paramView.findViewWithTag("nearby-live-preview-view-tag");
            Object localObject2 = paramView.findViewById(f.d.thumb_iv);
            localObject1 = ((BaseFinderFeed)paramcc).feedObject.getFeedObject().liveInfo;
            label495:
            boolean bool5;
            boolean bool1;
            boolean bool2;
            boolean bool3;
            if (localObject1 == null)
            {
              paramInt1 = 0;
              bool5 = com.tencent.mm.ae.d.ee(paramInt1, 256);
              if ((localNearbyLivePreviewView == null) || (!localNearbyLivePreviewView.isPlaying())) {
                break label901;
              }
              bool1 = true;
              localObject1 = ((BaseFinderFeed)paramcc).feedObject.getLiveInfo();
              if ((localObject1 == null) || (((bip)localObject1).liveStatus != 1)) {
                break label907;
              }
              bool2 = true;
              if ((localNearbyLivePreviewView == null) || (!localNearbyLivePreviewView.ELh)) {
                break label913;
              }
              bool3 = true;
              label565:
              if (localNearbyLivePreviewView != null) {
                break label919;
              }
              localObject1 = null;
              label573:
              if (localObject1 == null) {
                break label965;
              }
            }
            label965:
            for (boolean bool4 = true;; bool4 = false)
            {
              Log.i("NewEntranceViewItemClick", "startSwitchOutFromSquare animation for feed:" + com.tencent.mm.ae.d.hF(paramcc.bZA()) + " liveStatusOpen:" + bool2 + " isPlaying:" + bool1 + " isAudioMode" + bool5 + " isFirstFrameRendered:" + bool3 + " isSurfaceTextureAvailable:" + bool4);
              if ((!bool1) || (!bool3) || (bool5) || (!bool2) || (!bool4)) {
                break label971;
              }
              Log.w("NewEntranceViewItemClick", "startSwitchOutFromSquare video animation for feed:" + com.tencent.mm.ae.d.hF(paramcc.bZA()) + " liveView:" + localNearbyLivePreviewView);
              l = ((BaseFinderFeed)paramcc).feedObject.getId();
              paramRecyclerView = h.a.CCE;
              localObject1 = localNearbyLivePreviewView.getRenderView().getVideoView();
              s.s(localObject1, "liveView.renderView.videoView");
              paramRecyclerView = new com.tencent.mm.plugin.finder.live.fluent.f(paramRecyclerView, false, l, paramView, (TextureView)localObject1, localNearbyLivePreviewView.eFj(), localNearbyLivePreviewView.getVideoWidth(), localNearbyLivePreviewView.getVideoHeight(), localNearbyLivePreviewView.getVideoRatioWH(), g(paramView.getWidth(), paramView.getHeight(), localNearbyLivePreviewView.getVideoRatioWH()));
              paramRecyclerView.mUN = paramView.findViewById(e.e.live_player_container);
              localObject1 = g.CCu;
              g.a((Context)this.AZo, (h)paramRecyclerView).aX((kotlin.g.a.a)new b(this, paramInt2, paramcc, paramArrayList, paramView, str, paramString, paramInt3, paramBundle));
              break;
              paramInt1 = (int)((bip)localObject1).ZFH;
              break label495;
              bool1 = false;
              break label520;
              bool2 = false;
              break label549;
              bool3 = false;
              break label565;
              localObject1 = localNearbyLivePreviewView.getRenderView();
              if (localObject1 == null)
              {
                localObject1 = null;
                break label573;
              }
              localObject1 = ((com.tencent.mm.plugin.finder.video.d)localObject1).getVideoView();
              if (localObject1 == null)
              {
                localObject1 = null;
                break label573;
              }
              localObject1 = ((TextureView)localObject1).getSurfaceTexture();
              break label573;
            }
            label971:
            if ((bool2) && (localObject2 != null))
            {
              l = ((BaseFinderFeed)paramcc).feedObject.getId();
              localObject1 = ((BaseFinderFeed)paramcc).feedObject.getFeedObject().liveInfo;
              if ((localObject1 != null) && (((bip)localObject1).ZSl == 1))
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label1097;
                }
                localObject1 = "";
              }
              int i;
              float f;
              h.a locala;
              for (;;)
              {
                paramInt1 = ((View)localObject2).getWidth();
                i = ((View)localObject2).getHeight();
                f = 1.0F * paramInt1 / i;
                locala = h.a.CCE;
                localObject3 = ((View)localObject2).getParent();
                if (localObject3 != null) {
                  break label1133;
                }
                paramcc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(370507);
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
              label1133:
              Object localObject3 = (ViewGroup)localObject3;
              if (localObject1 == null)
              {
                localObject1 = "";
                label1150:
                paramRecyclerView = new com.tencent.mm.plugin.finder.live.fluent.c(locala, l, paramRecyclerView, (ViewGroup)localObject3, (View)localObject2, paramInt1, i, f, (String)localObject1);
                localObject1 = g.CCu;
                localObject1 = g.a((Context)this.AZo, (h)paramRecyclerView);
                localObject2 = new StringBuilder("startSwitchOutFromSquare image animation for feed:").append(com.tencent.mm.ae.d.hF(paramcc.bZA())).append(" liveView:").append(localNearbyLivePreviewView).append(" maskViewRes[").append(paramInt1).append(", ").append(i).append("] isFirstFrameRendered:");
                if (localNearbyLivePreviewView != null) {
                  break label1322;
                }
              }
              for (paramRecyclerView = null;; paramRecyclerView = Boolean.valueOf(localNearbyLivePreviewView.ELh))
              {
                Log.w("NewEntranceViewItemClick", paramRecyclerView);
                ((com.tencent.mm.plugin.finder.live.fluent.k)localObject1).aX((kotlin.g.a.a)new c(this, paramInt2, paramcc, paramArrayList, paramView, str, paramString, paramInt3, paramBundle));
                break;
                break label1150;
              }
            }
            label1097:
            Log.w("NewEntranceViewItemClick", "startSwitchOutFromSquare no animation for feed:" + com.tencent.mm.ae.d.hF(paramcc.bZA()) + " liveView:" + localNearbyLivePreviewView);
          }
          label901:
          label907:
          label913:
          label919:
          a(this, paramInt2, paramcc, paramArrayList, paramView, str, paramString, paramInt3, paramBundle);
        }
      }
    }
    if ((paramcc instanceof au))
    {
      this.EJz = ((au)paramcc).position;
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
      paramArrayList.mc(paramString);
      paramArrayList.md("");
      paramArrayList.me("");
      paramArrayList.mf("all_my_follow");
      paramArrayList.mg("");
      paramcc = ah.aiuX;
      paramArrayList.bMH();
    }
    AppMethodBeat.o(370507);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/NewEntranceViewItemClick$Companion;", "", "()V", "TAG", "", "skipReport", "", "getSkipReport", "()Z", "setSkipReport", "(Z)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama, int paramInt1, cc paramcc, ArrayList<cc> paramArrayList, View paramView, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama, int paramInt1, cc paramcc, ArrayList<cc> paramArrayList, View paramView, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.a
 * JD-Core Version:    0.7.0.1
 */