package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dm
  extends a
{
  private String ggA = "";
  private String gtJ = "";
  private String gtK = "";
  private int gtL;
  private String gtM = "";
  private String gtN = "";
  private String gtO = "";
  private String gtP = "";
  private long gtQ;
  private int gtR;
  private int gtS;
  private long gtT;
  private long gtU;
  
  public final String agH()
  {
    AppMethodBeat.i(209286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gtJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209286);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appuin:").append(this.gtJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.gtK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.gtL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networktype:").append(this.gtM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gtN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.gtO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowid:").append(this.gtP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickid:").append(this.gtQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispresend:").append(this.gtR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispreload:").append(this.gtS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmstartime:").append(this.gtT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmendtime:").append(this.gtU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209288);
    return localObject;
  }
  
  public final dm ajf()
  {
    this.gtL = 10;
    return this;
  }
  
  public final dm ajg()
  {
    this.gtQ = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 21249;
  }
  
  public final dm iP(long paramLong)
  {
    this.gtT = paramLong;
    return this;
  }
  
  public final dm iQ(long paramLong)
  {
    this.gtU = paramLong;
    return this;
  }
  
  public final dm lE(int paramInt)
  {
    this.gtR = paramInt;
    return this;
  }
  
  public final dm lF(int paramInt)
  {
    this.gtS = paramInt;
    return this;
  }
  
  public final dm qf(String paramString)
  {
    AppMethodBeat.i(209265);
    this.gtJ = z("appuin", paramString, true);
    AppMethodBeat.o(209265);
    return this;
  }
  
  public final dm qg(String paramString)
  {
    AppMethodBeat.i(209267);
    this.gtK = z("appversion", paramString, true);
    AppMethodBeat.o(209267);
    return this;
  }
  
  public final dm qh(String paramString)
  {
    AppMethodBeat.i(209272);
    this.gtM = z("networktype", paramString, true);
    AppMethodBeat.o(209272);
    return this;
  }
  
  public final dm qi(String paramString)
  {
    AppMethodBeat.i(209274);
    this.gtN = z("liveid", paramString, true);
    AppMethodBeat.o(209274);
    return this;
  }
  
  public final dm qj(String paramString)
  {
    AppMethodBeat.i(209277);
    this.gtO = z("finderid", paramString, true);
    AppMethodBeat.o(209277);
    return this;
  }
  
  public final dm qk(String paramString)
  {
    AppMethodBeat.i(209279);
    this.gtP = z("shopwindowid", paramString, true);
    AppMethodBeat.o(209279);
    return this;
  }
  
  public final dm ql(String paramString)
  {
    AppMethodBeat.i(209280);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209280);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dm
 * JD-Core Version:    0.7.0.1
 */