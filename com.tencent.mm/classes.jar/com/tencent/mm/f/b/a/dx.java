package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dx
  extends a
{
  private String ggA = "";
  private long guA;
  private long gvf;
  private String gvg = "";
  private long gvh;
  private String gvi = "";
  private String gvj = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209535);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209535);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209536);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pickerScene:").append(this.gvf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.guA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventCode:").append(this.gvg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tabType:").append(this.gvh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udfKv:").append(this.gvi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.gvj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209536);
    return localObject;
  }
  
  public final int getId()
  {
    return 22878;
  }
  
  public final dx kd(long paramLong)
  {
    this.gvf = paramLong;
    return this;
  }
  
  public final dx ke(long paramLong)
  {
    this.guA = paramLong;
    return this;
  }
  
  public final dx kf(long paramLong)
  {
    this.gvh = paramLong;
    return this;
  }
  
  public final dx qZ(String paramString)
  {
    AppMethodBeat.i(209529);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209529);
    return this;
  }
  
  public final dx ra(String paramString)
  {
    AppMethodBeat.i(209532);
    this.gvg = z("eventCode", paramString, true);
    AppMethodBeat.o(209532);
    return this;
  }
  
  public final dx rb(String paramString)
  {
    AppMethodBeat.i(209533);
    this.gvi = z("udfKv", paramString, true);
    AppMethodBeat.o(209533);
    return this;
  }
  
  public final dx rc(String paramString)
  {
    AppMethodBeat.i(209534);
    this.gvj = z("timeStampInMs", paramString, true);
    AppMethodBeat.o(209534);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dx
 * JD-Core Version:    0.7.0.1
 */