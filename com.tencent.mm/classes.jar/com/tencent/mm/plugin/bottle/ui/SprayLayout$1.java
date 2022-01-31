package com.tencent.mm.plugin.bottle.ui;

import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;

final class SprayLayout$1
  implements Runnable
{
  SprayLayout$1(SprayLayout paramSprayLayout) {}
  
  public final void run()
  {
    if (SprayLayout.a(this.iaZ) == 0)
    {
      SprayLayout.b(this.iaZ);
      SprayLayout.c(this.iaZ).clearAnimation();
      SprayLayout.c(this.iaZ).setVisibility(8);
      SprayLayout.d(this.iaZ);
    }
    while (SprayLayout.g(this.iaZ) > SprayLayout.h(this.iaZ))
    {
      this.iaZ.stop();
      return;
      if (SprayLayout.a(this.iaZ) == 1)
      {
        SprayLayout.e(this.iaZ).startAnimation(this.iaZ.iaP);
        SprayLayout.e(this.iaZ).setVisibility(0);
        SprayLayout.f(this.iaZ).setVisibility(8);
        SprayLayout.c(this.iaZ).setVisibility(8);
      }
      else if (SprayLayout.a(this.iaZ) == 2)
      {
        SprayLayout.e(this.iaZ).startAnimation(this.iaZ.iaQ);
        SprayLayout.f(this.iaZ).startAnimation(this.iaZ.iaP);
        SprayLayout.f(this.iaZ).setVisibility(0);
      }
      else if (SprayLayout.a(this.iaZ) == 3)
      {
        SprayLayout.e(this.iaZ).clearAnimation();
        SprayLayout.e(this.iaZ).setVisibility(8);
        SprayLayout.f(this.iaZ).startAnimation(this.iaZ.iaQ);
        SprayLayout.c(this.iaZ).startAnimation(this.iaZ.iaP);
        SprayLayout.c(this.iaZ).setVisibility(0);
      }
      else if (SprayLayout.a(this.iaZ) == 4)
      {
        SprayLayout.c(this.iaZ).startAnimation(this.iaZ.iaR);
        SprayLayout.f(this.iaZ).clearAnimation();
        SprayLayout.f(this.iaZ).setVisibility(8);
      }
    }
    SprayLayout.j(this.iaZ).postDelayed(SprayLayout.i(this.iaZ), 280L);
    SprayLayout.a(this.iaZ, SprayLayout.k(this.iaZ) % 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.SprayLayout.1
 * JD-Core Version:    0.7.0.1
 */