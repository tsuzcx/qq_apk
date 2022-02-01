package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fh
  extends a
{
  private String dRB;
  private String ekP;
  private String ekU;
  private String ekW;
  public long ekX = 0L;
  public long ekY = 0L;
  public long ekZ = 0L;
  public long ela = 0L;
  public long elb = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ela);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.ekP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.ekW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.ekX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.ekY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.ekZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.ela);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.elb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.ekU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
  
  public final fh op(String paramString)
  {
    AppMethodBeat.i(110278);
    this.dRB = t("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final fh oq(String paramString)
  {
    AppMethodBeat.i(110279);
    this.ekP = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final fh or(String paramString)
  {
    AppMethodBeat.i(110280);
    this.ekW = t("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final fh os(String paramString)
  {
    AppMethodBeat.i(110281);
    this.ekU = t("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fh
 * JD-Core Version:    0.7.0.1
 */