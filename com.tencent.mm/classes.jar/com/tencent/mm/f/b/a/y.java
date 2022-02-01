package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class y
  extends a
{
  private long gef;
  private String ggg = "";
  private long ggh;
  private long ggi;
  private long ggj;
  private long ggk;
  
  public final String agH()
  {
    AppMethodBeat.i(288827);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggk);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(288827);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(288829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.ggh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.ggi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("abcClickCount:").append(this.ggj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSearch:").append(this.ggk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(288829);
    return localObject;
  }
  
  public final y cg(long paramLong)
  {
    this.ggh = paramLong;
    return this;
  }
  
  public final y ch(long paramLong)
  {
    this.ggi = paramLong;
    return this;
  }
  
  public final y ci(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final y cj(long paramLong)
  {
    this.ggj = paramLong;
    return this;
  }
  
  public final y ck(long paramLong)
  {
    this.ggk = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 22597;
  }
  
  public final y iN(String paramString)
  {
    AppMethodBeat.i(288825);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(288825);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.y
 * JD-Core Version:    0.7.0.1
 */