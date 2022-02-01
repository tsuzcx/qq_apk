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
  private a bvQ;
  private int bvR = 0;
  private int bvS = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(234792);
    c(paramCoordinatorLayout, paramV, paramInt);
    if (this.bvQ == null) {
      this.bvQ = new a(paramV);
    }
    this.bvQ.wf();
    if (this.bvR != 0)
    {
      this.bvQ.fT(this.bvR);
      this.bvR = 0;
    }
    if (this.bvS != 0)
    {
      paramCoordinatorLayout = this.bvQ;
      paramInt = this.bvS;
      if (paramCoordinatorLayout.bvW != paramInt)
      {
        paramCoordinatorLayout.bvW = paramInt;
        paramCoordinatorLayout.wg();
      }
      this.bvS = 0;
    }
    AppMethodBeat.o(234792);
    return true;
  }
  
  protected void c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(234793);
    paramCoordinatorLayout.h(paramV, paramInt);
    AppMethodBeat.o(234793);
  }
  
  public boolean fT(int paramInt)
  {
    AppMethodBeat.i(234795);
    if (this.bvQ != null)
    {
      boolean bool = this.bvQ.fT(paramInt);
      AppMethodBeat.o(234795);
      return bool;
    }
    this.bvR = paramInt;
    AppMethodBeat.o(234795);
    return false;
  }
  
  public int vY()
  {
    if (this.bvQ != null) {
      return this.bvQ.bvV;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */