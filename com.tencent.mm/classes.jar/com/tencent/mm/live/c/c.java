package com.tencent.mm.live.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.r.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.ui.LiveUID;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "liveOverTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "title", "plugin-logic_release"})
public final class c
  extends a
  implements i
{
  private final String TAG;
  private final Button jbb;
  private final TextView kCA;
  private final TextView kCB;
  private final TextView kCC;
  private final LinearLayout kCD;
  private final LinearLayout kCE;
  private final LinearLayout kCF;
  public final LinearLayout kCG;
  public final LinearLayout kCH;
  private final RelativeLayout kCI;
  private boolean kCJ;
  private boolean kCK;
  private final b kCL;
  private final ImageView kCv;
  private final TextView kCw;
  private final TextView kCx;
  private final TextView kCy;
  private final TextView kCz;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(198636);
    this.kCL = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(b.e.live_after_back_btn);
    p.j(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.kCv = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_title);
    p.j(paramb, "root.findViewById(R.id.live_after_title)");
    this.kCw = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_over_tv);
    p.j(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.kCx = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_visitor);
    p.j(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.kCy = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_visitor_count);
    p.j(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.kCz = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_comment_count);
    p.j(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.kCA = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_like_count);
    p.j(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.kCB = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_duration_tv);
    p.j(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.kCC = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_info_visitor_group);
    p.j(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.kCD = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_info_comment_group);
    p.j(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.kCE = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_info_like_group);
    p.j(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.kCF = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_replay_group);
    p.j(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.kCG = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_replay_switch_group);
    p.j(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.kCH = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_ui_root_group);
    p.j(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.kCI = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(b.e.live_after_replay_btn);
    p.j(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.jbb = ((Button)paramb);
    this.kCH.setVisibility(8);
    this.kCG.setVisibility(8);
    paramb = this.kCv;
    Context localContext = paramRelativeLayout.getContext();
    p.j(localContext, "root.context");
    paramb.setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_back), -1));
    if (this.kCL.getLiveRole() == 0)
    {
      paramb = this.kCy;
      localContext = paramRelativeLayout.getContext();
      p.j(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(b.h.live_after_visitor_without_arrow));
    }
    for (;;)
    {
      this.kCE.setOnClickListener((View.OnClickListener)c.2.kCN);
      this.kCF.setOnClickListener((View.OnClickListener)c.3.kCO);
      this.kCv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(197592);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.b.a(c.b(this.kCP), b.c.kyW);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(197592);
        }
      });
      this.jbb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190243);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.b.a(c.b(this.kCP), b.c.kyW);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(190243);
        }
      });
      this.kCH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195334);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAfterPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(this.kCM.getContext(), LiveUID.class);
          ((Intent)localObject).putExtra("FROM_SENCE", 2);
          paramAnonymousView = this.kCM.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView = u.kwz;
          if (p.h(u.aOt(), z.bcZ())) {
            com.tencent.mm.live.d.d.aQB();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195334);
        }
      });
      AppMethodBeat.o(198636);
      return;
      paramb = this.kCy;
      localContext = paramRelativeLayout.getContext();
      p.j(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(b.h.live_after_visitor));
      this.kCD.setOnClickListener((View.OnClickListener)new c.1(paramRelativeLayout));
    }
  }
  
  private void Om(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(198607);
    p.k(paramString, "title");
    this.kCx.setText((CharSequence)paramString);
    paramString = this.kCw;
    Object localObject1 = this.kiF.getContext();
    Object localObject2 = u.kwz;
    paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject1, (CharSequence)u.aPe(), this.kCw.getTextSize()));
    paramString = this.kCz;
    localObject1 = u.kwz;
    paramString.setText((CharSequence)String.valueOf(u.aOr().SOs));
    paramString = this.kCA;
    localObject1 = u.kwz;
    paramString.setText((CharSequence)String.valueOf(u.aOr().TyC));
    paramString = this.kCB;
    localObject1 = u.kwz;
    paramString.setText((CharSequence)String.valueOf(u.aOr().TgX));
    paramString = u.kwz;
    boolean bool;
    if (u.aOr().ChC > 0)
    {
      paramString = u.kwz;
      if (u.aOr().end_time > 0)
      {
        paramString = u.kwz;
        i = u.aOr().end_time;
        paramString = u.kwz;
        int k = i - u.aOr().ChC;
        paramString = com.tencent.mm.live.b.r.kvH;
        if (k < 3600) {
          break label405;
        }
        bool = true;
        label214:
        localObject1 = r.a.a(k, ":", bool, false, false, 24);
        Log.i(this.TAG, "endTime:" + i + ", duration:" + k + ", formatDuration:" + (String)localObject1);
        paramString = this.kCC;
        localObject2 = af.aaBG;
        localObject2 = this.kiF.getContext().getString(b.h.live_after_duration);
        p.j(localObject2, "root.context.getString(R…ring.live_after_duration)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
        p.j(localObject1, "java.lang.String.format(format, *args)");
        paramString.setText((CharSequence)localObject1);
      }
    }
    else
    {
      paramString = u.kwz;
      paramString = u.aOr();
      if ((TextUtils.isEmpty((CharSequence)paramString.TyF)) || (!Util.isEqual(paramString.TyG, paramString.TyF))) {
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
      aPq();
      AppMethodBeat.o(198607);
      return;
      i = cm.bfF();
      break;
      bool = false;
      break label214;
    }
    label416:
    paramString = u.kwz;
    if (u.aOr().TyE)
    {
      aPq();
      AppMethodBeat.o(198607);
      return;
    }
    this.kCH.setVisibility(8);
    this.kCG.setVisibility(0);
    AppMethodBeat.o(198607);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(198596);
    p.k(paramLiveConfig, "config");
    if (paramLiveConfig.aJf() == LiveConfig.khY) {}
    for (boolean bool = true;; bool = false)
    {
      this.kCJ = bool;
      AppMethodBeat.o(198596);
      return;
    }
  }
  
  public final void aPq()
  {
    AppMethodBeat.i(198608);
    this.kCH.setVisibility(8);
    this.kCG.setVisibility(0);
    AppMethodBeat.o(198608);
  }
  
  public final void mount() {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(198616);
    if (this.kiF.getVisibility() == 0)
    {
      b.b.a(this.kCL, b.c.kyW);
      AppMethodBeat.o(198616);
      return true;
    }
    AppMethodBeat.o(198616);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(198630);
    if ((paramq instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.live.b.a.b)paramq).aOr();
        if (paramString != null)
        {
          paramString = paramString.TyK;
          if (paramString != null)
          {
            paramInt1 = (int)paramString.HnP;
            if (!com.tencent.mm.ae.d.dr(1, paramInt1)) {
              break label294;
            }
            paramString = this.kiF.getContext();
            p.j(paramString, "root.context");
            paramString = paramString.getResources().getString(b.h.live_after_cut_live);
            label84:
            p.j(paramString, "if (cutLive) root.contex…R.string.live_after_over)");
            Om(paramString);
            if ((!this.kCK) || (this.kCL.getLiveRole() != 1)) {
              break label373;
            }
            this.kCK = false;
            paramString = u.kwz;
            if (u.aOr().end_time <= 0) {
              break label323;
            }
            paramString = u.kwz;
          }
        }
        label294:
        label323:
        for (paramInt1 = u.aOr().end_time;; paramInt1 = cm.bfF())
        {
          paramString = u.kwz;
          paramInt2 = u.aOr().ChC;
          paramString = u.kwz;
          paramString = u.aOm();
          paramq = u.kwz;
          long l = u.aOr().klE;
          paramq = u.kwz;
          paramq = u.aOr().Srb;
          u localu = u.kwz;
          int i = u.aOr().SOs;
          localu = u.kwz;
          int j = u.aOM();
          localu = u.kwz;
          int k = u.aOr().TyC;
          localu = u.kwz;
          int m = u.aOr().TgX;
          localu = u.kwz;
          int n = u.aOO();
          localu = u.kwz;
          e.a(paramString, l, paramq, i, j, k, m, n, u.aOr().TyE, paramInt1 - paramInt2);
          AppMethodBeat.o(198630);
          return;
          paramInt1 = 0;
          break;
          paramString = this.kiF.getContext();
          p.j(paramString, "root.context");
          paramString = paramString.getResources().getString(b.h.live_after_over);
          break label84;
        }
      }
    }
    else if ((paramq instanceof com.tencent.mm.live.b.a.r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i(this.TAG, "open replay success");
        AppMethodBeat.o(198630);
        return;
      }
      Log.i(this.TAG, "open replay fail");
    }
    label373:
    AppMethodBeat.o(198630);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(198612);
    com.tencent.mm.kernel.c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3806, (i)this);
    AppMethodBeat.o(198612);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(198610);
    com.tencent.mm.kernel.c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3806, (i)this);
    AppMethodBeat.o(198610);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(198623);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (d.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198623);
      return;
      paramc = o.kvA;
      o.aOb();
      paramc = this.kiF.getContext();
      p.j(paramc, "root.context");
      paramc = paramc.getResources().getString(b.h.live_after_over);
      p.j(paramc, "root.context.resources.g…R.string.live_after_over)");
      Om(paramc);
      tU(0);
      paramc = u.kwz;
      paramc = u.aOt();
      paramBundle = com.tencent.mm.live.b.d.a.kyA;
      paramBundle = this.kiF.getContext();
      p.j(paramBundle, "root.context");
      a.a.b(paramc, paramBundle.getResources().getColor(com.tencent.mm.live.b.b.live_half_black_bg), (kotlin.g.a.b)new a(this));
      paramc = this.kiF.getContext();
      if (paramc == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(198623);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      AppMethodBeat.o(198623);
      return;
      this.kCK = true;
      tU(4);
    }
  }
  
  public final void unMount() {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Bitmap, x>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.c
 * JD-Core Version:    0.7.0.1
 */