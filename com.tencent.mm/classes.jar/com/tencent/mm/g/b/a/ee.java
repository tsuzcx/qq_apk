package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ee
  extends a
{
  public int dTw;
  private String dUy = "";
  public long ejh;
  public long eji;
  private String ejj = "";
  private String ejk = "";
  private String ejl = "";
  public int ejm;
  public int ejn;
  public int ejo;
  
  public final String RC()
  {
    AppMethodBeat.i(220281);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejo);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(220281);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(220282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.ejh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeTime:").append(this.eji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.ejk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomName:").append(this.ejl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.ejn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.ejo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220282);
    return localObject;
  }
  
  public final int getId()
  {
    return 20590;
  }
  
  public final ee nL(String paramString)
  {
    AppMethodBeat.i(220277);
    this.dUy = t("UserName", paramString, true);
    AppMethodBeat.o(220277);
    return this;
  }
  
  public final ee nM(String paramString)
  {
    AppMethodBeat.i(220278);
    this.ejj = t("PattedUserName", paramString, true);
    AppMethodBeat.o(220278);
    return this;
  }
  
  public final ee nN(String paramString)
  {
    AppMethodBeat.i(220279);
    this.ejk = t("PatSuffix", paramString, true);
    AppMethodBeat.o(220279);
    return this;
  }
  
  public final ee nO(String paramString)
  {
    AppMethodBeat.i(220280);
    this.ejl = t("ChatRoomName", paramString, true);
    AppMethodBeat.o(220280);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ee
 * JD-Core Version:    0.7.0.1
 */