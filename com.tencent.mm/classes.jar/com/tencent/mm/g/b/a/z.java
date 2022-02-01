package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class z
  extends a
{
  public long dVR;
  public int dVS;
  public int dVT;
  private String dVU;
  private String dVV;
  private String dVW;
  
  public z()
  {
    this.dVU = "";
    this.dVV = "";
    this.dVW = "";
  }
  
  public z(String paramString)
  {
    AppMethodBeat.i(108282);
    this.dVU = "";
    this.dVV = "";
    this.dVW = "";
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
      this.dVR = bu.getLong(paramString[0], 0L);
      this.dVS = bu.getInt(paramString[1], 0);
      this.dVT = bu.getInt(paramString[2], 0);
      ha(paramString[3]);
      hb(paramString[4]);
      hc(paramString[5]);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dVS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dVT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.dVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.dVV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.dVW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final int getId()
  {
    return 18662;
  }
  
  public final z ha(String paramString)
  {
    AppMethodBeat.i(108283);
    this.dVU = t("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final z hb(String paramString)
  {
    AppMethodBeat.i(108284);
    this.dVV = t("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
  
  public final z hc(String paramString)
  {
    AppMethodBeat.i(108285);
    this.dVW = t("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.z
 * JD-Core Version:    0.7.0.1
 */