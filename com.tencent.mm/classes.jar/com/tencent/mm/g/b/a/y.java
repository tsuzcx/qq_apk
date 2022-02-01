package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class y
  extends a
{
  private int dRj;
  private int dTw;
  private int dVO;
  private String dVP = "";
  private String dVQ = "";
  
  public final String RC()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVO);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dVQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dVO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final y gY(String paramString)
  {
    AppMethodBeat.i(183916);
    this.dVP = t("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final y gZ(String paramString)
  {
    AppMethodBeat.i(183917);
    this.dVQ = t("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final y im(int paramInt)
  {
    this.dRj = paramInt;
    return this;
  }
  
  public final y in(int paramInt)
  {
    this.dTw = paramInt;
    return this;
  }
  
  public final y io(int paramInt)
  {
    this.dVO = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.y
 * JD-Core Version:    0.7.0.1
 */