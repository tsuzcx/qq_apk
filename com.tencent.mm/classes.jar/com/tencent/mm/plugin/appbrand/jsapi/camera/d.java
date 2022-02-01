package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.ae;

final class d
  implements MMSightRecordView.f
{
  private final c jQp;
  final s kLm;
  boolean kLn;
  int kLo;
  
  public d(c paramc)
  {
    AppMethodBeat.i(46217);
    this.jQp = paramc;
    this.kLm = ((s)this.jQp.aYB().P(s.class));
    this.kLo = -2147483648;
    AppMethodBeat.o(46217);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(46218);
    this.kLn = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.kLo != -2147483648)
    {
      this.kLm.ua(this.kLo);
      this.kLo = -2147483648;
    }
    AppMethodBeat.o(46218);
  }
  
  public final void bkE()
  {
    AppMethodBeat.i(46219);
    if (!this.kLn)
    {
      ae.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(46219);
      return;
    }
    this.jQp.a(new a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */