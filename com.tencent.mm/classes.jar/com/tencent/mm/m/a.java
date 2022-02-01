package com.tencent.mm.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public final class a
{
  public static int mbf = -1;
  public static final long[] mbg = { 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L };
  public static final long[] mbh = { 104857600L, 314572800L, 314572800L, 314572800L, 314572800L };
  
  public static int aTd()
  {
    AppMethodBeat.i(150029);
    long l2 = 0L;
    long l4 = 0L;
    double d = 0.0D;
    l1 = l2;
    try
    {
      StatFs localStatFs = new StatFs(g.aQa().getPath());
      l1 = l2;
      l3 = localStatFs.getAvailableBlocks();
      l1 = l2;
      l2 = localStatFs.getBlockSize() * l3;
      l1 = l2;
      l3 = localStatFs.getBlockCount() * localStatFs.getBlockSize();
      l1 = l2;
      long l5 = localStatFs.getFreeBlocks();
      l1 = l2;
      i = localStatFs.getBlockSize();
      l4 = l5 * i;
      d = l2 / l3;
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l3 = 0L;
        Log.e("MicroMsg.DbChecker", "get db spare space error");
        continue;
        if (mbf < 0)
        {
          mbf = mbg.length - 1;
          i = 0;
        }
        for (;;)
        {
          if (i < mbg.length)
          {
            if (l3 < mbg[i]) {
              mbf = i;
            }
          }
          else
          {
            if (l1 >= mbh[mbf]) {
              break label273;
            }
            i = 1;
            break;
          }
          i += 1;
        }
        int i = 0;
      }
    }
    if (l3 > 0L) {
      if (l1 < 52428800L)
      {
        i = 2;
        Log.i("MicroMsg.DbChecker", "checkRomSparespace[%d] available:%d all:%d freeSize :%d availPercent %f mobileSizeIndex %d", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Double.valueOf(d), Integer.valueOf(mbf) });
        AppMethodBeat.o(150029);
        return i;
      }
    }
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(150030);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("db_check_tip_time", paramLong).commit();
    AppMethodBeat.o(150030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.a
 * JD-Core Version:    0.7.0.1
 */