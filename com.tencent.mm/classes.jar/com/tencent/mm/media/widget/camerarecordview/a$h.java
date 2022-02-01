package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import d.g.b.v.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class a$h
  implements Runnable
{
  a$h(a parama, v.f paramf, d.g.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(94221);
    if (!((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).auP())
    {
      localObject = d.gWO;
      d.asq();
      localObject = a.d(this.hbl);
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
    }
    if (!((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).auO())
    {
      localObject = d.gWO;
      d.asr();
      localObject = a.e(this.hbl);
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
    }
    a.g(this.hbl);
    Object localObject = this.fPt;
    if (localObject != null)
    {
      ((d.g.a.b)localObject).ay((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ);
      AppMethodBeat.o(94221);
      return;
    }
    AppMethodBeat.o(94221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.h
 * JD-Core Version:    0.7.0.1
 */