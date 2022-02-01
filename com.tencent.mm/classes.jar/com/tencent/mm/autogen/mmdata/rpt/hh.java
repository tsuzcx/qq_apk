package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hh
  extends a
{
  public long iNJ = 0L;
  public long iNK = 0L;
  public String iNL = "";
  public long iNM = 0L;
  public long iNN = 0L;
  public String iNO = "";
  public String iNP = "";
  public long iNQ = 0L;
  public String iNR = "";
  public long ijA = 0L;
  public long iuA = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369054);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369054);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369062);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("exit_type:").append(this.iNJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Del_count:").append(this.iNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Del_list:").append(this.iNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fastListSeq:").append(this.iNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OneLineCount:").append(this.iNN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.iNO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerAppMsgType:").append(this.iNP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ijA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LogVersion:").append(this.iNQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUser:").append(this.iNR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369062);
    return localObject;
  }
  
  public final int getId()
  {
    return 24035;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hh
 * JD-Core Version:    0.7.0.1
 */