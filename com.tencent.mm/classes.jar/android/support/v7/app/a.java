package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.d;

public final class a
  implements DrawerLayout.c
{
  private final a.a TU;
  private d TV;
  private boolean TW;
  boolean TX;
  private final int TY;
  private final int TZ;
  
  private void L(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.TV.aa(true);
    }
    for (;;)
    {
      this.TV.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.TV.aa(false);
      }
    }
  }
  
  private void bg(int paramInt)
  {
    this.TU.bg(paramInt);
  }
  
  public final void D(float paramFloat)
  {
    if (this.TW)
    {
      L(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    L(0.0F);
  }
  
  public final void fq()
  {
    L(1.0F);
    if (this.TX) {
      bg(this.TZ);
    }
  }
  
  public final void fr()
  {
    L(0.0F);
    if (this.TX) {
      bg(this.TY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.7.0.1
 */