package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class u
{
  final u.b abh;
  final u.a abi;
  final List<View> abj;
  
  u(u.b paramb)
  {
    this.abh = paramb;
    this.abi = new u.a();
    this.abj = new ArrayList();
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.abh.getChildCount();; paramInt = bs(paramInt))
    {
      this.abi.o(paramInt, paramBoolean);
      if (paramBoolean) {
        aQ(paramView);
      }
      this.abh.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.abh.getChildCount();; paramInt = bs(paramInt))
    {
      this.abi.o(paramInt, paramBoolean);
      if (paramBoolean) {
        aQ(paramView);
      }
      this.abh.addView(paramView, paramInt);
      return;
    }
  }
  
  final void aQ(View paramView)
  {
    this.abj.add(paramView);
    this.abh.aU(paramView);
  }
  
  final boolean aR(View paramView)
  {
    if (this.abj.remove(paramView))
    {
      this.abh.aV(paramView);
      return true;
    }
    return false;
  }
  
  final boolean aS(View paramView)
  {
    return this.abj.contains(paramView);
  }
  
  final int bs(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.abh.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.abi.bv(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.abi.get(i)) {
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
  
  final View bt(int paramInt)
  {
    return this.abh.getChildAt(paramInt);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = bs(paramInt);
    this.abi.bu(paramInt);
    this.abh.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = bs(paramInt);
    return this.abh.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.abh.getChildCount() - this.abj.size();
  }
  
  final int gx()
  {
    return this.abh.getChildCount();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.abh.indexOfChild(paramView);
    if (i == -1) {}
    while (this.abi.get(i)) {
      return -1;
    }
    return i - this.abi.bv(i);
  }
  
  public final String toString()
  {
    return this.abi.toString() + ", hidden list:" + this.abj.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.u
 * JD-Core Version:    0.7.0.1
 */