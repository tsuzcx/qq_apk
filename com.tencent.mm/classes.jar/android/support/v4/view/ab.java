package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class ab
{
  public final Object QZ;
  
  private ab(Object paramObject)
  {
    this.QZ = paramObject;
  }
  
  static ab G(Object paramObject)
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
    return paramab.QZ;
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
      if (this.QZ != null) {
        break;
      }
    } while (paramObject.QZ == null);
    return false;
    return this.QZ.equals(paramObject.QZ);
  }
  
  public final ab f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.QZ).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final ab fB()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.QZ).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.QZ).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.QZ).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.QZ).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.QZ).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.QZ == null) {
      return 0;
    }
    return this.QZ.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.QZ).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.ab
 * JD-Core Version:    0.7.0.1
 */