package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class bn
  extends a
{
  public long isX;
  public long isY;
  public long isZ;
  public String ita;
  
  public bn()
  {
    this.isX = 0L;
    this.isY = 0L;
    this.isZ = 0L;
    this.ita = "";
  }
  
  public bn(String paramString)
  {
    AppMethodBeat.i(368860);
    this.isX = 0L;
    this.isY = 0L;
    this.isZ = 0L;
    this.ita = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 4) {
          break label128;
        }
        String[] arrayOfString = new String[4];
        Arrays.fill(arrayOfString, 0, 4, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label128:
    for (;;)
    {
      this.isX = Util.getLong(paramString[0], 0L);
      this.isY = Util.getLong(paramString[1], 0L);
      this.isZ = Util.getLong(paramString[2], 0L);
      this.ita = F("edgeLogVal", paramString[3], true);
      AppMethodBeat.o(368860);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.isX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.isY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.isZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ita);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368868);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368872);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionCode:").append(this.isX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("syncScene:").append(this.isY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("edgeLogId:").append(this.isZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("edgeLogVal:").append(this.ita);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368872);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bn
 * JD-Core Version:    0.7.0.1
 */