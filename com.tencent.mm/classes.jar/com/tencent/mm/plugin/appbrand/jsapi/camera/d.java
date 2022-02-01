package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  implements MMSightRecordView.f
{
  private final f kSY;
  final s lPY;
  boolean lPZ;
  int lQa;
  
  public d(f paramf)
  {
    AppMethodBeat.i(46217);
    this.kSY = paramf;
    this.lPY = ((s)this.kSY.getJsRuntime().R(s.class));
    this.lQa = -2147483648;
    AppMethodBeat.o(46217);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(46218);
    this.lPZ = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.lQa != -2147483648)
    {
      this.lPY.xZ(this.lQa);
      this.lQa = -2147483648;
    }
    AppMethodBeat.o(46218);
  }
  
  public final void bGa()
  {
    AppMethodBeat.i(46219);
    if (!this.lPZ)
    {
      Log.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(46219);
      return;
    }
    this.kSY.a(new a());
    AppMethodBeat.o(46219);
  }
  
  public final class a
    extends bc
  {
    private static final int CTRL_INDEX = 637;
    public static final String NAME = "onCameraFrame";
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */