package android.support.v7.widget;

import android.view.View;

final class bf
{
  final b axY;
  a axZ;
  
  bf(b paramb)
  {
    this.axY = paramb;
    this.axZ = new a();
  }
  
  final boolean cf(View paramView)
  {
    this.axZ.setBounds(this.axY.lj(), this.axY.lk(), this.axY.bO(paramView), this.axY.bP(paramView));
    this.axZ.aya = 0;
    this.axZ.addFlags(24579);
    return this.axZ.mR();
  }
  
  final View k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.axY.lj();
    int k = this.axY.lk();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = this.axY.getChildAt(paramInt1);
      int m = this.axY.bO(localView);
      int n = this.axY.bP(localView);
      this.axZ.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.axZ.aya = 0;
      this.axZ.addFlags(paramInt3);
      if (!this.axZ.mR()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.axZ.aya = 0;
      this.axZ.addFlags(paramInt4);
      if (this.axZ.mR()) {
        localObject = localView;
      }
    }
    for (;;)
    {
      paramInt1 += i;
      break;
      label174:
      return localObject;
    }
  }
  
  static final class a
  {
    int aya = 0;
    int ayb;
    int ayc;
    int ayd;
    int aye;
    
    private static int compare(int paramInt1, int paramInt2)
    {
      if (paramInt1 > paramInt2) {
        return 1;
      }
      if (paramInt1 == paramInt2) {
        return 2;
      }
      return 4;
    }
    
    final void addFlags(int paramInt)
    {
      this.aya |= paramInt;
    }
    
    final boolean mR()
    {
      if (((this.aya & 0x7) != 0) && ((this.aya & compare(this.ayd, this.ayb) << 0) == 0)) {}
      while ((((this.aya & 0x70) != 0) && ((this.aya & compare(this.ayd, this.ayc) << 4) == 0)) || (((this.aya & 0x700) != 0) && ((this.aya & compare(this.aye, this.ayb) << 8) == 0)) || (((this.aya & 0x7000) != 0) && ((this.aya & compare(this.aye, this.ayc) << 12) == 0))) {
        return false;
      }
      return true;
    }
    
    final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.ayb = paramInt1;
      this.ayc = paramInt2;
      this.ayd = paramInt3;
      this.aye = paramInt4;
    }
  }
  
  static abstract interface b
  {
    public abstract int bO(View paramView);
    
    public abstract int bP(View paramView);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int lj();
    
    public abstract int lk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bf
 * JD-Core Version:    0.7.0.1
 */