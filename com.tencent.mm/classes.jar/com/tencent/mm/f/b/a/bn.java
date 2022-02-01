package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bn
  extends a
{
  private String gjm = "";
  private long gnj;
  private long gnk;
  private long gnl;
  private String gnm = "";
  private String gnn = "";
  private String gno = "";
  private String gnp = "";
  private String gnq = "";
  private String gnr = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208836);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208836);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.gnk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontype:").append(this.gnl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedplayinfo:").append(this.gnm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MutualAdInfo:").append(this.gnn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionbuffer:").append(this.gno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.gnq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.gnr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208838);
    return localObject;
  }
  
  public final bn dJ(long paramLong)
  {
    this.gnj = paramLong;
    return this;
  }
  
  public final bn dK(long paramLong)
  {
    this.gnk = paramLong;
    return this;
  }
  
  public final bn dL(long paramLong)
  {
    this.gnl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 22955;
  }
  
  public final bn jU(String paramString)
  {
    AppMethodBeat.i(208825);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(208825);
    return this;
  }
  
  public final bn jV(String paramString)
  {
    AppMethodBeat.i(208828);
    this.gnm = z("feedplayinfo", paramString, true);
    AppMethodBeat.o(208828);
    return this;
  }
  
  public final bn jW(String paramString)
  {
    AppMethodBeat.i(208829);
    this.gnn = z("MutualAdInfo", paramString, true);
    AppMethodBeat.o(208829);
    return this;
  }
  
  public final bn jX(String paramString)
  {
    AppMethodBeat.i(208830);
    this.gno = z("sessionbuffer", paramString, true);
    AppMethodBeat.o(208830);
    return this;
  }
  
  public final bn jY(String paramString)
  {
    AppMethodBeat.i(208831);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(208831);
    return this;
  }
  
  public final bn jZ(String paramString)
  {
    AppMethodBeat.i(208832);
    this.gnq = z("ExtraInfo", paramString, true);
    AppMethodBeat.o(208832);
    return this;
  }
  
  public final bn ka(String paramString)
  {
    AppMethodBeat.i(208835);
    this.gnr = z("enterSourceInfo", paramString, true);
    AppMethodBeat.o(208835);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bn
 * JD-Core Version:    0.7.0.1
 */