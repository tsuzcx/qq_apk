package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.g.c;
import java.io.File;
import java.io.FilenameFilter;

public final class d
{
  protected final int bQl;
  protected final Context mContext;
  
  public d(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private d(Context paramContext, byte paramByte)
  {
    this.mContext = paramContext;
    this.bQl = 5;
  }
  
  final File zo()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile1 = this.mContext.getExternalCacheDir();; localFile1 = this.mContext.getCacheDir())
    {
      localFile1 = new File(localFile1, "matrix_resource");
      c.i("Matrix.DumpStorageManager", "path to store hprof and result: %s", new Object[] { localFile1.getAbsolutePath() });
      if ((localFile1.exists()) || ((localFile1.mkdirs()) && (localFile1.canWrite()))) {
        break;
      }
      c.w("Matrix.DumpStorageManager", "failed to allocate new hprof file since path: %s is not writable.", new Object[] { localFile1.getAbsolutePath() });
      return null;
    }
    File[] arrayOfFile = localFile1.listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(".hprof");
      }
    });
    if ((arrayOfFile != null) && (arrayOfFile.length > this.bQl))
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile2 = arrayOfFile[i];
        if ((localFile2.exists()) && (!localFile2.delete())) {
          c.w("Matrix.DumpStorageManager", "faile to delete hprof file: " + localFile2.getAbsolutePath(), new Object[0]);
        }
        i += 1;
      }
    }
    return localFile1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.e.d
 * JD-Core Version:    0.7.0.1
 */