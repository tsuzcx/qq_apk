package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FitWindowsLinearLayout
  extends LinearLayout
  implements q
{
  private q.a tw;
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(199726);
    if (this.tw != null) {
      this.tw.e(paramRect);
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(199726);
    return bool;
  }
  
  public void setOnFitSystemWindowsListener(q.a parama)
  {
    this.tw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.FitWindowsLinearLayout
 * JD-Core Version:    0.7.0.1
 */