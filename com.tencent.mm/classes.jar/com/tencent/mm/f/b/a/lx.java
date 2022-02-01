package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lx
  extends a
{
  public long gQR = 0L;
  public long gQS = 0L;
  private String gRu = "";
  public long gRv = 0L;
  public long gSg = 0L;
  private long gSh = 0L;
  private long gSi = 0L;
  private long gSj = 0L;
  private long gSk = 0L;
  private long gSl = 0L;
  private long gSm = 0L;
  private long gSn = 0L;
  private long gSo = 0L;
  public long gSp = 0L;
  private long gSq = 0L;
  private long gSr = 0L;
  private String gcU = "";
  private long ggQ = 0L;
  private String glg = "";
  private long glw = 0L;
  
  public final lx Ct(String paramString)
  {
    AppMethodBeat.i(118505);
    this.gRu = z("SourceUserName", paramString, false);
    AppMethodBeat.o(118505);
    return this;
  }
  
  public final lx Cu(String paramString)
  {
    AppMethodBeat.i(118506);
    this.glg = z("ActionTrace", paramString, true);
    AppMethodBeat.o(118506);
    return this;
  }
  
  public final lx Cv(String paramString)
  {
    AppMethodBeat.i(118507);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(118507);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(118508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118508);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.ggQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.gQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.gSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.gRu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.gRv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.gQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTime:").append(this.gSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalUserNameCount:").append(this.gSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUserNameCount:").append(this.gSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalStoryCount:").append(this.gSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendStoryCount:").append(this.gSl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalBrowserCount:").append(this.gSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendBrowserCount:").append(this.gSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.glg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllVideoBrowserCountWithRepeat:").append(this.gSo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayFriendCount:").append(this.gSp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowComment:").append(this.gSq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsInformComment:").append(this.gSr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118509);
    return localObject;
  }
  
  public final long amR()
  {
    return this.ggQ;
  }
  
  public final long amS()
  {
    return this.gQR;
  }
  
  public final long amT()
  {
    return this.gSg;
  }
  
  public final long amU()
  {
    return this.glw;
  }
  
  public final long amV()
  {
    return this.gSi;
  }
  
  public final long amW()
  {
    return this.gSj;
  }
  
  public final long amX()
  {
    return this.gSk;
  }
  
  public final long amY()
  {
    return this.gSl;
  }
  
  public final long amZ()
  {
    return this.gSm;
  }
  
  public final long ana()
  {
    return this.gSn;
  }
  
  public final long anb()
  {
    return this.gSo;
  }
  
  public final int getId()
  {
    return 16658;
  }
  
  public final String getSessionId()
  {
    return this.gcU;
  }
  
  public final lx wm(long paramLong)
  {
    this.ggQ = paramLong;
    return this;
  }
  
  public final lx wn(long paramLong)
  {
    this.gQR = paramLong;
    return this;
  }
  
  public final lx wo(long paramLong)
  {
    this.gQS = paramLong;
    return this;
  }
  
  public final lx wp(long paramLong)
  {
    this.glw = paramLong;
    return this;
  }
  
  public final lx wq(long paramLong)
  {
    this.gSh = paramLong;
    return this;
  }
  
  public final lx wr(long paramLong)
  {
    this.gSi = paramLong;
    return this;
  }
  
  public final lx ws(long paramLong)
  {
    this.gSj = paramLong;
    return this;
  }
  
  public final lx wt(long paramLong)
  {
    this.gSk = paramLong;
    return this;
  }
  
  public final lx wu(long paramLong)
  {
    this.gSl = paramLong;
    return this;
  }
  
  public final lx wv(long paramLong)
  {
    this.gSm = paramLong;
    return this;
  }
  
  public final lx ww(long paramLong)
  {
    this.gSn = paramLong;
    return this;
  }
  
  public final lx wx(long paramLong)
  {
    this.gSo = paramLong;
    return this;
  }
  
  public final lx wy(long paramLong)
  {
    this.gSp = paramLong;
    return this;
  }
  
  public final lx wz(long paramLong)
  {
    this.gSq = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lx
 * JD-Core Version:    0.7.0.1
 */