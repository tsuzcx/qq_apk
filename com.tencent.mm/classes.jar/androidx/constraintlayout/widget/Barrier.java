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
  private int bkF;
  private int bkG;
  b bkH;
  
  public Barrier(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194139);
    super.setVisibility(8);
    AppMethodBeat.o(194139);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194146);
    super.setVisibility(8);
    AppMethodBeat.o(194146);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194152);
    super.setVisibility(8);
    AppMethodBeat.o(194152);
  }
  
  protected final void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194177);
    super.f(paramAttributeSet);
    this.bkH = new b();
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
            this.bkH.bhk = paramAttributeSet.getBoolean(k, true);
          }
        }
      }
    }
    this.bkK = this.bkH;
    Dh();
    AppMethodBeat.o(194177);
  }
  
  public int getType()
  {
    return this.bkF;
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean)
  {
    this.bkH.bhk = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(194165);
    this.bkF = paramInt;
    this.bkG = paramInt;
    if (Build.VERSION.SDK_INT < 17) {
      if (this.bkF == 5) {
        this.bkG = 0;
      }
    }
    for (;;)
    {
      this.bkH.bhi = this.bkG;
      AppMethodBeat.o(194165);
      return;
      if (this.bkF == 6)
      {
        this.bkG = 1;
        continue;
        if (1 == getResources().getConfiguration().getLayoutDirection()) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt != 0)
          {
            if (this.bkF == 5)
            {
              this.bkG = 1;
              break;
              paramInt = 0;
              continue;
            }
            if (this.bkF != 6) {
              break;
            }
            this.bkG = 0;
            break;
          }
        }
        if (this.bkF == 5) {
          this.bkG = 0;
        } else if (this.bkF == 6) {
          this.bkG = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.widget.Barrier
 * JD-Core Version:    0.7.0.1
 */