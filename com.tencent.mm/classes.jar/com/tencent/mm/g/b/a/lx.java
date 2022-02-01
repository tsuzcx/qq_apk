package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lx
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long erW = 0L;
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public a fav;
  public long faw = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43525);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fav != null) {}
    for (int i = this.fav.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fae);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faw);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43525);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFromAndroidRecents:").append(this.faw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43526);
    return localObject;
  }
  
  public final int getId()
  {
    return 16898;
  }
  
  public final lx vt(long paramLong)
  {
    AppMethodBeat.i(43522);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43522);
    return this;
  }
  
  public final lx vu(long paramLong)
  {
    AppMethodBeat.i(43523);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43523);
    return this;
  }
  
  public final lx vv(long paramLong)
  {
    AppMethodBeat.i(43524);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43524);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43521);
      fax = new a("release", 0, 1);
      fay = new a("debug", 1, 2);
      faz = new a("demo", 2, 3);
      faA = new a[] { fax, fay, faz };
      AppMethodBeat.o(43521);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mj(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fax;
      case 2: 
        return fay;
      }
      return faz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lx
 * JD-Core Version:    0.7.0.1
 */