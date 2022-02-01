package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cd
  extends a
{
  private long dHR;
  private String dKl;
  private String dNK;
  private long dNL;
  private long dNM;
  private String dOi;
  private long dOj;
  private long dOk;
  private long dOl;
  
  public final String PR()
  {
    AppMethodBeat.i(190818);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOl);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190818);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.dOi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.dOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.dOk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.dOl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190819);
    return localObject;
  }
  
  public final cd gX(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final cd gY(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final cd gZ(long paramLong)
  {
    this.dOj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19897;
  }
  
  public final cd ha(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final cd hb(long paramLong)
  {
    this.dOk = paramLong;
    return this;
  }
  
  public final cd hc(long paramLong)
  {
    this.dOl = paramLong;
    return this;
  }
  
  public final cd kc(String paramString)
  {
    AppMethodBeat.i(190815);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190815);
    return this;
  }
  
  public final cd kd(String paramString)
  {
    AppMethodBeat.i(190816);
    this.dKl = t("topic", paramString, true);
    AppMethodBeat.o(190816);
    return this;
  }
  
  public final cd ke(String paramString)
  {
    AppMethodBeat.i(190817);
    this.dOi = t("liveusername", paramString, true);
    AppMethodBeat.o(190817);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cd
 * JD-Core Version:    0.7.0.1
 */