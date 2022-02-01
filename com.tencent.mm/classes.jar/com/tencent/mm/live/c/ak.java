package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak
  extends a
{
  private final b kCL;
  private final TextView kGw;
  private final MMAnimateView kGx;
  
  public ak(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(196033);
    this.kCL = paramb;
    this.kGw = ((TextView)paramViewGroup.findViewById(b.e.live_mic_visitor_header_tip));
    this.kGx = ((MMAnimateView)paramViewGroup.findViewById(b.e.live_mic_visitor_header_icon));
    paramViewGroup.setVisibility(4);
    paramb = u.kwz;
    paramb = u.aPa();
    paramViewGroup = (r)new q(paramViewGroup)
    {
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
      static final class a
        extends q
        implements kotlin.g.a.a<x>
      {
        a(ak.1 param1, as paramas, String paramString)
        {
          super();
        }
      }
    };
    p.k(paramViewGroup, "observer");
    paramb.kyk = paramViewGroup;
    this.kGw.requestLayout();
    this.kGx.setImageResource(b.g.live_micing_icon);
    AppMethodBeat.o(196033);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(196029);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (al.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196029);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramBundle = com.tencent.mm.kernel.h.ae(n.class);
          p.j(paramBundle, "MMKernel.service<IMessen…engerStorage::class.java)");
          paramc = ((n)paramBundle).bbL().RG(paramc);
          if (paramc != null)
          {
            paramBundle = this.kGw;
            p.j(paramBundle, "micHeadTip");
            paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.kiF.getContext(), (CharSequence)this.kiF.getContext().getString(b.h.live_room_mic_talking, new Object[] { paramc.getNickname() })));
            AppMethodBeat.o(196029);
            return;
          }
        }
        AppMethodBeat.o(196029);
        return;
      }
      AppMethodBeat.o(196029);
      return;
      tU(0);
      AppMethodBeat.o(196029);
      return;
      tU(0);
      AppMethodBeat.o(196029);
      return;
      tU(8);
      paramc = j.kue;
      paramc = u.kwz;
      j.k(false, u.aOz());
      paramc = u.kwz;
      u.Oe("");
      paramc = u.kwz;
      u.Of("");
      AppMethodBeat.o(196029);
      return;
      tU(8);
      AppMethodBeat.o(196029);
      return;
      if (this.kCL.getLiveRole() == 1) {
        paramc = com.tencent.mm.live.core.core.a.b.klq;
      }
      for (paramc = (com.tencent.mm.live.core.core.trtc.a)b.b.aLh(); (paramc.knA.aLo()) || (paramc.knA.aLp()); paramc = (com.tencent.mm.live.core.core.trtc.a)c.a.aMm())
      {
        tU(0);
        if (this.kCL.getLiveRole() != 1) {
          break label430;
        }
        paramc = this.kGw;
        p.j(paramc, "micHeadTip");
        paramBundle = this.kiF.getContext();
        localContext = this.kiF.getContext();
        i = b.h.live_room_mic_talking;
        localu = u.kwz;
        paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramBundle, (CharSequence)localContext.getString(i, new Object[] { u.aOz() })));
        AppMethodBeat.o(196029);
        return;
        paramc = c.kqq;
      }
      continue;
      label430:
      paramc = u.kwz;
      if (Util.isEqual(u.aOA(), z.bcZ()))
      {
        paramc = this.kGw;
        p.j(paramc, "micHeadTip");
        paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.kiF.getContext(), (CharSequence)this.kiF.getContext().getString(b.h.live_room_mic_talking_anchor)));
        AppMethodBeat.o(196029);
        return;
      }
      paramc = this.kGw;
      p.j(paramc, "micHeadTip");
      paramBundle = this.kiF.getContext();
      Context localContext = this.kiF.getContext();
      int i = b.h.live_room_mic_talking_3rd;
      u localu = u.kwz;
      paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramBundle, (CharSequence)localContext.getString(i, new Object[] { u.aOz() })));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ak
 * JD-Core Version:    0.7.0.1
 */