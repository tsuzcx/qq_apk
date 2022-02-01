package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends a
{
  public long dFl = 0L;
  private long dFm = 0L;
  public long dFn = 0L;
  public long dFo = 0L;
  public long dFp = 0L;
  public long dFq = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFq);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.dFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.dFm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.dFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.dFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.dFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.dFq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final c PX()
  {
    AppMethodBeat.i(19852);
    c localc = bq(bt.eGO());
    AppMethodBeat.o(19852);
    return localc;
  }
  
  public final c PY()
  {
    AppMethodBeat.i(19854);
    c localc = br(bt.eGO());
    AppMethodBeat.o(19854);
    return localc;
  }
  
  public final c bq(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.dFl = paramLong;
    super.bb("FirstInputTimeStampMs", this.dFl);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final c br(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.dFm = paramLong;
    super.bb("LastInputTimeStampMs", this.dFm);
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