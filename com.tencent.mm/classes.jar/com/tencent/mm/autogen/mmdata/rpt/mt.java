package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mt
  extends a
{
  public String imU = "";
  public int imW;
  public int inj;
  private String iph = "";
  public long jaZ;
  public String jbb = "";
  private String jbc = "";
  public int jbe;
  public int jbf;
  public long jcp;
  public int jcq;
  public int jcr;
  public int jcs;
  public int jct;
  private String jcu = "";
  private String jcv = "";
  private String jcw = "";
  private String jcx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368362);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iph);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jct);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368362);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.jaZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.jbb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.iph);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.inj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.jcp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.jcq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCreateNewChat:").append(this.jcr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSequence:").append(this.jcs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.jbc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.jbf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.jbe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEducationGuidance:").append(this.jct);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromStatusID:").append(this.jcu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToStatusID:").append(this.jcv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromStatusIcon:").append(this.jcw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToStatusIcon:").append(this.jcx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368372);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
  
  public final mt vd(String paramString)
  {
    AppMethodBeat.i(368322);
    this.imU = F("Username", paramString, true);
    AppMethodBeat.o(368322);
    return this;
  }
  
  public final mt ve(String paramString)
  {
    AppMethodBeat.i(368328);
    this.jbb = F("PattedUserName", paramString, true);
    AppMethodBeat.o(368328);
    return this;
  }
  
  public final mt vf(String paramString)
  {
    AppMethodBeat.i(368334);
    this.iph = F("ChatroomName", paramString, true);
    AppMethodBeat.o(368334);
    return this;
  }
  
  public final mt vg(String paramString)
  {
    AppMethodBeat.i(368339);
    this.jbc = F("PatSuffix", paramString, true);
    AppMethodBeat.o(368339);
    return this;
  }
  
  public final mt vh(String paramString)
  {
    AppMethodBeat.i(368343);
    this.jcu = F("FromStatusID", paramString, true);
    AppMethodBeat.o(368343);
    return this;
  }
  
  public final mt vi(String paramString)
  {
    AppMethodBeat.i(368347);
    this.jcv = F("ToStatusID", paramString, true);
    AppMethodBeat.o(368347);
    return this;
  }
  
  public final mt vj(String paramString)
  {
    AppMethodBeat.i(368351);
    this.jcw = F("FromStatusIcon", paramString, true);
    AppMethodBeat.o(368351);
    return this;
  }
  
  public final mt vk(String paramString)
  {
    AppMethodBeat.i(368355);
    this.jcx = F("ToStatusIcon", paramString, true);
    AppMethodBeat.o(368355);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mt
 * JD-Core Version:    0.7.0.1
 */