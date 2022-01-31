package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
{
  private String fXq;
  private boolean fXr;
  private long time;
  
  public q(String paramString)
  {
    AppMethodBeat.i(50781);
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    paramString = str.split(":");
    try
    {
      if (paramString.length > 0) {
        this.fXq = paramString[0];
      }
      if (paramString.length > 1) {
        this.time = bo.getLong(paramString[1], 0L);
      }
      if (paramString.length > 2) {
        this.fXr = paramString[2].equals("1");
      }
      AppMethodBeat.o(50781);
      return;
    }
    catch (Exception paramString)
    {
      if (this.fXq == null) {
        this.fXq = "";
      }
      this.fXr = false;
      this.time = 0L;
      ab.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
      AppMethodBeat.o(50781);
    }
  }
  
  public static String d(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(50780);
    paramString = new StringBuilder().append(paramString).append(":").append(paramLong).append(":");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = i + "\n";
      AppMethodBeat.o(50780);
      return paramString;
    }
  }
  
  public final String alM()
  {
    return this.fXq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.q
 * JD-Core Version:    0.7.0.1
 */