package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oc
  extends a
{
  public String ijk = "";
  public String irj = "";
  public String jik = "";
  public long jil;
  public int jiq;
  public int jir;
  public long jis;
  public long jit;
  
  public final String aIE()
  {
    AppMethodBeat.i(368060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jir);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jis);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jit);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368060);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368067);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldedBlockId:").append(this.jik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCount:").append(this.jil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsExploded:").append(this.jiq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClicked:").append(this.jir);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimelineBrowseFeedCount:").append(this.jis);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocationIndex:").append(this.jit);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368067);
    return localObject;
  }
  
  public final int getId()
  {
    return 21340;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oc
 * JD-Core Version:    0.7.0.1
 */