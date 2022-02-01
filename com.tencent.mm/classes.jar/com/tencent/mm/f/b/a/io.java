package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class io
  extends a
{
  private String gIO = "";
  private String gIP = "";
  private String gJg = "";
  private int gJh;
  private int gJi;
  private int gJj;
  private long gJk;
  private long gJl;
  private long gJm;
  private long gmT;
  private long gzY;
  
  public final String agH()
  {
    AppMethodBeat.i(230210);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(230210);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(230212);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextId:").append(this.gJg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvObjectId:").append(this.gIO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvNonceId:").append(this.gIP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvIndex:").append(this.gJh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChanged:").append(this.gJi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLocal:").append(this.gJj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTime:").append(this.gzY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitCount:").append(this.gJk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrType:").append(this.gJl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrCode:").append(this.gJm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(230212);
    return localObject;
  }
  
  public final int getId()
  {
    return 22278;
  }
  
  public final io ni(int paramInt)
  {
    this.gJh = paramInt;
    return this;
  }
  
  public final io nj(int paramInt)
  {
    this.gJi = paramInt;
    return this;
  }
  
  public final io nk(int paramInt)
  {
    this.gJj = paramInt;
    return this;
  }
  
  public final io tM(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final io tN(long paramLong)
  {
    this.gzY = paramLong;
    return this;
  }
  
  public final io tO(long paramLong)
  {
    this.gJk = paramLong;
    return this;
  }
  
  public final io tP(long paramLong)
  {
    this.gJl = paramLong;
    return this;
  }
  
  public final io tQ(long paramLong)
  {
    this.gJm = paramLong;
    return this;
  }
  
  public final io zx(String paramString)
  {
    AppMethodBeat.i(230190);
    this.gJg = z("contextId", paramString, true);
    AppMethodBeat.o(230190);
    return this;
  }
  
  public final io zy(String paramString)
  {
    AppMethodBeat.i(230193);
    this.gIO = z("mvObjectId", paramString, true);
    AppMethodBeat.o(230193);
    return this;
  }
  
  public final io zz(String paramString)
  {
    AppMethodBeat.i(230196);
    this.gIP = z("mvNonceId", paramString, true);
    AppMethodBeat.o(230196);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.io
 * JD-Core Version:    0.7.0.1
 */