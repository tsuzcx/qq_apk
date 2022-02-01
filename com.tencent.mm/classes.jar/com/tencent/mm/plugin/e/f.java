package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;

public class f
  extends a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(133571);
    int i = m.aon();
    Log.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", new Object[] { Integer.valueOf(i >> 12) });
    getClass().getClassLoader();
    j.Ed("wechatsight_v7a");
    if (i >> 12 >= 4)
    {
      com.tencent.mm.plugin.sight.base.c.Dma = 3;
      com.tencent.mm.plugin.sight.base.c.Dmc = 3;
      com.tencent.mm.plugin.sight.base.c.Dmd = 544000;
      AppMethodBeat.o(133571);
      return;
    }
    com.tencent.mm.plugin.sight.base.c.Dma = 1;
    com.tencent.mm.plugin.sight.base.c.Dmc = 1;
    com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
    AppMethodBeat.o(133571);
  }
  
  public String name()
  {
    return "boot-sight-init";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.e.f
 * JD-Core Version:    0.7.0.1
 */