package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ot
  extends a
{
  private long jkh;
  public long jki = 0L;
  public long jkj = 0L;
  public String jkk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jkh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.jkh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.jki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.jkj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.jkk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final int getId()
  {
    return 18744;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ot
 * JD-Core Version:    0.7.0.1
 */