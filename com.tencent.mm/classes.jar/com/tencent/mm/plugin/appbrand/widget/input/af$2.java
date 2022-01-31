package com.tencent.mm.plugin.appbrand.widget.input;

import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.c.f;
import com.tencent.mm.sdk.platformtools.y;

final class af$2
  implements Runnable
{
  af$2(af paramaf) {}
  
  public final void run()
  {
    if (!this.hvT.hvQ) {}
    do
    {
      return;
      c.f localf = c.bU(this.hvT.hvM);
      if ((this.hvT.hvO == null) || (Math.abs(this.hvT.hvO.x - localf.x) > 1.0F) || (Math.abs(this.hvT.hvO.y - localf.y) > 1.0F))
      {
        y.v(this.hvT.TAG, "check long press timeout, but view has moved.");
        return;
      }
    } while (this.hvT.hvP == null);
    this.hvT.hvQ = false;
    this.hvT.hvM.removeCallbacks(this.hvT.hvR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.af.2
 * JD-Core Version:    0.7.0.1
 */