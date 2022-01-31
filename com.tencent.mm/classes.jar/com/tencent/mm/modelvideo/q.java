package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
{
  public String eHA;
  private boolean eHB;
  private long time;
  
  public q(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    paramString = str.split(":");
    try
    {
      if (paramString.length > 0) {
        this.eHA = paramString[0];
      }
      if (paramString.length > 1) {
        this.time = bk.getLong(paramString[1], 0L);
      }
      if (paramString.length > 2) {
        this.eHB = paramString[2].equals("1");
      }
      return;
    }
    catch (Exception paramString)
    {
      if (this.eHA == null) {
        this.eHA = "";
      }
      this.eHB = false;
      this.time = 0L;
      y.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
    }
  }
  
  public static String d(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = new StringBuilder().append(paramString).append(":").append(paramLong).append(":");
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return i + "\n";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.q
 * JD-Core Version:    0.7.0.1
 */