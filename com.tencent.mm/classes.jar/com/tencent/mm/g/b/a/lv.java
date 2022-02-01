package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class lv
  extends a
{
  private String eJx = "";
  private String eWb = "";
  public long eYW = 0L;
  public long erW = 0L;
  private long fac = 0L;
  public long fad = 0L;
  public long fae = 0L;
  public a fak;
  public long fal = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    if (this.fak != null) {}
    for (int i = this.fak.value;; i = -1)
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
      ((StringBuffer)localObject).append(this.fal);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43509);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fak);
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
    ((StringBuffer)localObject).append("IsPreload:").append(this.fal);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43510);
    return localObject;
  }
  
  public final lv aiT()
  {
    AppMethodBeat.i(43508);
    this.fae = Util.nowMilliSecond();
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43508);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final lv vo(long paramLong)
  {
    AppMethodBeat.i(43506);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43506);
    return this;
  }
  
  public final lv vp(long paramLong)
  {
    AppMethodBeat.i(43507);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43507);
    return this;
  }
  
  public final lv zg(String paramString)
  {
    AppMethodBeat.i(43504);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43504);
    return this;
  }
  
  public final lv zh(String paramString)
  {
    AppMethodBeat.i(43505);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43505);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43503);
      fam = new a("release", 0, 1);
      fan = new a("debug", 1, 2);
      fao = new a("demo", 2, 3);
      fap = new a[] { fam, fan, fao };
      AppMethodBeat.o(43503);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fam;
      case 2: 
        return fan;
      }
      return fao;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lv
 * JD-Core Version:    0.7.0.1
 */