package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class hb
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  public long eaM = 0L;
  private String ecQ = "";
  private String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  public long edg = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public a eek;
  private String eel = "";
  public long eem = 0L;
  public long een = 0L;
  public long eeo;
  public long eep = 0L;
  public long eeq = 0L;
  public long eer = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43560);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eek != null) {}
    for (int i = this.eek.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eel);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eem);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.een);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eep);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eer);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43560);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43561);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eek);
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
    ((StringBuffer)localObject).append("username:").append(this.eel);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.ecQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isContactSync:").append(this.eem);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunchSync:").append(this.een);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("phase:").append(this.eeo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showAd:").append(this.eep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkShowAdTimeThreshold:").append(this.eeq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.eer);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43561);
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
  
  public final hb SM()
  {
    AppMethodBeat.i(43557);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43557);
    return this;
  }
  
  public final hb SN()
  {
    this.edg = 0L;
    return this;
  }
  
  public final hb SO()
  {
    this.edd = 0L;
    return this;
  }
  
  public final hb SP()
  {
    this.een = 2L;
    return this;
  }
  
  public final hb SQ()
  {
    this.eeo = 0L;
    return this;
  }
  
  public final hb a(a parama)
  {
    this.eek = parama;
    return this;
  }
  
  public final int getId()
  {
    return 18033;
  }
  
  public final hb lL(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final hb lM(long paramLong)
  {
    this.eco = paramLong;
    return this;
  }
  
  public final hb lN(long paramLong)
  {
    AppMethodBeat.i(43555);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43555);
    return this;
  }
  
  public final hb lO(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final hb lP(long paramLong)
  {
    AppMethodBeat.i(43556);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43556);
    return this;
  }
  
  public final hb lQ(long paramLong)
  {
    this.eem = paramLong;
    return this;
  }
  
  public final hb on(String paramString)
  {
    AppMethodBeat.i(43553);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43553);
    return this;
  }
  
  public final hb oo(String paramString)
  {
    AppMethodBeat.i(43554);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43554);
    return this;
  }
  
  public final hb op(String paramString)
  {
    AppMethodBeat.i(43558);
    this.eel = t("username", paramString, true);
    AppMethodBeat.o(43558);
    return this;
  }
  
  public final hb oq(String paramString)
  {
    AppMethodBeat.i(43559);
    this.ecQ = t("networkType", paramString, true);
    AppMethodBeat.o(43559);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43552);
      ees = new a("release", 0, 1);
      eet = new a("debug", 1, 2);
      eeu = new a("demo", 2, 3);
      eev = new a[] { ees, eet, eeu };
      AppMethodBeat.o(43552);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iQ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ees;
      case 2: 
        return eet;
      }
      return eeu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hb
 * JD-Core Version:    0.7.0.1
 */