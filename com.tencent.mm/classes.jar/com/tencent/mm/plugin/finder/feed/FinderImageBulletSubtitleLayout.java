package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderImageBulletSubtitleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "bindData", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "tabType", "getFunctionSwitch", "", "isStartLoop", "onAttach", "onDetach", "onDetachedFromWindow", "pause", "refreshData", "reset", "resume", "setBulletSubtitleAlpha", "alpha", "", "startLoop", "switchFunction", "isTurnOn", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderImageBulletSubtitleLayout
  extends FrameLayout
{
  private e AWe;
  private d AWf;
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(363682);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.AWf = new d(paramContext);
    this.AWe = new e((View)this, this.AWf);
    AppMethodBeat.o(363682);
  }
  
  public FinderImageBulletSubtitleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(363687);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.AWf = new d(paramContext);
    this.AWe = new e((View)this, this.AWf);
    AppMethodBeat.o(363687);
  }
  
  public final boolean getFunctionSwitch()
  {
    AppMethodBeat.i(363695);
    boolean bool = this.AWe.getFunctionSwitch();
    AppMethodBeat.o(363695);
    return bool;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(363709);
    super.onDetachedFromWindow();
    this.AWf.onDetach();
    AppMethodBeat.o(363709);
  }
  
  public final void setBulletSubtitleAlpha(float paramFloat)
  {
    AppMethodBeat.i(363704);
    this.AWe.ebQ().setAlpha(paramFloat);
    AppMethodBeat.o(363704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout
 * JD-Core Version:    0.7.0.1
 */