package android.support.v7.widget;

import android.view.View;

final class bf
{
  final b azP;
  a azQ;
  
  bf(b paramb)
  {
    this.azP = paramb;
    this.azQ = new a();
  }
  
  final boolean cf(View paramView)
  {
    this.azQ.setBounds(this.azP.lB(), this.azP.lC(), this.azP.bO(paramView), this.azP.bP(paramView));
    this.azQ.azR = 0;
    this.azQ.addFlags(24579);
    return this.azQ.nj();
  }
  
  final View k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.azP.lB();
    int k = this.azP.lC();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = this.azP.getChildAt(paramInt1);
      int m = this.azP.bO(localView);
      int n = this.azP.bP(localView);
      this.azQ.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.azQ.azR = 0;
      this.azQ.addFlags(paramInt3);
      if (!this.azQ.nj()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.azQ.azR = 0;
      this.azQ.addFlags(paramInt4);
      if (this.azQ.nj()) {
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
    int azR = 0;
    int azS;
    int azT;
    int azU;
    int azV;
    
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
      this.azR |= paramInt;
    }
    
    final boolean nj()
    {
      if (((this.azR & 0x7) != 0) && ((this.azR & compare(this.azU, this.azS) << 0) == 0)) {}
      while ((((this.azR & 0x70) != 0) && ((this.azR & compare(this.azU, this.azT) << 4) == 0)) || (((this.azR & 0x700) != 0) && ((this.azR & compare(this.azV, this.azS) << 8) == 0)) || (((this.azR & 0x7000) != 0) && ((this.azR & compare(this.azV, this.azT) << 12) == 0))) {
        return false;
      }
      return true;
    }
    
    final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.azS = paramInt1;
      this.azT = paramInt2;
      this.azU = paramInt3;
      this.azV = paramInt4;
    }
  }
  
  static abstract interface b
  {
    public abstract int bO(View paramView);
    
    public abstract int bP(View paramView);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int lB();
    
    public abstract int lC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bf
 * JD-Core Version:    0.7.0.1
 */