package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gt
  extends a
{
  public long dQk = 0L;
  public long eiQ = 0L;
  public long eiR = 0L;
  public long eiS = 0L;
  public long eiT = 0L;
  private String eiU = "";
  private String eiV = "";
  
  public final String PV()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.eiQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eiS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.dQk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.eiT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.eiU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.eiV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
  
  public final gt mw(String paramString)
  {
    AppMethodBeat.i(121785);
    this.eiU = t("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final gt mx(String paramString)
  {
    AppMethodBeat.i(121786);
    this.eiV = t("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gt
 * JD-Core Version:    0.7.0.1
 */