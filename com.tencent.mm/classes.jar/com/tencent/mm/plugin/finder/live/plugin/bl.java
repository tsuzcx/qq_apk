package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorEnableTxt", "assistantEnableTxt", "autoInputMsg", "curBoxObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "disableTxt", "enableTxt", "galaEnableTxt", "olyEnableTxt", "postContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "postHint", "Landroid/widget/TextView;", "canClearScreen", "", "checkComment", "", "initBoxInfo", "normalClick", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bl
  extends b
{
  private final View Dhg;
  private final TextView Dhh;
  private String Dhi;
  private final String TAG;
  private final y<bfv> adlS;
  private final String akfb;
  private final String akfc;
  private final String akfd;
  private final String akfe;
  private final String akff;
  private final String akfg;
  private final com.tencent.mm.live.b.b nfT;
  
  public bl(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355278);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveNewVisitorPostPlugin";
    this.Dhg = paramViewGroup.findViewById(p.e.BTS);
    this.Dhh = ((TextView)paramViewGroup.findViewById(p.e.BTP));
    this.Dhi = "";
    paramb = MMApplicationContext.getContext().getResources().getString(p.h.Cjz);
    kotlin.g.b.s.s(paramb, "getContext().resources.g….finder_live_comment_tip)");
    this.akfb = paramb;
    paramb = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_olympics_comment_hint);
    kotlin.g.b.s.s(paramb, "getContext().resources.g…ve_olympics_comment_hint)");
    this.akfc = paramb;
    paramb = MMApplicationContext.getContext().getResources().getString(p.h.Cgu);
    kotlin.g.b.s.s(paramb, "getContext().resources.g…r_assistant_comment_hint)");
    this.akfd = paramb;
    paramb = MMApplicationContext.getContext().getResources().getString(p.h.Cgr);
    kotlin.g.b.s.s(paramb, "getContext().resources.g…nder_anchor_comment_hint)");
    this.akfe = paramb;
    paramb = MMApplicationContext.getContext().getResources().getString(p.h.XMw);
    kotlin.g.b.s.s(paramb, "getContext().resources.g…finder_gala_comment_hint)");
    this.akff = paramb;
    paramb = MMApplicationContext.getContext().getResources().getString(p.h.Cub);
    kotlin.g.b.s.s(paramb, "getContext().resources.g…finder_post_disable_hint)");
    this.akfg = paramb;
    this.adlS = new bl..ExternalSyntheticLambda1(this);
    this.Dhg.setOnClickListener(new bl..ExternalSyntheticLambda0(this, paramViewGroup));
    if (!isLandscape())
    {
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(355278);
        throw paramViewGroup;
      }
      paramb = (ViewGroup.MarginLayoutParams)paramb;
      paramb.bottomMargin += bf.bk(paramViewGroup.getContext());
    }
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
    AppMethodBeat.o(355278);
  }
  
  private static final void a(bl parambl, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(355303);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambl);
    localb.cH(paramViewGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambl, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parambl.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
    {
      paramViewGroup = new Bundle();
      paramViewGroup.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
      paramViewGroup.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", parambl.Dhi);
      parambl.nfT.statusChange(b.c.ncO, paramViewGroup);
    }
    for (;;)
    {
      parambl.Dhi = "";
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355303);
      return;
      if ((!((e)parambl.business(e.class)).Ecr) || (!((e)parambl.business(e.class)).Ecs))
      {
        aa.makeText(paramViewGroup.getContext(), (CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Csj), 0).show();
      }
      else if (kotlin.g.b.s.p(parambl.Dhh.getText(), parambl.akfg))
      {
        aa.a(paramViewGroup.getContext(), MMApplicationContext.getContext().getResources().getString(p.h.finder_live_comment_anchor_disable), bl..ExternalSyntheticLambda2.INSTANCE);
      }
      else
      {
        paramViewGroup = new Bundle();
        paramViewGroup.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
        paramViewGroup.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", parambl.Dhi);
        parambl.nfT.statusChange(b.c.ncO, paramViewGroup);
      }
    }
  }
  
  private static final void a(bl parambl, bfv parambfv)
  {
    AppMethodBeat.i(371449);
    kotlin.g.b.s.u(parambl, "this$0");
    Object localObject = bq.akii;
    localObject = parambl.TAG;
    if (parambfv == null) {}
    for (parambfv = null;; parambfv = parambfv.id)
    {
      bq.rU((String)localObject, kotlin.g.b.s.X("curBoxObserver ", parambfv));
      parambl.epR();
      AppMethodBeat.o(371449);
      return;
    }
  }
  
  private static final void gn(View paramView)
  {
    AppMethodBeat.i(371450);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icon_outlined_close_comment);
      }
    }
    AppMethodBeat.o(371450);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void epR()
  {
    AppMethodBeat.i(355345);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
    {
      this.Dhh.setText((CharSequence)this.akff);
      AppMethodBeat.o(355345);
      return;
    }
    Object localObject = bj.GlQ;
    if (bj.y(getBuContext())) {
      this.Dhh.setText((CharSequence)this.akfc);
    }
    for (;;)
    {
      Log.i(this.TAG, "riskControlEnableComment:" + ((e)business(e.class)).Ecr + ",enableLiveRoomComment:" + ((e)business(e.class)).Ect + ",enableCustomerComment:" + ((e)business(e.class)).Ecs);
      AppMethodBeat.o(355345);
      return;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.n(getBuContext()))
      {
        this.Dhh.setText((CharSequence)this.akfe);
      }
      else
      {
        if ((((e)business(e.class)).Ecr) && (((e)business(e.class)).Ect) && (((e)business(e.class)).Ecs))
        {
          TextView localTextView = this.Dhh;
          if (((e)business(e.class)).DUe) {}
          for (localObject = (CharSequence)this.akfd;; localObject = (CharSequence)this.akfb)
          {
            localTextView.setText((CharSequence)localObject);
            break;
          }
        }
        this.Dhh.setText((CharSequence)this.akfg);
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355355);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label346:
    for (;;)
    {
      AppMethodBeat.o(355355);
      return;
      tO(8);
      AppMethodBeat.o(355355);
      return;
      epR();
      AppMethodBeat.o(355355);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
      AppMethodBeat.o(355355);
      return;
      if (paramBundle == null) {
        paramc = "";
      }
      for (;;)
      {
        this.Dhi = paramc;
        this.Dhg.performClick();
        AppMethodBeat.o(355355);
        return;
        paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG");
        paramc = paramBundle;
        if (paramBundle == null) {
          paramc = "";
        }
      }
      paramc = bq.akii;
      if (!bq.B(getBuContext()))
      {
        Log.i(this.TAG, "FINDER_LIVE_INIT_BOX_INFO no box room ");
        AppMethodBeat.o(355355);
        return;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.a((q)this, this.adlS);
      paramc = this.Dhg.getLayoutParams();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(355355);
        throw paramc;
      }
      paramc.width = ((int)this.mJe.getContext().getResources().getDimension(p.c.Edge_18_5A));
      paramc = this.mJe.getLayoutParams();
      if ((paramc instanceof ConstraintLayout.LayoutParams)) {}
      for (paramc = (ConstraintLayout.LayoutParams)paramc;; paramc = null)
      {
        if (paramc == null) {
          break label346;
        }
        paramc.blN = 0;
        this.Dhg.requestLayout();
        this.Dhh.setGravity(19);
        this.Dhh.setPadding((int)this.mJe.getContext().getResources().getDimension(p.c.Edge_2A), 0, 0, 0);
        break;
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355333);
    if (((d)h.ax(d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(355333);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(355333);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(371454);
    super.unMount();
    AppMethodBeat.o(371454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bl
 * JD-Core Version:    0.7.0.1
 */