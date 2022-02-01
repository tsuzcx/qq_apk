package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  private String dKl;
  private String dNK;
  private long dNL;
  private long dNM;
  private long dOC;
  private long dOD;
  private String dOi;
  private long dOj;
  
  public final String PR()
  {
    AppMethodBeat.i(190838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOD);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190838);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.dOi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.dOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.dOC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.dOD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190839);
    return localObject;
  }
  
  public final int getId()
  {
    return 19898;
  }
  
  public final ci ht(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final ci hu(long paramLong)
  {
    this.dOj = paramLong;
    return this;
  }
  
  public final ci hv(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final ci hw(long paramLong)
  {
    this.dOC = paramLong;
    return this;
  }
  
  public final ci hx(long paramLong)
  {
    this.dOD = paramLong;
    return this;
  }
  
  public final ci km(String paramString)
  {
    AppMethodBeat.i(190835);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190835);
    return this;
  }
  
  public final ci kn(String paramString)
  {
    AppMethodBeat.i(190836);
    this.dKl = t("topic", paramString, true);
    AppMethodBeat.o(190836);
    return this;
  }
  
  public final ci ko(String paramString)
  {
    AppMethodBeat.i(190837);
    this.dOi = t("liveusername", paramString, true);
    AppMethodBeat.o(190837);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ci
 * JD-Core Version:    0.7.0.1
 */