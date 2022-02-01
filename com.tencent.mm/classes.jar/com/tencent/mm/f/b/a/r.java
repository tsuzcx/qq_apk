package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class r
  extends a
{
  public String gfm = "";
  public String gfn = "";
  public long gfo;
  public long gfp;
  public long gfq;
  public long gfr;
  public long gfs;
  public long gft;
  public long gfu;
  private String gfv = "";
  public long gfw;
  public long gfx = -1L;
  public long gfy = -1L;
  
  public final String agH()
  {
    AppMethodBeat.i(283907);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gft);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfy);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(283907);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(283908);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CheckSendShouldTimeStamp:").append(this.gfo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateStart:").append(this.gfp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateEnd:").append(this.gfq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadStatus:").append(this.gfr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkerCreateStatus:").append(this.gfs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitingWorkerCreateCost:").append(this.gft);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllCostTime:").append(this.gfu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdWorkerCreateFailErrorMsg:").append(this.gfv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowAdState:").append(this.gfw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartInjectJsTimestamp:").append(this.gfx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsInjectCost:").append(this.gfy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(283908);
    return localObject;
  }
  
  public final int getId()
  {
    return 22732;
  }
  
  public final r iM(String paramString)
  {
    AppMethodBeat.i(283906);
    this.gfv = z("AdWorkerCreateFailErrorMsg", paramString, true);
    AppMethodBeat.o(283906);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.r
 * JD-Core Version:    0.7.0.1
 */