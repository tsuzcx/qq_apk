package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s
{
  final b alK;
  final a alL;
  final List<View> alM;
  
  s(b paramb)
  {
    this.alK = paramb;
    this.alL = new a();
    this.alM = new ArrayList();
  }
  
  private int bK(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.alK.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.alL.bM(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.alL.get(i)) {
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
    for (paramInt = this.alK.getChildCount();; paramInt = bK(paramInt))
    {
      this.alL.h(paramInt, paramBoolean);
      if (paramBoolean) {
        be(paramView);
      }
      this.alK.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.alK.getChildCount();; paramInt = bK(paramInt))
    {
      this.alL.h(paramInt, paramBoolean);
      if (paramBoolean) {
        be(paramView);
      }
      this.alK.addView(paramView, paramInt);
      return;
    }
  }
  
  final View bL(int paramInt)
  {
    return this.alK.getChildAt(paramInt);
  }
  
  final void be(View paramView)
  {
    this.alM.add(paramView);
    this.alK.bi(paramView);
  }
  
  final boolean bf(View paramView)
  {
    if (this.alM.remove(paramView))
    {
      this.alK.bj(paramView);
      return true;
    }
    return false;
  }
  
  final boolean bg(View paramView)
  {
    return this.alM.contains(paramView);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = bK(paramInt);
    this.alL.remove(paramInt);
    this.alK.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = bK(paramInt);
    return this.alK.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.alK.getChildCount() - this.alM.size();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.alK.indexOfChild(paramView);
    if (i == -1) {}
    while (this.alL.get(i)) {
      return -1;
    }
    return i - this.alL.bM(i);
  }
  
  final int jr()
  {
    return this.alK.getChildCount();
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = bK(paramInt);
    View localView = this.alK.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.alL.remove(paramInt)) {
      bf(localView);
    }
    this.alK.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.alL.toString() + ", hidden list:" + this.alM.size();
  }
  
  static final class a
  {
    long alN = 0L;
    a alO;
    
    private void js()
    {
      if (this.alO == null) {
        this.alO = new a();
      }
    }
    
    final int bM(int paramInt)
    {
      if (this.alO == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.alN);
        }
        return Long.bitCount(this.alN & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.alN & (1L << paramInt) - 1L);
      }
      return this.alO.bM(paramInt - 64) + Long.bitCount(this.alN);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.alO == null) {
          return;
        }
        locala = locala.alO;
        paramInt -= 64;
      }
      locala.alN &= (1L << paramInt ^ 0xFFFFFFFF);
    }
    
    final boolean get(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.js();
        locala = locala.alO;
        paramInt -= 64;
      }
      return (locala.alN & 1L << paramInt) != 0L;
    }
    
    final void h(int paramInt, boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.js();
        locala = locala.alO;
        paramInt -= 64;
      }
      if ((locala.alN & 0x0) != 0L)
      {
        paramBoolean = true;
        label47:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.alN;
        locala.alN = (((l1 ^ 0xFFFFFFFF) & locala.alN) << 1 | l2 & l1);
        if (!bool) {
          break label132;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.alO == null)) {
          return;
        }
        locala.js();
        locala = locala.alO;
        paramInt = 0;
        bool = paramBoolean;
        break;
        paramBoolean = false;
        break label47;
        label132:
        locala.clear(paramInt);
      }
    }
    
    final boolean remove(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.js();
        locala = locala.alO;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.alN & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.alN &= (l1 ^ 0xFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.alN;
        locala.alN = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.alN, 1) | l2 & l1);
        if (locala.alO != null)
        {
          if (locala.alO.get(0)) {
            locala.set(63);
          }
          locala.alO.remove(0);
        }
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.js();
        locala = locala.alO;
        paramInt -= 64;
      }
      locala.alN |= 1L << paramInt;
    }
    
    public final String toString()
    {
      if (this.alO == null) {
        return Long.toBinaryString(this.alN);
      }
      return this.alO.toString() + "xx" + Long.toBinaryString(this.alN);
    }
  }
  
  static abstract interface b
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract RecyclerView.w bh(View paramView);
    
    public abstract void bi(View paramView);
    
    public abstract void bj(View paramView);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract int indexOfChild(View paramView);
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.s
 * JD-Core Version:    0.7.0.1
 */