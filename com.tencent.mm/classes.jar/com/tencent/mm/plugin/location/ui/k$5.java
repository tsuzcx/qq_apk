package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.bf.c;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;

final class k$5
  implements am.a
{
  k$5(k paramk) {}
  
  public final boolean tC()
  {
    if (this.lGT.lGJ == 3) {}
    for (int i = this.lGT.lGP.RH();; i = this.lGT.lGP.RI())
    {
      k localk = this.lGT;
      float f2 = i;
      float f1 = f2;
      if (f2 < 10.0F) {
        f1 = 10.0F;
      }
      f2 = f1;
      if (f1 > 100.0F) {
        f2 = 100.0F;
      }
      localk.lGC.setVolume(f2 / 100.0F);
      localk.lGC.invalidate();
      return true;
      if (bk.bl(this.lGT.lGG)) {
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.5
 * JD-Core Version:    0.7.0.1
 */