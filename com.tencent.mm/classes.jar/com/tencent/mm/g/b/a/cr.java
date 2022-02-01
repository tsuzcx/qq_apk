package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  private long dWm;
  private String dZB = "";
  private long eeA;
  private long eeB;
  private long eeC;
  private long eeD;
  private long eeE;
  private long eeF;
  private String eeu = "";
  private long eev;
  private long eew;
  private long eex = 0L;
  private long eey;
  private long eez;
  
  public final String RC()
  {
    AppMethodBeat.i(215494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eex);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eey);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eez);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeF);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215494);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215495);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.eeA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.eeB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.eeC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.eeD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.eeE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.eeF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215495);
    return localObject;
  }
  
  public final cr SU()
  {
    this.dWm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19891;
  }
  
  public final cr ik(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final cr il(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final cr im(long paramLong)
  {
    this.eey = paramLong;
    return this;
  }
  
  public final cr in(long paramLong)
  {
    this.eez = paramLong;
    return this;
  }
  
  public final cr io(long paramLong)
  {
    this.eeA = paramLong;
    return this;
  }
  
  public final cr ip(long paramLong)
  {
    this.eeB = paramLong;
    return this;
  }
  
  public final cr iq(long paramLong)
  {
    this.eeC = paramLong;
    return this;
  }
  
  public final cr ir(long paramLong)
  {
    this.eeD = paramLong;
    return this;
  }
  
  public final cr is(long paramLong)
  {
    this.eeE = paramLong;
    return this;
  }
  
  public final cr it(long paramLong)
  {
    this.eeF = paramLong;
    return this;
  }
  
  public final cr mh(String paramString)
  {
    AppMethodBeat.i(215492);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215492);
    return this;
  }
  
  public final cr mi(String paramString)
  {
    AppMethodBeat.i(215493);
    this.dZB = t("topic", paramString, true);
    AppMethodBeat.o(215493);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr
 * JD-Core Version:    0.7.0.1
 */