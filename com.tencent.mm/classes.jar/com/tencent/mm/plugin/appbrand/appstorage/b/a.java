package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/compatibility/AppBrandFileUtilsCompat;", "", "()V", "TAG", "", "cleanDirectory", "", "directory", "Ljava/io/File;", "deleteDirectory", "forceDelete", "file", "isSymlink", "", "moveDirectory", "srcDir", "destDir", "verifiedListFiles", "", "(Ljava/io/File;)[Ljava/io/File;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a kTL;
  
  static
  {
    AppMethodBeat.i(228118);
    kTL = new a();
    AppMethodBeat.o(228118);
  }
  
  private static boolean F(File paramFile)
  {
    AppMethodBeat.i(228117);
    if (!paramFile.exists())
    {
      AppMethodBeat.o(228117);
      return false;
    }
    try
    {
      FileStructStat localFileStructStat = new FileStructStat();
      if (FileStat.stat(paramFile.getAbsolutePath(), localFileStructStat) == 0)
      {
        Log.i("MicroMsg.AppBrandFileUtilsCompat", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(localFileStructStat.st_mode) });
        boolean bool = localFileStructStat.isSymLink();
        AppMethodBeat.o(228117);
        return bool;
      }
    }
    catch (Exception paramFile)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandFileUtilsCompat", (Throwable)paramFile, "", new Object[0]);
      AppMethodBeat.o(228117);
    }
    return false;
  }
  
  public final void deleteDirectory(File paramFile)
  {
    AppMethodBeat.i(228116);
    p.h(paramFile, "directory");
    if (!paramFile.exists())
    {
      AppMethodBeat.o(228116);
      return;
    }
    File[] arrayOfFile;
    Throwable localThrowable;
    int j;
    int i;
    if (!F(paramFile))
    {
      if (!paramFile.exists())
      {
        paramFile = (Throwable)new IllegalArgumentException(paramFile + " does not exist");
        AppMethodBeat.o(228116);
        throw paramFile;
      }
      if (!paramFile.isDirectory())
      {
        paramFile = (Throwable)new IllegalArgumentException(paramFile + " is not a directory");
        AppMethodBeat.o(228116);
        throw paramFile;
      }
      arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
      {
        paramFile = (Throwable)new IOException("Failed to list contents of ".concat(String.valueOf(paramFile)));
        AppMethodBeat.o(228116);
        throw paramFile;
      }
      localThrowable = null;
      j = arrayOfFile.length;
      i = 0;
    }
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        if (localFile.isDirectory())
        {
          deleteDirectory(localFile);
          break label344;
        }
        boolean bool = localFile.exists();
        if (localFile.delete()) {
          break label344;
        }
        if (!bool)
        {
          localThrowable = (Throwable)new FileNotFoundException("File does not exist: ".concat(String.valueOf(localFile)));
          AppMethodBeat.o(228116);
          throw localThrowable;
        }
        localThrowable = (Throwable)new IOException("Unable to delete file: ".concat(String.valueOf(localFile)));
        AppMethodBeat.o(228116);
        throw localThrowable;
      }
      catch (IOException localIOException)
      {
        break label344;
      }
      if (localThrowable != null)
      {
        paramFile = (Throwable)localThrowable;
        AppMethodBeat.o(228116);
        throw paramFile;
      }
      if (!paramFile.delete())
      {
        paramFile = (Throwable)new IOException("Unable to delete directory " + paramFile + '.');
        AppMethodBeat.o(228116);
        throw paramFile;
      }
      AppMethodBeat.o(228116);
      return;
      label344:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.a
 * JD-Core Version:    0.7.0.1
 */