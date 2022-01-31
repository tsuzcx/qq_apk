package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s
{
  final s.b abS;
  final s.a abT;
  final List<View> abU;
  
  s(s.b paramb)
  {
    this.abS = paramb;
    this.abT = new s.a();
    this.abU = new ArrayList();
  }
  
  private int bs(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.abS.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.abT.bv(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.abT.get(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.abS.getChildCount();; paramInt = bs(paramInt))
    {
      this.abT.i(paramInt, paramBoolean);
      if (paramBoolean) {
        aY(paramView);
      }
      this.abS.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.abS.getChildCount();; paramInt = bs(paramInt))
    {
      this.abT.i(paramInt, paramBoolean);
      if (paramBoolean) {
        aY(paramView);
      }
      this.abS.addView(paramView, paramInt);
      return;
    }
  }
  
  final void aY(View paramView)
  {
    this.abU.add(paramView);
    this.abS.bc(paramView);
  }
  
  final boolean aZ(View paramView)
  {
    if (this.abU.remove(paramView))
    {
      this.abS.bd(paramView);
      return true;
    }
    return false;
  }
  
  final boolean ba(View paramView)
  {
    return this.abU.contains(paramView);
  }
  
  final View bt(int paramInt)
  {
    return this.abS.getChildAt(paramInt);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = bs(paramInt);
    this.abT.bu(paramInt);
    this.abS.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = bs(paramInt);
    return this.abS.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.abS.getChildCount() - this.abU.size();
  }
  
  final int hx()
  {
    return this.abS.getChildCount();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.abS.indexOfChild(paramView);
    if (i == -1) {}
    while (this.abT.get(i)) {
      return -1;
    }
    return i - this.abT.bv(i);
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = bs(paramInt);
    View localView = this.abS.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.abT.bu(paramInt)) {
      aZ(localView);
    }
    this.abS.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.abT.toString() + ", hidden list:" + this.abU.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.s
 * JD-Core Version:    0.7.0.1
 */