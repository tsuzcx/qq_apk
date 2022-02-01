package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class id
  extends a
{
  public long iPA;
  public long iPB;
  public long iPC;
  public int iPD;
  public long iPw;
  public long iPx;
  public long iPy;
  public long iPz;
  
  public final String aIE()
  {
    AppMethodBeat.i(369209);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369209);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369215);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PressTime:").append(this.iPw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EngineProcessTime:").append(this.iPx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NotifyToUIThreadTime:").append(this.iPy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetCandidateTime:").append(this.iPz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIUpdataTime:").append(this.iPA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyboardType:").append(this.iPB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationType:").append(this.iPC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyType:").append(this.iPD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369215);
    return localObject;
  }
  
  public final int getId()
  {
    return 22355;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.id
 * JD-Core Version:    0.7.0.1
 */