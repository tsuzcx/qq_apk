package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  private long dTN;
  private long dWm;
  private String dZB = "";
  private long eeE;
  private long eeL;
  private long eeM;
  private long eeN;
  private long eeO;
  private long eeP;
  private long eeQ;
  private String eeu = "";
  private long eew;
  
  public final String RC()
  {
    AppMethodBeat.i(215501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeE);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215501);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215502);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.eeL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.eeM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.eeN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.eeO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.eeP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.eeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.eeE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215502);
    return localObject;
  }
  
  public final ct SV()
  {
    this.dWm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19890;
  }
  
  public final ct iA(long paramLong)
  {
    this.eeN = paramLong;
    return this;
  }
  
  public final ct iB(long paramLong)
  {
    this.eeO = paramLong;
    return this;
  }
  
  public final ct iC(long paramLong)
  {
    this.eeP = paramLong;
    return this;
  }
  
  public final ct iD(long paramLong)
  {
    this.dTN = paramLong;
    return this;
  }
  
  public final ct iE(long paramLong)
  {
    this.eeQ = paramLong;
    return this;
  }
  
  public final ct iF(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final ct iG(long paramLong)
  {
    this.eeE = paramLong;
    return this;
  }
  
  public final ct iy(long paramLong)
  {
    this.eeL = paramLong;
    return this;
  }
  
  public final ct iz(long paramLong)
  {
    this.eeM = paramLong;
    return this;
  }
  
  public final ct mk(String paramString)
  {
    AppMethodBeat.i(215499);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215499);
    return this;
  }
  
  public final ct ml(String paramString)
  {
    AppMethodBeat.i(215500);
    this.dZB = t("topic", paramString, true);
    AppMethodBeat.o(215500);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ct
 * JD-Core Version:    0.7.0.1
 */