package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qq
  extends a
{
  public long gLO = 0L;
  public long hlo = 0L;
  public long hlp = 0L;
  public long hlq = 0L;
  public long hlr = 0L;
  private String hls = "";
  private String hlt = "";
  
  public final qq HA(String paramString)
  {
    AppMethodBeat.i(121785);
    this.hls = z("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final qq HB(String paramString)
  {
    AppMethodBeat.i(121786);
    this.hlt = z("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hlo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hls);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlt);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.hlo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.hlp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.hlq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.gLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.hlr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.hls);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.hlt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qq
 * JD-Core Version:    0.7.0.1
 */