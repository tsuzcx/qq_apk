package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kd
  extends a
{
  public String gMG = "";
  public String gMH = "";
  private long gMI = 0L;
  public String giT = "";
  
  public final String agH()
  {
    AppMethodBeat.i(116484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMI);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(116484);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(116485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("api:").append(this.gMG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("arg:").append(this.gMH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timestampMs:").append(this.gMI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116485);
    return localObject;
  }
  
  public final int getId()
  {
    return 15961;
  }
  
  public final kd uO(long paramLong)
  {
    AppMethodBeat.i(116483);
    this.gMI = paramLong;
    super.bm("timestampMs", this.gMI);
    AppMethodBeat.o(116483);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kd
 * JD-Core Version:    0.7.0.1
 */