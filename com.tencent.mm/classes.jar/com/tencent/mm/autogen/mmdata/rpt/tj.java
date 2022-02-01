package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tj
  extends a
{
  private String iEy = "";
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long iuf = 0L;
  public a jCM;
  private String jCN = "";
  public long jCO = 0L;
  public long jax = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43652);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jCM != null) {}
    for (int i = this.jCM.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jCN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iuf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jCO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iEy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ilM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43652);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43653);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jCM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Provider:").append(this.jCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.iuf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stage:").append(this.jCO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43653);
    return localObject;
  }
  
  public final int getId()
  {
    return 17120;
  }
  
  public final tj zM(String paramString)
  {
    AppMethodBeat.i(180163);
    this.jCN = F("Provider", paramString, true);
    AppMethodBeat.o(180163);
    return this;
  }
  
  public final tj zN(String paramString)
  {
    AppMethodBeat.i(180164);
    this.iEy = F("networkType", paramString, true);
    AppMethodBeat.o(180164);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43651);
      jCP = new a("release", 0, 1);
      jCQ = new a("debug", 1, 2);
      jCR = new a("demo", 2, 3);
      jCS = new a[] { jCP, jCQ, jCR };
      AppMethodBeat.o(43651);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a oZ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return jCP;
      case 2: 
        return jCQ;
      }
      return jCR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tj
 * JD-Core Version:    0.7.0.1
 */