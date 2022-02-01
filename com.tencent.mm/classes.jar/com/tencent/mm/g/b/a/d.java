package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends a
{
  public long dPN = 0L;
  private long dPO = 0L;
  public long dPP = 0L;
  public long dPQ = 0L;
  public long dPR = 0L;
  public long dPS = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPS);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.dPN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.dPO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.dPP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.dPQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.dPR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.dPS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final d RF()
  {
    AppMethodBeat.i(19852);
    d locald = bn(bt.flT());
    AppMethodBeat.o(19852);
    return locald;
  }
  
  public final d RG()
  {
    AppMethodBeat.i(19854);
    d locald = bo(bt.flT());
    AppMethodBeat.o(19854);
    return locald;
  }
  
  public final d bn(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.dPN = paramLong;
    super.bg("FirstInputTimeStampMs", this.dPN);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final d bo(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.dPO = paramLong;
    super.bg("LastInputTimeStampMs", this.dPO);
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