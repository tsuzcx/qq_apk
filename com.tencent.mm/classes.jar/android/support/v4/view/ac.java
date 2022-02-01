package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class ac
{
  public final Object Rm;
  
  private ac(Object paramObject)
  {
    this.Rm = paramObject;
  }
  
  static ac G(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new ac(paramObject);
  }
  
  static Object c(ac paramac)
  {
    if (paramac == null) {
      return null;
    }
    return paramac.Rm;
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
      paramObject = (ac)paramObject;
      if (this.Rm != null) {
        break;
      }
    } while (paramObject.Rm == null);
    return false;
    return this.Rm.equals(paramObject.Rm);
  }
  
  public final ac f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ac(((WindowInsets)this.Rm).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final ac fI()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ac(((WindowInsets)this.Rm).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Rm).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Rm).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Rm).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Rm).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.Rm == null) {
      return 0;
    }
    return this.Rm.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.Rm).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.ac
 * JD-Core Version:    0.7.0.1
 */