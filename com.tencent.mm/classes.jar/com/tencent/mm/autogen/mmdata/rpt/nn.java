package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nn
  extends a
{
  public String iVg = "";
  public String jfn = "";
  public String jfo = "";
  public String jfp = "";
  public String jfq = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.iVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.jfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.jfo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.jfp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.jfq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94835);
    return localObject;
  }
  
  public final int getId()
  {
    return 18670;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nn
 * JD-Core Version:    0.7.0.1
 */