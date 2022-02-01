package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gm
  extends a
{
  private String dFY;
  private String dFe;
  private String dHM;
  private int dHw;
  private long ebY;
  private String eca;
  private String ecb;
  private String ecf;
  private int ecg;
  private long ech;
  private long eci;
  private int ecj = -1;
  private long eck;
  private int ecl;
  
  public final String PR()
  {
    AppMethodBeat.i(195195);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ech);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eci);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eck);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195195);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195196);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposureMs:").append(this.ech);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposureMs:").append(this.eci);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisAppearType:").append(this.ecj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.ecb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.ebY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureTimeMs:").append(this.eck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemPos:").append(this.ecl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.ecg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195196);
    return localObject;
  }
  
  public final String SA()
  {
    return this.dHM;
  }
  
  public final long SB()
  {
    return this.ech;
  }
  
  public final long SC()
  {
    return this.eci;
  }
  
  public final int SD()
  {
    return this.ecj;
  }
  
  public final long SE()
  {
    return this.eck;
  }
  
  public final int SF()
  {
    return this.ecl;
  }
  
  public final long Sq()
  {
    return this.ebY;
  }
  
  public final String Ss()
  {
    return this.eca;
  }
  
  public final String St()
  {
    return this.ecb;
  }
  
  public final String Sx()
  {
    return this.dFY;
  }
  
  public final String Sy()
  {
    return this.ecf;
  }
  
  public final int Sz()
  {
    return this.ecg;
  }
  
  public final int getId()
  {
    return 19944;
  }
  
  public final int getScene()
  {
    return this.dHw;
  }
  
  public final String getSessionId()
  {
    return this.dFe;
  }
  
  public final gm iA(int paramInt)
  {
    this.ecj = paramInt;
    return this;
  }
  
  public final gm iB(int paramInt)
  {
    this.dHw = paramInt;
    return this;
  }
  
  public final gm iC(int paramInt)
  {
    this.ecl = paramInt;
    return this;
  }
  
  public final gm iD(int paramInt)
  {
    this.ecg = paramInt;
    return this;
  }
  
  public final gm lh(long paramLong)
  {
    this.ech = paramLong;
    return this;
  }
  
  public final gm li(long paramLong)
  {
    this.eci = paramLong;
    return this;
  }
  
  public final gm lj(long paramLong)
  {
    AppMethodBeat.i(195192);
    this.ebY = paramLong;
    super.bc("UpdataTimeMs", this.ebY);
    AppMethodBeat.o(195192);
    return this;
  }
  
  public final gm lk(long paramLong)
  {
    AppMethodBeat.i(195193);
    this.eck = paramLong;
    super.bc("ItemExposureTimeMs", this.eck);
    AppMethodBeat.o(195193);
    return this;
  }
  
  public final gm nQ(String paramString)
  {
    AppMethodBeat.i(195187);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195187);
    return this;
  }
  
  public final gm nR(String paramString)
  {
    AppMethodBeat.i(195188);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(195188);
    return this;
  }
  
  public final gm nS(String paramString)
  {
    AppMethodBeat.i(195189);
    this.eca = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195189);
    return this;
  }
  
  public final gm nT(String paramString)
  {
    AppMethodBeat.i(195190);
    this.ecb = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195190);
    return this;
  }
  
  public final gm nU(String paramString)
  {
    AppMethodBeat.i(195191);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(195191);
    return this;
  }
  
  public final gm nV(String paramString)
  {
    AppMethodBeat.i(195194);
    this.ecf = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(195194);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gm
 * JD-Core Version:    0.7.0.1
 */