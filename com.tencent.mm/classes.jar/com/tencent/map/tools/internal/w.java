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

public class w
{
  static w c;
  private static final String d;
  Context a;
  Map<String, FileChannel> b;
  
  static
  {
    AppMethodBeat.i(180868);
    d = w.class.getSimpleName();
    c = null;
    AppMethodBeat.o(180868);
  }
  
  private w(Context paramContext)
  {
    AppMethodBeat.i(180863);
    this.a = null;
    this.b = null;
    this.a = paramContext;
    this.b = new HashMap(5);
    AppMethodBeat.o(180863);
  }
  
  public static w a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(180864);
      if (c == null) {
        c = new w(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(180864);
      return paramContext;
    }
    finally {}
  }
  
  private File c(String paramString)
  {
    try
    {
      AppMethodBeat.i(180867);
      try
      {
        File localFile1 = new File(y.b(this.a, u.n + File.separator + paramString + ".lock"));
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
      AppMethodBeat.o(180867);
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
        AppMethodBeat.i(180865);
        if (paramString.trim().length() <= 0)
        {
          AppMethodBeat.o(180865);
          bool = false;
          return bool;
        }
        localFile = c(paramString);
        if (localFile == null)
        {
          AppMethodBeat.o(180865);
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
            AppMethodBeat.o(180865);
            bool = true;
          }
        }
      }
      catch (Throwable paramString)
      {
        continue;
      }
      AppMethodBeat.o(180865);
      boolean bool = false;
    }
  }
  
  public final void b(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(180866);
        if (paramString.trim().length() <= 0)
        {
          AppMethodBeat.o(180866);
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
          AppMethodBeat.o(180866);
        }
        catch (Throwable paramString)
        {
          AppMethodBeat.o(180866);
        }
        paramString = finally;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.w
 * JD-Core Version:    0.7.0.1
 */