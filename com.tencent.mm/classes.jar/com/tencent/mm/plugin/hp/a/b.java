package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.a;
import com.tencent.mm.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.RandomAccessFile;

public final class b
{
  public static int A(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(117378);
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      try
      {
        File localFile2 = new File(paramString1);
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile2, "r");
        File localFile1 = new File(paramString3);
        y.bDX(y.bEo(paramString3));
        paramString2 = new File(paramString2);
        if ((localFile2.exists()) && (paramString2.exists()))
        {
          int j = 0;
          int i = j;
          if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion <= 29)
          {
            paramString1 = com.tencent.mm.d.a.hY(paramString1);
            i = j;
            if (paramString1 != null)
            {
              i = j;
              if (paramString1.hel != null)
              {
                i = paramString1.hel.heo + 8;
                Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          if (i != 0) {}
          for (i = d.a(localRandomAccessFile, localFile1, paramString2, i); i != 1; i = com.tencent.tinker.b.a.a(localRandomAccessFile, localFile1, paramString2))
          {
            Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
            localRandomAccessFile.close();
            AppMethodBeat.o(117378);
            return -1;
          }
          localRandomAccessFile.close();
          if (!paramString4.equalsIgnoreCase(y.bub(paramString3)))
          {
            Log.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", new Object[] { paramString4, y.bub(paramString3) });
            AppMethodBeat.o(117378);
            return -2;
          }
          AppMethodBeat.o(117378);
          return 0;
        }
        Log.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", new Object[] { Boolean.valueOf(localFile2.exists()), Boolean.valueOf(localFile1.exists()), Boolean.valueOf(paramString2.exists()) });
        localRandomAccessFile.close();
        AppMethodBeat.o(117378);
        return -1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", paramString1, "merge apk failed.", new Object[0]);
        AppMethodBeat.o(117378);
        return -1;
      }
    }
    AppMethodBeat.o(117378);
    return -1;
  }
  
  public static int B(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(261821);
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {}
    for (;;)
    {
      try
      {
        File localFile2 = new File(paramString1);
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile2, "r");
        File localFile1 = new File(paramString3);
        y.bDX(y.bEo(paramString3));
        paramString2 = new File(paramString2);
        if ((localFile2.exists()) && (paramString2.exists()))
        {
          if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion > 29) {
            break label336;
          }
          paramString1 = com.tencent.mm.d.a.hY(paramString1);
          if ((paramString1 == null) || (paramString1.hel == null)) {
            break label336;
          }
          i = paramString1.hel.heo + 8;
          Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", new Object[] { Integer.valueOf(i) });
          if (i != 0)
          {
            i = d.a(localRandomAccessFile, localFile1, paramString2, i);
            if (i != 1)
            {
              Log.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
              localRandomAccessFile.close();
              AppMethodBeat.o(261821);
              return -2;
            }
          }
          else
          {
            i = com.tencent.tinker.b.a.a(localRandomAccessFile, localFile1, paramString2);
            continue;
          }
          localRandomAccessFile.close();
          if (!paramString4.equalsIgnoreCase(y.bub(paramString3)))
          {
            Log.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", new Object[] { paramString4, y.bub(paramString3) });
            AppMethodBeat.o(261821);
            return -3;
          }
          AppMethodBeat.o(261821);
          return 0;
        }
        Log.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", new Object[] { Boolean.valueOf(localFile2.exists()), Boolean.valueOf(localFile1.exists()), Boolean.valueOf(paramString2.exists()) });
        localRandomAccessFile.close();
        AppMethodBeat.o(261821);
        return -1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", paramString1, "merge apk failed.", new Object[0]);
        AppMethodBeat.o(261821);
        return -4;
      }
      AppMethodBeat.o(261821);
      return -5;
      label336:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.b
 * JD-Core Version:    0.7.0.1
 */