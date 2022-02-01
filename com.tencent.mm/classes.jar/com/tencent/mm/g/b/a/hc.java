package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hc
  extends a
{
  private long eBF;
  private long eBn;
  private String eBo = "";
  private String eBp = "";
  private long eBr;
  private String eBu = "";
  private long eLr;
  private long eLs;
  private String eLt = "";
  private String eLu = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209312);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209312);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209313);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.eBn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.eBr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeState:").append(this.eLr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.eBo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoPath:").append(this.eBp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeType:").append(this.eLs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WhiteListReddotList:").append(this.eLt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverwriteRedDotTipsID:").append(this.eLu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotactiontimestamp:").append(this.eBF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoExt:").append(this.eBu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209313);
    return localObject;
  }
  
  public final int getId()
  {
    return 20951;
  }
  
  public final hc qI(long paramLong)
  {
    this.eBn = paramLong;
    return this;
  }
  
  public final hc qJ(long paramLong)
  {
    this.eBr = paramLong;
    return this;
  }
  
  public final hc qK(long paramLong)
  {
    this.eLr = paramLong;
    return this;
  }
  
  public final hc qL(long paramLong)
  {
    this.eLs = paramLong;
    return this;
  }
  
  public final hc qM(long paramLong)
  {
    this.eBF = paramLong;
    return this;
  }
  
  public final hc uQ(String paramString)
  {
    AppMethodBeat.i(209307);
    this.eBo = x("RedDotTipsID", paramString, true);
    AppMethodBeat.o(209307);
    return this;
  }
  
  public final hc uR(String paramString)
  {
    AppMethodBeat.i(209308);
    this.eBp = x("RedDotShowInfoPath", paramString, true);
    AppMethodBeat.o(209308);
    return this;
  }
  
  public final hc uS(String paramString)
  {
    AppMethodBeat.i(209309);
    this.eLt = x("WhiteListReddotList", paramString, true);
    AppMethodBeat.o(209309);
    return this;
  }
  
  public final hc uT(String paramString)
  {
    AppMethodBeat.i(209310);
    this.eLu = x("OverwriteRedDotTipsID", paramString, true);
    AppMethodBeat.o(209310);
    return this;
  }
  
  public final hc uU(String paramString)
  {
    AppMethodBeat.i(209311);
    this.eBu = x("RedDotShowInfoExt", paramString, true);
    AppMethodBeat.o(209311);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hc
 * JD-Core Version:    0.7.0.1
 */