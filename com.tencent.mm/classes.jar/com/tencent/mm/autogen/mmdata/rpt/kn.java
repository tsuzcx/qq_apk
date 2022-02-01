package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kn
  extends a
{
  public String iWS = "";
  public String iWT = "";
  private String iWU = "";
  private String iWV = "";
  public String iWY = "";
  private String iWZ = "";
  public String imT = "";
  public long ioV;
  public String ipT = "";
  public long iqr;
  
  public final String aIE()
  {
    AppMethodBeat.i(368801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368801);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368806);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.iWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.iWY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.iWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.iWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.iWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromSourceId:").append(this.iWZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368806);
    return localObject;
  }
  
  public final int getId()
  {
    return 22243;
  }
  
  public final kn sT(String paramString)
  {
    AppMethodBeat.i(368770);
    this.iWS = F("SongName", paramString, true);
    AppMethodBeat.o(368770);
    return this;
  }
  
  public final kn sU(String paramString)
  {
    AppMethodBeat.i(368775);
    this.iWU = F("WebUrl", paramString, true);
    AppMethodBeat.o(368775);
    return this;
  }
  
  public final kn sV(String paramString)
  {
    AppMethodBeat.i(368781);
    this.iWV = F("DataUrl", paramString, true);
    AppMethodBeat.o(368781);
    return this;
  }
  
  public final kn sW(String paramString)
  {
    AppMethodBeat.i(368788);
    this.iWT = F("Singer", paramString, true);
    AppMethodBeat.o(368788);
    return this;
  }
  
  public final kn sX(String paramString)
  {
    AppMethodBeat.i(368792);
    this.iWZ = F("FromSourceId", paramString, true);
    AppMethodBeat.o(368792);
    return this;
  }
  
  public final kn sY(String paramString)
  {
    AppMethodBeat.i(368797);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(368797);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kn
 * JD-Core Version:    0.7.0.1
 */