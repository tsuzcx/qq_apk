package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hr
  extends a
{
  private String dTr = "";
  private int dTw;
  private String dUt = "";
  private String dWh = "";
  private long euk;
  private String eum = "";
  private String eun = "";
  private String eur = "";
  private int eus;
  private long eut;
  private long euu;
  private int euv = -1;
  private long euw;
  private int eux;
  
  public final String RC()
  {
    AppMethodBeat.i(195822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eut);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eum);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eun);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eux);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eur);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eus);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(195822);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(195823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.eut);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.euu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.euv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.eum);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.eun);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.euk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.euw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.eux);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.eur);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.eus);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195823);
    return localObject;
  }
  
  public final long UK()
  {
    return this.euk;
  }
  
  public final String UM()
  {
    return this.eum;
  }
  
  public final String UN()
  {
    return this.eun;
  }
  
  public final String UR()
  {
    return this.dUt;
  }
  
  public final String US()
  {
    return this.eur;
  }
  
  public final int UT()
  {
    return this.eus;
  }
  
  public final String UU()
  {
    return this.dWh;
  }
  
  public final long UV()
  {
    return this.eut;
  }
  
  public final long UW()
  {
    return this.euu;
  }
  
  public final int UX()
  {
    return this.euv;
  }
  
  public final long UY()
  {
    return this.euw;
  }
  
  public final int UZ()
  {
    return this.eux;
  }
  
  public final int getId()
  {
    return 19944;
  }
  
  public final int getScene()
  {
    return this.dTw;
  }
  
  public final String getSessionId()
  {
    return this.dTr;
  }
  
  public final hr iV(int paramInt)
  {
    this.euv = paramInt;
    return this;
  }
  
  public final hr iW(int paramInt)
  {
    this.dTw = paramInt;
    return this;
  }
  
  public final hr iX(int paramInt)
  {
    this.eux = paramInt;
    return this;
  }
  
  public final hr iY(int paramInt)
  {
    this.eus = paramInt;
    return this;
  }
  
  public final hr nn(long paramLong)
  {
    this.eut = paramLong;
    return this;
  }
  
  public final hr no(long paramLong)
  {
    this.euu = paramLong;
    return this;
  }
  
  public final hr np(long paramLong)
  {
    AppMethodBeat.i(195819);
    this.euk = paramLong;
    super.bg("UpdataTimeMs", this.euk);
    AppMethodBeat.o(195819);
    return this;
  }
  
  public final hr nq(long paramLong)
  {
    AppMethodBeat.i(195820);
    this.euw = paramLong;
    super.bg("ItemExposureTimeMs", this.euw);
    AppMethodBeat.o(195820);
    return this;
  }
  
  public final hr qK(String paramString)
  {
    AppMethodBeat.i(195814);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(195814);
    return this;
  }
  
  public final hr qL(String paramString)
  {
    AppMethodBeat.i(195815);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(195815);
    return this;
  }
  
  public final hr qM(String paramString)
  {
    AppMethodBeat.i(195816);
    this.eum = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195816);
    return this;
  }
  
  public final hr qN(String paramString)
  {
    AppMethodBeat.i(195817);
    this.eun = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195817);
    return this;
  }
  
  public final hr qO(String paramString)
  {
    AppMethodBeat.i(195818);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(195818);
    return this;
  }
  
  public final hr qP(String paramString)
  {
    AppMethodBeat.i(195821);
    this.eur = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(195821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hr
 * JD-Core Version:    0.7.0.1
 */