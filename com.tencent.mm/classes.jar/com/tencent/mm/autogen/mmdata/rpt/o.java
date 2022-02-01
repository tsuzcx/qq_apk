package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
  extends a
{
  public long ilg = 0L;
  private long ilh = 0L;
  public long ili = 0L;
  public long ilj = 0L;
  public long ilk = 0L;
  public long ill = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(19855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ili);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ill);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(19855);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(19856);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.ilg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.ilh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.ili);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.ilj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.ilk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.ill);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19856);
    return localObject;
  }
  
  public final o aIG()
  {
    AppMethodBeat.i(19852);
    o localo = eq(Util.nowMilliSecond());
    AppMethodBeat.o(19852);
    return localo;
  }
  
  public final o aIH()
  {
    AppMethodBeat.i(19854);
    o localo = er(Util.nowMilliSecond());
    AppMethodBeat.o(19854);
    return localo;
  }
  
  public final o eq(long paramLong)
  {
    AppMethodBeat.i(19851);
    this.ilg = paramLong;
    super.by("FirstInputTimeStampMs", this.ilg);
    AppMethodBeat.o(19851);
    return this;
  }
  
  public final o er(long paramLong)
  {
    AppMethodBeat.i(19853);
    this.ilh = paramLong;
    super.by("LastInputTimeStampMs", this.ilh);
    AppMethodBeat.o(19853);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.o
 * JD-Core Version:    0.7.0.1
 */