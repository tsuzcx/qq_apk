package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cd
  extends a
{
  public long dQB;
  public String dTA = "";
  public String dTu = "";
  public String dTx = "";
  public String dTy = "";
  public long dWt;
  public long edp;
  public String edq = "";
  public String edr = "";
  public long eds;
  public long edt;
  public long edu;
  
  public final String RC()
  {
    AppMethodBeat.i(188460);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eds);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edu);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(188460);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(188461);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasReddot:").append(this.edp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordList:").append(this.edq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordVersion:").append(this.edr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.dTx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.dTy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.eds);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.dTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.edt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgContentLength:").append(this.edu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188461);
    return localObject;
  }
  
  public final int getId()
  {
    return 20257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cd
 * JD-Core Version:    0.7.0.1
 */