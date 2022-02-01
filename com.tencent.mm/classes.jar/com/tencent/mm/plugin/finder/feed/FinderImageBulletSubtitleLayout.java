package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderImageBulletSubtitleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "bindData", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "tabType", "getFunctionSwitch", "", "isStartLoop", "onAttach", "onDetach", "onDetachedFromWindow", "pause", "refreshData", "reset", "resume", "setBulletSubtitleAlpha", "alpha", "", "startLoop", "switchFunction", "isTurnOn", "plugin-finder_release"})
public final class FinderImageBulletSubtitleLayout
  extends FrameLayout
{
  public d rWd;
  public c rWe;
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201878);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.rWe = new c(paramContext);
    this.rWd = new d((View)this, this.rWe);
    AppMethodBeat.o(201878);
  }
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201879);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.rWe = new c(paramContext);
    this.rWd = new d((View)this, this.rWe);
    AppMethodBeat.o(201879);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(201875);
    boolean bool = this.rWd.getFunctionSwitch();
    AppMethodBeat.o(201875);
    return bool;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(201877);
    super.onDetachedFromWindow();
    this.rWe.onDetach();
    AppMethodBeat.o(201877);
  }
  
  public final void setBulletSubtitleAlpha(float paramFloat)
  {
    AppMethodBeat.i(201876);
    this.rWd.cAW().setAlpha(paramFloat);
    AppMethodBeat.o(201876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout
 * JD-Core Version:    0.7.0.1
 */