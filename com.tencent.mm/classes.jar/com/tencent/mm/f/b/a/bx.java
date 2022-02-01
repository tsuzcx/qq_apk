package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  private long goA;
  private long gog;
  private long goh;
  private long gom;
  private long got;
  private String gou = "";
  private long gov;
  private long gow;
  private long gox;
  private long goy;
  private long goz;
  
  public final String agH()
  {
    AppMethodBeat.i(209956);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.goh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.got);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gog);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gou);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gov);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gox);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gom);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goA);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209956);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209957);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("myAccountType:").append(this.goh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGreetSession:").append(this.got);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fromCommentScene:").append(this.gog);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chatlistSessionid:").append(this.gou);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeSessionCount:").append(this.gov);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeChatCount:").append(this.gow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionClickCount:").append(this.gox);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSessionCount:").append(this.goy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("delSessionCount:").append(this.goz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayDuration:").append(this.gom);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dotClickCount:").append(this.goA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209957);
    return localObject;
  }
  
  public final bx em(long paramLong)
  {
    this.goh = paramLong;
    return this;
  }
  
  public final bx en(long paramLong)
  {
    this.got = paramLong;
    return this;
  }
  
  public final bx eo(long paramLong)
  {
    this.gog = paramLong;
    return this;
  }
  
  public final bx ep(long paramLong)
  {
    this.gov = paramLong;
    return this;
  }
  
  public final bx eq(long paramLong)
  {
    this.gow = paramLong;
    return this;
  }
  
  public final bx er(long paramLong)
  {
    this.gox = paramLong;
    return this;
  }
  
  public final bx es(long paramLong)
  {
    this.goy = paramLong;
    return this;
  }
  
  public final bx et(long paramLong)
  {
    this.goz = paramLong;
    return this;
  }
  
  public final bx eu(long paramLong)
  {
    this.gom = paramLong;
    return this;
  }
  
  public final bx ev(long paramLong)
  {
    this.goA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20688;
  }
  
  public final bx lq(String paramString)
  {
    AppMethodBeat.i(209954);
    this.gou = z("chatlistSessionid", paramString, true);
    AppMethodBeat.o(209954);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bx
 * JD-Core Version:    0.7.0.1
 */