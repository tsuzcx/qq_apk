package com.tencent.mm.plugin.g;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class f
  extends a
{
  public final void execute(g paramg)
  {
    int i = m.yR();
    if ((i & 0x400) != 0)
    {
      y.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", new Object[] { Integer.valueOf(i >> 12) });
      k.b("wechatsight_v7a", getClass().getClassLoader());
      if (i >> 12 >= 4)
      {
        com.tencent.mm.plugin.sight.base.b.odY = 3;
        com.tencent.mm.plugin.sight.base.b.oea = 3;
        com.tencent.mm.plugin.sight.base.b.oeb = 544000;
        return;
      }
      com.tencent.mm.plugin.sight.base.b.odY = 1;
      com.tencent.mm.plugin.sight.base.b.oea = 1;
      com.tencent.mm.plugin.sight.base.b.oeb = 640000;
      return;
    }
    y.i("MicroMsg.SightInitTask", "load wechatsight");
    k.b("wechatsight", getClass().getClassLoader());
    Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
    com.tencent.mm.plugin.sight.base.b.odY = 1;
    com.tencent.mm.plugin.sight.base.b.oea = 1;
    com.tencent.mm.plugin.sight.base.b.oeb = 640000;
  }
  
  public final String name()
  {
    return "boot-sight-init";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.g.f
 * JD-Core Version:    0.7.0.1
 */