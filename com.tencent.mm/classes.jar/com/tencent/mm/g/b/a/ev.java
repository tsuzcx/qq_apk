package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ev
  extends a
{
  private long dVK;
  private long dVL = 0L;
  private long dVM = 0L;
  private String dVN;
  
  public final String PR()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVN);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.dVK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.dVL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.dVM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.dVN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final int getId()
  {
    return 18744;
  }
  
  public final ev jf(long paramLong)
  {
    this.dVL = paramLong;
    return this;
  }
  
  public final ev jg(long paramLong)
  {
    this.dVM = paramLong;
    return this;
  }
  
  public final ev mz(String paramString)
  {
    AppMethodBeat.i(118495);
    this.dVN = t("StoryidStr", paramString, true);
    AppMethodBeat.o(118495);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ev
 * JD-Core Version:    0.7.0.1
 */