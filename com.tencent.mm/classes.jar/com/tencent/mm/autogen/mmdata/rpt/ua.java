package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ua
  extends a
{
  public int jFt = 0;
  public int jFu = 0;
  public int jFv = 0;
  public String jFw = "";
  public String jFx = "";
  public int jFy = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(368205);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFy);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368205);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368210);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppSDKVersion:").append(this.jFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigSDKVersion:").append(this.jFu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigVersion:").append(this.jFv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelList:").append(this.jFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InvalidModelList:").append(this.jFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigFileVersion:").append(this.jFy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368210);
    return localObject;
  }
  
  public final int getId()
  {
    return 24501;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ua
 * JD-Core Version:    0.7.0.1
 */