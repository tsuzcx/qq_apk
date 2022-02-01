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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.k.a;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "liveOverTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "title", "plugin-logic_release"})
public final class c
  extends a
  implements f
{
  private final String TAG;
  private final Button fRF;
  private final ImageView gVf;
  private final TextView gVg;
  private final TextView gVh;
  private final TextView gVi;
  private final TextView gVj;
  private final TextView gVk;
  private final TextView gVl;
  private final TextView gVm;
  private final LinearLayout gVn;
  private final LinearLayout gVo;
  private final LinearLayout gVp;
  public final LinearLayout gVq;
  public final LinearLayout gVr;
  final RelativeLayout gVs;
  private boolean gVt;
  private boolean gVu;
  final b gVv;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(215930);
    this.gVv = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(2131307498);
    p.g(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.gVf = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307548);
    p.g(paramb, "root.findViewById(R.id.live_after_title)");
    this.gVg = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307520);
    p.g(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.gVh = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307551);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.gVi = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307552);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.gVj = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307500);
    p.g(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.gVk = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307507);
    p.g(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.gVl = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307501);
    p.g(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.gVm = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307505);
    p.g(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.gVn = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307502);
    p.g(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.gVo = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307504);
    p.g(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.gVp = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307525);
    p.g(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.gVq = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307528);
    p.g(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.gVr = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307550);
    p.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.gVs = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307521);
    p.g(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.fRF = ((Button)paramb);
    this.gVr.setVisibility(8);
    this.gVq.setVisibility(8);
    paramb = this.gVf;
    Context localContext = paramRelativeLayout.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131690353), -1));
    if (this.gVv.getLiveRole() == 0)
    {
      paramb = this.gVi;
      localContext = paramRelativeLayout.getContext();
      p.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131766567));
    }
    for (;;)
    {
      this.gVo.setOnClickListener((View.OnClickListener)c.2.gVx);
      this.gVp.setOnClickListener((View.OnClickListener)c.3.gVy);
      this.gVf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215917);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          b.b.a(this.gVz.gVv, b.c.gUe);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215917);
        }
      });
      this.fRF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215918);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          b.b.a(this.gVz.gVv, b.c.gUe);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215918);
        }
      });
      this.gVr.setOnClickListener((View.OnClickListener)new c.6(paramRelativeLayout));
      AppMethodBeat.o(215930);
      return;
      paramb = this.gVi;
      localContext = paramRelativeLayout.getContext();
      p.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131766566));
      this.gVn.setOnClickListener((View.OnClickListener)new c.1(paramRelativeLayout));
    }
  }
  
  private void yC(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(215923);
    p.h(paramString, "title");
    this.gVh.setText((CharSequence)paramString);
    paramString = this.gVg;
    Object localObject1 = this.gJt.getContext();
    Object localObject2 = com.tencent.mm.live.b.g.gQZ;
    paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject1, (CharSequence)com.tencent.mm.live.b.g.aov(), this.gVg.getTextSize()));
    paramString = this.gVj;
    localObject1 = com.tencent.mm.live.b.g.gQZ;
    paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.anH().GTv));
    paramString = this.gVk;
    localObject1 = com.tencent.mm.live.b.g.gQZ;
    paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.anH().Hie));
    paramString = this.gVl;
    localObject1 = com.tencent.mm.live.b.g.gQZ;
    paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.anH().GTx));
    paramString = com.tencent.mm.live.b.g.gQZ;
    boolean bool;
    if (com.tencent.mm.live.b.g.anH().FZN > 0)
    {
      paramString = com.tencent.mm.live.b.g.gQZ;
      if (com.tencent.mm.live.b.g.anH().oEs > 0)
      {
        paramString = com.tencent.mm.live.b.g.gQZ;
        i = com.tencent.mm.live.b.g.anH().oEs;
        paramString = com.tencent.mm.live.b.g.gQZ;
        int k = i - com.tencent.mm.live.b.g.anH().FZN;
        paramString = com.tencent.mm.live.b.k.gRU;
        if (k < 3600) {
          break label405;
        }
        bool = true;
        label214:
        localObject1 = k.a.a(k, ":", bool, false, false, 24);
        ae.i(this.TAG, "endTime:" + i + ", duration:" + k + ", formatDuration:" + (String)localObject1);
        paramString = this.gVm;
        localObject2 = ad.Njc;
        localObject2 = this.gJt.getContext().getString(2131766553);
        p.g(localObject2, "root.context.getString(R…ring.live_after_duration)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramString.setText((CharSequence)localObject1);
      }
    }
    else
    {
      paramString = com.tencent.mm.live.b.g.gQZ;
      paramString = com.tencent.mm.live.b.g.anH();
      if ((TextUtils.isEmpty((CharSequence)paramString.Hii)) || (!bu.lX(paramString.Hij, paramString.Hii))) {
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
      aoR();
      AppMethodBeat.o(215923);
      return;
      i = ch.aDd();
      break;
      bool = false;
      break label214;
    }
    label416:
    paramString = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anH().Hih)
    {
      aoR();
      AppMethodBeat.o(215923);
      return;
    }
    this.gVr.setVisibility(8);
    this.gVq.setVisibility(0);
    AppMethodBeat.o(215923);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215922);
    p.h(paramLiveConfig, "config");
    if (paramLiveConfig.alj() == LiveConfig.gJc) {}
    for (boolean bool = true;; bool = false)
    {
      this.gVt = bool;
      AppMethodBeat.o(215922);
      return;
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(215928);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (d.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215928);
      return;
      paramc = i.gRP;
      i.aoF();
      paramc = this.gJt.getContext();
      p.g(paramc, "root.context");
      paramc = paramc.getResources().getString(2131766555);
      p.g(paramc, "root.context.resources.g…R.string.live_after_over)");
      yC(paramc);
      nL(0);
      paramc = com.tencent.mm.live.b.g.gQZ;
      paramc = com.tencent.mm.live.b.g.anJ();
      paramBundle = com.tencent.mm.live.b.d.a.gTM;
      paramBundle = this.gJt.getContext();
      p.g(paramBundle, "root.context");
      a.a.a(paramc, paramBundle.getResources().getColor(2131101201), (d.g.a.b)new a(this));
      paramc = this.gJt.getContext();
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(215928);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      AppMethodBeat.o(215928);
      return;
      this.gVu = true;
      nL(4);
    }
  }
  
  public final void aoO() {}
  
  public final void aoP() {}
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(215927);
    if (this.gJt.getVisibility() == 0)
    {
      b.b.a(this.gVv, b.c.gUe);
      AppMethodBeat.o(215927);
      return true;
    }
    AppMethodBeat.o(215927);
    return false;
  }
  
  public final void aoR()
  {
    AppMethodBeat.i(215924);
    this.gVr.setVisibility(8);
    this.gVq.setVisibility(0);
    AppMethodBeat.o(215924);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215929);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.live.b.a.b)paramn).anH();
        if (paramString != null)
        {
          paramString = paramString.Hin;
          if (paramString != null)
          {
            paramInt1 = (int)paramString.xts;
            if (!com.tencent.mm.ac.c.cQ(1, paramInt1)) {
              break label293;
            }
            paramString = this.gJt.getContext();
            p.g(paramString, "root.context");
            paramString = paramString.getResources().getString(2131767239);
            label83:
            p.g(paramString, "title");
            yC(paramString);
            if ((!this.gVu) || (this.gVv.getLiveRole() != 1)) {
              break label371;
            }
            this.gVu = false;
            paramString = com.tencent.mm.live.b.g.gQZ;
            if (com.tencent.mm.live.b.g.anH().oEs <= 0) {
              break label321;
            }
            paramString = com.tencent.mm.live.b.g.gQZ;
          }
        }
        label293:
        label321:
        for (paramInt1 = com.tencent.mm.live.b.g.anH().oEs;; paramInt1 = ch.aDd())
        {
          paramString = com.tencent.mm.live.b.g.gQZ;
          paramInt2 = com.tencent.mm.live.b.g.anH().FZN;
          paramString = com.tencent.mm.live.b.g.gQZ;
          paramString = com.tencent.mm.live.b.g.anC();
          paramn = com.tencent.mm.live.b.g.gQZ;
          long l = com.tencent.mm.live.b.g.anH().FKy;
          paramn = com.tencent.mm.live.b.g.gQZ;
          paramn = com.tencent.mm.live.b.g.anH().Gud;
          com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
          int i = com.tencent.mm.live.b.g.anH().GTv;
          localg = com.tencent.mm.live.b.g.gQZ;
          int j = com.tencent.mm.live.b.g.aoe();
          localg = com.tencent.mm.live.b.g.gQZ;
          int k = com.tencent.mm.live.b.g.anH().Hie;
          localg = com.tencent.mm.live.b.g.gQZ;
          int m = com.tencent.mm.live.b.g.anH().GTx;
          localg = com.tencent.mm.live.b.g.gQZ;
          int n = com.tencent.mm.live.b.g.aog();
          localg = com.tencent.mm.live.b.g.gQZ;
          e.a(paramString, l, paramn, i, j, k, m, n, com.tencent.mm.live.b.g.anH().Hih, paramInt1 - paramInt2);
          AppMethodBeat.o(215929);
          return;
          paramInt1 = 0;
          break;
          paramString = this.gJt.getContext();
          p.g(paramString, "root.context");
          paramString = paramString.getResources().getString(2131766555);
          break label83;
        }
      }
    }
    else if ((paramn instanceof r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i(this.TAG, "open replay success");
        AppMethodBeat.o(215929);
        return;
      }
      ae.i(this.TAG, "open replay fail");
    }
    label371:
    AppMethodBeat.o(215929);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(215926);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(3806, (f)this);
    AppMethodBeat.o(215926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(215925);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(3806, (f)this);
    AppMethodBeat.o(215925);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.c
 * JD-Core Version:    0.7.0.1
 */