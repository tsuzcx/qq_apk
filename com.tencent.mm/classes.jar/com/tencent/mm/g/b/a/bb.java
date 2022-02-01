package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  private long dPH;
  private String dVa;
  private String dVb;
  private long dVd;
  private String dWX;
  private long dYc;
  private long dYd;
  private long dYe;
  private long dYf;
  private long dYg;
  
  public final String RD()
  {
    AppMethodBeat.i(209152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYg);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209152);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("messageType:").append(this.dYd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.dYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isfloat:").append(this.dYf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerVersion:").append(this.dYg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209153);
    return localObject;
  }
  
  public final bb Se()
  {
    this.dYg = 1L;
    return this;
  }
  
  public final bb eA(long paramLong)
  {
    this.dPH = paramLong;
    return this;
  }
  
  public final bb eB(long paramLong)
  {
    this.dYc = paramLong;
    return this;
  }
  
  public final bb eC(long paramLong)
  {
    this.dYd = paramLong;
    return this;
  }
  
  public final bb eD(long paramLong)
  {
    this.dYe = paramLong;
    return this;
  }
  
  public final bb ez(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final bb jf(String paramString)
  {
    AppMethodBeat.i(209149);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209149);
    return this;
  }
  
  public final bb jg(String paramString)
  {
    AppMethodBeat.i(209150);
    this.dVb = t("Contextid", paramString, true);
    AppMethodBeat.o(209150);
    return this;
  }
  
  public final bb jh(String paramString)
  {
    AppMethodBeat.i(209151);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bb
 * JD-Core Version:    0.7.0.1
 */