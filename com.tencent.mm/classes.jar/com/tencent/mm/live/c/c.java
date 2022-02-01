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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.r;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.k.a;
import com.tencent.mm.live.d.d;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.ui.LiveUIC;
import com.tencent.mm.live.ui.LiveUID;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import d.g.b.z;
import d.v;
import d.y;
import java.util.Arrays;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "plugin-logic_release"})
public final class c
  extends a
  implements com.tencent.mm.ak.g
{
  private final String TAG;
  private final Button fwm;
  private final ImageView gyM;
  private final TextView gyN;
  private final TextView gyO;
  private final TextView gyP;
  private final TextView gyQ;
  private final TextView gyR;
  private final TextView gyS;
  private final LinearLayout gyT;
  private final LinearLayout gyU;
  private final LinearLayout gyV;
  public final LinearLayout gyW;
  public final LinearLayout gyX;
  final RelativeLayout gyY;
  private boolean gyZ;
  private boolean gza;
  final b gzb;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(190022);
    this.gzb = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(2131307498);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.gyM = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307548);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_title)");
    this.gyN = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307551);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.gyO = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307552);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.gyP = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307500);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.gyQ = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307507);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.gyR = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307501);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.gyS = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307505);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.gyT = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307502);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.gyU = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307504);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.gyV = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307525);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.gyW = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307528);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.gyX = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307550);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.gyY = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307521);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.fwm = ((Button)paramb);
    this.gyX.setVisibility(8);
    this.gyW.setVisibility(8);
    paramb = this.gyM;
    Context localContext = paramRelativeLayout.getContext();
    d.g.b.k.g(localContext, "root.context");
    paramb.setImageDrawable(am.e(localContext.getResources().getDrawable(2131690353), -1));
    if (this.gzb.getLiveRole() == 0)
    {
      paramb = this.gyO;
      localContext = paramRelativeLayout.getContext();
      d.g.b.k.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131766567));
    }
    for (;;)
    {
      this.gyU.setOnClickListener((View.OnClickListener)c.2.gzd);
      this.gyV.setOnClickListener((View.OnClickListener)c.3.gze);
      this.gyM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190009);
          b.b.a(this.gzf.gzb, b.c.gxL);
          AppMethodBeat.o(190009);
        }
      });
      this.fwm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190010);
          b.b.a(this.gzf.gzb, b.c.gxL);
          AppMethodBeat.o(190010);
        }
      });
      this.gyX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190011);
          Object localObject = new Intent(this.gzc.getContext(), LiveUID.class);
          ((Intent)localObject).putExtra("FROM_SENCE", 2);
          paramAnonymousView = this.gzc.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView = com.tencent.mm.live.b.g.guG;
          if (d.g.b.k.g(com.tencent.mm.live.b.g.akH(), u.axw())) {
            d.and();
          }
          AppMethodBeat.o(190011);
        }
      });
      AppMethodBeat.o(190022);
      return;
      paramb = this.gyO;
      localContext = paramRelativeLayout.getContext();
      d.g.b.k.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131766566));
      this.gyT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190006);
          Object localObject = new Intent(this.gzc.getContext(), LiveUIC.class);
          paramAnonymousView = this.gzc.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(190006);
        }
      });
    }
  }
  
  private void alP()
  {
    int j = 1;
    AppMethodBeat.i(190015);
    Object localObject1 = this.gyN;
    Object localObject2 = this.gnb.getContext();
    Object localObject3 = com.tencent.mm.live.b.g.guG;
    ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject2, (CharSequence)com.tencent.mm.live.b.g.alt(), this.gyN.getTextSize()));
    localObject1 = this.gyP;
    localObject2 = com.tencent.mm.live.b.g.guG;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.akF().EQE));
    localObject1 = this.gyQ;
    localObject2 = com.tencent.mm.live.b.g.guG;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.akF().Ffa));
    localObject1 = this.gyR;
    localObject2 = com.tencent.mm.live.b.g.guG;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.akF().EQG));
    localObject1 = com.tencent.mm.live.b.g.guG;
    boolean bool;
    if (com.tencent.mm.live.b.g.akF().EbF > 0)
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      if (com.tencent.mm.live.b.g.akF().nUv > 0)
      {
        localObject1 = com.tencent.mm.live.b.g.guG;
        i = com.tencent.mm.live.b.g.akF().nUv;
        localObject1 = com.tencent.mm.live.b.g.guG;
        int k = i - com.tencent.mm.live.b.g.akF().EbF;
        localObject1 = com.tencent.mm.live.b.k.gvB;
        if (k < 3600) {
          break label403;
        }
        bool = true;
        label207:
        localObject2 = k.a.a(k, ":", bool, false, false, 24);
        ac.i(this.TAG, "endTime:" + i + ", duration:" + k + ", formatDuration:" + (String)localObject2);
        localObject1 = this.gyS;
        localObject3 = z.KUT;
        localObject3 = this.gnb.getContext().getString(2131766553);
        d.g.b.k.g(localObject3, "root.context.getString(R…ring.live_after_duration)");
        localObject2 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject2 }, 1));
        d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.live.b.g.guG;
      localObject1 = com.tencent.mm.live.b.g.akF();
      if ((TextUtils.isEmpty((CharSequence)((bqd)localObject1).Ffe)) || (!bs.lr(((bqd)localObject1).Fff, ((bqd)localObject1).Ffe))) {
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
      alQ();
      AppMethodBeat.o(190015);
      return;
      i = ce.azK();
      break;
      bool = false;
      break label207;
    }
    label414:
    localObject1 = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akF().Ffd)
    {
      alQ();
      AppMethodBeat.o(190015);
      return;
    }
    this.gyX.setVisibility(8);
    this.gyW.setVisibility(0);
    AppMethodBeat.o(190015);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(190014);
    d.g.b.k.h(paramLiveConfig, "config");
    if (paramLiveConfig.aii() == LiveConfig.gmK) {}
    for (boolean bool = true;; bool = false)
    {
      this.gyZ = bool;
      AppMethodBeat.o(190014);
      return;
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190020);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (d.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190020);
      return;
      paramc = i.gvw;
      i.alD();
      alP();
      nj(0);
      paramc = com.tencent.mm.live.b.g.guG;
      paramc = com.tencent.mm.live.b.g.akH();
      paramBundle = com.tencent.mm.live.b.d.a.gxt;
      paramBundle = this.gnb.getContext();
      d.g.b.k.g(paramBundle, "root.context");
      a.a.a(paramc, paramBundle.getResources().getColor(2131101201), (d.g.a.b)new a(this));
      paramc = this.gnb.getContext();
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(190020);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      AppMethodBeat.o(190020);
      return;
      this.gza = true;
      nj(4);
    }
  }
  
  public final void alM() {}
  
  public final void alN() {}
  
  public final boolean alO()
  {
    AppMethodBeat.i(190019);
    if (this.gnb.getVisibility() == 0)
    {
      b.b.a(this.gzb, b.c.gxL);
      AppMethodBeat.o(190019);
      return true;
    }
    AppMethodBeat.o(190019);
    return false;
  }
  
  public final void alQ()
  {
    AppMethodBeat.i(190016);
    this.gyX.setVisibility(8);
    this.gyW.setVisibility(0);
    AppMethodBeat.o(190016);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190021);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        alP();
        if ((this.gza) && (this.gzb.getLiveRole() == 1))
        {
          this.gza = false;
          paramString = com.tencent.mm.live.b.g.guG;
          if (com.tencent.mm.live.b.g.akF().nUv > 0) {
            paramString = com.tencent.mm.live.b.g.guG;
          }
          for (paramInt1 = com.tencent.mm.live.b.g.akF().nUv;; paramInt1 = ce.azK())
          {
            paramString = com.tencent.mm.live.b.g.guG;
            paramInt2 = com.tencent.mm.live.b.g.akF().EbF;
            paramString = com.tencent.mm.live.b.g.guG;
            paramString = com.tencent.mm.live.b.g.akA();
            paramn = com.tencent.mm.live.b.g.guG;
            long l = com.tencent.mm.live.b.g.akF().DMV;
            paramn = com.tencent.mm.live.b.g.guG;
            paramn = com.tencent.mm.live.b.g.akF().Eud;
            com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
            int i = com.tencent.mm.live.b.g.akF().EQE;
            localg = com.tencent.mm.live.b.g.guG;
            int j = com.tencent.mm.live.b.g.alc();
            localg = com.tencent.mm.live.b.g.guG;
            int k = com.tencent.mm.live.b.g.akF().Ffa;
            localg = com.tencent.mm.live.b.g.guG;
            int m = com.tencent.mm.live.b.g.akF().EQG;
            localg = com.tencent.mm.live.b.g.guG;
            int n = com.tencent.mm.live.b.g.ale();
            localg = com.tencent.mm.live.b.g.guG;
            e.a(paramString, l, paramn, i, j, k, m, n, com.tencent.mm.live.b.g.akF().Ffd, paramInt1 - paramInt2);
            AppMethodBeat.o(190021);
            return;
          }
        }
      }
    }
    else if ((paramn instanceof r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i(this.TAG, "open replay success");
        AppMethodBeat.o(190021);
        return;
      }
      ac.i(this.TAG, "open replay fail");
    }
    AppMethodBeat.o(190021);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(190018);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(3806, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190018);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(190017);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().a(3806, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190017);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Bitmap, y>
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