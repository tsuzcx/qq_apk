package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gg
  extends a
{
  private String iAN = "";
  public String iBL = "";
  public String iBP = "";
  public int iKH;
  public int iKI;
  public int iKL;
  public int iKM;
  public int iKN;
  public String iKO = "";
  public int iKP;
  public String iKQ = "";
  public int iKR;
  public String ijk = "";
  public String ioY = "";
  public int ipH;
  public String iuQ = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367959);
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
    ((StringBuffer)localObject).append(this.iKL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367959);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367969);
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
    ((StringBuffer)localObject).append("ItemPosition:").append(this.iKL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchScene:").append(this.iKM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AccountType:").append(this.iKN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClicktabcontextId:").append(this.iKO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.iKP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchSessionid:").append(this.iKQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchType:").append(this.iKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.iAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hotWordId:").append(this.iBP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367969);
    return localObject;
  }
  
  public final int getId()
  {
    return 22178;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gg
 * JD-Core Version:    0.7.0.1
 */