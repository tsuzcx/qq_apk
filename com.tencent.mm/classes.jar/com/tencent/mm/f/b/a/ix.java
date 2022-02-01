package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ix
  extends a
{
  private String gKr = "";
  public long gKs = 0L;
  public long gKt = 0L;
  public long gKu = 0L;
  public long gKv = 0L;
  public long gKw = 0L;
  public long gKx = 0L;
  private String ggA = "";
  
  public final String agH()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.gKr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.gKs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.gKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.gKu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.gKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.gKw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.gKx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final ix zT(String paramString)
  {
    AppMethodBeat.i(149918);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final ix zU(String paramString)
  {
    AppMethodBeat.i(149919);
    this.gKr = z("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ix
 * JD-Core Version:    0.7.0.1
 */