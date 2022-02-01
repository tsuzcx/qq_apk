package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  private String dTr = "";
  private int dTw;
  private String dUt = "";
  private String dYn = "";
  private long euk;
  private long eul;
  private String eum = "";
  private String eun = "";
  private int euo;
  private int eup;
  private String euq = "";
  private String eur = "";
  private int eus;
  
  public final String RC()
  {
    AppMethodBeat.i(195812);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eul);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eum);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eun);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eup);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eur);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eus);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(195812);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(195813);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.dYn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.euk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.eul);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.eum);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.eun);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.euo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.eup);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.euq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.eur);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.eus);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195813);
    return localObject;
  }
  
  public final String UJ()
  {
    return this.dYn;
  }
  
  public final long UK()
  {
    return this.euk;
  }
  
  public final long UL()
  {
    return this.eul;
  }
  
  public final String UM()
  {
    return this.eum;
  }
  
  public final String UN()
  {
    return this.eun;
  }
  
  public final int UO()
  {
    return this.euo;
  }
  
  public final int UP()
  {
    return this.eup;
  }
  
  public final String UQ()
  {
    return this.euq;
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
  
  public final int getId()
  {
    return 19945;
  }
  
  public final int getScene()
  {
    return this.dTw;
  }
  
  public final String getSessionId()
  {
    return this.dTr;
  }
  
  public final hq iR(int paramInt)
  {
    this.dTw = paramInt;
    return this;
  }
  
  public final hq iS(int paramInt)
  {
    this.euo = paramInt;
    return this;
  }
  
  public final hq iT(int paramInt)
  {
    this.eup = paramInt;
    return this;
  }
  
  public final hq iU(int paramInt)
  {
    this.eus = paramInt;
    return this;
  }
  
  public final hq nl(long paramLong)
  {
    AppMethodBeat.i(195805);
    this.euk = paramLong;
    super.bg("UpdataTimeMs", this.euk);
    AppMethodBeat.o(195805);
    return this;
  }
  
  public final hq nm(long paramLong)
  {
    AppMethodBeat.i(195806);
    this.eul = paramLong;
    super.bg("ClickTimeMs", this.eul);
    AppMethodBeat.o(195806);
    return this;
  }
  
  public final hq qD(String paramString)
  {
    AppMethodBeat.i(195803);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(195803);
    return this;
  }
  
  public final hq qE(String paramString)
  {
    AppMethodBeat.i(195804);
    this.dYn = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(195804);
    return this;
  }
  
  public final hq qF(String paramString)
  {
    AppMethodBeat.i(195807);
    this.eum = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195807);
    return this;
  }
  
  public final hq qG(String paramString)
  {
    AppMethodBeat.i(195808);
    this.eun = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195808);
    return this;
  }
  
  public final hq qH(String paramString)
  {
    AppMethodBeat.i(195809);
    this.euq = t("ShotScreenJson", paramString, true);
    AppMethodBeat.o(195809);
    return this;
  }
  
  public final hq qI(String paramString)
  {
    AppMethodBeat.i(195810);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(195810);
    return this;
  }
  
  public final hq qJ(String paramString)
  {
    AppMethodBeat.i(195811);
    this.eur = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(195811);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hq
 * JD-Core Version:    0.7.0.1
 */