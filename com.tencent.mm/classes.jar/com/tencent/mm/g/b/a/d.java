package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  extends a
{
  public long dRd = 0L;
  private long dRe = 0L;
  public long dRf = 0L;
  public long dRg = 0L;
  public long dRh = 0L;
  public long dRi = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRi);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.dRd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.dRe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.dRf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.dRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.dRh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.dRi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final d RE()
  {
    AppMethodBeat.i(19852);
    d locald = bn(bu.fpO());
    AppMethodBeat.o(19852);
    return locald;
  }
  
  public final d RF()
  {
    AppMethodBeat.i(19854);
    d locald = bo(bu.fpO());
    AppMethodBeat.o(19854);
    return locald;
  }
  
  public final d bn(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.dRd = paramLong;
    super.bh("FirstInputTimeStampMs", this.dRd);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final d bo(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.dRe = paramLong;
    super.bh("LastInputTimeStampMs", this.dRe);
    AppMethodBeat.o(19853);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.d
 * JD-Core Version:    0.7.0.1
 */