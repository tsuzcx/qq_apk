package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fe
  extends a
{
  public int dPT = -1;
  public int dSg = -1;
  private String dWK = "";
  private String ejz = "";
  public int ekt = -1;
  public int eku = -1;
  
  public final String RD()
  {
    AppMethodBeat.i(94847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eku);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94847);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94848);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnDestroyAction:").append(this.ekt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.eku);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94848);
    return localObject;
  }
  
  public final int getId()
  {
    return 18197;
  }
  
  public final fe on(String paramString)
  {
    AppMethodBeat.i(94845);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(94845);
    return this;
  }
  
  public final fe oo(String paramString)
  {
    AppMethodBeat.i(94846);
    this.ejz = t("PublishId", paramString, true);
    AppMethodBeat.o(94846);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fe
 * JD-Core Version:    0.7.0.1
 */