package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.d;

public final class a
  implements DrawerLayout.c
{
  private final a.a WS;
  private d WT;
  private boolean WU;
  boolean WV;
  private final int WW;
  private final int WX;
  
  private void N(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.WT.Z(true);
    }
    for (;;)
    {
      this.WT.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.WT.Z(false);
      }
    }
  }
  
  private void bh(int paramInt)
  {
    this.WS.bh(paramInt);
  }
  
  public final void F(float paramFloat)
  {
    if (this.WU)
    {
      N(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    N(0.0F);
  }
  
  public final void fW()
  {
    N(1.0F);
    if (this.WV) {
      bh(this.WX);
    }
  }
  
  public final void fX()
  {
    N(0.0F);
    if (this.WV) {
      bh(this.WW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.7.0.1
 */