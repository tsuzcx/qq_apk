package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jy
  extends a
{
  public long eDd = 0L;
  public String eHs = "";
  private String ePe = "";
  public String eSU = "";
  public long eSV = 0L;
  public String eSW = "";
  private int eSX;
  public String eSY = "";
  public String eSZ = "";
  public long eTa;
  public long eTb;
  public String eTc = "";
  public String eiB = "";
  public String ekv = "";
  public long enl = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(199747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekv);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(199747);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(199748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Word:").append(this.eSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.ePe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.eDd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.eHs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalCount:").append(this.eSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.eSW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.eSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocalSearch:").append(this.eSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.eSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordType:").append(this.eTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.eTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecSessionId:").append(this.eTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.ekv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199748);
    return localObject;
  }
  
  public final int getId()
  {
    return 10994;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jy
 * JD-Core Version:    0.7.0.1
 */