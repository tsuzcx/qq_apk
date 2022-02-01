package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lm
  extends a
{
  private long eYH;
  private String eYJ = "";
  private String eYK = "";
  private String eYO = "";
  private int eYP;
  private long eYQ;
  private long eYR;
  private int eYS = -1;
  private long eYT;
  private int eYU;
  private String eiB = "";
  private int enq;
  private String eoz = "";
  private String err = "";
  
  public final String abV()
  {
    AppMethodBeat.i(220242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220242);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.eYQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.eYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.eYS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.eYJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.eYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.eYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.eYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.eYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.eYO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.eYP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220243);
    return localObject;
  }
  
  public final String acj()
  {
    return this.eoz;
  }
  
  public final String adk()
  {
    return this.err;
  }
  
  public final long aiD()
  {
    return this.eYH;
  }
  
  public final String aiF()
  {
    return this.eYJ;
  }
  
  public final String aiG()
  {
    return this.eYK;
  }
  
  public final String aiK()
  {
    return this.eYO;
  }
  
  public final int aiL()
  {
    return this.eYP;
  }
  
  public final long aiM()
  {
    return this.eYQ;
  }
  
  public final long aiN()
  {
    return this.eYR;
  }
  
  public final int aiO()
  {
    return this.eYS;
  }
  
  public final long aiP()
  {
    return this.eYT;
  }
  
  public final int aiQ()
  {
    return this.eYU;
  }
  
  public final int getId()
  {
    return 19944;
  }
  
  public final int getScene()
  {
    return this.enq;
  }
  
  public final String getSessionId()
  {
    return this.eiB;
  }
  
  public final lm lX(int paramInt)
  {
    this.eYS = paramInt;
    return this;
  }
  
  public final lm lY(int paramInt)
  {
    this.enq = paramInt;
    return this;
  }
  
  public final lm lZ(int paramInt)
  {
    this.eYU = paramInt;
    return this;
  }
  
  public final lm ma(int paramInt)
  {
    this.eYP = paramInt;
    return this;
  }
  
  public final lm uX(long paramLong)
  {
    this.eYQ = paramLong;
    return this;
  }
  
  public final lm uY(long paramLong)
  {
    this.eYR = paramLong;
    return this;
  }
  
  public final lm uZ(long paramLong)
  {
    AppMethodBeat.i(220239);
    this.eYH = paramLong;
    super.bi("UpdataTimeMs", this.eYH);
    AppMethodBeat.o(220239);
    return this;
  }
  
  public final lm va(long paramLong)
  {
    AppMethodBeat.i(220240);
    this.eYT = paramLong;
    super.bi("ItemExposureTimeMs", this.eYT);
    AppMethodBeat.o(220240);
    return this;
  }
  
  public final lm yN(String paramString)
  {
    AppMethodBeat.i(220234);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(220234);
    return this;
  }
  
  public final lm yO(String paramString)
  {
    AppMethodBeat.i(220235);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(220235);
    return this;
  }
  
  public final lm yP(String paramString)
  {
    AppMethodBeat.i(220236);
    this.eYJ = x("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(220236);
    return this;
  }
  
  public final lm yQ(String paramString)
  {
    AppMethodBeat.i(220237);
    this.eYK = x("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(220237);
    return this;
  }
  
  public final lm yR(String paramString)
  {
    AppMethodBeat.i(220238);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(220238);
    return this;
  }
  
  public final lm yS(String paramString)
  {
    AppMethodBeat.i(220241);
    this.eYO = x("ItemBufffer", paramString, true);
    AppMethodBeat.o(220241);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lm
 * JD-Core Version:    0.7.0.1
 */