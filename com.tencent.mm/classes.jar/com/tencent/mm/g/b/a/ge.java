package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ge
  extends a
{
  private long dZo = 0L;
  private long elh = 0L;
  private String emw = "";
  private long emx = 0L;
  private long eni = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eni);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.emw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.dZo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.elh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.eni);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final int getId()
  {
    return 17090;
  }
  
  public final ge lF(long paramLong)
  {
    this.dZo = paramLong;
    return this;
  }
  
  public final ge lG(long paramLong)
  {
    this.elh = paramLong;
    return this;
  }
  
  public final ge lH(long paramLong)
  {
    this.emx = paramLong;
    return this;
  }
  
  public final ge lI(long paramLong)
  {
    this.eni = paramLong;
    return this;
  }
  
  public final ge pb(String paramString)
  {
    AppMethodBeat.i(118521);
    this.emw = t("StoryId", paramString, true);
    AppMethodBeat.o(118521);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ge
 * JD-Core Version:    0.7.0.1
 */