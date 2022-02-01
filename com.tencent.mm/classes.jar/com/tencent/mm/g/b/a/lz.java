package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class lz
  extends a
{
  private String eJx = "";
  private String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public long eZK = 0L;
  public long erW = 0L;
  public long evl = 0L;
  public a faG;
  public long faH = 0L;
  private String faI = "";
  private long fac = 0L;
  private long fad = 0L;
  public long fae = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43543);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.faG != null) {}
    for (int i = this.faG.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faI);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43543);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43544);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.faG);
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
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.evl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isGame:").append(this.faH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.faI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43544);
    return localObject;
  }
  
  public final lz aiU()
  {
    AppMethodBeat.i(43542);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43542);
    return this;
  }
  
  public final int getId()
  {
    return 15814;
  }
  
  public final lz vA(long paramLong)
  {
    AppMethodBeat.i(43541);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43541);
    return this;
  }
  
  public final lz vz(long paramLong)
  {
    AppMethodBeat.i(43540);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43540);
    return this;
  }
  
  public final lz zi(String paramString)
  {
    AppMethodBeat.i(43538);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43538);
    return this;
  }
  
  public final lz zj(String paramString)
  {
    AppMethodBeat.i(43539);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43539);
    return this;
  }
  
  public final lz zk(String paramString)
  {
    AppMethodBeat.i(226063);
    this.faI = x("engineVersion", paramString, true);
    AppMethodBeat.o(226063);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43537);
      faJ = new a("release", 0, 1);
      faK = new a("debug", 1, 2);
      faL = new a("demo", 2, 3);
      faM = new a[] { faJ, faK, faL };
      AppMethodBeat.o(43537);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ml(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return faJ;
      case 2: 
        return faK;
      }
      return faL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lz
 * JD-Core Version:    0.7.0.1
 */