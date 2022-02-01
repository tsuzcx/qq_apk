package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d pJe;
  public boolean pJf;
  private Pattern pJg;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.pJf = false;
    this.pJg = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d chI()
  {
    AppMethodBeat.i(108424);
    if (pJe == null) {}
    try
    {
      pJe = new d();
      d locald = pJe;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void acg(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new k(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fTj();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.pJf)
          {
            if (localObject.isDirectory()) {
              acg(w.B(localObject.mUri));
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.pJg.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          ae.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
          AppMethodBeat.o(108425);
          return;
        }
      }
    }
    AppMethodBeat.o(108425);
  }
  
  public final void ach(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new k(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.fTj();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            ach(w.B(localObject.mUri));
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