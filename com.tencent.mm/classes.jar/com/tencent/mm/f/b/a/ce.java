package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ce
  extends a
{
  private String gcU = "";
  private long gjE;
  private long gpj;
  private long gpk;
  private String gpl = "";
  private long gpm;
  private long gpn;
  private long gpo;
  private long gpp;
  private long gpq;
  private long gpr;
  
  public final String agH()
  {
    AppMethodBeat.i(209898);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209898);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209899);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.gpj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.gpk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.gpl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.gpm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.gpn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.gpo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.gpp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.gjE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.gpq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("createscene:").append(this.gpr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209899);
    return localObject;
  }
  
  public final ce ahs()
  {
    this.gpm = 1L;
    return this;
  }
  
  public final ce aht()
  {
    this.gpn = 1L;
    return this;
  }
  
  public final ce ahu()
  {
    this.gpp = 1L;
    return this;
  }
  
  public final ce ahv()
  {
    this.gjE = 1L;
    return this;
  }
  
  public final ce fa(long paramLong)
  {
    this.gpj = paramLong;
    return this;
  }
  
  public final ce fb(long paramLong)
  {
    this.gpk = paramLong;
    return this;
  }
  
  public final ce fc(long paramLong)
  {
    this.gpr = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final ce lV(String paramString)
  {
    AppMethodBeat.i(209890);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209890);
    return this;
  }
  
  public final ce lW(String paramString)
  {
    AppMethodBeat.i(209893);
    this.gpl = z("FailReasonWording", paramString, true);
    AppMethodBeat.o(209893);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ce
 * JD-Core Version:    0.7.0.1
 */