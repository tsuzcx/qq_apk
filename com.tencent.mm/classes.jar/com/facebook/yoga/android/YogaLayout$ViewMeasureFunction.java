package com.facebook.yoga.android;

import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaLayout$ViewMeasureFunction
  implements YogaMeasureFunction
{
  private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode paramYogaMeasureMode)
  {
    if (paramYogaMeasureMode == YogaMeasureMode.AT_MOST) {
      return -2147483648;
    }
    if (paramYogaMeasureMode == YogaMeasureMode.EXACTLY) {
      return 1073741824;
    }
    return 0;
  }
  
  public long measure(YogaNode paramYogaNode, float paramFloat1, YogaMeasureMode paramYogaMeasureMode1, float paramFloat2, YogaMeasureMode paramYogaMeasureMode2)
  {
    AppMethodBeat.i(18236);
    paramYogaNode = (View)paramYogaNode.getData();
    if ((paramYogaNode == null) || ((paramYogaNode instanceof YogaLayout)))
    {
      l = YogaMeasureOutput.make(0, 0);
      AppMethodBeat.o(18236);
      return l;
    }
    paramYogaNode.measure(View.MeasureSpec.makeMeasureSpec((int)paramFloat1, viewMeasureSpecFromYogaMeasureMode(paramYogaMeasureMode1)), View.MeasureSpec.makeMeasureSpec((int)paramFloat2, viewMeasureSpecFromYogaMeasureMode(paramYogaMeasureMode2)));
    long l = YogaMeasureOutput.make(paramYogaNode.getMeasuredWidth(), paramYogaNode.getMeasuredHeight());
    AppMethodBeat.o(18236);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.android.YogaLayout.ViewMeasureFunction
 * JD-Core Version:    0.7.0.1
 */