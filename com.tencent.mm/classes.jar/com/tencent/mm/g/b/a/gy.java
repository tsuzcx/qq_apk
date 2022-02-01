package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gy
  extends a
{
  private long egh;
  private String erZ = "";
  private String esa = "";
  private long esk;
  private String esl = "";
  private String esm = "";
  private long esn;
  private long eso;
  
  public final String RC()
  {
    AppMethodBeat.i(221932);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eso);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221932);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221933);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.esk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.esl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.egh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.esm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.esn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.eso);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221933);
    return localObject;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final gy mr(long paramLong)
  {
    this.esk = paramLong;
    return this;
  }
  
  public final gy ms(long paramLong)
  {
    this.egh = paramLong;
    return this;
  }
  
  public final gy mt(long paramLong)
  {
    this.esn = paramLong;
    return this;
  }
  
  public final gy mu(long paramLong)
  {
    this.eso = paramLong;
    return this;
  }
  
  public final gy qg(String paramString)
  {
    AppMethodBeat.i(221928);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(221928);
    return this;
  }
  
  public final gy qh(String paramString)
  {
    AppMethodBeat.i(221929);
    this.erZ = t("Appid", paramString, true);
    AppMethodBeat.o(221929);
    return this;
  }
  
  public final gy qi(String paramString)
  {
    AppMethodBeat.i(221930);
    this.esl = t("EventName", paramString, true);
    AppMethodBeat.o(221930);
    return this;
  }
  
  public final gy qj(String paramString)
  {
    AppMethodBeat.i(221931);
    this.esm = t("Parent", paramString, true);
    AppMethodBeat.o(221931);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gy
 * JD-Core Version:    0.7.0.1
 */