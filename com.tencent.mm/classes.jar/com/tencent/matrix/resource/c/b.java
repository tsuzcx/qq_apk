package com.tencent.matrix.resource.c;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.e.c;
import com.tencent.matrix.e.d;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
{
  protected final int dcU;
  protected final Context mContext;
  
  public b(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private b(Context paramContext, byte paramByte)
  {
    this.mContext = paramContext;
    this.dcU = 5;
  }
  
  public final File XI()
  {
    Object localObject;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject = this.mContext.getExternalCacheDir();
      localFile = new File((File)localObject, "matrix_resource");
      c.i("Matrix.DumpStorageManager", "path to store hprof and result: %s", new Object[] { localFile.getAbsolutePath() });
      if ((localFile.exists()) || ((localFile.mkdirs()) && (localFile.canWrite()))) {
        break label112;
      }
      c.w("Matrix.DumpStorageManager", "failed to allocate new hprof file since path: %s is not writable.", new Object[] { localFile.getAbsolutePath() });
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return null;
        localObject = this.mContext.getCacheDir();
        break;
        label112:
        File[] arrayOfFile = localFile.listFiles(new FilenameFilter()
        {
          public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.endsWith(".hprof");
          }
        });
        localObject = localFile;
        if (arrayOfFile != null)
        {
          localObject = localFile;
          if (arrayOfFile.length > this.dcU)
          {
            int j = arrayOfFile.length;
            int i = 0;
            for (;;)
            {
              localObject = localFile;
              if (i >= j) {
                break;
              }
              localObject = arrayOfFile[i];
              if ((((File)localObject).exists()) && (!((File)localObject).delete())) {
                c.w("Matrix.DumpStorageManager", "faile to delete hprof file: " + ((File)localObject).getAbsolutePath(), new Object[0]);
              }
              i += 1;
            }
          }
        }
      }
    }
    return new File((File)localObject, "dump_" + d.getProcessName(this.mContext).replace(".", "_").replace(":", "_") + "_" + Process.myPid() + "_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".hprof");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.b
 * JD-Core Version:    0.7.0.1
 */