package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eu
  extends a
{
  private String ekb = "";
  public long ekd = 0L;
  public long eke;
  public long ekf = 0L;
  public long ekg = 0L;
  public long ekh;
  public long eki;
  private String ekj = "";
  
  public final String RC()
  {
    AppMethodBeat.i(193975);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekj);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(193975);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(193976);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.ekb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrigInvitedUV:").append(this.eke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailUV:").append(this.ekf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Opt:").append(this.ekg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUV:").append(this.ekh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalResult:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.ekd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsers:").append(this.ekj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193976);
    return localObject;
  }
  
  public final int getId()
  {
    return 20542;
  }
  
  public final eu or(String paramString)
  {
    AppMethodBeat.i(193973);
    this.ekb = t("RoomId", paramString, true);
    AppMethodBeat.o(193973);
    return this;
  }
  
  public final eu os(String paramString)
  {
    AppMethodBeat.i(193974);
    this.ekj = t("ToUsers", paramString, true);
    AppMethodBeat.o(193974);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eu
 * JD-Core Version:    0.7.0.1
 */