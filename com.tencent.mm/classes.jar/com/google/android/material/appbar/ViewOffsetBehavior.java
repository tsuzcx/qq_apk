package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private a doT;
  private int doU = 0;
  private int doV = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int Vx()
  {
    if (this.doT != null) {
      return this.doT.doY;
    }
    return 0;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(210027);
    c(paramCoordinatorLayout, paramV, paramInt);
    if (this.doT == null) {
      this.doT = new a(paramV);
    }
    this.doT.VE();
    if (this.doU != 0)
    {
      this.doT.ji(this.doU);
      this.doU = 0;
    }
    if (this.doV != 0)
    {
      paramCoordinatorLayout = this.doT;
      paramInt = this.doV;
      if (paramCoordinatorLayout.doZ != paramInt)
      {
        paramCoordinatorLayout.doZ = paramInt;
        paramCoordinatorLayout.VF();
      }
      this.doV = 0;
    }
    AppMethodBeat.o(210027);
    return true;
  }
  
  protected void c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(210037);
    paramCoordinatorLayout.h(paramV, paramInt);
    AppMethodBeat.o(210037);
  }
  
  public boolean ji(int paramInt)
  {
    AppMethodBeat.i(210049);
    if (this.doT != null)
    {
      boolean bool = this.doT.ji(paramInt);
      AppMethodBeat.o(210049);
      return bool;
    }
    this.doU = paramInt;
    AppMethodBeat.o(210049);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */