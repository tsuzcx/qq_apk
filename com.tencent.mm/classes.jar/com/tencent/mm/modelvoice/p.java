package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;

public final class p
{
  public String paV;
  public boolean paW;
  public long time;
  
  public p(String paramString)
  {
    AppMethodBeat.i(130092);
    String str = paramString;
    for (;;)
    {
      try
      {
        if (paramString.endsWith("\n")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
        paramString = str.split(":");
        if ((paramString.length == 4) && (au.bwS(paramString[0])))
        {
          i = 1;
          if (paramString.length > i) {
            this.paV = paramString[i];
          }
          if (paramString.length > i + 1) {
            this.time = Util.getLong(paramString[(i + 1)], 0L);
          }
          if (paramString.length > i + 2) {
            this.paW = paramString[(i + 2)].equals("1");
          }
          AppMethodBeat.o(130092);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (this.paV == null) {
          this.paV = "";
        }
        this.paW = false;
        this.time = 0L;
        Log.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        AppMethodBeat.o(130092);
        return;
      }
      int i = 0;
    }
  }
  
  public static String a(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(130091);
    paramString = new StringBuilder().append(paramString).append(":").append(paramLong).append(":");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = i + "\n";
      AppMethodBeat.o(130091);
      return paramString;
    }
  }
  
  public final String bOq()
  {
    return this.paV;
  }
  
  public final String bPi()
  {
    AppMethodBeat.i(234442);
    Object localObject = new StringBuilder().append(this.paV).append(":").append(this.time).append(":");
    if (this.paW) {}
    for (int i = 1;; i = 0)
    {
      localObject = i + ":\n";
      AppMethodBeat.o(234442);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.p
 * JD-Core Version:    0.7.0.1
 */