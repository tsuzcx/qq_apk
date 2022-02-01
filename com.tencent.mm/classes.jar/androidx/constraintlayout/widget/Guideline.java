package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Guideline
  extends View
{
  public Guideline(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194166);
    super.setVisibility(8);
    AppMethodBeat.o(194166);
  }
  
  public Guideline(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194182);
    super.setVisibility(8);
    AppMethodBeat.o(194182);
  }
  
  public Guideline(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194191);
    super.setVisibility(8);
    AppMethodBeat.o(194191);
  }
  
  public void draw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194210);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(194210);
  }
  
  public void setGuidelineBegin(int paramInt)
  {
    AppMethodBeat.i(194218);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bld = paramInt;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194218);
  }
  
  public void setGuidelineEnd(int paramInt)
  {
    AppMethodBeat.i(194229);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.ble = paramInt;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194229);
  }
  
  public void setGuidelinePercent(float paramFloat)
  {
    AppMethodBeat.i(194243);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.blf = paramFloat;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194243);
  }
  
  public void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.constraintlayout.widget.Guideline
 * JD-Core Version:    0.7.0.1
 */