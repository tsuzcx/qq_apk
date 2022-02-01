package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ev
  extends a
{
  private long dSa;
  private String dSb;
  private String dSe;
  private long dVd = 0L;
  private long dWa = 0L;
  private String edW;
  private String eje;
  private String ejf;
  private long ejg = 0L;
  private long ejh = 0L;
  private long eji;
  private long ejj = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(207798);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWa);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(207798);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(207799);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.edW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.eje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.ejf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.ejg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.ejh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.eji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.dWa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207799);
    return localObject;
  }
  
  public final ev Tk()
  {
    this.dVd = 59L;
    return this;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final ev jZ(long paramLong)
  {
    this.ejg = paramLong;
    return this;
  }
  
  public final ev ka(long paramLong)
  {
    this.ejh = paramLong;
    return this;
  }
  
  public final ev kb(long paramLong)
  {
    this.eji = paramLong;
    return this;
  }
  
  public final ev kc(long paramLong)
  {
    this.dSa = paramLong;
    return this;
  }
  
  public final ev kd(long paramLong)
  {
    this.dWa = paramLong;
    return this;
  }
  
  public final ev nY(String paramString)
  {
    AppMethodBeat.i(207793);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(207793);
    return this;
  }
  
  public final ev nZ(String paramString)
  {
    AppMethodBeat.i(207794);
    this.edW = t("SearchId", paramString, true);
    AppMethodBeat.o(207794);
    return this;
  }
  
  public final ev oa(String paramString)
  {
    AppMethodBeat.i(207795);
    this.eje = t("ClickMD5", paramString, true);
    AppMethodBeat.o(207795);
    return this;
  }
  
  public final ev ob(String paramString)
  {
    AppMethodBeat.i(207796);
    this.ejf = t("QueryMD5", paramString, true);
    AppMethodBeat.o(207796);
    return this;
  }
  
  public final ev oc(String paramString)
  {
    AppMethodBeat.i(207797);
    this.dSe = t("RequestId", paramString, true);
    AppMethodBeat.o(207797);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ev
 * JD-Core Version:    0.7.0.1
 */