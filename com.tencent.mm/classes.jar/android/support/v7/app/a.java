package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.d;

public final class a
  implements DrawerLayout.c
{
  private final a.a WF;
  private d WG;
  private boolean WH;
  boolean WI;
  private final int WJ;
  private final int WK;
  
  private void N(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.WG.aa(true);
    }
    for (;;)
    {
      this.WG.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.WG.aa(false);
      }
    }
  }
  
  private void bg(int paramInt)
  {
    this.WF.bg(paramInt);
  }
  
  public final void F(float paramFloat)
  {
    if (this.WH)
    {
      N(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    N(0.0F);
  }
  
  public final void fP()
  {
    N(1.0F);
    if (this.WI) {
      bg(this.WK);
    }
  }
  
  public final void fQ()
  {
    N(0.0F);
    if (this.WI) {
      bg(this.WJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.app.a
 * JD-Core Version:    0.7.0.1
 */