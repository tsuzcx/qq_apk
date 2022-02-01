package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g$b
{
  private static boolean cZe;
  private static boolean cZf;
  
  static
  {
    AppMethodBeat.i(130007);
    cZe = false;
    cZf = false;
    init();
    AppMethodBeat.o(130007);
  }
  
  public static boolean Oq()
  {
    return cZe;
  }
  
  public static boolean Or()
  {
    return cZf;
  }
  
  public static void init()
  {
    AppMethodBeat.i(177008);
    b localb = (b)com.tencent.mm.kernel.g.ab(b.class);
    if (localb != null) {
      if (localb.a(b.a.pwb, 1) != 1) {}
    }
    for (boolean bool = true;; bool = true)
    {
      ad.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", new Object[] { Boolean.valueOf(bool) });
      int i = m.WG();
      ad.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if (bool) {}
      for (;;)
      {
        try
        {
          g.class.getClassLoader();
          j.pq("wechatvoicesilk");
          cZe = true;
          cZf = true;
          ad.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(cZe), Boolean.valueOf(cZf) });
          AppMethodBeat.o(177008);
          return;
          bool = false;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          ad.e("MicroMsg.RecorderUtil", "load library failed!");
          cZe = false;
          cZf = false;
          continue;
        }
        if ((!bt.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bt.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
        {
          ad.i("MicroMsg.RecorderUtil", "don't contains armeabi");
          ad.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          cZe = false;
          cZf = false;
        }
        else if ((i & 0x400) != 0)
        {
          try
          {
            g.class.getClassLoader();
            j.pq("wechatvoicesilk");
            cZe = true;
            cZf = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            ad.e("MicroMsg.RecorderUtil", "load library failed!");
            cZe = false;
            cZf = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          ad.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
          cZe = false;
          cZf = false;
        }
        else
        {
          ad.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
          cZe = false;
          cZf = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */