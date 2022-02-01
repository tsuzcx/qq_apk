package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fs
  extends a
{
  private long dRO = 0L;
  private long emO = 0L;
  private long emP = 0L;
  private String ens = "";
  public long ent = 0L;
  private long enu = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ens);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ent);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enu);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dRO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.ens);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.ent);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.emP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.enu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final fs Ty()
  {
    this.emP = 1L;
    return this;
  }
  
  public final fs Tz()
  {
    this.enu = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final fs kJ(long paramLong)
  {
    this.dRO = paramLong;
    return this;
  }
  
  public final fs kK(long paramLong)
  {
    this.emO = paramLong;
    return this;
  }
  
  public final fs pa(String paramString)
  {
    AppMethodBeat.i(118485);
    this.ens = t("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fs
 * JD-Core Version:    0.7.0.1
 */