package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class ab
{
  public final Object On;
  
  private ab(Object paramObject)
  {
    this.On = paramObject;
  }
  
  static ab D(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new ab(paramObject);
  }
  
  static Object c(ab paramab)
  {
    if (paramab == null) {
      return null;
    }
    return paramab.On;
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
      paramObject = (ab)paramObject;
      if (this.On != null) {
        break;
      }
    } while (paramObject.On == null);
    return false;
    return this.On.equals(paramObject.On);
  }
  
  public final ab f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.On).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final ab fc()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.On).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.On).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.On).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.On).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.On).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.On == null) {
      return 0;
    }
    return this.On.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.On).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.ab
 * JD-Core Version:    0.7.0.1
 */