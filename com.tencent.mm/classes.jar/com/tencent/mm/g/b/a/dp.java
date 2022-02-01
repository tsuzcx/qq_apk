package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  private String dHr = "";
  public long dTX = 0L;
  private String dUW = "";
  public long dUX = 0L;
  private String dUY = "";
  public long dUZ = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTX);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.dUX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.dUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.dTX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final dp jS(String paramString)
  {
    AppMethodBeat.i(94851);
    this.dUW = t("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final dp jT(String paramString)
  {
    AppMethodBeat.i(94852);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final dp jU(String paramString)
  {
    AppMethodBeat.i(94853);
    this.dUY = t("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dp
 * JD-Core Version:    0.7.0.1
 */