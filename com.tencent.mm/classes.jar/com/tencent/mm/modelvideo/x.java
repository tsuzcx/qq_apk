package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
{
  private String paV;
  private boolean paW;
  private long time;
  
  public x(String paramString)
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
        this.paV = paramString[0];
      }
      if (paramString.length > 1) {
        this.time = Util.getLong(paramString[1], 0L);
      }
      if (paramString.length > 2) {
        this.paW = paramString[2].equals("1");
      }
      AppMethodBeat.o(126946);
      return;
    }
    catch (Exception paramString)
    {
      if (this.paV == null) {
        this.paV = "";
      }
      this.paW = false;
      this.time = 0L;
      Log.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
      AppMethodBeat.o(126946);
    }
  }
  
  public static String a(String paramString, long paramLong, boolean paramBoolean)
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
  
  public final String bOq()
  {
    return this.paV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.x
 * JD-Core Version:    0.7.0.1
 */