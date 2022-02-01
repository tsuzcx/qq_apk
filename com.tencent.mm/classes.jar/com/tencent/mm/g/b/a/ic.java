package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ic
  extends a
{
  private String eMN = "";
  public long eMP = 0L;
  public long eMQ;
  public long eMR = 0L;
  public long eMS = 0L;
  public long eMT;
  public long eMU;
  private String eMV = "";
  
  public final String abV()
  {
    AppMethodBeat.i(187897);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMV);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187897);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187898);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.eMN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrigInvitedUV:").append(this.eMQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailUV:").append(this.eMR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Opt:").append(this.eMS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUV:").append(this.eMT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalResult:").append(this.eMU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.eMP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsers:").append(this.eMV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187898);
    return localObject;
  }
  
  public final int getId()
  {
    return 20542;
  }
  
  public final ic vL(String paramString)
  {
    AppMethodBeat.i(187895);
    this.eMN = x("RoomId", paramString, true);
    AppMethodBeat.o(187895);
    return this;
  }
  
  public final ic vM(String paramString)
  {
    AppMethodBeat.i(187896);
    this.eMV = x("ToUsers", paramString, true);
    AppMethodBeat.o(187896);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ic
 * JD-Core Version:    0.7.0.1
 */