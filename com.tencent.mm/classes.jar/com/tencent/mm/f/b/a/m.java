package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  extends a
{
  public long geH = 0L;
  private long geI = 0L;
  public long geJ = 0L;
  public long geK = 0L;
  public long geL = 0L;
  public long geM = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.geH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.geI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.geJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.geK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.geL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.geM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final m agK()
  {
    AppMethodBeat.i(19852);
    m localm = bZ(Util.nowMilliSecond());
    AppMethodBeat.o(19852);
    return localm;
  }
  
  public final m agL()
  {
    AppMethodBeat.i(19854);
    m localm = ca(Util.nowMilliSecond());
    AppMethodBeat.o(19854);
    return localm;
  }
  
  public final m bZ(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.geH = paramLong;
    super.bm("FirstInputTimeStampMs", this.geH);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final m ca(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.geI = paramLong;
    super.bm("LastInputTimeStampMs", this.geI);
    AppMethodBeat.o(19853);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.m
 * JD-Core Version:    0.7.0.1
 */