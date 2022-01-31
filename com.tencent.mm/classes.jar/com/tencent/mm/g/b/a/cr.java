package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class cr
  extends a
{
  public long cRG;
  public long cTb;
  private String cZA;
  public long cZB;
  public long cZD;
  private String dar;
  private long dat;
  private long dau;
  private long dav;
  public cr.a dcE;
  public cr.b dcF;
  
  public cr()
  {
    this.dar = "";
    this.cZA = "";
    this.cZB = 0L;
    this.cZD = 0L;
    this.dat = 0L;
    this.cRG = 0L;
    this.dau = 0L;
    this.dav = 0L;
    this.cTb = 0L;
  }
  
  public cr(String paramString)
  {
    AppMethodBeat.i(128824);
    this.dar = "";
    this.cZA = "";
    this.cZB = 0L;
    this.cZD = 0L;
    this.dat = 0L;
    this.cRG = 0L;
    this.dau = 0L;
    this.dav = 0L;
    this.cTb = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 11) {
          break label239;
        }
        String[] arrayOfString = new String[11];
        Arrays.fill(arrayOfString, 0, 11, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label239:
    for (;;)
    {
      hQ(paramString[0]);
      hR(paramString[1]);
      this.cZB = bo.getLong(paramString[2], 0L);
      this.dcE = cr.a.he(bo.getInt(paramString[3], 0));
      this.cZD = bo.getLong(paramString[4], 0L);
      fk(bo.getLong(paramString[5], 0L));
      this.cRG = bo.getLong(paramString[6], 0L);
      fl(bo.getLong(paramString[7], 0L));
      fm(bo.getLong(paramString[8], 0L));
      this.dcF = cr.b.hf(bo.getInt(paramString[9], 0));
      this.cTb = bo.getLong(paramString[10], 0L);
      AppMethodBeat.o(128824);
      return;
    }
  }
  
  public final String Ff()
  {
    int j = -1;
    AppMethodBeat.i(128830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dcE != null) {}
    for (int i = this.dcE.value;; i = -1)
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
      i = j;
      if (this.dcF != null) {
        i = this.dcF.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cTb);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128830);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128831);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dcE);
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
    ((StringBuffer)localObject).append("Ret:").append(this.dcF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.cTb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128831);
    return localObject;
  }
  
  public final cr fk(long paramLong)
  {
    AppMethodBeat.i(128827);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128827);
    return this;
  }
  
  public final cr fl(long paramLong)
  {
    AppMethodBeat.i(128828);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128828);
    return this;
  }
  
  public final cr fm(long paramLong)
  {
    AppMethodBeat.i(128829);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128829);
    return this;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final cr hQ(String paramString)
  {
    AppMethodBeat.i(128825);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128825);
    return this;
  }
  
  public final cr hR(String paramString)
  {
    AppMethodBeat.i(128826);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128826);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr
 * JD-Core Version:    0.7.0.1
 */