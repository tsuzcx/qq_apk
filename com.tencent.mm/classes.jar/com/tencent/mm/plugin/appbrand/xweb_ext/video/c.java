package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;

public final class c
  implements j
{
  public final boolean bua()
  {
    AppMethodBeat.i(50046);
    int i = aw.aKT("xweb_abtest_command").decodeInt("xweb_video_preload_command_value", -1);
    if (i >= 0)
    {
      ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openWeishiVideoPreload, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(50046);
        return true;
      }
      AppMethodBeat.o(50046);
      return false;
    }
    if (((b)g.ab(b.class)).a(b.a.pRc, 0) == 1)
    {
      AppMethodBeat.o(50046);
      return true;
    }
    AppMethodBeat.o(50046);
    return false;
  }
  
  public final int bub()
  {
    AppMethodBeat.i(50047);
    int i = aw.aKT("xweb_abtest_command").decodeInt("xweb_video_weishi_ps_command_value", -1);
    if (i >= 0)
    {
      ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getWeishiVideoPreloadSize, command value:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(50047);
      return i;
    }
    i = ((b)g.ab(b.class)).a(b.a.pRd, -1);
    AppMethodBeat.o(50047);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.c
 * JD-Core Version:    0.7.0.1
 */