package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fw
  extends a
{
  private long enJ;
  private long enK = 0L;
  private long enL = 0L;
  private String enM = "";
  
  public final String RC()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.enJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.enK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.enL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.enM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final int getId()
  {
    return 18744;
  }
  
  public final fw lc(long paramLong)
  {
    this.enK = paramLong;
    return this;
  }
  
  public final fw ld(long paramLong)
  {
    this.enL = paramLong;
    return this;
  }
  
  public final fw ph(String paramString)
  {
    AppMethodBeat.i(118495);
    this.enM = t("StoryidStr", paramString, true);
    AppMethodBeat.o(118495);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fw
 * JD-Core Version:    0.7.0.1
 */