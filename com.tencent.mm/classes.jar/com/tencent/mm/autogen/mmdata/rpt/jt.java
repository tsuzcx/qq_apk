package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jt
  extends a
{
  public String iUB = "";
  public long iUC;
  public String iUE = "";
  public long iUF;
  public long iUG;
  public String inx = "";
  public String iny = "";
  public String ipU = "";
  public String iqk = "";
  public String izY = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368989);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368989);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368994);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.iUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GenerateType:").append(this.iUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GenerateScene:").append(this.iUG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniSessionId:").append(this.iUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskOrder:").append(this.iUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.izY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.iqk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368994);
    return localObject;
  }
  
  public final int getId()
  {
    return 21154;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jt
 * JD-Core Version:    0.7.0.1
 */