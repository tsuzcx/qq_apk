package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lp
  extends a
{
  private long gQR = 0L;
  private long gQS = 0L;
  private String gRu = "";
  public long gRv = 0L;
  private long gRw = 0L;
  private long ggQ = 0L;
  
  public final lp Ck(String paramString)
  {
    AppMethodBeat.i(118485);
    this.gRu = z("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRw);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.ggQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.gQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.gRu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.gRv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.gQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.gRw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final lp amJ()
  {
    this.gQS = 1L;
    return this;
  }
  
  public final lp amK()
  {
    this.gRw = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final lp vN(long paramLong)
  {
    this.ggQ = paramLong;
    return this;
  }
  
  public final lp vO(long paramLong)
  {
    this.gQR = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lp
 * JD-Core Version:    0.7.0.1
 */