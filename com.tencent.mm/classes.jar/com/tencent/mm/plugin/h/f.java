package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;

public class f
  extends a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(133571);
    int i = m.aOK();
    Log.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", new Object[] { Integer.valueOf(i >> 12) });
    getClass().getClassLoader();
    k.DA("wechatsight_v7a");
    if (i >> 12 >= 4)
    {
      com.tencent.mm.plugin.sight.base.d.PFh = 3;
      com.tencent.mm.plugin.sight.base.d.PFj = 3;
      com.tencent.mm.plugin.sight.base.d.PFk = 544000;
      AppMethodBeat.o(133571);
      return;
    }
    com.tencent.mm.plugin.sight.base.d.PFh = 1;
    com.tencent.mm.plugin.sight.base.d.PFj = 1;
    com.tencent.mm.plugin.sight.base.d.PFk = 640000;
    AppMethodBeat.o(133571);
  }
  
  public String name()
  {
    return "boot-sight-init";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.f
 * JD-Core Version:    0.7.0.1
 */