package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  private String dNK;
  private long dNL;
  private long dNW = 0L;
  private long dNX;
  private String dNY;
  private long dNZ;
  private long dOa;
  
  public final String PR()
  {
    AppMethodBeat.i(190804);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOa);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190804);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190805);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.dNW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.dNX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.dNY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.dNZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.dOa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190805);
    return localObject;
  }
  
  public final ca gH(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final ca gI(long paramLong)
  {
    this.dNW = paramLong;
    return this;
  }
  
  public final ca gJ(long paramLong)
  {
    this.dNX = paramLong;
    return this;
  }
  
  public final ca gK(long paramLong)
  {
    this.dOa = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19894;
  }
  
  public final ca jW(String paramString)
  {
    AppMethodBeat.i(190803);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190803);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ca
 * JD-Core Version:    0.7.0.1
 */