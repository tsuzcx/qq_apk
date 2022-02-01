package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  public long iPI;
  public long iPJ;
  public long iPK;
  public long iPL;
  public long iPM;
  public long iPN;
  public long iPO;
  public long iPP;
  private long iPQ;
  
  public final String aIE()
  {
    AppMethodBeat.i(369218);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369218);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369226);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InitializeTime:").append(this.iPI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateSessionTime:").append(this.iPJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionType:").append(this.iPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigDictTime:").append(this.iPL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCellDictTime:").append(this.iPM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitNetWorkTime:").append(this.iPN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshContactDictTime:").append(this.iPO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.iPP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessStartTime:").append(this.iPQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369226);
    return localObject;
  }
  
  public final int getId()
  {
    return 22354;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ig
 * JD-Core Version:    0.7.0.1
 */