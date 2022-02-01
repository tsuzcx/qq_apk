package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.b
{
  private com.tencent.mm.plugin.mmsight.model.a.d kxS;
  private VideoTransPara kxT;
  
  public final void a(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89187);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    k.d(paramVideoTransPara);
    this.kxT = paramVideoTransPara;
    AppMethodBeat.o(89187);
  }
  
  public final void b(com.tencent.mm.remoteservice.d paramd, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89188);
    if (paramd != null) {
      CaptureMMProxy.createProxy(new CaptureMMProxy(paramd));
    }
    k.d(paramVideoTransPara);
    k.zuy.gIP = 1;
    this.kxT = paramVideoTransPara;
    AppMethodBeat.o(89188);
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.d bqF()
  {
    AppMethodBeat.i(89189);
    if (this.kxT != null)
    {
      l.ekc();
      this.kxS = l.q(this.kxT);
    }
    if ((this.kxS instanceof m))
    {
      localObject = (m)this.kxS;
      Log.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", new Object[] { Boolean.TRUE });
      ((m)localObject).isU = true;
    }
    Object localObject = this.kxS;
    AppMethodBeat.o(89189);
    return localObject;
  }
  
  public static final class a
    implements com.tencent.mm.plugin.mmsight.api.b.a
  {
    public final com.tencent.mm.plugin.mmsight.api.b bqG()
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