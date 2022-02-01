package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActivityChooserView$InnerLayout
  extends LinearLayout
{
  private static final int[] na = { 16842964 };
  
  public ActivityChooserView$InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200228);
    paramContext = ac.a(paramContext, paramAttributeSet, na);
    setBackgroundDrawable(paramContext.getDrawable(0));
    paramContext.xv.recycle();
    AppMethodBeat.o(200228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.InnerLayout
 * JD-Core Version:    0.7.0.1
 */