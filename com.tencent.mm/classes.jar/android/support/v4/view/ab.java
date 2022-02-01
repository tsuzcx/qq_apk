package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class ab
{
  public final Object Pk;
  
  private ab(Object paramObject)
  {
    this.Pk = paramObject;
  }
  
  static ab F(Object paramObject)
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
    return paramab.Pk;
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
      if (this.Pk != null) {
        break;
      }
    } while (paramObject.Pk == null);
    return false;
    return this.Pk.equals(paramObject.Pk);
  }
  
  public final ab f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.Pk).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final ab fk()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.Pk).consumeSystemWindowInsets());
    }
    return null;
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Pk).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Pk).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Pk).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Pk).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.Pk == null) {
      return 0;
    }
    return this.Pk.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.Pk).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.ab
 * JD-Core Version:    0.7.0.1
 */