package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ag
  extends a
{
  private long dWB;
  private long dWH;
  private String dWI = "";
  private long dWJ;
  private long dWK;
  private long dWL;
  private long dWM;
  private long dWN;
  private long dWO;
  private long dWv;
  private long dWw;
  
  public final String RC()
  {
    AppMethodBeat.i(189074);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWO);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189074);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189075);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("myAccountType:").append(this.dWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGreetSession:").append(this.dWH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fromCommentScene:").append(this.dWv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatlistSessionid:").append(this.dWI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeSessionCount:").append(this.dWJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeChatCount:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionClickCount:").append(this.dWL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSessionCount:").append(this.dWM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delSessionCount:").append(this.dWN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayDuration:").append(this.dWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dotClickCount:").append(this.dWO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189075);
    return localObject;
  }
  
  public final ag cA(long paramLong)
  {
    this.dWK = paramLong;
    return this;
  }
  
  public final ag cB(long paramLong)
  {
    this.dWL = paramLong;
    return this;
  }
  
  public final ag cC(long paramLong)
  {
    this.dWM = paramLong;
    return this;
  }
  
  public final ag cD(long paramLong)
  {
    this.dWN = paramLong;
    return this;
  }
  
  public final ag cE(long paramLong)
  {
    this.dWB = paramLong;
    return this;
  }
  
  public final ag cF(long paramLong)
  {
    this.dWO = paramLong;
    return this;
  }
  
  public final ag cw(long paramLong)
  {
    this.dWw = paramLong;
    return this;
  }
  
  public final ag cx(long paramLong)
  {
    this.dWH = paramLong;
    return this;
  }
  
  public final ag cy(long paramLong)
  {
    this.dWv = paramLong;
    return this;
  }
  
  public final ag cz(long paramLong)
  {
    this.dWJ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20688;
  }
  
  public final ag hl(String paramString)
  {
    AppMethodBeat.i(189073);
    this.dWI = t("chatlistSessionid", paramString, true);
    AppMethodBeat.o(189073);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ag
 * JD-Core Version:    0.7.0.1
 */