package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class md
  extends a
{
  private long gQR = 0L;
  private long gSP = 0L;
  private String gSf = "";
  private long gSg = 0L;
  private long gwi = 0L;
  
  public final md CG(String paramString)
  {
    AppMethodBeat.i(118521);
    this.gSf = z("StoryId", paramString, true);
    AppMethodBeat.o(118521);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.gSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.gwi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.gQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.gSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.gSP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final int getId()
  {
    return 17090;
  }
  
  public final md wT(long paramLong)
  {
    this.gwi = paramLong;
    return this;
  }
  
  public final md wU(long paramLong)
  {
    this.gQR = paramLong;
    return this;
  }
  
  public final md wV(long paramLong)
  {
    this.gSg = paramLong;
    return this;
  }
  
  public final md wW(long paramLong)
  {
    this.gSP = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.md
 * JD-Core Version:    0.7.0.1
 */