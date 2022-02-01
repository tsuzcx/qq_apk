package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class i
  extends a
{
  public String ikl;
  public String ikm;
  public String ikn;
  public long iko;
  public long ikp;
  public long ikq;
  
  public i()
  {
    this.ikl = "";
    this.ikm = "";
    this.ikn = "";
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(368642);
    this.ikl = "";
    this.ikm = "";
    this.ikn = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 6) {
          break label138;
        }
        String[] arrayOfString = new String[6];
        Arrays.fill(arrayOfString, 0, 6, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label138:
    for (;;)
    {
      ka(paramString[0]);
      kb(paramString[1]);
      kc(paramString[2]);
      this.iko = Util.getLong(paramString[3], 0L);
      this.ikp = Util.getLong(paramString[4], 0L);
      this.ikq = Util.getLong(paramString[5], 0L);
      AppMethodBeat.o(368642);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368665);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368665);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368671);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lastSessionId:").append(this.ikl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionId:").append(this.ikm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nextSessionId:").append(this.ikn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionEnterMs:").append(this.iko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionQuitMs:").append(this.ikp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionStayTime:").append(this.ikq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368671);
    return localObject;
  }
  
  public final int getId()
  {
    return 21948;
  }
  
  public final i ka(String paramString)
  {
    AppMethodBeat.i(368652);
    this.ikl = F("lastSessionId", paramString, true);
    AppMethodBeat.o(368652);
    return this;
  }
  
  public final i kb(String paramString)
  {
    AppMethodBeat.i(368657);
    this.ikm = F("currSessionId", paramString, true);
    AppMethodBeat.o(368657);
    return this;
  }
  
  public final i kc(String paramString)
  {
    AppMethodBeat.i(368659);
    this.ikn = F("nextSessionId", paramString, true);
    AppMethodBeat.o(368659);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.i
 * JD-Core Version:    0.7.0.1
 */