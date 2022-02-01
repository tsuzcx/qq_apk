package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  private long dCQ;
  private String dHV;
  private String dHW;
  private String dHX;
  private long dHY;
  private long dHZ;
  
  public final String PR()
  {
    AppMethodBeat.i(194887);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHZ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194887);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194888);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.dHZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194888);
    return localObject;
  }
  
  public final aa cm(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final aa cn(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final aa co(long paramLong)
  {
    this.dHZ = paramLong;
    return this;
  }
  
  public final aa ga(String paramString)
  {
    AppMethodBeat.i(194884);
    this.dHV = t("Sessionid", paramString, true);
    AppMethodBeat.o(194884);
    return this;
  }
  
  public final aa gb(String paramString)
  {
    AppMethodBeat.i(194885);
    this.dHW = t("Contextid", paramString, true);
    AppMethodBeat.o(194885);
    return this;
  }
  
  public final aa gc(String paramString)
  {
    AppMethodBeat.i(194886);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(194886);
    return this;
  }
  
  public final int getId()
  {
    return 19995;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aa
 * JD-Core Version:    0.7.0.1
 */