package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lt
  extends a
{
  private long gRL;
  private long gRM = 0L;
  private long gRN = 0L;
  private String gRO = "";
  
  public final lt Cr(String paramString)
  {
    AppMethodBeat.i(118495);
    this.gRO = z("StoryidStr", paramString, true);
    AppMethodBeat.o(118495);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gRL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRO);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.gRL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.gRM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.gRN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.gRO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final int getId()
  {
    return 18744;
  }
  
  public final lt wg(long paramLong)
  {
    this.gRM = paramLong;
    return this;
  }
  
  public final lt wh(long paramLong)
  {
    this.gRN = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lt
 * JD-Core Version:    0.7.0.1
 */