package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class kf
{
  private static final String b = "LibaryLoaderHelper";
  private static boolean c;
  
  static
  {
    AppMethodBeat.i(224753);
    if (!kf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      c = false;
      AppMethodBeat.o(224753);
      return;
    }
  }
  
  private static File a(Context paramContext)
  {
    AppMethodBeat.i(224699);
    paramContext = new File(paramContext.getApplicationInfo().nativeLibraryDir);
    AppMethodBeat.o(224699);
    return paramContext;
  }
  
  private static ZipEntry a(ZipFile paramZipFile, String paramString)
  {
    AppMethodBeat.i(224733);
    ZipEntry localZipEntry = paramZipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(paramString));
    if (localZipEntry != null)
    {
      AppMethodBeat.o(224733);
      return localZipEntry;
    }
    paramZipFile = paramZipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(paramString));
    AppMethodBeat.o(224733);
    return paramZipFile;
  }
  
  private static void a(File paramFile)
  {
    AppMethodBeat.i(224741);
    for (;;)
    {
      int i;
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          i = 0;
          if (i < j)
          {
            File localFile = arrayOfFile[i];
            localFile.getName();
            if ((localFile.delete()) || (!Log.isLoggable("LibaryLoaderHelper", 6))) {
              break label129;
            }
            new StringBuilder("Failed to remove ").append(localFile.getAbsolutePath());
            break label129;
          }
        }
        if ((!paramFile.delete()) && (Log.isLoggable("LibaryLoaderHelper", 6))) {
          new StringBuilder("Failed to remove ").append(paramFile.getAbsolutePath());
        }
        AppMethodBeat.o(224741);
        return;
      }
      catch (Exception paramFile)
      {
        Log.isLoggable("LibaryLoaderHelper", 6);
        AppMethodBeat.o(224741);
        return;
      }
      label129:
      i += 1;
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(224691);
    if ((!a) && (paramContext == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(224691);
      throw paramContext;
    }
    paramString = b(paramContext, paramString);
    boolean bool = paramString.exists();
    if (Log.isLoggable("LibaryLoaderHelper", 4)) {
      new StringBuilder("libary:").append(paramString.getAbsolutePath()).append(" is exist:").append(bool);
    }
    if ((!bool) && (!b(paramContext)))
    {
      AppMethodBeat.o(224691);
      return false;
    }
    try
    {
      System.load(paramString.getAbsolutePath());
      AppMethodBeat.o(224691);
      return true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      AppMethodBeat.o(224691);
    }
    return false;
  }
  
  private static File b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(224707);
    paramString = System.mapLibraryName(paramString);
    paramContext = new File(a(paramContext), paramString);
    AppMethodBeat.o(224707);
    return paramContext;
  }
  
  private static boolean b(Context paramContext)
  {
    AppMethodBeat.i(224723);
    if (c)
    {
      AppMethodBeat.o(224723);
      return false;
    }
    c = true;
    File localFile1 = a(paramContext);
    a(localFile1);
    int i;
    for (;;)
    {
      ZipFile localZipFile;
      Object localObject3;
      File localFile2;
      try
      {
        localZipFile = new ZipFile(new File(paramContext.getApplicationInfo().sourceDir), 1);
        String[] arrayOfString = ke.a;
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label527;
        }
        localObject1 = arrayOfString[i];
        localObject3 = localZipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName((String)localObject1));
        if (localObject3 != null)
        {
          if (localObject3 == null)
          {
            localZipFile.close();
            a(localFile1);
            AppMethodBeat.o(224723);
            return false;
          }
        }
        else
        {
          localObject3 = localZipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName((String)localObject1));
          continue;
        }
        localFile2 = b(paramContext, (String)localObject1);
        if (Log.isLoggable("LibaryLoaderHelper", 4)) {
          new StringBuilder("Extracting native libraries into ").append(localFile2.getAbsolutePath());
        }
        if ((!a) && (localFile2.exists()))
        {
          paramContext = new AssertionError();
          AppMethodBeat.o(224723);
          throw paramContext;
        }
      }
      catch (IOException paramContext)
      {
        Log.isLoggable("LibaryLoaderHelper", 6);
        a(localFile1);
        AppMethodBeat.o(224723);
        return false;
      }
      try
      {
        if (!localFile2.createNewFile())
        {
          paramContext = new IOException();
          AppMethodBeat.o(224723);
          throw paramContext;
        }
      }
      catch (IOException paramContext)
      {
        if ((localFile2.exists()) && (!localFile2.delete()) && (Log.isLoggable("LibaryLoaderHelper", 6))) {
          new StringBuilder("Failed to delete ").append(localFile2.getAbsolutePath());
        }
        localZipFile.close();
        AppMethodBeat.o(224723);
        throw paramContext;
      }
      Object localObject1 = null;
      for (;;)
      {
        try
        {
          localObject3 = localZipFile.getInputStream((ZipEntry)localObject3);
          localObject1 = localObject3;
          localFileOutputStream = new FileOutputStream(localFile2);
          try
          {
            localObject1 = new byte[16384];
            int k = ((InputStream)localObject3).read((byte[])localObject1);
            if (k > 0)
            {
              localFileOutputStream.write((byte[])localObject1, 0, k);
              continue;
              if (localObject1 == null) {}
            }
          }
          finally
          {
            localObject1 = localObject3;
            paramContext = localFileOutputStream;
            localObject3 = localObject5;
          }
        }
        finally
        {
          FileOutputStream localFileOutputStream;
          paramContext = null;
          continue;
          i += 1;
        }
        try
        {
          ((InputStream)localObject1).close();
          if (paramContext != null) {
            paramContext.close();
          }
          AppMethodBeat.o(224723);
          throw ((Throwable)localObject3);
        }
        finally
        {
          paramContext.close();
          AppMethodBeat.o(224723);
        }
      }
      if (localObject3 != null) {}
      label527:
      localZipFile.close();
      AppMethodBeat.o(224723);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kf
 * JD-Core Version:    0.7.0.1
 */