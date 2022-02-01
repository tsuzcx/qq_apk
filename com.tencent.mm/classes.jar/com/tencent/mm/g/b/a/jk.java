package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jk
  extends a
{
  private long eRp;
  private long eRq = 0L;
  private long eRr = 0L;
  private String eRs = "";
  
  public final String abV()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eRp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRs);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.eRp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.eRq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.eRr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.eRs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final int getId()
  {
    return 18744;
  }
  
  public final jk se(long paramLong)
  {
    this.eRq = paramLong;
    return this;
  }
  
  public final jk sf(long paramLong)
  {
    this.eRr = paramLong;
    return this;
  }
  
  public final jk wQ(String paramString)
  {
    AppMethodBeat.i(118495);
    this.eRs = x("StoryidStr", paramString, true);
    AppMethodBeat.o(118495);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jk
 * JD-Core Version:    0.7.0.1
 */