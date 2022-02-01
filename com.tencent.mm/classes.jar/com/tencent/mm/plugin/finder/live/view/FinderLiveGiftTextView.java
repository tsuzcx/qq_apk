package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "WIDTH_BROADEN", "getWIDTH_BROADEN", "()I", "onMeasure", "", "widthSpec", "heightSpec", "plugin-finder_release"})
public final class FinderLiveGiftTextView
  extends AppCompatTextView
{
  private final String TAG;
  private final int yUy;
  
  public FinderLiveGiftTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(285882);
    this.TAG = "Finder.FinderLiveGiftTextView";
    this.yUy = d.e(MMApplicationContext.getContext(), 2.0F);
    AppMethodBeat.o(285882);
  }
  
  public FinderLiveGiftTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(285883);
    this.TAG = "Finder.FinderLiveGiftTextView";
    this.yUy = d.e(MMApplicationContext.getContext(), 2.0F);
    AppMethodBeat.o(285883);
  }
  
  public final int getWIDTH_BROADEN()
  {
    return this.yUy;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285881);
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredWidth();
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int j = getMeasuredHeight();
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i + this.yUy, paramInt1), View.MeasureSpec.makeMeasureSpec(j, paramInt2));
    AppMethodBeat.o(285881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView
 * JD-Core Version:    0.7.0.1
 */