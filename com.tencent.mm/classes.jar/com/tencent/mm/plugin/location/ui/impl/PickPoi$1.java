package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class PickPoi$1
  implements b.a
{
  PickPoi$1(PickPoi paramPickPoi) {}
  
  public final void b(Addr paramAddr)
  {
    y.d("MicroMsg.PickPoi", "onGetAddrss  %s", new Object[] { paramAddr.toString() });
    if (PickPoi.a(this.lJx) == null) {
      y.i("MicroMsg.PickPoi", "error, empty poi!");
    }
    do
    {
      return;
      f localf = PickPoi.a(this.lJx);
      localf.lJO = paramAddr;
      localf.lJE = paramAddr.ekZ;
      localf.aWE = paramAddr.elk;
      localf.aWF = paramAddr.ell;
      localf.lJI = paramAddr.ela;
      localf.lJJ = paramAddr.elb;
      localf.lJL = paramAddr.elf;
      localf.lJN = paramAddr.elh;
      localf.lJQ = paramAddr.elj;
      y.d("poidata", "roughAddr %s", new Object[] { paramAddr.toString() });
    } while (PickPoi.b(this.lJx) == null);
    PickPoi.b(this.lJx).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.PickPoi.1
 * JD-Core Version:    0.7.0.1
 */