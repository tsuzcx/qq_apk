package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
final class c$a
  extends d.g.b.l
  implements a<Boolean>
{
  public static final a mQE;
  
  static
  {
    AppMethodBeat.i(187510);
    mQE = new a();
    AppMethodBeat.o(187510);
  }
  
  c$a()
  {
    super(0);
  }
  
  private static boolean hJ()
  {
    AppMethodBeat.i(187509);
    for (;;)
    {
      try
      {
        int i = ((b)g.ab(b.class)).a(b.a.pRo, 0);
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
      ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "abtestXWebCameraEnable: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(187509);
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c.a
 * JD-Core Version:    0.7.0.1
 */