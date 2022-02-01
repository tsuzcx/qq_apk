package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class p
{
  public String mhK;
  public boolean mhL;
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
        if ((paramString.length == 4) && (as.PY(paramString[0])))
        {
          i = 1;
          if (paramString.length > i) {
            this.mhK = paramString[i];
          }
          if (paramString.length > i + 1) {
            this.time = Util.getLong(paramString[(i + 1)], 0L);
          }
          if (paramString.length > i + 2) {
            this.mhL = paramString[(i + 2)].equals("1");
          }
          AppMethodBeat.o(130092);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (this.mhK == null) {
          this.mhK = "";
        }
        this.mhL = false;
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
  
  public final String bqK()
  {
    return this.mhK;
  }
  
  public final String brC()
  {
    AppMethodBeat.i(196550);
    Object localObject = new StringBuilder().append(this.mhK).append(":").append(this.time).append(":");
    if (this.mhL) {}
    for (int i = 1;; i = 0)
    {
      localObject = i + "\n";
      AppMethodBeat.o(196550);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.p
 * JD-Core Version:    0.7.0.1
 */