package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  implements MMSightRecordView.f
{
  private final e nNw;
  final s oMs;
  boolean oMt;
  int oMu;
  
  public d(e parame)
  {
    AppMethodBeat.i(46217);
    this.nNw = parame;
    this.oMs = ((s)this.nNw.getJsRuntime().Q(s.class));
    this.oMu = -2147483648;
    AppMethodBeat.o(46217);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(46218);
    this.oMt = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.oMu != -2147483648)
    {
      this.oMs.Bz(this.oMu);
      this.oMu = -2147483648;
    }
    AppMethodBeat.o(46218);
  }
  
  public final void bRK()
  {
    AppMethodBeat.i(46219);
    if (!this.oMt)
    {
      Log.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(46219);
      return;
    }
    new a().j(this.nNw).bPO();
    AppMethodBeat.o(46219);
  }
  
  public final class a
    extends az
  {
    private static final int CTRL_INDEX = 637;
    public static final String NAME = "onCameraFrame";
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */