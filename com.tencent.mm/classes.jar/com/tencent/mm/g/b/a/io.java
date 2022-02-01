package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class io
  extends a
{
  private String dHr;
  private String dJL;
  private int dJu;
  private String dLe;
  private String pGB;
  private String pGC;
  private String pGG;
  private long pGz;
  private int qdj;
  private long qeJ;
  private long qmW;
  private int qnd = -1;
  private long qnk;
  private int qno;
  
  public final io AV(int paramInt)
  {
    this.qnd = paramInt;
    return this;
  }
  
  public final io AX(long paramLong)
  {
    this.qeJ = paramLong;
    return this;
  }
  
  public final io AY(long paramLong)
  {
    this.qmW = paramLong;
    return this;
  }
  
  public final io AZ(long paramLong)
  {
    AppMethodBeat.i(205359);
    this.pGz = paramLong;
    super.ba("UpdataTimeMs", this.pGz);
    AppMethodBeat.o(205359);
    return this;
  }
  
  public final io Ba(long paramLong)
  {
    AppMethodBeat.i(205360);
    this.qnk = paramLong;
    super.ba("ItemExposureTimeMs", this.qnk);
    AppMethodBeat.o(205360);
    return this;
  }
  
  public final io Bu(int paramInt)
  {
    this.dJu = paramInt;
    return this;
  }
  
  public final io Bv(int paramInt)
  {
    this.qno = paramInt;
    return this;
  }
  
  public final io Bw(int paramInt)
  {
    this.qdj = paramInt;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(205362);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qeJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qmW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qnd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qnk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qdj);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(205362);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(205363);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.qeJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.qmW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.qnd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.pGB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.pGC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.pGz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.qnk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.qno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.pGG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.qdj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(205363);
    return localObject;
  }
  
  public final io aTL(String paramString)
  {
    AppMethodBeat.i(205354);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(205354);
    return this;
  }
  
  public final io aTM(String paramString)
  {
    AppMethodBeat.i(205355);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(205355);
    return this;
  }
  
  public final io aTN(String paramString)
  {
    AppMethodBeat.i(205356);
    this.pGB = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(205356);
    return this;
  }
  
  public final io aTO(String paramString)
  {
    AppMethodBeat.i(205357);
    this.pGC = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(205357);
    return this;
  }
  
  public final io aTP(String paramString)
  {
    AppMethodBeat.i(205358);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(205358);
    return this;
  }
  
  public final io aTQ(String paramString)
  {
    AppMethodBeat.i(205361);
    this.pGG = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(205361);
    return this;
  }
  
  public final String bQT()
  {
    return this.dLe;
  }
  
  public final String bUo()
  {
    return this.pGG;
  }
  
  public final int bYB()
  {
    return this.qdj;
  }
  
  public final String bYE()
  {
    return this.dJL;
  }
  
  public final long bYF()
  {
    return this.qeJ;
  }
  
  public final long bYQ()
  {
    return this.qmW;
  }
  
  public final long btd()
  {
    return this.pGz;
  }
  
  public final String btf()
  {
    return this.pGB;
  }
  
  public final String btg()
  {
    return this.pGC;
  }
  
  public final int cci()
  {
    return this.qnd;
  }
  
  public final long ccj()
  {
    return this.qnk;
  }
  
  public final int cck()
  {
    return this.qno;
  }
  
  public final int getId()
  {
    return 19944;
  }
  
  public final int getScene()
  {
    return this.dJu;
  }
  
  public final String getSessionId()
  {
    return this.dHr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.io
 * JD-Core Version:    0.7.0.1
 */