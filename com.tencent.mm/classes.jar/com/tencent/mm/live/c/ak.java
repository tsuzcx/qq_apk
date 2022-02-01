package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak
  extends a
{
  final b gSM;
  final TextView gWr;
  private final MMAnimateView gWs;
  
  public ak(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212540);
    this.gSM = paramb;
    this.gWr = ((TextView)paramViewGroup.findViewById(2131307710));
    this.gWs = ((MMAnimateView)paramViewGroup.findViewById(2131307708));
    paramViewGroup.setVisibility(4);
    paramb = com.tencent.mm.live.b.g.gOr;
    paramb = com.tencent.mm.live.b.g.aod();
    paramViewGroup = (r)new q(paramViewGroup)
    {
      @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
      static final class a
        extends q
        implements d.g.a.a<z>
      {
        a(ak.1 param1, am paramam, String paramString)
        {
          super();
        }
      }
    };
    p.h(paramViewGroup, "observer");
    paramb.gQL = paramViewGroup;
    this.gWr.requestLayout();
    this.gWs.setImageResource(2131691544);
    AppMethodBeat.o(212540);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212539);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (al.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212539);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramBundle, "MMKernel.service<IMessen…engerStorage::class.java)");
          paramc = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azp().Bf(paramc);
          if (paramc != null)
          {
            paramBundle = this.gWr;
            p.g(paramBundle, "micHeadTip");
            paramBundle.setText((CharSequence)k.c(this.gGK.getContext(), (CharSequence)this.gGK.getContext().getString(2131766699, new Object[] { paramc.VC() })));
            AppMethodBeat.o(212539);
            return;
          }
        }
        AppMethodBeat.o(212539);
        return;
      }
      AppMethodBeat.o(212539);
      return;
      nI(0);
      AppMethodBeat.o(212539);
      return;
      nI(0);
      AppMethodBeat.o(212539);
      return;
      nI(8);
      paramc = c.gMO;
      paramc = com.tencent.mm.live.b.g.gOr;
      c.g(false, com.tencent.mm.live.b.g.anC());
      paramc = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.xH("");
      paramc = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.xI("");
      AppMethodBeat.o(212539);
      return;
      nI(8);
      AppMethodBeat.o(212539);
      return;
      if (this.gSM.getLiveRole() == 1)
      {
        paramc = com.tencent.mm.live.core.core.a.b.gHl;
        paramc = this.gGK.getContext();
        p.g(paramc, "root.context");
      }
      for (paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cq(paramc); (paramc.gIt.alE()) || (paramc.gIt.alF()); paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cr(paramc))
      {
        nI(0);
        if (this.gSM.getLiveRole() != 1) {
          break label454;
        }
        paramc = this.gWr;
        p.g(paramc, "micHeadTip");
        paramBundle = this.gGK.getContext();
        localContext = this.gGK.getContext();
        localg = com.tencent.mm.live.b.g.gOr;
        paramc.setText((CharSequence)k.c(paramBundle, (CharSequence)localContext.getString(2131766699, new Object[] { com.tencent.mm.live.b.g.anC() })));
        AppMethodBeat.o(212539);
        return;
        paramc = com.tencent.mm.live.core.core.c.b.gKd;
        paramc = this.gGK.getContext();
        p.g(paramc, "root.context");
      }
      continue;
      label454:
      paramc = com.tencent.mm.live.b.g.gOr;
      if (bt.lQ(com.tencent.mm.live.b.g.anD(), u.aAm()))
      {
        paramc = this.gWr;
        p.g(paramc, "micHeadTip");
        paramc.setText((CharSequence)k.c(this.gGK.getContext(), (CharSequence)this.gGK.getContext().getString(2131766701)));
        AppMethodBeat.o(212539);
        return;
      }
      paramc = this.gWr;
      p.g(paramc, "micHeadTip");
      paramBundle = this.gGK.getContext();
      Context localContext = this.gGK.getContext();
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
      paramc.setText((CharSequence)k.c(paramBundle, (CharSequence)localContext.getString(2131766700, new Object[] { com.tencent.mm.live.b.g.anC() })));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ak
 * JD-Core Version:    0.7.0.1
 */