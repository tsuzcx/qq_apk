package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class il
  extends a
{
  public long dSb = 0L;
  public long ekU = 0L;
  public long ekV = 0L;
  public long ekW = 0L;
  public long ekX = 0L;
  private String ekY = "";
  private String ekZ = "";
  
  public final String PR()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekZ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.ekU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.ekV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.ekW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.ekX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.ekY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.ekZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
  
  public final il pC(String paramString)
  {
    AppMethodBeat.i(121785);
    this.ekY = t("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final il pD(String paramString)
  {
    AppMethodBeat.i(121786);
    this.ekZ = t("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.il
 * JD-Core Version:    0.7.0.1
 */