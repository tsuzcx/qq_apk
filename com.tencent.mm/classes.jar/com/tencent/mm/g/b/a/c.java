package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends a
{
  public long dCY = 0L;
  private long dCZ = 0L;
  public long dDa = 0L;
  public long dDb = 0L;
  public long dDc = 0L;
  public long dDd = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDd);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.dCY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.dCZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.dDa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.dDb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.dDc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.dDd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final c PT()
  {
    AppMethodBeat.i(19852);
    c localc = bn(bs.eWj());
    AppMethodBeat.o(19852);
    return localc;
  }
  
  public final c PU()
  {
    AppMethodBeat.i(19854);
    c localc = bo(bs.eWj());
    AppMethodBeat.o(19854);
    return localc;
  }
  
  public final c bn(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.dCY = paramLong;
    super.bd("FirstInputTimeStampMs", this.dCY);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final c bo(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.dCZ = paramLong;
    super.bd("LastInputTimeStampMs", this.dCZ);
    AppMethodBeat.o(19853);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */