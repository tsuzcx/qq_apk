package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  private int eki;
  private int enq;
  private int eqh;
  private String eqi = "";
  private String eqj = "";
  
  public final String abV()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqh);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.eqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.eqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.eqh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final ar iv(String paramString)
  {
    AppMethodBeat.i(183916);
    this.eqi = x("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final ar iw(String paramString)
  {
    AppMethodBeat.i(183917);
    this.eqj = x("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
  
  public final ar jT(int paramInt)
  {
    this.eki = paramInt;
    return this;
  }
  
  public final ar jU(int paramInt)
  {
    this.enq = paramInt;
    return this;
  }
  
  public final ar jV(int paramInt)
  {
    this.eqh = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ar
 * JD-Core Version:    0.7.0.1
 */