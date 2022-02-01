package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class tl
  extends a
{
  public long iVU;
  private String ilM;
  public String imT;
  public long ind;
  private String iqX;
  public long iqr;
  private String jCW;
  public a jDh;
  public b jDi;
  public long jDj;
  public long jDk;
  public long jax;
  private long jyH;
  public long jyI;
  public long jyJ;
  
  public tl()
  {
    this.ilM = "";
    this.imT = "";
    this.ind = 0L;
    this.jax = 0L;
    this.jyH = 0L;
    this.iqr = 0L;
    this.jyI = 0L;
    this.jyJ = 0L;
    this.iVU = 0L;
    this.iqX = "";
    this.jDj = 0L;
    this.jCW = "";
  }
  
  public tl(String paramString)
  {
    AppMethodBeat.i(43676);
    this.ilM = "";
    this.imT = "";
    this.ind = 0L;
    this.jax = 0L;
    this.jyH = 0L;
    this.iqr = 0L;
    this.jyI = 0L;
    this.jyJ = 0L;
    this.iVU = 0L;
    this.iqX = "";
    this.jDj = 0L;
    this.jCW = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 15) {
          break label298;
        }
        String[] arrayOfString = new String[15];
        Arrays.fill(arrayOfString, 0, 15, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label298:
    for (;;)
    {
      zR(paramString[0]);
      zS(paramString[1]);
      this.ind = Util.getLong(paramString[2], 0L);
      this.jDh = a.pb(Util.getInt(paramString[3], 0));
      this.jax = Util.getLong(paramString[4], 0L);
      go(Util.getLong(paramString[5], 0L));
      this.iqr = Util.getLong(paramString[6], 0L);
      gp(Util.getLong(paramString[7], 0L));
      gq(Util.getLong(paramString[8], 0L));
      this.jDi = b.pc(Util.getInt(paramString[9], 0));
      this.iVU = Util.getLong(paramString[10], 0L);
      zT(paramString[11]);
      this.jDj = Util.getLong(paramString[12], 0L);
      this.jDk = Util.getLong(paramString[13], 0L);
      zU(paramString[14]);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jDh != null) {}
    for (int i = this.jDh.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyJ);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jDi != null) {
        i = this.jDi.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iVU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jDj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jDk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jCW);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jDh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.jyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.jyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.jyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.jDi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.jDj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.jDk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkTypeStr:").append(this.jCW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final tl go(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.jyH = paramLong;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final tl gp(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.jyI = paramLong;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final tl gq(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.jyJ = paramLong;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final tl zR(String paramString)
  {
    AppMethodBeat.i(43677);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final tl zS(String paramString)
  {
    AppMethodBeat.i(43678);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public final tl zT(String paramString)
  {
    AppMethodBeat.i(43682);
    this.iqX = F("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public final tl zU(String paramString)
  {
    AppMethodBeat.i(368789);
    this.jCW = F("NetworkTypeStr", paramString, true);
    AppMethodBeat.o(368789);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      jDl = new a("release", 0, 1);
      jDm = new a("debug", 1, 2);
      jDn = new a("demo", 2, 3);
      jDo = new a[] { jDl, jDm, jDn };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a pb(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return jDl;
      case 2: 
        return jDm;
      }
      return jDn;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      jDp = new b("ok", 0, 0);
      jDq = new b("common_fail", 1, 1);
      jDr = new b[] { jDp, jDq };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b pc(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return jDp;
      }
      return jDq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tl
 * JD-Core Version:    0.7.0.1
 */