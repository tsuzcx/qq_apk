package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ju
  extends a
{
  private long eAl = 0L;
  private long eQv = 0L;
  private String eRJ = "";
  private long eRK = 0L;
  private long eSu = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.eRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.eAl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.eQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.eRK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.eSu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final int getId()
  {
    return 17090;
  }
  
  public final ju sS(long paramLong)
  {
    this.eAl = paramLong;
    return this;
  }
  
  public final ju sT(long paramLong)
  {
    this.eQv = paramLong;
    return this;
  }
  
  public final ju sU(long paramLong)
  {
    this.eRK = paramLong;
    return this;
  }
  
  public final ju sV(long paramLong)
  {
    this.eSu = paramLong;
    return this;
  }
  
  public final ju xf(String paramString)
  {
    AppMethodBeat.i(118521);
    this.eRJ = x("StoryId", paramString, true);
    AppMethodBeat.o(118521);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ju
 * JD-Core Version:    0.7.0.1
 */