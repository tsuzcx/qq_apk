package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s
{
  final b aiZ;
  final a aja;
  final List<View> ajb;
  
  s(b paramb)
  {
    this.aiZ = paramb;
    this.aja = new a();
    this.ajb = new ArrayList();
  }
  
  private int bK(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.aiZ.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.aja.bM(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.aja.get(i)) {
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
    for (paramInt = this.aiZ.getChildCount();; paramInt = bK(paramInt))
    {
      this.aja.h(paramInt, paramBoolean);
      if (paramBoolean) {
        be(paramView);
      }
      this.aiZ.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.aiZ.getChildCount();; paramInt = bK(paramInt))
    {
      this.aja.h(paramInt, paramBoolean);
      if (paramBoolean) {
        be(paramView);
      }
      this.aiZ.addView(paramView, paramInt);
      return;
    }
  }
  
  final View bL(int paramInt)
  {
    return this.aiZ.getChildAt(paramInt);
  }
  
  final void be(View paramView)
  {
    this.ajb.add(paramView);
    this.aiZ.bi(paramView);
  }
  
  final boolean bf(View paramView)
  {
    if (this.ajb.remove(paramView))
    {
      this.aiZ.bj(paramView);
      return true;
    }
    return false;
  }
  
  final boolean bg(View paramView)
  {
    return this.ajb.contains(paramView);
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = bK(paramInt);
    this.aja.remove(paramInt);
    this.aiZ.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = bK(paramInt);
    return this.aiZ.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.aiZ.getChildCount() - this.ajb.size();
  }
  
  final int iT()
  {
    return this.aiZ.getChildCount();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.aiZ.indexOfChild(paramView);
    if (i == -1) {}
    while (this.aja.get(i)) {
      return -1;
    }
    return i - this.aja.bM(i);
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = bK(paramInt);
    View localView = this.aiZ.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.aja.remove(paramInt)) {
      bf(localView);
    }
    this.aiZ.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.aja.toString() + ", hidden list:" + this.ajb.size();
  }
  
  static final class a
  {
    long ajc = 0L;
    a ajd;
    
    private void iU()
    {
      if (this.ajd == null) {
        this.ajd = new a();
      }
    }
    
    final int bM(int paramInt)
    {
      if (this.ajd == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(this.ajc);
        }
        return Long.bitCount(this.ajc & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(this.ajc & (1L << paramInt) - 1L);
      }
      return this.ajd.bM(paramInt - 64) + Long.bitCount(this.ajc);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.ajd == null) {
          return;
        }
        locala = locala.ajd;
        paramInt -= 64;
      }
      locala.ajc &= (1L << paramInt ^ 0xFFFFFFFF);
    }
    
    final boolean get(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.iU();
        locala = locala.ajd;
        paramInt -= 64;
      }
      return (locala.ajc & 1L << paramInt) != 0L;
    }
    
    final void h(int paramInt, boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.iU();
        locala = locala.ajd;
        paramInt -= 64;
      }
      if ((locala.ajc & 0x0) != 0L)
      {
        paramBoolean = true;
        label47:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.ajc;
        locala.ajc = (((l1 ^ 0xFFFFFFFF) & locala.ajc) << 1 | l2 & l1);
        if (!bool) {
          break label132;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.ajd == null)) {
          return;
        }
        locala.iU();
        locala = locala.ajd;
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
        locala.iU();
        locala = locala.ajd;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.ajc & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.ajc &= (l1 ^ 0xFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.ajc;
        locala.ajc = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.ajc, 1) | l2 & l1);
        if (locala.ajd != null)
        {
          if (locala.ajd.get(0)) {
            locala.set(63);
          }
          locala.ajd.remove(0);
        }
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        locala.iU();
        locala = locala.ajd;
        paramInt -= 64;
      }
      locala.ajc |= 1L << paramInt;
    }
    
    public final String toString()
    {
      if (this.ajd == null) {
        return Long.toBinaryString(this.ajc);
      }
      return this.ajd.toString() + "xx" + Long.toBinaryString(this.ajc);
    }
  }
  
  static abstract interface b
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract RecyclerView.v bh(View paramView);
    
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