package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es
  extends a
{
  private String eir;
  public long eit = 0L;
  public long eiu;
  public long eiv = 0L;
  public long eiw = 0L;
  public long eix;
  public long eiy;
  private String eiz = "";
  
  public final String RD()
  {
    AppMethodBeat.i(207382);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eir);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eix);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eit);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiz);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(207382);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(207383);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.eir);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrigInvitedUV:").append(this.eiu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailUV:").append(this.eiv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Opt:").append(this.eiw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUV:").append(this.eix);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalResult:").append(this.eiy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.eit);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsers:").append(this.eiz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207383);
    return localObject;
  }
  
  public final int getId()
  {
    return 20542;
  }
  
  public final es nW(String paramString)
  {
    AppMethodBeat.i(207380);
    this.eir = t("RoomId", paramString, true);
    AppMethodBeat.o(207380);
    return this;
  }
  
  public final es nX(String paramString)
  {
    AppMethodBeat.i(207381);
    this.eiz = t("ToUsers", paramString, true);
    AppMethodBeat.o(207381);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.es
 * JD-Core Version:    0.7.0.1
 */