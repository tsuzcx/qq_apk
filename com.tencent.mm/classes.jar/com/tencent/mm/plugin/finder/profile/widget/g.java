package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.view.d;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import com.tencent.mm.view.refreshLayout.b.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget;", "", "anchorFinderUsername", "", "context", "Landroid/content/Context;", "isSelf", "", "(Ljava/lang/String;Landroid/content/Context;Z)V", "adapter", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter;", "getAnchorFinderUsername", "()Ljava/lang/String;", "cgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice;", "getContext", "()Landroid/content/Context;", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "headInfoResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeListInfo;", "isAllReserved", "()Z", "noticeList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "noticeOrCancelAllTxv", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "rvTouchListener", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$CustomOnItemTouchListener;", "tailInfoResp", "titleTxv", "deleteFinderNotice", "", "liveNoticeInfo", "destroy", "doReserveInternal", "opType", "", "loadData", "fromHead", "noticeId", "lastNoticeStartTime", "notifyDataChanged", "removeNotice", "showList", "initData", "updateNoticeOrCancelText", "Companion", "CustomOnItemTouchListener", "RecyclerAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a Fhr;
  final String Azl;
  private WxRefreshLayout EMN;
  private TextView EOe;
  private TextView Fhs;
  private final List<bkk> Fht;
  private c Fhu;
  private com.tencent.mm.plugin.finder.cgi.u Fhv;
  private bkl Fhw;
  private bkl Fhx;
  private final g.b Fhy;
  final Context context;
  private final boolean hHq;
  private j lCH;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(349352);
    Fhr = new a((byte)0);
    AppMethodBeat.o(349352);
  }
  
  public g(String paramString, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(349235);
    this.Azl = paramString;
    this.context = paramContext;
    this.hHq = paramBoolean;
    this.Fht = ((List)new ArrayList());
    this.Fhy = new g.b(this);
    AppMethodBeat.o(349235);
  }
  
  private static final ah a(w paramw, g paramg, bkk parambkk, b.a parama)
  {
    AppMethodBeat.i(349309);
    kotlin.g.b.s.u(paramw, "$dialog");
    kotlin.g.b.s.u(paramg, "this$0");
    kotlin.g.b.s.u(parambkk, "$liveNoticeInfo");
    paramw.dismiss();
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      aa.db(paramg.context, ((MMActivity)paramg.context).getResources().getString(e.h.finder_live_list_anchor_cancel_dialog_tips_ok));
      paramw = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
      paramw = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramg.Azl);
      if (paramw != null)
      {
        paramw = paramw.FeK;
        if (paramw != null)
        {
          parama = paramw.ZTJ;
          if (parama != null) {
            kotlin.a.p.e((List)parama, (kotlin.g.a.b)new d(parambkk));
          }
          paramw.ZTK = paramw.ZTJ.size();
        }
      }
      paramg.Fht.remove(parambkk);
      paramg.cPy();
      parama = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
      paramg = parambkk.hAR;
      paramw = paramg;
      if (paramg == null) {
        paramw = "";
      }
      parama.Sw(paramw);
    }
    paramw = ah.aiuX;
    AppMethodBeat.o(349309);
    return paramw;
  }
  
  private static final ah a(boolean paramBoolean, g paramg, b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(349298);
    kotlin.g.b.s.u(paramg, "this$0");
    boolean bool1;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (paramBoolean)
      {
        localObject = (azt)parama.ott;
        if (localObject == null)
        {
          localObject = null;
          paramg.Fhw = ((bkl)localObject);
          parama = (azt)parama.ott;
          if (parama == null) {
            break label400;
          }
          parama = parama.live_notice_list_info;
          if (parama == null) {
            break label400;
          }
          localObject = parama.ZTJ;
          if (localObject == null) {
            break label394;
          }
          if (!paramBoolean) {
            break label302;
          }
          if (parama.ZTM != 1) {
            break label296;
          }
          bool1 = true;
          label103:
          paramg.Fht.addAll(0, (Collection)localObject);
          label119:
          int i = parama.ZTK;
          parama = paramg.EOe;
          bool2 = bool1;
          if (parama != null) {
            parama.setText((CharSequence)((MMActivity)paramg.context).getResources().getString(e.h.finder_profile_dialog_count, new Object[] { Integer.valueOf(i) }));
          }
        }
      }
    }
    label394:
    label400:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      paramg.eKR();
      paramg.cPy();
      if (paramBoolean) {
        if (bool2)
        {
          paramg = paramg.EMN;
          if (paramg != null) {
            paramg.Od(true);
          }
        }
      }
      for (;;)
      {
        Log.i("MoreLiveListWidget", "#loadData fromHead=" + paramBoolean + ", hasMore=" + bool2);
        paramg = ah.aiuX;
        AppMethodBeat.o(349298);
        return paramg;
        localObject = ((azt)localObject).live_notice_list_info;
        break;
        azt localazt = (azt)parama.ott;
        if (localazt == null) {}
        for (;;)
        {
          paramg.Fhx = ((bkl)localObject);
          break;
          localObject = localazt.live_notice_list_info;
        }
        label296:
        bool1 = false;
        break label103;
        label302:
        if (parama.BeA == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramg.Fht.addAll((Collection)localObject);
          break;
        }
        paramg = paramg.EMN;
        if (paramg != null)
        {
          paramg.jNx();
          continue;
          if (bool2)
          {
            paramg = paramg.EMN;
            if (paramg != null) {
              paramg.Oe(true);
            }
          }
          else
          {
            paramg = paramg.EMN;
            if (paramg != null) {
              paramg.jNy();
            }
          }
        }
      }
      bool1 = true;
      break label119;
    }
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(349277);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "this$0");
    if (paramg.eKQ()) {}
    for (int i = 4;; i = 3)
    {
      paramg.a(null, i);
      paramg.eKR();
      paramg.cPy();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349277);
      return;
    }
  }
  
  private static final void b(g paramg, View paramView)
  {
    AppMethodBeat.i(349285);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "this$0");
    paramg = paramg.lCH;
    if (paramg != null) {
      paramg.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349285);
  }
  
  private void cPy()
  {
    AppMethodBeat.i(349269);
    c localc = this.Fhu;
    if (localc != null) {
      localc.bZE.notifyChanged();
    }
    AppMethodBeat.o(349269);
  }
  
  private final boolean eKQ()
  {
    boolean bool2 = false;
    bkl localbkl = this.Fhw;
    boolean bool1 = bool2;
    if (localbkl != null)
    {
      bool1 = bool2;
      if (localbkl.ZTK == localbkl.ZTL) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void eKR()
  {
    AppMethodBeat.i(349251);
    TextView localTextView = this.Fhs;
    if (localTextView != null)
    {
      if (!this.hHq)
      {
        i = 0;
        localTextView.setVisibility(i);
      }
    }
    else
    {
      localTextView = this.Fhs;
      if (localTextView != null) {
        if (!eKQ()) {
          break label67;
        }
      }
    }
    label67:
    for (int i = e.h.finder_profile_dialog_notice_cancel_all;; i = e.h.finder_profile_dialog_notice_all)
    {
      localTextView.setText(i);
      AppMethodBeat.o(349251);
      return;
      i = 8;
      break;
    }
  }
  
  public final void a(bkk parambkk, int paramInt)
  {
    AppMethodBeat.i(349424);
    Object localObject3 = new i();
    ((i)localObject3).n("source_type", Integer.valueOf(1));
    Object localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
      kotlin.g.b.s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
      localObject2 = (com.tencent.mm.plugin.g)localObject1;
      localObject3 = this.Azl;
      if (parambkk == null) {
        localObject1 = "";
      }
      break;
    }
    for (;;)
    {
      Object localObject4 = k.aeZF;
      localObject1 = com.tencent.mm.plugin.g.a.a((com.tencent.mm.plugin.g)localObject2, (String)localObject3, (String)localObject1, paramInt, ((as)k.nq(this.context).q(as.class)).fou());
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
      if (parambkk == null) {
        break label828;
      }
      if (((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).Sv(this.Azl) != null) {
        break label797;
      }
      ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(this.Azl, parambkk);
      AppMethodBeat.o(349424);
      return;
      localObject1 = com.tencent.mm.kernel.h.ax(cf.class);
      kotlin.g.b.s.s(localObject1, "service(IHellLiveVisitorReoprter::class.java)");
      localObject4 = (cf)localObject1;
      q.cg localcg = q.cg.DFs;
      String str1 = this.Azl;
      String str2 = q.n.Dtx.scene;
      if (parambkk == null) {
        localObject1 = "";
      }
      for (;;)
      {
        cf.a.a((cf)localObject4, localcg, str1, 0L, str2, null, null, null, null, (String)localObject1, ((i)localObject3).toString(), 480);
        if (parambkk != null) {
          parambkk.status = 0;
        }
        localObject1 = this.Fhw;
        if (localObject1 == null) {
          break;
        }
        ((bkl)localObject1).ZTL += 1;
        if (((bkl)localObject1).ZTL <= ((bkl)localObject1).ZTK) {
          break;
        }
        ((bkl)localObject1).ZTL = ((bkl)localObject1).ZTK;
        break;
        localObject2 = parambkk.YSR;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject1 = com.tencent.mm.kernel.h.ax(cf.class);
      kotlin.g.b.s.s(localObject1, "service(IHellLiveVisitorReoprter::class.java)");
      localObject4 = (cf)localObject1;
      localcg = q.cg.DFt;
      str1 = this.Azl;
      str2 = q.n.Dtx.scene;
      if (parambkk == null) {
        localObject1 = "";
      }
      for (;;)
      {
        cf.a.a((cf)localObject4, localcg, str1, 0L, str2, null, null, null, null, (String)localObject1, ((i)localObject3).toString(), 480);
        if (parambkk != null) {
          parambkk.status = 1;
        }
        localObject1 = this.Fhw;
        if (localObject1 == null) {
          break;
        }
        ((bkl)localObject1).ZTL -= 1;
        if (((bkl)localObject1).ZTL >= 0) {
          break;
        }
        ((bkl)localObject1).ZTL = 0;
        break;
        localObject2 = parambkk.YSR;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject1 = com.tencent.mm.kernel.h.ax(cf.class);
      kotlin.g.b.s.s(localObject1, "service(IHellLiveVisitorReoprter::class.java)");
      localObject4 = (cf)localObject1;
      localcg = q.cg.DFs;
      str1 = this.Azl;
      str2 = q.n.Dtx.scene;
      if (parambkk == null) {
        localObject1 = "";
      }
      for (;;)
      {
        cf.a.a((cf)localObject4, localcg, str1, 0L, str2, null, null, null, null, (String)localObject1, ((i)localObject3).toString(), 480);
        localObject1 = this.Fht.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bkk)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((bkk)localObject2).status = 0;
          }
        }
        localObject2 = parambkk.YSR;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject1 = this.Fhw;
      if (localObject1 == null) {
        break;
      }
      ((bkl)localObject1).ZTL = ((bkl)localObject1).ZTK;
      break;
      localObject1 = com.tencent.mm.kernel.h.ax(cf.class);
      kotlin.g.b.s.s(localObject1, "service(IHellLiveVisitorReoprter::class.java)");
      localObject4 = (cf)localObject1;
      localcg = q.cg.DFt;
      str1 = this.Azl;
      str2 = q.n.Dtx.scene;
      if (parambkk == null) {
        localObject1 = "";
      }
      for (;;)
      {
        cf.a.a((cf)localObject4, localcg, str1, 0L, str2, null, null, null, null, (String)localObject1, ((i)localObject3).toString(), 480);
        localObject1 = this.Fht.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bkk)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((bkk)localObject2).status = 1;
          }
        }
        localObject2 = parambkk.YSR;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject1 = this.Fhw;
      if (localObject1 == null) {
        break;
      }
      ((bkl)localObject1).ZTL = 0;
      break;
      localObject1 = parambkk.hAR;
      if (localObject1 == null) {
        localObject1 = "";
      }
    }
    label797:
    Object localObject1 = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).Sv(this.Azl);
    if (localObject1 != null) {
      ((bkk)localObject1).status = parambkk.status;
    }
    label828:
    AppMethodBeat.o(349424);
  }
  
  public final void a(bkl parambkl)
  {
    AppMethodBeat.i(349399);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUV().bmg()).intValue() == 0)
    {
      Log.i("MoreLiveListWidget", "multi notice disable, return.");
      AppMethodBeat.o(349399);
      return;
    }
    this.Fhw = parambkl;
    this.Fhx = parambkl;
    localObject = this.lCH;
    if (localObject != null) {
      ((j)localObject).cyW();
    }
    localObject = this.Fhv;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.cgi.u)localObject).cancel();
    }
    this.Fht.clear();
    if (parambkl != null)
    {
      localObject = parambkl.ZTJ;
      if (localObject != null) {
        this.Fht.addAll((Collection)localObject);
      }
    }
    this.lCH = new j(this.context, 0, 0);
    localObject = this.lCH;
    if (localObject != null) {
      ((j)localObject).setHeight(d.e(this.context, 600.0F));
    }
    localObject = LayoutInflater.from(this.context).inflate(e.f.finder_profile_more_live_list_widget_ui, null);
    kotlin.g.b.s.s(localObject, "from(context)\n          …ive_list_widget_ui, null)");
    this.EOe = ((TextView)((View)localObject).findViewById(e.e.finder_live_notice_list_title));
    this.Fhs = ((TextView)((View)localObject).findViewById(e.e.finder_live_make_notice_all));
    TextView localTextView = this.Fhs;
    if (localTextView != null) {
      localTextView.setOnClickListener(new g..ExternalSyntheticLambda0(this));
    }
    eKR();
    if (parambkl != null)
    {
      int i = parambkl.ZTK;
      parambkl = this.EOe;
      if (parambkl != null) {
        parambkl.setText((CharSequence)this.context.getResources().getString(e.h.finder_profile_dialog_count, new Object[] { Integer.valueOf(i) }));
      }
    }
    ((View)localObject).findViewById(e.e.icon_btn_close).setOnClickListener(new g..ExternalSyntheticLambda1(this));
    this.mkw = ((RecyclerView)((View)localObject).findViewById(e.e.recyclerView));
    this.EMN = ((WxRefreshLayout)((View)localObject).findViewById(e.e.refreshLayout));
    this.Fhu = new c(this.Azl, this.hHq, this.context);
    parambkl = this.mkw;
    if (parambkl != null) {
      parambkl.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    parambkl = this.mkw;
    if (parambkl != null) {
      parambkl.setAdapter((RecyclerView.a)this.Fhu);
    }
    if (this.hHq)
    {
      parambkl = this.mkw;
      if (parambkl != null) {
        parambkl.a((RecyclerView.k)this.Fhy);
      }
    }
    parambkl = this.EMN;
    if (parambkl != null) {
      parambkl.a((c)new DemoHeader(this.context));
    }
    parambkl = this.EMN;
    if (parambkl != null) {
      parambkl.a((com.tencent.mm.view.refreshLayout.b.b)new DemoFooter(this.context));
    }
    parambkl = this.EMN;
    if (parambkl != null) {
      parambkl.setOnSimpleAction((com.tencent.mm.view.refreshLayout.d.b)new e(this));
    }
    parambkl = this.lCH;
    if (parambkl != null) {
      parambkl.F((View)localObject, 0, 0);
    }
    parambkl = this.lCH;
    if (parambkl != null) {
      parambkl.dDn();
    }
    if (this.Fht.isEmpty())
    {
      parambkl = this.EMN;
      if (parambkl != null) {
        parambkl.autoRefresh();
      }
    }
    AppMethodBeat.o(349399);
  }
  
  public final void azy(String paramString)
  {
    AppMethodBeat.i(349403);
    kotlin.g.b.s.u(paramString, "noticeId");
    Iterator localIterator = this.Fht.iterator();
    while (localIterator.hasNext()) {
      if (kotlin.g.b.s.p(((bkk)localIterator.next()).hAR, paramString)) {
        localIterator.remove();
      }
    }
    cPy();
    AppMethodBeat.o(349403);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter$ItemHolder;", "Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget;", "username", "", "isSelf", "", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget;Ljava/lang/String;ZLandroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "()Z", "getUsername", "()Ljava/lang/String;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<a>
  {
    private final Context context;
    private final boolean hHq;
    private final String username;
    
    public c(boolean paramBoolean, Context paramContext)
    {
      AppMethodBeat.i(349198);
      this.username = paramBoolean;
      this.hHq = paramContext;
      this.context = localObject;
      AppMethodBeat.o(349198);
    }
    
    private static final void a(c paramc, bkk parambkk, View paramView)
    {
      AppMethodBeat.i(349215);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramc);
      localb.cH(parambkk);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramc, "this$0");
      kotlin.g.b.s.u(parambkk, "$info");
      paramView = new Intent();
      localObject = m.Hce;
      paramView.putExtra(m.frz(), paramc.username);
      localObject = m.Hce;
      paramView.putExtra(m.frA(), parambkk.toByteArray());
      parambkk = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.c(paramc.context, paramView, 10011);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349215);
    }
    
    private static final void a(g paramg, bkk parambkk, View paramView)
    {
      AppMethodBeat.i(349207);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramg);
      localb.cH(parambkk);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramg, "this$0");
      kotlin.g.b.s.u(parambkk, "$info");
      g.a(paramg, parambkk);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349207);
    }
    
    private static final void a(g paramg, bkk parambkk, c paramc, View paramView)
    {
      AppMethodBeat.i(349222);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramg);
      localb.cH(parambkk);
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramg, "this$0");
      kotlin.g.b.s.u(parambkk, "$info");
      kotlin.g.b.s.u(paramc, "this$1");
      if (parambkk.status == 0) {}
      for (int i = 2;; i = 1)
      {
        paramg.a(parambkk, i);
        g.b(paramg);
        paramc.bZE.notifyChanged();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(349222);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(349252);
      int i = g.a(g.this).size();
      AppMethodBeat.o(349252);
      return i;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$RecyclerAdapter;Landroid/view/View;)V", "date", "Landroid/widget/TextView;", "getDate", "()Landroid/widget/TextView;", "desc", "getDesc", "moreIcon", "getMoreIcon", "()Landroid/view/View;", "noticeCount", "getNoticeCount", "parentLid", "getParentLid", "revocation", "getRevocation", "subscribeIcon", "getSubscribeIcon", "subscribeLayout", "getSubscribeLayout", "subscribeText", "getSubscribeText", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      extends RecyclerView.v
    {
      final View FhC;
      final TextView FhD;
      final TextView FhE;
      final View FhF;
      final View FhG;
      final TextView FhH;
      final View FhI;
      final View FhJ;
      final TextView pmf;
      
      public a()
      {
        super();
        AppMethodBeat.i(349248);
        this$1 = localObject.findViewById(e.e.parent_lid);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.parent_lid)");
        this.FhC = g.c.this;
        this$1 = localObject.findViewById(e.e.txv_date);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.txv_date)");
        this.FhD = ((TextView)g.c.this);
        this$1 = localObject.findViewById(e.e.txv_desc);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.txv_desc)");
        this.pmf = ((TextView)g.c.this);
        this$1 = localObject.findViewById(e.e.txv_notice_count);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.txv_notice_count)");
        this.FhE = ((TextView)g.c.this);
        this$1 = localObject.findViewById(e.e.icon_more);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.icon_more)");
        this.FhF = g.c.this;
        this$1 = localObject.findViewById(e.e.subscribe_layout);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.subscribe_layout)");
        this.FhG = g.c.this;
        this$1 = localObject.findViewById(e.e.tv_subscribe_status_text);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.…tv_subscribe_status_text)");
        this.FhH = ((TextView)g.c.this);
        this$1 = localObject.findViewById(e.e.icon_fill_done);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.icon_fill_done)");
        this.FhI = g.c.this;
        this$1 = localObject.findViewById(e.e.btn_anchor_revocation);
        kotlin.g.b.s.s(g.c.this, "itemView.findViewById(R.id.btn_anchor_revocation)");
        this.FhJ = g.c.this;
        AppMethodBeat.o(349248);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<bkk, Boolean>
  {
    d(bkk parambkk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/widget/MoreLiveListWidget$showList$5", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "onLoadMore", "", "onRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.view.refreshLayout.d.b
  {
    e(g paramg) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(349140);
      g localg = this.FhB;
      String str = this.FhB.Azl;
      bkk localbkk = (bkk)kotlin.a.p.oN(g.a(this.FhB));
      if (localbkk == null) {}
      for (int i = 0;; i = localbkk.startTime)
      {
        g.a(localg, false, str, i);
        AppMethodBeat.o(349140);
        return;
      }
    }
    
    public final void onRefresh()
    {
      AppMethodBeat.i(349136);
      g localg = this.FhB;
      String str = this.FhB.Azl;
      bkk localbkk = (bkk)kotlin.a.p.oL(g.a(this.FhB));
      if (localbkk == null) {}
      for (int i = 0;; i = localbkk.startTime)
      {
        g.a(localg, true, str, i);
        AppMethodBeat.o(349136);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.g
 * JD-Core Version:    0.7.0.1
 */