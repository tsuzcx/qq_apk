package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout
  extends FrameLayout
{
  private TypedValue aje;
  private TypedValue ajf;
  private TypedValue ajg;
  private TypedValue ajh;
  private TypedValue aji;
  private TypedValue ajj;
  private final Rect ajk = new Rect();
  private a ajl;
  
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
  }
  
  public final void g(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (this.aji == null) {
      this.aji = new TypedValue();
    }
    return this.aji;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.ajj == null) {
      this.ajj = new TypedValue();
    }
    return this.ajj;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.ajg == null) {
      this.ajg = new TypedValue();
    }
    return this.ajg;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.ajh == null) {
      this.ajh = new TypedValue();
    }
    return this.ajh;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.aje == null) {
      this.aje = new TypedValue();
    }
    return this.aje;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.ajf == null) {
      this.ajf = new TypedValue();
    }
    return this.ajf;
  }
  
  public final void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ajk.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (t.ay(this)) {
      requestLayout();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.ajl != null) {
      this.ajl.onDetachedFromWindow();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = 0;
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int j;
    int i1;
    int i2;
    TypedValue localTypedValue;
    label61:
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      j = 1;
      i1 = View.MeasureSpec.getMode(paramInt1);
      i2 = View.MeasureSpec.getMode(paramInt2);
      if (i1 != -2147483648) {
        break label495;
      }
      if (j == 0) {
        break label353;
      }
      localTypedValue = this.ajh;
      if ((localTypedValue == null) || (localTypedValue.type == 0)) {
        break label495;
      }
      if (localTypedValue.type != 5) {
        break label362;
      }
      i = (int)localTypedValue.getDimension(localDisplayMetrics);
    }
    for (;;)
    {
      label92:
      int m;
      int k;
      if (i > 0)
      {
        m = View.MeasureSpec.makeMeasureSpec(Math.min(i - (this.ajk.left + this.ajk.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
        k = 1;
      }
      for (;;)
      {
        i = paramInt2;
        if (i2 == -2147483648)
        {
          if (j == 0) {
            break label394;
          }
          localTypedValue = this.aji;
          label150:
          i = paramInt2;
          if (localTypedValue != null)
          {
            i = paramInt2;
            if (localTypedValue.type != 0)
            {
              if (localTypedValue.type != 5) {
                break label403;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
        }
        for (;;)
        {
          label185:
          i = paramInt2;
          if (paramInt1 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (this.ajk.top + this.ajk.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
          super.onMeasure(m, i);
          i2 = getMeasuredWidth();
          m = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
          if ((k == 0) && (i1 == -2147483648)) {
            if (j != 0)
            {
              localTypedValue = this.ajf;
              label266:
              if ((localTypedValue == null) || (localTypedValue.type == 0)) {
                break label476;
              }
              if (localTypedValue.type != 5) {
                break label444;
              }
              paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
            }
          }
          for (;;)
          {
            label297:
            paramInt2 = paramInt1;
            if (paramInt1 > 0) {
              paramInt2 = paramInt1 - (this.ajk.left + this.ajk.right);
            }
            if (i2 < paramInt2) {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            }
            for (paramInt2 = 1;; paramInt2 = n)
            {
              if (paramInt2 != 0) {
                super.onMeasure(paramInt1, i);
              }
              return;
              j = 0;
              break;
              label353:
              localTypedValue = this.ajg;
              break label61;
              label362:
              if (localTypedValue.type != 6) {
                break label504;
              }
              i = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label92;
              label394:
              localTypedValue = this.ajj;
              break label150;
              label403:
              if (localTypedValue.type != 6) {
                break label490;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              break label185;
              localTypedValue = this.aje;
              break label266;
              label444:
              if (localTypedValue.type != 6) {
                break label485;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label297;
              label476:
              paramInt1 = m;
            }
            label485:
            paramInt1 = 0;
          }
          label490:
          paramInt1 = 0;
        }
        label495:
        k = 0;
        m = paramInt1;
      }
      label504:
      i = 0;
    }
  }
  
  public void setAttachListener(a parama)
  {
    this.ajl = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ContentFrameLayout
 * JD-Core Version:    0.7.0.1
 */