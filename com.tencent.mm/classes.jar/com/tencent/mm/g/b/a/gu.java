package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gu
  extends a
{
  private String eKW = "";
  private String eKX = "";
  private String eKY = "";
  private long ejW;
  private String ekH = "";
  private long elz;
  private String enR = "";
  private long erw;
  private String exF = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209305);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKY);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209305);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209306);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionTS:").append(this.elz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("setting:").append(this.eKW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session_id:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.exF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickid:").append(this.eKX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestID:").append(this.eKY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209306);
    return localObject;
  }
  
  public final int getId()
  {
    return 21837;
  }
  
  public final gu qE(long paramLong)
  {
    this.elz = paramLong;
    return this;
  }
  
  public final gu qF(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final gu qG(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final gu uA(String paramString)
  {
    AppMethodBeat.i(209301);
    this.ekH = x("session_id", paramString, true);
    AppMethodBeat.o(209301);
    return this;
  }
  
  public final gu uB(String paramString)
  {
    AppMethodBeat.i(209302);
    this.exF = x("finderid", paramString, true);
    AppMethodBeat.o(209302);
    return this;
  }
  
  public final gu uC(String paramString)
  {
    AppMethodBeat.i(209303);
    this.eKX = x("clickid", paramString, true);
    AppMethodBeat.o(209303);
    return this;
  }
  
  public final gu uD(String paramString)
  {
    AppMethodBeat.i(209304);
    this.eKY = x("requestID", paramString, true);
    AppMethodBeat.o(209304);
    return this;
  }
  
  public final gu uy(String paramString)
  {
    AppMethodBeat.i(209299);
    this.eKW = x("setting", paramString, true);
    AppMethodBeat.o(209299);
    return this;
  }
  
  public final gu uz(String paramString)
  {
    AppMethodBeat.i(209300);
    this.enR = x("appid", paramString, true);
    AppMethodBeat.o(209300);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gu
 * JD-Core Version:    0.7.0.1
 */