package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  private long guA;
  private long gzn;
  private String gzo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210023);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gzn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210023);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210024);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgType:").append(this.gzn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.guA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgId:").append(this.gzo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210024);
    return localObject;
  }
  
  public final fc akw()
  {
    this.gzn = 5L;
    return this;
  }
  
  public final int getId()
  {
    return 20849;
  }
  
  public final fc mU(long paramLong)
  {
    this.guA = paramLong;
    return this;
  }
  
  public final fc tO(String paramString)
  {
    AppMethodBeat.i(210022);
    this.gzo = z("msgId", paramString, true);
    AppMethodBeat.o(210022);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fc
 * JD-Core Version:    0.7.0.1
 */