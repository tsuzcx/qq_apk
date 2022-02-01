package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Group
  extends ConstraintHelper
{
  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void Di()
  {
    AppMethodBeat.i(194186);
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bml.setWidth(0);
    localLayoutParams.bml.setHeight(0);
    AppMethodBeat.o(194186);
  }
  
  public final void a(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194176);
    int j = getVisibility();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (float f = getElevation();; f = 0.0F)
    {
      int i = 0;
      while (i < this.mCount)
      {
        View localView = paramConstraintLayout.dU(this.bkI[i]);
        if (localView != null)
        {
          localView.setVisibility(j);
          if ((f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
            localView.setElevation(f);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(194176);
      return;
    }
  }
  
  protected final void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194159);
    super.f(paramAttributeSet);
    this.bkL = false;
    AppMethodBeat.o(194159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.widget.Group
 * JD-Core Version:    0.7.0.1
 */