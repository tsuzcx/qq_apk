package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class e
  extends a
{
  public long eiR;
  public String ejo = "";
  private long ejp;
  private long ejq;
  public String ejr = "";
  
  public final String abV()
  {
    AppMethodBeat.i(238843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejr);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238843);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ejo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeMs:").append(this.ejp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GetTimeMs:").append(this.ejq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.ejr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238844);
    return localObject;
  }
  
  public final e bI(long paramLong)
  {
    AppMethodBeat.i(238841);
    this.ejp = paramLong;
    super.bi("StartTimeMs", this.ejp);
    AppMethodBeat.o(238841);
    return this;
  }
  
  public final e bJ(long paramLong)
  {
    AppMethodBeat.i(238842);
    this.ejq = paramLong;
    super.bi("GetTimeMs", this.ejq);
    AppMethodBeat.o(238842);
    return this;
  }
  
  public final int getId()
  {
    return 21639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */