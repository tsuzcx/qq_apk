package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ff
  extends a
{
  private long eCt;
  private String eFc = "";
  private long eFn = 0L;
  private long eFo;
  private String eFp = "";
  private long eFq;
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207415);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207415);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207416);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.eFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.eFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.eFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.eCt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.eFq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207416);
    return localObject;
  }
  
  public final int getId()
  {
    return 19894;
  }
  
  public final ff nq(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final ff nr(long paramLong)
  {
    this.eFn = paramLong;
    return this;
  }
  
  public final ff ns(long paramLong)
  {
    this.eFo = paramLong;
    return this;
  }
  
  public final ff nt(long paramLong)
  {
    this.eFq = paramLong;
    return this;
  }
  
  public final ff sd(String paramString)
  {
    AppMethodBeat.i(207414);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207414);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ff
 * JD-Core Version:    0.7.0.1
 */