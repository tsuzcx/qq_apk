package com.tencent.mm.plugin.appbrand.w.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

public final class a
{
  public static boolean aLz()
  {
    AppMethodBeat.i(143672);
    int i = as.apq("xweb_abtest_command").decodeInt("xweb_video_preload_command_value", -1);
    if (i >= 0)
    {
      ab.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openWeishiVideoPreload, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(143672);
        return true;
      }
      AppMethodBeat.o(143672);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUL, 0) == 1)
    {
      AppMethodBeat.o(143672);
      return true;
    }
    AppMethodBeat.o(143672);
    return false;
  }
  
  public static void rc(int paramInt)
  {
    AppMethodBeat.i(143673);
    as.apq("xweb_abtest_command").encode("xweb_video_preload_command_value", paramInt);
    AppMethodBeat.o(143673);
  }
  
  public static void rd(int paramInt)
  {
    AppMethodBeat.i(143674);
    as.apq("xweb_abtest_command").encode("xweb_video_player_command_value", paramInt);
    AppMethodBeat.o(143674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a.a
 * JD-Core Version:    0.7.0.1
 */