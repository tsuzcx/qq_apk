package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

public final class b
{
  public static boolean bvn()
  {
    AppMethodBeat.i(50040);
    int i = bvo();
    if (i >= 0)
    {
      ad.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(50040);
        return true;
      }
      AppMethodBeat.o(50040);
      return false;
    }
    if (g.ab(com.tencent.mm.plugin.expt.a.b.class) != null)
    {
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pnF, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(50040);
        return bool;
      }
    }
    AppMethodBeat.o(50040);
    return false;
  }
  
  private static int bvo()
  {
    AppMethodBeat.i(50042);
    int i = ax.aFC("xweb_abtest_command").decodeInt("xweb_video_proxy_command_value", -1);
    AppMethodBeat.o(50042);
    return i;
  }
  
  public static boolean bvp()
  {
    AppMethodBeat.i(50043);
    int i = bvq();
    if (i >= 0)
    {
      ad.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoHlsProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(50043);
        return true;
      }
      AppMethodBeat.o(50043);
      return false;
    }
    if (g.ab(com.tencent.mm.plugin.expt.a.b.class) != null)
    {
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pnG, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "openXWebVideoHlsProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(50043);
        return bool;
      }
    }
    AppMethodBeat.o(50043);
    return false;
  }
  
  private static int bvq()
  {
    AppMethodBeat.i(50045);
    int i = ax.aFC("xweb_abtest_command").decodeInt("xweb_video_hls_proxy_command_value", -1);
    AppMethodBeat.o(50045);
    return i;
  }
  
  public static void vH(int paramInt)
  {
    AppMethodBeat.i(50038);
    ax.aFC("xweb_abtest_command").encode("xweb_video_preload_command_value", paramInt);
    AppMethodBeat.o(50038);
  }
  
  public static void vI(int paramInt)
  {
    AppMethodBeat.i(50039);
    ax.aFC("xweb_abtest_command").encode("xweb_video_player_command_value", paramInt);
    AppMethodBeat.o(50039);
  }
  
  public static void vJ(int paramInt)
  {
    AppMethodBeat.i(175095);
    ax.aFC("xweb_abtest_command").encode("xweb_hls_video_player_command_value", paramInt);
    AppMethodBeat.o(175095);
  }
  
  public static void vK(int paramInt)
  {
    AppMethodBeat.i(50041);
    ax.aFC("xweb_abtest_command").encode("xweb_video_proxy_command_value", paramInt);
    AppMethodBeat.o(50041);
  }
  
  public static void vL(int paramInt)
  {
    AppMethodBeat.i(50044);
    ax.aFC("xweb_abtest_command").encode("xweb_video_hls_proxy_command_value", paramInt);
    AppMethodBeat.o(50044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.b
 * JD-Core Version:    0.7.0.1
 */