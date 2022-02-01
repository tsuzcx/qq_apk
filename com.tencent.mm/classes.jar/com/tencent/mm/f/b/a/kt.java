package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kt
  extends a
{
  public String gOX = "";
  public String gOY = "";
  public String gOZ = "";
  public String gPa = "";
  public String gPb = "";
  
  public final String agH()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gOX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPb);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.gOX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.gOY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.gOZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.gPa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.gPb);
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
 * Qualified Name:     com.tencent.mm.f.b.a.kt
 * JD-Core Version:    0.7.0.1
 */