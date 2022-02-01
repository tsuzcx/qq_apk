package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.b
{
  private com.tencent.mm.plugin.mmsight.model.a.d jbf;
  private VideoTransPara jbg;
  
  public final void a(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89187);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    com.tencent.mm.plugin.mmsight.model.k.d(paramVideoTransPara);
    this.jbg = paramVideoTransPara;
    AppMethodBeat.o(89187);
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.d aRX()
  {
    AppMethodBeat.i(89189);
    if (this.jbg != null)
    {
      com.tencent.mm.plugin.mmsight.model.a.k.ddS();
      this.jbf = com.tencent.mm.plugin.mmsight.model.a.k.q(this.jbg);
    }
    if ((this.jbf instanceof l))
    {
      localObject = (l)this.jbf;
      ac.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", new Object[] { Boolean.TRUE });
      ((l)localObject).hdX = true;
    }
    Object localObject = this.jbf;
    AppMethodBeat.o(89189);
    return localObject;
  }
  
  public final void b(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89188);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    com.tencent.mm.plugin.mmsight.model.k.d(paramVideoTransPara);
    com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ = 1;
    this.jbg = paramVideoTransPara;
    AppMethodBeat.o(89188);
  }
  
  public static final class a
    implements com.tencent.mm.plugin.mmsight.api.b.a
  {
    public final com.tencent.mm.plugin.mmsight.api.b aRY()
    {
      AppMethodBeat.i(89186);
      b localb = new b();
      AppMethodBeat.o(89186);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.b
 * JD-Core Version:    0.7.0.1
 */