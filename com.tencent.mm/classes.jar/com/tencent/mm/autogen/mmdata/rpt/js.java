package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class js
  extends a
{
  public long iUA;
  public String iUB = "";
  public long iUC;
  public long iUD;
  public long iUz;
  public String inx = "";
  public String iny = "";
  public String ipU = "";
  public String izY = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368970);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUA);
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
    ((StringBuffer)localObject).append(this.iUD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368970);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368978);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpType:").append(this.iUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpScene:").append(this.iUA);
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
    ((StringBuffer)localObject).append("ifPictureInPicture:").append(this.iUD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368978);
    return localObject;
  }
  
  public final int getId()
  {
    return 21155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.js
 * JD-Core Version:    0.7.0.1
 */