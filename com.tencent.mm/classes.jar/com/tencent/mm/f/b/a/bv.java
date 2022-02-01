package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bv
  extends a
{
  private String gjw = "";
  private long gnP;
  private long goe;
  private long gof;
  
  public final String agH()
  {
    AppMethodBeat.i(208711);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gof);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208711);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208712);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Followcount:").append(this.gof);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208712);
    return localObject;
  }
  
  public final bv ahp()
  {
    this.goe = 0L;
    return this;
  }
  
  public final bv ei(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final bv ej(long paramLong)
  {
    this.gof = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21345;
  }
  
  public final bv lp(String paramString)
  {
    AppMethodBeat.i(208709);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(208709);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bv
 * JD-Core Version:    0.7.0.1
 */