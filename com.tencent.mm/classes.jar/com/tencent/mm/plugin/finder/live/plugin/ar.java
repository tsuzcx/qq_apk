package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveGameInfoView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.surface.c.f;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameInfoPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "gameInfoView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameInfoView;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameInfoView;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "firstFrame", "", "firstInit", "previewView", "Landroid/view/View;", "surfaceMgr", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "getSurfaceMgr", "()Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "setSurfaceMgr", "(Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;)V", "canClearScreen", "canShow", "checkVisible", "", "pause", "requestLandScapeLayout", "showWidget", "requestLayout", "preview", "resume", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  extends b
{
  public com.tencent.mm.plugin.finder.live.model.frameset.c CZh;
  private final FinderLiveGameInfoView CZp;
  private boolean CZq;
  private View CZr;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private boolean ynV;
  
  public ar(FinderLiveGameInfoView paramFinderLiveGameInfoView, com.tencent.mm.live.b.b paramb)
  {
    super((ViewGroup)paramFinderLiveGameInfoView, paramb);
    AppMethodBeat.i(354782);
    this.CZp = paramFinderLiveGameInfoView;
    this.nfT = paramb;
    this.TAG = "MicroMsg.FinderLiveGameInfoPlugin";
    this.ynV = true;
    this.CZq = true;
    AppMethodBeat.o(354782);
  }
  
  private void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(354794);
    Object localObject = this.CZp.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(354794);
      throw ((Throwable)localObject);
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_11A);
      this.CZp.setSurfaceMgr(this.CZh);
      this.CZp.setup((e)getBuContext().business(e.class));
    }
    for (;;)
    {
      this.CZp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(354794);
      return;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_3A);
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(354820);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHt, 1);
    if (this.CZq)
    {
      this.CZq = false;
      if (i != 1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(as.REPORT_ID, as.CZs);
        Log.v(as.REPORT_TAG, "abtest closed");
      }
    }
    if (i == 0)
    {
      tO(8);
      Log.e(this.TAG, "show_game_info_view is 0, hide gameInfo entrance");
      AppMethodBeat.o(354820);
      return;
    }
    if (isLandscape())
    {
      tO(8);
      Log.e(this.TAG, "now not support landscape, hide gameInfo entrance");
      AppMethodBeat.o(354820);
      return;
    }
    bgz localbgz = ((e)business(e.class)).Edj;
    if (localbgz == null)
    {
      tO(8);
      Log.e(this.TAG, "liveGameData is null");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(as.REPORT_ID, as.CZv);
      Log.v(as.REPORT_TAG, "liveData Empty");
      AppMethodBeat.o(354820);
      return;
    }
    Log.i(this.TAG, "liveGameData visibility:%d", new Object[] { Integer.valueOf(localbgz.visibility) });
    this.CZp.setSurfaceMgr(this.CZh);
    if (localbgz.visibility == 0)
    {
      tO(8);
      AppMethodBeat.o(354820);
      return;
    }
    if (this.mJe.getVisibility() != 0)
    {
      tO(0);
      rn(true);
      Log.i(this.TAG, "show game data");
      this.CZp.setup((e)getBuContext().business(e.class));
    }
    this.CZp.a(localbgz);
    if (this.ynV)
    {
      this.ynV = false;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(as.REPORT_ID, as.CZu);
      Log.v(as.REPORT_TAG, "first frame return");
    }
    AppMethodBeat.o(354820);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(354828);
    bgz localbgz = ((e)business(e.class)).Edj;
    if ((localbgz != null) && (localbgz.visibility == 1)) {}
    for (int i = 1; (i != 0) && (!isLandscape()); i = 0)
    {
      AppMethodBeat.o(354828);
      return false;
    }
    AppMethodBeat.o(354828);
    return true;
  }
  
  public final void fY(View paramView)
  {
    AppMethodBeat.i(354862);
    s.u(paramView, "preview");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Object localObject = this.mJe.getResources();
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getDisplayMetrics();
      if (localObject != null) {
        int i = ((DisplayMetrics)localObject).widthPixels;
      }
    }
    bf.getStatusBarHeight(this.mJe.getContext());
    if (!isLandscape())
    {
      localObject = this.CZp.getLayoutParams();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(354862);
        throw paramView;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).topMargin = (arrayOfInt[1] + paramView.getHeight());
      this.CZp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      Log.i(this.TAG, "previewEntranceLoc[1]:%d, preview.height:%d, topMargin:%d", new Object[] { Integer.valueOf(arrayOfInt[1]), Integer.valueOf(paramView.getHeight()), Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
      if (this.CZr == null) {
        this.CZr = paramView;
      }
    }
    AppMethodBeat.o(354862);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(354844);
    super.pause();
    f localf = this.CZp.vFn;
    if (localf != null) {
      localf.pause();
    }
    AppMethodBeat.o(354844);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(354851);
    super.resume();
    f localf = this.CZp.vFn;
    if (localf != null) {
      localf.resume();
    }
    AppMethodBeat.o(354851);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354805);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354805);
      return;
      eoD();
      AppMethodBeat.o(354805);
      return;
      AppMethodBeat.o(354805);
      return;
      rn(true);
      AppMethodBeat.o(354805);
      return;
      rn(false);
      AppMethodBeat.o(354805);
      return;
      if (this.CZr != null)
      {
        paramc = this.CZr;
        s.checkNotNull(paramc);
        fY(paramc);
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354839);
    if ((!((e)business(e.class)).isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((ap)localObject).at((View)this.CZp, paramInt);
        AppMethodBeat.o(354839);
      }
    }
    else
    {
      super.tO(paramInt);
    }
    AppMethodBeat.o(354839);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354857);
    super.unMount();
    com.tencent.mm.plugin.finder.live.model.frameset.c localc = this.CZh;
    if (localc != null) {
      localc.unMount();
    }
    this.CZr = null;
    AppMethodBeat.o(354857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ar
 * JD-Core Version:    0.7.0.1
 */