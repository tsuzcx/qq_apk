package android.support.v7.widget;

import android.view.View;

final class bf
{
  final b axe;
  a axf;
  
  bf(b paramb)
  {
    this.axe = paramb;
    this.axf = new a();
  }
  
  final boolean cf(View paramView)
  {
    this.axf.setBounds(this.axe.lb(), this.axe.lc(), this.axe.bO(paramView), this.axe.bP(paramView));
    this.axf.axg = 0;
    this.axf.addFlags(24579);
    return this.axf.mH();
  }
  
  final View k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.axe.lb();
    int k = this.axe.lc();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = this.axe.getChildAt(paramInt1);
      int m = this.axe.bO(localView);
      int n = this.axe.bP(localView);
      this.axf.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.axf.axg = 0;
      this.axf.addFlags(paramInt3);
      if (!this.axf.mH()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.axf.axg = 0;
      this.axf.addFlags(paramInt4);
      if (this.axf.mH()) {
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
    int axg = 0;
    int axh;
    int axi;
    int axj;
    int axk;
    
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
      this.axg |= paramInt;
    }
    
    final boolean mH()
    {
      if (((this.axg & 0x7) != 0) && ((this.axg & compare(this.axj, this.axh) << 0) == 0)) {}
      while ((((this.axg & 0x70) != 0) && ((this.axg & compare(this.axj, this.axi) << 4) == 0)) || (((this.axg & 0x700) != 0) && ((this.axg & compare(this.axk, this.axh) << 8) == 0)) || (((this.axg & 0x7000) != 0) && ((this.axg & compare(this.axk, this.axi) << 12) == 0))) {
        return false;
      }
      return true;
    }
    
    final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.axh = paramInt1;
      this.axi = paramInt2;
      this.axj = paramInt3;
      this.axk = paramInt4;
    }
  }
  
  static abstract interface b
  {
    public abstract int bO(View paramView);
    
    public abstract int bP(View paramView);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int lb();
    
    public abstract int lc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bf
 * JD-Core Version:    0.7.0.1
 */