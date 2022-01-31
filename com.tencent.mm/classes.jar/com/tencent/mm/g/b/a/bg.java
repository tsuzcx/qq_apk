package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bg
  extends a
{
  private long cVa = 0L;
  private long cWZ = 0L;
  private String cWo = "";
  private long cWp = 0L;
  private long cXa = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(138742);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXa);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(138742);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(138743);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.cWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.cWZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.cVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.cWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.cXa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(138743);
    return localObject;
  }
  
  public final bg dl(long paramLong)
  {
    this.cWZ = paramLong;
    return this;
  }
  
  public final bg dm(long paramLong)
  {
    this.cVa = paramLong;
    return this;
  }
  
  public final bg dn(long paramLong)
  {
    this.cWp = paramLong;
    return this;
  }
  
  public final bg jdMethod_do(long paramLong)
  {
    this.cXa = paramLong;
    return this;
  }
  
  public final bg gA(String paramString)
  {
    AppMethodBeat.i(138741);
    this.cWo = t("StoryId", paramString, true);
    AppMethodBeat.o(138741);
    return this;
  }
  
  public final int getId()
  {
    return 17090;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bg
 * JD-Core Version:    0.7.0.1
 */