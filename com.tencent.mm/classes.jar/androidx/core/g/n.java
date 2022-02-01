package androidx.core.g;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
{
  private ViewParent btq;
  private ViewParent btr;
  public boolean bts;
  private int[] btt;
  private final View mView;
  
  public n(View paramView)
  {
    this.mView = paramView;
  }
  
  private int[] Ef()
  {
    if (this.btt == null) {
      this.btt = new int[2];
    }
    return this.btt;
  }
  
  private void a(int paramInt, ViewParent paramViewParent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.btq = paramViewParent;
      return;
    }
    this.btr = paramViewParent;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(195706);
    ViewParent localViewParent;
    int j;
    int i;
    if (this.bts)
    {
      localViewParent = eo(paramInt5);
      if (localViewParent == null)
      {
        AppMethodBeat.o(195706);
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
        paramArrayOfInt2 = Ef();
        paramArrayOfInt2[0] = 0;
        paramArrayOfInt2[1] = 0;
      }
      for (;;)
      {
        ac.a(localViewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfInt2);
        if (paramArrayOfInt1 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt1);
          paramArrayOfInt1[0] -= j;
          paramArrayOfInt1[1] -= i;
        }
        AppMethodBeat.o(195706);
        return true;
        if (paramArrayOfInt1 != null)
        {
          paramArrayOfInt1[0] = 0;
          paramArrayOfInt1[1] = 0;
        }
        AppMethodBeat.o(195706);
        return false;
      }
      label182:
      i = 0;
      j = 0;
    }
  }
  
  private ViewParent eo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.btq;
    }
    return this.btr;
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(195897);
    a(0, paramInt1, 0, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2);
    AppMethodBeat.o(195897);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    AppMethodBeat.i(195887);
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5, null);
    AppMethodBeat.o(195887);
    return bool;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    AppMethodBeat.i(195929);
    ViewParent localViewParent;
    int j;
    int i;
    if (this.bts)
    {
      localViewParent = eo(paramInt3);
      if (localViewParent == null)
      {
        AppMethodBeat.o(195929);
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
        paramArrayOfInt1 = Ef();
      }
      for (;;)
      {
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[1] = 0;
        ac.a(localViewParent, this.mView, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= j;
          paramArrayOfInt2[1] -= i;
        }
        if ((paramArrayOfInt1[0] != 0) || (paramArrayOfInt1[1] != 0))
        {
          AppMethodBeat.o(195929);
          return true;
        }
        AppMethodBeat.o(195929);
        return false;
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        AppMethodBeat.o(195929);
        return false;
      }
      label184:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean az(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195833);
    if (en(paramInt2))
    {
      AppMethodBeat.o(195833);
      return true;
    }
    if (this.bts)
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView = this.mView;
      while (localViewParent != null)
      {
        if (ac.a(localViewParent, localView, this.mView, paramInt1, paramInt2))
        {
          a(paramInt2, localViewParent);
          ac.b(localViewParent, localView, this.mView, paramInt1, paramInt2);
          AppMethodBeat.o(195833);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    AppMethodBeat.o(195833);
    return false;
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(195942);
    if (this.bts)
    {
      ViewParent localViewParent = eo(0);
      if (localViewParent != null)
      {
        paramBoolean = ac.a(localViewParent, this.mView, paramFloat1, paramFloat2, paramBoolean);
        AppMethodBeat.o(195942);
        return paramBoolean;
      }
    }
    AppMethodBeat.o(195942);
    return false;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195951);
    if (this.bts)
    {
      ViewParent localViewParent = eo(0);
      if (localViewParent != null)
      {
        boolean bool = ac.a(localViewParent, this.mView, paramFloat1, paramFloat2);
        AppMethodBeat.o(195951);
        return bool;
      }
    }
    AppMethodBeat.o(195951);
    return false;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(195911);
    boolean bool = a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
    AppMethodBeat.o(195911);
    return bool;
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195877);
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0, null);
    AppMethodBeat.o(195877);
    return bool;
  }
  
  public final void em(int paramInt)
  {
    AppMethodBeat.i(195862);
    ViewParent localViewParent = eo(paramInt);
    if (localViewParent != null)
    {
      ac.a(localViewParent, this.mView, paramInt);
      a(paramInt, null);
    }
    AppMethodBeat.o(195862);
  }
  
  public final boolean en(int paramInt)
  {
    AppMethodBeat.i(195801);
    if (eo(paramInt) != null)
    {
      AppMethodBeat.o(195801);
      return true;
    }
    AppMethodBeat.o(195801);
    return false;
  }
  
  public final boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(195787);
    boolean bool = en(0);
    AppMethodBeat.o(195787);
    return bool;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    return this.bts;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(195758);
    if (this.bts) {
      z.as(this.mView);
    }
    this.bts = paramBoolean;
    AppMethodBeat.o(195758);
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(195812);
    boolean bool = az(paramInt, 0);
    AppMethodBeat.o(195812);
    return bool;
  }
  
  public final void stopNestedScroll()
  {
    AppMethodBeat.i(195848);
    em(0);
    AppMethodBeat.o(195848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.n
 * JD-Core Version:    0.7.0.1
 */