package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class in
  extends a
{
  private String dHr;
  private int dJu;
  private String dLe;
  private String iRQ;
  private long pGA;
  private String pGB;
  private String pGC;
  private int pGD;
  private int pGE;
  private String pGF;
  private String pGG;
  private long pGz;
  private int qdj;
  
  public final in AV(long paramLong)
  {
    AppMethodBeat.i(205345);
    this.pGz = paramLong;
    super.ba("UpdataTimeMs", this.pGz);
    AppMethodBeat.o(205345);
    return this;
  }
  
  public final in AW(long paramLong)
  {
    AppMethodBeat.i(205346);
    this.pGA = paramLong;
    super.ba("ClickTimeMs", this.pGA);
    AppMethodBeat.o(205346);
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(205352);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.qdj);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(205352);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(205353);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.iRQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.pGz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.pGA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.pGB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.pGC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.pGD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.pGE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.pGF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.pGG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.qdj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(205353);
    return localObject;
  }
  
  public final in aTE(String paramString)
  {
    AppMethodBeat.i(205343);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(205343);
    return this;
  }
  
  public final in aTF(String paramString)
  {
    AppMethodBeat.i(205344);
    this.iRQ = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(205344);
    return this;
  }
  
  public final in aTG(String paramString)
  {
    AppMethodBeat.i(205347);
    this.pGB = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(205347);
    return this;
  }
  
  public final in aTH(String paramString)
  {
    AppMethodBeat.i(205348);
    this.pGC = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(205348);
    return this;
  }
  
  public final in aTI(String paramString)
  {
    AppMethodBeat.i(205349);
    this.pGF = t("ShotScreenJson", paramString, true);
    AppMethodBeat.o(205349);
    return this;
  }
  
  public final in aTJ(String paramString)
  {
    AppMethodBeat.i(205350);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(205350);
    return this;
  }
  
  public final in aTK(String paramString)
  {
    AppMethodBeat.i(205351);
    this.pGG = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(205351);
    return this;
  }
  
  public final String bMv()
  {
    return this.pGF;
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
  
  public final String btc()
  {
    return this.iRQ;
  }
  
  public final long btd()
  {
    return this.pGz;
  }
  
  public final long bte()
  {
    return this.pGA;
  }
  
  public final String btf()
  {
    return this.pGB;
  }
  
  public final String btg()
  {
    return this.pGC;
  }
  
  public final int bul()
  {
    return this.pGD;
  }
  
  public final int bum()
  {
    return this.pGE;
  }
  
  public final int getId()
  {
    return 19945;
  }
  
  public final int getScene()
  {
    return this.dJu;
  }
  
  public final String getSessionId()
  {
    return this.dHr;
  }
  
  public final in uN(int paramInt)
  {
    this.dJu = paramInt;
    return this;
  }
  
  public final in uO(int paramInt)
  {
    this.pGD = paramInt;
    return this;
  }
  
  public final in uP(int paramInt)
  {
    this.pGE = paramInt;
    return this;
  }
  
  public final in xK(int paramInt)
  {
    this.qdj = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.in
 * JD-Core Version:    0.7.0.1
 */