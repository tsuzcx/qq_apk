package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jf
  extends a
{
  public long dWt = 0L;
  public a eBx;
  public long ebQ = 0L;
  public String esa = "";
  public long etb = 0L;
  public long euA = 0L;
  public String euy = "";
  private long evH = 0L;
  private long evI = 0L;
  private long evJ = 0L;
  public long evp = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43753);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.eBx != null) {}
    for (int i = this.eBx.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebQ);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43753);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43754);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eBx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.evH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.evI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.evJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.ebQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43754);
    return localObject;
  }
  
  public final int getId()
  {
    return 16368;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43752);
      eBy = new a("release", 0, 1);
      eBz = new a("debug", 1, 2);
      eBA = new a("demo", 2, 3);
      eBB = new a[] { eBy, eBz, eBA };
      AppMethodBeat.o(43752);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jL(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eBy;
      case 2: 
        return eBz;
      }
      return eBA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jf
 * JD-Core Version:    0.7.0.1
 */