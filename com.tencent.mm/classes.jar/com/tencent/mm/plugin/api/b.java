package com.tencent.mm.plugin.api;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.b
{
  private com.tencent.mm.plugin.mmsight.model.a.d fvQ;
  private VideoTransPara fvR;
  
  public final com.tencent.mm.plugin.mmsight.model.a.d YU()
  {
    if (this.fvR != null)
    {
      k.bjA();
      this.fvQ = k.d(this.fvR);
    }
    if ((this.fvQ instanceof l))
    {
      l locall = (l)this.fvQ;
      y.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", new Object[] { Boolean.valueOf(true) });
      locall.mjM = true;
    }
    return this.fvQ;
  }
  
  public final void a(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.c(paramVideoTransPara);
    this.fvR = paramVideoTransPara;
  }
  
  public final void b(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.c(paramVideoTransPara);
    j.mhB.dys = 1;
    this.fvR = paramVideoTransPara;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.b
 * JD-Core Version:    0.7.0.1
 */