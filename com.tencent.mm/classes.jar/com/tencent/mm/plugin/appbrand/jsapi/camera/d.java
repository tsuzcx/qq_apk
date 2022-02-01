package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  implements MMSightRecordView.f
{
  private final f qNp;
  final s rQo;
  boolean rQp;
  int rQq;
  
  public d(f paramf)
  {
    AppMethodBeat.i(46217);
    this.qNp = paramf;
    this.rQo = ((s)this.qNp.getJsRuntime().Z(s.class));
    this.rQq = -2147483648;
    AppMethodBeat.o(46217);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(46218);
    this.rQp = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.rQq != -2147483648)
    {
      this.rQo.BM(this.rQq);
      this.rQq = -2147483648;
    }
    AppMethodBeat.o(46218);
  }
  
  public final void crP()
  {
    AppMethodBeat.i(46219);
    if (!this.rQp)
    {
      Log.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(46219);
      return;
    }
    new a().i(this.qNp).cpV();
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