package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class e
  extends o
{
  protected final File cCx;
  protected final int flags;
  
  public e(File paramFile, int paramInt)
  {
    this.cCx = paramFile;
    this.flags = paramInt;
  }
  
  private static void a(String paramString, f paramf, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    AppMethodBeat.i(208075);
    paramString = a(paramString, paramf);
    new StringBuilder("Loading lib dependencies: ").append(Arrays.toString(paramString));
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramf = paramString[i];
      if (!paramf.startsWith("/")) {
        n.c(paramf, paramInt | 0x1, paramThreadPolicy);
      }
      i += 1;
    }
    AppMethodBeat.o(208075);
  }
  
  private static String[] a(String paramString, f paramf)
  {
    AppMethodBeat.i(208085);
    if (n.cCY) {
      a.e("SoLoader.getElfDependencies[", paramString, "]");
    }
    try
    {
      paramString = k.a(paramf);
      return paramString;
    }
    finally
    {
      if (n.cCY) {
        Trace.endSection();
      }
      AppMethodBeat.o(208085);
    }
  }
  
  public final File PS()
  {
    return this.cCx;
  }
  
  public int a(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    AppMethodBeat.i(208099);
    paramInt = a(paramString, paramInt, this.cCx, paramThreadPolicy);
    AppMethodBeat.o(208099);
    return paramInt;
  }
  
  protected final int a(String paramString, int paramInt, File paramFile, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(208115);
    if (n.cCZ == null)
    {
      paramString = new IllegalStateException("SoLoader.init() not yet called");
      AppMethodBeat.o(208115);
      throw paramString;
    }
    File localFile = new File(this.cCx, paramString);
    if (localFile.exists()) {}
    while (localFile == null)
    {
      new StringBuilder().append(paramString).append(" not found on ").append(paramFile.getCanonicalPath());
      AppMethodBeat.o(208115);
      return 0;
      localFile = null;
    }
    new StringBuilder().append(paramString).append(" found on ").append(paramFile.getCanonicalPath());
    if (((paramInt & 0x1) != 0) && ((this.flags & 0x2) != 0))
    {
      new StringBuilder().append(paramString).append(" loaded implicitly");
      AppMethodBeat.o(208115);
      return 2;
    }
    if ((this.flags & 0x1) != 0) {
      i = 1;
    }
    boolean bool = localFile.getName().equals(paramString);
    if (i == 0)
    {
      paramFile = localObject;
      if (bool) {
        break label207;
      }
    }
    try
    {
      paramFile = new g(localFile);
      label207:
      if (i != 0) {}
      try
      {
        a(paramString, paramFile, paramInt, paramThreadPolicy);
        if (bool) {}
        for (;;)
        {
          try
          {
            n.cCZ.v(localFile.getAbsolutePath(), paramInt);
            if (paramFile != null) {
              paramFile.close();
            }
            AppMethodBeat.o(208115);
            return 1;
          }
          catch (UnsatisfiedLinkError paramString)
          {
            bool = paramString.getMessage().contains("bad ELF magic");
            if (!bool) {
              continue;
            }
            if (paramFile == null) {
              continue;
            }
            paramFile.close();
            AppMethodBeat.o(208115);
            return 3;
            AppMethodBeat.o(208115);
            throw paramString;
          }
          paramString = n.cCZ;
          localFile.getAbsolutePath();
          paramString.PZ();
        }
        if (paramFile == null) {
          break label327;
        }
      }
      finally {}
    }
    finally
    {
      paramFile = null;
    }
    paramFile.close();
    label327:
    AppMethodBeat.o(208115);
    throw paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(208122);
    try
    {
      String str1 = String.valueOf(this.cCx.getCanonicalPath());
      str1 = getClass().getName() + "[root = " + str1 + " flags = " + this.flags + ']';
      AppMethodBeat.o(208122);
      return str1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str2 = this.cCx.getName();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.e
 * JD-Core Version:    0.7.0.1
 */