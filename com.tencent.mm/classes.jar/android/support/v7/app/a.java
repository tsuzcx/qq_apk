package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.d;

public final class a
  implements DrawerLayout.c
{
  private final a.a UQ;
  private d UR;
  private boolean US;
  boolean UT;
  private final int UU;
  private final int UV;
  
  private void P(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.UR.aa(true);
    }
    for (;;)
    {
      this.UR.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.UR.aa(false);
      }
    }
  }
  
  private void bg(int paramInt)
  {
    this.UQ.bg(paramInt);
  }
  
  public final void H(float paramFloat)
  {
    if (this.US)
    {
      P(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    P(0.0F);
  }
  
  public final void fy()
  {
    P(1.0F);
    if (this.UT) {
      bg(this.UV);
    }
  }
  
  public final void fz()
  {
    P(0.0F);
    if (this.UT) {
      bg(this.UU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.7.0.1
 */