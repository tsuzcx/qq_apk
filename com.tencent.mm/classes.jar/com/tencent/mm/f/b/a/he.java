package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class he
  extends a
{
  private long gDT;
  private String gDw = "";
  private long gDx;
  private long gDy;
  private long gEr = 0L;
  private long gEs;
  private String gEt = "";
  private String gEu = "";
  private long gEv;
  private long geB;
  private long ggH;
  
  public final String agH()
  {
    AppMethodBeat.i(195058);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(195058);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(195068);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.gEr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.gDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.gEs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.ggH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.gEt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("anchorusername:").append(this.gEu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audiencecount:").append(this.gEv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195068);
    return localObject;
  }
  
  public final int getId()
  {
    return 19893;
  }
  
  public final he qo(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final he qp(long paramLong)
  {
    this.gDT = paramLong;
    return this;
  }
  
  public final he qq(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final he qr(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final he qs(long paramLong)
  {
    this.gEs = paramLong;
    return this;
  }
  
  public final he qt(long paramLong)
  {
    this.ggH = paramLong;
    return this;
  }
  
  public final he qu(long paramLong)
  {
    this.gEv = paramLong;
    return this;
  }
  
  public final he we(String paramString)
  {
    AppMethodBeat.i(195029);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(195029);
    return this;
  }
  
  public final he wf(String paramString)
  {
    AppMethodBeat.i(195038);
    this.gEt = z("audienceUserName", paramString, true);
    AppMethodBeat.o(195038);
    return this;
  }
  
  public final he wg(String paramString)
  {
    AppMethodBeat.i(195043);
    this.gEu = z("anchorusername", paramString, true);
    AppMethodBeat.o(195043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.he
 * JD-Core Version:    0.7.0.1
 */