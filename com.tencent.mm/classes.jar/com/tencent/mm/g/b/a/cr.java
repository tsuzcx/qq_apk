package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  public int dJp = -1;
  public int dJu = -1;
  private String dKt = "";
  private String dRy = "";
  public int dSn = -1;
  public int dSo = -1;
  
  public final String PV()
  {
    AppMethodBeat.i(94847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94847);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94848);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.dRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnDestroyAction:").append(this.dSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94848);
    return localObject;
  }
  
  public final int getId()
  {
    return 18197;
  }
  
  public final cr jk(String paramString)
  {
    AppMethodBeat.i(94845);
    this.dKt = t("Username", paramString, true);
    AppMethodBeat.o(94845);
    return this;
  }
  
  public final cr jl(String paramString)
  {
    AppMethodBeat.i(94846);
    this.dRy = t("PublishId", paramString, true);
    AppMethodBeat.o(94846);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr
 * JD-Core Version:    0.7.0.1
 */