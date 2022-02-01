package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ey
  extends a
{
  public String ejA;
  public String ejB;
  public String ejC;
  public String ejD;
  public String ejz;
  
  public final String RD()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.ejB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.ejC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.ejD);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ey
 * JD-Core Version:    0.7.0.1
 */