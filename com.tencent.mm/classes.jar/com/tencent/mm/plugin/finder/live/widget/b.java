package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.plugin.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "initView", "isVisible", "", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "reportShowMusicPanel", "setVisible", "visible", "", "showMusicPanel", "showMusicPanelImpl", "Companion", "plugin-finder_release"})
public final class b
{
  public static final String zlr = "PORTRAIT_ACTION_GOTO_CREATE_MUSIC";
  public static final a zls;
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  private final d xYq;
  
  static
  {
    AppMethodBeat.i(270899);
    zls = new a((byte)0);
    zlr = "PORTRAIT_ACTION_GOTO_CREATE_MUSIC";
    AppMethodBeat.o(270899);
  }
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(270898);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveAnchoMusicEntranceWidget";
    this.kiF.setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(270898);
  }
  
  public final void dHH()
  {
    AppMethodBeat.i(270896);
    com.tencent.mm.live.c.b.b.a(this.kCL, b.c.kAp);
    AppMethodBeat.o(270896);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(270897);
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(270897);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget$Companion;", "", "()V", "PORTRAIT_ACTION_GOTO_CREATE_MUSIC", "", "getPORTRAIT_ACTION_GOTO_CREATE_MUSIC", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290279);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.zlt);
      b.dHI();
      a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.b
 * JD-Core Version:    0.7.0.1
 */