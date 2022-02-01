package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  private String eBd = "";
  private long eBe;
  private String eBf = "";
  private String eiB = "";
  private String eoz = "";
  private String erH = "";
  private String err = "";
  private long ery;
  private long ett;
  
  public final String abV()
  {
    AppMethodBeat.i(209157);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ett);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209157);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeItems:").append(this.eBd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.ett);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFriendLikeCnt:").append(this.eBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterContextId:").append(this.eBf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209158);
    return localObject;
  }
  
  public final int getId()
  {
    return 19955;
  }
  
  public final dq kr(long paramLong)
  {
    this.ett = paramLong;
    return this;
  }
  
  public final dq ks(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final dq kt(long paramLong)
  {
    this.eBe = paramLong;
    return this;
  }
  
  public final dq pu(String paramString)
  {
    AppMethodBeat.i(209151);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209151);
    return this;
  }
  
  public final dq pv(String paramString)
  {
    AppMethodBeat.i(209152);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(209152);
    return this;
  }
  
  public final dq pw(String paramString)
  {
    AppMethodBeat.i(209153);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209153);
    return this;
  }
  
  public final dq px(String paramString)
  {
    AppMethodBeat.i(209154);
    this.eBd = x("ExposeItems", paramString, true);
    AppMethodBeat.o(209154);
    return this;
  }
  
  public final dq py(String paramString)
  {
    AppMethodBeat.i(209155);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(209155);
    return this;
  }
  
  public final dq pz(String paramString)
  {
    AppMethodBeat.i(209156);
    this.eBf = x("EnterContextId", paramString, true);
    AppMethodBeat.o(209156);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dq
 * JD-Core Version:    0.7.0.1
 */