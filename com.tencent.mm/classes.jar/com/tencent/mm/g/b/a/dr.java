package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dr
  extends a
{
  private long dLs = 0L;
  private long dTd = 0L;
  private String dUu = "";
  private long dUv = 0L;
  private long dVf = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVf);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.dUu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.dLs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.dUv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.dVf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final dr gG(long paramLong)
  {
    this.dLs = paramLong;
    return this;
  }
  
  public final dr gH(long paramLong)
  {
    this.dTd = paramLong;
    return this;
  }
  
  public final dr gI(long paramLong)
  {
    this.dUv = paramLong;
    return this;
  }
  
  public final dr gJ(long paramLong)
  {
    this.dVf = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 17090;
  }
  
  public final dr jY(String paramString)
  {
    AppMethodBeat.i(118521);
    this.dUu = t("StoryId", paramString, true);
    AppMethodBeat.o(118521);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dr
 * JD-Core Version:    0.7.0.1
 */