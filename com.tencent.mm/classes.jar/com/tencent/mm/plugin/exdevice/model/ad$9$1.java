package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.g.a.h;
import com.tencent.mm.plugin.exdevice.g.b.b.a;
import com.tencent.mm.storage.bv;

final class ad$9$1
  implements Runnable
{
  ad$9$1(ad.9 param9, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(23451);
    String str = (String)this.cDz;
    if (ad.cKN().anD(str))
    {
      bg.aVF();
      if (!c.aSN().bjG(str)) {
        bg.azz().a(new h(str, null), 0);
      }
    }
    AppMethodBeat.o(23451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9.1
 * JD-Core Version:    0.7.0.1
 */