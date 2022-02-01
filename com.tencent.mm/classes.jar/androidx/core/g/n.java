package androidx.core.g;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private ViewParent Nn;
  private ViewParent No;
  public boolean Np;
  private int[] Nq;
  private final View mView;
  
  public n(View paramView)
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
      this.Nn = paramViewParent;
      return;
    }
    this.No = paramViewParent;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(251504);
    ViewParent localViewParent;
    int j;
    int i;
    if (this.Np)
    {
      localViewParent = by(paramInt5);
      if (localViewParent == null)
      {
        AppMethodBeat.o(251504);
        return false;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramInt3 != 0) || (paramInt4 != 0))
      {
        if (paramArrayOfInt1 == null) {
          break label182;
        }
        this.mView.getLocationInWindow(paramArrayOfInt1);
        j = paramArrayOfInt1[0];
        i = paramArrayOfInt1[1];
      }
    }
    for (;;)
    {
      if (paramArrayOfInt2 == null)
      {
        paramArrayOfInt2 = gW();
        paramArrayOfInt2[0] = 0;
        paramArrayOfInt2[1] = 0;
      }
      for (;;)
      {
        z.a(localViewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfInt2);
        if (paramArrayOfInt1 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt1);
          paramArrayOfInt1[0] -= j;
          paramArrayOfInt1[1] -= i;
        }
        AppMethodBeat.o(251504);
        return true;
        if (paramArrayOfInt1 != null)
        {
          paramArrayOfInt1[0] = 0;
          paramArrayOfInt1[1] = 0;
        }
        AppMethodBeat.o(251504);
        return false;
      }
      label182:
      i = 0;
      j = 0;
    }
  }
  
  private ViewParent by(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.Nn;
    }
    return this.No;
  }
  
  private int[] gW()
  {
    if (this.Nq == null) {
      this.Nq = new int[2];
    }
    return this.Nq;
  }
  
  public final boolean E(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251498);
    if (bx(paramInt2))
    {
      AppMethodBeat.o(251498);
      return true;
    }
    if (this.Np)
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView = this.mView;
      while (localViewParent != null)
      {
        if (z.a(localViewParent, localView, this.mView, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          z.b(localViewParent, localView, this.mView, paramInt1, paramInt2);
          AppMethodBeat.o(251498);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    AppMethodBeat.o(251498);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(251503);
    a(0, paramInt1, 0, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2);
    AppMethodBeat.o(251503);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    AppMethodBeat.i(251502);
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5, null);
    AppMethodBeat.o(251502);
    return bool;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    AppMethodBeat.i(251506);
    ViewParent localViewParent;
    int j;
    int i;
    if (this.Np)
    {
      localViewParent = by(paramInt3);
      if (localViewParent == null)
      {
        AppMethodBeat.o(251506);
        return false;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramArrayOfInt2 == null) {
          break label184;
        }
        this.mView.getLocationInWindow(paramArrayOfInt2);
        j = paramArrayOfInt2[0];
        i = paramArrayOfInt2[1];
      }
    }
    for (;;)
    {
      if (paramArrayOfInt1 == null) {
        paramArrayOfInt1 = gW();
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        z.a(localViewParent, this.mView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= j;
          paramArrayOfInt2[1] -= i;
        }
        if ((paramArrayOfInt1[0] != 0) || (paramArrayOfInt1[1] != 0))
        {
          AppMethodBeat.o(251506);
          return true;
        }
        AppMethodBeat.o(251506);
        return false;
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        AppMethodBeat.o(251506);
        return false;
      }
      label184:
      i = 0;
      j = 0;
    }
  }
  
  public final void bw(int paramInt)
  {
    AppMethodBeat.i(251500);
    ViewParent localViewParent = by(paramInt);
    if (localViewParent != null)
    {
      z.a(localViewParent, this.mView, paramInt);
      a(paramInt, null);
    }
    AppMethodBeat.o(251500);
  }
  
  public final boolean bx(int paramInt)
  {
    AppMethodBeat.i(251496);
    if (by(paramInt) != null)
    {
      AppMethodBeat.o(251496);
      return true;
    }
    AppMethodBeat.o(251496);
    return false;
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(251508);
    if (this.Np)
    {
      ViewParent localViewParent = by(0);
      if (localViewParent != null)
      {
        paramBoolean = z.a(localViewParent, this.mView, paramFloat1, paramFloat2, paramBoolean);
        AppMethodBeat.o(251508);
        return paramBoolean;
      }
    }
    AppMethodBeat.o(251508);
    return false;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251511);
    if (this.Np)
    {
      ViewParent localViewParent = by(0);
      if (localViewParent != null)
      {
        boolean bool = z.a(localViewParent, this.mView, paramFloat1, paramFloat2);
        AppMethodBeat.o(251511);
        return bool;
      }
    }
    AppMethodBeat.o(251511);
    return false;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(251505);
    boolean bool = a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
    AppMethodBeat.o(251505);
    return bool;
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251501);
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0, null);
    AppMethodBeat.o(251501);
    return bool;
  }
  
  public final boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(251495);
    boolean bool = bx(0);
    AppMethodBeat.o(251495);
    return bool;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    return this.Np;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(251494);
    if (this.Np) {
      w.af(this.mView);
    }
    this.Np = paramBoolean;
    AppMethodBeat.o(251494);
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(251497);
    boolean bool = E(paramInt, 0);
    AppMethodBeat.o(251497);
    return bool;
  }
  
  public final void stopNestedScroll()
  {
    AppMethodBeat.i(251499);
    bw(0);
    AppMethodBeat.o(251499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.n
 * JD-Core Version:    0.7.0.1
 */