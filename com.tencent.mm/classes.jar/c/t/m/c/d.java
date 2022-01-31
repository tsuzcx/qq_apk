package c.t.m.c;

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
  static d c = null;
  Context a;
  Map<String, FileChannel> b;
  
  protected d(Context paramContext)
  {
    AppMethodBeat.i(136338);
    this.a = null;
    this.b = null;
    this.a = paramContext;
    this.b = new HashMap(5);
    AppMethodBeat.o(136338);
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(136339);
      if (c == null) {
        c = new d(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(136339);
      return paramContext;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      File localFile;
      FileChannel localFileChannel2;
      FileChannel localFileChannel1;
      try
      {
        AppMethodBeat.i(136340);
        if ((paramString == null) || (paramString.trim().length() <= 0))
        {
          AppMethodBeat.o(136340);
          bool = false;
          return bool;
        }
        localFile = c(paramString);
        if (localFile == null)
        {
          AppMethodBeat.o(136340);
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
            AppMethodBeat.o(136340);
            bool = true;
          }
        }
      }
      catch (Throwable paramString)
      {
        continue;
      }
      AppMethodBeat.o(136340);
      boolean bool = false;
    }
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(136341);
        if ((paramString != null) && (paramString.trim().length() > 0)) {
          continue;
        }
        AppMethodBeat.o(136341);
      }
      finally
      {
        try
        {
          paramString = (FileChannel)this.b.get(paramString);
          if (paramString != null) {
            paramString.close();
          }
          AppMethodBeat.o(136341);
        }
        catch (Throwable paramString)
        {
          AppMethodBeat.o(136341);
        }
        paramString = finally;
      }
      return;
    }
  }
  
  protected File c(String paramString)
  {
    try
    {
      AppMethodBeat.i(136342);
      try
      {
        File localFile = new File(this.a.getFilesDir(), "TencentLocationCoverSDK_" + paramString + ".lock");
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
      AppMethodBeat.o(136342);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.c.d
 * JD-Core Version:    0.7.0.1
 */