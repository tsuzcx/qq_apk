package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.g.c;
import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

public final class d
{
  protected final int cZV;
  protected final Context mContext;
  
  public d(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private d(Context paramContext, byte paramByte)
  {
    this.mContext = paramContext;
    this.cZV = 5;
  }
  
  private File Tk()
  {
    File localFile2 = Tl();
    File localFile1;
    if ((!localFile2.exists()) && ((!localFile2.mkdirs()) || (!localFile2.canWrite())))
    {
      c.w("Matrix.DumpStorageManager", "failed to allocate new hprof file since path: %s is not writable.", new Object[] { localFile2.getAbsolutePath() });
      localFile1 = null;
    }
    File[] arrayOfFile;
    do
    {
      do
      {
        return localFile1;
        arrayOfFile = localFile2.listFiles(new FilenameFilter()
        {
          public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.endsWith(".hprof");
          }
        });
        localFile1 = localFile2;
      } while (arrayOfFile == null);
      localFile1 = localFile2;
    } while (arrayOfFile.length <= this.cZV);
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      localFile1 = localFile2;
      if (i >= j) {
        break;
      }
      localFile1 = arrayOfFile[i];
      if ((localFile1.exists()) && (!localFile1.delete())) {
        c.w("Matrix.DumpStorageManager", "faile to delete hprof file: " + localFile1.getAbsolutePath(), new Object[0]);
      }
      i += 1;
    }
  }
  
  private File Tl()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = this.mContext.getExternalCacheDir();; localFile = this.mContext.getCacheDir())
    {
      localFile = new File(localFile, "matrix_resource");
      c.i("Matrix.DumpStorageManager", "path to store hprof and result: %s", new Object[] { localFile.getAbsolutePath() });
      return localFile;
    }
  }
  
  public final File Tj()
  {
    File localFile = Tk();
    if (localFile == null) {
      return null;
    }
    UUID localUUID = UUID.randomUUID();
    return new File(localFile, "dump_" + Long.toHexString(localUUID.getMostSignificantBits()) + Long.toHexString(localUUID.getLeastSignificantBits()) + ".hprof");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.e.d
 * JD-Core Version:    0.7.0.1
 */