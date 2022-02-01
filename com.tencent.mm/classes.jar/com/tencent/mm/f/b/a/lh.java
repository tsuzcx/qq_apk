package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lh
  extends a
{
  private String gQA = "";
  public long gQB = 0L;
  private String gQF = "";
  public long gfj = 0L;
  private String ggg = "";
  
  public final lh BY(String paramString)
  {
    AppMethodBeat.i(110286);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final lh BZ(String paramString)
  {
    AppMethodBeat.i(110287);
    this.gQA = z("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final lh Ca(String paramString)
  {
    AppMethodBeat.i(110288);
    this.gQF = z("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.gQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.gfj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.gQF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lh
 * JD-Core Version:    0.7.0.1
 */