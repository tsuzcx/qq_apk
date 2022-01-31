package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;

public final class f$2
  implements e.a
{
  public f$2(f paramf, b paramb, com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(14258);
    this.jYn.a(this.jYo, this.jMz, this.jYp, true);
    this.jYn.a(this.jYo, true);
    this.jYm.jXV.jVJ.m(this.jMz.field_msgId, this.jYp);
    AppMethodBeat.o(14258);
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.f.2
 * JD-Core Version:    0.7.0.1
 */