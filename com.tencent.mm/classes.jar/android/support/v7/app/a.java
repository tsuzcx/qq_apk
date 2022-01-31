package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.d;

public final class a
  implements DrawerLayout.c
{
  private final a MT;
  private d MU;
  private boolean MV;
  boolean MW;
  private final int MX;
  private final int MY;
  
  private void L(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.MU.U(true);
    }
    for (;;)
    {
      this.MU.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.MU.U(false);
      }
    }
  }
  
  private void aN(int paramInt)
  {
    this.MT.aN(paramInt);
  }
  
  public final void D(float paramFloat)
  {
    if (this.MV)
    {
      L(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    L(0.0F);
  }
  
  public final void dY()
  {
    L(1.0F);
    if (this.MW) {
      aN(this.MY);
    }
  }
  
  public final void dZ()
  {
    L(0.0F);
    if (this.MW) {
      aN(this.MX);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aN(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.7.0.1
 */