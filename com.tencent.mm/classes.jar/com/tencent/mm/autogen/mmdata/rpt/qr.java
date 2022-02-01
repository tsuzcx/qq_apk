package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qr
  extends a
{
  public long iCW;
  public long iHM;
  public long iOd;
  public long iSD;
  public String iWh = "";
  public String ijk = "";
  public long ikE;
  public String iwJ = "";
  public long jtk;
  public int jtu;
  
  public final String aIE()
  {
    AppMethodBeat.i(369304);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369304);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369309);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSource:").append(this.iHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.iCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.iSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressSize:").append(this.jtk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.jtu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.iwJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369309);
    return localObject;
  }
  
  public final int getId()
  {
    return 24975;
  }
  
  public final qr xQ(String paramString)
  {
    AppMethodBeat.i(369273);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(369273);
    return this;
  }
  
  public final qr xR(String paramString)
  {
    AppMethodBeat.i(369280);
    this.iWh = F("ToUsername", paramString, true);
    AppMethodBeat.o(369280);
    return this;
  }
  
  public final qr xS(String paramString)
  {
    AppMethodBeat.i(369289);
    this.iwJ = F("ExtraInfo", paramString, true);
    AppMethodBeat.o(369289);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qr
 * JD-Core Version:    0.7.0.1
 */