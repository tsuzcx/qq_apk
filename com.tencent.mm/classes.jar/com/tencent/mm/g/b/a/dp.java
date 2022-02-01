package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  private String dFh;
  public int dHw;
  private String dJb;
  public long dSr;
  private String dSs;
  public int dSt;
  public long dSu;
  public int dSv;
  
  public final String PR()
  {
    AppMethodBeat.i(198554);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSv);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(198554);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(198555);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.dSr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.dSs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.dSt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.dSu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.dSv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(198555);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
  
  public final dp lB(String paramString)
  {
    AppMethodBeat.i(198551);
    this.dJb = t("Username", paramString, true);
    AppMethodBeat.o(198551);
    return this;
  }
  
  public final dp lC(String paramString)
  {
    AppMethodBeat.i(198552);
    this.dSs = t("PattedUserName", paramString, true);
    AppMethodBeat.o(198552);
    return this;
  }
  
  public final dp lD(String paramString)
  {
    AppMethodBeat.i(198553);
    this.dFh = t("ChatroomName", paramString, true);
    AppMethodBeat.o(198553);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dp
 * JD-Core Version:    0.7.0.1
 */