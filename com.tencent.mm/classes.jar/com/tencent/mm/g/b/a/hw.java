package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  private String erZ = "";
  public long euT = 0L;
  public long euV = 0L;
  public long euW = 0L;
  public long euX = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euT);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.euV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.euW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.euX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.euT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
  
  public final hw qW(String paramString)
  {
    AppMethodBeat.i(43480);
    this.erZ = t("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hw
 * JD-Core Version:    0.7.0.1
 */