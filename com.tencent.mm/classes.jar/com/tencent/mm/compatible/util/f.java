package com.tencent.mm.compatible.util;

import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class f
{
  public static boolean bs(long paramLong)
  {
    if (!zF())
    {
      y.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
      return false;
    }
    for (;;)
    {
      try
      {
        localStatFs = new StatFs(e.bkF);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            i = localStatFs.getBlockCount();
            l1 = i;
          }
          catch (Exception localException2)
          {
            StatFs localStatFs;
            int i;
            long l2;
            long l1 = 0L;
            continue;
          }
          try
          {
            i = localStatFs.getAvailableBlocks();
            l2 = i;
            if ((localStatFs == null) || (l1 <= 0L) || (l1 - l2 < 0L)) {
              break;
            }
            l1 = localStatFs.getBlockSize();
            if (localStatFs.getFreeBlocks() * l1 >= paramLong) {
              continue;
            }
            y.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + paramLong + " not enough and ret false");
            return false;
          }
          catch (Exception localException3) {}
        }
        localException1 = localException1;
        localStatFs = null;
        l1 = 0L;
      }
      y.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", new Object[] { localException1 });
      l2 = 0L;
    }
    return true;
  }
  
  public static boolean zF()
  {
    boolean bool2 = false;
    String str = h.getExternalStorageDirectory().getAbsolutePath();
    boolean bool1;
    if (e.bkF.equalsIgnoreCase(str))
    {
      bool1 = bool2;
      try
      {
        if (h.getExternalStorageState().equals("mounted"))
        {
          boolean bool3 = new File(str).canWrite();
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
        return bool1;
      }
      catch (Exception localException1)
      {
        y.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + localException1.getMessage() + " SDCARD_ROOT: " + e.bkF);
        return false;
      }
    }
    try
    {
      bool1 = new File(e.bkF).canWrite();
      return bool1;
    }
    catch (Exception localException2)
    {
      y.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + localException2.getMessage() + " SDCARD_ROOT: " + e.bkF);
    }
    return false;
  }
  
  public static boolean zG()
  {
    if (!zF()) {
      return false;
    }
    for (;;)
    {
      try
      {
        localStatFs = new StatFs(e.bkF);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          long l1;
          try
          {
            i = localStatFs.getBlockCount();
            l2 = i;
          }
          catch (Exception localException2)
          {
            StatFs localStatFs;
            int i;
            long l3;
            long l4;
            l1 = 0L;
            long l2 = 0L;
            continue;
          }
          try
          {
            i = localStatFs.getAvailableBlocks();
            l1 = i;
          }
          catch (Exception localException3)
          {
            l1 = 0L;
            continue;
          }
          try
          {
            i = localStatFs.getBlockSize();
            l3 = i;
            if ((localStatFs == null) || (l2 <= 0L) || (l2 - l1 < 0L)) {
              break;
            }
            i = (int)((l2 - l1) * 100L / l2);
            l4 = l3 * l1;
            y.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l3 * l2), Long.valueOf(l4), Integer.valueOf(i) });
            if ((95 > i) || (l4 > 314572800L)) {
              break;
            }
            y.i("MicroMsg.CUtil", "checkSDCardFull is full!");
            return true;
          }
          catch (Exception localException4) {}
        }
        localException1 = localException1;
        l1 = 0L;
        l2 = 0L;
        localStatFs = null;
      }
      y.e("MicroMsg.CUtil", "checkSDCardFull", new Object[] { localException1 });
      l3 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.f
 * JD-Core Version:    0.7.0.1
 */