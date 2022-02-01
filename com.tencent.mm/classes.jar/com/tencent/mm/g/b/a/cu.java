package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cu
  extends a
{
  private String els = "";
  private String exA = "";
  private String exB = "";
  private int exC;
  private String exD = "";
  private String exE = "";
  private String exF = "";
  private String exG = "";
  private long exH;
  private int exI;
  private int exJ;
  private long exK;
  private long exL;
  
  public final String abV()
  {
    AppMethodBeat.i(209062);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.exA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exL);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209062);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209063);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appuin:").append(this.exA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.exB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.exC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networktype:").append(this.exD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.exE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.exF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowid:").append(this.exG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickid:").append(this.exH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispresend:").append(this.exI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispreload:").append(this.exJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmstartime:").append(this.exK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmendtime:").append(this.exL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209063);
    return localObject;
  }
  
  public final cu aem()
  {
    this.exC = 10;
    return this;
  }
  
  public final cu aen()
  {
    this.exH = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 21249;
  }
  
  public final cu hQ(long paramLong)
  {
    this.exK = paramLong;
    return this;
  }
  
  public final cu hR(long paramLong)
  {
    this.exL = paramLong;
    return this;
  }
  
  public final cu kk(int paramInt)
  {
    this.exI = paramInt;
    return this;
  }
  
  public final cu kl(int paramInt)
  {
    this.exJ = paramInt;
    return this;
  }
  
  public final cu nA(String paramString)
  {
    AppMethodBeat.i(209059);
    this.exF = x("finderid", paramString, true);
    AppMethodBeat.o(209059);
    return this;
  }
  
  public final cu nB(String paramString)
  {
    AppMethodBeat.i(209060);
    this.exG = x("shopwindowid", paramString, true);
    AppMethodBeat.o(209060);
    return this;
  }
  
  public final cu nC(String paramString)
  {
    AppMethodBeat.i(209061);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209061);
    return this;
  }
  
  public final cu nw(String paramString)
  {
    AppMethodBeat.i(209055);
    this.exA = x("appuin", paramString, true);
    AppMethodBeat.o(209055);
    return this;
  }
  
  public final cu nx(String paramString)
  {
    AppMethodBeat.i(209056);
    this.exB = x("appversion", paramString, true);
    AppMethodBeat.o(209056);
    return this;
  }
  
  public final cu ny(String paramString)
  {
    AppMethodBeat.i(209057);
    this.exD = x("networktype", paramString, true);
    AppMethodBeat.o(209057);
    return this;
  }
  
  public final cu nz(String paramString)
  {
    AppMethodBeat.i(209058);
    this.exE = x("liveid", paramString, true);
    AppMethodBeat.o(209058);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu
 * JD-Core Version:    0.7.0.1
 */