package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.constraintlayout.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Barrier
  extends ConstraintHelper
{
  private int Ex;
  private int Ey;
  b Ez;
  
  public Barrier(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194556);
    super.setVisibility(8);
    AppMethodBeat.o(194556);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194558);
    super.setVisibility(8);
    AppMethodBeat.o(194558);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194559);
    super.setVisibility(8);
    AppMethodBeat.o(194559);
  }
  
  protected final void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194571);
    super.f(paramAttributeSet);
    this.Ez = new b();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_barrierDirection) {
          setType(paramAttributeSet.getInt(k, 0));
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
            this.Ez.Bc = paramAttributeSet.getBoolean(k, true);
          }
        }
      }
    }
    this.EC = this.Ez;
    fY();
    AppMethodBeat.o(194571);
  }
  
  public int getType()
  {
    return this.Ex;
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.Ez.Bc = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(194565);
    this.Ex = paramInt;
    this.Ey = paramInt;
    if (Build.VERSION.SDK_INT < 17) {
      if (this.Ex == 5) {
        this.Ey = 0;
      }
    }
    for (;;)
    {
      this.Ez.Ba = this.Ey;
      AppMethodBeat.o(194565);
      return;
      if (this.Ex == 6)
      {
        this.Ey = 1;
        continue;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt != 0)
          {
            if (this.Ex == 5)
            {
              this.Ey = 1;
              break;
              paramInt = 0;
              continue;
            }
            if (this.Ex != 6) {
              break;
            }
            this.Ey = 0;
            break;
          }
        }
        if (this.Ex == 5) {
          this.Ey = 0;
        } else if (this.Ex == 6) {
          this.Ey = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.widget.Barrier
 * JD-Core Version:    0.7.0.1
 */