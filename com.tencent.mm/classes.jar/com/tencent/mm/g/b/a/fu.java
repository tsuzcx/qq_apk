package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fu
  extends a
{
  private long emb;
  private long emc = 0L;
  private long emd = 0L;
  private String eme;
  
  public final String RD()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eme);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.emb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.emc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.emd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.eme);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final int getId()
  {
    return 18744;
  }
  
  public final fu kR(long paramLong)
  {
    this.emc = paramLong;
    return this;
  }
  
  public final fu kS(long paramLong)
  {
    this.emd = paramLong;
    return this;
  }
  
  public final fu oM(String paramString)
  {
    AppMethodBeat.i(118495);
    this.eme = t("StoryidStr", paramString, true);
    AppMethodBeat.o(118495);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fu
 * JD-Core Version:    0.7.0.1
 */