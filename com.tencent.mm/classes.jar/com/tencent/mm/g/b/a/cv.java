package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cv
  extends a
{
  private String els = "";
  private String exA = "";
  private int exC;
  private String exD = "";
  private String exE = "";
  private String exF = "";
  private String exG = "";
  private int exI;
  private int exJ;
  private long exM;
  private String exN = "";
  private long exO;
  
  public final String abV()
  {
    AppMethodBeat.i(209071);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.exA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209071);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209072);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appuin:").append(this.exA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.exM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.exC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networktype:").append(this.exD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmpath:").append(this.exN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispresend:").append(this.exI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispreload:").append(this.exJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.exE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.exF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowid:").append(this.exG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventtime:").append(this.exO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209072);
    return localObject;
  }
  
  public final cv aeo()
  {
    this.exM = 0L;
    return this;
  }
  
  public final cv aep()
  {
    this.exC = 10;
    return this;
  }
  
  public final int getId()
  {
    return 21248;
  }
  
  public final cv hS(long paramLong)
  {
    this.exO = paramLong;
    return this;
  }
  
  public final cv km(int paramInt)
  {
    this.exI = paramInt;
    return this;
  }
  
  public final cv kn(int paramInt)
  {
    this.exJ = paramInt;
    return this;
  }
  
  public final cv nD(String paramString)
  {
    AppMethodBeat.i(209064);
    this.exA = x("appuin", paramString, true);
    AppMethodBeat.o(209064);
    return this;
  }
  
  public final cv nE(String paramString)
  {
    AppMethodBeat.i(209065);
    this.exD = x("networktype", paramString, true);
    AppMethodBeat.o(209065);
    return this;
  }
  
  public final cv nF(String paramString)
  {
    AppMethodBeat.i(209066);
    this.exN = x("prewarmpath", paramString, true);
    AppMethodBeat.o(209066);
    return this;
  }
  
  public final cv nG(String paramString)
  {
    AppMethodBeat.i(209067);
    this.exE = x("liveid", paramString, true);
    AppMethodBeat.o(209067);
    return this;
  }
  
  public final cv nH(String paramString)
  {
    AppMethodBeat.i(209068);
    this.exF = x("finderid", paramString, true);
    AppMethodBeat.o(209068);
    return this;
  }
  
  public final cv nI(String paramString)
  {
    AppMethodBeat.i(209069);
    this.exG = x("shopwindowid", paramString, true);
    AppMethodBeat.o(209069);
    return this;
  }
  
  public final cv nJ(String paramString)
  {
    AppMethodBeat.i(209070);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209070);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cv
 * JD-Core Version:    0.7.0.1
 */