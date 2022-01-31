package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.b
{
  private com.tencent.mm.plugin.mmsight.model.a.d gNw;
  private VideoTransPara gNx;
  
  public final void a(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76305);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.d(paramVideoTransPara);
    this.gNx = paramVideoTransPara;
    AppMethodBeat.o(76305);
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.d asE()
  {
    AppMethodBeat.i(76307);
    if (this.gNx != null)
    {
      k.bRq();
      this.gNw = k.q(this.gNx);
    }
    if ((this.gNw instanceof l))
    {
      localObject = (l)this.gNw;
      ab.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", new Object[] { Boolean.TRUE });
      ((l)localObject).fdo = true;
    }
    Object localObject = this.gNw;
    AppMethodBeat.o(76307);
    return localObject;
  }
  
  public final void b(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76306);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.d(paramVideoTransPara);
    j.oHG.eqK = 1;
    this.gNx = paramVideoTransPara;
    AppMethodBeat.o(76306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.b
 * JD-Core Version:    0.7.0.1
 */