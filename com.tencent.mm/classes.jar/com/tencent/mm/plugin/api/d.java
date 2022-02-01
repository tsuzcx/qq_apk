package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.api.b.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  private VideoTransPara qpA;
  private com.tencent.mm.plugin.mmsight.model.a.d qpz;
  
  public final void a(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89187);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.d(paramVideoTransPara);
    this.qpA = paramVideoTransPara;
    AppMethodBeat.o(89187);
  }
  
  public final void b(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89188);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    j.d(paramVideoTransPara);
    j.KVJ.lWy = 1;
    this.qpA = paramVideoTransPara;
    AppMethodBeat.o(89188);
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.d caQ()
  {
    AppMethodBeat.i(89189);
    if (this.qpA != null)
    {
      k.gcB();
      this.qpz = k.q(this.qpA);
    }
    if ((this.qpz instanceof l))
    {
      localObject = (l)this.qpz;
      Log.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", new Object[] { Boolean.TRUE });
      ((l)localObject).nMI = true;
    }
    Object localObject = this.qpz;
    AppMethodBeat.o(89189);
    return localObject;
  }
  
  public static final class a
    implements b.a
  {
    public final b caR()
    {
      AppMethodBeat.i(89186);
      d locald = new d();
      AppMethodBeat.o(89186);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.d
 * JD-Core Version:    0.7.0.1
 */