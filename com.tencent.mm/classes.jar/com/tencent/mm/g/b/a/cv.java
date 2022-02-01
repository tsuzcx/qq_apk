package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cv
  extends a
{
  private long dWm;
  private String dZB = "";
  private String eeS = "";
  private long eeT;
  private long eeU;
  private long eeV;
  private String eeu = "";
  private long eev;
  private long eew;
  
  public final String RC()
  {
    AppMethodBeat.i(215511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeV);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215511);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215512);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eeS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eeT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.eeU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.eeV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215512);
    return localObject;
  }
  
  public final int getId()
  {
    return 19897;
  }
  
  public final cv iK(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final cv iL(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final cv iM(long paramLong)
  {
    this.eeT = paramLong;
    return this;
  }
  
  public final cv iN(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final cv iO(long paramLong)
  {
    this.eeU = paramLong;
    return this;
  }
  
  public final cv iP(long paramLong)
  {
    this.eeV = paramLong;
    return this;
  }
  
  public final cv mp(String paramString)
  {
    AppMethodBeat.i(215508);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215508);
    return this;
  }
  
  public final cv mq(String paramString)
  {
    AppMethodBeat.i(215509);
    this.dZB = t("topic", paramString, true);
    AppMethodBeat.o(215509);
    return this;
  }
  
  public final cv mr(String paramString)
  {
    AppMethodBeat.i(215510);
    this.eeS = t("liveusername", paramString, true);
    AppMethodBeat.o(215510);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cv
 * JD-Core Version:    0.7.0.1
 */