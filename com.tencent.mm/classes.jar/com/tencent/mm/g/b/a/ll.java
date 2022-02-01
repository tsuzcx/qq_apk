package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ll
  extends a
{
  private long eYH;
  private long eYI;
  private String eYJ = "";
  private String eYK = "";
  private int eYL;
  private int eYM;
  private String eYN = "";
  private String eYO = "";
  private int eYP;
  private String eiB = "";
  private int enq;
  private String eoz = "";
  private String eug = "";
  
  public final String abV()
  {
    AppMethodBeat.i(220232);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eug);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220232);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220233);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.eug);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.eYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.eYI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.eYJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.eYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.eYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.eYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.eYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.eYO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.eYP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220233);
    return localObject;
  }
  
  public final String acj()
  {
    return this.eoz;
  }
  
  public final String aiC()
  {
    return this.eug;
  }
  
  public final long aiD()
  {
    return this.eYH;
  }
  
  public final long aiE()
  {
    return this.eYI;
  }
  
  public final String aiF()
  {
    return this.eYJ;
  }
  
  public final String aiG()
  {
    return this.eYK;
  }
  
  public final int aiH()
  {
    return this.eYL;
  }
  
  public final int aiI()
  {
    return this.eYM;
  }
  
  public final String aiJ()
  {
    return this.eYN;
  }
  
  public final String aiK()
  {
    return this.eYO;
  }
  
  public final int aiL()
  {
    return this.eYP;
  }
  
  public final int getId()
  {
    return 19945;
  }
  
  public final int getScene()
  {
    return this.enq;
  }
  
  public final String getSessionId()
  {
    return this.eiB;
  }
  
  public final ll lT(int paramInt)
  {
    this.enq = paramInt;
    return this;
  }
  
  public final ll lU(int paramInt)
  {
    this.eYL = paramInt;
    return this;
  }
  
  public final ll lV(int paramInt)
  {
    this.eYM = paramInt;
    return this;
  }
  
  public final ll lW(int paramInt)
  {
    this.eYP = paramInt;
    return this;
  }
  
  public final ll uV(long paramLong)
  {
    AppMethodBeat.i(220225);
    this.eYH = paramLong;
    super.bi("UpdataTimeMs", this.eYH);
    AppMethodBeat.o(220225);
    return this;
  }
  
  public final ll uW(long paramLong)
  {
    AppMethodBeat.i(220226);
    this.eYI = paramLong;
    super.bi("ClickTimeMs", this.eYI);
    AppMethodBeat.o(220226);
    return this;
  }
  
  public final ll yG(String paramString)
  {
    AppMethodBeat.i(220223);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(220223);
    return this;
  }
  
  public final ll yH(String paramString)
  {
    AppMethodBeat.i(220224);
    this.eug = x("ClickFeedId", paramString, true);
    AppMethodBeat.o(220224);
    return this;
  }
  
  public final ll yI(String paramString)
  {
    AppMethodBeat.i(220227);
    this.eYJ = x("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(220227);
    return this;
  }
  
  public final ll yJ(String paramString)
  {
    AppMethodBeat.i(220228);
    this.eYK = x("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(220228);
    return this;
  }
  
  public final ll yK(String paramString)
  {
    AppMethodBeat.i(220229);
    this.eYN = x("ShotScreenJson", paramString, true);
    AppMethodBeat.o(220229);
    return this;
  }
  
  public final ll yL(String paramString)
  {
    AppMethodBeat.i(220230);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(220230);
    return this;
  }
  
  public final ll yM(String paramString)
  {
    AppMethodBeat.i(220231);
    this.eYO = x("ItemBufffer", paramString, true);
    AppMethodBeat.o(220231);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ll
 * JD-Core Version:    0.7.0.1
 */