package com.tencent.mm.f.b;

import android.os.Build;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class g$b
{
  private static boolean bDw = false;
  private static boolean bDx = false;
  
  static
  {
    int i = m.yR();
    y.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
    if ((!bk.bl(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bk.bl(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
    {
      y.i("MicroMsg.RecorderUtil", "don't contains armeabi");
      k.b("wechatvoicesilk_v5", g.class.getClassLoader());
      Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
      bDw = true;
      bDx = false;
    }
    for (;;)
    {
      y.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(bDw), Boolean.valueOf(bDx) });
      return;
      if ((i & 0x400) != 0)
      {
        try
        {
          k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
          bDw = true;
          bDx = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          y.e("MicroMsg.RecorderUtil", "load library failed!");
          bDw = false;
          bDx = false;
        }
      }
      else if ((i & 0x200) != 0)
      {
        k.b("wechatvoicesilk", g.class.getClassLoader());
        Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
        bDw = true;
        bDx = true;
      }
      else
      {
        k.b("wechatvoicesilk_v5", g.class.getClassLoader());
        Assert.assertTrue("Can't remove libwechatvoicesilk.so yet.", false);
        bDw = true;
        bDx = false;
      }
    }
  }
  
  public static boolean uv()
  {
    return bDw;
  }
  
  public static boolean uw()
  {
    return bDx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.g.b
 * JD-Core Version:    0.7.0.1
 */