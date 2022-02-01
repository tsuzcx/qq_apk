package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sd
  extends a
{
  public long ioV;
  public String ipT = "";
  public long ipV;
  public String izT = "";
  public String jrH = "";
  public String jxu = "";
  public String jxv = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368524);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jrH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jxv);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368524);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368528);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppID:").append(this.jrH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.izT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("click_tab_context_id:").append(this.jxu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageResrouceID:").append(this.jxv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368528);
    return localObject;
  }
  
  public final int getId()
  {
    return 22265;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sd
 * JD-Core Version:    0.7.0.1
 */