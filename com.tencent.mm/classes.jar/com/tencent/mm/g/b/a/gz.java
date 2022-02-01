package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class gz
  extends a
{
  public long dHY = 0L;
  private String dZT = "";
  public long eaM = 0L;
  public long eaY = 0L;
  private String ecm = "";
  public long eco = 0L;
  public a edZ;
  public long edd = 0L;
  private long edv = 0L;
  private long edw = 0L;
  public long edx = 0L;
  public long eea = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(43543);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.edZ != null) {}
    for (int i = this.edZ.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eea);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43543);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edZ);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.eaY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGame:").append(this.eea);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43544);
    return localObject;
  }
  
  public final gz SJ()
  {
    AppMethodBeat.i(43542);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43542);
    return this;
  }
  
  public final int getId()
  {
    return 15814;
  }
  
  public final gz lJ(long paramLong)
  {
    AppMethodBeat.i(43540);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43540);
    return this;
  }
  
  public final gz lK(long paramLong)
  {
    AppMethodBeat.i(43541);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43541);
    return this;
  }
  
  public final gz ol(String paramString)
  {
    AppMethodBeat.i(43538);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43538);
    return this;
  }
  
  public final gz om(String paramString)
  {
    AppMethodBeat.i(43539);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43539);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43537);
      eeb = new a("release", 0, 1);
      eec = new a("debug", 1, 2);
      eed = new a("demo", 2, 3);
      eee = new a[] { eeb, eec, eed };
      AppMethodBeat.o(43537);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iO(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eeb;
      case 2: 
        return eec;
      }
      return eed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gz
 * JD-Core Version:    0.7.0.1
 */