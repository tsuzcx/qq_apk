package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ea
  extends a
{
  public String dTm;
  public String dTn;
  public String dTo;
  public String dTp;
  public String dTq;
  
  public final String PR()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTq);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.dTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.dTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.dTo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.dTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.dTq);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ea
 * JD-Core Version:    0.7.0.1
 */