package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;

public final class p
{
  public String iaC;
  public boolean iaD;
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
        if ((paramString.length == 4) && (ai.ww(paramString[0])))
        {
          i = 1;
          if (paramString.length > i) {
            this.iaC = paramString[i];
          }
          if (paramString.length > i + 1) {
            this.time = bs.getLong(paramString[(i + 1)], 0L);
          }
          if (paramString.length > i + 2) {
            this.iaD = paramString[(i + 2)].equals("1");
          }
          AppMethodBeat.o(130092);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (this.iaC == null) {
          this.iaC = "";
        }
        this.iaD = false;
        this.time = 0L;
        ac.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        AppMethodBeat.o(130092);
        return;
      }
      int i = 0;
    }
  }
  
  public static String b(String paramString, long paramLong, boolean paramBoolean)
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
  
  public final String aJH()
  {
    return this.iaC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.p
 * JD-Core Version:    0.7.0.1
 */