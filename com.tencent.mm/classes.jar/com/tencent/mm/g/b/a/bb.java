package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  private long dQX;
  private String dWq = "";
  private String dWr = "";
  private long dWt;
  private String dYp = "";
  private long dZt;
  private long dZu;
  private long dZv;
  private long dZw;
  private long dZx;
  
  public final String RC()
  {
    AppMethodBeat.i(189186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZx);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189186);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189187);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.dZt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("messageType:").append(this.dZu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.dZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isfloat:").append(this.dZw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerVersion:").append(this.dZx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189187);
    return localObject;
  }
  
  public final bb Sc()
  {
    this.dZx = 1L;
    return this;
  }
  
  public final bb eA(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final bb eB(long paramLong)
  {
    this.dQX = paramLong;
    return this;
  }
  
  public final bb eC(long paramLong)
  {
    this.dZt = paramLong;
    return this;
  }
  
  public final bb eD(long paramLong)
  {
    this.dZu = paramLong;
    return this;
  }
  
  public final bb eE(long paramLong)
  {
    this.dZv = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final bb jr(String paramString)
  {
    AppMethodBeat.i(189183);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189183);
    return this;
  }
  
  public final bb js(String paramString)
  {
    AppMethodBeat.i(189184);
    this.dWr = t("Contextid", paramString, true);
    AppMethodBeat.o(189184);
    return this;
  }
  
  public final bb jt(String paramString)
  {
    AppMethodBeat.i(189185);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189185);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bb
 * JD-Core Version:    0.7.0.1
 */