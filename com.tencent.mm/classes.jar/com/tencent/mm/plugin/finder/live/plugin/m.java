package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.g;
import com.tencent.mm.plugin.finder.live.widget.x;
import com.tencent.mm.protocal.protobuf.bgw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorFansClubPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "autoShowFans", "", "fansClubWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorFansClubWidget;", "applyState", "", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "createfansClubWidget", "keyboardChange", "show", "height", "mount", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends b
{
  public static final m.a CUJ;
  private g CUK;
  private boolean CUL;
  private final Activity activity;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354658);
    CUJ = new m.a((byte)0);
    AppMethodBeat.o(354658);
  }
  
  public m(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354640);
    this.nfT = paramb;
    paramViewGroup = paramViewGroup.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(354640);
      throw paramViewGroup;
    }
    this.activity = ((Activity)paramViewGroup);
    if (this.activity.getIntent().getIntExtra("KEY_PARAMS_DO_ACTION", 0) == 2) {
      this.CUL = true;
    }
    AppMethodBeat.o(354640);
  }
  
  private void eoZ()
  {
    AppMethodBeat.i(354650);
    if (this.CUK == null)
    {
      this.CUK = new g(this.activity, this.mJe);
      g localg = this.CUK;
      if (localg != null) {
        localg.c((b)this);
      }
    }
    AppMethodBeat.o(354650);
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(354681);
    super.applyState(paramInt1, paramInt2, paramBundle);
    if ((((e)business(e.class)).isLiveStarted()) && (this.CUL))
    {
      new StringBuilder("liveState:").append(paramInt1).append(",uiState:").append(paramInt2);
      com.tencent.e.f.h.jXD();
      eoZ();
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      if ((paramBundle == null) || (paramBundle.ZQo != true)) {
        break label120;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label125;
      }
      paramBundle = this.CUK;
      if (paramBundle != null) {
        paramBundle.sw(true);
      }
    }
    for (;;)
    {
      this.CUL = false;
      AppMethodBeat.o(354681);
      return;
      label120:
      paramInt1 = 0;
      break;
      label125:
      paramBundle = this.CUK;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.ElO;
        if (paramBundle != null) {
          paramBundle.show();
        }
      }
    }
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(354690);
    g localg = this.CUK;
    if (localg != null) {
      localg.onKeyboardHeightChanged(paramInt, paramBoolean);
    }
    AppMethodBeat.o(354690);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(354694);
    g localg = this.CUK;
    if (localg != null) {
      localg.c((b)this);
    }
    AppMethodBeat.o(354694);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354670);
    s.u(paramc, "status");
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      eoZ();
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      int i;
      if ((paramc != null) && (paramc.ZQo == true))
      {
        i = 1;
        if (i == 0) {
          break label102;
        }
        paramc = this.CUK;
        if (paramc == null) {
          break label124;
        }
        if (paramBundle != null) {
          break label91;
        }
      }
      label91:
      for (boolean bool = false;; bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_SHOW_FANS_MODIFY"))
      {
        paramc.sw(bool);
        AppMethodBeat.o(354670);
        return;
        i = 0;
        break;
      }
      label102:
      paramc = this.CUK;
      if (paramc != null)
      {
        paramc = paramc.ElO;
        if (paramc != null) {
          paramc.show();
        }
      }
    }
    label124:
    AppMethodBeat.o(354670);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354701);
    g localg = this.CUK;
    if (localg != null) {
      localg.unMount();
    }
    AppMethodBeat.o(354701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.m
 * JD-Core Version:    0.7.0.1
 */