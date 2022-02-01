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
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.b.u.a;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveAfterPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commentCountTv", "Landroid/widget/TextView;", "commentGroup", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/widget/Button;", "isJumpForStartLive", "", "likeCountTv", "likeGroup", "liveDurationTv", "liveNameTv", "liveOverTv", "replayCheckGroup", "replayGroup", "rootContent", "toReplay", "visitorCountTv", "visitorGroup", "visitorTv", "isLiveAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "mount", "", "onBackPress", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "resume", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchFinishMode", "switchReplayMode", "switchVisitorReplayMode", "unMount", "updateBgByUsername", "username", "updateDataInfo", "title", "plugin-logic_release"})
public final class c
  extends a
  implements i
{
  private final String TAG;
  private final Button gwO;
  private final ImageView hNZ;
  private final TextView hOa;
  private final TextView hOb;
  private final TextView hOc;
  private final TextView hOd;
  private final TextView hOe;
  private final TextView hOf;
  private final TextView hOg;
  private final LinearLayout hOh;
  private final LinearLayout hOi;
  private final LinearLayout hOj;
  public final LinearLayout hOk;
  public final LinearLayout hOl;
  final RelativeLayout hOm;
  private boolean hOn;
  private boolean hOo;
  final b hOp;
  
  public c(RelativeLayout paramRelativeLayout, b paramb)
  {
    super((ViewGroup)paramRelativeLayout, paramb);
    AppMethodBeat.i(207892);
    this.hOp = paramb;
    this.TAG = "MicroMsg.LiveAfterPlugin";
    paramb = paramRelativeLayout.findViewById(2131303247);
    p.g(paramb, "root.findViewById(R.id.live_after_back_btn)");
    this.hNZ = ((ImageView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303306);
    p.g(paramb, "root.findViewById(R.id.live_after_title)");
    this.hOa = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303275);
    p.g(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.hOb = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303309);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.hOc = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303310);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.hOd = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303249);
    p.g(paramb, "root.findViewById(R.id.live_after_comment_count)");
    this.hOe = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303259);
    p.g(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.hOf = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303250);
    p.g(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.hOg = ((TextView)paramb);
    paramb = paramRelativeLayout.findViewById(2131303256);
    p.g(paramb, "root.findViewById(R.id.l…after_info_visitor_group)");
    this.hOh = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303252);
    p.g(paramb, "root.findViewById(R.id.l…after_info_comment_group)");
    this.hOi = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303254);
    p.g(paramb, "root.findViewById(R.id.live_after_info_like_group)");
    this.hOj = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303280);
    p.g(paramb, "root.findViewById(R.id.live_after_replay_group)");
    this.hOk = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303283);
    p.g(paramb, "root.findViewById(R.id.l…fter_replay_switch_group)");
    this.hOl = ((LinearLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303308);
    p.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.hOm = ((RelativeLayout)paramb);
    paramb = paramRelativeLayout.findViewById(2131303276);
    p.g(paramb, "root.findViewById(R.id.live_after_replay_btn)");
    this.gwO = ((Button)paramb);
    this.hOl.setVisibility(8);
    this.hOk.setVisibility(8);
    paramb = this.hNZ;
    Context localContext = paramRelativeLayout.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690485), -1));
    if (this.hOp.getLiveRole() == 0)
    {
      paramb = this.hOc;
      localContext = paramRelativeLayout.getContext();
      p.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131762254));
    }
    for (;;)
    {
      this.hOi.setOnClickListener((View.OnClickListener)c.2.hOr);
      this.hOj.setOnClickListener((View.OnClickListener)c.3.hOs);
      this.hNZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207879);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          b.b.a(this.hOt.hOp, b.c.hLD);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207879);
        }
      });
      this.gwO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207880);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          b.b.a(this.hOt.hOp, b.c.hLD);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAfterPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207880);
        }
      });
      this.hOl.setOnClickListener((View.OnClickListener)new c.6(paramRelativeLayout));
      AppMethodBeat.o(207892);
      return;
      paramb = this.hOc;
      localContext = paramRelativeLayout.getContext();
      p.g(localContext, "root.context");
      paramb.setText((CharSequence)localContext.getResources().getString(2131762253));
      this.hOh.setOnClickListener((View.OnClickListener)new c.1(paramRelativeLayout));
    }
  }
  
  private void Hb(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(207885);
    p.h(paramString, "title");
    this.hOb.setText((CharSequence)paramString);
    paramString = this.hOa;
    Object localObject1 = this.hwr.getContext();
    Object localObject2 = com.tencent.mm.live.b.x.hJf;
    paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject1, (CharSequence)com.tencent.mm.live.b.x.aHe(), this.hOa.getTextSize()));
    paramString = this.hOd;
    localObject1 = com.tencent.mm.live.b.x.hJf;
    paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.x.aGr().LIa));
    paramString = this.hOe;
    localObject1 = com.tencent.mm.live.b.x.hJf;
    paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.x.aGr().MnH));
    paramString = this.hOf;
    localObject1 = com.tencent.mm.live.b.x.hJf;
    paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.x.aGr().LXG));
    paramString = com.tencent.mm.live.b.x.hJf;
    boolean bool;
    if (com.tencent.mm.live.b.x.aGr().Gaz > 0)
    {
      paramString = com.tencent.mm.live.b.x.hJf;
      if (com.tencent.mm.live.b.x.aGr().pSb > 0)
      {
        paramString = com.tencent.mm.live.b.x.hJf;
        i = com.tencent.mm.live.b.x.aGr().pSb;
        paramString = com.tencent.mm.live.b.x.hJf;
        int k = i - com.tencent.mm.live.b.x.aGr().Gaz;
        paramString = u.hIn;
        if (k < 3600) {
          break label405;
        }
        bool = true;
        label214:
        localObject1 = u.a.a(k, ":", bool, false, false, 24);
        Log.i(this.TAG, "endTime:" + i + ", duration:" + k + ", formatDuration:" + (String)localObject1);
        paramString = this.hOg;
        localObject2 = ae.SYK;
        localObject2 = this.hwr.getContext().getString(2131762240);
        p.g(localObject2, "root.context.getString(R…ring.live_after_duration)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramString.setText((CharSequence)localObject1);
      }
    }
    else
    {
      paramString = com.tencent.mm.live.b.x.hJf;
      paramString = com.tencent.mm.live.b.x.aGr();
      if ((TextUtils.isEmpty((CharSequence)paramString.MnL)) || (!Util.isEqual(paramString.MnM, paramString.MnL))) {
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
      aHq();
      AppMethodBeat.o(207885);
      return;
      i = cl.aWB();
      break;
      bool = false;
      break label214;
    }
    label416:
    paramString = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.aGr().MnK)
    {
      aHq();
      AppMethodBeat.o(207885);
      return;
    }
    this.hOl.setVisibility(8);
    this.hOk.setVisibility(0);
    AppMethodBeat.o(207885);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207884);
    p.h(paramLiveConfig, "config");
    if (paramLiveConfig.aBC() == LiveConfig.hvV) {}
    for (boolean bool = true;; bool = false)
    {
      this.hOn = bool;
      AppMethodBeat.o(207884);
      return;
    }
  }
  
  public final void aHq()
  {
    AppMethodBeat.i(207886);
    this.hOl.setVisibility(8);
    this.hOk.setVisibility(0);
    AppMethodBeat.o(207886);
  }
  
  public final void mount() {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(207889);
    if (this.hwr.getVisibility() == 0)
    {
      b.b.a(this.hOp, b.c.hLD);
      AppMethodBeat.o(207889);
      return true;
    }
    AppMethodBeat.o(207889);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(207891);
    if ((paramq instanceof com.tencent.mm.live.b.a.b))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.live.b.a.b)paramq).aGr();
        if (paramString != null)
        {
          paramString = paramString.MnQ;
          if (paramString != null)
          {
            paramInt1 = (int)paramString.Btv;
            if (!d.cW(1, paramInt1)) {
              break label293;
            }
            paramString = this.hwr.getContext();
            p.g(paramString, "root.context");
            paramString = paramString.getResources().getString(2131762239);
            label83:
            p.g(paramString, "if (cutLive) root.contex…R.string.live_after_over)");
            Hb(paramString);
            if ((!this.hOo) || (this.hOp.getLiveRole() != 1)) {
              break label371;
            }
            this.hOo = false;
            paramString = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.aGr().pSb <= 0) {
              break label321;
            }
            paramString = com.tencent.mm.live.b.x.hJf;
          }
        }
        label293:
        label321:
        for (paramInt1 = com.tencent.mm.live.b.x.aGr().pSb;; paramInt1 = cl.aWB())
        {
          paramString = com.tencent.mm.live.b.x.hJf;
          paramInt2 = com.tencent.mm.live.b.x.aGr().Gaz;
          paramString = com.tencent.mm.live.b.x.hJf;
          paramString = com.tencent.mm.live.b.x.aGm();
          paramq = com.tencent.mm.live.b.x.hJf;
          long l = com.tencent.mm.live.b.x.aGr().hyH;
          paramq = com.tencent.mm.live.b.x.hJf;
          paramq = com.tencent.mm.live.b.x.aGr().LpF;
          com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
          int i = com.tencent.mm.live.b.x.aGr().LIa;
          localx = com.tencent.mm.live.b.x.hJf;
          int j = com.tencent.mm.live.b.x.aGM();
          localx = com.tencent.mm.live.b.x.hJf;
          int k = com.tencent.mm.live.b.x.aGr().MnH;
          localx = com.tencent.mm.live.b.x.hJf;
          int m = com.tencent.mm.live.b.x.aGr().LXG;
          localx = com.tencent.mm.live.b.x.hJf;
          int n = com.tencent.mm.live.b.x.aGO();
          localx = com.tencent.mm.live.b.x.hJf;
          e.a(paramString, l, paramq, i, j, k, m, n, com.tencent.mm.live.b.x.aGr().MnK, paramInt1 - paramInt2);
          AppMethodBeat.o(207891);
          return;
          paramInt1 = 0;
          break;
          paramString = this.hwr.getContext();
          p.g(paramString, "root.context");
          paramString = paramString.getResources().getString(2131762242);
          break label83;
        }
      }
    }
    else if ((paramq instanceof com.tencent.mm.live.b.a.r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i(this.TAG, "open replay success");
        AppMethodBeat.o(207891);
        return;
      }
      Log.i(this.TAG, "open replay fail");
    }
    label371:
    AppMethodBeat.o(207891);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(207888);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3806, (i)this);
    AppMethodBeat.o(207888);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(207887);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3806, (i)this);
    AppMethodBeat.o(207887);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(207890);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (d.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207890);
      return;
      paramc = com.tencent.mm.live.b.r.hIg;
      com.tencent.mm.live.b.r.aGb();
      paramc = this.hwr.getContext();
      p.g(paramc, "root.context");
      paramc = paramc.getResources().getString(2131762242);
      p.g(paramc, "root.context.resources.g…R.string.live_after_over)");
      Hb(paramc);
      rg(0);
      paramc = com.tencent.mm.live.b.x.hJf;
      paramc = com.tencent.mm.live.b.x.aGt();
      paramBundle = com.tencent.mm.live.b.d.a.hLg;
      paramBundle = this.hwr.getContext();
      p.g(paramBundle, "root.context");
      a.a.a(paramc, paramBundle.getResources().getColor(2131100702), (kotlin.g.a.b)new a(this));
      paramc = this.hwr.getContext();
      if (paramc == null)
      {
        paramc = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(207890);
        throw paramc;
      }
      ((Activity)paramc).setRequestedOrientation(1);
      AppMethodBeat.o(207890);
      return;
      this.hOo = true;
      rg(4);
    }
  }
  
  public final void unMount() {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Bitmap, kotlin.x>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.c
 * JD-Core Version:    0.7.0.1
 */