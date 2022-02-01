package com.tencent.mm.plugin.finder.live.fluent.params;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;", "", "fluentScene", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "feedId", "", "parentView", "Landroid/view/ViewGroup;", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;JLandroid/view/ViewGroup;Lcom/tencent/rtmp/ui/TXCloudVideoView;)V", "getFeedId", "()J", "getFluentScene", "()Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "getParentView", "()Landroid/view/ViewGroup;", "targetRootView", "Landroid/view/View;", "getTargetRootView", "()Landroid/view/View;", "setTargetRootView", "(Landroid/view/View;)V", "getVideoView", "()Lcom/tencent/rtmp/ui/TXCloudVideoView;", "windowSizePoint", "Landroid/graphics/Point;", "getWindowSizePoint", "()Landroid/graphics/Point;", "setWindowSizePoint", "(Landroid/graphics/Point;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final h.a CCA;
  public final TXCloudVideoView CDn;
  public View CDo;
  public Point CDp;
  private final long feedId;
  public final ViewGroup parentView;
  
  public a(h.a parama, long paramLong, ViewGroup paramViewGroup, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(352051);
    this.CCA = parama;
    this.feedId = paramLong;
    this.parentView = paramViewGroup;
    this.CDn = paramTXCloudVideoView;
    AppMethodBeat.o(352051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.params.a
 * JD-Core Version:    0.7.0.1
 */