package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  private String dbq = "";
  public cp.a dcj;
  private String dck = "";
  public long dcl = 0L;
  public long dcm = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128800);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dcj != null) {}
    for (int i = this.dcj.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dck);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dcl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dcm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dbq);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128800);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dcj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.dck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.dcl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.dcm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkTypeStr:").append(this.dbq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128801);
    return localObject;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final cp hL(String paramString)
  {
    AppMethodBeat.i(128797);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128797);
    return this;
  }
  
  public final cp hM(String paramString)
  {
    AppMethodBeat.i(128798);
    this.dck = t("Provider", paramString, true);
    AppMethodBeat.o(128798);
    return this;
  }
  
  public final cp hN(String paramString)
  {
    AppMethodBeat.i(128799);
    this.dbq = t("networkTypeStr", paramString, true);
    AppMethodBeat.o(128799);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cp
 * JD-Core Version:    0.7.0.1
 */