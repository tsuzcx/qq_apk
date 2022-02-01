package com.tencent.mm.plugin.emoji.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static d xKW;
  public boolean xKX;
  private Pattern xKY;
  
  public d()
  {
    AppMethodBeat.i(108423);
    this.xKX = false;
    this.xKY = Pattern.compile("_\\d");
    AppMethodBeat.o(108423);
  }
  
  public static d dzs()
  {
    AppMethodBeat.i(108424);
    if (xKW == null) {}
    try
    {
      xKW = new d();
      d locald = xKW;
      AppMethodBeat.o(108424);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(108424);
    }
  }
  
  public final void aoc(String paramString)
  {
    AppMethodBeat.i(108425);
    paramString = new u(paramString);
    if ((paramString.jKS()) && (paramString.isDirectory()))
    {
      paramString = paramString.jKX();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.xKX)
          {
            if (localObject.isDirectory()) {
              aoc(ah.v(localObject.mUri));
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.xKY.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.diJ();
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
  
  public final void aod(String paramString)
  {
    AppMethodBeat.i(108426);
    paramString = new u(paramString);
    if ((paramString.jKS()) && (paramString.isDirectory()))
    {
      paramString = paramString.jKX();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            aod(ah.v(localObject.mUri));
          }
          for (;;)
          {
            i += 1;
            break;
            localObject.getName();
            localObject.diJ();
          }
        }
      }
    }
    AppMethodBeat.o(108426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.d
 * JD-Core Version:    0.7.0.1
 */