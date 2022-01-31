package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class ab
{
  public final Object Hp;
  
  private ab(Object paramObject)
  {
    this.Hp = paramObject;
  }
  
  static ab E(Object paramObject)
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
    return paramab.Hp;
  }
  
  public final ab dK()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.Hp).consumeSystemWindowInsets());
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
      paramObject = (ab)paramObject;
      if (this.Hp != null) {
        break;
      }
    } while (paramObject.Hp == null);
    return false;
    return this.Hp.equals(paramObject.Hp);
  }
  
  public final ab f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new ab(((WindowInsets)this.Hp).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Hp).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Hp).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Hp).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.Hp).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.Hp == null) {
      return 0;
    }
    return this.Hp.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.Hp).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.ab
 * JD-Core Version:    0.7.0.1
 */