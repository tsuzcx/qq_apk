package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  private String dTC = "";
  public int dTw;
  private String dYc = "";
  public int ejG;
  public long ejH;
  public int ejI;
  public int ejJ;
  public int ejK;
  public int ejL;
  public long ejh;
  private String ejj = "";
  private String ejk = "";
  public int ejm;
  public int ejo;
  
  public final String RC()
  {
    AppMethodBeat.i(220287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejL);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(220287);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(220288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.ejh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ejG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.ejH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.ejI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCreateNewChat:").append(this.ejJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSequence:").append(this.ejK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.ejk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.ejo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEducationGuidance:").append(this.ejL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220288);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
  
  public final em od(String paramString)
  {
    AppMethodBeat.i(220283);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(220283);
    return this;
  }
  
  public final em oe(String paramString)
  {
    AppMethodBeat.i(220284);
    this.ejj = t("PattedUserName", paramString, true);
    AppMethodBeat.o(220284);
    return this;
  }
  
  public final em of(String paramString)
  {
    AppMethodBeat.i(220285);
    this.dTC = t("ChatroomName", paramString, true);
    AppMethodBeat.o(220285);
    return this;
  }
  
  public final em og(String paramString)
  {
    AppMethodBeat.i(220286);
    this.ejk = t("PatSuffix", paramString, true);
    AppMethodBeat.o(220286);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.em
 * JD-Core Version:    0.7.0.1
 */