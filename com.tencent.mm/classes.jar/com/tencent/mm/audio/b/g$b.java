package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g$b
{
  private static boolean dhQ;
  private static boolean dhR;
  
  static
  {
    AppMethodBeat.i(130007);
    dhQ = false;
    dhR = false;
    init();
    AppMethodBeat.o(130007);
  }
  
  public static boolean PV()
  {
    return dhQ;
  }
  
  public static boolean PW()
  {
    return dhR;
  }
  
  public static void init()
  {
    AppMethodBeat.i(177008);
    b localb = (b)com.tencent.mm.kernel.g.ab(b.class);
    if (localb != null) {
      if (localb.a(b.a.qFL, 1) != 1) {}
    }
    for (boolean bool = true;; bool = true)
    {
      ad.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", new Object[] { Boolean.valueOf(bool) });
      int i = m.aaf();
      ad.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if (bool) {}
      for (;;)
      {
        try
        {
          g.class.getClassLoader();
          j.vr("wechatvoicesilk");
          dhQ = true;
          dhR = true;
          ad.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(dhQ), Boolean.valueOf(dhR) });
          AppMethodBeat.o(177008);
          return;
          bool = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          ad.e("MicroMsg.RecorderUtil", "load library failed!");
          dhQ = false;
          dhR = false;
          continue;
        }
        if ((!bt.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bt.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
        {
          ad.i("MicroMsg.RecorderUtil", "don't contains armeabi");
          ad.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          dhQ = false;
          dhR = false;
        }
        else if ((i & 0x400) != 0)
        {
          try
          {
            g.class.getClassLoader();
            j.vr("wechatvoicesilk");
            dhQ = true;
            dhR = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            ad.e("MicroMsg.RecorderUtil", "load library failed!");
            dhQ = false;
            dhR = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          ad.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
          dhQ = false;
          dhR = false;
        }
        else
        {
          ad.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          dhQ = false;
          dhR = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */