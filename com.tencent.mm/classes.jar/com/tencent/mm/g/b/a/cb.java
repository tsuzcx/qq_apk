package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  private String dHu;
  public int dJu;
  private String dKt;
  public long dQC;
  private String dQD;
  public int dQE;
  public long dQF;
  public int dQG;
  
  public final String PV()
  {
    AppMethodBeat.i(196674);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQG);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(196674);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(196675);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.dQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.dQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dHu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.dQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.dQG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(196675);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
  
  public final cb iL(String paramString)
  {
    AppMethodBeat.i(196671);
    this.dKt = t("Username", paramString, true);
    AppMethodBeat.o(196671);
    return this;
  }
  
  public final cb iM(String paramString)
  {
    AppMethodBeat.i(196672);
    this.dQD = t("PattedUserName", paramString, true);
    AppMethodBeat.o(196672);
    return this;
  }
  
  public final cb iN(String paramString)
  {
    AppMethodBeat.i(196673);
    this.dHu = t("ChatroomName", paramString, true);
    AppMethodBeat.o(196673);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cb
 * JD-Core Version:    0.7.0.1
 */