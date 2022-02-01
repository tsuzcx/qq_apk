package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.ad;

final class d
  implements MMSightRecordView.f
{
  private final c jAc;
  final s jMw;
  boolean jMx;
  int jMy;
  
  public d(c paramc)
  {
    AppMethodBeat.i(46217);
    this.jAc = paramc;
    this.jMw = ((s)this.jAc.aOf().P(s.class));
    this.jMy = -2147483648;
    AppMethodBeat.o(46217);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(46218);
    this.jMx = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.jMy != -2147483648)
    {
      this.jMw.sA(this.jMy);
      this.jMy = -2147483648;
    }
    AppMethodBeat.o(46218);
  }
  
  public final void aZz()
  {
    AppMethodBeat.i(46219);
    if (!this.jMx)
    {
      ad.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(46219);
      return;
    }
    this.jAc.a(new a());
    AppMethodBeat.o(46219);
  }
  
  public final class a
    extends ar
  {
    private static final int CTRL_INDEX = 637;
    public static final String NAME = "onCameraFrame";
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */