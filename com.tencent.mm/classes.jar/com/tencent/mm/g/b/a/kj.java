package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kj
  extends a
{
  private long eVs = 0L;
  private long eVt = 0L;
  private String eVu = "";
  private long eVv = 0L;
  private String eVw = "";
  private long eVx = 0L;
  private long eVy = 0L;
  private long eVz = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(74990);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eVs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(74990);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(74991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SearchID:").append(this.eVs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommentID:").append(this.eVt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryContent:").append(this.eVu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishType:").append(this.eVv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Behavior:").append(this.eVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxIndex:").append(this.eVx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewSearchID:").append(this.eVy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewRecommentID:").append(this.eVz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74991);
    return localObject;
  }
  
  public final String ain()
  {
    return this.eVw;
  }
  
  public final int getId()
  {
    return 17121;
  }
  
  public final kj th(long paramLong)
  {
    this.eVv = paramLong;
    return this;
  }
  
  public final kj ti(long paramLong)
  {
    this.eVx = paramLong;
    return this;
  }
  
  public final kj tj(long paramLong)
  {
    this.eVy = paramLong;
    return this;
  }
  
  public final kj tk(long paramLong)
  {
    this.eVz = paramLong;
    return this;
  }
  
  public final kj xE(String paramString)
  {
    AppMethodBeat.i(74988);
    this.eVu = x("QueryContent", paramString, true);
    AppMethodBeat.o(74988);
    return this;
  }
  
  public final kj xF(String paramString)
  {
    AppMethodBeat.i(74989);
    this.eVw = x("Behavior", paramString, true);
    AppMethodBeat.o(74989);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kj
 * JD-Core Version:    0.7.0.1
 */