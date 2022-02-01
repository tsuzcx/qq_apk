package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ny
  extends a
{
  private String fgl = "";
  private long fgn;
  private long fgo;
  private String fgq = "";
  private String fiM = "";
  
  public final ny Be(String paramString)
  {
    AppMethodBeat.i(226120);
    this.fgl = x("session", paramString, true);
    AppMethodBeat.o(226120);
    return this;
  }
  
  public final ny Bf(String paramString)
  {
    AppMethodBeat.i(226121);
    this.fiM = x("weapp_ID", paramString, true);
    AppMethodBeat.o(226121);
    return this;
  }
  
  public final ny Bg(String paramString)
  {
    AppMethodBeat.i(226122);
    this.fgq = x("weapp_name", paramString, true);
    AppMethodBeat.o(226122);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(226123);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fgl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226123);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.fgl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_sum:").append(this.fgn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_index:").append(this.fgo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_ID:").append(this.fiM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.fgq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226124);
    return localObject;
  }
  
  public final int getId()
  {
    return 21776;
  }
  
  public final ny yt(long paramLong)
  {
    this.fgn = paramLong;
    return this;
  }
  
  public final ny yu(long paramLong)
  {
    this.fgo = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ny
 * JD-Core Version:    0.7.0.1
 */