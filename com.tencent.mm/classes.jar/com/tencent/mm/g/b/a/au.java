package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  private String dVa;
  private long dWP;
  private long dXf = 0L;
  private long dXg;
  private String dXh;
  private long dXi;
  private long dXj;
  private String dXk;
  
  public final String RD()
  {
    AppMethodBeat.i(209109);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXk);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209109);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209110);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.dXf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.dXg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.dWP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.dXh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.dXi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.dXj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.dXk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209110);
    return localObject;
  }
  
  public final String Sb()
  {
    return this.dXh;
  }
  
  public final au Sc()
  {
    this.dXi = 1L;
    return this;
  }
  
  public final au dS(long paramLong)
  {
    this.dXf = paramLong;
    return this;
  }
  
  public final au dT(long paramLong)
  {
    this.dXg = paramLong;
    return this;
  }
  
  public final au dU(long paramLong)
  {
    this.dWP = paramLong;
    return this;
  }
  
  public final au dV(long paramLong)
  {
    this.dXj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19949;
  }
  
  public final au in(String paramString)
  {
    AppMethodBeat.i(209106);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209106);
    return this;
  }
  
  public final au io(String paramString)
  {
    AppMethodBeat.i(209107);
    this.dXh = t("ClickContextid", paramString, true);
    AppMethodBeat.o(209107);
    return this;
  }
  
  public final au ip(String paramString)
  {
    AppMethodBeat.i(209108);
    this.dXk = t("ContextID", paramString, true);
    AppMethodBeat.o(209108);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.au
 * JD-Core Version:    0.7.0.1
 */