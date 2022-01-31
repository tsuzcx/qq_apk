package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  public static c iWA;
  public boolean iWB = false;
  private Pattern iWC = Pattern.compile("_\\d");
  
  public static c aHb()
  {
    if (iWA == null) {}
    try
    {
      iWA = new c();
      return iWA;
    }
    finally {}
  }
  
  public final void Aq(String paramString)
  {
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
          if (this.iWB)
          {
            if (localObject.isDirectory()) {
              Aq(localObject.getPath());
            }
            for (;;)
            {
              i += 1;
              break;
              String str = localObject.getName();
              if ((this.iWC.matcher(str).find()) || (str.startsWith("temp"))) {
                localObject.delete();
              }
            }
          }
          y.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
        }
      }
    }
  }
  
  public final void Ar(String paramString)
  {
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
            Ar(localObject.getPath());
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */