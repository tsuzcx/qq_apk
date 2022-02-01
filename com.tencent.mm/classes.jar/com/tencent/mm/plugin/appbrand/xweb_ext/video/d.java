package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class d
  implements l
{
  public final boolean cJs()
  {
    AppMethodBeat.i(50046);
    AppMethodBeat.o(50046);
    return true;
  }
  
  public final int cJt()
  {
    AppMethodBeat.i(50047);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_weishi_ps_command_value", -1);
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getWeishiVideoPreloadSize, command value:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(50047);
      return i;
    }
    i = ((c)h.ax(c.class)).a(c.a.yPF, -1);
    AppMethodBeat.o(50047);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.d
 * JD-Core Version:    0.7.0.1
 */