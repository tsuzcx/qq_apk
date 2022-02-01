package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pl
  extends a
{
  private String ikD = "";
  public int jlY = 0;
  private String jlZ = "";
  private String jma = "";
  private String jmb = "";
  public String jmc = "";
  private String jmd = "";
  public String jme = "";
  private int jmf;
  public String jmg = "";
  private String jmh = "";
  public int jmi;
  public long jmj;
  public int jmk;
  private String jml = "";
  private String jmm = "";
  private int jmn;
  
  public final String aIE()
  {
    AppMethodBeat.i(369118);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jlY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jma);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jme);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jml);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369118);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("HookResult:").append(this.jlY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceName:").append(this.jlZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MethodName:").append(this.jma);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentActivity:").append(this.jmb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MethodStack:").append(this.jmc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MethodTimeStamp:").append(this.jmd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MethodOffsetTime:").append(this.jme);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPermissionGranted:").append(this.jmf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessName:").append(this.ikD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrStack:").append(this.jmg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequirePermission:").append(this.jmh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LogVersion:").append(this.jmi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hookDuration:").append(this.jmj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hookSuccessCount:").append(this.jmk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessTypeByStack:").append(this.jml);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bussinessTypeByActivity:").append(this.jmm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isBusinessMatch:").append(this.jmn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369125);
    return localObject;
  }
  
  public final int getId()
  {
    return 24550;
  }
  
  public final pl wN(String paramString)
  {
    AppMethodBeat.i(369080);
    this.jlZ = F("ServiceName", paramString, true);
    AppMethodBeat.o(369080);
    return this;
  }
  
  public final pl wO(String paramString)
  {
    AppMethodBeat.i(369085);
    this.jma = F("MethodName", paramString, true);
    AppMethodBeat.o(369085);
    return this;
  }
  
  public final pl wP(String paramString)
  {
    AppMethodBeat.i(369091);
    this.jmb = F("CurrentActivity", paramString, true);
    AppMethodBeat.o(369091);
    return this;
  }
  
  public final pl wQ(String paramString)
  {
    AppMethodBeat.i(369096);
    this.jmc = F("MethodStack", paramString, true);
    AppMethodBeat.o(369096);
    return this;
  }
  
  public final pl wR(String paramString)
  {
    AppMethodBeat.i(369100);
    this.jme = F("MethodOffsetTime", paramString, true);
    AppMethodBeat.o(369100);
    return this;
  }
  
  public final pl wS(String paramString)
  {
    AppMethodBeat.i(369105);
    this.ikD = F("ProcessName", paramString, true);
    AppMethodBeat.o(369105);
    return this;
  }
  
  public final pl wT(String paramString)
  {
    AppMethodBeat.i(369110);
    this.jmg = F("ErrStack", paramString, true);
    AppMethodBeat.o(369110);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pl
 * JD-Core Version:    0.7.0.1
 */