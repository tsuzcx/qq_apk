package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ff
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  public a ebI;
  public long ebJ = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43525);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ebI != null) {}
    for (int i = this.ebI.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ebJ);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43525);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ebI);
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
    ((StringBuffer)localObject).append("isFromAndroidRecents:").append(this.ebJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43526);
    return localObject;
  }
  
  public final int getId()
  {
    return 16898;
  }
  
  public final ff ib(long paramLong)
  {
    AppMethodBeat.i(43522);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43522);
    return this;
  }
  
  public final ff ic(long paramLong)
  {
    AppMethodBeat.i(43523);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43523);
    return this;
  }
  
  public final ff id(long paramLong)
  {
    AppMethodBeat.i(43524);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43524);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43521);
      ebK = new a("release", 0, 1);
      ebL = new a("debug", 1, 2);
      ebM = new a("demo", 2, 3);
      ebN = new a[] { ebK, ebL, ebM };
      AppMethodBeat.o(43521);
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
        return ebK;
      case 2: 
        return ebL;
      }
      return ebM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ff
 * JD-Core Version:    0.7.0.1
 */