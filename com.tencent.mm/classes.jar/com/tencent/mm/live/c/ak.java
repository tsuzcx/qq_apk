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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.g.a.r;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak
  extends a
{
  final TextView gCH;
  private final MMAnimateView gCI;
  final b gzb;
  
  public ak(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190250);
    this.gzb = paramb;
    this.gCH = ((TextView)paramViewGroup.findViewById(2131307710));
    this.gCI = ((MMAnimateView)paramViewGroup.findViewById(2131307708));
    paramViewGroup.setVisibility(4);
    paramb = com.tencent.mm.live.b.g.guG;
    paramb = com.tencent.mm.live.b.g.alq();
    paramViewGroup = (r)new d.g.b.l(paramViewGroup)
    {
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<y>
      {
        a(ak.1 param1, ai paramai, String paramString)
        {
          super();
        }
      }
    };
    d.g.b.k.h(paramViewGroup, "observer");
    paramb.gxa = paramViewGroup;
    this.gCH.requestLayout();
    this.gCI.setImageResource(2131691544);
    AppMethodBeat.o(190250);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190249);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (al.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190249);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(paramBundle, "MMKernel.service<IMessen…engerStorage::class.java)");
          paramc = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramBundle).awB().aNt(paramc);
          if (paramc != null)
          {
            paramBundle = this.gCH;
            d.g.b.k.g(paramBundle, "micHeadTip");
            paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.gnb.getContext(), (CharSequence)this.gnb.getContext().getString(2131766699, new Object[] { paramc.Tn() })));
            AppMethodBeat.o(190249);
            return;
          }
        }
      }
      AppMethodBeat.o(190249);
      return;
      nj(0);
      AppMethodBeat.o(190249);
      return;
      nj(0);
      AppMethodBeat.o(190249);
      return;
      nj(8);
      paramc = c.gtd;
      paramc = com.tencent.mm.live.b.g.guG;
      c.f(false, com.tencent.mm.live.b.g.akP());
      paramc = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.uR("");
      paramc = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.uS("");
      AppMethodBeat.o(190249);
      return;
      nj(8);
      AppMethodBeat.o(190249);
      return;
      if (this.gzb.getLiveRole() == 1)
      {
        paramc = com.tencent.mm.live.core.core.a.b.gnC;
        paramc = this.gnb.getContext();
        d.g.b.k.g(paramc, "root.context");
      }
      for (paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.ct(paramc); (paramc.goL.aiS()) || (paramc.goL.aiT()); paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cu(paramc))
      {
        nj(0);
        if (this.gzb.getLiveRole() != 1) {
          break label448;
        }
        paramc = this.gCH;
        d.g.b.k.g(paramc, "micHeadTip");
        paramBundle = this.gnb.getContext();
        localContext = this.gnb.getContext();
        localg = com.tencent.mm.live.b.g.guG;
        paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(paramBundle, (CharSequence)localContext.getString(2131766699, new Object[] { com.tencent.mm.live.b.g.akP() })));
        AppMethodBeat.o(190249);
        return;
        paramc = com.tencent.mm.live.core.core.c.b.gqt;
        paramc = this.gnb.getContext();
        d.g.b.k.g(paramc, "root.context");
      }
      continue;
      label448:
      paramc = com.tencent.mm.live.b.g.guG;
      if (bs.lr(com.tencent.mm.live.b.g.akQ(), u.axw()))
      {
        paramc = this.gCH;
        d.g.b.k.g(paramc, "micHeadTip");
        paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.gnb.getContext(), (CharSequence)this.gnb.getContext().getString(2131766701)));
        AppMethodBeat.o(190249);
        return;
      }
      paramc = this.gCH;
      d.g.b.k.g(paramc, "micHeadTip");
      paramBundle = this.gnb.getContext();
      Context localContext = this.gnb.getContext();
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
      paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(paramBundle, (CharSequence)localContext.getString(2131766700, new Object[] { com.tencent.mm.live.b.g.akP() })));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ak
 * JD-Core Version:    0.7.0.1
 */