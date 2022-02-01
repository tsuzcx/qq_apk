package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dn
  extends a
{
  private String ggA = "";
  private String gtJ = "";
  private int gtL;
  private String gtM = "";
  private String gtN = "";
  private String gtO = "";
  private String gtP = "";
  private int gtR;
  private int gtS;
  private long gtV;
  private String gtW = "";
  private long gtX;
  
  public final String agH()
  {
    AppMethodBeat.i(209662);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gtJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209662);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209663);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appuin:").append(this.gtJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.gtV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.gtL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networktype:").append(this.gtM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmpath:").append(this.gtW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispresend:").append(this.gtR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispreload:").append(this.gtS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gtN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.gtO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowid:").append(this.gtP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventtime:").append(this.gtX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209663);
    return localObject;
  }
  
  public final dn ajh()
  {
    this.gtV = 0L;
    return this;
  }
  
  public final dn aji()
  {
    this.gtL = 10;
    return this;
  }
  
  public final int getId()
  {
    return 21248;
  }
  
  public final dn iR(long paramLong)
  {
    this.gtX = paramLong;
    return this;
  }
  
  public final dn lG(int paramInt)
  {
    this.gtR = paramInt;
    return this;
  }
  
  public final dn lH(int paramInt)
  {
    this.gtS = paramInt;
    return this;
  }
  
  public final dn qm(String paramString)
  {
    AppMethodBeat.i(209649);
    this.gtJ = z("appuin", paramString, true);
    AppMethodBeat.o(209649);
    return this;
  }
  
  public final dn qn(String paramString)
  {
    AppMethodBeat.i(209650);
    this.gtM = z("networktype", paramString, true);
    AppMethodBeat.o(209650);
    return this;
  }
  
  public final dn qo(String paramString)
  {
    AppMethodBeat.i(209651);
    this.gtW = z("prewarmpath", paramString, true);
    AppMethodBeat.o(209651);
    return this;
  }
  
  public final dn qp(String paramString)
  {
    AppMethodBeat.i(209655);
    this.gtN = z("liveid", paramString, true);
    AppMethodBeat.o(209655);
    return this;
  }
  
  public final dn qq(String paramString)
  {
    AppMethodBeat.i(209657);
    this.gtO = z("finderid", paramString, true);
    AppMethodBeat.o(209657);
    return this;
  }
  
  public final dn qr(String paramString)
  {
    AppMethodBeat.i(209658);
    this.gtP = z("shopwindowid", paramString, true);
    AppMethodBeat.o(209658);
    return this;
  }
  
  public final dn qs(String paramString)
  {
    AppMethodBeat.i(209660);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209660);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dn
 * JD-Core Version:    0.7.0.1
 */