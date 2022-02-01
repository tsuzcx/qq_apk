package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

public final class b
{
  public static boolean bGo()
  {
    AppMethodBeat.i(50040);
    int i = bGp();
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
    if (g.ab(com.tencent.mm.plugin.expt.b.b.class) != null)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvA, 0) == 1) {}
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
  
  private static int bGp()
  {
    AppMethodBeat.i(50042);
    int i = ax.aQz("xweb_abtest_command").decodeInt("xweb_video_proxy_command_value", -1);
    AppMethodBeat.o(50042);
    return i;
  }
  
  public static boolean bGq()
  {
    AppMethodBeat.i(50043);
    int i = bGr();
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
    if (g.ab(com.tencent.mm.plugin.expt.b.b.class) != null)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvB, 0) == 1) {}
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
  
  private static int bGr()
  {
    AppMethodBeat.i(50045);
    int i = ax.aQz("xweb_abtest_command").decodeInt("xweb_video_hls_proxy_command_value", -1);
    AppMethodBeat.o(50045);
    return i;
  }
  
  public static void xe(int paramInt)
  {
    AppMethodBeat.i(50038);
    ax.aQz("xweb_abtest_command").encode("xweb_video_preload_command_value", paramInt);
    AppMethodBeat.o(50038);
  }
  
  public static void xf(int paramInt)
  {
    AppMethodBeat.i(50039);
    ax.aQz("xweb_abtest_command").encode("xweb_video_player_command_value", paramInt);
    AppMethodBeat.o(50039);
  }
  
  public static void xg(int paramInt)
  {
    AppMethodBeat.i(175095);
    ax.aQz("xweb_abtest_command").encode("xweb_hls_video_player_command_value", paramInt);
    AppMethodBeat.o(175095);
  }
  
  public static void xh(int paramInt)
  {
    AppMethodBeat.i(50041);
    ax.aQz("xweb_abtest_command").encode("xweb_video_proxy_command_value", paramInt);
    AppMethodBeat.o(50041);
  }
  
  public static void xi(int paramInt)
  {
    AppMethodBeat.i(50044);
    ax.aQz("xweb_abtest_command").encode("xweb_video_hls_proxy_command_value", paramInt);
    AppMethodBeat.o(50044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.b
 * JD-Core Version:    0.7.0.1
 */