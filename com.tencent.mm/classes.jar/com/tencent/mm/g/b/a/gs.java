package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gs
  extends a
{
  private String eKN = "";
  public long eKO = 0L;
  public long eKP = 0L;
  public long eKQ = 0L;
  public long eKR = 0L;
  public long eKS = 0L;
  public long eKT = 0L;
  private String els = "";
  
  public final String abV()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKT);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.eKN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.eKO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.eKP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.eKQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.eKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.eKS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.eKT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final gs uu(String paramString)
  {
    AppMethodBeat.i(149918);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final gs uv(String paramString)
  {
    AppMethodBeat.i(149919);
    this.eKN = x("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gs
 * JD-Core Version:    0.7.0.1
 */