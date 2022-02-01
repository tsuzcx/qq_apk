package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class v
{
  static v c;
  private static final String d;
  Context a;
  Map<String, FileChannel> b;
  
  static
  {
    AppMethodBeat.i(180862);
    d = v.class.getSimpleName();
    c = null;
    AppMethodBeat.o(180862);
  }
  
  private v(Context paramContext)
  {
    AppMethodBeat.i(193545);
    this.a = null;
    this.b = null;
    this.a = paramContext;
    this.b = new HashMap(5);
    AppMethodBeat.o(193545);
  }
  
  public static v a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(193546);
      if (c == null) {
        c = new v(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(193546);
      return paramContext;
    }
    finally {}
  }
  
  private File c(String paramString)
  {
    try
    {
      AppMethodBeat.i(193549);
      try
      {
        File localFile1 = new File(x.b(this.a, t.n + File.separator + paramString + ".lock"));
        paramString = localFile1;
        if (!localFile1.exists())
        {
          File localFile2 = new File(localFile1.getParent());
          paramString = localFile1;
          if (!localFile2.exists())
          {
            localFile2.mkdirs();
            localFile1.createNewFile();
            paramString = localFile1;
          }
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
      AppMethodBeat.o(193549);
      return paramString;
    }
    finally {}
  }
  
  public final boolean a(String paramString)
  {
    for (;;)
    {
      File localFile;
      FileChannel localFileChannel2;
      FileChannel localFileChannel1;
      try
      {
        AppMethodBeat.i(193547);
        if (paramString.trim().length() <= 0)
        {
          AppMethodBeat.o(193547);
          bool = false;
          return bool;
        }
        localFile = c(paramString);
        if (localFile == null)
        {
          AppMethodBeat.o(193547);
          bool = true;
          continue;
        }
      }
      finally {}
      try
      {
        localFileChannel2 = (FileChannel)this.b.get(paramString);
        if (localFileChannel2 != null)
        {
          localFileChannel1 = localFileChannel2;
          if (localFileChannel2.isOpen()) {}
        }
        else
        {
          localFileChannel1 = new FileOutputStream(localFile).getChannel();
          this.b.put(paramString, localFileChannel1);
        }
        paramString = localFileChannel1.lock();
        if (paramString != null)
        {
          bool = paramString.isValid();
          if (bool)
          {
            AppMethodBeat.o(193547);
            bool = true;
          }
        }
      }
      catch (Throwable paramString)
      {
        continue;
      }
      AppMethodBeat.o(193547);
      boolean bool = false;
    }
  }
  
  public final void b(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193548);
        if (paramString.trim().length() <= 0)
        {
          AppMethodBeat.o(193548);
          return;
        }
      }
      finally
      {
        try
        {
          paramString = (FileChannel)this.b.get(paramString);
          if (paramString != null) {
            paramString.close();
          }
          AppMethodBeat.o(193548);
        }
        catch (Throwable paramString)
        {
          AppMethodBeat.o(193548);
        }
        paramString = finally;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.internal.v
 * JD-Core Version:    0.7.0.1
 */