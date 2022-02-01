package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad
  extends a
{
  public String ggg = "";
  public long ggi = 0L;
  public long ghT = 0L;
  public long ghU = 0L;
  public boolean ghV;
  public long ghW = 0L;
  public long ghX = 0L;
  public long ghY = 0L;
  private long ghZ = 0L;
  private long gia = 0L;
  public a gib;
  
  public final String agH()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghU);
    ((StringBuffer)localObject).append(",");
    if (this.ghV)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ghW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ghX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ghY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ghZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gia);
      ((StringBuffer)localObject).append(",");
      if (this.gib == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.gib.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.ggi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.ghT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.ghU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.ghV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.ghW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.ghX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.ghY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.ghZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.gia);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.gib);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final ad agO()
  {
    AppMethodBeat.i(19860);
    this.ghZ = Util.nowMilliSecond();
    super.bm("StartDownloadTimeStampMs", this.ghZ);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final ad agP()
  {
    AppMethodBeat.i(19861);
    this.gia = Util.nowMilliSecond();
    super.bm("FinishDownloadTimeStampMs", this.gia);
    AppMethodBeat.o(19861);
    return this;
  }
  
  public final int getId()
  {
    return 15749;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(19859);
      gic = new a("ok", 0, 0);
      gid = new a("cancel", 1, 1);
      gie = new a("error", 2, 2);
      gif = new a[] { gic, gid, gie };
      AppMethodBeat.o(19859);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ad
 * JD-Core Version:    0.7.0.1
 */