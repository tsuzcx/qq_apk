package com.tencent.mm.live.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.model.d.a.a;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.live.model.u;
import com.tencent.mm.live.ui.LiveUIC;
import com.tencent.mm.live.ui.LiveUID;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "liveOverTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "title", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
  implements com.tencent.mm.am.h
{
  private final String TAG;
  private final Button lDb;
  private final b nfT;
  private final ImageView nfU;
  private final TextView nfV;
  private final TextView nfW;
  private final TextView nfX;
  private final TextView nfY;
  private final TextView nfZ;
  private final TextView nga;
  private final TextView ngb;
  private final LinearLayout ngc;
  private final LinearLayout ngd;
  private final LinearLayout nge;
  public final LinearLayout ngf;
  public final LinearLayout ngg;
  private final RelativeLayout ngh;
  private boolean ngi;
  private boolean ngj;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(247027);
    this.nfT = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(b.e.live_after_back_btn);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.nfU = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_title);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_title)");
    this.nfV = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_over_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.nfW = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_visitor);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.nfX = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_visitor_count);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.nfY = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_comment_count);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.nfZ = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_like_count);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.nga = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_duration_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.ngb = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_info_visitor_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.ngc = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_info_comment_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.ngd = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_info_like_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.nge = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_replay_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.ngf = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_replay_switch_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.ngg = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_ui_root_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.ngh = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_replay_btn);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.lDb = ((Button)paramb);
    this.ngg.setVisibility(8);
    this.ngf.setVisibility(8);
    this.nfU.setImageDrawable(bb.e(paramRelativeLayout.getContext().getResources().getDrawable(b.g.icons_filled_back), -1));
    if (this.nfT.getLiveRole() == 0) {
      this.nfX.setText((CharSequence)paramRelativeLayout.getContext().getResources().getString(b.h.live_after_visitor_without_arrow));
    }
    for (;;)
    {
      this.ngd.setOnClickListener(c..ExternalSyntheticLambda5.INSTANCE);
      this.nge.setOnClickListener(c..ExternalSyntheticLambda4.INSTANCE);
      this.nfU.setOnClickListener(new c..ExternalSyntheticLambda2(this));
      this.lDb.setOnClickListener(new c..ExternalSyntheticLambda3(this));
      this.ngg.setOnClickListener(new c..ExternalSyntheticLambda0(paramRelativeLayout));
      AppMethodBeat.o(247027);
      return;
      this.nfX.setText((CharSequence)paramRelativeLayout.getContext().getResources().getString(b.h.live_after_visitor));
      this.ngc.setOnClickListener(new c..ExternalSyntheticLambda1(paramRelativeLayout));
    }
  }
  
  private void Gz(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(247040);
    kotlin.g.b.s.u(paramString, "title");
    this.nfW.setText((CharSequence)paramString);
    paramString = this.nfV;
    Object localObject1 = this.mJe.getContext();
    Object localObject2 = u.mZl;
    paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject1, (CharSequence)u.biR(), this.nfV.getTextSize()));
    paramString = this.nfY;
    localObject1 = u.mZl;
    paramString.setText((CharSequence)String.valueOf(u.bie().ZWw));
    paramString = this.nfZ;
    localObject1 = u.mZl;
    paramString.setText((CharSequence)String.valueOf(u.bie().aaNk));
    paramString = this.nga;
    localObject1 = u.mZl;
    paramString.setText((CharSequence)String.valueOf(u.bie().aaun));
    paramString = u.mZl;
    boolean bool;
    if (u.bie().HTK > 0)
    {
      paramString = u.mZl;
      if (u.bie().end_time > 0)
      {
        paramString = u.mZl;
        i = u.bie().end_time;
        paramString = u.mZl;
        int k = i - u.bie().HTK;
        paramString = com.tencent.mm.live.model.r.mZi;
        if (k < 3600) {
          break label405;
        }
        bool = true;
        label214:
        localObject1 = r.a.a(k, ":", bool, false, false, 24);
        Log.i(this.TAG, "endTime:" + i + ", duration:" + k + ", formatDuration:" + (String)localObject1);
        paramString = this.ngb;
        localObject2 = am.aixg;
        localObject2 = this.mJe.getContext().getString(b.h.live_after_duration);
        kotlin.g.b.s.s(localObject2, "root.context.getString(R…ring.live_after_duration)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
        paramString.setText((CharSequence)localObject1);
      }
    }
    else
    {
      paramString = u.mZl;
      paramString = u.bie();
      if ((TextUtils.isEmpty((CharSequence)paramString.aaNn)) || (!Util.isEqual(paramString.aaNo, paramString.aaNn))) {
        break label411;
      }
    }
    label405:
    label411:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label416;
      }
      bjc();
      AppMethodBeat.o(247040);
      return;
      i = cn.getSyncServerTimeSecond();
      break;
      bool = false;
      break label214;
    }
    label416:
    paramString = u.mZl;
    if (u.bie().aaNm)
    {
      bjc();
      AppMethodBeat.o(247040);
      return;
    }
    this.ngg.setVisibility(8);
    this.ngf.setVisibility(0);
    AppMethodBeat.o(247040);
  }
  
  private static final void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(247051);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRelativeLayout, "$root");
    paramView = new Intent(paramRelativeLayout.getContext(), LiveUIC.class);
    paramRelativeLayout = paramRelativeLayout.getContext();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramRelativeLayout, paramView.aYi(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "_init_$lambda-0", "(Landroid/widget/RelativeLayout;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramRelativeLayout.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramRelativeLayout, "com/tencent/mm/live/plugin/LiveAfterPlugin", "_init_$lambda-0", "(Landroid/widget/RelativeLayout;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247051);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(247076);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    b.b.a(paramc.nfT, b.c.ncl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247076);
  }
  
  private static final void b(RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(247095);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramRelativeLayout, "$root");
    paramView = new Intent(paramRelativeLayout.getContext(), LiveUID.class);
    paramView.putExtra("FROM_SENCE", 2);
    paramRelativeLayout = paramRelativeLayout.getContext();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramRelativeLayout, paramView.aYi(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "_init_$lambda-5", "(Landroid/widget/RelativeLayout;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramRelativeLayout.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramRelativeLayout, "com/tencent/mm/live/plugin/LiveAfterPlugin", "_init_$lambda-5", "(Landroid/widget/RelativeLayout;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramRelativeLayout = u.mZl;
    if (kotlin.g.b.s.p(u.big(), z.bAM())) {
      com.tencent.mm.live.c.d.bko();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247095);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(247085);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    b.b.a(paramc.nfT, b.c.ncl);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247085);
  }
  
  private static final void de(View paramView)
  {
    AppMethodBeat.i(247059);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247059);
  }
  
  private static final void df(View paramView)
  {
    AppMethodBeat.i(247067);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247067);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(247161);
    kotlin.g.b.s.u(paramLiveConfig, "config");
    if (paramLiveConfig.mIy == LiveConfig.mIu) {}
    for (boolean bool = true;; bool = false)
    {
      this.ngi = bool;
      AppMethodBeat.o(247161);
      return;
    }
  }
  
  public final void bjc()
  {
    AppMethodBeat.i(247168);
    this.ngg.setVisibility(8);
    this.ngf.setVisibility(0);
    AppMethodBeat.o(247168);
  }
  
  public final void mount() {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247211);
    if (this.mJe.getVisibility() == 0)
    {
      b.b.a(this.nfT, b.c.ncl);
      AppMethodBeat.o(247211);
      return true;
    }
    AppMethodBeat.o(247211);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(247246);
    if ((paramp instanceof com.tencent.mm.live.model.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.live.model.a.b)paramp).bie();
        if (paramString == null)
        {
          paramInt1 = 0;
          if (!com.tencent.mm.ae.d.ee(1, paramInt1)) {
            break label290;
          }
          paramString = this.mJe.getContext().getResources().getString(b.h.live_after_cut_live);
          label62:
          kotlin.g.b.s.s(paramString, "if (cutLive) root.contex…R.string.live_after_over)");
          Gz(paramString);
          if ((!this.ngj) || (this.nfT.getLiveRole() != 1)) {
            break label360;
          }
          this.ngj = false;
          paramString = u.mZl;
          if (u.bie().end_time <= 0) {
            break label310;
          }
          paramString = u.mZl;
        }
        label290:
        label310:
        for (paramInt1 = u.bie().end_time;; paramInt1 = cn.getSyncServerTimeSecond())
        {
          paramString = u.mZl;
          paramInt2 = u.bie().HTK;
          paramString = u.mZl;
          paramString = u.bhZ();
          paramp = u.mZl;
          long l = u.bie().mMJ;
          paramp = u.mZl;
          paramp = u.bie().Zqd;
          u localu = u.mZl;
          int i = u.bie().ZWw;
          localu = u.mZl;
          int j = u.biz();
          localu = u.mZl;
          int k = u.bie().aaNk;
          localu = u.mZl;
          int m = u.bie().aaun;
          localu = u.mZl;
          int n = u.biB();
          localu = u.mZl;
          e.a(paramString, l, paramp, i, j, k, m, n, u.bie().aaNm, paramInt1 - paramInt2);
          AppMethodBeat.o(247246);
          return;
          paramString = paramString.aaNs;
          if (paramString == null)
          {
            paramInt1 = 0;
            break;
          }
          paramInt1 = (int)paramString.NlD;
          break;
          paramString = this.mJe.getContext().getResources().getString(b.h.live_after_over);
          break label62;
        }
      }
    }
    else if ((paramp instanceof com.tencent.mm.live.model.a.r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i(this.TAG, "open replay success");
        AppMethodBeat.o(247246);
        return;
      }
      Log.i(this.TAG, "open replay fail");
    }
    label360:
    AppMethodBeat.o(247246);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(247195);
    com.tencent.mm.kernel.h.baD().mCm.b(3806, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247195);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247185);
    com.tencent.mm.kernel.h.baD().mCm.a(3806, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247185);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247224);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (c.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247224);
      return;
      paramc = o.mZb;
      o.bhM();
      paramc = this.mJe.getContext().getResources().getString(b.h.live_after_over);
      kotlin.g.b.s.s(paramc, "root.context.resources.g…R.string.live_after_over)");
      Gz(paramc);
      tO(0);
      paramc = u.mZl;
      paramc = u.big();
      paramBundle = com.tencent.mm.live.model.d.a.nbX;
      a.a.b(paramc, this.mJe.getContext().getResources().getColor(com.tencent.mm.live.b.b.live_half_black_bg), (kotlin.g.a.b)new c.b(this));
      paramc = this.mJe.getContext();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(247224);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      AppMethodBeat.o(247224);
      return;
      this.ngj = true;
      tO(4);
    }
  }
  
  public final void unMount() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.c
 * JD-Core Version:    0.7.0.1
 */