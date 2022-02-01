package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.r.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.e;
import com.tencent.mm.plugin.finder.live.report.s.k;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "infoGroup", "Landroid/widget/LinearLayout;", "likeCountTv", "Landroid/widget/TextView;", "likeGroup", "Landroid/view/View;", "likeTv", "liveDurationTv", "liveTask", "livingToFinish", "", "newFollowCountContainer", "newFollowCountTv", "newFollowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "newFollowTv", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "split1", "split2", "titleTv", "visitorCountTv", "visitorTv", "wecoinHotCountTv", "wecoinHotGroup", "wecoinHotGroupArrow", "wecoinHotTv", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLiveTaskInfo", "show", "afterAction", "Lkotlin/Function0;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateBg", "bgUrl", "updateBgByUsername", "updateFinishInfo", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "updateLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
public final class e
  extends d
  implements com.tencent.mm.an.i
{
  private final String TAG;
  private final TextView kCB;
  private final TextView kCC;
  private final RelativeLayout kCI;
  private final com.tencent.mm.live.c.b kCU;
  private final ImageView kCv;
  private final TextView kCy;
  private final TextView kCz;
  private final TextView kEc;
  private final View kEf;
  private final Button kEt;
  private final TextView titleTv;
  private final View ylf;
  private final TextView ylg;
  private final TextView ylh;
  private final WeImageView yli;
  private final View ylj;
  private final View ylk;
  private final TextView yll;
  private final TextView ylm;
  private final View yln;
  private final View ylo;
  private final TextView ylp;
  private final LinearLayout ylq;
  private boolean ylr;
  
  public e(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(287049);
    this.kCU = paramb;
    this.TAG = "Finder.LiveAnchorAfterPlugin";
    paramb = paramViewGroup.findViewById(b.f.live_after_over_tv);
    p.j(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.titleTv = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_duration_tv);
    p.j(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.kCC = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_visitor_count);
    p.j(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.kCz = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_visitor);
    p.j(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.kCy = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_like_count);
    p.j(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.kCB = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_like);
    p.j(paramb, "root.findViewById(R.id.live_after_like)");
    this.kEc = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_info_new_follow_group);
    p.j(paramb, "root.findViewById(R.id.l…er_info_new_follow_group)");
    this.ylf = paramb;
    paramb = paramViewGroup.findViewById(b.f.live_after_new_follow_count);
    p.j(paramb, "root.findViewById(R.id.l…e_after_new_follow_count)");
    this.ylg = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_new_follow);
    p.j(paramb, "root.findViewById(R.id.live_after_new_follow)");
    this.ylh = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_new_follow_icon);
    p.j(paramb, "root.findViewById(R.id.live_after_new_follow_icon)");
    this.yli = ((WeImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_info_like_group);
    p.j(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.kEf = paramb;
    paramb = paramViewGroup.findViewById(b.f.live_after_info_wecoin_hot_group);
    p.j(paramb, "root.findViewById(R.id.l…er_info_wecoin_hot_group)");
    this.ylj = paramb;
    paramb = paramViewGroup.findViewById(b.f.live_after_wecoin_hot_arrow);
    p.j(paramb, "root.findViewById(R.id.l…e_after_wecoin_hot_arrow)");
    this.ylk = paramb;
    paramb = paramViewGroup.findViewById(b.f.live_after_wecoin_hot);
    p.j(paramb, "root.findViewById(R.id.live_after_wecoin_hot)");
    this.yll = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_wecoin_hot_count);
    p.j(paramb, "root.findViewById(R.id.l…e_after_wecoin_hot_count)");
    this.ylm = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_split_1);
    p.j(paramb, "root.findViewById(R.id.live_after_split_1)");
    this.yln = paramb;
    paramb = paramViewGroup.findViewById(b.f.live_after_split_2);
    p.j(paramb, "root.findViewById(R.id.live_after_split_2)");
    this.ylo = paramb;
    paramb = paramViewGroup.findViewById(b.f.live_after_finish_btn);
    p.j(paramb, "root.findViewById(R.id.live_after_finish_btn)");
    this.kEt = ((Button)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_task_entrance);
    p.j(paramb, "root.findViewById(R.id.live_task_entrance)");
    this.ylp = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_ui_root_group);
    p.j(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.kCI = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_info_group);
    p.j(paramb, "root.findViewById(R.id.live_after_info_group)");
    this.ylq = ((LinearLayout)paramb);
    paramb = paramViewGroup.findViewById(b.f.back_icon);
    p.j(paramb, "root.findViewById(R.id.back_icon)");
    this.kCv = ((ImageView)paramb);
    this.kEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(285496);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.a(this.yls).statusChange(com.tencent.mm.live.c.b.c.kyW, null);
        if (e.a(this.yls).getLiveRole() == 1)
        {
          paramAnonymousView = k.yBj;
          k.a(s.e.yEQ, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285496);
      }
    });
    this.ylf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277492);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (Util.safeParseInt(e.b(this.yls).getText().toString()) > 0)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("PARAM_FINDER_LIVE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.yls.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
          localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
          localObject = paramViewGroup.getContext();
          p.j(localObject, "root.context");
          com.tencent.mm.plugin.finder.utils.a.ae((Context)localObject, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277492);
      }
    });
    this.ylj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265146);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yls.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfn = false;
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("KEY_LIVE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.yls.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
        paramAnonymousView.putExtra("KEY_OBJECT_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.yls.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk);
        paramAnonymousView.putExtra("KEY_OBJECT_NONCE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.yls.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).nonceId);
        paramAnonymousView.putExtra("TYPE_MEMBER_ONLINE", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)this.yls.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.SHu);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject = paramViewGroup.getContext();
        p.j(localObject, "root.context");
        com.tencent.mm.plugin.finder.utils.a.al((Context)localObject, paramAnonymousView);
        if (e.a(this.yls).getLiveRole() == 1)
        {
          paramAnonymousView = k.yBj;
          k.a(s.e.yEP, String.valueOf(s.k.yFG.action));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265146);
      }
    });
    paramb = this.titleTv;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(287049);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.topMargin += ax.getStatusBarHeight(MMApplicationContext.getContext());
    paramb = this.kEt;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(287049);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += ax.aB(MMApplicationContext.getContext());
    ar.a((Paint)this.titleTv.getPaint(), 0.8F);
    ar.a((Paint)this.kEt.getPaint(), 0.8F);
    this.kCv.setImageDrawable(au.o(paramViewGroup.getContext(), b.i.icons_filled_back, -1));
    this.kCv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221585);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.a(this.yls).statusChange(com.tencent.mm.live.c.b.c.kyW, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221585);
      }
    });
    AppMethodBeat.o(287049);
  }
  
  private final void dAq()
  {
    AppMethodBeat.i(287044);
    com.tencent.mm.plugin.finder.live.util.g localg = com.tencent.mm.plugin.finder.live.util.g.yPJ;
    com.tencent.mm.plugin.finder.live.util.g.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGE(), (View)this.kCI);
    AppMethodBeat.o(287044);
  }
  
  public final void N(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(287042);
    float f;
    if (!this.ylr)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.k(getBuContext())) {}
    }
    else
    {
      this.kiF.setAlpha(0.0F);
      tU(0);
      this.kCv.setVisibility(8);
      this.kEt.setVisibility(0);
      this.kiF.animate().alpha(1.0F).setDuration(300L).withEndAction((Runnable)new g(parama)).start();
      f = 4.0F;
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfH) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGP())) {
        break label329;
      }
      this.ylj.setVisibility(0);
      this.yln.setVisibility(0);
      label143:
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfg) {
        break label354;
      }
      this.kEf.setVisibility(0);
      this.ylo.setVisibility(0);
    }
    for (;;)
    {
      this.ylq.setWeightSum(f);
      if (this.kCU.getLiveRole() == 1)
      {
        parama = k.yBj;
        k.a(s.e.yEO, "");
      }
      parama = com.tencent.mm.plugin.finder.api.d.wZQ;
      if (!d.a.aAQ("Entrance_LiveComplete")) {
        break label379;
      }
      this.ylp.setVisibility(0);
      com.tencent.mm.plugin.report.service.h.IzE.a(22748, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Long.valueOf(cm.bfE()), z.bdh() });
      this.ylp.setOnClickListener((View.OnClickListener)new e.a(this));
      AppMethodBeat.o(287042);
      return;
      tU(0);
      this.kCv.setVisibility(0);
      this.kEt.setVisibility(8);
      parama.invoke();
      break;
      label329:
      this.ylj.setVisibility(8);
      this.yln.setVisibility(8);
      f = 3.0F;
      break label143;
      label354:
      this.kEf.setVisibility(8);
      this.ylo.setVisibility(8);
      f -= 1.0F;
    }
    label379:
    this.ylp.setVisibility(8);
    AppMethodBeat.o(287042);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.a parama)
  {
    AppMethodBeat.i(287040);
    p.k(parama, "info");
    this.ylq.setVisibility(0);
    Object localObject1 = this.kCC;
    Object localObject2 = new StringBuilder();
    Object localObject3 = this.kiF.getContext();
    p.j(localObject3, "root.context");
    localObject2 = ((StringBuilder)localObject2).append(((Context)localObject3).getResources().getString(b.j.finder_live_duration)).append(' ');
    localObject3 = r.kvH;
    ((TextView)localObject1).setText((CharSequence)r.a.a(parama.duration, ":", false, false, false, 28));
    localObject1 = this.kCz;
    localObject2 = aj.AGc;
    ((TextView)localObject1).setText((CharSequence)aj.Rh(parama.zes));
    localObject1 = this.kCB;
    localObject2 = aj.AGc;
    ((TextView)localObject1).setText((CharSequence)aj.Rh(parama.likeCount));
    localObject1 = this.ylg;
    localObject2 = aj.AGc;
    ((TextView)localObject1).setText((CharSequence)aj.Rh(parama.zet));
    localObject1 = this.ylm;
    localObject2 = aj.AGc;
    ((TextView)localObject1).setText((CharSequence)aj.Rg((int)parama.zeu));
    localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilj().aSr()).intValue() == 1)
    {
      if (parama.zeu != 0L) {
        break label267;
      }
      this.ylj.setOnClickListener(null);
      this.ylk.setVisibility(8);
    }
    while (parama.zet > 0)
    {
      this.yli.setVisibility(0);
      AppMethodBeat.o(287040);
      return;
      label267:
      this.ylk.setVisibility(0);
    }
    this.yli.setVisibility(8);
    AppMethodBeat.o(287040);
  }
  
  public final void dAp()
  {
    AppMethodBeat.i(287041);
    Object localObject = this.kCI;
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    ((RelativeLayout)localObject).setBackgroundColor(localContext.getResources().getColor(com.tencent.mm.plugin.finder.b.c.finder_live_half_black_bg));
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig != null)
    {
      localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject = d.a.aAK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      if (localObject == null) {
        break label109;
      }
    }
    label109:
    for (localObject = ((com.tencent.mm.plugin.finder.api.i)localObject).field_avatarUrl;; localObject = null)
    {
      if (Util.isNullOrNil((String)localObject)) {
        break label114;
      }
      dAq();
      AppMethodBeat.o(287041);
      return;
      localObject = null;
      break;
    }
    label114:
    Log.i(this.TAG, "update bg fail,contact is null!");
    localObject = com.tencent.mm.kernel.h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3736, (com.tencent.mm.an.i)this);
    localObject = ah.yhC;
    localObject = ah.getFinderLiveAssistant();
    if (localObject != null)
    {
      ((an)localObject).aBW(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      AppMethodBeat.o(287041);
      return;
    }
    AppMethodBeat.o(287041);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(287048);
    if (this.kCU.getLiveRole() == 1)
    {
      k localk = k.yBj;
      k.a(s.e.yEQ, "");
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(287048);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(287043);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    if ((paramq instanceof cr))
    {
      FinderContact localFinderContact = ((cr)paramq).dpc();
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("update bg,user page isOnlyFetchUserInfo:").append(((cr)paramq).xer).append(", local username:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig).append(",req username:").append(((cr)paramq).xcq).append("，contact username:");
      if (localFinderContact != null) {}
      for (paramString = localFinderContact.username;; paramString = null)
      {
        Log.i(str, paramString);
        if ((!((cr)paramq).xer) || (!p.h(((cr)paramq).xcq, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig))) {
          break;
        }
        paramString = com.tencent.mm.kernel.h.aHF();
        p.j(paramString, "MMKernel.network()");
        paramString.aGY().b(3736, (com.tencent.mm.an.i)this);
        if (localFinderContact == null) {
          break;
        }
        paramString = localFinderContact.headUrl;
        if (paramString == null) {
          break;
        }
        p.j(paramString, "it");
        dAq();
        AppMethodBeat.o(287043);
        return;
      }
    }
    AppMethodBeat.o(287043);
  }
  
  public final void statusChange(com.tencent.mm.live.c.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(287045);
    p.k(paramc, "status");
    switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(287045);
      return;
    }
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL");; bool = false)
    {
      this.ylr = bool;
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(287046);
    super.unMount();
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3736, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(287046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.e
 * JD-Core Version:    0.7.0.1
 */