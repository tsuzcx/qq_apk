package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fr
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  public long ecI = 0L;
  public long ecK = 0L;
  public long ecL = 0L;
  public String ecO = "";
  public String ecr = "";
  public fr.a edo;
  public String edp = "";
  
  public final String PV()
  {
    AppMethodBeat.i(43617);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.edo != null) {}
    for (int i = this.edo.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecO);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43617);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43618);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.ecr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("referrer:").append(this.edp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.ecI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.ecL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.ecK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ecO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43618);
    return localObject;
  }
  
  public final int getId()
  {
    return 16006;
  }
  
  public final fr iP(long paramLong)
  {
    AppMethodBeat.i(43614);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43614);
    return this;
  }
  
  public final fr iQ(long paramLong)
  {
    AppMethodBeat.i(43615);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43615);
    return this;
  }
  
  public final fr iR(long paramLong)
  {
    AppMethodBeat.i(43616);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43616);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fr
 * JD-Core Version:    0.7.0.1
 */