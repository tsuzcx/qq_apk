package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ai
  extends a
{
  private long dPH;
  private String dQt;
  private String dVC;
  private String dVD;
  private String dVE;
  private long dVF;
  private long dVG;
  private String dVi;
  
  public final String RD()
  {
    AppMethodBeat.i(209057);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVG);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209057);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209058);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("finderUsername:").append(this.dVC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUsername:").append(this.dVD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toFinderUsername:").append(this.dVE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.dVF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.dVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.dVG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209058);
    return localObject;
  }
  
  public final String RK()
  {
    return this.dQt;
  }
  
  public final String RL()
  {
    return this.dVi;
  }
  
  public final ai cG(long paramLong)
  {
    this.dPH = paramLong;
    return this;
  }
  
  public final ai cH(long paramLong)
  {
    this.dVF = paramLong;
    return this;
  }
  
  public final ai cI(long paramLong)
  {
    this.dVG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20671;
  }
  
  public final ai hi(String paramString)
  {
    AppMethodBeat.i(209052);
    this.dVC = t("finderUsername", paramString, true);
    AppMethodBeat.o(209052);
    return this;
  }
  
  public final ai hj(String paramString)
  {
    AppMethodBeat.i(209053);
    this.dVD = t("toUsername", paramString, true);
    AppMethodBeat.o(209053);
    return this;
  }
  
  public final ai hk(String paramString)
  {
    AppMethodBeat.i(209054);
    this.dVE = t("toFinderUsername", paramString, true);
    AppMethodBeat.o(209054);
    return this;
  }
  
  public final ai hl(String paramString)
  {
    AppMethodBeat.i(209055);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(209055);
    return this;
  }
  
  public final ai hm(String paramString)
  {
    AppMethodBeat.i(209056);
    this.dVi = t("clicktabcontextid", paramString, true);
    AppMethodBeat.o(209056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ai
 * JD-Core Version:    0.7.0.1
 */