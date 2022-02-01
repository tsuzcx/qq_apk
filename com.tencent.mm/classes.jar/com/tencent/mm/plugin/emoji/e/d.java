package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d qZz;
  public boolean qZA;
  private Pattern qZB;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.qZA = false;
    this.qZB = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d cFF()
  {
    AppMethodBeat.i(108424);
    if (qZz == null) {}
    try
    {
      qZz = new d();
      d locald = qZz;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void amj(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new o(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.het();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.qZA)
          {
            if (localObject.isDirectory()) {
              amj(aa.z(localObject.mUri));
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.qZB.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          Log.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
          AppMethodBeat.o(108425);
          return;
        }
      }
    }
    AppMethodBeat.o(108425);
  }
  
  public final void amk(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new o(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.het();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            amk(aa.z(localObject.mUri));
          }
          for (;;)
          {
            i += 1;
            break;
            localObject.getName();
            localObject.delete();
          }
        }
      }
    }
    AppMethodBeat.o(108426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */