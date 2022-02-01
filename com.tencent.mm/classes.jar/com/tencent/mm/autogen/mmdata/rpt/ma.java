package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ma
  extends a
{
  public long iGM;
  private long ipZ;
  public long iuA;
  private String jaI = "";
  public long jaJ;
  public long jaK;
  public long jaL;
  public long jaM;
  public long jaN;
  public long jaO;
  public long jaP;
  public long jaQ;
  public long jaR;
  public long jaS;
  public long jaT;
  
  public final String aIE()
  {
    AppMethodBeat.i(368465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jaI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368465);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368475);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("friendUsername:").append(this.jaI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isClickAll:").append(this.jaJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("buttonAddNewLabelCnt:").append(this.jaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchAddNewLabelCnt:").append(this.jaL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectAddLabelCnt:").append(this.jaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchAddLabelCnt:").append(this.jaN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oriLabelCnt:").append(this.jaO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("removedLabelCnt:").append(this.jaP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addedLabelCnt:").append(this.jaQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTime:").append(this.iGM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLabelCnt:").append(this.jaR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("opResult:").append(this.jaS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addremark:").append(this.jaT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("source:").append(this.ipZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368475);
    return localObject;
  }
  
  public final ma aIQ()
  {
    this.ipZ = 22L;
    return this;
  }
  
  public final int getId()
  {
    return 22865;
  }
  
  public final ma uI(String paramString)
  {
    AppMethodBeat.i(368449);
    this.jaI = F("friendUsername", paramString, true);
    AppMethodBeat.o(368449);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ma
 * JD-Core Version:    0.7.0.1
 */