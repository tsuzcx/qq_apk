package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FitWindowsFrameLayout
  extends FrameLayout
  implements q
{
  private q.a sx;
  
  public FitWindowsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(241287);
    if (this.sx != null) {
      this.sx.a(paramRect);
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(241287);
    return bool;
  }
  
  public void setOnFitSystemWindowsListener(q.a parama)
  {
    this.sx = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.FitWindowsFrameLayout
 * JD-Core Version:    0.7.0.1
 */