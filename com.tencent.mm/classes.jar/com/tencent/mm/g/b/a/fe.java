package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fe
  extends a
{
  private String eFc = "";
  private long eFd;
  private long eFe = 0L;
  private long eFf;
  private long eFg;
  private long eFh;
  private long eFi;
  private long eFj;
  private long eFk;
  private long eFl;
  private long eFm;
  private long erw;
  private String evz = "";
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207412);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFm);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207412);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207413);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.evz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.eFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.eFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.eFg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.eFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.eFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.eFj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.eFk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.eFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.eFm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207413);
    return localObject;
  }
  
  public final fe afX()
  {
    this.erw = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19891;
  }
  
  public final fe ng(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fe nh(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fe ni(long paramLong)
  {
    this.eFf = paramLong;
    return this;
  }
  
  public final fe nj(long paramLong)
  {
    this.eFg = paramLong;
    return this;
  }
  
  public final fe nk(long paramLong)
  {
    this.eFh = paramLong;
    return this;
  }
  
  public final fe nl(long paramLong)
  {
    this.eFi = paramLong;
    return this;
  }
  
  public final fe nm(long paramLong)
  {
    this.eFj = paramLong;
    return this;
  }
  
  public final fe nn(long paramLong)
  {
    this.eFk = paramLong;
    return this;
  }
  
  public final fe no(long paramLong)
  {
    this.eFl = paramLong;
    return this;
  }
  
  public final fe np(long paramLong)
  {
    this.eFm = paramLong;
    return this;
  }
  
  public final fe sb(String paramString)
  {
    AppMethodBeat.i(207410);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207410);
    return this;
  }
  
  public final fe sc(String paramString)
  {
    AppMethodBeat.i(207411);
    this.evz = x("topic", paramString, true);
    AppMethodBeat.o(207411);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fe
 * JD-Core Version:    0.7.0.1
 */