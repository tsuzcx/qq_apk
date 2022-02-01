package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class dz
  extends a
{
  public long isX;
  public long isZ;
  public String ita;
  
  public dz()
  {
    this.isX = 0L;
    this.isZ = 0L;
    this.ita = "";
  }
  
  public dz(String paramString)
  {
    AppMethodBeat.i(368316);
    this.isX = 0L;
    this.isZ = 0L;
    this.ita = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 3) {
          break label112;
        }
        String[] arrayOfString = new String[3];
        Arrays.fill(arrayOfString, 0, 3, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label112:
    for (;;)
    {
      this.isX = Util.getLong(paramString[0], 0L);
      this.isZ = Util.getLong(paramString[1], 0L);
      this.ita = F("edgeLogVal", paramString[2], true);
      AppMethodBeat.o(368316);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368330);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.isX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.isZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ita);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368330);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368335);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionCode:").append(this.isX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("edgeLogId:").append(this.isZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("edgeLogVal:").append(this.ita);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368335);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dz
 * JD-Core Version:    0.7.0.1
 */