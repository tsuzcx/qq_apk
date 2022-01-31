package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class h
{
  public static int b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(125706);
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      AppMethodBeat.o(125706);
      return -1;
    }
    for (;;)
    {
      try
      {
        File localFile2 = new File(paramString1);
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile2, "r");
        File localFile1 = new File(paramString3);
        paramString2 = new File(paramString2);
        if ((!localFile2.exists()) || (!paramString2.exists()))
        {
          System.err.println("MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + localFile2.exists() + ", newFile.exists()=" + localFile1.exists() + ", patch.exists()=" + paramString2.exists());
          localRandomAccessFile.close();
          AppMethodBeat.o(125706);
          return -1;
        }
        paramString1 = a.dn(paramString1);
        if ((paramString1 != null) && (paramString1.bWq != null))
        {
          i = paramString1.bWq.bWt + 8;
          System.out.println("MicroMsg.MergePatchApk:extLen = ".concat(String.valueOf(i)));
          if (d.a(localRandomAccessFile, localFile1, paramString2, i) != 1)
          {
            System.out.println("MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
            localRandomAccessFile.close();
            AppMethodBeat.o(125706);
            return -1;
          }
          localRandomAccessFile.close();
          boolean bool = paramString4.equalsIgnoreCase(g.getMD5(paramString3));
          if (!bool)
          {
            AppMethodBeat.o(125706);
            return -2;
          }
          paramString1 = new b();
          paramString1.apkMd5 = paramString4;
          new a(paramString1).t(localFile1);
          AppMethodBeat.o(125706);
          return 0;
        }
      }
      catch (Exception paramString1)
      {
        System.out.println("MicroMsg.MergePatchApk:Exception in merge()");
        AppMethodBeat.o(125706);
        return -1;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.c.h
 * JD-Core Version:    0.7.0.1
 */