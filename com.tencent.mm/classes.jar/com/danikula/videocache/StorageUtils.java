package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class StorageUtils
{
  private static final String INDIVIDUAL_DIR_NAME = "video-cache";
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(195175);
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      if (localFile.isFile())
      {
        bool = localFile.delete();
        AppMethodBeat.o(195175);
        return bool;
      }
      String[] arrayOfString = localFile.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          deleteFile(paramString + File.separator + str);
          i += 1;
        }
      }
      boolean bool = localFile.delete();
      AppMethodBeat.o(195175);
      return bool;
    }
    AppMethodBeat.o(195175);
    return true;
  }
  
  public static boolean deleteFiles(File paramFile)
  {
    AppMethodBeat.i(195174);
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if ((!localObject.isDirectory()) && (localObject.exists()) && (!localObject.delete()))
        {
          AppMethodBeat.o(195174);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(195174);
    return true;
  }
  
  private static File getCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(195173);
    Object localObject2 = null;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localObject2 = paramContext.getExternalCacheDir();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getCacheDir();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new File("/data/data/" + paramContext.getPackageName() + "/cache/");
    }
    AppMethodBeat.o(195173);
    return localObject2;
  }
  
  static File getIndividualCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(195172);
    paramContext = new File(getCacheDirectory(paramContext), "video-cache");
    AppMethodBeat.o(195172);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.StorageUtils
 * JD-Core Version:    0.7.0.1
 */