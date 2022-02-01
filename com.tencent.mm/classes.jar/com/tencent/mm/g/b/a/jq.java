package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jq
  extends a
{
  public long eBW = 0L;
  public long eBX = 0L;
  public long eBY = 0L;
  public long eBZ = 0L;
  private String eCa = "";
  private String eCb = "";
  public long ehG = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCb);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.eBW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.eBX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eBY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.ehG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.eBZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.eCa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.eCb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
  
  public final jq si(String paramString)
  {
    AppMethodBeat.i(121785);
    this.eCa = t("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final jq sj(String paramString)
  {
    AppMethodBeat.i(121786);
    this.eCb = t("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jq
 * JD-Core Version:    0.7.0.1
 */