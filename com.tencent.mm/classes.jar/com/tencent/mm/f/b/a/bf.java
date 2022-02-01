package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  public String gcU = "";
  public long giq = 0L;
  public String giz = "";
  public String glQ = "";
  public String glR = "";
  public long glS;
  
  public final String agH()
  {
    AppMethodBeat.i(211735);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glS);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211735);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211738);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.glQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DocId:").append(this.glR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.giz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.glS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211738);
    return localObject;
  }
  
  public final int getId()
  {
    return 22411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bf
 * JD-Core Version:    0.7.0.1
 */