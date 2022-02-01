package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class il
  extends a
{
  public String eOG = "";
  public String eOH = "";
  public String eOI = "";
  public String eOJ = "";
  public String eOK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(94834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94834);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.eOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentIdList:").append(this.eOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiIdList:").append(this.eOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIconIdList:").append(this.eOJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickEmojiIdList:").append(this.eOK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94835);
    return localObject;
  }
  
  public final int getId()
  {
    return 18670;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.il
 * JD-Core Version:    0.7.0.1
 */