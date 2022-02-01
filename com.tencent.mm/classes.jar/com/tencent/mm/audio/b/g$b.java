package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g$b
{
  private static boolean dAe;
  private static boolean dAf;
  
  static
  {
    AppMethodBeat.i(130007);
    dAe = false;
    dAf = false;
    init();
    AppMethodBeat.o(130007);
  }
  
  public static boolean aao()
  {
    return dAe;
  }
  
  public static boolean aap()
  {
    return dAf;
  }
  
  public static void init()
  {
    AppMethodBeat.i(177008);
    b localb = (b)com.tencent.mm.kernel.g.af(b.class);
    if (localb != null) {
      if (localb.a(b.a.skm, 1) != 1) {}
    }
    for (boolean bool = true;; bool = true)
    {
      Log.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", new Object[] { Boolean.valueOf(bool) });
      int i = m.aon();
      Log.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if (bool) {}
      for (;;)
      {
        try
        {
          g.class.getClassLoader();
          j.Ed("wechatvoicesilk");
          dAe = true;
          dAf = true;
          Log.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(dAe), Boolean.valueOf(dAf) });
          AppMethodBeat.o(177008);
          return;
          bool = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          Log.e("MicroMsg.RecorderUtil", "load library failed!");
          dAe = false;
          dAf = false;
          continue;
        }
        if ((!Util.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!Util.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
        {
          Log.i("MicroMsg.RecorderUtil", "don't contains armeabi");
          Log.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          dAe = false;
          dAf = false;
        }
        else if ((i & 0x400) != 0)
        {
          try
          {
            g.class.getClassLoader();
            j.Ed("wechatvoicesilk");
            dAe = true;
            dAf = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            Log.e("MicroMsg.RecorderUtil", "load library failed!");
            dAe = false;
            dAf = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          Log.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
          dAe = false;
          dAf = false;
        }
        else
        {
          Log.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          dAe = false;
          dAf = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */