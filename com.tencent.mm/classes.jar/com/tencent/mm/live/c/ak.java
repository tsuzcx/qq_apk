package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak
  extends a
{
  final b gVv;
  final TextView gZe;
  private final MMAnimateView gZf;
  
  public ak(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216166);
    this.gVv = paramb;
    this.gZe = ((TextView)paramViewGroup.findViewById(2131307710));
    this.gZf = ((MMAnimateView)paramViewGroup.findViewById(2131307708));
    paramViewGroup.setVisibility(4);
    paramb = com.tencent.mm.live.b.g.gQZ;
    paramb = com.tencent.mm.live.b.g.aos();
    paramViewGroup = (r)new q(paramViewGroup)
    {
      @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
      static final class a
        extends q
        implements d.g.a.a<z>
      {
        a(ak.1 param1, an paraman, String paramString)
        {
          super();
        }
      }
    };
    p.h(paramViewGroup, "observer");
    paramb.gTt = paramViewGroup;
    this.gZe.requestLayout();
    this.gZf.setImageResource(2131691544);
    AppMethodBeat.o(216166);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216165);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (al.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216165);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramBundle, "MMKernel.service<IMessen…engerStorage::class.java)");
          paramc = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azF().BH(paramc);
          if (paramc != null)
          {
            paramBundle = this.gZe;
            p.g(paramBundle, "micHeadTip");
            paramBundle.setText((CharSequence)k.c(this.gJt.getContext(), (CharSequence)this.gJt.getContext().getString(2131766699, new Object[] { paramc.VK() })));
            AppMethodBeat.o(216165);
            return;
          }
        }
        AppMethodBeat.o(216165);
        return;
      }
      AppMethodBeat.o(216165);
      return;
      nL(0);
      AppMethodBeat.o(216165);
      return;
      nL(0);
      AppMethodBeat.o(216165);
      return;
      nL(8);
      paramc = c.gPx;
      paramc = com.tencent.mm.live.b.g.gQZ;
      c.g(false, com.tencent.mm.live.b.g.anR());
      paramc = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.yq("");
      paramc = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.yr("");
      AppMethodBeat.o(216165);
      return;
      nL(8);
      AppMethodBeat.o(216165);
      return;
      if (this.gVv.getLiveRole() == 1)
      {
        paramc = com.tencent.mm.live.core.core.a.b.gJU;
        paramc = this.gJt.getContext();
        p.g(paramc, "root.context");
      }
      for (paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cs(paramc); (paramc.gLc.alT()) || (paramc.gLc.alU()); paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.ct(paramc))
      {
        nL(0);
        if (this.gVv.getLiveRole() != 1) {
          break label454;
        }
        paramc = this.gZe;
        p.g(paramc, "micHeadTip");
        paramBundle = this.gJt.getContext();
        localContext = this.gJt.getContext();
        localg = com.tencent.mm.live.b.g.gQZ;
        paramc.setText((CharSequence)k.c(paramBundle, (CharSequence)localContext.getString(2131766699, new Object[] { com.tencent.mm.live.b.g.anR() })));
        AppMethodBeat.o(216165);
        return;
        paramc = com.tencent.mm.live.core.core.c.b.gMM;
        paramc = this.gJt.getContext();
        p.g(paramc, "root.context");
      }
      continue;
      label454:
      paramc = com.tencent.mm.live.b.g.gQZ;
      if (bu.lX(com.tencent.mm.live.b.g.anS(), v.aAC()))
      {
        paramc = this.gZe;
        p.g(paramc, "micHeadTip");
        paramc.setText((CharSequence)k.c(this.gJt.getContext(), (CharSequence)this.gJt.getContext().getString(2131766701)));
        AppMethodBeat.o(216165);
        return;
      }
      paramc = this.gZe;
      p.g(paramc, "micHeadTip");
      paramBundle = this.gJt.getContext();
      Context localContext = this.gJt.getContext();
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
      paramc.setText((CharSequence)k.c(paramBundle, (CharSequence)localContext.getString(2131766700, new Object[] { com.tencent.mm.live.b.g.anR() })));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ak
 * JD-Core Version:    0.7.0.1
 */