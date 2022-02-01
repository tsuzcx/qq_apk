package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b
{
  public static void AP(int paramInt)
  {
    AppMethodBeat.i(50038);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_preload_command_value", paramInt);
    AppMethodBeat.o(50038);
  }
  
  public static void AQ(int paramInt)
  {
    AppMethodBeat.i(50039);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_player_command_value", paramInt);
    AppMethodBeat.o(50039);
  }
  
  public static void AR(int paramInt)
  {
    AppMethodBeat.i(175095);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_hls_video_player_command_value", paramInt);
    AppMethodBeat.o(175095);
  }
  
  public static void AS(int paramInt)
  {
    AppMethodBeat.i(50041);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_proxy_command_value", paramInt);
    AppMethodBeat.o(50041);
  }
  
  public static void AT(int paramInt)
  {
    AppMethodBeat.i(50044);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_hls_proxy_command_value", paramInt);
    AppMethodBeat.o(50044);
  }
  
  public static boolean cdM()
  {
    AppMethodBeat.i(50040);
    int i = cdN();
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(50040);
        return true;
      }
      AppMethodBeat.o(50040);
      return false;
    }
    if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVp, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(50040);
        return bool;
      }
    }
    AppMethodBeat.o(50040);
    return false;
  }
  
  private static int cdN()
  {
    AppMethodBeat.i(50042);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_proxy_command_value", -1);
    AppMethodBeat.o(50042);
    return i;
  }
  
  public static boolean cdO()
  {
    AppMethodBeat.i(50043);
    int i = cdP();
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoHlsProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(50043);
        return true;
      }
      AppMethodBeat.o(50043);
      return false;
    }
    if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVq, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoHlsProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(50043);
        return bool;
      }
    }
    AppMethodBeat.o(50043);
    return false;
  }
  
  private static int cdP()
  {
    AppMethodBeat.i(50045);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_hls_proxy_command_value", -1);
    AppMethodBeat.o(50045);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.b
 * JD-Core Version:    0.7.0.1
 */