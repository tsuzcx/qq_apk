package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ho
  extends a
{
  private String dSb;
  private int dSg;
  private String dTd;
  private String dWV;
  private long esD;
  private long esE;
  private String esF;
  private String esG;
  private int esH;
  private int esI;
  private String esJ;
  private String esK;
  private int esL;
  
  public final String RD()
  {
    AppMethodBeat.i(210172);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esL);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(210172);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(210173);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.dWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.esD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.esE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.esF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.esG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.esH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.esI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.esJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.esK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.esL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210173);
    return localObject;
  }
  
  public final String UD()
  {
    return this.dWV;
  }
  
  public final long UE()
  {
    return this.esD;
  }
  
  public final long UF()
  {
    return this.esE;
  }
  
  public final String UG()
  {
    return this.esF;
  }
  
  public final String UH()
  {
    return this.esG;
  }
  
  public final int UI()
  {
    return this.esH;
  }
  
  public final int UJ()
  {
    return this.esI;
  }
  
  public final String UK()
  {
    return this.esJ;
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
  
  public final int getId()
  {
    return 19945;
  }
  
  public final int getScene()
  {
    return this.dSg;
  }
  
  public final String getSessionId()
  {
    return this.dSb;
  }
  
  public final ho iP(int paramInt)
  {
    this.dSg = paramInt;
    return this;
  }
  
  public final ho iQ(int paramInt)
  {
    this.esH = paramInt;
    return this;
  }
  
  public final ho iR(int paramInt)
  {
    this.esI = paramInt;
    return this;
  }
  
  public final ho iS(int paramInt)
  {
    this.esL = paramInt;
    return this;
  }
  
  public final ho mZ(long paramLong)
  {
    AppMethodBeat.i(210165);
    this.esD = paramLong;
    super.bf("UpdataTimeMs", this.esD);
    AppMethodBeat.o(210165);
    return this;
  }
  
  public final ho na(long paramLong)
  {
    AppMethodBeat.i(210166);
    this.esE = paramLong;
    super.bf("ClickTimeMs", this.esE);
    AppMethodBeat.o(210166);
    return this;
  }
  
  public final ho qi(String paramString)
  {
    AppMethodBeat.i(210163);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(210163);
    return this;
  }
  
  public final ho qj(String paramString)
  {
    AppMethodBeat.i(210164);
    this.dWV = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(210164);
    return this;
  }
  
  public final ho qk(String paramString)
  {
    AppMethodBeat.i(210167);
    this.esF = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(210167);
    return this;
  }
  
  public final ho ql(String paramString)
  {
    AppMethodBeat.i(210168);
    this.esG = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(210168);
    return this;
  }
  
  public final ho qm(String paramString)
  {
    AppMethodBeat.i(210169);
    this.esJ = t("ShotScreenJson", paramString, true);
    AppMethodBeat.o(210169);
    return this;
  }
  
  public final ho qn(String paramString)
  {
    AppMethodBeat.i(210170);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(210170);
    return this;
  }
  
  public final ho qo(String paramString)
  {
    AppMethodBeat.i(210171);
    this.esK = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(210171);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ho
 * JD-Core Version:    0.7.0.1
 */