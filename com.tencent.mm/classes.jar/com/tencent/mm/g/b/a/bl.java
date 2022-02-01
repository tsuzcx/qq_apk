package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  private String dFY;
  private String dFe;
  private long dHU;
  private long dIS;
  private String dLi;
  
  public final String PR()
  {
    AppMethodBeat.i(184190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dLi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHU);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184190);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dLi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dIS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dHU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184191);
    return localObject;
  }
  
  public final bl fJ(long paramLong)
  {
    this.dIS = paramLong;
    return this;
  }
  
  public final bl fK(long paramLong)
  {
    this.dHU = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19433;
  }
  
  public final bl jr(String paramString)
  {
    AppMethodBeat.i(184188);
    this.dLi = t("Action", paramString, true);
    AppMethodBeat.o(184188);
    return this;
  }
  
  public final bl js(String paramString)
  {
    AppMethodBeat.i(184189);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(184189);
    return this;
  }
  
  public final bl jt(String paramString)
  {
    AppMethodBeat.i(195035);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195035);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bl
 * JD-Core Version:    0.7.0.1
 */