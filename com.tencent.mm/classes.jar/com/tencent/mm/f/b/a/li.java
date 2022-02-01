package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class li
  extends a
{
  public long gQB = 0L;
  private String gQF = "";
  public long gQN = 0L;
  private String ggg = "";
  public long gpu = 0L;
  public long gsS = 0L;
  
  public final li Cb(String paramString)
  {
    AppMethodBeat.i(110291);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(110291);
    return this;
  }
  
  public final li Cc(String paramString)
  {
    AppMethodBeat.i(110292);
    this.gQF = z("Identifier", paramString, true);
    AppMethodBeat.o(110292);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(110293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(110293);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(110294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gpu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.gsS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.gQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.gQF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110294);
    return localObject;
  }
  
  public final int getId()
  {
    return 18256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.li
 * JD-Core Version:    0.7.0.1
 */