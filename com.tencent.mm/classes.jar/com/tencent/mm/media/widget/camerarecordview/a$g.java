package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.g.b.v.c;
import d.g.b.v.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$g
  implements Runnable
{
  a$g(a parama, com.tencent.mm.media.j.a parama1, v.e parame1, v.c paramc, v.e parame2, d.g.a.b paramb) {}
  
  public final void run()
  {
    String str = null;
    AppMethodBeat.i(94220);
    if (a.f(this.gAP))
    {
      AppMethodBeat.o(94220);
      return;
    }
    Object localObject2 = new StringBuilder("stop daemonRecorder ");
    Object localObject1 = a.e(this.gAP);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      localObject1 = a.e(this.gAP);
      if (localObject1 == null) {
        break label387;
      }
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).anX();
      label82:
      ad.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
      this.gAS.agL();
      localObject1 = a.e(this.gAP);
      if (localObject1 == null) {
        break label392;
      }
    }
    label387:
    label392:
    for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
    {
      localObject2 = a.e(this.gAP);
      if (localObject2 != null) {
        str = ((com.tencent.mm.media.widget.c.b)localObject2).anX();
      }
      if ((localObject1 == null) || (str == null)) {
        break label425;
      }
      localObject2 = e.ano((String)localObject1);
      if (localObject2 == null) {
        break label425;
      }
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).gBl = true;
      com.tencent.mm.media.widget.camerarecordview.b.b localb = (com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw;
      k.h(localObject1, "<set-?>");
      localb.gBn = ((String)localObject1);
      localObject1 = (com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw;
      k.h(str, "<set-?>");
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBo = str;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).gBp = 0;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).gBq = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      localObject1 = this.gAU;
      ((v.c)localObject1).Jhu += 1;
      ad.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(localObject2)));
      localObject1 = d.gwr;
      d.alI();
      localObject1 = d.gwr;
      d.lJ(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
      localObject1 = d.gwr;
      d.lK(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
      if (this.gAU.Jhu != 2) {
        break label403;
      }
      localObject1 = d.gwr;
      d.alv();
      aq.az((Runnable)this.gAV.Jhw);
      a.g(this.gAP);
      localObject1 = this.fLH;
      if (localObject1 == null) {
        break label397;
      }
      ((d.g.a.b)localObject1).aA((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw);
      AppMethodBeat.o(94220);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label82;
    }
    label397:
    AppMethodBeat.o(94220);
    return;
    label403:
    aq.n((Runnable)this.gAV.Jhw, 3000L);
    AppMethodBeat.o(94220);
    return;
    label425:
    AppMethodBeat.o(94220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.g
 * JD-Core Version:    0.7.0.1
 */