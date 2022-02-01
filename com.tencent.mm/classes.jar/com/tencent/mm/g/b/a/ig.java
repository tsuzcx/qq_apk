package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  private long dKc;
  private String dQr;
  private long mat;
  private long mbm = 0L;
  
  public final ig Am(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202455);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202456);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.mbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202456);
    return localObject;
  }
  
  public final ig aTe(String paramString)
  {
    AppMethodBeat.i(202454);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202454);
    return this;
  }
  
  public final ig btb()
  {
    this.dKc = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ig
 * JD-Core Version:    0.7.0.1
 */