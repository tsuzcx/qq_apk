package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
{
  private String iaC;
  private boolean iaD;
  private long time;
  
  public q(String paramString)
  {
    AppMethodBeat.i(126946);
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    paramString = str.split(":");
    try
    {
      if (paramString.length > 0) {
        this.iaC = paramString[0];
      }
      if (paramString.length > 1) {
        this.time = bs.getLong(paramString[1], 0L);
      }
      if (paramString.length > 2) {
        this.iaD = paramString[2].equals("1");
      }
      AppMethodBeat.o(126946);
      return;
    }
    catch (Exception paramString)
    {
      if (this.iaC == null) {
        this.iaC = "";
      }
      this.iaD = false;
      this.time = 0L;
      ac.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
      AppMethodBeat.o(126946);
    }
  }
  
  public static String b(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(126945);
    paramString = new StringBuilder().append(paramString).append(":").append(paramLong).append(":");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = i + "\n";
      AppMethodBeat.o(126945);
      return paramString;
    }
  }
  
  public final String aJH()
  {
    return this.iaC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.q
 * JD-Core Version:    0.7.0.1
 */