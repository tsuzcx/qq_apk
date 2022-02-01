package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gl
  extends a
{
  private String dFY;
  private String dFe;
  private int dHw;
  private String dJm;
  private long ebY;
  private long ebZ;
  private String eca;
  private String ecb;
  private int ecc;
  private int ecd;
  private String ece;
  private String ecf;
  private int ecg;
  
  public final String PR()
  {
    AppMethodBeat.i(195185);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ece);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195185);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.dJm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.ebY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.ebZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.ecb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.ecc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.ecd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.ece);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.ecg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195186);
    return localObject;
  }
  
  public final String Sp()
  {
    return this.dJm;
  }
  
  public final long Sq()
  {
    return this.ebY;
  }
  
  public final long Sr()
  {
    return this.ebZ;
  }
  
  public final String Ss()
  {
    return this.eca;
  }
  
  public final String St()
  {
    return this.ecb;
  }
  
  public final int Su()
  {
    return this.ecc;
  }
  
  public final int Sv()
  {
    return this.ecd;
  }
  
  public final String Sw()
  {
    return this.ece;
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
    return 19945;
  }
  
  public final int getScene()
  {
    return this.dHw;
  }
  
  public final String getSessionId()
  {
    return this.dFe;
  }
  
  public final gl iw(int paramInt)
  {
    this.dHw = paramInt;
    return this;
  }
  
  public final gl ix(int paramInt)
  {
    this.ecc = paramInt;
    return this;
  }
  
  public final gl iy(int paramInt)
  {
    this.ecd = paramInt;
    return this;
  }
  
  public final gl iz(int paramInt)
  {
    this.ecg = paramInt;
    return this;
  }
  
  public final gl lf(long paramLong)
  {
    AppMethodBeat.i(195178);
    this.ebY = paramLong;
    super.bc("UpdataTimeMs", this.ebY);
    AppMethodBeat.o(195178);
    return this;
  }
  
  public final gl lg(long paramLong)
  {
    AppMethodBeat.i(195179);
    this.ebZ = paramLong;
    super.bc("ClickTimeMs", this.ebZ);
    AppMethodBeat.o(195179);
    return this;
  }
  
  public final gl nJ(String paramString)
  {
    AppMethodBeat.i(195176);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195176);
    return this;
  }
  
  public final gl nK(String paramString)
  {
    AppMethodBeat.i(195177);
    this.dJm = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(195177);
    return this;
  }
  
  public final gl nL(String paramString)
  {
    AppMethodBeat.i(195180);
    this.eca = t("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195180);
    return this;
  }
  
  public final gl nM(String paramString)
  {
    AppMethodBeat.i(195181);
    this.ecb = t("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(195181);
    return this;
  }
  
  public final gl nN(String paramString)
  {
    AppMethodBeat.i(195182);
    this.ece = t("ShotScreenJson", paramString, true);
    AppMethodBeat.o(195182);
    return this;
  }
  
  public final gl nO(String paramString)
  {
    AppMethodBeat.i(195183);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(195183);
    return this;
  }
  
  public final gl nP(String paramString)
  {
    AppMethodBeat.i(195184);
    this.ecf = t("ItemBufffer", paramString, true);
    AppMethodBeat.o(195184);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gl
 * JD-Core Version:    0.7.0.1
 */