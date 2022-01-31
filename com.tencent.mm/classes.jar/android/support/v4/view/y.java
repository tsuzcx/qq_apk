package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class y
{
  public final Object HI;
  
  private y(Object paramObject)
  {
    this.HI = paramObject;
  }
  
  static y G(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new y(paramObject);
  }
  
  static Object c(y paramy)
  {
    if (paramy == null) {
      return null;
    }
    return paramy.HI;
  }
  
  public final y dv()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new y(((WindowInsets)this.HI).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (y)paramObject;
      if (this.HI != null) {
        break;
      }
    } while (paramObject.HI == null);
    return false;
    return this.HI.equals(paramObject.HI);
  }
  
  public final y f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new y(((WindowInsets)this.HI).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.HI).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.HI).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.HI).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.HI).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.HI == null) {
      return 0;
    }
    return this.HI.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.HI).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.y
 * JD-Core Version:    0.7.0.1
 */