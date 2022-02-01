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
    AppMethodBeat.i(194963);
    super.setVisibility(8);
    AppMethodBeat.o(194963);
  }
  
  public Guideline(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194967);
    super.setVisibility(8);
    AppMethodBeat.o(194967);
  }
  
  public Guideline(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194969);
    super.setVisibility(8);
    AppMethodBeat.o(194969);
  }
  
  public void draw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194970);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(194970);
  }
  
  public void setGuidelineBegin(int paramInt)
  {
    AppMethodBeat.i(194971);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.EW = paramInt;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194971);
  }
  
  public void setGuidelineEnd(int paramInt)
  {
    AppMethodBeat.i(194974);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.EX = paramInt;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194974);
  }
  
  public void setGuidelinePercent(float paramFloat)
  {
    AppMethodBeat.i(194976);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.EY = paramFloat;
    setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194976);
  }
  
  public void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.constraintlayout.widget.Guideline
 * JD-Core Version:    0.7.0.1
 */