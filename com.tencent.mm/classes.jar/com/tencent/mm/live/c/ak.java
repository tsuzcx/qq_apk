package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.f;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import d.g.a.r;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class ak
  extends a
{
  final b IIs;
  final TextView Kws;
  private final MMAnimateView Kwt;
  
  public ak(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203016);
    this.IIs = paramb;
    this.Kws = ((TextView)paramViewGroup.findViewById(2131307627));
    this.Kwt = ((MMAnimateView)paramViewGroup.findViewById(2131307625));
    paramViewGroup.setVisibility(4);
    paramb = f.rGw;
    paramb = f.fOz();
    paramViewGroup = (r)new d.g.b.l(paramViewGroup)
    {
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/live/plugin/LiveMicHeaderPlugin$1$1$1"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<y>
      {
        a(ak.1 param1, af paramaf, String paramString)
        {
          super();
        }
      }
    };
    d.g.b.k.h(paramViewGroup, "observer");
    paramb.BMu = paramViewGroup;
    this.Kws.requestLayout();
    this.Kwt.setImageResource(2131691529);
    AppMethodBeat.o(203016);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203015);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (al.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203015);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramBundle = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(paramBundle, "MMKernel.service<IMessen…engerStorage::class.java)");
          paramc = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramBundle).apM().aHY(paramc);
          if (paramc != null)
          {
            paramBundle = this.Kws;
            d.g.b.k.g(paramBundle, "micHeadTip");
            paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.pTc.getContext(), (CharSequence)this.pTc.getContext().getString(2131766664, new Object[] { paramc.Su() })));
            AppMethodBeat.o(203015);
            return;
          }
        }
      }
      AppMethodBeat.o(203015);
      return;
      agK(0);
      AppMethodBeat.o(203015);
      return;
      agK(0);
      AppMethodBeat.o(203015);
      return;
      agK(8);
      paramc = c.qYi;
      paramc = f.rGw;
      c.g(false, f.fhH());
      paramc = f.rGw;
      f.aUn("");
      paramc = f.rGw;
      f.aUo("");
      AppMethodBeat.o(203015);
      return;
      agK(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.ak
 * JD-Core Version:    0.7.0.1
 */