package android.support.v7.widget;

import android.support.v4.view.q;
import java.util.ArrayList;

final class RecyclerView$q
  extends RecyclerView.c
{
  RecyclerView$q(RecyclerView paramRecyclerView) {}
  
  private void hY()
  {
    if ((RecyclerView.afs) && (this.agK.afM) && (this.agK.afL))
    {
      q.b(this.agK, this.agK.afE);
      return;
    }
    this.agK.afU = true;
    this.agK.requestLayout();
  }
  
  public final void am(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.agK.Q(null);
    e locale = this.agK.afA;
    if (paramInt2 > 0)
    {
      locale.Ze.add(locale.a(1, paramInt1, paramInt2, null));
      locale.Zk |= 0x1;
      if (locale.Ze.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        hY();
      }
      return;
    }
  }
  
  public final void an(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.agK.Q(null);
    e locale = this.agK.afA;
    if (paramInt2 > 0)
    {
      locale.Ze.add(locale.a(2, paramInt1, paramInt2, null));
      locale.Zk |= 0x2;
      if (locale.Ze.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        hY();
      }
      return;
    }
  }
  
  public final void ao(int paramInt1, int paramInt2)
  {
    int i = 1;
    this.agK.Q(null);
    e locale = this.agK.afA;
    if (paramInt1 != paramInt2)
    {
      locale.Ze.add(locale.a(8, paramInt1, paramInt2, null));
      locale.Zk |= 0x8;
      if (locale.Ze.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        hY();
      }
      return;
    }
  }
  
  public final void d(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 1;
    this.agK.Q(null);
    e locale = this.agK.afA;
    if (paramInt2 > 0)
    {
      locale.Ze.add(locale.a(4, paramInt1, paramInt2, paramObject));
      locale.Zk |= 0x4;
      if (locale.Ze.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        hY();
      }
      return;
    }
  }
  
  public final void onChanged()
  {
    this.agK.Q(null);
    this.agK.agu.ahP = true;
    this.agK.ae(true);
    if (!this.agK.afA.gb()) {
      this.agK.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.q
 * JD-Core Version:    0.7.0.1
 */