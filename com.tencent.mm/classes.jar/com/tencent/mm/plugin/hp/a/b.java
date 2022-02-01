package com.tencent.mm.plugin.hp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.d.a.a;
import com.tencent.mm.d.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.io.RandomAccessFile;

public final class b
{
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(117378);
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      try
      {
        File localFile2 = new File(paramString1);
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile2, "r");
        File localFile1 = new File(paramString3);
        i.aSh(i.aSs(paramString3));
        paramString2 = new File(paramString2);
        if ((localFile2.exists()) && (paramString2.exists()))
        {
          int j = 0;
          paramString1 = a.ea(paramString1);
          int i = j;
          if (paramString1 != null)
          {
            i = j;
            if (paramString1.cGU != null)
            {
              i = paramString1.cGU.cGX + 8;
              ac.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", new Object[] { Integer.valueOf(i) });
            }
          }
          if (d.a(localRandomAccessFile, localFile1, paramString2, i) != 1)
          {
            ac.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
            localRandomAccessFile.close();
            AppMethodBeat.o(117378);
            return -1;
          }
          localRandomAccessFile.close();
          if (!paramString4.equalsIgnoreCase(i.aKe(paramString3)))
          {
            ac.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", new Object[] { paramString4, i.aKe(paramString3) });
            AppMethodBeat.o(117378);
            return -2;
          }
          paramString1 = new com.tencent.mm.d.b();
          paramString1.apkMd5 = paramString4;
          new a(paramString1).A(localFile1);
          AppMethodBeat.o(117378);
          return 0;
        }
        ac.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", new Object[] { Boolean.valueOf(localFile2.exists()), Boolean.valueOf(localFile1.exists()), Boolean.valueOf(paramString2.exists()) });
        localRandomAccessFile.close();
        AppMethodBeat.o(117378);
        return -1;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", paramString1, "merge apk failed.", new Object[0]);
        AppMethodBeat.o(117378);
        return -1;
      }
    }
    AppMethodBeat.o(117378);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.b
 * JD-Core Version:    0.7.0.1
 */