package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  public a ebo;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public long ebs = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43499);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.ebo != null) {}
    for (int i = this.ebo.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.ebs);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43499);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ebo);
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
    ((StringBuffer)localObject).append("BootstepType:").append(this.ebs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43500);
    return localObject;
  }
  
  public final int getId()
  {
    return 16900;
  }
  
  public final fc hT(long paramLong)
  {
    AppMethodBeat.i(43496);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43496);
    return this;
  }
  
  public final fc hU(long paramLong)
  {
    AppMethodBeat.i(43497);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43497);
    return this;
  }
  
  public final fc hV(long paramLong)
  {
    AppMethodBeat.i(43498);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43498);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43495);
      ebt = new a("release", 0, 1);
      ebu = new a("debug", 1, 2);
      ebv = new a("demo", 2, 3);
      ebw = new a[] { ebt, ebu, ebv };
      AppMethodBeat.o(43495);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iL(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ebt;
      case 2: 
        return ebu;
      }
      return ebv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fc
 * JD-Core Version:    0.7.0.1
 */