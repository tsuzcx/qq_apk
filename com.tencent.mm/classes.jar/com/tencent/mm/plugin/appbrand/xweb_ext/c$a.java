package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
final class c$a
  extends q
  implements a<Boolean>
{
  public static final a nwx;
  
  static
  {
    AppMethodBeat.i(224030);
    nwx = new a();
    AppMethodBeat.o(224030);
  }
  
  c$a()
  {
    super(0);
  }
  
  private static boolean hZ()
  {
    AppMethodBeat.i(224029);
    for (;;)
    {
      try
      {
        int i = ((b)g.ab(b.class)).a(b.a.qCI, 0);
        if (i != 1) {
          continue;
        }
        bool = true;
      }
      catch (Throwable localThrowable)
      {
        boolean bool = false;
        continue;
      }
      ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "abtestXWebCameraEnable: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(224029);
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c.a
 * JD-Core Version:    0.7.0.1
 */