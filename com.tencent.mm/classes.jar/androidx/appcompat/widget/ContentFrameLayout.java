package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentFrameLayout
  extends FrameLayout
{
  private TypedValue rV;
  private TypedValue rW;
  private TypedValue rX;
  private TypedValue rY;
  private TypedValue rZ;
  private TypedValue sa;
  private final Rect sc;
  private a sd;
  
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
    AppMethodBeat.i(241198);
    this.sc = new Rect();
    AppMethodBeat.o(241198);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241205);
    this.sc.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (w.ah(this)) {
      requestLayout();
    }
    AppMethodBeat.o(241205);
  }
  
  public final void b(Rect paramRect)
  {
    AppMethodBeat.i(241202);
    fitSystemWindows(paramRect);
    AppMethodBeat.o(241202);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    AppMethodBeat.i(241218);
    if (this.rZ == null) {
      this.rZ = new TypedValue();
    }
    TypedValue localTypedValue = this.rZ;
    AppMethodBeat.o(241218);
    return localTypedValue;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    AppMethodBeat.i(241223);
    if (this.sa == null) {
      this.sa = new TypedValue();
    }
    TypedValue localTypedValue = this.sa;
    AppMethodBeat.o(241223);
    return localTypedValue;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    AppMethodBeat.i(241214);
    if (this.rX == null) {
      this.rX = new TypedValue();
    }
    TypedValue localTypedValue = this.rX;
    AppMethodBeat.o(241214);
    return localTypedValue;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    AppMethodBeat.i(241215);
    if (this.rY == null) {
      this.rY = new TypedValue();
    }
    TypedValue localTypedValue = this.rY;
    AppMethodBeat.o(241215);
    return localTypedValue;
  }
  
  public TypedValue getMinWidthMajor()
  {
    AppMethodBeat.i(241211);
    if (this.rV == null) {
      this.rV = new TypedValue();
    }
    TypedValue localTypedValue = this.rV;
    AppMethodBeat.o(241211);
    return localTypedValue;
  }
  
  public TypedValue getMinWidthMinor()
  {
    AppMethodBeat.i(241213);
    if (this.rW == null) {
      this.rW = new TypedValue();
    }
    TypedValue localTypedValue = this.rW;
    AppMethodBeat.o(241213);
    return localTypedValue;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(241226);
    super.onAttachedToWindow();
    AppMethodBeat.o(241226);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(241229);
    super.onDetachedFromWindow();
    if (this.sd != null) {
      this.sd.onDetachedFromWindow();
    }
    AppMethodBeat.o(241229);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = 0;
    AppMethodBeat.i(241208);
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
      localTypedValue = this.rY;
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
        m = View.MeasureSpec.makeMeasureSpec(Math.min(i - (this.sc.left + this.sc.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
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
          localTypedValue = this.rZ;
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
            i = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (this.sc.top + this.sc.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
          super.onMeasure(m, i);
          i2 = getMeasuredWidth();
          m = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
          if ((k == 0) && (i1 == -2147483648)) {
            if (j != 0)
            {
              localTypedValue = this.rW;
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
              paramInt2 = paramInt1 - (this.sc.left + this.sc.right);
            }
            if (i2 < paramInt2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            for (paramInt2 = 1;; paramInt2 = n)
            {
              if (paramInt2 != 0) {
                super.onMeasure(paramInt1, i);
              }
              AppMethodBeat.o(241208);
              return;
              j = 0;
              break;
              label363:
              localTypedValue = this.rX;
              break label66;
              label372:
              if (localTypedValue.type != 6) {
                break label514;
              }
              i = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label97;
              label404:
              localTypedValue = this.sa;
              break label155;
              label413:
              if (localTypedValue.type != 6) {
                break label500;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              break label190;
              localTypedValue = this.rV;
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
    this.sd = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ContentFrameLayout
 * JD-Core Version:    0.7.0.1
 */