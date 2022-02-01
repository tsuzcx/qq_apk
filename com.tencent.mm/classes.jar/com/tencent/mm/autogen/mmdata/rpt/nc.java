package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nc
  extends a
{
  private String jda = "";
  public long jdb = 0L;
  public long jdc;
  public long jdd = 0L;
  public long jde = 0L;
  public long jdf;
  public long jdg;
  private String jdh = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jde);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367952);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367964);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.jda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrigInvitedUV:").append(this.jdc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailUV:").append(this.jdd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Opt:").append(this.jde);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUV:").append(this.jdf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalResult:").append(this.jdg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.jdb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsers:").append(this.jdh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367964);
    return localObject;
  }
  
  public final int getId()
  {
    return 20542;
  }
  
  public final nc vx(String paramString)
  {
    AppMethodBeat.i(367928);
    this.jda = F("RoomId", paramString, true);
    AppMethodBeat.o(367928);
    return this;
  }
  
  public final nc vy(String paramString)
  {
    AppMethodBeat.i(367939);
    this.jdh = F("ToUsers", paramString, true);
    AppMethodBeat.o(367939);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nc
 * JD-Core Version:    0.7.0.1
 */