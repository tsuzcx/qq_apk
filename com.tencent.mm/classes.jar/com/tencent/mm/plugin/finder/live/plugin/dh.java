package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ap;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curBgmPlayingId", "", "curPlayStatus", "canClearScreen", "", "checkBgmPlayStatus", "", "newMusicId", "playStatus", "unMount", "plugin-finder_release"})
public final class dh
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private int yzH;
  private int yzI;
  
  public dh(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(280377);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveVisitorMusicPlugin";
    paramViewGroup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(271942);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("PARAM_LIVE_BGM_ID", dh.a(this.yzJ));
        dh.d(this.yzJ).statusChange(b.c.kBs, paramAnonymousView);
        m.yCt.NG(s.ap.yJy.type);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorMusicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271942);
      }
    });
    AppMethodBeat.o(280377);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(280376);
    super.unMount();
    this.yzH = 0;
    this.yzI = 0;
    AppMethodBeat.o(280376);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(dh paramdh, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.dh
 * JD-Core Version:    0.7.0.1
 */