package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class l
{
  private ViewParent NT;
  private ViewParent NU;
  public boolean NV;
  private int[] NW;
  private final View mView;
  
  public l(View paramView)
  {
    this.mView = paramView;
  }
  
  private void a(int paramInt, ViewParent paramViewParent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.NT = paramViewParent;
      return;
    }
    this.NU = paramViewParent;
  }
  
  private ViewParent aO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.NT;
    }
    return this.NU;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    ViewParent localViewParent;
    int j;
    int i;
    if (this.NV)
    {
      localViewParent = aO(paramInt5);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0))
      {
        if (paramArrayOfInt == null) {
          break label136;
        }
        this.mView.getLocationInWindow(paramArrayOfInt);
        j = paramArrayOfInt[0];
        i = paramArrayOfInt[1];
      }
    }
    for (;;)
    {
      w.a(localViewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      if (paramArrayOfInt != null)
      {
        this.mView.getLocationInWindow(paramArrayOfInt);
        paramArrayOfInt[0] -= j;
        paramArrayOfInt[1] -= i;
      }
      return true;
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
      }
      return false;
      label136:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    ViewParent localViewParent;
    int j;
    int i;
    if (this.NV)
    {
      localViewParent = aO(paramInt3);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramArrayOfInt2 == null) {
          break label173;
        }
        this.mView.getLocationInWindow(paramArrayOfInt2);
        j = paramArrayOfInt2[0];
        i = paramArrayOfInt2[1];
      }
    }
    for (;;)
    {
      if (paramArrayOfInt1 == null)
      {
        if (this.NW == null) {
          this.NW = new int[2];
        }
        paramArrayOfInt1 = this.NW;
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        w.a(localViewParent, this.mView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= j;
          paramArrayOfInt2[1] -= i;
        }
        return (paramArrayOfInt1[0] != 0) || (paramArrayOfInt1[1] != 0);
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        return false;
      }
      label173:
      i = 0;
      j = 0;
    }
  }
  
  public final void aM(int paramInt)
  {
    ViewParent localViewParent = aO(paramInt);
    View localView;
    if (localViewParent != null)
    {
      localView = this.mView;
      if (!(localViewParent instanceof n)) {
        break label40;
      }
      ((n)localViewParent).j(localView, paramInt);
    }
    for (;;)
    {
      a(paramInt, null);
      return;
      label40:
      if (paramInt == 0) {
        if (Build.VERSION.SDK_INT >= 21) {
          try
          {
            localViewParent.onStopNestedScroll(localView);
          }
          catch (AbstractMethodError localAbstractMethodError)
          {
            new StringBuilder("ViewParent ").append(localViewParent).append(" does not implement interface method onStopNestedScroll");
          }
        } else if ((localViewParent instanceof m)) {
          ((m)localViewParent).onStopNestedScroll(localAbstractMethodError);
        }
      }
    }
  }
  
  public final boolean aN(int paramInt)
  {
    return aO(paramInt) != null;
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.NV)
    {
      ViewParent localViewParent = aO(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = w.a(localViewParent, this.mView, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return bool1;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.NV)
    {
      ViewParent localViewParent = aO(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = w.a(localViewParent, this.mView, paramFloat1, paramFloat2);
      }
    }
    return bool1;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0);
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    if (this.NV) {
      t.aw(this.mView);
    }
    this.NV = paramBoolean;
  }
  
  public final boolean t(int paramInt1, int paramInt2)
  {
    if (aN(paramInt2)) {
      return true;
    }
    if (this.NV)
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView1 = this.mView;
      while (localViewParent != null)
      {
        if (w.a(localViewParent, localView1, this.mView, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          View localView3 = this.mView;
          if ((localViewParent instanceof n)) {
            ((n)localViewParent).b(localView1, localView3, paramInt1, paramInt2);
          }
          for (;;)
          {
            return true;
            if (paramInt2 == 0) {
              if (Build.VERSION.SDK_INT >= 21) {
                try
                {
                  localViewParent.onNestedScrollAccepted(localView1, localView3, paramInt1);
                }
                catch (AbstractMethodError localAbstractMethodError)
                {
                  new StringBuilder("ViewParent ").append(localViewParent).append(" does not implement interface method onNestedScrollAccepted");
                }
              } else if ((localViewParent instanceof m)) {
                ((m)localViewParent).onNestedScrollAccepted(localAbstractMethodError, localView3, paramInt1);
              }
            }
          }
        }
        if ((localViewParent instanceof View)) {
          View localView2 = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.l
 * JD-Core Version:    0.7.0.1
 */