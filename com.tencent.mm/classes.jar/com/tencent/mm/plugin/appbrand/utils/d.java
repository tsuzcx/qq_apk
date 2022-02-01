package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class d
{
  public static void DE(int paramInt)
  {
    AppMethodBeat.i(317395);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_preload_command_value", paramInt);
    AppMethodBeat.o(317395);
  }
  
  public static void DF(int paramInt)
  {
    AppMethodBeat.i(317399);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_player_command_value", paramInt);
    AppMethodBeat.o(317399);
  }
  
  public static void DG(int paramInt)
  {
    AppMethodBeat.i(317415);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_proxy_command_value", paramInt);
    AppMethodBeat.o(317415);
  }
  
  public static void DH(int paramInt)
  {
    AppMethodBeat.i(317428);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_hls_proxy_command_value", paramInt);
    AppMethodBeat.o(317428);
  }
  
  public static boolean cCQ()
  {
    AppMethodBeat.i(317446);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(317446);
      return true;
    }
    AppMethodBeat.o(317446);
    return false;
  }
  
  private static int cNo()
  {
    AppMethodBeat.i(317403);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_player_command_value", -1);
    AppMethodBeat.o(317403);
    return i;
  }
  
  public static boolean cNp()
  {
    AppMethodBeat.i(317408);
    int i = cNq();
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(317408);
        return true;
      }
      AppMethodBeat.o(317408);
      return false;
    }
    if (h.ax(c.class) != null)
    {
      if (((c)h.ax(c.class)).a(c.a.yPR, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(317408);
        return bool;
      }
    }
    AppMethodBeat.o(317408);
    return false;
  }
  
  private static int cNq()
  {
    AppMethodBeat.i(317419);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_proxy_command_value", -1);
    AppMethodBeat.o(317419);
    return i;
  }
  
  public static boolean cNr()
  {
    AppMethodBeat.i(317426);
    int i = cNs();
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoHlsProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(317426);
        return true;
      }
      AppMethodBeat.o(317426);
      return false;
    }
    if (h.ax(c.class) != null)
    {
      if (((c)h.ax(c.class)).a(c.a.yPS, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoHlsProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(317426);
        return bool;
      }
    }
    AppMethodBeat.o(317426);
    return false;
  }
  
  private static int cNs()
  {
    AppMethodBeat.i(317432);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_hls_proxy_command_value", -1);
    AppMethodBeat.o(317432);
    return i;
  }
  
  private static boolean cNt()
  {
    AppMethodBeat.i(317452);
    boolean bool = cCQ();
    c localc = (c)h.ax(c.class);
    if (localc != null)
    {
      bool = localc.a(c.a.yPK, bool);
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useThumbPlayer, expt is ".concat(String.valueOf(bool)));
    }
    for (;;)
    {
      AppMethodBeat.o(317452);
      return bool;
    }
  }
  
  public static int cNu()
  {
    AppMethodBeat.i(317456);
    int j = cNo();
    int i = j;
    if (-1 == j) {
      if (!cNt()) {
        break label31;
      }
    }
    label31:
    for (i = 5;; i = 4)
    {
      AppMethodBeat.o(317456);
      return i;
    }
  }
  
  public static void ld(boolean paramBoolean)
  {
    AppMethodBeat.i(317434);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("video_fix_notify_error_command_value", paramBoolean);
    AppMethodBeat.o(317434);
  }
  
  public static void le(boolean paramBoolean)
  {
    AppMethodBeat.i(317438);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("video_lock_cache_command_value", paramBoolean);
    AppMethodBeat.o(317438);
  }
  
  public static void lf(boolean paramBoolean)
  {
    AppMethodBeat.i(317441);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("video_cancel_cache_when_play_command_value", paramBoolean);
    AppMethodBeat.o(317441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.d
 * JD-Core Version:    0.7.0.1
 */