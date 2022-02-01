package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class fd
  extends a
{
  public long dKe = 0L;
  private String dYa = "";
  private String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public a ebx;
  public long eby = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    if (this.ebx != null) {}
    for (int i = this.ebx.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eby);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ebx);
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
    ((StringBuffer)localObject).append("IsPreload:").append(this.eby);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final fd RP()
  {
    AppMethodBeat.i(43508);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final fd hW(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final fd hX(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final fd le(String paramString)
  {
    AppMethodBeat.i(43504);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final fd lf(String paramString)
  {
    AppMethodBeat.i(43505);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43503);
      ebz = new a("release", 0, 1);
      ebA = new a("debug", 1, 2);
      ebB = new a("demo", 2, 3);
      ebC = new a[] { ebz, ebA, ebB };
      AppMethodBeat.o(43503);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iM(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ebz;
      case 2: 
        return ebA;
      }
      return ebB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fd
 * JD-Core Version:    0.7.0.1
 */