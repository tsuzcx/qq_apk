package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bp
  extends a
{
  private String dXk;
  private long dZT;
  private long dZW;
  private String dZX;
  private String dZY;
  private String dZZ;
  private long eaa;
  private long eab;
  private String eac;
  private String ead;
  private long eae;
  private String eaf;
  private String eag;
  private long eah;
  private long eai;
  private long eaj;
  private String eak;
  private long eal;
  private String eam;
  private long ean;
  
  public final String RD()
  {
    AppMethodBeat.i(209223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eab);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eac);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ead);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eae);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eah);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eak);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eal);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eam);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ean);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209223);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.dZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoPath:").append(this.dZY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoParentPath:").append(this.dZZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.eaa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoCountNum:").append(this.eab);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoTitle:").append(this.eac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoExt:").append(this.ead);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotAction:").append(this.eae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.eaf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.dXk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextID:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.eah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsTriggerByUser:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnverVersion:").append(this.eaj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eak);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecTimeStamp:").append(this.eal);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoIconUrl:").append(this.eam);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.ean);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209224);
    return localObject;
  }
  
  public final bp Su()
  {
    this.eaj = 1L;
    return this;
  }
  
  public final bp ge(long paramLong)
  {
    this.dZW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20411;
  }
  
  public final bp gf(long paramLong)
  {
    this.eaa = paramLong;
    return this;
  }
  
  public final bp gg(long paramLong)
  {
    this.eab = paramLong;
    return this;
  }
  
  public final bp gh(long paramLong)
  {
    this.eae = paramLong;
    return this;
  }
  
  public final bp gi(long paramLong)
  {
    this.dZT = paramLong;
    return this;
  }
  
  public final bp gj(long paramLong)
  {
    this.eah = paramLong;
    return this;
  }
  
  public final bp gk(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final bp gl(long paramLong)
  {
    this.eal = paramLong;
    return this;
  }
  
  public final bp gm(long paramLong)
  {
    this.ean = paramLong;
    return this;
  }
  
  public final bp kq(String paramString)
  {
    AppMethodBeat.i(209213);
    this.dZX = t("RedDotTipsID", paramString, true);
    AppMethodBeat.o(209213);
    return this;
  }
  
  public final bp kr(String paramString)
  {
    AppMethodBeat.i(209214);
    this.dZY = t("RedDotShowInfoPath", paramString, true);
    AppMethodBeat.o(209214);
    return this;
  }
  
  public final bp ks(String paramString)
  {
    AppMethodBeat.i(209215);
    this.dZZ = t("RedDotShowInfoParentPath", paramString, true);
    AppMethodBeat.o(209215);
    return this;
  }
  
  public final bp kt(String paramString)
  {
    AppMethodBeat.i(209216);
    this.eac = t("RedDotShowInfoTitle", paramString, true);
    AppMethodBeat.o(209216);
    return this;
  }
  
  public final bp ku(String paramString)
  {
    AppMethodBeat.i(209217);
    this.ead = t("RedDotShowInfoExt", paramString, true);
    AppMethodBeat.o(209217);
    return this;
  }
  
  public final bp kv(String paramString)
  {
    AppMethodBeat.i(209218);
    this.eaf = t("CurrUI", paramString, true);
    AppMethodBeat.o(209218);
    return this;
  }
  
  public final bp kw(String paramString)
  {
    AppMethodBeat.i(209219);
    this.dXk = t("ContextID", paramString, true);
    AppMethodBeat.o(209219);
    return this;
  }
  
  public final bp kx(String paramString)
  {
    AppMethodBeat.i(209220);
    this.eag = t("ClickTabContextID", paramString, true);
    AppMethodBeat.o(209220);
    return this;
  }
  
  public final bp ky(String paramString)
  {
    AppMethodBeat.i(209221);
    this.eak = t("SessionID", paramString, true);
    AppMethodBeat.o(209221);
    return this;
  }
  
  public final bp kz(String paramString)
  {
    AppMethodBeat.i(209222);
    this.eam = t("RedDotShowInfoIconUrl", paramString, true);
    AppMethodBeat.o(209222);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bp
 * JD-Core Version:    0.7.0.1
 */