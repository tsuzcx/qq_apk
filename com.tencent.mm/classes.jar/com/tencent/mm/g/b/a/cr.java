package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  private long dUW;
  private String dYk = "";
  private String ecZ;
  private long eda;
  private long edb;
  private long edc = 0L;
  private long edd;
  private long ede;
  private long edf;
  private long edg;
  private long edh;
  private long edi;
  private long edj;
  private long edk;
  
  public final String RD()
  {
    AppMethodBeat.i(211878);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ede);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edk);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211878);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211879);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.edc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.ede);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.edf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.edh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.edi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.edj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.edk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211879);
    return localObject;
  }
  
  public final cr SQ()
  {
    this.dUW = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19891;
  }
  
  public final cr jdMethod_if(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final cr ig(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final cr ih(long paramLong)
  {
    this.edd = paramLong;
    return this;
  }
  
  public final cr ii(long paramLong)
  {
    this.ede = paramLong;
    return this;
  }
  
  public final cr ij(long paramLong)
  {
    this.edf = paramLong;
    return this;
  }
  
  public final cr ik(long paramLong)
  {
    this.edg = paramLong;
    return this;
  }
  
  public final cr il(long paramLong)
  {
    this.edh = paramLong;
    return this;
  }
  
  public final cr im(long paramLong)
  {
    this.edi = paramLong;
    return this;
  }
  
  public final cr in(long paramLong)
  {
    this.edj = paramLong;
    return this;
  }
  
  public final cr io(long paramLong)
  {
    this.edk = paramLong;
    return this;
  }
  
  public final cr lQ(String paramString)
  {
    AppMethodBeat.i(211876);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211876);
    return this;
  }
  
  public final cr lR(String paramString)
  {
    AppMethodBeat.i(211877);
    this.dYk = t("topic", paramString, true);
    AppMethodBeat.o(211877);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr
 * JD-Core Version:    0.7.0.1
 */