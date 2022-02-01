package com.tencent.mm.plugin.finder.live.fluent;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchImageParams;", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "fluentScene", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;", "feedId", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "parentView", "Landroid/view/ViewGroup;", "imageView", "Landroid/view/View;", "videoWidth", "", "videoHeight", "videoRatioWH", "", "liveUrl", "", "(Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams$FluentScene;JLandroidx/recyclerview/widget/RecyclerView;Landroid/view/ViewGroup;Landroid/view/View;IIFLjava/lang/String;)V", "getImageView", "()Landroid/view/View;", "getLiveUrl", "()Ljava/lang/String;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends h
{
  public final View CCk;
  public final String CCl;
  private final RecyclerView mkw;
  
  public c(h.a parama, long paramLong, RecyclerView paramRecyclerView, ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2, float paramFloat, String paramString)
  {
    super(parama, paramLong, (View)paramViewGroup, paramInt1, paramInt2, paramFloat, null);
    AppMethodBeat.i(352088);
    this.mkw = paramRecyclerView;
    this.CCk = paramView;
    this.CCl = paramString;
    AppMethodBeat.o(352088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.c
 * JD-Core Version:    0.7.0.1
 */