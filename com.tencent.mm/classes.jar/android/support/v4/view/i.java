package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class i
{
  private ViewParent Fn;
  private ViewParent Fo;
  public boolean Fp;
  private int[] Fq;
  private final View mView;
  
  public i(View paramView)
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
      this.Fn = paramViewParent;
      return;
    }
    this.Fo = paramViewParent;
  }
  
  private ViewParent aw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.Fn;
    }
    return this.Fo;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    ViewParent localViewParent;
    int j;
    int i;
    if (this.Fp)
    {
      localViewParent = aw(paramInt5);
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
      t.a(localViewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
    if (this.Fp)
    {
      localViewParent = aw(paramInt3);
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
        if (this.Fq == null) {
          this.Fq = new int[2];
        }
        paramArrayOfInt1 = this.Fq;
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        t.a(localViewParent, this.mView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
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
  
  public final boolean au(int paramInt)
  {
    return aw(paramInt) != null;
  }
  
  public final void av(int paramInt)
  {
    ViewParent localViewParent = aw(paramInt);
    if (localViewParent != null)
    {
      t.a(localViewParent, this.mView, paramInt);
      a(paramInt, null);
    }
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Fp)
    {
      ViewParent localViewParent = aw(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = t.a(localViewParent, this.mView, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return bool1;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Fp)
    {
      ViewParent localViewParent = aw(0);
      bool1 = bool2;
      if (localViewParent != null) {
        bool1 = t.a(localViewParent, this.mView, paramFloat1, paramFloat2);
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
  
  public final boolean r(int paramInt1, int paramInt2)
  {
    if (au(paramInt2)) {
      return true;
    }
    if (this.Fp)
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView = this.mView;
      while (localViewParent != null)
      {
        if (t.a(localViewParent, localView, this.mView, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          t.b(localViewParent, localView, this.mView, paramInt1, paramInt2);
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
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    if (this.Fp) {
      q.ak(this.mView);
    }
    this.Fp = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.i
 * JD-Core Version:    0.7.0.1
 */