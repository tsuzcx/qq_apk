package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ol
  extends a
{
  private long gYL = 0L;
  private long gYN = 0L;
  private String gmF = "";
  private long gnP = 0L;
  private ol.a hbI;
  private long hbJ = 0L;
  private String hbK = "";
  private long hbL = 0L;
  private long hbM = 0L;
  private long hbN = 0L;
  private long hbO = 0L;
  private long hbP = 0L;
  
  public final ol AS(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final ol AT(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final ol AU(long paramLong)
  {
    this.hbJ = paramLong;
    return this;
  }
  
  public final ol AV(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final ol AW(long paramLong)
  {
    this.hbL = paramLong;
    return this;
  }
  
  public final ol AX(long paramLong)
  {
    this.hbO = paramLong;
    return this;
  }
  
  public final ol AY(long paramLong)
  {
    this.hbP = paramLong;
    return this;
  }
  
  public final ol FA(String paramString)
  {
    AppMethodBeat.i(180149);
    this.hbK = z("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
  
  public final ol Fz(String paramString)
  {
    AppMethodBeat.i(43469);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final ol a(ol.a parama)
  {
    this.hbI = parama;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hbI != null) {}
    for (int i = this.hbI.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbP);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hbI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.hbJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.hbK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFileOccupation:").append(this.hbL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TriggerSingleAppClean:").append(this.hbM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TriggerAllAppClean:").append(this.hbN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RuntimeFileOccupation:").append(this.hbO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RuntimeSpaceStaticsEnable:").append(this.hbP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final long aoA()
  {
    return this.hbN;
  }
  
  public final long aoB()
  {
    return this.hbO;
  }
  
  public final long aoC()
  {
    return this.hbP;
  }
  
  public final long aov()
  {
    return this.hbJ;
  }
  
  public final String aow()
  {
    return this.hbK;
  }
  
  public final long aox()
  {
    return this.hbL;
  }
  
  public final ol aoy()
  {
    this.hbM = 1L;
    return this;
  }
  
  public final ol aoz()
  {
    this.hbN = 1L;
    return this;
  }
  
  public final String getAppId()
  {
    return this.gmF;
  }
  
  public final int getId()
  {
    return 17687;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ol
 * JD-Core Version:    0.7.0.1
 */