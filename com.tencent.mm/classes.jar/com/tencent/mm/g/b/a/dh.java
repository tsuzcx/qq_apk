package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  private long dTY;
  private long dTZ = 0L;
  private long dUa = 0L;
  private String dUb;
  
  public final String PV()
  {
    AppMethodBeat.i(118496);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUb);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118496);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Storyid:").append(this.dTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseFriendsCount:").append(this.dTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFriendsCount:").append(this.dUa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryidStr:").append(this.dUb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118497);
    return localObject;
  }
  
  public final dh fS(long paramLong)
  {
    this.dTZ = paramLong;
    return this;
  }
  
  public final dh fT(long paramLong)
  {
    this.dUa = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18744;
  }
  
  public final dh jJ(String paramString)
  {
    AppMethodBeat.i(118495);
    this.dUb = t("StoryidStr", paramString, true);
    AppMethodBeat.o(118495);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dh
 * JD-Core Version:    0.7.0.1
 */