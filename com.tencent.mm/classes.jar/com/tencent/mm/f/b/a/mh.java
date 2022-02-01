package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mh
  extends a
{
  public String gFT = "";
  private String gIs = "";
  public String gTp = "";
  public long gTq = 0L;
  public String gTr = "";
  private int gTs;
  public String gTt = "";
  public String gTu = "";
  public long gTv;
  public long gTw;
  public String gTx = "";
  public String gcU = "";
  public String gfa = "";
  public long giq = 0L;
  public long gzP = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(226064);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(226064);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(226076);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Word:").append(this.gTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.gIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.gzP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.gFT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalCount:").append(this.gTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.gTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.gTs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocalSearch:").append(this.gTt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.gTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordType:").append(this.gTv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.gTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecSessionId:").append(this.gTx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.gfa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226076);
    return localObject;
  }
  
  public final int getId()
  {
    return 10994;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mh
 * JD-Core Version:    0.7.0.1
 */