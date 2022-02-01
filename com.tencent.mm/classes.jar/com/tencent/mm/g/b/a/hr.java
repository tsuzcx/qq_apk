package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class hr
  extends a
{
  public long dHY;
  public long dQE;
  private String dZT;
  public long eaM;
  private String ecm;
  public long eco;
  private long edv;
  private long edw;
  private long edx;
  private String eel;
  public a ehj;
  public b ehk;
  private long ehl;
  private long ehm;
  
  public hr()
  {
    this.dZT = "";
    this.ecm = "";
    this.eaM = 0L;
    this.eco = 0L;
    this.edv = 0L;
    this.dHY = 0L;
    this.edw = 0L;
    this.edx = 0L;
    this.dQE = 0L;
    this.ehl = 0L;
  }
  
  public hr(String paramString)
  {
    AppMethodBeat.i(43676);
    this.dZT = "";
    this.ecm = "";
    this.eaM = 0L;
    this.eco = 0L;
    this.edv = 0L;
    this.dHY = 0L;
    this.edw = 0L;
    this.edx = 0L;
    this.dQE = 0L;
    this.ehl = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label277;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label277:
    for (;;)
    {
      oO(paramString[0]);
      oP(paramString[1]);
      this.eaM = bs.getLong(paramString[2], 0L);
      this.ehj = a.jd(bs.getInt(paramString[3], 0));
      this.eco = bs.getLong(paramString[4], 0L);
      mT(bs.getLong(paramString[5], 0L));
      this.dHY = bs.getLong(paramString[6], 0L);
      mV(bs.getLong(paramString[7], 0L));
      mW(bs.getLong(paramString[8], 0L));
      this.ehk = b.je(bs.getInt(paramString[9], 0));
      this.dQE = bs.getLong(paramString[10], 0L);
      oQ(paramString[11]);
      this.ehl = bs.getLong(paramString[12], 0L);
      this.ehm = bs.getLong(paramString[13], 0L);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.ehj != null) {}
    for (int i = this.ehj.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edx);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.ehk != null) {
        i = this.ehk.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dQE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eel);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ehm);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ehj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.ehk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.eel);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.ehl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.ehm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final long SK()
  {
    return this.edw;
  }
  
  public final long SL()
  {
    return this.edx;
  }
  
  public final hr SZ()
  {
    this.ehl = 1L;
    return this;
  }
  
  public final hr a(a parama)
  {
    this.ehj = parama;
    return this;
  }
  
  public final hr a(b paramb)
  {
    this.ehk = paramb;
    return this;
  }
  
  public final String getAppId()
  {
    return this.ecm;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final hr mR(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hr mS(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hr mT(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final hr mU(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hr mV(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final hr mW(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.edx = paramLong;
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final hr mX(long paramLong)
  {
    this.dQE = paramLong;
    return this;
  }
  
  public final hr mY(long paramLong)
  {
    this.ehm = paramLong;
    return this;
  }
  
  public final hr oO(String paramString)
  {
    AppMethodBeat.i(43677);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final hr oP(String paramString)
  {
    AppMethodBeat.i(43678);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public final hr oQ(String paramString)
  {
    AppMethodBeat.i(43682);
    this.eel = t("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      ehn = new a("release", 0, 1);
      eho = new a("debug", 1, 2);
      ehp = new a("demo", 2, 3);
      ehq = new a[] { ehn, eho, ehp };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jd(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ehn;
      case 2: 
        return eho;
      }
      return ehp;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      ehr = new b("ok", 0, 0);
      ehs = new b("common_fail", 1, 1);
      eht = new b[] { ehr, ehs };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b je(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return ehr;
      }
      return ehs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hr
 * JD-Core Version:    0.7.0.1
 */