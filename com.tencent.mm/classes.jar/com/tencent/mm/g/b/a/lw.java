package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lw
  extends a
{
  public String eJx = "";
  public String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long erW = 0L;
  public long evl = 0L;
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public a faq;
  
  public final String abV()
  {
    AppMethodBeat.i(43517);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.faq != null) {}
    for (int i = this.faq.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.evl);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43517);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43518);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.faq);
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
    ((StringBuffer)localObject).append("type:").append(this.evl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43518);
    return localObject;
  }
  
  public final int getId()
  {
    return 16895;
  }
  
  public final lw vq(long paramLong)
  {
    AppMethodBeat.i(43514);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43514);
    return this;
  }
  
  public final lw vr(long paramLong)
  {
    AppMethodBeat.i(43515);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43515);
    return this;
  }
  
  public final lw vs(long paramLong)
  {
    AppMethodBeat.i(43516);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43516);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43513);
      far = new a("release", 0, 1);
      fas = new a("debug", 1, 2);
      fat = new a("demo", 2, 3);
      fau = new a[] { far, fas, fat };
      AppMethodBeat.o(43513);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mi(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return far;
      case 2: 
        return fas;
      }
      return fat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lw
 * JD-Core Version:    0.7.0.1
 */