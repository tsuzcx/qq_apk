package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class g$b
{
  private static boolean ckl;
  private static boolean ckm;
  
  static
  {
    AppMethodBeat.i(55758);
    ckl = false;
    ckm = false;
    int i = m.Lo();
    ab.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
    if ((!bo.isNullOrNil(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bo.isNullOrNil(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
    {
      ab.i("MicroMsg.RecorderUtil", "don't contains armeabi");
      k.a("wechatvoicesilk_v5", g.class.getClassLoader());
      Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
      ckl = true;
      ckm = false;
    }
    for (;;)
    {
      ab.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(ckl), Boolean.valueOf(ckm) });
      AppMethodBeat.o(55758);
      return;
      if ((i & 0x400) != 0)
      {
        try
        {
          k.a("wechatvoicesilk_v7a", g.class.getClassLoader());
          ckl = true;
          ckm = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          ab.e("MicroMsg.RecorderUtil", "load library failed!");
          ckl = false;
          ckm = false;
        }
      }
      else if ((i & 0x200) != 0)
      {
        k.a("wechatvoicesilk", g.class.getClassLoader());
        Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
        ckl = true;
        ckm = true;
      }
      else
      {
        k.a("wechatvoicesilk_v5", g.class.getClassLoader());
        Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
        ckl = true;
        ckm = false;
      }
    }
  }
  
  public static boolean EI()
  {
    return ckl;
  }
  
  public static boolean EJ()
  {
    return ckm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.g.b
 * JD-Core Version:    0.7.0.1
 */