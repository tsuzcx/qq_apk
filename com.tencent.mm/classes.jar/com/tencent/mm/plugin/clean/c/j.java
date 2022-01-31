package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.h.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;

public final class j
  implements ar
{
  private static j iBY;
  public HashSet<String> iBL;
  public HashMap<String, Long> iBX;
  public long iBk;
  public long iBl;
  public long iBm;
  
  public static long aDI()
  {
    try
    {
      StatFs localStatFs = new StatFs(e.bkF);
      l1 = localStatFs.getBlockCount();
      int i = localStatFs.getBlockSize();
      l1 = i * l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
      }
    }
    l2 = l1;
    if (l1 <= 0L) {
      l2 = 1L;
    }
    return l2;
  }
  
  public static long aDJ()
  {
    try
    {
      StatFs localStatFs = new StatFs(e.bkF);
      l1 = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      l1 = i * l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
      }
    }
    l2 = l1;
    if (l1 <= 0L) {
      l2 = 1L;
    }
    return l2;
  }
  
  public static j aEb()
  {
    if (iBY == null) {
      iBY = new j();
    }
    return iBY;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    b.ayE().onAccountInitialized(null);
  }
  
  public final void bi(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
    this.iBk = 0L;
    this.iBl = 0L;
    this.iBm = 0L;
    if (this.iBX != null) {
      this.iBX.clear();
    }
    if (this.iBL != null) {
      this.iBL.clear();
    }
    d.aDV();
    b.ayE().onAccountRelease();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.j
 * JD-Core Version:    0.7.0.1
 */