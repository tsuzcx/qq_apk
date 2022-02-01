package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.ad;

final class d
  implements MMSightRecordView.f
{
  final s kHX;
  boolean kHY;
  int kHZ;
  private final c kuU;
  
  public d(c paramc)
  {
    AppMethodBeat.i(46217);
    this.kuU = paramc;
    this.kHX = ((s)this.kuU.aYh().P(s.class));
    this.kHZ = -2147483648;
    AppMethodBeat.o(46217);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(46218);
    this.kHY = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.kHZ != -2147483648)
    {
      this.kHX.tU(this.kHZ);
      this.kHZ = -2147483648;
    }
    AppMethodBeat.o(46218);
  }
  
  public final void bjV()
  {
    AppMethodBeat.i(46219);
    if (!this.kHY)
    {
      ad.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(46219);
      return;
    }
    this.kuU.a(new a());
    AppMethodBeat.o(46219);
  }
  
  public final class a
    extends at
  {
    private static final int CTRL_INDEX = 637;
    public static final String NAME = "onCameraFrame";
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */