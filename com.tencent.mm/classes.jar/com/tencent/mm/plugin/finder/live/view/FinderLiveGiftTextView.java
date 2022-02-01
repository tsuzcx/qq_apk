package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "WIDTH_BROADEN", "getWIDTH_BROADEN", "()I", "onMeasure", "", "widthSpec", "heightSpec", "plugin-finder_release"})
public final class FinderLiveGiftTextView
  extends AppCompatTextView
{
  private final String TAG;
  private final int uyH;
  
  public FinderLiveGiftTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247460);
    this.TAG = "Finder.FinderLiveGiftTextView";
    this.uyH = d.e(MMApplicationContext.getContext(), 2.0F);
    AppMethodBeat.o(247460);
  }
  
  public FinderLiveGiftTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247461);
    this.TAG = "Finder.FinderLiveGiftTextView";
    this.uyH = d.e(MMApplicationContext.getContext(), 2.0F);
    AppMethodBeat.o(247461);
  }
  
  public final int getWIDTH_BROADEN()
  {
    return this.uyH;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247459);
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredWidth();
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int j = getMeasuredHeight();
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i + this.uyH, paramInt1), View.MeasureSpec.makeMeasureSpec(j, paramInt2));
    AppMethodBeat.o(247459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView
 * JD-Core Version:    0.7.0.1
 */