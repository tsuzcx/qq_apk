package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class v
  extends a
{
  private int dHr;
  private int dHu;
  private String dHv;
  private int dHw;
  private String dHx;
  
  public final String PR()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHu);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dHv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dHx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dHu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final v fQ(String paramString)
  {
    AppMethodBeat.i(183916);
    this.dHv = t("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final v fR(String paramString)
  {
    AppMethodBeat.i(183917);
    this.dHx = t("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final v hZ(int paramInt)
  {
    this.dHr = paramInt;
    return this;
  }
  
  public final v ia(int paramInt)
  {
    this.dHw = paramInt;
    return this;
  }
  
  public final v ib(int paramInt)
  {
    this.dHu = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.v
 * JD-Core Version:    0.7.0.1
 */