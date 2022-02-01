package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.ad;
import com.tencent.mm.protocal.protobuf.bmw;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFastCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "fastCommentWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFastCommentWidget;", "checkIfShowViolationMsg", "", "createFastCommentWidget", "mount", "showWidget", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends b
{
  public static final a CUM;
  private ad CUN;
  private final Activity activity;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(353792);
    CUM = new a((byte)0);
    AppMethodBeat.o(353792);
  }
  
  public n(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353785);
    this.nfT = paramb;
    paramViewGroup = paramViewGroup.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(353785);
      throw paramViewGroup;
    }
    this.activity = ((Activity)paramViewGroup);
    AppMethodBeat.o(353785);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(353812);
    ad localad = this.CUN;
    if (localad != null) {
      localad.c((b)this);
    }
    AppMethodBeat.o(353812);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(353808);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    ad localad;
    do
    {
      AppMethodBeat.o(353808);
      return;
      if (this.CUN == null)
      {
        this.CUN = new ad((Context)this.activity, getBuContext());
        this.mJe.addView((View)this.CUN);
        paramc = this.CUN;
        if (paramc != null) {
          paramc.c((b)this);
        }
      }
      paramc = this.CUN;
      if (paramc != null) {
        paramc.show();
      }
      AppMethodBeat.o(353808);
      return;
      localad = this.CUN;
    } while (localad == null);
    paramc = ((e)localad.buContext.business(e.class)).EdT;
    label159:
    int i;
    if (paramc == null)
    {
      paramc = null;
      if (paramc != null) {
        break label204;
      }
      i = 0;
      label165:
      if (i == 0) {
        break label210;
      }
      if (paramc != null) {
        break label212;
      }
    }
    label204:
    label210:
    label212:
    for (paramBundle = null;; paramBundle = paramc.ZVC)
    {
      localad.ayA(paramBundle);
      if (paramc == null) {
        break;
      }
      paramc.ZVB = 0;
      break;
      paramc = (bmw)p.oL(paramc);
      break label159;
      i = paramc.ZVB;
      break label165;
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(353819);
    ad localad = this.CUN;
    if (localad != null) {
      localad.unMount();
    }
    AppMethodBeat.o(353819);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFastCommentPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.n
 * JD-Core Version:    0.7.0.1
 */