package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g$b
{
  private static boolean fsT;
  private static boolean fsU;
  
  static
  {
    AppMethodBeat.i(130007);
    fsT = false;
    fsU = false;
    init();
    AppMethodBeat.o(130007);
  }
  
  public static boolean afa()
  {
    return fsT;
  }
  
  public static boolean afb()
  {
    return fsU;
  }
  
  public static void init()
  {
    AppMethodBeat.i(177008);
    b localb = (b)h.ae(b.class);
    if (localb != null) {
      if (localb.a(b.a.vUG, 1) != 1) {}
    }
    for (boolean bool = true;; bool = true)
    {
      Log.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", new Object[] { Boolean.valueOf(bool) });
      int i = m.aus();
      Log.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if (bool) {}
      for (;;)
      {
        try
        {
          g.class.getClassLoader();
          j.KW("wechatvoicesilk");
          fsT = true;
          fsU = true;
          Log.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(fsT), Boolean.valueOf(fsU) });
          AppMethodBeat.o(177008);
          return;
          bool = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          Log.e("MicroMsg.RecorderUtil", "load library failed!");
          fsT = false;
          fsU = false;
          continue;
        }
        if ((!Util.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!Util.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
        {
          Log.i("MicroMsg.RecorderUtil", "don't contains armeabi");
          Log.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          fsT = false;
          fsU = false;
        }
        else if ((i & 0x400) != 0)
        {
          try
          {
            g.class.getClassLoader();
            j.KW("wechatvoicesilk");
            fsT = true;
            fsU = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            Log.e("MicroMsg.RecorderUtil", "load library failed!");
            fsT = false;
            fsU = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          Log.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
          fsT = false;
          fsU = false;
        }
        else
        {
          Log.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          fsT = false;
          fsU = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */