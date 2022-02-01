package com.tencent.mm.plugin.finder.profile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.ai;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "context", "Landroid/app/Activity;", "header", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;)V", "getContext", "()Landroid/app/Activity;", "continueFlag", "", "isFirst", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "networkBack", "poiDrawer", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiDrawer;", "poiLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getPoiLayout", "()Landroid/widget/LinearLayout;", "poiLayout$delegate", "Lkotlin/Lazy;", "poiListIv", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getPoiListIv", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "poiListIv$delegate", "poiListView", "Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiListView;", "poiName", "Landroid/widget/TextView;", "getPoiName", "()Landroid/widget/TextView;", "poiName$delegate", "userName", "", "createPoiDrawer", "createPoiListView", "enableLoadMore", "", "enable", "handlePoiList", "infoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderPoiInfo;", "fromLocal", "handlePoiLoadMore", "incrementList", "handleProfilePoi", "snsPoiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "loadLocalData", "onBackPressed", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "reportProfilePoiAction", "eventCode", "finderUsername", "requestPoiSearch", "query", "queryTime", "", "requestUserPoi", "loadMore", "saveData", "setUserName", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RefreshLoadMoreLayout.b
{
  public static final a Fah;
  private d Fad;
  private final kotlin.j Fai;
  private final kotlin.j Faj;
  private final kotlin.j Fak;
  public FinderProfilePoiDrawer Fal;
  private boolean Fam;
  private int continueFlag;
  final Activity hHU;
  private boolean isFirst;
  private com.tencent.mm.bx.b lastBuffer;
  public String userName;
  
  static
  {
    AppMethodBeat.i(348320);
    Fah = new a((byte)0);
    AppMethodBeat.o(348320);
  }
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(348167);
    this.hHU = paramActivity;
    this.Fai = k.cm((kotlin.g.a.a)new d(paramView));
    this.Faj = k.cm((kotlin.g.a.a)new f(paramView));
    this.Fak = k.cm((kotlin.g.a.a)new e(paramView));
    this.continueFlag = -1;
    this.userName = "";
    this.isFirst = true;
    AppMethodBeat.o(348167);
  }
  
  private final void D(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(348228);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("poi_name", paramString1);
    localJSONObject.put("finderusername", paramString2);
    paramString1 = z.FrZ;
    paramString1 = localJSONObject.toString();
    s.s(paramString1, "kvJson.toString()");
    paramString2 = n.bV(paramString1, ",", ";");
    paramString1 = as.GSQ;
    paramString1 = as.a.hu((Context)this.hHU);
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = paramString1.fou())
    {
      z.b(paramInt, "channel_profile_poi", paramString2, paramString1);
      AppMethodBeat.o(348228);
      return;
    }
  }
  
  private static final ah a(c paramc, long paramLong, b.a parama)
  {
    AppMethodBeat.i(348304);
    s.u(paramc, "this$0");
    List localList;
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      d locald = paramc.Fad;
      if (locald != null)
      {
        localList = (List)((bsi)parama.ott).ZEJ;
        StringBuilder localStringBuilder = new StringBuilder("[onLoadSearch] list size=");
        if (localList != null) {
          break label249;
        }
        localObject = null;
        Log.i("Finder.FinderProfilePoiListView", localObject + " queryTime=" + paramLong + ", lastQueryTime=" + locald.Fax);
        if (paramLong > locald.Fax)
        {
          locald.Fax = paramLong;
          if (localList != null)
          {
            if (locald.Fas.isEmpty()) {
              locald.Fas.addAll((Collection)locald.Far);
            }
            locald.Far.clear();
            locald.Far.addAll((Collection)localList);
            locald.hp((List)locald.Far);
          }
        }
      }
      Log.i("Finder.UserPoiHandler", s.X("[requestPoiSearch] poi_list size=", Integer.valueOf(((bsi)parama.ott).ZEJ.size())));
    }
    for (;;)
    {
      if (paramc.continueFlag != 0) {
        paramc.te(true);
      }
      paramc = ah.aiuX;
      AppMethodBeat.o(348304);
      return paramc;
      label249:
      localObject = Integer.valueOf(localList.size());
      break;
      Log.i("Finder.UserPoiHandler", "[requestPoiSearch] errType=" + parama.errType + " errCode=" + parama.errCode + " errMsg=" + parama.errMsg);
    }
  }
  
  private static final ah a(c paramc, boolean paramBoolean, b.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(348289);
    s.u(paramc, "this$0");
    Object localObject1;
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Log.i("Finder.UserPoiHandler", s.X("[requestUserPoi] ", Integer.valueOf(((byp)parama.ott).ZEJ.size())));
      paramc.continueFlag = ((byp)parama.ott).BeA;
      paramc.lastBuffer = ((byp)parama.ott).ZEQ;
      if (paramBoolean)
      {
        localObject1 = ((byp)parama.ott).ZEJ;
        s.s(localObject1, "it.resp.poi_list");
        localObject1 = (List)localObject1;
        d locald = paramc.Fad;
        if (locald != null)
        {
          Object localObject2 = locald.BaP;
          if (localObject2 != null) {
            ((MMProcessBar)localObject2).jEO();
          }
          localObject2 = (Collection)localObject1;
          if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
            break label267;
          }
          i = 1;
          if (i == 0)
          {
            locald.Far.addAll((Collection)localObject1);
            d.a(locald, (List)locald.Far);
          }
        }
        if (paramc.continueFlag != 0)
        {
          bool = true;
          label210:
          paramc.te(bool);
        }
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramc = paramc.Fad;
        if (paramc != null)
        {
          paramc = paramc.getRlLayout();
          if (paramc != null) {
            paramc.aFW(((byp)parama.ott).ZEJ.size());
          }
        }
      }
      paramc = ah.aiuX;
      AppMethodBeat.o(348289);
      return paramc;
      label267:
      i = 0;
      break;
      bool = false;
      break label210;
      localObject1 = (List)((byp)parama.ott).ZEJ;
      if (paramc.continueFlag != 0) {}
      for (;;)
      {
        a(paramc, (List)localObject1, bool, false, 4);
        break;
        bool = false;
      }
      Log.i("Finder.UserPoiHandler", "[requestUserPoi] errType=" + parama.errType + " errCode=" + parama.errCode + " errMsg=" + parama.errMsg);
    }
  }
  
  private static final void a(c paramc, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(348243);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.u(paramf, "$info");
    paramView = ai.Ghs;
    paramView = (Context)paramc.hHU;
    paramf = ((fes)paramf.aqH).abEh;
    if (paramf == null)
    {
      paramf = null;
      ai.a(paramView, paramf);
      paramf = paramc.eIx().getText();
      if (paramf != null) {
        break label172;
      }
      paramf = "";
    }
    for (;;)
    {
      paramc.D(1, paramf, paramc.userName);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348243);
      return;
      paramf = paramf.abjy;
      break;
      label172:
      paramView = paramf.toString();
      paramf = paramView;
      if (paramView == null) {
        paramf = "";
      }
    }
  }
  
  private static final void a(c paramc, boolean paramBoolean, List paramList, View paramView)
  {
    AppMethodBeat.i(348269);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).fv(paramBoolean);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramList);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramc, "this$0");
    if (paramc.Fad == null)
    {
      paramView = paramc.userName;
      localObject1 = new d((Context)paramc.hHU);
      ((d)localObject1).userName = paramView;
      ((d)localObject1).Faw = paramc;
      ((d)localObject1).Fau = ((kotlin.g.a.b)new b(paramc));
      paramc.Fad = ((d)localObject1);
    }
    if (paramc.Fal == null)
    {
      paramView = FinderProfilePoiDrawer.Fac;
      localObject1 = (Context)paramc.hHU;
      Object localObject3 = paramc.hHU.getWindow();
      s.s(localObject3, "context.window");
      localObject2 = paramc.Fad;
      s.u(localObject1, "context");
      s.u(localObject3, "window");
      com.tencent.e.f.h.jXD();
      FinderProfilePoiDrawer localFinderProfilePoiDrawer = new FinderProfilePoiDrawer((Context)localObject1);
      localFinderProfilePoiDrawer.setPoiListView((d)localObject2);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      paramView = new b();
      RecyclerViewDrawer localRecyclerViewDrawer = (RecyclerViewDrawer)localFinderProfilePoiDrawer;
      s.u(localRecyclerViewDrawer, "drawer");
      Object localObject4 = localRecyclerViewDrawer.getContext();
      s.s(localObject4, "drawer.context");
      s.u(localObject4, "<set-?>");
      paramView.context = ((Context)localObject4);
      localObject4 = (FinderProfilePoiDrawer)localRecyclerViewDrawer;
      s.u(localObject4, "<set-?>");
      paramView.Faf = ((FinderProfilePoiDrawer)localObject4);
      localRecyclerViewDrawer.setSquaresBackgroundResource(e.d.finder_bottom_corner_shape);
      localRecyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
      localRecyclerViewDrawer.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)paramView);
      int i = bf.bi((Context)localObject1);
      localLayoutParams.bottomMargin = i;
      s.X("[initView] bottomMargin= ", Integer.valueOf(i));
      com.tencent.e.f.h.jXD();
      ((FrameLayout)((Window)localObject3).getDecorView()).addView((View)localFinderProfilePoiDrawer, (ViewGroup.LayoutParams)localLayoutParams);
      paramView.b((Context)localObject1, localFinderProfilePoiDrawer.getHeaderLayout());
      localObject3 = localFinderProfilePoiDrawer.getCenterLayout();
      s.u(localObject1, "context");
      s.u(localObject3, "rlLayout");
      s.u(localObject3, "<set-?>");
      paramView.ATx = ((RefreshLoadMoreLayout)localObject3);
      localObject3 = ((RefreshLoadMoreLayout)localObject3).getRecyclerView();
      s.u(localObject3, "<set-?>");
      paramView.mkw = ((RecyclerView)localObject3);
      if (localObject2 != null)
      {
        localObject3 = paramView.eIu();
        paramView = paramView.ATx;
        if (paramView != null)
        {
          s.u(localObject3, "header");
          s.u(paramView, "refreshLayout");
          ((d)localObject2).Fag = ((View)localObject3);
          paramView.setEnableRefresh(false);
          paramView.setEnableLoadMore(false);
          localObject3 = af.mU(((d)localObject2).context).inflate(e.f.hot_tab_load_more_footer, null);
          ((d)localObject2).BaP = ((MMProcessBar)((View)localObject3).findViewById(e.e.rl_loading_icon));
          s.s(localObject3, "footerLayout");
          paramView.setLoadMoreFooter((View)localObject3);
          paramView.setActionCallback((RefreshLoadMoreLayout.b)((d)localObject2).Faw);
          s.u(paramView, "<set-?>");
          ((d)localObject2).ATx = paramView;
          paramView = paramView.getRecyclerView();
          s.u(paramView, "<set-?>");
          ((d)localObject2).mkw = paramView;
          paramView = new d.c((d)localObject2);
          s.u(paramView, "<set-?>");
          ((d)localObject2).Fat = paramView;
          ((d)localObject2).getRecyclerView().setAdapter((RecyclerView.a)((d)localObject2).eIy());
          ((d)localObject2).getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
          ((d)localObject2).RD(0);
        }
      }
      else
      {
        b.c((Context)localObject1, localFinderProfilePoiDrawer.getLoadingLayout());
        if ((localObject1 instanceof FinderProfileUI)) {
          ((FinderProfileUI)localObject1).getLifecycle().addObserver((p)new FinderProfilePoiDrawer.Companion.createDrawerToAttachWindow.1(localFinderProfilePoiDrawer, (Context)localObject1));
        }
        paramc.Fal = localFinderProfilePoiDrawer;
      }
    }
    else
    {
      paramView = paramc.Fad;
      if (paramView != null)
      {
        s.u(paramList, "list");
        Log.i("Finder.FinderProfilePoiListView", s.X("[initPoiList] list size=", Integer.valueOf(paramList.size())));
        paramView.RE(paramList.size());
        paramView.Far.clear();
        paramView.Far.addAll((Collection)paramList);
        d.a(paramView, (List)paramView.Far);
      }
      paramView = paramc.Fal;
      if (paramView != null) {
        paramView.setTopPadding(paramList.size());
      }
      paramList = paramc.Fal;
      if (paramList != null) {
        RecyclerViewDrawer.a((RecyclerViewDrawer)paramList);
      }
      paramList = paramc.eIx().getText();
      if (paramList != null) {
        break label873;
      }
      paramList = "";
    }
    for (;;)
    {
      paramc.D(1, paramList, paramc.userName);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348269);
      return;
      s.bIx("rlLayout");
      paramView = null;
      break;
      label873:
      paramView = paramList.toString();
      paramList = paramView;
      if (paramView == null) {
        paramList = "";
      }
    }
  }
  
  private static final void a(String paramString1, String paramString2, c paramc, long paramLong)
  {
    AppMethodBeat.i(348310);
    s.u(paramc, "this$0");
    new al(paramString1, paramString2).bFJ().g(new c..ExternalSyntheticLambda2(paramc, paramLong));
    AppMethodBeat.o(348310);
  }
  
  private final LinearLayout eIw()
  {
    AppMethodBeat.i(348175);
    LinearLayout localLinearLayout = (LinearLayout)this.Fai.getValue();
    AppMethodBeat.o(348175);
    return localLinearLayout;
  }
  
  private final TextView eIx()
  {
    AppMethodBeat.i(348180);
    TextView localTextView = (TextView)this.Faj.getValue();
    AppMethodBeat.o(348180);
    return localTextView;
  }
  
  private void td(boolean paramBoolean)
  {
    AppMethodBeat.i(348211);
    if ((paramBoolean) && (this.continueFlag == 0))
    {
      Log.i("Finder.UserPoiHandler", "[requestUserPoi] no load more");
      Object localObject = this.Fad;
      if (localObject != null)
      {
        localObject = ((d)localObject).getRlLayout();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).aFW(0);
        }
      }
      localObject = this.Fad;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((d)localObject).getRlLayout())
      {
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).setEnableLoadMore(false);
        }
        AppMethodBeat.o(348211);
        return;
      }
    }
    new au(this.userName, this.lastBuffer).bFJ().g(new c..ExternalSyntheticLambda3(this, paramBoolean));
    AppMethodBeat.o(348211);
  }
  
  private void te(boolean paramBoolean)
  {
    AppMethodBeat.i(348217);
    Object localObject = this.Fad;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((d)localObject).getRlLayout())
    {
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setEnableLoadMore(paramBoolean);
      }
      AppMethodBeat.o(348217);
      return;
    }
  }
  
  public final void a(fes paramfes)
  {
    AppMethodBeat.i(348377);
    Object localObject1 = new ah.f();
    ((ah.f)localObject1).aqH = paramfes;
    Object localObject2;
    int i;
    if (((ah.f)localObject1).aqH == null)
    {
      paramfes = ai.Ghs;
      paramfes = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
      paramfes = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(this.userName);
      if (paramfes == null)
      {
        paramfes = null;
        paramfes = ai.hH((List)paramfes);
        localObject2 = (Collection)paramfes;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label118;
        }
      }
      label118:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label123;
        }
        AppMethodBeat.o(348377);
        return;
        paramfes = paramfes.FeI;
        if (paramfes == null)
        {
          paramfes = null;
          break;
        }
        paramfes = paramfes.aahg;
        break;
      }
      label123:
      ((ah.f)localObject1).aqH = ((bsg)paramfes.get(0)).aaae;
    }
    if (((ah.f)localObject1).aqH == null)
    {
      AppMethodBeat.o(348377);
      return;
    }
    if ((this.isFirst) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
    {
      this.isFirst = false;
      eIw().setVisibility(0);
      localObject2 = eIx();
      paramfes = ((fes)((ah.f)localObject1).aqH).abEh;
      if (paramfes == null)
      {
        paramfes = null;
        ((TextView)localObject2).setText((CharSequence)paramfes);
        eIw().setOnClickListener(new c..ExternalSyntheticLambda0(this, (ah.f)localObject1));
        paramfes = this.userName;
        if (paramfes != null)
        {
          if (((CharSequence)paramfes).length() != 0) {
            break label338;
          }
          i = 1;
          label260:
          if (i == 0) {
            com.tencent.mm.ae.d.B((kotlin.g.a.a)new c(paramfes, this));
          }
        }
        td(false);
        paramfes = eIx().getText();
        if (paramfes != null) {
          break label343;
        }
        paramfes = "";
      }
      for (;;)
      {
        D(0, paramfes, this.userName);
        AppMethodBeat.o(348377);
        return;
        paramfes = paramfes.abjy;
        if (paramfes == null)
        {
          paramfes = null;
          break;
        }
        paramfes = paramfes.IGU;
        break;
        label338:
        i = 0;
        break label260;
        label343:
        localObject1 = paramfes.toString();
        paramfes = (fes)localObject1;
        if (localObject1 == null) {
          paramfes = "";
        }
      }
    }
    eIw().setVisibility(8);
    AppMethodBeat.o(348377);
  }
  
  public final void a(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(348397);
    s.u(paramd, "reason");
    super.a(paramd);
    AppMethodBeat.o(348397);
  }
  
  public final void l(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(348385);
    Log.i("Finder.UserPoiHandler", "[requestPoiSearch] query=" + paramString1 + ", finderUsername=" + paramString2 + " queryTime=" + paramLong);
    te(false);
    FinderProfilePoiDrawer localFinderProfilePoiDrawer = this.Fal;
    if (localFinderProfilePoiDrawer != null) {
      localFinderProfilePoiDrawer.post(new c..ExternalSyntheticLambda4(paramString1, paramString2, this, paramLong));
    }
    AppMethodBeat.o(348385);
  }
  
  public final void qI(int paramInt)
  {
    AppMethodBeat.i(348390);
    td(true);
    super.qI(paramInt);
    AppMethodBeat.o(348390);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfilePoiHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/PoiBrief;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<eee, ah>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    d(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RoundCornerRelativeLayout>
  {
    e(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(List<? extends bsg> paramList, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.c
 * JD-Core Version:    0.7.0.1
 */