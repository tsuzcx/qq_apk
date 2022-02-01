package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jg
  extends a
{
  private String eQY = "";
  public long eQZ = 0L;
  private long eQv = 0L;
  private long eQw = 0L;
  private long eRa = 0L;
  private long elI = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRa);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.elI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.eQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.eQY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.eQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.eQw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.eRa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final jg ahn()
  {
    this.eQw = 1L;
    return this;
  }
  
  public final jg aho()
  {
    this.eRa = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final jg rL(long paramLong)
  {
    this.elI = paramLong;
    return this;
  }
  
  public final jg rM(long paramLong)
  {
    this.eQv = paramLong;
    return this;
  }
  
  public final jg wJ(String paramString)
  {
    AppMethodBeat.i(118485);
    this.eQY = x("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jg
 * JD-Core Version:    0.7.0.1
 */