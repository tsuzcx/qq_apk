package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class mt
  extends a
{
  public long eJb;
  private String eJx;
  private String eWb;
  public long eXc;
  public long eYW;
  public long erW;
  private String faT;
  private long fac;
  private long fad;
  private long fae;
  public a fep;
  public b feq;
  private long fer;
  private long fes;
  
  public mt()
  {
    this.eWb = "";
    this.eJx = "";
    this.eXc = 0L;
    this.eYW = 0L;
    this.fac = 0L;
    this.erW = 0L;
    this.fad = 0L;
    this.fae = 0L;
    this.eJb = 0L;
    this.faT = "";
    this.fer = 0L;
  }
  
  public mt(String paramString)
  {
    AppMethodBeat.i(43676);
    this.eWb = "";
    this.eJx = "";
    this.eXc = 0L;
    this.eYW = 0L;
    this.fac = 0L;
    this.erW = 0L;
    this.fad = 0L;
    this.fae = 0L;
    this.eJb = 0L;
    this.faT = "";
    this.fer = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label283;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label283:
    for (;;)
    {
      zY(paramString[0]);
      zZ(paramString[1]);
      this.eXc = Util.getLong(paramString[2], 0L);
      this.fep = a.mE(Util.getInt(paramString[3], 0));
      this.eYW = Util.getLong(paramString[4], 0L);
      wP(Util.getLong(paramString[5], 0L));
      this.erW = Util.getLong(paramString[6], 0L);
      wR(Util.getLong(paramString[7], 0L));
      wS(Util.getLong(paramString[8], 0L));
      this.feq = b.mF(Util.getInt(paramString[9], 0));
      this.eJb = Util.getLong(paramString[10], 0L);
      Aa(paramString[11]);
      this.fer = Util.getLong(paramString[12], 0L);
      this.fes = Util.getLong(paramString[13], 0L);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final mt Aa(String paramString)
  {
    AppMethodBeat.i(43682);
    this.faT = x("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public final mt a(a parama)
  {
    this.fep = parama;
    return this;
  }
  
  public final mt a(b paramb)
  {
    this.feq = paramb;
    return this;
  }
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fep != null) {}
    for (int i = this.fep.value;; i = -1)
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
      i = j;
      if (this.feq != null) {
        i = this.feq.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eJb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.faT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fer);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fes);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fep);
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
    ((StringBuffer)localObject).append("Ret:").append(this.feq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.faT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.fer);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.fes);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final long aiV()
  {
    return this.fad;
  }
  
  public final long aiW()
  {
    return this.fae;
  }
  
  public final mt ajk()
  {
    this.fer = 1L;
    return this;
  }
  
  public final String getAppId()
  {
    return this.eJx;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final mt wN(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mt wO(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mt wP(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.fac = paramLong;
    super.bi("CostTimeMs", this.fac);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final mt wQ(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mt wR(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final mt wS(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.fae = paramLong;
    super.bj("EndTimeStampMs", this.fae);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final mt wT(long paramLong)
  {
    this.eJb = paramLong;
    return this;
  }
  
  public final mt wU(long paramLong)
  {
    this.fes = paramLong;
    return this;
  }
  
  public final mt zY(String paramString)
  {
    AppMethodBeat.i(43677);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final mt zZ(String paramString)
  {
    AppMethodBeat.i(43678);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      fet = new a("release", 0, 1);
      feu = new a("debug", 1, 2);
      fev = new a("demo", 2, 3);
      few = new a[] { fet, feu, fev };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fet;
      case 2: 
        return feu;
      }
      return fev;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      fex = new b("ok", 0, 0);
      fey = new b("common_fail", 1, 1);
      fez = new b[] { fex, fey };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b mF(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return fex;
      }
      return fey;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mt
 * JD-Core Version:    0.7.0.1
 */