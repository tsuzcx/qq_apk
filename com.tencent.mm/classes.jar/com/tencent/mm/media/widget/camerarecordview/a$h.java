package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import d.g.b.v.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$h
  implements Runnable
{
  a$h(a parama, v.e parame, d.g.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(94221);
    if (!((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).anZ())
    {
      localObject = d.gwr;
      d.alw();
      localObject = a.d(this.gAP);
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
    }
    if (!((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).anY())
    {
      localObject = d.gwr;
      d.alx();
      localObject = a.e(this.gAP);
      if (localObject != null) {
        ((com.tencent.mm.media.widget.c.b)localObject).cancel();
      }
    }
    a.g(this.gAP);
    Object localObject = this.fLH;
    if (localObject != null)
    {
      ((d.g.a.b)localObject).aA((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw);
      AppMethodBeat.o(94221);
      return;
    }
    AppMethodBeat.o(94221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.h
 * JD-Core Version:    0.7.0.1
 */