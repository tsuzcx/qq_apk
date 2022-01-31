package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.b;

public final class a
  implements DrawerLayout.c
{
  private final a Nd;
  private b Ne;
  private boolean Nf;
  boolean Ng;
  private final int Nh;
  private final int Ni;
  
  private void K(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.Ne.S(true);
    }
    for (;;)
    {
      b localb = this.Ne;
      if (localb.St != paramFloat)
      {
        localb.St = paramFloat;
        localb.invalidateSelf();
      }
      return;
      if (paramFloat == 0.0F) {
        this.Ne.S(false);
      }
    }
  }
  
  private void aR(int paramInt)
  {
    this.Nd.aR(paramInt);
  }
  
  public final void C(float paramFloat)
  {
    if (this.Nf)
    {
      K(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    K(0.0F);
  }
  
  public final void dH()
  {
    K(1.0F);
    if (this.Ng) {
      aR(this.Ni);
    }
  }
  
  public final void dI()
  {
    K(0.0F);
    if (this.Ng) {
      aR(this.Nh);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aR(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.7.0.1
 */