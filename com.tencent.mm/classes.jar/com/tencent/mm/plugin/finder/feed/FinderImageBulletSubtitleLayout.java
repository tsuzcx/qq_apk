package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderImageBulletSubtitleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "bindData", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "tabType", "getFunctionSwitch", "", "isStartLoop", "onAttach", "onDetach", "onDetachedFromWindow", "pause", "refreshData", "reset", "resume", "setBulletSubtitleAlpha", "alpha", "", "startLoop", "switchFunction", "isTurnOn", "plugin-finder_release"})
public final class FinderImageBulletSubtitleLayout
  extends FrameLayout
{
  public e tOr;
  public d tOs;
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243893);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.tOs = new d(paramContext);
    this.tOr = new e((View)this, this.tOs);
    AppMethodBeat.o(243893);
  }
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(243894);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.tOs = new d(paramContext);
    this.tOr = new e((View)this, this.tOs);
    AppMethodBeat.o(243894);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(243890);
    boolean bool = this.tOr.getFunctionSwitch();
    AppMethodBeat.o(243890);
    return bool;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(243892);
    super.onDetachedFromWindow();
    this.tOs.onDetach();
    AppMethodBeat.o(243892);
  }
  
  public final void setBulletSubtitleAlpha(float paramFloat)
  {
    AppMethodBeat.i(243891);
    this.tOr.dcy().setAlpha(paramFloat);
    AppMethodBeat.o(243891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout
 * JD-Core Version:    0.7.0.1
 */