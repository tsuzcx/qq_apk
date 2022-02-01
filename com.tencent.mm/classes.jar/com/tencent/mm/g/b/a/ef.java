package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ef
  extends a
{
  public int dHr = -1;
  public int dHw = -1;
  private String dJb = "";
  private String dTm = "";
  public int dUb = -1;
  public int dUc = -1;
  
  public final String PR()
  {
    AppMethodBeat.i(94847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUc);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94847);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94848);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.dTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnDestroyAction:").append(this.dUb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.dUc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94848);
    return localObject;
  }
  
  public final int getId()
  {
    return 18197;
  }
  
  public final ef ma(String paramString)
  {
    AppMethodBeat.i(94845);
    this.dJb = t("Username", paramString, true);
    AppMethodBeat.o(94845);
    return this;
  }
  
  public final ef mb(String paramString)
  {
    AppMethodBeat.i(94846);
    this.dTm = t("PublishId", paramString, true);
    AppMethodBeat.o(94846);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ef
 * JD-Core Version:    0.7.0.1
 */