package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dj
  extends a
{
  private String gfg = "";
  private String gfl = "";
  private int glx;
  private String gtA = "";
  private String gtB = "";
  private int gtC;
  private int gtD;
  private String gtE = "";
  private String gtF = "";
  private String gtG = "";
  private long gtH;
  private String gtI = "";
  private int gtw;
  private int gtx;
  private long gty;
  private int gtz;
  
  public final String agH()
  {
    AppMethodBeat.i(207944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gtw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gty);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtI);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207944);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isFirstOpen:").append(this.gtw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.gtx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.gfg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.gty);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appType:").append(this.gtz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.glx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("preWarmPath:").append(this.gtB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPresend:").append(this.gtC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.gtD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.gtE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderId:").append(this.gtF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowId:").append(this.gtG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.gfl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventTime:").append(this.gtH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickId:").append(this.gtI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207947);
    return localObject;
  }
  
  public final dj ajd()
  {
    this.gty = 0L;
    return this;
  }
  
  public final dj aje()
  {
    this.gtz = 10;
    return this;
  }
  
  public final int getId()
  {
    return 21188;
  }
  
  public final dj iH(long paramLong)
  {
    this.gtH = paramLong;
    return this;
  }
  
  public final dj lA(int paramInt)
  {
    this.gtx = paramInt;
    return this;
  }
  
  public final dj lB(int paramInt)
  {
    this.glx = paramInt;
    return this;
  }
  
  public final dj lC(int paramInt)
  {
    this.gtC = paramInt;
    return this;
  }
  
  public final dj lD(int paramInt)
  {
    this.gtD = paramInt;
    return this;
  }
  
  public final dj lz(int paramInt)
  {
    this.gtw = paramInt;
    return this;
  }
  
  public final dj pN(String paramString)
  {
    AppMethodBeat.i(207916);
    this.gfg = z("appId", paramString, true);
    AppMethodBeat.o(207916);
    return this;
  }
  
  public final dj pO(String paramString)
  {
    AppMethodBeat.i(207923);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(207923);
    return this;
  }
  
  public final dj pP(String paramString)
  {
    AppMethodBeat.i(207924);
    this.gtB = z("preWarmPath", paramString, true);
    AppMethodBeat.o(207924);
    return this;
  }
  
  public final dj pQ(String paramString)
  {
    AppMethodBeat.i(207929);
    this.gtE = z("liveId", paramString, true);
    AppMethodBeat.o(207929);
    return this;
  }
  
  public final dj pR(String paramString)
  {
    AppMethodBeat.i(207931);
    this.gtF = z("finderId", paramString, true);
    AppMethodBeat.o(207931);
    return this;
  }
  
  public final dj pS(String paramString)
  {
    AppMethodBeat.i(207935);
    this.gtG = z("shopwindowId", paramString, true);
    AppMethodBeat.o(207935);
    return this;
  }
  
  public final dj pT(String paramString)
  {
    AppMethodBeat.i(207936);
    this.gfl = z("sessionId", paramString, true);
    AppMethodBeat.o(207936);
    return this;
  }
  
  public final dj pU(String paramString)
  {
    AppMethodBeat.i(207940);
    this.gtI = z("clickId", paramString, true);
    AppMethodBeat.o(207940);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dj
 * JD-Core Version:    0.7.0.1
 */