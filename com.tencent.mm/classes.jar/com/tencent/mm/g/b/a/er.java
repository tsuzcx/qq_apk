package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  private long dDB = 0L;
  private long dUP = 0L;
  private long dUQ = 0L;
  private String dVs = "";
  public long dVt = 0L;
  private long dVu = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVu);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.dVs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.dVt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.dUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.dVu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final er Rl()
  {
    this.dUQ = 1L;
    return this;
  }
  
  public final er Rm()
  {
    this.dVu = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final er iM(long paramLong)
  {
    this.dDB = paramLong;
    return this;
  }
  
  public final er iN(long paramLong)
  {
    this.dUP = paramLong;
    return this;
  }
  
  public final er ms(String paramString)
  {
    AppMethodBeat.i(118485);
    this.dVs = t("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.er
 * JD-Core Version:    0.7.0.1
 */