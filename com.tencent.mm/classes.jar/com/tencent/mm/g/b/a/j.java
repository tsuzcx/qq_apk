package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends a
{
  public long ekc = 0L;
  private long ekd = 0L;
  public long eke = 0L;
  public long ekf = 0L;
  public long ekg = 0L;
  public long ekh = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekh);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.ekc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.ekd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.eke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.ekf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.ekg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.ekh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final j abX()
  {
    AppMethodBeat.i(19852);
    j localj = bK(Util.nowMilliSecond());
    AppMethodBeat.o(19852);
    return localj;
  }
  
  public final j abY()
  {
    AppMethodBeat.i(19854);
    j localj = bL(Util.nowMilliSecond());
    AppMethodBeat.o(19854);
    return localj;
  }
  
  public final j bK(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.ekc = paramLong;
    super.bj("FirstInputTimeStampMs", this.ekc);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final j bL(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.ekd = paramLong;
    super.bj("LastInputTimeStampMs", this.ekd);
    AppMethodBeat.o(19853);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.j
 * JD-Core Version:    0.7.0.1
 */