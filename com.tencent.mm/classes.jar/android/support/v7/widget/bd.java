package android.support.v7.widget;

import android.view.View;

final class bd
{
  final bd.b anl;
  bd.a anm;
  
  bd(bd.b paramb)
  {
    this.anl = paramb;
    this.anm = new bd.a();
  }
  
  final boolean bE(View paramView)
  {
    this.anm.setBounds(this.anl.hT(), this.anl.hU(), this.anl.bs(paramView), this.anl.bt(paramView));
    this.anm.ann = 0;
    this.anm.addFlags(24579);
    return this.anm.jf();
  }
  
  final View i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.anl.hT();
    int k = this.anl.hU();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = this.anl.getChildAt(paramInt1);
      int m = this.anl.bs(localView);
      int n = this.anl.bt(localView);
      this.anm.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.anm.ann = 0;
      this.anm.addFlags(paramInt3);
      if (!this.anm.jf()) {
        break;
      }
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.anm.ann = 0;
      this.anm.addFlags(paramInt4);
      if (this.anm.jf()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.bd
 * JD-Core Version:    0.7.0.1
 */