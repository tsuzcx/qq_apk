package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nd
  extends a
{
  private long gXW;
  private long gXX;
  private long gXY;
  private long gXZ;
  private long gYa;
  private long gYb;
  private long gYc;
  private String gYd = "";
  private String gYe = "";
  private long gYf = 2020L;
  private long gYg;
  private long gYh;
  private String gYi = "";
  private String gYj = "";
  private long gYk;
  private long gYl;
  private String gYm = "";
  private long gYn;
  private long gYo;
  private int gYp = 0;
  private int gYq = 0;
  private long gYr;
  private long gYs;
  private long gYt = 0L;
  private long gYu = 1L;
  private long gYv = 0L;
  private String gYw = "";
  private String gYx = "";
  private long gYy = 0L;
  private String gYz = "";
  private long gnP = 0L;
  private String gvO = "";
  private long gwA = 2020L;
  
  public final nd DS(String paramString)
  {
    AppMethodBeat.i(233033);
    this.gYd = z("OutputVideoResolution", paramString, true);
    AppMethodBeat.o(233033);
    return this;
  }
  
  public final nd DT(String paramString)
  {
    AppMethodBeat.i(233036);
    this.gYe = z("OutputMediaInfo", paramString, true);
    AppMethodBeat.o(233036);
    return this;
  }
  
  public final nd DU(String paramString)
  {
    AppMethodBeat.i(233040);
    this.gvO = z("EditId", paramString, true);
    AppMethodBeat.o(233040);
    return this;
  }
  
  public final nd DV(String paramString)
  {
    AppMethodBeat.i(233053);
    this.gYm = z("IntelligentFilterSceneResult", paramString, true);
    AppMethodBeat.o(233053);
    return this;
  }
  
  public final nd DW(String paramString)
  {
    AppMethodBeat.i(233063);
    this.gYw = z("OriginMediaInfo", paramString, true);
    AppMethodBeat.o(233063);
    return this;
  }
  
  public final nd DX(String paramString)
  {
    AppMethodBeat.i(233064);
    this.gYx = z("ColorSpace", paramString, true);
    AppMethodBeat.o(233064);
    return this;
  }
  
  public final nd DY(String paramString)
  {
    AppMethodBeat.i(233065);
    this.gYz = z("CpuName", paramString, true);
    AppMethodBeat.o(233065);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(233066);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gXW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYz);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(233066);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(233068);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RenderLibVersion:").append(this.gXW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagCreateCount:").append(this.gXX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagCreateSuccessCount:").append(this.gXY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("avgRenderTime:").append(this.gXZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NormalFrameRenderTime:").append(this.gYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetFPS:").append(this.gYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputVideoFPS:").append(this.gYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputVideoResolution:").append(this.gYd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputMediaInfo:").append(this.gYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditId:").append(this.gvO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputResult:").append(this.gYf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RemuxType:").append(this.gwA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputVideoDurationMs:").append(this.gYg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RemuxVideoTimeMs:").append(this.gYh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoGOPSize:").append(this.gYi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSeekTimeMsStr:").append(this.gYj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCompositionTimeMs:").append(this.gYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IntelligentFilterSceneTimeMs:").append(this.gYl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IntelligentFilterSceneResult:").append(this.gYm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RenderFrames:").append(this.gYn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalRenderTime:").append(this.gYo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLongVideo:").append(this.gYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HevcOption:").append(this.gYq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioQuality:").append(this.gYr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoQuality:").append(this.gYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSoftEncode:").append(this.gYt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileExist:").append(this.gYu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFallbackSize:").append(this.gYv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginMediaInfo:").append(this.gYw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ColorSpace:").append(this.gYx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UseAnimationtool:").append(this.gYy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpuName:").append(this.gYz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(233068);
    return localObject;
  }
  
  public final nd anQ()
  {
    this.gYu = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 21177;
  }
  
  public final nd nY(int paramInt)
  {
    this.gYp = paramInt;
    return this;
  }
  
  public final nd nZ(int paramInt)
  {
    this.gYq = paramInt;
    return this;
  }
  
  public final nd yT(long paramLong)
  {
    this.gXW = paramLong;
    return this;
  }
  
  public final nd yU(long paramLong)
  {
    this.gXX = paramLong;
    return this;
  }
  
  public final nd yV(long paramLong)
  {
    this.gXY = paramLong;
    return this;
  }
  
  public final nd yW(long paramLong)
  {
    this.gXZ = paramLong;
    return this;
  }
  
  public final nd yX(long paramLong)
  {
    this.gYb = paramLong;
    return this;
  }
  
  public final nd yY(long paramLong)
  {
    this.gYc = paramLong;
    return this;
  }
  
  public final nd yZ(long paramLong)
  {
    this.gYf = paramLong;
    return this;
  }
  
  public final nd za(long paramLong)
  {
    this.gwA = paramLong;
    return this;
  }
  
  public final nd zb(long paramLong)
  {
    this.gYg = paramLong;
    return this;
  }
  
  public final nd zc(long paramLong)
  {
    AppMethodBeat.i(233049);
    this.gYh = paramLong;
    super.bk("RemuxVideoTimeMs", this.gYh);
    AppMethodBeat.o(233049);
    return this;
  }
  
  public final nd zd(long paramLong)
  {
    AppMethodBeat.i(233050);
    this.gYk = paramLong;
    super.bk("UpdateCompositionTimeMs", this.gYk);
    AppMethodBeat.o(233050);
    return this;
  }
  
  public final nd ze(long paramLong)
  {
    this.gYn = paramLong;
    return this;
  }
  
  public final nd zf(long paramLong)
  {
    this.gYo = paramLong;
    return this;
  }
  
  public final nd zg(long paramLong)
  {
    this.gYr = paramLong;
    return this;
  }
  
  public final nd zh(long paramLong)
  {
    this.gYs = paramLong;
    return this;
  }
  
  public final nd zi(long paramLong)
  {
    this.gYt = paramLong;
    return this;
  }
  
  public final nd zj(long paramLong)
  {
    this.gYv = paramLong;
    return this;
  }
  
  public final nd zk(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nd
 * JD-Core Version:    0.7.0.1
 */