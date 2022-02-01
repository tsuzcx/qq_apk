package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class en
  extends a
{
  public String dTT = "";
  public String ejM = "";
  public String ejN = "";
  private long ejO = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejO);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.ejM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.ejN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.ejO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final int getId()
  {
    return 15961;
  }
  
  public final en kj(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.ejO = paramLong;
    super.bh("timestampMs", this.ejO);
    AppMethodBeat.o(116483);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.en
 * JD-Core Version:    0.7.0.1
 */