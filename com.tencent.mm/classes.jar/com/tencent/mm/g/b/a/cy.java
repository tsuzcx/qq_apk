package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  public long ddO = 0L;
  public long ddP = 0L;
  private String ddQ = "";
  public long ddR = 0L;
  private String ddS = "";
  private String ddT = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(91272);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ddO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ddP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ddQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ddR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ddS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ddT);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91272);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91273);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.ddO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.ddP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.ddQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.ddR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.ddS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.ddT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91273);
    return localObject;
  }
  
  public final int getId()
  {
    return 14688;
  }
  
  public final cy ih(String paramString)
  {
    AppMethodBeat.i(91269);
    this.ddQ = t("appId", paramString, true);
    AppMethodBeat.o(91269);
    return this;
  }
  
  public final cy ii(String paramString)
  {
    AppMethodBeat.i(91270);
    this.ddS = t("statBuffer", paramString, true);
    AppMethodBeat.o(91270);
    return this;
  }
  
  public final cy ij(String paramString)
  {
    AppMethodBeat.i(91271);
    this.ddT = t("switchId", paramString, true);
    AppMethodBeat.o(91271);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cy
 * JD-Core Version:    0.7.0.1
 */