package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class l
{
  private ViewParent PW;
  private ViewParent PX;
  public boolean PY;
  private int[] PZ;
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
      this.PW = paramViewParent;
      return;
    }
    this.PX = paramViewParent;
  }
  
  private ViewParent aO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.PW;
    }
    return this.PX;
  }
  
  public final boolean A(int paramInt1, int paramInt2)
  {
    if (aN(paramInt2)) {
      return true;
    }
    if (this.PY)
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView = this.mView;
      while (localViewParent != null)
      {
        if (x.a(localViewParent, localView, this.mView, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          x.b(localViewParent, localView, this.mView, paramInt1, paramInt2);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    ViewParent localViewParent;
    int j;
    int i;
    if (this.PY)
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
      x.a(localViewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
    if (this.PY)
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
        if (this.PZ == null) {
          this.PZ = new int[2];
        }
        paramArrayOfInt1 = this.PZ;
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        x.a(localViewParent, this.mView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
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
    if (localViewParent != null)
    {
      x.a(localViewParent, this.mView, paramInt);
      a(paramInt, null);
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
    if (this.PY)
    {
      ViewParent localViewParent = aO(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = x.a(localViewParent, this.mView, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return bool1;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.PY)
    {
      ViewParent localViewParent = aO(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = x.a(localViewParent, this.mView, paramFloat1, paramFloat2);
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
  
  public final boolean hasNestedScrollingParent()
  {
    return aN(0);
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    return this.PY;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    if (this.PY) {
      u.ax(this.mView);
    }
    this.PY = paramBoolean;
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    return A(paramInt, 0);
  }
  
  public final void stopNestedScroll()
  {
    aM(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.l
 * JD-Core Version:    0.7.0.1
 */