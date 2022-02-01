package com.tencent.mm.plugin.finder.profile.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.forcenotify.e.a.a;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget;", "", "header", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroid/view/View;Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "finderLiveBookBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getFinderLiveBookBtn", "()Landroid/widget/TextView;", "finderLiveBookBtn$delegate", "Lkotlin/Lazy;", "finderLiveCount", "getFinderLiveCount", "finderLiveCount$delegate", "finderLiveDescView", "Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "getFinderLiveDescView", "()Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "finderLiveDescView$delegate", "finderLiveNoticeOpBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFinderLiveNoticeOpBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "finderLiveNoticeOpBtn$delegate", "finderLiveTimeView", "getFinderLiveTimeView", "finderLiveTimeView$delegate", "finderLiveView", "Landroid/widget/RelativeLayout;", "getFinderLiveView", "()Landroid/widget/RelativeLayout;", "finderLiveView$delegate", "finderNoticeActivityLayout", "Landroid/widget/LinearLayout;", "getFinderNoticeActivityLayout", "()Landroid/widget/LinearLayout;", "finderNoticeActivityLayout$delegate", "finderNoticeActivityLine", "getFinderNoticeActivityLine", "()Landroid/view/View;", "finderNoticeActivityLine$delegate", "finderNoticeMoreLayout", "getFinderNoticeMoreLayout", "finderNoticeMoreLayout$delegate", "localNoticeAction", "", "localNoticeInitStatus", "onMoreLiveListClick", "Lkotlin/Function0;", "", "getOnMoreLiveListClick", "()Lkotlin/jvm/functions/Function0;", "setOnMoreLiveListClick", "(Lkotlin/jvm/functions/Function0;)V", "checkLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "svrInfo", "checkReport21158", "username", "", "handleFinderLiveNoticeInfo", "source", "firstReceivedScene", "", "isSelf", "isSelfFlag", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "handleFirstBookEduTips", "initLiveWidget", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a FgU;
  private final j FgP;
  private final j FgQ;
  public kotlin.g.a.a<ah> FgV;
  private final j FgW;
  private final j FgX;
  private final j FgY;
  private final j FgZ;
  private final j Fha;
  private final j Fhb;
  private final j Fhc;
  public int Fhd;
  public int Fhe;
  private final AppCompatActivity activity;
  
  static
  {
    AppMethodBeat.i(349428);
    FgU = new a((byte)0);
    AppMethodBeat.o(349428);
  }
  
  public c(View paramView, AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(349292);
    this.activity = paramAppCompatActivity;
    this.FgP = kotlin.k.cm((kotlin.g.a.a)new g(paramView));
    this.FgW = kotlin.k.cm((kotlin.g.a.a)new d(paramView));
    this.FgX = kotlin.k.cm((kotlin.g.a.a)new f(paramView));
    this.FgY = kotlin.k.cm((kotlin.g.a.a)new b(paramView));
    this.FgZ = kotlin.k.cm((kotlin.g.a.a)new e(paramView));
    this.Fha = kotlin.k.cm((kotlin.g.a.a)new c(paramView));
    this.FgQ = kotlin.k.cm((kotlin.g.a.a)new h(paramView));
    this.Fhb = kotlin.k.cm((kotlin.g.a.a)new i(paramView));
    this.Fhc = kotlin.k.cm((kotlin.g.a.a)new j(paramView));
    this.Fhd = -1;
    this.Fhe = -1;
    AppMethodBeat.o(349292);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.api.m paramm, bkk parambkk, c paramc, View paramView)
  {
    AppMethodBeat.i(349358);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambkk);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    localObject1 = new Intent();
    paramView = com.tencent.mm.plugin.findersdk.a.m.Hce;
    localObject2 = com.tencent.mm.plugin.findersdk.a.m.frz();
    if (paramm == null) {
      paramm = "";
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra((String)localObject2, paramm);
      paramm = com.tencent.mm.plugin.findersdk.a.m.Hce;
      ((Intent)localObject1).putExtra(com.tencent.mm.plugin.findersdk.a.m.frA(), parambkk.toByteArray());
      paramm = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ax((Context)paramc.activity, (Intent)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349358);
      return;
      paramView = paramm.getUsername();
      paramm = paramView;
      if (paramView == null) {
        paramm = "";
      }
    }
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(349412);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = paramc.FgV;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349412);
  }
  
  private static final void a(c paramc, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(349390);
    kotlin.g.b.s.u(paramc, "this$0");
    if (params.jmw()) {
      params.a(4, paramc.activity.getResources().getColor(e.b.Red), (CharSequence)paramc.activity.getResources().getString(e.h.finder_live_notice_unreserve));
    }
    AppMethodBeat.o(349390);
  }
  
  private static final void a(c paramc, String paramString, bkk parambkk1, bkk parambkk2, int paramInt)
  {
    AppMethodBeat.i(349380);
    paramc.Fhd = parambkk2.status;
    Object localObject = (g)com.tencent.mm.kernel.h.ax(g.class);
    String str = parambkk2.hAR;
    kotlin.g.b.s.checkNotNull(str);
    kotlin.g.b.s.s(str, "liveNoticeInfo.noticeId!!");
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((g)localObject).a(paramString, str, paramInt, ((as)com.tencent.mm.ui.component.k.d(paramc.activity).q(as.class)).fou(), paramc.activity.getIntent().getStringExtra("key_promotion_token"));
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    if (((g)com.tencent.mm.kernel.h.ax(g.class)).Sv(paramString) == null) {
      ((g)com.tencent.mm.kernel.h.ax(g.class)).a(paramString, parambkk2);
    }
    for (;;)
    {
      a(parambkk1, paramc);
      AppMethodBeat.o(349380);
      return;
      paramString = ((g)com.tencent.mm.kernel.h.ax(g.class)).Sv(paramString);
      if (paramString != null) {
        paramString.status = parambkk2.status;
      }
    }
  }
  
  private static final void a(bkk parambkk, c paramc)
  {
    AppMethodBeat.i(349370);
    if (parambkk.status == 1)
    {
      paramc.eKI().setText((CharSequence)paramc.activity.getResources().getString(e.h.finder_create_live_notice_btn_book));
      paramc.eKI().setTextColor(paramc.activity.getResources().getColor(e.b.FG_0));
    }
    for (;;)
    {
      paramc.eKI().setTag(e.e.finder_accessibility_live_notice_status_tag, Integer.valueOf(parambkk.status));
      AppMethodBeat.o(349370);
      return;
      paramc.eKI().setText((CharSequence)paramc.activity.getResources().getString(e.h.finder_create_live_notice_btn_book_cancel));
      paramc.eKI().setTextColor(paramc.activity.getResources().getColor(e.b.FG_2));
    }
  }
  
  private static final void a(bkk parambkk, c paramc, String paramString, View paramView)
  {
    AppMethodBeat.i(349405);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambkk);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramString, "$username");
    if (parambkk.status == 1)
    {
      parambkk.status = 0;
      paramView = com.tencent.mm.plugin.forcenotify.e.a.HpI;
      com.tencent.mm.plugin.forcenotify.e.a.a((Context)paramc.activity, 2, (a.a)new k(paramc));
      localObject2 = new i();
      ((i)localObject2).n("source_type", Integer.valueOf(0));
      paramView = com.tencent.mm.kernel.h.ax(cf.class);
      kotlin.g.b.s.s(paramView, "service(IHellLiveVisitorReoprter::class.java)");
      cf localcf = (cf)paramView;
      q.cg localcg = q.cg.DFs;
      String str = q.n.Dtx.scene;
      if (parambkk == null)
      {
        paramView = "";
        cf.a.a(localcf, localcg, paramString, 0L, str, null, null, null, null, paramView, ((i)localObject2).toString(), 480);
        a(paramc, paramString, parambkk, parambkk, 1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349405);
      return;
      localObject1 = parambkk.YSR;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramView = "";
      break;
      paramView = new f((Context)paramc.activity, 1, true);
      paramView.Vtg = new c..ExternalSyntheticLambda4(paramc);
      paramView.GAC = new c..ExternalSyntheticLambda5(parambkk, paramString, paramc);
      paramView.dDn();
    }
  }
  
  private static final void a(bkk parambkk, String paramString, c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349396);
    kotlin.g.b.s.u(paramString, "$username");
    kotlin.g.b.s.u(paramc, "this$0");
    if (paramMenuItem.getItemId() == 4)
    {
      parambkk.status = 1;
      paramMenuItem = com.tencent.mm.kernel.h.ax(cf.class);
      kotlin.g.b.s.s(paramMenuItem, "service(IHellLiveVisitorReoprter::class.java)");
      cf localcf = (cf)paramMenuItem;
      q.cg localcg = q.cg.DFt;
      String str2 = q.n.Dtx.scene;
      String str1 = parambkk.YSR;
      paramMenuItem = str1;
      if (str1 == null) {
        paramMenuItem = "";
      }
      cf.a.a(localcf, localcg, paramString, 0L, str2, null, null, null, null, paramMenuItem, null, 1504);
      a(paramc, paramString, parambkk, parambkk, 2);
      aa.y((Context)paramc.activity, paramc.activity.getString(e.h.finder_cancel_succ), e.g.icons_filled_done);
    }
    AppMethodBeat.o(349396);
  }
  
  private static final boolean a(bkk parambkk, c paramc, View paramView)
  {
    AppMethodBeat.i(349346);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambkk);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    parambkk = ClipData.newPlainText((CharSequence)"Label", (CharSequence)parambkk.hAR);
    paramView = MMApplicationContext.getContext().getSystemService("clipboard");
    if (paramView == null)
    {
      parambkk = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(349346);
      throw parambkk;
    }
    ((ClipboardManager)paramView).setPrimaryClip(parambkk);
    aa.showTextToast((Context)paramc.activity, "已复制noticeId");
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(349346);
    return true;
  }
  
  private final FinderCollapsibleTextView eKG()
  {
    AppMethodBeat.i(349295);
    FinderCollapsibleTextView localFinderCollapsibleTextView = (FinderCollapsibleTextView)this.FgW.getValue();
    AppMethodBeat.o(349295);
    return localFinderCollapsibleTextView;
  }
  
  private final TextView eKI()
  {
    AppMethodBeat.i(349303);
    TextView localTextView = (TextView)this.FgY.getValue();
    AppMethodBeat.o(349303);
    return localTextView;
  }
  
  private final WeImageView eKJ()
  {
    AppMethodBeat.i(349312);
    WeImageView localWeImageView = (WeImageView)this.FgZ.getValue();
    AppMethodBeat.o(349312);
    return localWeImageView;
  }
  
  private final TextView eKK()
  {
    AppMethodBeat.i(349320);
    TextView localTextView = (TextView)this.Fha.getValue();
    AppMethodBeat.o(349320);
    return localTextView;
  }
  
  private final View eKL()
  {
    AppMethodBeat.i(349326);
    View localView = (View)this.Fhb.getValue();
    AppMethodBeat.o(349326);
    return localView;
  }
  
  private final RelativeLayout eKM()
  {
    AppMethodBeat.i(349336);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Fhc.getValue();
    AppMethodBeat.o(349336);
    return localRelativeLayout;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.finder.api.m paramm)
  {
    AppMethodBeat.i(349513);
    kotlin.g.b.s.u(paramString1, "source");
    kotlin.g.b.s.u(paramString2, "username");
    Log.i("Finder.HeaderLiveWidget", kotlin.g.b.s.X("[handleFinderLiveNoticeInfo] source:", paramString1));
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      AppMethodBeat.o(349513);
      return;
    }
    Object localObject;
    if (n.a((CharSequence)paramString1, (CharSequence)"oncreate", true))
    {
      localObject = ((g)com.tencent.mm.kernel.h.ax(g.class)).Sv(paramString2);
      if (localObject != null)
      {
        paramString1 = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
        paramString1 = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString2);
        if (paramString1 != null) {
          break label638;
        }
        paramString1 = null;
        if ((paramString1 == null) || (paramString1.startTime > ((bkk)localObject).startTime))
        {
          paramString1 = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
          paramString1 = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString2);
          if (paramString1 != null) {
            paramString1.FeE = ((bkk)localObject);
          }
        }
      }
    }
    paramString1 = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    paramString1 = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString2);
    bkk localbkk;
    label180:
    int i;
    if (paramString1 == null)
    {
      localbkk = null;
      if (localbkk == null) {
        break label873;
      }
      paramString1 = (CharSequence)localbkk.hAR;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label655;
      }
      i = 1;
      label210:
      if (i != 0) {
        break label873;
      }
      eKD().setVisibility(0);
      ((LinearLayout)this.FgQ.getValue()).setVisibility(0);
      paramString1 = av.GiL;
      if (av.bgV()) {
        eKD().setOnLongClickListener(new c..ExternalSyntheticLambda3(localbkk, this));
      }
      long l = localbkk.startTime;
      paramString1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      String str = com.tencent.mm.plugin.finder.utils.aw.a(l * 1000L, null, false, 6);
      eKH().setText((CharSequence)this.activity.getResources().getString(e.h.finder_create_live_notice_time_info, new Object[] { str }));
      paramString1 = localbkk.YSR;
      if (paramString1 != null) {
        break label661;
      }
      localObject = null;
      paramString1 = "";
      label342:
      if (localObject == null) {
        ((c)this).eKG().setVisibility(8);
      }
      localObject = eKD();
      if (localObject != null) {
        ((RelativeLayout)localObject).setTag(e.e.finder_accessibility_live_notice_time_tag, str);
      }
      localObject = eKD();
      if (localObject != null) {
        ((RelativeLayout)localObject).setTag(e.e.finder_accessibility_live_desc_tag, paramString1);
      }
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label802;
      }
      eKK().setVisibility(0);
      eKK().setText((CharSequence)this.activity.getResources().getString(e.h.finder_create_live_notice_count_info, new Object[] { String.valueOf(localbkk.ZTG) }));
      paramString1 = eKD();
      if (paramString1 != null) {
        paramString1.setTag(e.e.finder_accessibility_live_notice_count_tag, eKK().getText());
      }
      eKI().setVisibility(8);
      eKJ().setVisibility(0);
      eKJ().setOnClickListener(new c..ExternalSyntheticLambda0(paramm, localbkk, this));
      label514:
      eKM().setOnClickListener(new c..ExternalSyntheticLambda1(this));
      eKL().setVisibility(8);
      eKM().setVisibility(8);
      paramString1 = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
      paramString1 = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString2);
      if (paramString1 == null) {
        break label882;
      }
      paramString1 = paramString1.FeK;
      if (paramString1 == null) {
        break label882;
      }
      if (paramString1.ZTK <= 1) {
        break label862;
      }
      i = 1;
      label586:
      if (i == 0) {
        break label868;
      }
    }
    for (;;)
    {
      if (paramString1 == null) {
        break label882;
      }
      paramString1 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUV().bmg()).intValue() == 1)
      {
        eKL().setVisibility(0);
        eKM().setVisibility(0);
      }
      AppMethodBeat.o(349513);
      return;
      label638:
      paramString1 = paramString1.FeE;
      break;
      localbkk = paramString1.FeE;
      break label180;
      label655:
      i = 0;
      break label210;
      label661:
      if (((CharSequence)paramString1).length() > 0)
      {
        i = 1;
        label676:
        if (i == 0) {
          break label701;
        }
      }
      for (;;)
      {
        if (paramString1 != null) {
          break label706;
        }
        localObject = null;
        paramString1 = "";
        break;
        i = 0;
        break label676;
        label701:
        paramString1 = null;
      }
      label706:
      eKG().setTextColor(this.activity.getResources().getColor(e.b.FG_1));
      eKG().getContentTextView().setTextSize(0, com.tencent.mm.cd.a.br((Context)this.activity, e.c.FootnoteextSize));
      eKG().setVisibility(0);
      eKG().setLimitLine(1);
      localObject = eKG();
      kotlin.g.b.s.s(localObject, "finderLiveDescView");
      FinderCollapsibleTextView.a((FinderCollapsibleTextView)localObject, (CharSequence)paramString1, null, null, 6);
      localObject = ah.aiuX;
      break label342;
      label802:
      eKK().setVisibility(8);
      eKI().setVisibility(0);
      com.tencent.mm.ui.aw.a((Paint)eKI().getPaint(), 0.8F);
      a(localbkk, this);
      eKI().setOnClickListener(new c..ExternalSyntheticLambda2(localbkk, this, paramString2));
      break label514;
      label862:
      i = 0;
      break label586;
      label868:
      paramString1 = null;
    }
    label873:
    eKD().setVisibility(8);
    label882:
    AppMethodBeat.o(349513);
  }
  
  public final RelativeLayout eKD()
  {
    AppMethodBeat.i(349477);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.FgP.getValue();
    AppMethodBeat.o(349477);
    return localRelativeLayout;
  }
  
  public final TextView eKH()
  {
    AppMethodBeat.i(349484);
    TextView localTextView = (TextView)this.FgX.getValue();
    AppMethodBeat.o(349484);
    return localTextView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<FinderCollapsibleTextView>
  {
    d(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WeImageView>
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    h(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    j(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/widget/HeaderLiveWidget$handleFinderLiveNoticeInfo$7$1", "Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "onResult", "", "ok", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements a.a
  {
    k(c paramc) {}
    
    public final void onResult(boolean paramBoolean)
    {
      AppMethodBeat.i(349224);
      c.a(this.Fhf);
      AppMethodBeat.o(349224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.c
 * JD-Core Version:    0.7.0.1
 */