package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ev
  extends a
{
  private long dYT = 0L;
  private String eag;
  private a eah;
  private long eai = 0L;
  private long eaj = 0L;
  private String eak;
  
  public final String PV()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eah != null) {}
    for (int i = this.eah.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eak);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.eaj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.eak);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final long RN()
  {
    return this.eaj;
  }
  
  public final String RO()
  {
    return this.eak;
  }
  
  public final ev a(a parama)
  {
    this.eah = parama;
    return this;
  }
  
  public final String getAppId()
  {
    return this.eag;
  }
  
  public final int getId()
  {
    return 17687;
  }
  
  public final ev hJ(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final ev hK(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final ev hL(long paramLong)
  {
    this.eaj = paramLong;
    return this;
  }
  
  public final ev kR(String paramString)
  {
    AppMethodBeat.i(43469);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final ev kS(String paramString)
  {
    AppMethodBeat.i(180149);
    this.eak = t("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43468);
      eal = new a("release", 0, 1);
      eam = new a("debug", 1, 2);
      ean = new a("demo", 2, 3);
      eao = new a[] { eal, eam, ean };
      AppMethodBeat.o(43468);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iG(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eal;
      case 2: 
        return eam;
      }
      return ean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ev
 * JD-Core Version:    0.7.0.1
 */