package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d oYQ;
  public boolean oYR;
  private Pattern oYS;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.oYR = false;
    this.oYS = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d cbO()
  {
    AppMethodBeat.i(108424);
    if (oYQ == null) {}
    try
    {
      oYQ = new d();
      d locald = oYQ;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void XJ(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new com.tencent.mm.vfs.e(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fxX();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.oYR)
          {
            if (localObject.isDirectory()) {
              XJ(q.B(localObject.mUri));
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.oYS.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          ac.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
          AppMethodBeat.o(108425);
          return;
        }
      }
    }
    AppMethodBeat.o(108425);
  }
  
  public final void XK(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new com.tencent.mm.vfs.e(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fxX();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            XK(q.B(localObject.mUri));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */