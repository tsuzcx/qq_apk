package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class de
  extends a
{
  private long giq;
  private String gmO = "";
  private String gnE = "";
  private long gnz;
  private String gpU = "";
  private String gpV = "";
  private int gpW;
  private String gpX = "";
  private long gpY;
  private long grE;
  private String gsw = "";
  private String gsx = "";
  private long gsy;
  private long gsz;
  
  public final String agH()
  {
    AppMethodBeat.i(256608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsz);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(256608);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(256610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.gpU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.gpV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.gpW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.gpX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.gpY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveId:").append(this.gsw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Description:").append(this.gsx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveTime:").append(this.gnz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCount:").append(this.grE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnlineCount:").append(this.gsy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.gnE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.gsz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(256610);
    return localObject;
  }
  
  public final String ahA()
  {
    return this.gpX;
  }
  
  public final long ahB()
  {
    return this.gpY;
  }
  
  public final long ahC()
  {
    return this.giq;
  }
  
  public final String ahY()
  {
    return this.gsw;
  }
  
  public final String ahZ()
  {
    return this.gmO;
  }
  
  public final long ahc()
  {
    return this.gnz;
  }
  
  public final String ahi()
  {
    return this.gnE;
  }
  
  public final String ahx()
  {
    return this.gpU;
  }
  
  public final String ahy()
  {
    return this.gpV;
  }
  
  public final int ahz()
  {
    return this.gpW;
  }
  
  public final long aia()
  {
    return this.grE;
  }
  
  public final long aib()
  {
    return this.gsy;
  }
  
  public final long aic()
  {
    return this.gsz;
  }
  
  public final String getDescription()
  {
    return this.gsx;
  }
  
  public final int getId()
  {
    return 21054;
  }
  
  public final de hB(long paramLong)
  {
    AppMethodBeat.i(256579);
    this.gpY = paramLong;
    super.bk("ActionTimeMs", this.gpY);
    AppMethodBeat.o(256579);
    return this;
  }
  
  public final de hC(long paramLong)
  {
    this.gnz = paramLong;
    return this;
  }
  
  public final de hD(long paramLong)
  {
    this.grE = paramLong;
    return this;
  }
  
  public final de hE(long paramLong)
  {
    this.gsy = paramLong;
    return this;
  }
  
  public final de hF(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final de hG(long paramLong)
  {
    this.gsz = paramLong;
    return this;
  }
  
  public final de ly(int paramInt)
  {
    this.gpW = paramInt;
    return this;
  }
  
  public final de oQ(String paramString)
  {
    AppMethodBeat.i(256573);
    this.gpU = z("FinderUsrname", paramString, true);
    AppMethodBeat.o(256573);
    return this;
  }
  
  public final de oR(String paramString)
  {
    AppMethodBeat.i(256575);
    this.gpV = z("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(256575);
    return this;
  }
  
  public final de oS(String paramString)
  {
    AppMethodBeat.i(256577);
    this.gpX = z("FinderSessionId", paramString, true);
    AppMethodBeat.o(256577);
    return this;
  }
  
  public final de oT(String paramString)
  {
    AppMethodBeat.i(256583);
    this.gsw = z("LiveId", paramString, true);
    AppMethodBeat.o(256583);
    return this;
  }
  
  public final de oU(String paramString)
  {
    AppMethodBeat.i(256586);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(256586);
    return this;
  }
  
  public final de oV(String paramString)
  {
    AppMethodBeat.i(256590);
    this.gsx = z("Description", paramString, true);
    AppMethodBeat.o(256590);
    return this;
  }
  
  public final de oW(String paramString)
  {
    AppMethodBeat.i(256603);
    this.gnE = z("ActionResult", paramString, true);
    AppMethodBeat.o(256603);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.de
 * JD-Core Version:    0.7.0.1
 */