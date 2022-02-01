package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class Space
  extends View
{
  @Deprecated
  public Space(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @Deprecated
  public Space(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @Deprecated
  public Space(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192922);
    if (getVisibility() == 0) {
      setVisibility(4);
    }
    AppMethodBeat.o(192922);
  }
  
  private static int aP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192951);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      AppMethodBeat.o(192951);
      return paramInt2;
      paramInt2 = Math.min(paramInt1, i);
      continue;
      paramInt2 = i;
    }
  }
  
  @Deprecated
  public void draw(Canvas paramCanvas) {}
  
  @Deprecated
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192970);
    setMeasuredDimension(aP(getSuggestedMinimumWidth(), paramInt1), aP(getSuggestedMinimumHeight(), paramInt2));
    AppMethodBeat.o(192970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.legacy.widget.Space
 * JD-Core Version:    0.7.0.1
 */