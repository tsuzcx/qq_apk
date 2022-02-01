package android.support.v7.widget;

import android.view.View;

final class bf
{
  final b azN;
  a azO;
  
  bf(b paramb)
  {
    this.azN = paramb;
    this.azO = new a();
  }
  
  final boolean bR(View paramView)
  {
    this.azO.setBounds(this.azN.lE(), this.azN.lF(), this.azN.bB(paramView), this.azN.bC(paramView));
    this.azO.azP = 0;
    this.azO.addFlags(24579);
    return this.azO.nl();
  }
  
  final View k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.azN.lE();
    int k = this.azN.lF();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = this.azN.getChildAt(paramInt1);
      int m = this.azN.bB(localView);
      int n = this.azN.bC(localView);
      this.azO.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.azO.azP = 0;
      this.azO.addFlags(paramInt3);
      if (!this.azO.nl()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.azO.azP = 0;
      this.azO.addFlags(paramInt4);
      if (this.azO.nl()) {
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
    int azP = 0;
    int azQ;
    int azR;
    int azS;
    int azT;
    
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
      this.azP |= paramInt;
    }
    
    final boolean nl()
    {
      if (((this.azP & 0x7) != 0) && ((this.azP & compare(this.azS, this.azQ) << 0) == 0)) {}
      while ((((this.azP & 0x70) != 0) && ((this.azP & compare(this.azS, this.azR) << 4) == 0)) || (((this.azP & 0x700) != 0) && ((this.azP & compare(this.azT, this.azQ) << 8) == 0)) || (((this.azP & 0x7000) != 0) && ((this.azP & compare(this.azT, this.azR) << 12) == 0))) {
        return false;
      }
      return true;
    }
    
    final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.azQ = paramInt1;
      this.azR = paramInt2;
      this.azS = paramInt3;
      this.azT = paramInt4;
    }
  }
  
  static abstract interface b
  {
    public abstract int bB(View paramView);
    
    public abstract int bC(View paramView);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int lE();
    
    public abstract int lF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bf
 * JD-Core Version:    0.7.0.1
 */