package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cv
  extends a
{
  private String dDw = "";
  private String dRl = "";
  public long dRm = 0L;
  public long dRn = 0L;
  public long dRo = 0L;
  public long dRp = 0L;
  public long dRq = 0L;
  public long dRr = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRr);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.dRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.dRm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.dRn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.dRo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.dRp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.dRq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.dRr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final cv kR(String paramString)
  {
    AppMethodBeat.i(149918);
    this.dDw = t("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final cv kS(String paramString)
  {
    AppMethodBeat.i(149919);
    this.dRl = t("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cv
 * JD-Core Version:    0.7.0.1
 */