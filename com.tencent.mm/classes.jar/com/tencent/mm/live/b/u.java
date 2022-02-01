package com.tencent.mm.live.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.model.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveMicHeaderPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "micHeadIcon", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "micHeadTip", "Landroid/widget/TextView;", "loadSelfMicView", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends a
{
  private final b nfT;
  private final TextView nju;
  private final MMAnimateView njv;
  
  public u(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247175);
    this.nfT = paramb;
    this.nju = ((TextView)paramViewGroup.findViewById(b.e.live_mic_visitor_header_tip));
    this.njv = ((MMAnimateView)paramViewGroup.findViewById(b.e.live_mic_visitor_header_icon));
    paramViewGroup.setVisibility(4);
    paramb = com.tencent.mm.live.model.u.mZl;
    paramb = com.tencent.mm.live.model.u.biN();
    paramViewGroup = (r)new kotlin.g.b.u(paramViewGroup)
    {
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<ah>
      {
        a(u paramu, ViewGroup paramViewGroup, au paramau, String paramString)
        {
          super();
        }
      }
    };
    s.u(paramViewGroup, "observer");
    paramb.nbJ = paramViewGroup;
    this.nju.requestLayout();
    this.njv.setImageResource(b.g.live_micing_icon);
    AppMethodBeat.o(247175);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247215);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (u.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247215);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_LIVE_WXID", "");
        if (!TextUtils.isEmpty((CharSequence)paramc))
        {
          paramc = ((n)h.ax(n.class)).bzA().JE(paramc);
          if (paramc != null) {
            this.nju.setText((CharSequence)p.b(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getString(b.h.live_room_mic_talking, new Object[] { paramc.field_nickname })));
          }
        }
        AppMethodBeat.o(247215);
        return;
        tO(0);
        AppMethodBeat.o(247215);
        return;
        tO(0);
        AppMethodBeat.o(247215);
        return;
        tO(8);
        paramc = j.mXT;
        paramc = com.tencent.mm.live.model.u.mZl;
        j.j(false, com.tencent.mm.live.model.u.bim());
        paramc = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.Gr("");
        paramc = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.Gs("");
        AppMethodBeat.o(247215);
        return;
        tO(8);
        AppMethodBeat.o(247215);
        return;
        if (this.nfT.getLiveRole() == 1) {
          paramc = com.tencent.mm.live.core.core.a.b.mMo;
        }
        for (paramc = (com.tencent.mm.live.core.core.trtc.a)b.a.bej(); (paramc.mRB.bet()) || (paramc.mRB.beu()); paramc = (com.tencent.mm.live.core.core.trtc.a)d.a.bfM())
        {
          tO(0);
          if (this.nfT.getLiveRole() != 1) {
            break label396;
          }
          paramc = this.nju;
          paramBundle = this.mJe.getContext();
          localContext = this.mJe.getContext();
          i = b.h.live_room_mic_talking;
          localu = com.tencent.mm.live.model.u.mZl;
          paramc.setText((CharSequence)p.b(paramBundle, (CharSequence)localContext.getString(i, new Object[] { com.tencent.mm.live.model.u.bim() })));
          AppMethodBeat.o(247215);
          return;
          paramc = d.mUj;
        }
        continue;
        label396:
        paramc = com.tencent.mm.live.model.u.mZl;
        if (Util.isEqual(com.tencent.mm.live.model.u.bin(), z.bAM()))
        {
          this.nju.setText((CharSequence)p.b(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getString(b.h.live_room_mic_talking_anchor)));
          AppMethodBeat.o(247215);
          return;
        }
        paramc = this.nju;
        paramBundle = this.mJe.getContext();
        Context localContext = this.mJe.getContext();
        int i = b.h.live_room_mic_talking_3rd;
        com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
        paramc.setText((CharSequence)p.b(paramBundle, (CharSequence)localContext.getString(i, new Object[] { com.tencent.mm.live.model.u.bim() })));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.u
 * JD-Core Version:    0.7.0.1
 */