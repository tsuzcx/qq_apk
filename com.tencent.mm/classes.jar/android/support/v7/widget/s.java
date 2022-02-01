package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s
{
  final b alX;
  final a alY;
  final List<View> alZ;
  
  s(b paramb)
  {
    this.alX = paramb;
    this.alY = new a();
    this.alZ = new ArrayList();
  }
  
  private int bL(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.alX.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.alY.bN(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.alY.get(i)) {
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
    for (paramInt = this.alX.getChildCount();; paramInt = bL(paramInt))
    {
      this.alY.i(paramInt, paramBoolean);
      if (paramBoolean) {
        bf(paramView);
      }
      this.alX.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.alX.getChildCount();; paramInt = bL(paramInt))
    {
      this.alY.i(paramInt, paramBoolean);
      if (paramBoolean) {
        bf(paramView);
      }
      this.alX.addView(paramView, paramInt);
      return;
    }
  }
  
  final View bM(int paramInt)
  {
    return this.alX.getChildAt(paramInt);
  }
  
  final void bf(View paramView)
  {
    this.alZ.add(paramView);
    this.alX.bj(paramView);
  }
  
  final boolean bg(View paramView)
  {
    if (this.alZ.remove(paramView))
    {
      this.alX.bk(paramView);
      return true;
    }
    return false;
  }
  
  final boolean bh(View paramView)
  {
    return this.alZ.contains(paramView);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = bL(paramInt);
    this.alY.remove(paramInt);
    this.alX.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = bL(paramInt);
    return this.alX.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.alX.getChildCount() - this.alZ.size();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.alX.indexOfChild(paramView);
    if (i == -1) {}
    while (this.alY.get(i)) {
      return -1;
    }
    return i - this.alY.bN(i);
  }
  
  final int jA()
  {
    return this.alX.getChildCount();
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = bL(paramInt);
    View localView = this.alX.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.alY.remove(paramInt)) {
      bg(localView);
    }
    this.alX.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.alY.toString() + ", hidden list:" + this.alZ.size();
  }
  
  static final class a
  {
    long ama = 0L;
    a amb;
    
    private void jB()
    {
      if (this.amb == null) {
        this.amb = new a();
      }
    }
    
    final int bN(int paramInt)
    {
      if (this.amb == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.ama);
        }
        return Long.bitCount(this.ama & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.ama & (1L << paramInt) - 1L);
      }
      return this.amb.bN(paramInt - 64) + Long.bitCount(this.ama);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.amb == null) {
          return;
        }
        locala = locala.amb;
        paramInt -= 64;
      }
      locala.ama &= (1L << paramInt ^ 0xFFFFFFFF);
    }
    
    final boolean get(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.jB();
        locala = locala.amb;
        paramInt -= 64;
      }
      return (locala.ama & 1L << paramInt) != 0L;
    }
    
    final void i(int paramInt, boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.jB();
        locala = locala.amb;
        paramInt -= 64;
      }
      if ((locala.ama & 0x0) != 0L)
      {
        paramBoolean = true;
        label47:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.ama;
        locala.ama = (((l1 ^ 0xFFFFFFFF) & locala.ama) << 1 | l2 & l1);
        if (!bool) {
          break label132;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.amb == null)) {
          return;
        }
        locala.jB();
        locala = locala.amb;
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
        locala.jB();
        locala = locala.amb;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.ama & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.ama &= (l1 ^ 0xFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.ama;
        locala.ama = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.ama, 1) | l2 & l1);
        if (locala.amb != null)
        {
          if (locala.amb.get(0)) {
            locala.set(63);
          }
          locala.amb.remove(0);
        }
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.jB();
        locala = locala.amb;
        paramInt -= 64;
      }
      locala.ama |= 1L << paramInt;
    }
    
    public final String toString()
    {
      if (this.amb == null) {
        return Long.toBinaryString(this.ama);
      }
      return this.amb.toString() + "xx" + Long.toBinaryString(this.ama);
    }
  }
  
  static abstract interface b
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract RecyclerView.v bi(View paramView);
    
    public abstract void bj(View paramView);
    
    public abstract void bk(View paramView);
    
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