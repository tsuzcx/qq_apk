package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ez
  extends a
{
  private long gcX;
  private int gzb;
  private long gzc = -1L;
  private String gzd = "";
  private String gze = "";
  private int gzf = -1;
  private String gzg = "";
  private String gzh = "";
  private long gzi = -1L;
  private long gzj = -1L;
  
  public final String agH()
  {
    AppMethodBeat.i(208674);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gzb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gze);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208674);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208675);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("innerversion:").append(this.gzb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.gzc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionName:").append(this.gzd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionExt:").append(this.gze);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.gzf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultExt:").append(this.gzg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.gcX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("snn:").append(this.gzh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cost:").append(this.gzi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTime:").append(this.gzj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208675);
    return localObject;
  }
  
  public final ez akv()
  {
    this.gzb = 8;
    return this;
  }
  
  public final int getId()
  {
    return 22138;
  }
  
  public final ez mL(long paramLong)
  {
    this.gzc = paramLong;
    return this;
  }
  
  public final ez mM(long paramLong)
  {
    this.gcX = paramLong;
    return this;
  }
  
  public final ez mN(long paramLong)
  {
    this.gzi = paramLong;
    return this;
  }
  
  public final ez mO(long paramLong)
  {
    this.gzj = paramLong;
    return this;
  }
  
  public final ez ms(int paramInt)
  {
    this.gzf = paramInt;
    return this;
  }
  
  public final ez tI(String paramString)
  {
    AppMethodBeat.i(208665);
    this.gzd = z("actionName", paramString, true);
    AppMethodBeat.o(208665);
    return this;
  }
  
  public final ez tJ(String paramString)
  {
    AppMethodBeat.i(208666);
    this.gze = z("actionExt", paramString, true);
    AppMethodBeat.o(208666);
    return this;
  }
  
  public final ez tK(String paramString)
  {
    AppMethodBeat.i(208669);
    this.gzg = z("resultExt", paramString, true);
    AppMethodBeat.o(208669);
    return this;
  }
  
  public final ez tL(String paramString)
  {
    AppMethodBeat.i(208671);
    this.gzh = z("snn", paramString, true);
    AppMethodBeat.o(208671);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ez
 * JD-Core Version:    0.7.0.1
 */