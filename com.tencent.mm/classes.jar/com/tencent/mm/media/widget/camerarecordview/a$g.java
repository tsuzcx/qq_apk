package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.g.b.v.d;
import d.g.b.v.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class a$g
  implements Runnable
{
  a$g(a parama, com.tencent.mm.media.j.a parama1, v.f paramf1, v.d paramd, v.f paramf2, d.g.a.b paramb) {}
  
  public final void run()
  {
    String str = null;
    AppMethodBeat.i(94220);
    if (a.f(this.hbl))
    {
      AppMethodBeat.o(94220);
      return;
    }
    Object localObject2 = new StringBuilder("stop daemonRecorder ");
    Object localObject1 = a.e(this.hbl);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      localObject1 = a.e(this.hbl);
      if (localObject1 == null) {
        break label387;
      }
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).auN();
      label82:
      ac.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
      this.hbo.aic();
      localObject1 = a.e(this.hbl);
      if (localObject1 == null) {
        break label392;
      }
    }
    label387:
    label392:
    for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
    {
      localObject2 = a.e(this.hbl);
      if (localObject2 != null) {
        str = ((com.tencent.mm.media.widget.c.b)localObject2).auN();
      }
      if ((localObject1 == null) || (str == null)) {
        break label425;
      }
      localObject2 = e.asx((String)localObject1);
      if (localObject2 == null) {
        break label425;
      }
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).hbH = true;
      com.tencent.mm.media.widget.camerarecordview.b.b localb = (com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ;
      k.h(localObject1, "<set-?>");
      localb.hbJ = ((String)localObject1);
      localObject1 = (com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ;
      k.h(str, "<set-?>");
      ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbK = str;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).hbL = 0;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).hbM = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      localObject1 = this.hbq;
      ((v.d)localObject1).KUO += 1;
      ac.i("MicroMsg.CameraPreviewContainer", "record video info daemon: ".concat(String.valueOf(localObject2)));
      localObject1 = d.gWO;
      d.asC();
      localObject1 = d.gWO;
      d.px(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
      localObject1 = d.gWO;
      d.py(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
      if (this.hbq.KUO != 2) {
        break label403;
      }
      localObject1 = d.gWO;
      d.asp();
      ap.aB((Runnable)this.hbr.KUQ);
      a.g(this.hbl);
      localObject1 = this.fPt;
      if (localObject1 == null) {
        break label397;
      }
      ((d.g.a.b)localObject1).ay((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ);
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
    ap.n((Runnable)this.hbr.KUQ, 3000L);
    AppMethodBeat.o(94220);
    return;
    label425:
    AppMethodBeat.o(94220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.g
 * JD-Core Version:    0.7.0.1
 */