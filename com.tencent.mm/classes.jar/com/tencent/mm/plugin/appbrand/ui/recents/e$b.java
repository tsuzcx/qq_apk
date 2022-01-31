package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.f.a;

final class e$b
  extends RecyclerView.c
  implements RecyclerView.f.a
{
  private e$b(e parame) {}
  
  private void dG(final boolean paramBoolean)
  {
    this.hhH.F(new Runnable()
    {
      public final void run()
      {
        if ((!e.b(e.b.this.hhH).isEmpty()) && (e.b(e.b.this.hhH) != null)) {
          e.b(e.b.this.hhH).bL(e.b(e.b.this.hhH).getItemCount() - 1);
        }
        f localf;
        if (e.n(e.b.this.hhH) != null)
        {
          localf = e.n(e.b.this.hhH);
          if ((paramBoolean) || (e.b(e.b.this.hhH).isEmpty())) {
            break label112;
          }
        }
        label112:
        for (boolean bool = true;; bool = false)
        {
          localf.dH(bool);
          return;
        }
      }
    });
  }
  
  public final void am(int paramInt1, int paramInt2)
  {
    dG(false);
  }
  
  public final void an(int paramInt1, int paramInt2)
  {
    dG(true);
  }
  
  public final void ao(int paramInt1, int paramInt2)
  {
    dG(false);
  }
  
  public final void hQ()
  {
    dG(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.b
 * JD-Core Version:    0.7.0.1
 */