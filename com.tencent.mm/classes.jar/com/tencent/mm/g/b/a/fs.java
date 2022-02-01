package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fs
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  private String dYa = "";
  private String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  private long ecA = 0L;
  public long ecI = 0L;
  public long ecK = 0L;
  public long ecL = 0L;
  private String ecO = "";
  public a edu;
  private String edv = "";
  
  public final String PV()
  {
    AppMethodBeat.i(43629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.edu != null) {}
    for (int i = this.edu.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecO);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43629);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("package:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSize:").append(this.ecI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreloadPageFrame:").append(this.ecA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.ecL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.ecK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ecO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43630);
    return localObject;
  }
  
  public final int getId()
  {
    return 16005;
  }
  
  public final fs iS(long paramLong)
  {
    AppMethodBeat.i(43624);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43624);
    return this;
  }
  
  public final fs iT(long paramLong)
  {
    AppMethodBeat.i(43625);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43625);
    return this;
  }
  
  public final fs iU(long paramLong)
  {
    AppMethodBeat.i(43626);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43626);
    return this;
  }
  
  public final fs lw(String paramString)
  {
    AppMethodBeat.i(43622);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43622);
    return this;
  }
  
  public final fs lx(String paramString)
  {
    AppMethodBeat.i(43623);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43623);
    return this;
  }
  
  public final fs ly(String paramString)
  {
    AppMethodBeat.i(43627);
    this.edv = t("package", paramString, true);
    AppMethodBeat.o(43627);
    return this;
  }
  
  public final fs lz(String paramString)
  {
    AppMethodBeat.i(43628);
    this.ecO = t("engineVersion", paramString, true);
    AppMethodBeat.o(43628);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43621);
      edw = new a("release", 0, 1);
      edx = new a("debug", 1, 2);
      edy = new a("demo", 2, 3);
      edz = new a[] { edw, edx, edy };
      AppMethodBeat.o(43621);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iZ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edw;
      case 2: 
        return edx;
      }
      return edy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fs
 * JD-Core Version:    0.7.0.1
 */