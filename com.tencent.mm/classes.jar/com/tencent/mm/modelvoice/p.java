package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class p
{
  public String fXq;
  public boolean fXr;
  public long time;
  
  public p(String paramString)
  {
    AppMethodBeat.i(55838);
    String str = paramString;
    for (;;)
    {
      try
      {
        if (paramString.endsWith("\n")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
        paramString = str.split(":");
        if ((paramString.length == 4) && (ad.nM(paramString[0])))
        {
          i = 1;
          if (paramString.length > i) {
            this.fXq = paramString[i];
          }
          if (paramString.length > i + 1) {
            this.time = bo.getLong(paramString[(i + 1)], 0L);
          }
          if (paramString.length > i + 2) {
            this.fXr = paramString[(i + 2)].equals("1");
          }
          AppMethodBeat.o(55838);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (this.fXq == null) {
          this.fXq = "";
        }
        this.fXr = false;
        this.time = 0L;
        ab.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        AppMethodBeat.o(55838);
        return;
      }
      int i = 0;
    }
  }
  
  public static String d(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(55837);
    paramString = new StringBuilder().append(paramString).append(":").append(paramLong).append(":");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = i + "\n";
      AppMethodBeat.o(55837);
      return paramString;
    }
  }
  
  public final String alM()
  {
    return this.fXq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.p
 * JD-Core Version:    0.7.0.1
 */