package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.sdk.platformtools.ab;

final class d
  implements MMSightRecordView.f
{
  private final c hAC;
  final p hIY;
  boolean hIZ;
  int hJa;
  
  public d(c paramc)
  {
    AppMethodBeat.i(130968);
    this.hAC = paramc;
    this.hIY = ((p)this.hAC.aAO().v(p.class));
    this.hJa = -2147483648;
    AppMethodBeat.o(130968);
  }
  
  public final void a(MMSightRecordView paramMMSightRecordView)
  {
    AppMethodBeat.i(130969);
    this.hIZ = false;
    if (paramMMSightRecordView != null) {
      paramMMSightRecordView.a(null, null);
    }
    if (this.hJa != -2147483648)
    {
      this.hIY.oy(this.hJa);
      this.hJa = -2147483648;
    }
    AppMethodBeat.o(130969);
  }
  
  public final void aCP()
  {
    AppMethodBeat.i(130970);
    if (!this.hIZ)
    {
      ab.i("MicroMsg.FrameDataCallbackHelper", "onDateUpdate not need callback");
      AppMethodBeat.o(130970);
      return;
    }
    this.hAC.a(new d.a(this));
    AppMethodBeat.o(130970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */