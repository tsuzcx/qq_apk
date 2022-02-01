package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bo
  extends a
{
  private long ebk;
  private String ebl = "";
  private long ebm;
  private long ebn;
  private String ebo = "";
  private long ebp;
  
  public final String RC()
  {
    AppMethodBeat.i(189246);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189246);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189247);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CtrType:").append(this.ebk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.ebl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecallTime:").append(this.ebm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.ebn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeId:").append(this.ebo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeStatus:").append(this.ebp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189247);
    return localObject;
  }
  
  public final bo gd(long paramLong)
  {
    this.ebk = paramLong;
    return this;
  }
  
  public final bo ge(long paramLong)
  {
    this.ebm = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20223;
  }
  
  public final bo gf(long paramLong)
  {
    this.ebn = paramLong;
    return this;
  }
  
  public final bo gg(long paramLong)
  {
    this.ebp = paramLong;
    return this;
  }
  
  public final bo kB(String paramString)
  {
    AppMethodBeat.i(189244);
    this.ebl = t("TipsId", paramString, true);
    AppMethodBeat.o(189244);
    return this;
  }
  
  public final bo kC(String paramString)
  {
    AppMethodBeat.i(189245);
    this.ebo = t("RevokeId", paramString, true);
    AppMethodBeat.o(189245);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bo
 * JD-Core Version:    0.7.0.1
 */