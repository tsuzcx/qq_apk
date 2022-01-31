package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e
{
  public static e lfI;
  public boolean lfJ;
  private Pattern lfK;
  
  public e()
  {
    AppMethodBeat.i(52860);
    this.lfJ = false;
    this.lfK = Pattern.compile("_\\d");
    AppMethodBeat.o(52860);
  }
  
  public static e bkP()
  {
    AppMethodBeat.i(52861);
    if (lfI == null) {}
    try
    {
      lfI = new e();
      e locale = lfI;
      AppMethodBeat.o(52861);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(52861);
    }
  }
  
  public final void Kr(String paramString)
  {
    AppMethodBeat.i(52862);
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (this.lfJ)
          {
            if (localObject.isDirectory()) {
              Kr(localObject.getPath());
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.lfK.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          ab.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
          AppMethodBeat.o(52862);
          return;
        }
      }
    }
    AppMethodBeat.o(52862);
  }
  
  public final void Ks(String paramString)
  {
    AppMethodBeat.i(52863);
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramString[i];
          if (localObject.isDirectory()) {
            Ks(localObject.getPath());
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
    AppMethodBeat.o(52863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */