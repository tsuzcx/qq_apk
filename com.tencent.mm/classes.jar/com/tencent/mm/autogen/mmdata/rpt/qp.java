package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qp
  extends a
{
  public long iCW;
  public long iNl;
  public long iSD;
  public long ikE;
  private String imN = "";
  public long imZ;
  private String irn = "";
  public long jtk;
  private String jtl = "";
  public long jtm;
  public long jtn;
  public long jto;
  
  public final String aIE()
  {
    AppMethodBeat.i(369266);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jto);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369266);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369272);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileId:").append(this.irn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.iSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressSize:").append(this.jtk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.iNl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SenderUserName:").append(this.jtl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginLoadingTime:").append(this.jtm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoPlayTime:").append(this.jtn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.iCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverWriteMsgID:").append(this.jto);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369272);
    return localObject;
  }
  
  public final int getId()
  {
    return 25000;
  }
  
  public final qp xN(String paramString)
  {
    AppMethodBeat.i(369251);
    this.irn = F("FileId", paramString, true);
    AppMethodBeat.o(369251);
    return this;
  }
  
  public final qp xO(String paramString)
  {
    AppMethodBeat.i(369257);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(369257);
    return this;
  }
  
  public final qp xP(String paramString)
  {
    AppMethodBeat.i(369261);
    this.jtl = F("SenderUserName", paramString, true);
    AppMethodBeat.o(369261);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qp
 * JD-Core Version:    0.7.0.1
 */