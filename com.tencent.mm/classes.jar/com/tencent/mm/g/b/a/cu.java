package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class cu
  extends a
{
  public long cRG = 0L;
  public long cTb = 0L;
  private String cZA = "";
  public long cZB = 0L;
  public long cZD = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  public long dav = 0L;
  public cu.a ddj;
  public long ddk = 0L;
  public cu.c ddl;
  public cu.b ddm;
  public long ddn = 0L;
  private long ddo = 0L;
  
  public final String Ff()
  {
    int j = -1;
    AppMethodBeat.i(128871);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.ddj != null)
    {
      i = this.ddj.value;
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
      ((StringBuffer)localObject).append(this.ddk);
      ((StringBuffer)localObject).append(",");
      if (this.ddl == null) {
        break label309;
      }
    }
    label309:
    for (int i = this.ddl.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ddm != null) {
        i = this.ddm.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cTb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ddn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ddo);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128871);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128872);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ddj);
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
    ((StringBuffer)localObject).append("PkgSize:").append(this.ddk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.ddl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.ddm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.cTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.ddn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.ddo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128872);
    return localObject;
  }
  
  public final cu Hh()
  {
    AppMethodBeat.i(128870);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128870);
    return this;
  }
  
  public final cu fv(long paramLong)
  {
    AppMethodBeat.i(128868);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128868);
    return this;
  }
  
  public final cu fw(long paramLong)
  {
    AppMethodBeat.i(128869);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128869);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final cu hW(String paramString)
  {
    AppMethodBeat.i(128866);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128866);
    return this;
  }
  
  public final cu hX(String paramString)
  {
    AppMethodBeat.i(128867);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128867);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu
 * JD-Core Version:    0.7.0.1
 */