package androidx.legacy.widget;

import android.annotation.SuppressLint;
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
    AppMethodBeat.i(186196);
    if (getVisibility() == 0) {
      setVisibility(4);
    }
    AppMethodBeat.o(186196);
  }
  
  private static int U(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186214);
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
      AppMethodBeat.o(186214);
      return paramInt2;
      paramInt2 = Math.min(paramInt1, i);
      continue;
      paramInt2 = i;
    }
  }
  
  @Deprecated
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  @Deprecated
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186216);
    setMeasuredDimension(U(getSuggestedMinimumWidth(), paramInt1), U(getSuggestedMinimumHeight(), paramInt2));
    AppMethodBeat.o(186216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.legacy.widget.Space
 * JD-Core Version:    0.7.0.1
 */