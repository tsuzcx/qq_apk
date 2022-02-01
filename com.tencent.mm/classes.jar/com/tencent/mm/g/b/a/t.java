package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  private int dJp;
  private int dJs;
  private String dJt;
  private int dJu;
  private String dJv;
  
  public final String PV()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJs);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dJt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dJs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final t fZ(String paramString)
  {
    AppMethodBeat.i(183916);
    this.dJt = t("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final t ga(String paramString)
  {
    AppMethodBeat.i(183917);
    this.dJv = t("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final t ip(int paramInt)
  {
    this.dJp = paramInt;
    return this;
  }
  
  public final t iq(int paramInt)
  {
    this.dJu = paramInt;
    return this;
  }
  
  public final t ir(int paramInt)
  {
    this.dJs = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.t
 * JD-Core Version:    0.7.0.1
 */