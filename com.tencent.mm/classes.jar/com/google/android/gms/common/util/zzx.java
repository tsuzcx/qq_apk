package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

public class zzx
{
  @TargetApi(21)
  public static File getNoBackupFilesDir(Context paramContext)
  {
    if (zzt.zzzo()) {
      return paramContext.getNoBackupFilesDir();
    }
    return zze(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }
  
  private static File zze(File paramFile)
  {
    for (File localFile = paramFile;; localFile = null) {
      try
      {
        if (!paramFile.exists())
        {
          localFile = paramFile;
          if (!paramFile.mkdirs())
          {
            boolean bool = paramFile.exists();
            if (!bool) {
              break label37;
            }
            localFile = paramFile;
          }
        }
        return localFile;
        label37:
        paramFile = String.valueOf(paramFile.getPath());
        if (paramFile.length() != 0) {
          "Unable to create no-backup dir ".concat(paramFile);
        } else {
          new String("Unable to create no-backup dir ");
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.zzx
 * JD-Core Version:    0.7.0.1
 */