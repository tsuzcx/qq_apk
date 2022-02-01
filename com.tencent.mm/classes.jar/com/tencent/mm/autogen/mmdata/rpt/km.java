package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class km
  extends a
{
  public String iWS = "";
  public String iWT = "";
  public String iWU = "";
  public String iWV = "";
  public long iWW;
  private String iWX = "";
  public String ijk = "";
  public String ilL = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368847);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368851);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.iWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.iWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.iWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.iWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Length:").append(this.iWW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayTrace:").append(this.iWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368851);
    return localObject;
  }
  
  public final int getId()
  {
    return 24576;
  }
  
  public final km sS(String paramString)
  {
    AppMethodBeat.i(368843);
    this.iWX = F("PlayTrace", paramString, true);
    AppMethodBeat.o(368843);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.km
 * JD-Core Version:    0.7.0.1
 */