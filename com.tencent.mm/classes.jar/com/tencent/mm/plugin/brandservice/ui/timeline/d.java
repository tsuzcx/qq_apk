package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;

public final class d
{
  IListener rDF;
  h vGD;
  
  public d(h paramh)
  {
    AppMethodBeat.i(5904);
    this.rDF = new BizTimeLineMusicImp.1(this, f.hfK);
    this.vGD = paramh;
    AppMethodBeat.o(5904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.d
 * JD-Core Version:    0.7.0.1
 */