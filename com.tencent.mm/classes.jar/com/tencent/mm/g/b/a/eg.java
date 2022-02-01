package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eg
  extends a
{
  public long dTO;
  public long dWm;
  private String eeX = "";
  public long eiW;
  private long ejt;
  private String eju = "";
  private String ejv = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.eeX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final eg Tp()
  {
    this.ejt = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
  
  public final eg nQ(String paramString)
  {
    AppMethodBeat.i(184767);
    this.eeX = t("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final eg nR(String paramString)
  {
    AppMethodBeat.i(184768);
    this.eju = t("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
  
  public final eg nS(String paramString)
  {
    AppMethodBeat.i(217087);
    this.ejv = t("appusername", paramString, true);
    AppMethodBeat.o(217087);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eg
 * JD-Core Version:    0.7.0.1
 */