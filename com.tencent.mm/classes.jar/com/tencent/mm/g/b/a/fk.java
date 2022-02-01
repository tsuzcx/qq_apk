package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fk
  extends a
{
  private long dXn;
  private long dXo;
  private long dXp;
  private String dXw;
  private long dXy;
  
  public final String PR()
  {
    AppMethodBeat.i(209781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXw);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(209781);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(209782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.dXy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.dXw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209782);
    return localObject;
  }
  
  public final int getId()
  {
    return 20203;
  }
  
  public final fk ke(long paramLong)
  {
    this.dXn = paramLong;
    return this;
  }
  
  public final fk kf(long paramLong)
  {
    this.dXo = paramLong;
    return this;
  }
  
  public final fk kg(long paramLong)
  {
    this.dXp = paramLong;
    return this;
  }
  
  public final fk kh(long paramLong)
  {
    this.dXy = paramLong;
    return this;
  }
  
  public final fk mS(String paramString)
  {
    AppMethodBeat.i(209780);
    this.dXw = t("WordVersion", paramString, true);
    AppMethodBeat.o(209780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fk
 * JD-Core Version:    0.7.0.1
 */