package com.tencent.mm.live.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.k.a;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "plugin-logic_release"})
public final class c
  extends a
  implements f
{
  private final String TAG;
  private final Button fPz;
  private final TextView gSA;
  private final TextView gSB;
  private final TextView gSC;
  private final TextView gSD;
  private final LinearLayout gSE;
  private final LinearLayout gSF;
  private final LinearLayout gSG;
  public final LinearLayout gSH;
  public final LinearLayout gSI;
  final RelativeLayout gSJ;
  private boolean gSK;
  private boolean gSL;
  final b gSM;
  private final ImageView gSx;
  private final TextView gSy;
  private final TextView gSz;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(212310);
    this.gSM = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(2131307498);
    p.g(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.gSx = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307548);
    p.g(paramb, "root.findViewById(R.id.live_after_title)");
    this.gSy = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307551);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.gSz = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307552);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.gSA = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307500);
    p.g(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.gSB = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307507);
    p.g(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.gSC = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307501);
    p.g(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.gSD = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307505);
    p.g(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.gSE = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307502);
    p.g(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.gSF = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307504);
    p.g(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.gSG = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307525);
    p.g(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.gSH = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307528);
    p.g(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.gSI = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307550);
    p.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.gSJ = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307521);
    p.g(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.fPz = ((Button)paramb);
    this.gSI.setVisibility(8);
    this.gSH.setVisibility(8);
    paramb = this.gSx;
    Context localContext = paramRelativeLayout.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131690353), -1));
    if (this.gSM.getLiveRole() == 0)
    {
      paramb = this.gSz;
      localContext = paramRelativeLayout.getContext();
      p.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131766567));
    }
    for (;;)
    {
      this.gSF.setOnClickListener((View.OnClickListener)c.2.gSO);
      this.gSG.setOnClickListener((View.OnClickListener)c.3.gSP);
      this.gSx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212297);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          b.b.a(this.gSQ.gSM, b.c.gRw);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212297);
        }
      });
      this.fPz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212298);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          b.b.a(this.gSQ.gSM, b.c.gRw);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212298);
        }
      });
      this.gSI.setOnClickListener((View.OnClickListener)new c.6(paramRelativeLayout));
      AppMethodBeat.o(212310);
      return;
      paramb = this.gSz;
      localContext = paramRelativeLayout.getContext();
      p.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131766566));
      this.gSE.setOnClickListener((View.OnClickListener)new c.1(paramRelativeLayout));
    }
  }
  
  private void aoC()
  {
    int j = 1;
    AppMethodBeat.i(212303);
    Object localObject1 = this.gSy;
    Object localObject2 = this.gGK.getContext();
    Object localObject3 = com.tencent.mm.live.b.g.gOr;
    ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject2, (CharSequence)com.tencent.mm.live.b.g.aog(), this.gSy.getTextSize()));
    localObject1 = this.gSA;
    localObject2 = com.tencent.mm.live.b.g.gOr;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.ans().GzV));
    localObject1 = this.gSB;
    localObject2 = com.tencent.mm.live.b.g.gOr;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.ans().GOE));
    localObject1 = this.gSC;
    localObject2 = com.tencent.mm.live.b.g.gOr;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.ans().GzX));
    localObject1 = com.tencent.mm.live.b.g.gOr;
    boolean bool;
    if (com.tencent.mm.live.b.g.ans().FHr > 0)
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      if (com.tencent.mm.live.b.g.ans().oxQ > 0)
      {
        localObject1 = com.tencent.mm.live.b.g.gOr;
        i = com.tencent.mm.live.b.g.ans().oxQ;
        localObject1 = com.tencent.mm.live.b.g.gOr;
        int k = i - com.tencent.mm.live.b.g.ans().FHr;
        localObject1 = com.tencent.mm.live.b.k.gPm;
        if (k < 3600) {
          break label403;
        }
        bool = true;
        label207:
        localObject2 = k.a.a(k, ":", bool, false, false, 24);
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "endTime:" + i + ", duration:" + k + ", formatDuration:" + (String)localObject2);
        localObject1 = this.gSD;
        localObject3 = d.g.b.ad.MLZ;
        localObject3 = this.gGK.getContext().getString(2131766553);
        p.g(localObject3, "root.context.getString(R…ring.live_after_duration)");
        localObject2 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject2 }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.live.b.g.gOr;
      localObject1 = com.tencent.mm.live.b.g.ans();
      if ((TextUtils.isEmpty((CharSequence)((buq)localObject1).GOI)) || (!bt.lQ(((buq)localObject1).GOJ, ((buq)localObject1).GOI))) {
        break label409;
      }
    }
    label403:
    label409:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label414;
      }
      aoD();
      AppMethodBeat.o(212303);
      return;
      i = cf.aCN();
      break;
      bool = false;
      break label207;
    }
    label414:
    localObject1 = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.ans().GOH)
    {
      aoD();
      AppMethodBeat.o(212303);
      return;
    }
    this.gSI.setVisibility(8);
    this.gSH.setVisibility(0);
    AppMethodBeat.o(212303);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212302);
    p.h(paramLiveConfig, "config");
    if (paramLiveConfig.akU() == LiveConfig.gGt) {}
    for (boolean bool = true;; bool = false)
    {
      this.gSK = bool;
      AppMethodBeat.o(212302);
      return;
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212308);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (d.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212308);
      return;
      paramc = i.gPh;
      i.aoq();
      aoC();
      nI(0);
      paramc = com.tencent.mm.live.b.g.gOr;
      paramc = com.tencent.mm.live.b.g.anu();
      paramBundle = com.tencent.mm.live.b.d.a.gRe;
      paramBundle = this.gGK.getContext();
      p.g(paramBundle, "root.context");
      a.a.a(paramc, paramBundle.getResources().getColor(2131101201), (d.g.a.b)new a(this));
      paramc = this.gGK.getContext();
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(212308);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      AppMethodBeat.o(212308);
      return;
      this.gSL = true;
      nI(4);
    }
  }
  
  public final void aoA() {}
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212307);
    if (this.gGK.getVisibility() == 0)
    {
      b.b.a(this.gSM, b.c.gRw);
      AppMethodBeat.o(212307);
      return true;
    }
    AppMethodBeat.o(212307);
    return false;
  }
  
  public final void aoD()
  {
    AppMethodBeat.i(212304);
    this.gSI.setVisibility(8);
    this.gSH.setVisibility(0);
    AppMethodBeat.o(212304);
  }
  
  public final void aoz() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212309);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aoC();
        if ((this.gSL) && (this.gSM.getLiveRole() == 1))
        {
          this.gSL = false;
          paramString = com.tencent.mm.live.b.g.gOr;
          if (com.tencent.mm.live.b.g.ans().oxQ > 0) {
            paramString = com.tencent.mm.live.b.g.gOr;
          }
          for (paramInt1 = com.tencent.mm.live.b.g.ans().oxQ;; paramInt1 = cf.aCN())
          {
            paramString = com.tencent.mm.live.b.g.gOr;
            paramInt2 = com.tencent.mm.live.b.g.ans().FHr;
            paramString = com.tencent.mm.live.b.g.gOr;
            paramString = com.tencent.mm.live.b.g.anm();
            paramn = com.tencent.mm.live.b.g.gOr;
            long l = com.tencent.mm.live.b.g.ans().Fsa;
            paramn = com.tencent.mm.live.b.g.gOr;
            paramn = com.tencent.mm.live.b.g.ans().Gbw;
            com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
            int i = com.tencent.mm.live.b.g.ans().GzV;
            localg = com.tencent.mm.live.b.g.gOr;
            int j = com.tencent.mm.live.b.g.anP();
            localg = com.tencent.mm.live.b.g.gOr;
            int k = com.tencent.mm.live.b.g.ans().GOE;
            localg = com.tencent.mm.live.b.g.gOr;
            int m = com.tencent.mm.live.b.g.ans().GzX;
            localg = com.tencent.mm.live.b.g.gOr;
            int n = com.tencent.mm.live.b.g.anR();
            localg = com.tencent.mm.live.b.g.gOr;
            e.a(paramString, l, paramn, i, j, k, m, n, com.tencent.mm.live.b.g.ans().GOH, paramInt1 - paramInt2);
            AppMethodBeat.o(212309);
            return;
          }
        }
      }
    }
    else if ((paramn instanceof r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "open replay success");
        AppMethodBeat.o(212309);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "open replay fail");
    }
    AppMethodBeat.o(212309);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(212306);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(3806, (f)this);
    AppMethodBeat.o(212306);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(212305);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(3806, (f)this);
    AppMethodBeat.o(212305);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.b<Bitmap, z>
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