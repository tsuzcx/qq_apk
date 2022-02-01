package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  private long dCS;
  private String dHV;
  private String dHW;
  private long dHY;
  private String dJP;
  private long dKh;
  
  public final String PR()
  {
    AppMethodBeat.i(194964);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKh);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194964);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194965);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.dKh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194965);
    return localObject;
  }
  
  public final aq dH(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final aq dI(long paramLong)
  {
    this.dCS = paramLong;
    return this;
  }
  
  public final aq dJ(long paramLong)
  {
    this.dKh = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final aq hI(String paramString)
  {
    AppMethodBeat.i(194961);
    this.dHV = t("Sessionid", paramString, true);
    AppMethodBeat.o(194961);
    return this;
  }
  
  public final aq hJ(String paramString)
  {
    AppMethodBeat.i(194962);
    this.dHW = t("Contextid", paramString, true);
    AppMethodBeat.o(194962);
    return this;
  }
  
  public final aq hK(String paramString)
  {
    AppMethodBeat.i(194963);
    this.dJP = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(194963);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aq
 * JD-Core Version:    0.7.0.1
 */