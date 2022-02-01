package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.m;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak
  extends a
{
  final b hOp;
  final TextView hRZ;
  private final MMAnimateView hSa;
  
  public ak(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208128);
    this.hOp = paramb;
    this.hRZ = ((TextView)paramViewGroup.findViewById(2131303494));
    this.hSa = ((MMAnimateView)paramViewGroup.findViewById(2131303492));
    paramViewGroup.setVisibility(4);
    paramb = com.tencent.mm.live.b.x.hJf;
    paramb = com.tencent.mm.live.b.x.aHa();
    paramViewGroup = (r)new q(paramViewGroup)
    {
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
      static final class a
        extends q
        implements kotlin.g.a.a<kotlin.x>
      {
        a(ak.1 param1, as paramas, String paramString)
        {
          super();
        }
      }
    };
    p.h(paramViewGroup, "observer");
    paramb.hKQ = paramViewGroup;
    this.hRZ.requestLayout();
    this.hSa.setImageResource(2131691012);
    AppMethodBeat.o(208128);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208127);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (al.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208127);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramBundle = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramBundle, "MMKernel.service<IMessen…engerStorage::class.java)");
          paramc = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).aSN().Kn(paramc);
          if (paramc != null)
          {
            paramBundle = this.hRZ;
            p.g(paramBundle, "micHeadTip");
            paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), (CharSequence)this.hwr.getContext().getString(2131762396, new Object[] { paramc.getNickname() })));
            AppMethodBeat.o(208127);
            return;
          }
        }
        AppMethodBeat.o(208127);
        return;
      }
      AppMethodBeat.o(208127);
      return;
      rg(0);
      AppMethodBeat.o(208127);
      return;
      rg(0);
      AppMethodBeat.o(208127);
      return;
      rg(8);
      paramc = m.hGg;
      paramc = com.tencent.mm.live.b.x.hJf;
      m.h(false, com.tencent.mm.live.b.x.aGz());
      paramc = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.GT("");
      paramc = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.GU("");
      AppMethodBeat.o(208127);
      return;
      rg(8);
      AppMethodBeat.o(208127);
      return;
      if (this.hOp.getLiveRole() == 1)
      {
        paramc = com.tencent.mm.live.core.core.a.b.hyv;
        this.hwr.getContext();
      }
      for (paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.aDo(); (paramc.hAz.aDt()) || (paramc.hAz.aDu()); paramc = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.d.b.a.aEf())
      {
        rg(0);
        if (this.hOp.getLiveRole() != 1) {
          break label440;
        }
        paramc = this.hRZ;
        p.g(paramc, "micHeadTip");
        paramBundle = this.hwr.getContext();
        localContext = this.hwr.getContext();
        localx = com.tencent.mm.live.b.x.hJf;
        paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramBundle, (CharSequence)localContext.getString(2131762396, new Object[] { com.tencent.mm.live.b.x.aGz() })));
        AppMethodBeat.o(208127);
        return;
        paramc = com.tencent.mm.live.core.core.d.b.hCo;
        this.hwr.getContext();
      }
      continue;
      label440:
      paramc = com.tencent.mm.live.b.x.hJf;
      if (Util.isEqual(com.tencent.mm.live.b.x.aGA(), z.aTY()))
      {
        paramc = this.hRZ;
        p.g(paramc, "micHeadTip");
        paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), (CharSequence)this.hwr.getContext().getString(2131762398)));
        AppMethodBeat.o(208127);
        return;
      }
      paramc = this.hRZ;
      p.g(paramc, "micHeadTip");
      paramBundle = this.hwr.getContext();
      Context localContext = this.hwr.getContext();
      com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
      paramc.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramBundle, (CharSequence)localContext.getString(2131762397, new Object[] { com.tencent.mm.live.b.x.aGz() })));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ak
 * JD-Core Version:    0.7.0.1
 */