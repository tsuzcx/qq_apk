package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ef
  extends a
{
  private long giq;
  private String gnp = "";
  private String gnq = "";
  private String gwj = "";
  private long gxb;
  private String gxc = "";
  private long gxd;
  private String gxe = "";
  private String gxf = "";
  private String gxg = "";
  
  public final String agH()
  {
    AppMethodBeat.i(207988);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gxb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207988);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207989);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ProfileUin:").append(this.gxb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AtText:").append(this.gxc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfClickSucess:").append(this.gxd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileUsername:").append(this.gxe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileBizUin:").append(this.gxf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.gwj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.gnq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceInfo:").append(this.gxg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207989);
    return localObject;
  }
  
  public final int getId()
  {
    return 21172;
  }
  
  public final ef ll(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final ef rM(String paramString)
  {
    AppMethodBeat.i(207978);
    this.gxe = z("ProfileUsername", paramString, true);
    AppMethodBeat.o(207978);
    return this;
  }
  
  public final ef rN(String paramString)
  {
    AppMethodBeat.i(207980);
    this.gxf = z("ProfileBizUin", paramString, true);
    AppMethodBeat.o(207980);
    return this;
  }
  
  public final ef rO(String paramString)
  {
    AppMethodBeat.i(207981);
    this.gwj = z("ExtInfo", paramString, true);
    AppMethodBeat.o(207981);
    return this;
  }
  
  public final ef rP(String paramString)
  {
    AppMethodBeat.i(207983);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(207983);
    return this;
  }
  
  public final ef rQ(String paramString)
  {
    AppMethodBeat.i(207984);
    this.gnq = z("ExtraInfo", paramString, true);
    AppMethodBeat.o(207984);
    return this;
  }
  
  public final ef rR(String paramString)
  {
    AppMethodBeat.i(207987);
    this.gxg = z("EnterSourceInfo", paramString, true);
    AppMethodBeat.o(207987);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ef
 * JD-Core Version:    0.7.0.1
 */