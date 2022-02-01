package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class y
  extends a
{
  private int dPT;
  private int dSg;
  private String dUA;
  private int dUy;
  private String dUz;
  
  public final String RD()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dUy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final y gS(String paramString)
  {
    AppMethodBeat.i(183916);
    this.dUz = t("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final y gT(String paramString)
  {
    AppMethodBeat.i(183917);
    this.dUA = t("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final y ik(int paramInt)
  {
    this.dPT = paramInt;
    return this;
  }
  
  public final y il(int paramInt)
  {
    this.dSg = paramInt;
    return this;
  }
  
  public final y im(int paramInt)
  {
    this.dUy = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.y
 * JD-Core Version:    0.7.0.1
 */