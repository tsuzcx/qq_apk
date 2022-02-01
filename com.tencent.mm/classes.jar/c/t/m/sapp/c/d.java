package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class d
{
  public static d a;
  public Context b;
  public Map<String, FileChannel> c;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(210698);
    this.b = null;
    this.c = null;
    this.b = paramContext;
    this.c = new HashMap(5);
    AppMethodBeat.o(210698);
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(210699);
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(210699);
      return paramContext;
    }
    finally {}
  }
  
  public File a(String paramString)
  {
    try
    {
      AppMethodBeat.i(210702);
      try
      {
        File localFile = this.b.getFilesDir();
        StringBuilder localStringBuilder = new StringBuilder();
        paramString = localStringBuilder.append("TencentLocationCoverSDK_sapp_").append(paramString);
        localFile = new File(localFile, ".lock");
        paramString = localFile;
        if (!localFile.exists())
        {
          localFile.createNewFile();
          paramString = localFile;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
      AppMethodBeat.o(210702);
      return paramString;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      File localFile;
      FileChannel localFileChannel2;
      FileChannel localFileChannel1;
      try
      {
        AppMethodBeat.i(210700);
        if ((paramString != null) && (paramString.trim().length() > 0))
        {
          localFile = a(paramString);
          if (localFile == null)
          {
            AppMethodBeat.o(210700);
            bool = true;
            return bool;
          }
        }
      }
      finally {}
      try
      {
        localFileChannel2 = (FileChannel)this.c.get(paramString);
        if (localFileChannel2 != null)
        {
          localFileChannel1 = localFileChannel2;
          if (localFileChannel2.isOpen()) {}
        }
        else
        {
          localFileChannel1 = new FileOutputStream(localFile).getChannel();
          this.c.put(paramString, localFileChannel1);
        }
        paramString = localFileChannel1.lock();
        if (paramString != null)
        {
          bool = paramString.isValid();
          if (bool)
          {
            AppMethodBeat.o(210700);
            bool = true;
          }
        }
      }
      catch (Throwable paramString)
      {
        continue;
      }
      AppMethodBeat.o(210700);
      boolean bool = false;
      continue;
      AppMethodBeat.o(210700);
      bool = false;
    }
  }
  
  public void c(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210701);
        if (paramString != null)
        {
          int i = paramString.trim().length();
          if (i > 0)
          {
            try
            {
              paramString = (FileChannel)this.c.get(paramString);
              if (paramString == null) {
                continue;
              }
              paramString.close();
              AppMethodBeat.o(210701);
            }
            catch (Throwable paramString)
            {
              AppMethodBeat.o(210701);
              continue;
            }
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(210701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.d
 * JD-Core Version:    0.7.0.1
 */