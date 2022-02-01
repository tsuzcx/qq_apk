package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ds
  extends a
{
  private long eBj;
  private long eBk;
  private String eBl = "";
  private long eBm;
  private String ejo = "";
  private long eyO;
  
  public final String abV()
  {
    AppMethodBeat.i(209169);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBm);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209169);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209170);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CtrType:").append(this.eBj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.ejo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecallTime:").append(this.eBk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.eyO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeId:").append(this.eBl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeStatus:").append(this.eBm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209170);
    return localObject;
  }
  
  public final int getId()
  {
    return 20223;
  }
  
  public final ds kw(long paramLong)
  {
    this.eBj = paramLong;
    return this;
  }
  
  public final ds kx(long paramLong)
  {
    this.eBk = paramLong;
    return this;
  }
  
  public final ds ky(long paramLong)
  {
    this.eyO = paramLong;
    return this;
  }
  
  public final ds kz(long paramLong)
  {
    this.eBm = paramLong;
    return this;
  }
  
  public final ds pG(String paramString)
  {
    AppMethodBeat.i(209167);
    this.ejo = x("TipsId", paramString, true);
    AppMethodBeat.o(209167);
    return this;
  }
  
  public final ds pH(String paramString)
  {
    AppMethodBeat.i(209168);
    this.eBl = x("RevokeId", paramString, true);
    AppMethodBeat.o(209168);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ds
 * JD-Core Version:    0.7.0.1
 */