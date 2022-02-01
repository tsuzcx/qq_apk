package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iw
  extends a
{
  private String eQe = "";
  private String eQj = "";
  private String eQl = "";
  public long eQm = 0L;
  public long eQn = 0L;
  public long eQo = 0L;
  public long eQp = 0L;
  public long eQq = 0L;
  private String emL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.eQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.eQl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.eQm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.eQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.eQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.eQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.eQq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
  
  public final iw wt(String paramString)
  {
    AppMethodBeat.i(110278);
    this.emL = x("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final iw wu(String paramString)
  {
    AppMethodBeat.i(110279);
    this.eQe = x("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final iw wv(String paramString)
  {
    AppMethodBeat.i(110280);
    this.eQl = x("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final iw ww(String paramString)
  {
    AppMethodBeat.i(110281);
    this.eQj = x("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iw
 * JD-Core Version:    0.7.0.1
 */