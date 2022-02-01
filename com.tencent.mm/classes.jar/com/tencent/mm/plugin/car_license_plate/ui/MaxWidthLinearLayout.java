package com.tencent.mm.plugin.car_license_plate.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/MaxWidthLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maxWidthPixels", "getMaxWidthPixels", "()I", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaxWidthLinearLayout
  extends LinearLayout
{
  private final int wdv = 1073741823;
  
  public MaxWidthLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MaxWidthLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final int getMaxWidthPixels()
  {
    return this.wdv;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277680);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.wdv, -2147483648), paramInt2);
    AppMethodBeat.o(277680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.MaxWidthLinearLayout
 * JD-Core Version:    0.7.0.1
 */