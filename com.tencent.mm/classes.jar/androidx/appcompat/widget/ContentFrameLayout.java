package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentFrameLayout
  extends FrameLayout
{
  private TypedValue sU;
  private TypedValue sV;
  private TypedValue sW;
  private TypedValue sX;
  private TypedValue sY;
  private TypedValue sZ;
  private final Rect ta;
  private a tb;
  
  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199449);
    this.ta = new Rect();
    AppMethodBeat.o(199449);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199492);
    this.ta.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (z.au(this)) {
      requestLayout();
    }
    AppMethodBeat.o(199492);
  }
  
  public final void f(Rect paramRect)
  {
    AppMethodBeat.i(199464);
    fitSystemWindows(paramRect);
    AppMethodBeat.o(199464);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    AppMethodBeat.i(199605);
    if (this.sY == null) {
      this.sY = new TypedValue();
    }
    TypedValue localTypedValue = this.sY;
    AppMethodBeat.o(199605);
    return localTypedValue;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    AppMethodBeat.i(199619);
    if (this.sZ == null) {
      this.sZ = new TypedValue();
    }
    TypedValue localTypedValue = this.sZ;
    AppMethodBeat.o(199619);
    return localTypedValue;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    AppMethodBeat.i(199573);
    if (this.sW == null) {
      this.sW = new TypedValue();
    }
    TypedValue localTypedValue = this.sW;
    AppMethodBeat.o(199573);
    return localTypedValue;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    AppMethodBeat.i(199587);
    if (this.sX == null) {
      this.sX = new TypedValue();
    }
    TypedValue localTypedValue = this.sX;
    AppMethodBeat.o(199587);
    return localTypedValue;
  }
  
  public TypedValue getMinWidthMajor()
  {
    AppMethodBeat.i(199544);
    if (this.sU == null) {
      this.sU = new TypedValue();
    }
    TypedValue localTypedValue = this.sU;
    AppMethodBeat.o(199544);
    return localTypedValue;
  }
  
  public TypedValue getMinWidthMinor()
  {
    AppMethodBeat.i(199559);
    if (this.sV == null) {
      this.sV = new TypedValue();
    }
    TypedValue localTypedValue = this.sV;
    AppMethodBeat.o(199559);
    return localTypedValue;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(199639);
    super.onAttachedToWindow();
    AppMethodBeat.o(199639);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(199654);
    super.onDetachedFromWindow();
    if (this.tb != null) {
      this.tb.onDetachedFromWindow();
    }
    AppMethodBeat.o(199654);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = 0;
    AppMethodBeat.i(199527);
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int j;
    int i1;
    int i2;
    TypedValue localTypedValue;
    label66:
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      j = 1;
      i1 = View.MeasureSpec.getMode(paramInt1);
      i2 = View.MeasureSpec.getMode(paramInt2);
      if (i1 != -2147483648) {
        break label505;
      }
      if (j == 0) {
        break label363;
      }
      localTypedValue = this.sX;
      if ((localTypedValue == null) || (localTypedValue.type == 0)) {
        break label505;
      }
      if (localTypedValue.type != 5) {
        break label372;
      }
      i = (int)localTypedValue.getDimension(localDisplayMetrics);
    }
    for (;;)
    {
      label97:
      int m;
      int k;
      if (i > 0)
      {
        m = View.MeasureSpec.makeMeasureSpec(Math.min(i - (this.ta.left + this.ta.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
        k = 1;
      }
      for (;;)
      {
        i = paramInt2;
        if (i2 == -2147483648)
        {
          if (j == 0) {
            break label404;
          }
          localTypedValue = this.sY;
          label155:
          i = paramInt2;
          if (localTypedValue != null)
          {
            i = paramInt2;
            if (localTypedValue.type != 0)
            {
              if (localTypedValue.type != 5) {
                break label413;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
        }
        for (;;)
        {
          label190:
          i = paramInt2;
          if (paramInt1 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (this.ta.top + this.ta.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
          super.onMeasure(m, i);
          i2 = getMeasuredWidth();
          m = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
          if ((k == 0) && (i1 == -2147483648)) {
            if (j != 0)
            {
              localTypedValue = this.sV;
              label271:
              if ((localTypedValue == null) || (localTypedValue.type == 0)) {
                break label486;
              }
              if (localTypedValue.type != 5) {
                break label454;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
          for (;;)
          {
            label302:
            paramInt2 = paramInt1;
            if (paramInt1 > 0) {
              paramInt2 = paramInt1 - (this.ta.left + this.ta.right);
            }
            if (i2 < paramInt2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            for (paramInt2 = 1;; paramInt2 = n)
            {
              if (paramInt2 != 0) {
                super.onMeasure(paramInt1, i);
              }
              AppMethodBeat.o(199527);
              return;
              j = 0;
              break;
              label363:
              localTypedValue = this.sW;
              break label66;
              label372:
              if (localTypedValue.type != 6) {
                break label514;
              }
              i = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label97;
              label404:
              localTypedValue = this.sZ;
              break label155;
              label413:
              if (localTypedValue.type != 6) {
                break label500;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              break label190;
              localTypedValue = this.sU;
              break label271;
              label454:
              if (localTypedValue.type != 6) {
                break label495;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label302;
              label486:
              paramInt1 = m;
            }
            label495:
            paramInt1 = 0;
          }
          label500:
          paramInt1 = 0;
        }
        label505:
        k = 0;
        m = paramInt1;
      }
      label514:
      i = 0;
    }
  }
  
  public void setAttachListener(a parama)
  {
    this.tb = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ContentFrameLayout
 * JD-Core Version:    0.7.0.1
 */