package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  public long dWt;
  private String edR = "";
  public long edS = 0L;
  public long edT = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(184627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edT);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184627);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.edR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.edS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.edT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184628);
    return localObject;
  }
  
  public final int getId()
  {
    return 19353;
  }
  
  public final ci ma(String paramString)
  {
    AppMethodBeat.i(184626);
    this.edR = t("Roomid", paramString, true);
    AppMethodBeat.o(184626);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ci
 * JD-Core Version:    0.7.0.1
 */