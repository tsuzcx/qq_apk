package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cm
  extends a
{
  public String dRA;
  public String dRB;
  public String dRC;
  public String dRy;
  public String dRz;
  
  public final String PV()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRC);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.dRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.dRz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.dRA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.dRC);
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
 * Qualified Name:     com.tencent.mm.g.b.a.cm
 * JD-Core Version:    0.7.0.1
 */