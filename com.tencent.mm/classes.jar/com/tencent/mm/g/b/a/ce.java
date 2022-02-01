package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ce
  extends a
{
  private long dHR;
  private String dNK;
  private long dNM;
  private long dOm = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(190821);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190821);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.dOm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190822);
    return localObject;
  }
  
  public final ce QM()
  {
    this.dHR = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
  
  public final ce hd(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final ce kf(String paramString)
  {
    AppMethodBeat.i(190820);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190820);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ce
 * JD-Core Version:    0.7.0.1
 */