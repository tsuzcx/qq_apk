package com.tencent.mm.plugin.hp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.c.a.a;
import com.tencent.mm.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.RandomAccessFile;

public final class b
{
  public static int b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(90546);
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      try
      {
        File localFile2 = new File(paramString1);
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile2, "r");
        File localFile1 = new File(paramString3);
        e.cR(paramString3);
        paramString2 = new File(paramString2);
        if ((localFile2.exists()) && (paramString2.exists()))
        {
          int j = 0;
          paramString1 = a.dn(paramString1);
          int i = j;
          if (paramString1 != null)
          {
            i = j;
            if (paramString1.bWq != null)
            {
              i = paramString1.bWq.bWt + 8;
              ab.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:extLen = %d", new Object[] { Integer.valueOf(i) });
            }
          }
          if (d.a(localRandomAccessFile, localFile1, paramString2, i) != 1)
          {
            ab.i("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
            localRandomAccessFile.close();
            AppMethodBeat.o(90546);
            return -1;
          }
          localRandomAccessFile.close();
          if (!paramString4.equalsIgnoreCase(g.getMD5(paramString3)))
          {
            ab.i("MicroMsg.Tinker.MergeBsDiffApk", "newApkMd5:%s file md5:%s", new Object[] { paramString4, g.getMD5(paramString3) });
            AppMethodBeat.o(90546);
            return -2;
          }
          paramString1 = new com.tencent.mm.c.b();
          paramString1.apkMd5 = paramString4;
          new a(paramString1).t(localFile1);
          AppMethodBeat.o(90546);
          return 0;
        }
        ab.e("MicroMsg.Tinker.MergeBsDiffApk", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=%s , newFile.exists()=%s , patch.exists()=%s ", new Object[] { Boolean.valueOf(localFile2.exists()), Boolean.valueOf(localFile1.exists()), Boolean.valueOf(paramString2.exists()) });
        localRandomAccessFile.close();
        AppMethodBeat.o(90546);
        return -1;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("MicroMsg.Tinker.MergeBsDiffApk", paramString1, "merge apk failed.", new Object[0]);
        AppMethodBeat.o(90546);
        return -1;
      }
    }
    AppMethodBeat.o(90546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.b
 * JD-Core Version:    0.7.0.1
 */