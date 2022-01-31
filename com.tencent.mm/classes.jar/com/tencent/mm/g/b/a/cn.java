package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cn
  extends a
{
  private long cRG = 0L;
  private String cUZ = "";
  private String cZA = "";
  private long cZB = 0L;
  private long cZD = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  private long dav = 0L;
  private cn.a dbJ;
  private long dbK = 0L;
  private String dbq = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(128777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dbJ != null) {}
    for (int i = this.dbJ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dat);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dau);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dav);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cUZ);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128777);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dbJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.dat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.dau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.dav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkTypeStr:").append(this.dbq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.dbK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.cUZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128778);
    return localObject;
  }
  
  public final cn a(cn.a parama)
  {
    this.dbJ = parama;
    return this;
  }
  
  public final cn fa(long paramLong)
  {
    this.cZB = paramLong;
    return this;
  }
  
  public final cn fb(long paramLong)
  {
    this.cZD = paramLong;
    return this;
  }
  
  public final cn fc(long paramLong)
  {
    this.cRG = paramLong;
    return this;
  }
  
  public final cn fd(long paramLong)
  {
    this.dbK = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final cn hF(String paramString)
  {
    AppMethodBeat.i(128773);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128773);
    return this;
  }
  
  public final cn hG(String paramString)
  {
    AppMethodBeat.i(128774);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128774);
    return this;
  }
  
  public final cn hH(String paramString)
  {
    AppMethodBeat.i(128775);
    this.dbq = t("networkTypeStr", paramString, true);
    AppMethodBeat.o(128775);
    return this;
  }
  
  public final cn hI(String paramString)
  {
    AppMethodBeat.i(128776);
    this.cUZ = t("UserName", paramString, true);
    AppMethodBeat.o(128776);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cn
 * JD-Core Version:    0.7.0.1
 */