package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ex
  extends a
{
  private long dTq;
  private String dTr = "";
  private String dTu = "";
  private long dWt = 0L;
  private long dXq = 0L;
  private String efw = "";
  private String ekM = "";
  private String ekN = "";
  private long ekO = 0L;
  private long ekP = 0L;
  private long ekQ;
  private long ekR = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(197972);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXq);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(197972);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(197973);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.efw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.ekM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.ekN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.ekO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.ekP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.ekQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.ekR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.dXq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(197973);
    return localObject;
  }
  
  public final ex Tq()
  {
    this.dWt = 59L;
    return this;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final ex kk(long paramLong)
  {
    this.ekO = paramLong;
    return this;
  }
  
  public final ex kl(long paramLong)
  {
    this.ekP = paramLong;
    return this;
  }
  
  public final ex km(long paramLong)
  {
    this.ekQ = paramLong;
    return this;
  }
  
  public final ex kn(long paramLong)
  {
    this.dTq = paramLong;
    return this;
  }
  
  public final ex ko(long paramLong)
  {
    this.dXq = paramLong;
    return this;
  }
  
  public final ex ot(String paramString)
  {
    AppMethodBeat.i(197967);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(197967);
    return this;
  }
  
  public final ex ou(String paramString)
  {
    AppMethodBeat.i(197968);
    this.efw = t("SearchId", paramString, true);
    AppMethodBeat.o(197968);
    return this;
  }
  
  public final ex ov(String paramString)
  {
    AppMethodBeat.i(197969);
    this.ekM = t("ClickMD5", paramString, true);
    AppMethodBeat.o(197969);
    return this;
  }
  
  public final ex ow(String paramString)
  {
    AppMethodBeat.i(197970);
    this.ekN = t("QueryMD5", paramString, true);
    AppMethodBeat.o(197970);
    return this;
  }
  
  public final ex ox(String paramString)
  {
    AppMethodBeat.i(197971);
    this.dTu = t("RequestId", paramString, true);
    AppMethodBeat.o(197971);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ex
 * JD-Core Version:    0.7.0.1
 */