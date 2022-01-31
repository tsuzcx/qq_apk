package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends a
{
  public long cOi = 0L;
  private long cOj = 0L;
  public long cOk = 0L;
  public long cOl = 0L;
  public long cOm = 0L;
  public long cOn = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(15821);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cOi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOn);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(15821);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(15822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FirstInputTimeStampMs:").append(this.cOi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastInputTimeStampMs:").append(this.cOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendStampMs:").append(this.cOk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCount:").append(this.cOl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextLength:").append(this.cOm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiCount:").append(this.cOn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(15822);
    return localObject;
  }
  
  public final b Fh()
  {
    AppMethodBeat.i(15818);
    b localb = aI(bo.aoy());
    AppMethodBeat.o(15818);
    return localb;
  }
  
  public final b Fi()
  {
    AppMethodBeat.i(15820);
    b localb = aJ(bo.aoy());
    AppMethodBeat.o(15820);
    return localb;
  }
  
  public final b aI(long paramLong)
  {
    AppMethodBeat.i(15817);
    this.cOi = paramLong;
    super.az("FirstInputTimeStampMs", this.cOi);
    AppMethodBeat.o(15817);
    return this;
  }
  
  public final b aJ(long paramLong)
  {
    AppMethodBeat.i(15819);
    this.cOj = paramLong;
    super.az("LastInputTimeStampMs", this.cOj);
    AppMethodBeat.o(15819);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.b
 * JD-Core Version:    0.7.0.1
 */