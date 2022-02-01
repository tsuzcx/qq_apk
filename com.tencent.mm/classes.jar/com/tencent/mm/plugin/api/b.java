package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.b
{
  private com.tencent.mm.plugin.mmsight.model.a.d nqS;
  private VideoTransPara nqT;
  
  public final void a(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89187);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.d(paramVideoTransPara);
    this.nqT = paramVideoTransPara;
    AppMethodBeat.o(89187);
  }
  
  public final void b(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89188);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.d(paramVideoTransPara);
    j.EZX.jth = 1;
    this.nqT = paramVideoTransPara;
    AppMethodBeat.o(89188);
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.d bBu()
  {
    AppMethodBeat.i(89189);
    if (this.nqT != null)
    {
      k.eTI();
      this.nqS = k.q(this.nqT);
    }
    if ((this.nqS instanceof l))
    {
      localObject = (l)this.nqS;
      Log.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", new Object[] { Boolean.TRUE });
      ((l)localObject).lhZ = true;
    }
    Object localObject = this.nqS;
    AppMethodBeat.o(89189);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.b
 * JD-Core Version:    0.7.0.1
 */