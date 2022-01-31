package android.support.v7.widget;

import android.view.View;

final class bf
{
  final bf.b apC;
  bf.a apD;
  
  bf(bf.b paramb)
  {
    this.apC = paramb;
    this.apD = new bf.a();
  }
  
  final boolean bX(View paramView)
  {
    this.apD.setBounds(this.apC.jC(), this.apC.jD(), this.apC.bH(paramView), this.apC.bI(paramView));
    this.apD.apE = 0;
    this.apD.addFlags(24579);
    return this.apD.la();
  }
  
  final View k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.apC.jC();
    int k = this.apC.jD();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = this.apC.getChildAt(paramInt1);
      int m = this.apC.bH(localView);
      int n = this.apC.bI(localView);
      this.apD.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.apD.apE = 0;
      this.apD.addFlags(paramInt3);
      if (!this.apD.la()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.apD.apE = 0;
      this.apD.addFlags(paramInt4);
      if (this.apD.la()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bf
 * JD-Core Version:    0.7.0.1
 */