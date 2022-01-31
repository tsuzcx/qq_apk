package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

public final class n
{
  public String eHA;
  public boolean eHB;
  public long time;
  
  public n(String paramString)
  {
    String str = paramString;
    for (;;)
    {
      try
      {
        if (paramString.endsWith("\n")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
        paramString = str.split(":");
        if ((paramString.length == 4) && (ad.hd(paramString[0])))
        {
          i = 1;
          if (paramString.length > i) {
            this.eHA = paramString[i];
          }
          if (paramString.length > i + 1) {
            this.time = bk.getLong(paramString[(i + 1)], 0L);
          }
          if (paramString.length > i + 2) {
            this.eHB = paramString[(i + 2)].equals("1");
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        if (this.eHA == null) {
          this.eHA = "";
        }
        this.eHB = false;
        this.time = 0L;
        y.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        return;
      }
      int i = 0;
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
 * Qualified Name:     com.tencent.mm.modelvoice.n
 * JD-Core Version:    0.7.0.1
 */