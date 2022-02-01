package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oy
  extends a
{
  public long jjE = 0L;
  public long jkO = 0L;
  public long jkP = 0L;
  public long jkQ = 0L;
  public long jkR = 0L;
  public long jkS = 0L;
  public long jkT = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jkO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.jkO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.jkP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.jkQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.jkR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.jkS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.jjE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.jkT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final int getId()
  {
    return 16844;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oy
 * JD-Core Version:    0.7.0.1
 */