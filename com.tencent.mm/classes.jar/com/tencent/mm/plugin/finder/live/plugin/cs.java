package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curBgmPlayingId", "", "curPlayStatus", "canClearScreen", "", "checkBgmPlayStatus", "", "newMusicId", "playStatus", "unMount", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cs
  extends b
{
  public int DmD;
  public int DmE;
  public final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public cs(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354661);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveVisitorMusicPlugin";
    paramViewGroup.setOnClickListener(new cs..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(354661);
  }
  
  private static final void a(cs paramcs, View paramView)
  {
    AppMethodBeat.i(354674);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcs);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcs, "this$0");
    paramView = new Bundle();
    paramView.putInt("PARAM_LIVE_BGM_ID", paramcs.DmD);
    paramcs.nfT.statusChange(b.c.neT, paramView);
    k.Doi.Pm(q.bb.DAv.type);
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354674);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354702);
    super.unMount();
    this.DmD = 0;
    this.DmE = 0;
    AppMethodBeat.o(354702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cs
 * JD-Core Version:    0.7.0.1
 */