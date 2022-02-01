package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class q
{
  private String iwS;
  private boolean iwT;
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
        this.iwS = paramString[0];
      }
      if (paramString.length > 1) {
        this.time = bu.getLong(paramString[1], 0L);
      }
      if (paramString.length > 2) {
        this.iwT = paramString[2].equals("1");
      }
      AppMethodBeat.o(126946);
      return;
    }
    catch (Exception paramString)
    {
      if (this.iwS == null) {
        this.iwS = "";
      }
      this.iwT = false;
      this.time = 0L;
      ae.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
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
  
  public final String aNq()
  {
    return this.iwS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.q
 * JD-Core Version:    0.7.0.1
 */