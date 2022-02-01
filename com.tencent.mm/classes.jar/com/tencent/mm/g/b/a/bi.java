package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bi
  extends a
{
  private String dFJ = "";
  public long dPA = 0L;
  public long dPB = 0L;
  public long dPC = 0L;
  private String dPw = "";
  public long dPx = 0L;
  public long dPy = 0L;
  public long dPz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPC);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.dPw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.dPx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.dPy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.dPz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.dPA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.dPB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.dPC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final bi ib(String paramString)
  {
    AppMethodBeat.i(149918);
    this.dFJ = t("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final bi ic(String paramString)
  {
    AppMethodBeat.i(149919);
    this.dPw = t("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bi
 * JD-Core Version:    0.7.0.1
 */