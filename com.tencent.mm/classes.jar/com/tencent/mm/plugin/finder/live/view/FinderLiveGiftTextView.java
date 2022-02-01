package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "WIDTH_BROADEN", "getWIDTH_BROADEN", "()I", "onMeasure", "", "widthSpec", "heightSpec", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGiftTextView
  extends AppCompatTextView
{
  private final int DNP;
  private final String TAG;
  
  public FinderLiveGiftTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(358118);
    this.TAG = "Finder.FinderLiveGiftTextView";
    this.DNP = d.e(MMApplicationContext.getContext(), 2.0F);
    AppMethodBeat.o(358118);
  }
  
  public FinderLiveGiftTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358127);
    this.TAG = "Finder.FinderLiveGiftTextView";
    this.DNP = d.e(MMApplicationContext.getContext(), 2.0F);
    AppMethodBeat.o(358127);
  }
  
  public final int getWIDTH_BROADEN()
  {
    return this.DNP;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358145);
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredWidth();
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int j = getMeasuredHeight();
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(i + this.DNP, paramInt1), View.MeasureSpec.makeMeasureSpec(j, paramInt2));
    AppMethodBeat.o(358145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftTextView
 * JD-Core Version:    0.7.0.1
 */