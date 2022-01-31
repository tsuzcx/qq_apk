package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.modelgeo.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    c.d(this.ksc);
    if (c.a(this.ksc) != null) {
      c.a(this.ksc).c(c.b(this.ksc));
    }
    if (c.b(this.ksc) == null)
    {
      y.w(c.BG(), "already callback");
      return;
    }
    c.c(this.ksc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.c.2
 * JD-Core Version:    0.7.0.1
 */