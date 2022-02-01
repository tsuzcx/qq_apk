package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ff
  extends a
{
  private long dLe = 0L;
  private long dUP = 0L;
  private long dWR = 0L;
  private String dWg = "";
  private long dWh = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWR);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.dWg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.dWR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final int getId()
  {
    return 17090;
  }
  
  public final ff jT(long paramLong)
  {
    this.dLe = paramLong;
    return this;
  }
  
  public final ff jU(long paramLong)
  {
    this.dUP = paramLong;
    return this;
  }
  
  public final ff jV(long paramLong)
  {
    this.dWh = paramLong;
    return this;
  }
  
  public final ff jW(long paramLong)
  {
    this.dWR = paramLong;
    return this;
  }
  
  public final ff mO(String paramString)
  {
    AppMethodBeat.i(118521);
    this.dWg = t("StoryId", paramString, true);
    AppMethodBeat.o(118521);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ff
 * JD-Core Version:    0.7.0.1
 */