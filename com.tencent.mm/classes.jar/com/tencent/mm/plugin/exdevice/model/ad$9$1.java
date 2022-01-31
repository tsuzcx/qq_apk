package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
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
    String str = (String)this.bjR;
    if (ad.aLN().BA(str))
    {
      au.Hx();
      if (!c.Fw().abg(str)) {
        au.Dk().a(new h(str, null), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9.1
 * JD-Core Version:    0.7.0.1
 */