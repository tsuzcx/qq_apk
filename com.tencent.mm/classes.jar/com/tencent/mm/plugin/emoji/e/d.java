package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d uCA;
  public boolean uCB;
  private Pattern uCC;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.uCB = false;
    this.uCC = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d cUl()
  {
    AppMethodBeat.i(108424);
    if (uCA == null) {}
    try
    {
      uCA = new d();
      d locald = uCA;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void aub(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new q(paramString);
    if ((paramString.ifE()) && (paramString.isDirectory()))
    {
      paramString = paramString.ifJ();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.uCB)
          {
            if (localObject.isDirectory()) {
              aub(localObject.getPath());
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.uCC.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.cFq();
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
  
  public final void auc(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new q(paramString);
    if ((paramString.ifE()) && (paramString.isDirectory()))
    {
      paramString = paramString.ifJ();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            auc(localObject.getPath());
          }
          for (;;)
          {
            i += 1;
            break;
            localObject.getName();
            localObject.cFq();
          }
        }
      }
    }
    AppMethodBeat.o(108426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */