package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dm
  extends a
{
  private long eAY;
  private String eAZ = "";
  private long eBa;
  private String eBb = "";
  private String eBc = "";
  private long enl;
  
  public final String abV()
  {
    AppMethodBeat.i(209136);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eAY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBc);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209136);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209137);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ProfileUin:").append(this.eAY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AtText:").append(this.eAZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfClickSucess:").append(this.eBa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileUsername:").append(this.eBb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileBizUin:").append(this.eBc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209137);
    return localObject;
  }
  
  public final String aff()
  {
    return this.eBb;
  }
  
  public final int getId()
  {
    return 21172;
  }
  
  public final dm kj(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final dm pe(String paramString)
  {
    AppMethodBeat.i(209134);
    this.eBb = x("ProfileUsername", paramString, true);
    AppMethodBeat.o(209134);
    return this;
  }
  
  public final dm pf(String paramString)
  {
    AppMethodBeat.i(209135);
    this.eBc = x("ProfileBizUin", paramString, true);
    AppMethodBeat.o(209135);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dm
 * JD-Core Version:    0.7.0.1
 */