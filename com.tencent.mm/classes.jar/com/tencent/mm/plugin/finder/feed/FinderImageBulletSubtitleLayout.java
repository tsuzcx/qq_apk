package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderImageBulletSubtitleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "bindData", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "tabType", "getFunctionSwitch", "", "isStartLoop", "onAttach", "onDetach", "onDetachedFromWindow", "pause", "refreshData", "reset", "resume", "setBulletSubtitleAlpha", "alpha", "", "startLoop", "switchFunction", "isTurnOn", "plugin-finder_release"})
public final class FinderImageBulletSubtitleLayout
  extends FrameLayout
{
  public e xyR;
  public d xyS;
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280655);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.xyS = new d(paramContext);
    this.xyR = new e((View)this, this.xyS);
    AppMethodBeat.o(280655);
  }
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280656);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.xyS = new d(paramContext);
    this.xyR = new e((View)this, this.xyS);
    AppMethodBeat.o(280656);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(280650);
    boolean bool = this.xyR.getFunctionSwitch();
    AppMethodBeat.o(280650);
    return bool;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(280653);
    super.onDetachedFromWindow();
    this.xyS.onDetach();
    AppMethodBeat.o(280653);
  }
  
  public final void setBulletSubtitleAlpha(float paramFloat)
  {
    AppMethodBeat.i(280651);
    this.xyR.dsO().setAlpha(paramFloat);
    AppMethodBeat.o(280651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout
 * JD-Core Version:    0.7.0.1
 */