package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s
{
  final b ajT;
  final a ajU;
  final List<View> ajV;
  
  s(b paramb)
  {
    this.ajT = paramb;
    this.ajU = new a();
    this.ajV = new ArrayList();
  }
  
  private int bK(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.ajT.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.ajU.bM(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.ajU.get(i)) {
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
    for (paramInt = this.ajT.getChildCount();; paramInt = bK(paramInt))
    {
      this.ajU.h(paramInt, paramBoolean);
      if (paramBoolean) {
        be(paramView);
      }
      this.ajT.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.ajT.getChildCount();; paramInt = bK(paramInt))
    {
      this.ajU.h(paramInt, paramBoolean);
      if (paramBoolean) {
        be(paramView);
      }
      this.ajT.addView(paramView, paramInt);
      return;
    }
  }
  
  final View bL(int paramInt)
  {
    return this.ajT.getChildAt(paramInt);
  }
  
  final void be(View paramView)
  {
    this.ajV.add(paramView);
    this.ajT.bi(paramView);
  }
  
  final boolean bf(View paramView)
  {
    if (this.ajV.remove(paramView))
    {
      this.ajT.bj(paramView);
      return true;
    }
    return false;
  }
  
  final boolean bg(View paramView)
  {
    return this.ajV.contains(paramView);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = bK(paramInt);
    this.ajU.remove(paramInt);
    this.ajT.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = bK(paramInt);
    return this.ajT.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.ajT.getChildCount() - this.ajV.size();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.ajT.indexOfChild(paramView);
    if (i == -1) {}
    while (this.ajU.get(i)) {
      return -1;
    }
    return i - this.ajU.bM(i);
  }
  
  final int jb()
  {
    return this.ajT.getChildCount();
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = bK(paramInt);
    View localView = this.ajT.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.ajU.remove(paramInt)) {
      bf(localView);
    }
    this.ajT.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.ajU.toString() + ", hidden list:" + this.ajV.size();
  }
  
  static final class a
  {
    long ajW = 0L;
    a ajX;
    
    private void jc()
    {
      if (this.ajX == null) {
        this.ajX = new a();
      }
    }
    
    final int bM(int paramInt)
    {
      if (this.ajX == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.ajW);
        }
        return Long.bitCount(this.ajW & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.ajW & (1L << paramInt) - 1L);
      }
      return this.ajX.bM(paramInt - 64) + Long.bitCount(this.ajW);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.ajX == null) {
          return;
        }
        locala = locala.ajX;
        paramInt -= 64;
      }
      locala.ajW &= (1L << paramInt ^ 0xFFFFFFFF);
    }
    
    final boolean get(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.jc();
        locala = locala.ajX;
        paramInt -= 64;
      }
      return (locala.ajW & 1L << paramInt) != 0L;
    }
    
    final void h(int paramInt, boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.jc();
        locala = locala.ajX;
        paramInt -= 64;
      }
      if ((locala.ajW & 0x0) != 0L)
      {
        paramBoolean = true;
        label47:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.ajW;
        locala.ajW = (((l1 ^ 0xFFFFFFFF) & locala.ajW) << 1 | l2 & l1);
        if (!bool) {
          break label132;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.ajX == null)) {
          return;
        }
        locala.jc();
        locala = locala.ajX;
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
        locala.jc();
        locala = locala.ajX;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.ajW & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.ajW &= (l1 ^ 0xFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.ajW;
        locala.ajW = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.ajW, 1) | l2 & l1);
        if (locala.ajX != null)
        {
          if (locala.ajX.get(0)) {
            locala.set(63);
          }
          locala.ajX.remove(0);
        }
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.jc();
        locala = locala.ajX;
        paramInt -= 64;
      }
      locala.ajW |= 1L << paramInt;
    }
    
    public final String toString()
    {
      if (this.ajX == null) {
        return Long.toBinaryString(this.ajW);
      }
      return this.ajX.toString() + "xx" + Long.toBinaryString(this.ajW);
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