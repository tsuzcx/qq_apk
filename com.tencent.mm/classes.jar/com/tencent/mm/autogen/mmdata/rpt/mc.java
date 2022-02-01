package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mc
  extends a
{
  public int iUn;
  public int imW;
  private String irj = "";
  public long jaZ;
  public long jba;
  private String jbb = "";
  private String jbc = "";
  private String jbd = "";
  public int jbe;
  public int jbf;
  
  public final String aIE()
  {
    AppMethodBeat.i(368431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jba);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368431);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368437);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.jaZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeTime:").append(this.jba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.jbb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.jbc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomName:").append(this.jbd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.jbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.iUn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.jbf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368437);
    return localObject;
  }
  
  public final int getId()
  {
    return 20590;
  }
  
  public final mc uJ(String paramString)
  {
    AppMethodBeat.i(368412);
    this.irj = F("UserName", paramString, true);
    AppMethodBeat.o(368412);
    return this;
  }
  
  public final mc uK(String paramString)
  {
    AppMethodBeat.i(368418);
    this.jbb = F("PattedUserName", paramString, true);
    AppMethodBeat.o(368418);
    return this;
  }
  
  public final mc uL(String paramString)
  {
    AppMethodBeat.i(368424);
    this.jbc = F("PatSuffix", paramString, true);
    AppMethodBeat.o(368424);
    return this;
  }
  
  public final mc uM(String paramString)
  {
    AppMethodBeat.i(368427);
    this.jbd = F("ChatRoomName", paramString, true);
    AppMethodBeat.o(368427);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mc
 * JD-Core Version:    0.7.0.1
 */