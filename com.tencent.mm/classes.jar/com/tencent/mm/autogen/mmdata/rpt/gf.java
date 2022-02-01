package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gf
  extends a
{
  public int iBK;
  public String iBL = "";
  public int iBM;
  public int iBN;
  public int iKH;
  public int iKI;
  public String iKJ = "";
  public int iKK;
  public int imW;
  public String inx = "";
  public String ioY = "";
  public String iuQ = "";
  public int iuv;
  public String ixK = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367958);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367958);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367968);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.ioY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.iuQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestType:").append(this.iKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.iKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.iBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.iBM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.iBN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.iBK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchSessionid:").append(this.iKJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iuv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.iKK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367968);
    return localObject;
  }
  
  public final int getId()
  {
    return 18690;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gf
 * JD-Core Version:    0.7.0.1
 */