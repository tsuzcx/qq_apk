package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hp
  extends a
{
  private String dSb;
  private int dSg;
  private String dTd;
  private String dUR;
  private long esD;
  private String esF;
  private String esG;
  private String esK;
  private int esL;
  private long esM;
  private long esN;
  private int esO = -1;
  private long esP;
  private int esQ;
  
  public final String RD()
  {
    AppMethodBeat.i(210182);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(210182);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(210183);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.esM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.esN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.esO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.esF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.esG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.esD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.esP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.esQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.esK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.esL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210183);
    return localObject;
  }
  
  public final long UE()
  {
    return this.esD;
  }
  
  public final String UG()
  {
    return this.esF;
  }
  
  public final String UH()
  {
    return this.esG;
  }
  
  public final String UL()
  {
    return this.dTd;
  }
  
  public final String UM()
  {
    return this.esK;
  }
  
  public final int UN()
  {
    return this.esL;
  }
  
  public final String UO()
  {
    return this.dUR;
  }
  
  public final long UP()
  {
    return this.esM;
  }
  
  public final long UQ()
  {
    return this.esN;
  }
  
  public final int UR()
  {
    return this.esO;
  }
  
  public final long US()
  {
    return this.esP;
  }
  
  public final int UT()
  {
    return this.esQ;
  }
  
  public final int getId()
  {
    return 19944;
  }
  
  public final int getScene()
  {
    return this.dSg;
  }
  
  public final String getSessionId()
  {
    return this.dSb;
  }
  
  public final hp iT(int paramInt)
  {
    this.esO = paramInt;
    return this;
  }
  
  public final hp iU(int paramInt)
  {
    this.dSg = paramInt;
    return this;
  }
  
  public final hp iV(int paramInt)
  {
    this.esQ = paramInt;
    return this;
  }
  
  public final hp iW(int paramInt)
  {
    this.esL = paramInt;
    return this;
  }
  
  public final hp nb(long paramLong)
  {
    this.esM = paramLong;
    return this;
  }
  
  public final hp nc(long paramLong)
  {
    this.esN = paramLong;
    return this;
  }
  
  public final hp nd(long paramLong)
  {
    AppMethodBeat.i(210179);
    this.esD = paramLong;
    super.bf("UpdataTimeMs", this.esD);
    AppMethodBeat.o(210179);
    return this;
  }
  
  public final hp ne(long paramLong)
  {
    AppMethodBeat.i(210180);
    this.esP = paramLong;
    super.bf("ItemExposureTimeMs", this.esP);
    AppMethodBeat.o(210180);
    return this;
  }
  
  public final hp qp(String paramString)
  {
    AppMethodBeat.i(210174);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(210174);
    return this;
  }
  
  public final hp qq(String paramString)
  {
    AppMethodBeat.i(210175);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(210175);
    return this;
  }
  
  public final hp qr(String paramString)
  {
    AppMethodBeat.i(210176);
    this.esF = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(210176);
    return this;
  }
  
  public final hp qs(String paramString)
  {
    AppMethodBeat.i(210177);
    this.esG = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(210177);
    return this;
  }
  
  public final hp qt(String paramString)
  {
    AppMethodBeat.i(210178);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(210178);
    return this;
  }
  
  public final hp qu(String paramString)
  {
    AppMethodBeat.i(210181);
    this.esK = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(210181);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hp
 * JD-Core Version:    0.7.0.1
 */