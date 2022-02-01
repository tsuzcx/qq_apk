package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fq
  extends a
{
  private long dQy = 0L;
  private String elK = "";
  public long elL = 0L;
  private long elM = 0L;
  private long elh = 0L;
  private long eli = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eli);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elM);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.elh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.elK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.elL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.eli);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.elM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final fq Ts()
  {
    this.eli = 1L;
    return this;
  }
  
  public final fq Tt()
  {
    this.elM = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final fq ky(long paramLong)
  {
    this.dQy = paramLong;
    return this;
  }
  
  public final fq kz(long paramLong)
  {
    this.elh = paramLong;
    return this;
  }
  
  public final fq oF(String paramString)
  {
    AppMethodBeat.i(118485);
    this.elK = t("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fq
 * JD-Core Version:    0.7.0.1
 */