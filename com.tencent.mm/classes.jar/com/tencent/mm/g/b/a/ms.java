package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ms
  extends a
{
  public long eJb = 0L;
  private String eJx = "";
  private String eWb = "";
  public long eXc = 0L;
  public long eYW = 0L;
  public String eoK = "";
  public long erW = 0L;
  private long fac = 0L;
  private long fad = 0L;
  private long fae = 0L;
  public a fec;
  public c fed;
  public b fee;
  
  public final ms a(a parama)
  {
    this.fec = parama;
    return this;
  }
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(43668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fec != null)
    {
      i = this.fec.value;
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
      if (this.fed == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.fed.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.fee != null) {
        i = this.fee.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eJb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eoK);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43668);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43669);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fec);
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
    ((StringBuffer)localObject).append("Ret:").append(this.fed);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.fee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43669);
    return localObject;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final ms wH(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final ms wI(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final ms wJ(long paramLong)
  {
    AppMethodBeat.i(43665);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43665);
    return this;
  }
  
  public final ms wK(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final ms wL(long paramLong)
  {
    AppMethodBeat.i(43666);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43666);
    return this;
  }
  
  public final ms wM(long paramLong)
  {
    AppMethodBeat.i(43667);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43667);
    return this;
  }
  
  public final ms zW(String paramString)
  {
    AppMethodBeat.i(43663);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43663);
    return this;
  }
  
  public final ms zX(String paramString)
  {
    AppMethodBeat.i(43664);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43664);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43656);
      fef = new a("release", 0, 1);
      feg = new a("debug", 1, 2);
      feh = new a("demo", 2, 3);
      fei = new a[] { fef, feg, feh };
      AppMethodBeat.o(43656);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mD(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fef;
      case 2: 
        return feg;
      }
      return feh;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43659);
      fej = new b("sync", 0, 0);
      fek = new b("async", 1, 1);
      fel = new b[] { fej, fek };
      AppMethodBeat.o(43659);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43662);
      fem = new c("ok", 0, 0);
      fen = new c("common_fail", 1, 1);
      feo = new c[] { fem, fen };
      AppMethodBeat.o(43662);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ms
 * JD-Core Version:    0.7.0.1
 */