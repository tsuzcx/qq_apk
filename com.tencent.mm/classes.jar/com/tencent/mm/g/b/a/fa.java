package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  public String elg = "";
  public String elh = "";
  public String eli = "";
  public String elj = "";
  public String elk = "";
  
  public final String RC()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eli);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elk);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.elg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.elh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.eli);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.elj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.elk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94835);
    return localObject;
  }
  
  public final int getId()
  {
    return 18670;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa
 * JD-Core Version:    0.7.0.1
 */