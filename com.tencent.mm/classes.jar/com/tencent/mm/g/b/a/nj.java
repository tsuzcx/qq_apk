package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nj
  extends a
{
  private String eBQ = "";
  private String enR = "";
  private long exM = 0L;
  private long fde = 0L;
  private String fgA = "";
  private long fgs = 0L;
  private int fgt = 0;
  private String fgu = "";
  private String fgv = "";
  private String fgw = "";
  private String fgx = "";
  private long fgy = 0L;
  private String fgz = "";
  
  public final nj At(String paramString)
  {
    AppMethodBeat.i(43763);
    this.enR = x("appid", paramString, true);
    AppMethodBeat.o(43763);
    return this;
  }
  
  public final nj Au(String paramString)
  {
    AppMethodBeat.i(43764);
    this.fgv = x("errorMessage", paramString, true);
    AppMethodBeat.o(43764);
    return this;
  }
  
  public final nj Av(String paramString)
  {
    AppMethodBeat.i(43765);
    this.fgw = x("errorStack", paramString, true);
    AppMethodBeat.o(43765);
    return this;
  }
  
  public final nj Aw(String paramString)
  {
    AppMethodBeat.i(43766);
    this.fgx = x("sdkversion", paramString, true);
    AppMethodBeat.o(43766);
    return this;
  }
  
  public final nj Ax(String paramString)
  {
    AppMethodBeat.i(43767);
    this.fgz = x("route", paramString, true);
    AppMethodBeat.o(43767);
    return this;
  }
  
  public final nj Ay(String paramString)
  {
    AppMethodBeat.i(43768);
    this.eBQ = x("query", paramString, true);
    AppMethodBeat.o(43768);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fde);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.exM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.fgs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.fgt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.fgu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.fgv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.fgw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.fgx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.fgy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.fgz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.fgA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.fde);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final nj ajp()
  {
    this.fgt = 9;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
  
  public final nj xI(long paramLong)
  {
    this.exM = paramLong;
    return this;
  }
  
  public final nj xJ(long paramLong)
  {
    this.fgs = paramLong;
    return this;
  }
  
  public final nj xK(long paramLong)
  {
    this.fgy = paramLong;
    return this;
  }
  
  public final nj xL(long paramLong)
  {
    this.fde = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nj
 * JD-Core Version:    0.7.0.1
 */