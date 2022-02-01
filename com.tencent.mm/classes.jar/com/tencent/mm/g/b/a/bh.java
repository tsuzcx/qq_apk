package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  private long esa;
  private long esb;
  private long esg;
  private long esm;
  private String esn = "";
  private long eso;
  private long esp;
  private long esq;
  private long esr;
  private long ess;
  private long est;
  
  public final String abV()
  {
    AppMethodBeat.i(208865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eso);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ess);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.est);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208865);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("myAccountType:").append(this.esb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGreetSession:").append(this.esm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fromCommentScene:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatlistSessionid:").append(this.esn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeSessionCount:").append(this.eso);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeChatCount:").append(this.esp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionClickCount:").append(this.esq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSessionCount:").append(this.esr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delSessionCount:").append(this.ess);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayDuration:").append(this.esg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dotClickCount:").append(this.est);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208866);
    return localObject;
  }
  
  public final bh dA(long paramLong)
  {
    this.esa = paramLong;
    return this;
  }
  
  public final bh dB(long paramLong)
  {
    this.eso = paramLong;
    return this;
  }
  
  public final bh dC(long paramLong)
  {
    this.esp = paramLong;
    return this;
  }
  
  public final bh dD(long paramLong)
  {
    this.esq = paramLong;
    return this;
  }
  
  public final bh dE(long paramLong)
  {
    this.esr = paramLong;
    return this;
  }
  
  public final bh dF(long paramLong)
  {
    this.ess = paramLong;
    return this;
  }
  
  public final bh dG(long paramLong)
  {
    this.esg = paramLong;
    return this;
  }
  
  public final bh dH(long paramLong)
  {
    this.est = paramLong;
    return this;
  }
  
  public final bh dy(long paramLong)
  {
    this.esb = paramLong;
    return this;
  }
  
  public final bh dz(long paramLong)
  {
    this.esm = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20688;
  }
  
  public final bh jg(String paramString)
  {
    AppMethodBeat.i(208864);
    this.esn = x("chatlistSessionid", paramString, true);
    AppMethodBeat.o(208864);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bh
 * JD-Core Version:    0.7.0.1
 */