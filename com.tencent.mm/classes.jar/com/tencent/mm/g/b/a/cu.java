package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cu
  extends a
{
  private long dWm;
  private String dZB = "";
  private String eeR = "";
  private String eeS = "";
  private String eeu = "";
  private long eev;
  private long eew;
  private long eey;
  
  public final String RC()
  {
    AppMethodBeat.i(215506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eey);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeS);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215506);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215507);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eeS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215507);
    return localObject;
  }
  
  public final cu SW()
  {
    this.dWm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19896;
  }
  
  public final cu iH(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final cu iI(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final cu iJ(long paramLong)
  {
    this.eey = paramLong;
    return this;
  }
  
  public final cu mm(String paramString)
  {
    AppMethodBeat.i(215503);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215503);
    return this;
  }
  
  public final cu mn(String paramString)
  {
    AppMethodBeat.i(215504);
    this.dZB = t("topic", paramString, true);
    AppMethodBeat.o(215504);
    return this;
  }
  
  public final cu mo(String paramString)
  {
    AppMethodBeat.i(215505);
    this.eeS = t("liveusername", paramString, true);
    AppMethodBeat.o(215505);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu
 * JD-Core Version:    0.7.0.1
 */