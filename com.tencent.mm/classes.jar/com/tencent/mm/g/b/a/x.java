package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
  extends a
{
  public String emL = "";
  public long emM = 0L;
  public long emN = 0L;
  public long emO = 0L;
  public boolean emP;
  public long emQ = 0L;
  public long emR = 0L;
  public long emS = 0L;
  private long emT = 0L;
  private long emU = 0L;
  public a emV;
  
  public final String abV()
  {
    AppMethodBeat.i(19862);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    if (this.emP)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.emQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.emR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.emS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.emT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.emU);
      ((StringBuffer)localObject).append(",");
      if (this.emV == null) {
        break label225;
      }
    }
    label225:
    for (int i = this.emV.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(19862);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(19863);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.emM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSvrId:").append(this.emN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCreateTime:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHdImgBool:").append(this.emP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgSize:").append(this.emQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgWidth:").append(this.emR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImgHeight:").append(this.emS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTimeStampMs:").append(this.emT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishDownloadTimeStampMs:").append(this.emU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinishCode:").append(this.emV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19863);
    return localObject;
  }
  
  public final x acb()
  {
    AppMethodBeat.i(19860);
    this.emT = Util.nowMilliSecond();
    super.bj("StartDownloadTimeStampMs", this.emT);
    AppMethodBeat.o(19860);
    return this;
  }
  
  public final x acc()
  {
    AppMethodBeat.i(19861);
    this.emU = Util.nowMilliSecond();
    super.bj("FinishDownloadTimeStampMs", this.emU);
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
      emW = new a("ok", 0, 0);
      emX = new a("cancel", 1, 1);
      emY = new a("error", 2, 2);
      emZ = new a[] { emW, emX, emY };
      AppMethodBeat.o(19859);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.x
 * JD-Core Version:    0.7.0.1
 */