package com.tencent.mm.plugin.base.model;

import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class d$3
  implements Runnable
{
  d$3(com.tencent.mm.ag.d.a parama, d.a parama1, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.WebviewShrotcutManager", "expired");
    if (d.Kd().contains(this.hRP))
    {
      d.Kd().remove(this.hRP);
      o.JQ().b(this.hRP);
      if (this.hRN != null) {
        this.hRN.el(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.d.3
 * JD-Core Version:    0.7.0.1
 */