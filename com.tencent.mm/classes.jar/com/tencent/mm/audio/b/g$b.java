package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g$b
{
  private static boolean diT;
  private static boolean diU;
  
  static
  {
    AppMethodBeat.i(130007);
    diT = false;
    diU = false;
    init();
    AppMethodBeat.o(130007);
  }
  
  public static boolean PU()
  {
    return diT;
  }
  
  public static boolean PV()
  {
    return diU;
  }
  
  public static void init()
  {
    AppMethodBeat.i(177008);
    b localb = (b)com.tencent.mm.kernel.g.ab(b.class);
    if (localb != null) {
      if (localb.a(b.a.qNr, 1) != 1) {}
    }
    for (boolean bool = true;; bool = true)
    {
      ae.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", new Object[] { Boolean.valueOf(bool) });
      int i = m.aao();
      ae.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if (bool) {}
      for (;;)
      {
        try
        {
          g.class.getClassLoader();
          j.vN("wechatvoicesilk");
          diT = true;
          diU = true;
          ae.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(diT), Boolean.valueOf(diU) });
          AppMethodBeat.o(177008);
          return;
          bool = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          ae.e("MicroMsg.RecorderUtil", "load library failed!");
          diT = false;
          diU = false;
          continue;
        }
        if ((!bu.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bu.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
        {
          ae.i("MicroMsg.RecorderUtil", "don't contains armeabi");
          ae.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          diT = false;
          diU = false;
        }
        else if ((i & 0x400) != 0)
        {
          try
          {
            g.class.getClassLoader();
            j.vN("wechatvoicesilk");
            diT = true;
            diU = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            ae.e("MicroMsg.RecorderUtil", "load library failed!");
            diT = false;
            diU = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          ae.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
          diT = false;
          diU = false;
        }
        else
        {
          ae.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          diT = false;
          diU = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */