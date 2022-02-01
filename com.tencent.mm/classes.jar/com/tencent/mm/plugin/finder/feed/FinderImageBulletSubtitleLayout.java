package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderImageBulletSubtitleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "bindData", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "tabType", "getFunctionSwitch", "", "isStartLoop", "onAttach", "onDetach", "onDetachedFromWindow", "pause", "refreshData", "reset", "resume", "setBulletSubtitleAlpha", "alpha", "", "startLoop", "switchFunction", "isTurnOn", "plugin-finder_release"})
public final class FinderImageBulletSubtitleLayout
  extends FrameLayout
{
  public d seK;
  public c seL;
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202338);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.seL = new c(paramContext);
    this.seK = new d((View)this, this.seL);
    AppMethodBeat.o(202338);
  }
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202339);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.seL = new c(paramContext);
    this.seK = new d((View)this, this.seL);
    AppMethodBeat.o(202339);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(202335);
    boolean bool = this.seK.getFunctionSwitch();
    AppMethodBeat.o(202335);
    return bool;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(202337);
    super.onDetachedFromWindow();
    this.seL.onDetach();
    AppMethodBeat.o(202337);
  }
  
  public final void setBulletSubtitleAlpha(float paramFloat)
  {
    AppMethodBeat.i(202336);
    this.seK.cCI().setAlpha(paramFloat);
    AppMethodBeat.o(202336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout
 * JD-Core Version:    0.7.0.1
 */