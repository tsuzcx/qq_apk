package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  private String iBf = "";
  public long iFd;
  public long iFe;
  public long iFf;
  public long iFg;
  public long iFh;
  public long iFi;
  private long iFj;
  public long iFk;
  public int iFl;
  public long iFm;
  private String iFn = "";
  public long iFo;
  
  public final String aIE()
  {
    AppMethodBeat.i(367865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367865);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367874);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sceneType:").append(this.iFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstFrameTime:").append(this.iFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startPlayTime:").append(this.iFg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectTime:").append(this.iFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectToDecodeTime:").append(this.iFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("decodeTime:").append(this.iFj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("playTime:").append(this.iFk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFirstLivePreload:").append(this.iFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startPlayToFrameTime:").append(this.iFm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("snn:").append(this.iFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("data:").append(this.iBf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367874);
    return localObject;
  }
  
  public final int getId()
  {
    return 23799;
  }
  
  public final er pe(String paramString)
  {
    AppMethodBeat.i(367851);
    this.iFn = F("snn", paramString, true);
    AppMethodBeat.o(367851);
    return this;
  }
  
  public final er pf(String paramString)
  {
    AppMethodBeat.i(367858);
    this.iBf = F("data", paramString, true);
    AppMethodBeat.o(367858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.er
 * JD-Core Version:    0.7.0.1
 */