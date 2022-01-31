package android.support.v7.widget;

import android.support.v4.view.t;
import java.util.ArrayList;

final class RecyclerView$q
  extends RecyclerView.c
{
  RecyclerView$q(RecyclerView paramRecyclerView) {}
  
  private void jH()
  {
    if ((RecyclerView.ahI) && (this.aja.aic) && (this.aja.aib))
    {
      t.b(this.aja, this.aja.ahU);
      return;
    }
    this.aja.aik = true;
    this.aja.requestLayout();
  }
  
  public final void as(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.aja.S(null);
    d locald = this.aja.ahQ;
    if (paramInt2 > 0)
    {
      locald.ZP.add(locald.b(1, paramInt1, paramInt2, null));
      locald.ZV |= 0x1;
      if (locald.ZP.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        jH();
      }
      return;
    }
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.aja.S(null);
    d locald = this.aja.ahQ;
    if (paramInt2 > 0)
    {
      locald.ZP.add(locald.b(2, paramInt1, paramInt2, null));
      locald.ZV |= 0x2;
      if (locald.ZP.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        jH();
      }
      return;
    }
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.aja.S(null);
    d locald = this.aja.ahQ;
    if (paramInt1 != paramInt2)
    {
      locald.ZP.add(locald.b(8, paramInt1, paramInt2, null));
      locald.ZV |= 0x8;
      if (locald.ZP.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        jH();
      }
      return;
    }
  }
  
  public final void f(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 1;
    this.aja.S(null);
    d locald = this.aja.ahQ;
    if (paramInt2 > 0)
    {
      locald.ZP.add(locald.b(4, paramInt1, paramInt2, paramObject));
      locald.ZV |= 0x4;
      if (locald.ZP.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        jH();
      }
      return;
    }
  }
  
  public final void onChanged()
  {
    this.aja.S(null);
    this.aja.aiK.akf = true;
    this.aja.an(true);
    if (!this.aja.ahQ.gY()) {
      this.aja.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.q
 * JD-Core Version:    0.7.0.1
 */