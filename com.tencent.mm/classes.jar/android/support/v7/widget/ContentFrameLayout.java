package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout
  extends FrameLayout
{
  private TypedValue amc;
  private TypedValue amd;
  private TypedValue ame;
  private TypedValue amf;
  private TypedValue amg;
  private TypedValue amh;
  private final Rect ami = new Rect();
  private a amj;
  
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
    if (this.amg == null) {
      this.amg = new TypedValue();
    }
    return this.amg;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.amh == null) {
      this.amh = new TypedValue();
    }
    return this.amh;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.ame == null) {
      this.ame = new TypedValue();
    }
    return this.ame;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.amf == null) {
      this.amf = new TypedValue();
    }
    return this.amf;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.amc == null) {
      this.amc = new TypedValue();
    }
    return this.amc;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.amd == null) {
      this.amd = new TypedValue();
    }
    return this.amd;
  }
  
  public final void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ami.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (u.az(this)) {
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
    if (this.amj != null) {
      this.amj.onDetachedFromWindow();
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
      localTypedValue = this.amf;
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
        m = View.MeasureSpec.makeMeasureSpec(Math.min(i - (this.ami.left + this.ami.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
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
          localTypedValue = this.amg;
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
            i = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (this.ami.top + this.ami.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
          super.onMeasure(m, i);
          i2 = getMeasuredWidth();
          m = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
          if ((k == 0) && (i1 == -2147483648)) {
            if (j != 0)
            {
              localTypedValue = this.amd;
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
              paramInt2 = paramInt1 - (this.ami.left + this.ami.right);
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
              localTypedValue = this.ame;
              break label61;
              label362:
              if (localTypedValue.type != 6) {
                break label504;
              }
              i = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label92;
              label394:
              localTypedValue = this.amh;
              break label150;
              label403:
              if (localTypedValue.type != 6) {
                break label490;
              }
              paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              break label185;
              localTypedValue = this.amc;
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
    this.amj = parama;
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