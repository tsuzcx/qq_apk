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
import com.tencent.mm.al.n;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.j.a;
import com.tencent.mm.live.d.d;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.ui.LiveUIC;
import com.tencent.mm.live.ui.LiveUID;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import d.g.b.z;
import d.v;
import d.y;
import java.util.Arrays;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "", "visitorCountTv", "visitorGroup", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "plugin-logic_release"})
public final class c
  extends a
  implements com.tencent.mm.al.g
{
  private final TextView IIh;
  private final TextView IIi;
  private final TextView IIj;
  private final TextView IIk;
  private final LinearLayout IIl;
  private final LinearLayout IIm;
  private final LinearLayout IIn;
  public final LinearLayout IIo;
  public final LinearLayout IIp;
  final RelativeLayout IIq;
  private boolean IIr;
  final b IIs;
  private final String TAG;
  private final Button fsF;
  private final ImageView oPR;
  private final TextView qrL;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(202821);
    this.IIs = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(2131307422);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.oPR = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307472);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_title)");
    this.IIh = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307476);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.IIi = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307424);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.IIj = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307431);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.qrL = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307425);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.IIk = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131307429);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.IIl = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307426);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.IIm = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307428);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.IIn = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307449);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.IIo = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307452);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.IIp = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307474);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.IIq = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131307445);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.fsF = ((Button)paramb);
    this.IIp.setVisibility(8);
    this.IIo.setVisibility(8);
    paramb = this.oPR;
    Context localContext = paramRelativeLayout.getContext();
    d.g.b.k.g(localContext, "root.context");
    paramb.setImageDrawable(am.e(localContext.getResources().getDrawable(2131690353), -1));
    this.IIl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202805);
        Object localObject = new Intent(this.IIt.getContext(), LiveUIC.class);
        paramAnonymousView = this.IIt.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveAfterPlugin$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(202805);
      }
    });
    this.IIm.setOnClickListener((View.OnClickListener)2.IIu);
    this.IIn.setOnClickListener((View.OnClickListener)3.IIv);
    this.oPR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202808);
        b.b.a(this.IIw.IIs, b.c.FAX);
        AppMethodBeat.o(202808);
      }
    });
    this.fsF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202809);
        b.b.a(this.IIw.IIs, b.c.FAX);
        AppMethodBeat.o(202809);
      }
    });
    this.IIp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202810);
        Object localObject = new Intent(this.IIt.getContext(), LiveUID.class);
        ((Intent)localObject).putExtra("FROM_SENCE", 2);
        paramAnonymousView = this.IIt.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/live/plugin/LiveAfterPlugin$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView = f.rGw;
        if (d.g.b.k.g(f.eNI(), u.aqG())) {
          d.fPR();
        }
        AppMethodBeat.o(202810);
      }
    });
    AppMethodBeat.o(202821);
  }
  
  private void fOO()
  {
    AppMethodBeat.i(202814);
    Object localObject1 = this.IIh;
    Object localObject2 = this.pTc.getContext();
    Object localObject3 = new StringBuilder("\"");
    f localf = f.rGw;
    ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject2, (CharSequence)(f.fOB() + "\""), this.IIh.getTextSize()));
    localObject1 = this.IIi;
    localObject2 = f.rGw;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(f.eNG().LyP));
    localObject1 = this.IIj;
    localObject2 = f.rGw;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(f.eNG().Lza));
    localObject1 = this.qrL;
    localObject2 = f.rGw;
    ((TextView)localObject1).setText((CharSequence)String.valueOf(f.eNG().LyR));
    localObject1 = f.rGw;
    if (f.eNG().nrv > 0)
    {
      localObject1 = f.rGw;
      i = f.eNG().nrv;
      localObject1 = f.rGw;
      int j = f.eNG().CJd;
      localObject1 = j.zaQ;
      localObject2 = j.a.aT(i - j, ":");
      localObject1 = this.IIk;
      localObject3 = z.Jhz;
      localObject3 = this.pTc.getContext().getString(2131766534);
      d.g.b.k.g(localObject3, "root.context.getString(R…ring.live_after_duration)");
      localObject2 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject2 }, 1));
      d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = f.rGw;
      localObject1 = f.eNG();
      if ((TextUtils.isEmpty((CharSequence)((eas)localObject1).Lze)) || (!bt.kU(((eas)localObject1).Lzf, ((eas)localObject1).Lze))) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label338;
      }
      fOP();
      AppMethodBeat.o(202814);
      return;
      i = ce.asT();
      break;
    }
    label338:
    localObject1 = f.rGw;
    if (f.eNG().Lzd)
    {
      fOP();
      AppMethodBeat.o(202814);
      return;
    }
    this.IIp.setVisibility(8);
    this.IIo.setVisibility(0);
    AppMethodBeat.o(202814);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202813);
    d.g.b.k.h(paramLiveConfig, "config");
    if (paramLiveConfig.ckz() == LiveConfig.qsK) {}
    for (boolean bool = true;; bool = false)
    {
      this.IIr = bool;
      AppMethodBeat.o(202813);
      return;
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202819);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (d.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202819);
      return;
      fOO();
      agK(0);
      paramc = f.rGw;
      paramc = f.eNI();
      paramBundle = com.tencent.mm.live.b.d.a.Fwy;
      paramBundle = this.pTc.getContext();
      d.g.b.k.g(paramBundle, "root.context");
      a.a.a(paramc, paramBundle.getResources().getColor(2131101200), (d.g.a.b)new a(this));
      paramc = this.pTc.getContext();
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(202819);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      paramc = f.rGw;
      if (f.eNG().nrv > 0) {
        paramc = f.rGw;
      }
      for (int i = f.eNG().nrv;; i = ce.asT())
      {
        paramc = f.rGw;
        int j = f.eNG().CJd;
        paramc = f.rGw;
        paramc = f.eNB();
        paramBundle = f.rGw;
        long l = f.eNG().LwA;
        paramBundle = f.rGw;
        paramBundle = f.eNG().LwZ;
        f localf = f.rGw;
        int k = f.eNG().LyP;
        localf = f.rGw;
        int m = f.fHk();
        localf = f.rGw;
        int n = f.eNG().Lza;
        localf = f.rGw;
        int i1 = f.eNG().LyR;
        localf = f.rGw;
        int i2 = f.fOo();
        localf = f.rGw;
        e.a(paramc, l, paramBundle, k, m, n, i1, i2, f.eNG().Lzd, i - j);
        AppMethodBeat.o(202819);
        return;
      }
      agK(4);
    }
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(202818);
    if (this.pTc.getVisibility() == 0)
    {
      b.b.a(this.IIs, b.c.FAX);
      AppMethodBeat.o(202818);
      return true;
    }
    AppMethodBeat.o(202818);
    return false;
  }
  
  public final void fOM() {}
  
  public final void fON() {}
  
  public final void fOP()
  {
    AppMethodBeat.i(202815);
    this.IIp.setVisibility(8);
    this.IIo.setVisibility(0);
    AppMethodBeat.o(202815);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(202820);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fOO();
        AppMethodBeat.o(202820);
      }
    }
    else if ((paramn instanceof com.tencent.mm.live.b.a.q))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i(this.TAG, "open replay success");
        AppMethodBeat.o(202820);
        return;
      }
      ad.i(this.TAG, "open replay fail");
    }
    AppMethodBeat.o(202820);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(202817);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(3806, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(202817);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(202816);
    Object localObject = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aeS().a(3806, (com.tencent.mm.al.g)this);
    localObject = h.xfu;
    h.fOH();
    AppMethodBeat.o(202816);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.c
 * JD-Core Version:    0.7.0.1
 */