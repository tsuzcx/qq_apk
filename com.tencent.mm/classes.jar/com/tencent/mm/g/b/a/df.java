package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class df
  extends a
{
  public long cUd = 0L;
  public long deV = 0L;
  public long deW = 0L;
  public long deX = 0L;
  public long deY = 0L;
  private String deZ = "";
  private String dfa = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(73313);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.deV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dfa);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73313);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73314);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.deV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.deW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.deX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.cUd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.deY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.deZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.dfa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73314);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
  
  public final df iA(String paramString)
  {
    AppMethodBeat.i(73312);
    this.dfa = t("ExptVal", paramString, false);
    AppMethodBeat.o(73312);
    return this;
  }
  
  public final df iz(String paramString)
  {
    AppMethodBeat.i(73311);
    this.deZ = t("ExptKey", paramString, true);
    AppMethodBeat.o(73311);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.df
 * JD-Core Version:    0.7.0.1
 */