package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.v.c;
import d.g.b.v.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$f
  implements Runnable
{
  a$f(a parama, v.e parame1, com.tencent.mm.media.j.a parama1, v.e parame2, v.c paramc, v.e parame3, d.g.a.b paramb) {}
  
  public final void run()
  {
    String str = null;
    AppMethodBeat.i(94219);
    if (a.f(this.gAP))
    {
      AppMethodBeat.o(94219);
      return;
    }
    Object localObject2 = new StringBuilder("stopRecord ");
    Object localObject1 = (com.tencent.mm.media.widget.c.b)this.KBQ.Jhw;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      localObject1 = (com.tencent.mm.media.widget.c.b)this.KBQ.Jhw;
      if (localObject1 == null) {
        break label437;
      }
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).anX();
      label88:
      ad.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
      this.gAS.agL();
      localObject1 = (com.tencent.mm.media.widget.c.b)this.KBQ.Jhw;
      if (localObject1 == null) {
        break label442;
      }
    }
    label437:
    label442:
    for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
    {
      localObject2 = (com.tencent.mm.media.widget.c.b)this.KBQ.Jhw;
      if (localObject2 != null) {
        str = ((com.tencent.mm.media.widget.c.b)localObject2).anX();
      }
      if ((localObject1 == null) || (str == null)) {
        break label475;
      }
      localObject2 = e.ano((String)localObject1);
      if (localObject2 == null) {
        break label475;
      }
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).gBl = true;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).rr((String)localObject1);
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).rs(str);
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).cUL = 0;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw).gBm = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      localObject1 = this.gAU;
      ((v.c)localObject1).Jhu += 1;
      ad.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(localObject2)));
      localObject1 = d.gwr;
      d.alH();
      localObject1 = d.gwr;
      d.lH(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
      localObject1 = d.gwr;
      d.lI(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
      if (((!this.gAP.gAN.aoh()) || (this.gAU.Jhu != 2)) && (this.gAP.gAN.aoh())) {
        break label453;
      }
      if ((this.gAP.gAN.aoh()) && (this.gAU.Jhu == 2))
      {
        localObject1 = d.gwr;
        d.alv();
      }
      aq.az((Runnable)this.gAV.Jhw);
      a.g(this.gAP);
      localObject1 = this.fLH;
      if (localObject1 == null) {
        break label447;
      }
      ((d.g.a.b)localObject1).aA((com.tencent.mm.media.widget.camerarecordview.b.b)this.gAT.Jhw);
      AppMethodBeat.o(94219);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label88;
    }
    label447:
    AppMethodBeat.o(94219);
    return;
    label453:
    aq.n((Runnable)this.gAV.Jhw, 3000L);
    AppMethodBeat.o(94219);
    return;
    label475:
    AppMethodBeat.o(94219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.f
 * JD-Core Version:    0.7.0.1
 */