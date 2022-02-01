package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class fh
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  private String dYa = "";
  public long dZg = 0L;
  public long eaX = 0L;
  private String eag = "";
  public long eai = 0L;
  public a ebT;
  public long ebU = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  public long ebr = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43543);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ebT != null) {}
    for (int i = this.ebT.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dZg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebU);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43543);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ebT);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.dZg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGame:").append(this.ebU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43544);
    return localObject;
  }
  
  public final fh RQ()
  {
    AppMethodBeat.i(43542);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43542);
    return this;
  }
  
  public final int getId()
  {
    return 15814;
  }
  
  public final fh ih(long paramLong)
  {
    AppMethodBeat.i(43540);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43540);
    return this;
  }
  
  public final fh ii(long paramLong)
  {
    AppMethodBeat.i(43541);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43541);
    return this;
  }
  
  public final fh lg(String paramString)
  {
    AppMethodBeat.i(43538);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43538);
    return this;
  }
  
  public final fh lh(String paramString)
  {
    AppMethodBeat.i(43539);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43539);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43537);
      ebV = new a("release", 0, 1);
      ebW = new a("debug", 1, 2);
      ebX = new a("demo", 2, 3);
      ebY = new a[] { ebV, ebW, ebX };
      AppMethodBeat.o(43537);
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
        return ebV;
      case 2: 
        return ebW;
      }
      return ebX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fh
 * JD-Core Version:    0.7.0.1
 */