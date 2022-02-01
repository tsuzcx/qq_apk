package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class c
{
  public static void Dk(int paramInt)
  {
    AppMethodBeat.i(268835);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_preload_command_value", paramInt);
    AppMethodBeat.o(268835);
  }
  
  public static void Dl(int paramInt)
  {
    AppMethodBeat.i(268836);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_player_command_value", paramInt);
    AppMethodBeat.o(268836);
  }
  
  public static void Dm(int paramInt)
  {
    AppMethodBeat.i(268839);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_proxy_command_value", paramInt);
    AppMethodBeat.o(268839);
  }
  
  public static void Dn(int paramInt)
  {
    AppMethodBeat.i(268844);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_hls_proxy_command_value", paramInt);
    AppMethodBeat.o(268844);
  }
  
  public static boolean ccu()
  {
    AppMethodBeat.i(268852);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(268852);
      return true;
    }
    AppMethodBeat.o(268852);
    return false;
  }
  
  private static int clX()
  {
    AppMethodBeat.i(268837);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_player_command_value", -1);
    AppMethodBeat.o(268837);
    return i;
  }
  
  public static boolean clY()
  {
    AppMethodBeat.i(268838);
    int i = clZ();
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(268838);
        return true;
      }
      AppMethodBeat.o(268838);
      return false;
    }
    if (h.ae(b.class) != null)
    {
      if (((b)h.ae(b.class)).a(b.a.vBK, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(268838);
        return bool;
      }
    }
    AppMethodBeat.o(268838);
    return false;
  }
  
  private static int clZ()
  {
    AppMethodBeat.i(268841);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_proxy_command_value", -1);
    AppMethodBeat.o(268841);
    return i;
  }
  
  public static boolean cma()
  {
    AppMethodBeat.i(268842);
    int i = cmb();
    if (i >= 0)
    {
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoHlsProxy, command value:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(268842);
        return true;
      }
      AppMethodBeat.o(268842);
      return false;
    }
    if (h.ae(b.class) != null)
    {
      if (((b)h.ae(b.class)).a(b.a.vBL, 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "openXWebVideoHlsProxy, expt is %s", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(268842);
        return bool;
      }
    }
    AppMethodBeat.o(268842);
    return false;
  }
  
  private static int cmb()
  {
    AppMethodBeat.i(268846);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_hls_proxy_command_value", -1);
    AppMethodBeat.o(268846);
    return i;
  }
  
  private static boolean cmc()
  {
    AppMethodBeat.i(268853);
    boolean bool = ccu();
    b localb = (b)h.ae(b.class);
    if (localb != null)
    {
      bool = localb.a(b.a.vBI, bool);
      Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "useThumbPlayer, expt is ".concat(String.valueOf(bool)));
    }
    for (;;)
    {
      AppMethodBeat.o(268853);
      return bool;
    }
  }
  
  public static int cmd()
  {
    AppMethodBeat.i(268855);
    int j = clX();
    int i = j;
    if (-1 == j) {
      if (!cmc()) {
        break label31;
      }
    }
    label31:
    for (i = 5;; i = 4)
    {
      AppMethodBeat.o(268855);
      return i;
    }
  }
  
  public static void jT(boolean paramBoolean)
  {
    AppMethodBeat.i(268848);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("video_fix_notify_error_command_value", paramBoolean);
    AppMethodBeat.o(268848);
  }
  
  public static void jU(boolean paramBoolean)
  {
    AppMethodBeat.i(268849);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("video_lock_cache_command_value", paramBoolean);
    AppMethodBeat.o(268849);
  }
  
  public static void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(268851);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("video_cancel_cache_when_play_command_value", paramBoolean);
    AppMethodBeat.o(268851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c
 * JD-Core Version:    0.7.0.1
 */