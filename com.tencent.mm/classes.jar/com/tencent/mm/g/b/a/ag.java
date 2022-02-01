package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ag
  extends a
{
  private long dVf;
  private long dVg;
  private long dVl;
  private long dVr;
  private String dVs;
  private long dVt;
  private long dVu;
  private long dVv;
  private long dVw;
  private long dVx;
  private long dVy;
  
  public final String RD()
  {
    AppMethodBeat.i(209046);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209046);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209047);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("myAccountType:").append(this.dVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGreetSession:").append(this.dVr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fromCommentScene:").append(this.dVf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatlistSessionid:").append(this.dVs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeSessionCount:").append(this.dVt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeChatCount:").append(this.dVu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionClickCount:").append(this.dVv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSessionCount:").append(this.dVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delSessionCount:").append(this.dVx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayDuration:").append(this.dVl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dotClickCount:").append(this.dVy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209047);
    return localObject;
  }
  
  public final ag cA(long paramLong)
  {
    this.dVu = paramLong;
    return this;
  }
  
  public final ag cB(long paramLong)
  {
    this.dVv = paramLong;
    return this;
  }
  
  public final ag cC(long paramLong)
  {
    this.dVw = paramLong;
    return this;
  }
  
  public final ag cD(long paramLong)
  {
    this.dVx = paramLong;
    return this;
  }
  
  public final ag cE(long paramLong)
  {
    this.dVl = paramLong;
    return this;
  }
  
  public final ag cF(long paramLong)
  {
    this.dVy = paramLong;
    return this;
  }
  
  public final ag cw(long paramLong)
  {
    this.dVg = paramLong;
    return this;
  }
  
  public final ag cx(long paramLong)
  {
    this.dVr = paramLong;
    return this;
  }
  
  public final ag cy(long paramLong)
  {
    this.dVf = paramLong;
    return this;
  }
  
  public final ag cz(long paramLong)
  {
    this.dVt = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20688;
  }
  
  public final ag hf(String paramString)
  {
    AppMethodBeat.i(209045);
    this.dVs = t("chatlistSessionid", paramString, true);
    AppMethodBeat.o(209045);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ag
 * JD-Core Version:    0.7.0.1
 */