package com.tencent.mm.c;

import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class h
{
  public static int b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return -1;
    }
    RandomAccessFile localRandomAccessFile;
    File localFile1;
    try
    {
      File localFile2 = new File(paramString1);
      localRandomAccessFile = new RandomAccessFile(localFile2, "r");
      localFile1 = new File(paramString3);
      paramString2 = new File(paramString2);
      if ((!localFile2.exists()) || (!paramString2.exists()))
      {
        System.err.println("MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + localFile2.exists() + ", newFile.exists()=" + localFile1.exists() + ", patch.exists()=" + paramString2.exists());
        localRandomAccessFile.close();
        return -1;
      }
    }
    catch (Exception paramString1)
    {
      System.out.println("MicroMsg.MergePatchApk:Exception in merge()");
      return -1;
    }
    paramString1 = a.cc(paramString1);
    int i;
    if ((paramString1 != null) && (paramString1.bvf != null))
    {
      i = paramString1.bvf.bvi + 8;
      System.out.println("MicroMsg.MergePatchApk:extLen = " + i);
    }
    for (;;)
    {
      if (d.a(localRandomAccessFile, localFile1, paramString2, i) != 1)
      {
        System.out.println("MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
        localRandomAccessFile.close();
        return -1;
      }
      localRandomAccessFile.close();
      if (!paramString4.equalsIgnoreCase(g.bQ(paramString3))) {
        return -2;
      }
      paramString1 = new b();
      paramString1.apkMd5 = paramString4;
      new a(paramString1).o(localFile1);
      return 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.c.h
 * JD-Core Version:    0.7.0.1
 */