package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hj
  extends a
{
  public long eLK = 0L;
  public long eLL = 0L;
  public long eLM = 0L;
  public String eLN = "";
  public long eLO = 0L;
  public long eLP = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(223491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(223491);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(223492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResType:").append(this.eLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResSubType:").append(this.eLL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResVersion:").append(this.eLM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Network:").append(this.eLN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.eLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportKey:").append(this.eLP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(223492);
    return localObject;
  }
  
  public final int getId()
  {
    return 15166;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hj
 * JD-Core Version:    0.7.0.1
 */