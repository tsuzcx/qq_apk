package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  private int geN;
  private int ggl;
  private int glt;
  private String glu = "";
  private String glv = "";
  
  public final String agH()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glt);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.glu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.glv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.glt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final az jw(String paramString)
  {
    AppMethodBeat.i(183916);
    this.glu = z("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final az jx(String paramString)
  {
    AppMethodBeat.i(183917);
    this.glv = z("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
  
  public final az ln(int paramInt)
  {
    this.geN = paramInt;
    return this;
  }
  
  public final az lo(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final az lp(int paramInt)
  {
    this.glt = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.az
 * JD-Core Version:    0.7.0.1
 */