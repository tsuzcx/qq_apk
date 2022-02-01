package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class c
  implements k
{
  public final boolean bVs()
  {
    AppMethodBeat.i(50046);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_preload_command_value", -1);
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openWeishiVideoPreload, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(50046);
        return true;
      }
      AppMethodBeat.o(50046);
      return false;
    }
    if (((b)g.af(b.class)).a(b.a.rVl, 0) == 1)
    {
      AppMethodBeat.o(50046);
      return true;
    }
    AppMethodBeat.o(50046);
    return false;
  }
  
  public final int bVt()
  {
    AppMethodBeat.i(50047);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_weishi_ps_command_value", -1);
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getWeishiVideoPreloadSize, command value:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(50047);
      return i;
    }
    i = ((b)g.af(b.class)).a(b.a.rVm, -1);
    AppMethodBeat.o(50047);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.c
 * JD-Core Version:    0.7.0.1
 */