package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g$b
{
  private static boolean cWA;
  private static boolean cWB;
  
  static
  {
    AppMethodBeat.i(130007);
    cWA = false;
    cWB = false;
    init();
    AppMethodBeat.o(130007);
  }
  
  public static boolean Om()
  {
    return cWA;
  }
  
  public static boolean On()
  {
    return cWB;
  }
  
  public static void init()
  {
    AppMethodBeat.i(177008);
    b localb = (b)com.tencent.mm.kernel.g.ab(b.class);
    if (localb != null) {
      if (localb.a(b.a.qap, 1) != 1) {}
    }
    for (boolean bool = true;; bool = true)
    {
      ac.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", new Object[] { Boolean.valueOf(bool) });
      int i = m.XE();
      ac.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if (bool) {}
      for (;;)
      {
        try
        {
          g.class.getClassLoader();
          j.sC("wechatvoicesilk");
          cWA = true;
          cWB = true;
          ac.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(cWA), Boolean.valueOf(cWB) });
          AppMethodBeat.o(177008);
          return;
          bool = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          ac.e("MicroMsg.RecorderUtil", "load library failed!");
          cWA = false;
          cWB = false;
          continue;
        }
        if ((!bs.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bs.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
        {
          ac.i("MicroMsg.RecorderUtil", "don't contains armeabi");
          ac.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          cWA = false;
          cWB = false;
        }
        else if ((i & 0x400) != 0)
        {
          try
          {
            g.class.getClassLoader();
            j.sC("wechatvoicesilk");
            cWA = true;
            cWB = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            ac.e("MicroMsg.RecorderUtil", "load library failed!");
            cWA = false;
            cWB = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          ac.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
          cWA = false;
          cWB = false;
        }
        else
        {
          ac.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          cWA = false;
          cWB = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */