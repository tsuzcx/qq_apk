package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class js
  extends a
{
  public long eDF = 0L;
  public long eDG = 0L;
  public long eDH = 0L;
  public long eDI = 0L;
  private String eDJ = "";
  private String eDK = "";
  public long ejq = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDK);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.eDF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.eDG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eDH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.ejq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.eDI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.eDJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.eDK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
  
  public final js sD(String paramString)
  {
    AppMethodBeat.i(121785);
    this.eDJ = t("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final js sE(String paramString)
  {
    AppMethodBeat.i(121786);
    this.eDK = t("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.js
 * JD-Core Version:    0.7.0.1
 */