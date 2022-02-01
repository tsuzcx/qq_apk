package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gg
  extends a
{
  private long eaH = 0L;
  private long emO = 0L;
  private long eoQ = 0L;
  private String eoe = "";
  private long eog = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eog);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoQ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.eoe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.eaH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.eog);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.eoQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final int getId()
  {
    return 17090;
  }
  
  public final gg lQ(long paramLong)
  {
    this.eaH = paramLong;
    return this;
  }
  
  public final gg lR(long paramLong)
  {
    this.emO = paramLong;
    return this;
  }
  
  public final gg lS(long paramLong)
  {
    this.eog = paramLong;
    return this;
  }
  
  public final gg lT(long paramLong)
  {
    this.eoQ = paramLong;
    return this;
  }
  
  public final gg px(String paramString)
  {
    AppMethodBeat.i(118521);
    this.eoe = t("StoryId", paramString, true);
    AppMethodBeat.o(118521);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gg
 * JD-Core Version:    0.7.0.1
 */