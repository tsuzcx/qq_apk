package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d pCA;
  public boolean pCB;
  private Pattern pCC;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.pCB = false;
    this.pCC = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d cgs()
  {
    AppMethodBeat.i(108424);
    if (pCA == null) {}
    try
    {
      pCA = new d();
      d locald = pCA;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void abp(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new com.tencent.mm.vfs.e(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fOM();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.pCB)
          {
            if (localObject.isDirectory()) {
              abp(q.B(localObject.mUri));
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.pCC.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          ad.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
          AppMethodBeat.o(108425);
          return;
        }
      }
    }
    AppMethodBeat.o(108425);
  }
  
  public final void abq(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new com.tencent.mm.vfs.e(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fOM();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            abq(q.B(localObject.mUri));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */