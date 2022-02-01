package com.qcloud.qvb.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

public class a
{
  public static final String[] dYz = { "armeabi", "armeabi-v7a", "arm64-v8a", "x86", "x86_64" };
  public String basePath;
  private Context context;
  public String dYA;
  public String dYD;
  
  private String getAppVersion()
  {
    AppMethodBeat.i(207450);
    Object localObject2 = this.context.getPackageManager();
    Object localObject1 = "default";
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(this.context.getPackageName(), 0).versionName;
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label34:
      break label34;
    }
    AppMethodBeat.o(207450);
    return localObject1;
  }
  
  public final boolean deleteDir(File paramFile)
  {
    AppMethodBeat.i(207469);
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (!deleteDir(new File(paramFile, arrayOfString[i])))
        {
          AppMethodBeat.o(207469);
          return false;
        }
        i += 1;
      }
    }
    boolean bool = paramFile.delete();
    AppMethodBeat.o(207469);
    return bool;
  }
  
  public final class b
    implements FileFilter
  {
    public b()
    {
      AppMethodBeat.i(207442);
      AppMethodBeat.o(207442);
    }
    
    public final boolean accept(File paramFile)
    {
      AppMethodBeat.i(207447);
      if ((paramFile.isDirectory()) && (!paramFile.getName().equals(a.a(a.this))))
      {
        AppMethodBeat.o(207447);
        return true;
      }
      AppMethodBeat.o(207447);
      return false;
    }
  }
  
  public final class c
    implements FileFilter
  {
    public c()
    {
      AppMethodBeat.i(207443);
      AppMethodBeat.o(207443);
    }
    
    public final boolean accept(File paramFile)
    {
      AppMethodBeat.i(207449);
      if ((paramFile.getName().startsWith(a.this)) && (paramFile.getName().endsWith(".so")))
      {
        AppMethodBeat.o(207449);
        return true;
      }
      AppMethodBeat.o(207449);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.qcloud.qvb.a.a
 * JD-Core Version:    0.7.0.1
 */