package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ma
  extends a
{
  private long gQR = 0L;
  private String gSF = "";
  private String gSG = "";
  private long gSg = 0L;
  private long glw = 0L;
  
  public final ma Cy(String paramString)
  {
    AppMethodBeat.i(118512);
    this.gSF = z("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final ma Cz(String paramString)
  {
    AppMethodBeat.i(118513);
    this.gSG = z("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSG);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.gQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.gSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.gSF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.gSG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final long amU()
  {
    return this.glw;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final ma wN(long paramLong)
  {
    this.gQR = paramLong;
    return this;
  }
  
  public final ma wO(long paramLong)
  {
    this.gSg = paramLong;
    return this;
  }
  
  public final ma wP(long paramLong)
  {
    this.glw = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ma
 * JD-Core Version:    0.7.0.1
 */