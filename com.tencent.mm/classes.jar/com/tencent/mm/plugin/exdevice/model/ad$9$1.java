package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.b.b.a;
import com.tencent.mm.storage.bd;

final class ad$9$1
  implements Runnable
{
  ad$9$1(ad.9 param9, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(19383);
    String str = (String)this.bFJ;
    if (ad.bqa().LC(str))
    {
      aw.aaz();
      if (!c.YA().arr(str)) {
        aw.Rc().a(new h(str, null), 0);
      }
    }
    AppMethodBeat.o(19383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9.1
 * JD-Core Version:    0.7.0.1
 */