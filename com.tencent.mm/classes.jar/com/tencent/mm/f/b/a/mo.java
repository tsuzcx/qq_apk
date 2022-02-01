package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mo
  extends a
{
  private long gBe;
  private int gUy;
  private int gUz;
  private long gef;
  private String gjO = "";
  
  public final mo Dg(String paramString)
  {
    AppMethodBeat.i(232655);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(232655);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(232674);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUz);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(232674);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(232676);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasMoreFriendsButton:").append(this.gUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreFriendButtonNum:").append(this.gUz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(232676);
    return localObject;
  }
  
  public final int getId()
  {
    return 22662;
  }
  
  public final mo nS(int paramInt)
  {
    this.gUy = paramInt;
    return this;
  }
  
  public final mo nT(int paramInt)
  {
    this.gUz = paramInt;
    return this;
  }
  
  public final mo yg(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final mo yh(long paramLong)
  {
    this.gBe = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mo
 * JD-Core Version:    0.7.0.1
 */