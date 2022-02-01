package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  public long dPU = 0L;
  private String dPV = "";
  
  public final String PV()
  {
    AppMethodBeat.i(149928);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149928);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.dPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.dPV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149929);
    return localObject;
  }
  
  public final int getId()
  {
    return 16868;
  }
  
  public final bs ip(String paramString)
  {
    AppMethodBeat.i(162225);
    this.dPV = t("emoticonMd5", paramString, true);
    AppMethodBeat.o(162225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bs
 * JD-Core Version:    0.7.0.1
 */