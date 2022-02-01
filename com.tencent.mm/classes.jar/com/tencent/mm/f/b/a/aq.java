package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  private String gjA = "";
  private String gjB = "";
  private long gjC;
  private String gjw = "";
  private long gjx;
  private long gjy;
  private String gjz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209209);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209209);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209210);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontimestampms:").append(this.gjx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("atcion:").append(this.gjy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DailyPaperId:").append(this.gjz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DailyPaperWording:").append(this.gjA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gjB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagClickable:").append(this.gjC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209210);
    return localObject;
  }
  
  public final aq ct(long paramLong)
  {
    AppMethodBeat.i(209202);
    this.gjx = paramLong;
    super.bm("actiontimestampms", this.gjx);
    AppMethodBeat.o(209202);
    return this;
  }
  
  public final aq cu(long paramLong)
  {
    this.gjy = paramLong;
    return this;
  }
  
  public final aq cv(long paramLong)
  {
    this.gjC = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21559;
  }
  
  public final aq jk(String paramString)
  {
    AppMethodBeat.i(209200);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(209200);
    return this;
  }
  
  public final aq jl(String paramString)
  {
    AppMethodBeat.i(209204);
    this.gjz = z("DailyPaperId", paramString, true);
    AppMethodBeat.o(209204);
    return this;
  }
  
  public final aq jm(String paramString)
  {
    AppMethodBeat.i(209205);
    this.gjA = z("DailyPaperWording", paramString, true);
    AppMethodBeat.o(209205);
    return this;
  }
  
  public final aq jn(String paramString)
  {
    AppMethodBeat.i(209207);
    this.gjB = z("SessionBuffer", paramString, true);
    AppMethodBeat.o(209207);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.aq
 * JD-Core Version:    0.7.0.1
 */