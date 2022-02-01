package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.v.d;
import d.g.b.v.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class a$f
  implements Runnable
{
  a$f(a parama, v.f paramf1, com.tencent.mm.media.j.a parama1, v.f paramf2, v.d paramd, v.f paramf3, d.g.a.b paramb) {}
  
  public final void run()
  {
    String str = null;
    AppMethodBeat.i(94219);
    if (a.f(this.hbl))
    {
      AppMethodBeat.o(94219);
      return;
    }
    Object localObject2 = new StringBuilder("stopRecord ");
    Object localObject1 = (com.tencent.mm.media.widget.c.b)this.hbn.KUQ;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      localObject1 = (com.tencent.mm.media.widget.c.b)this.hbn.KUQ;
      if (localObject1 == null) {
        break label437;
      }
      localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).auN();
      label88:
      ac.m("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
      this.hbo.aic();
      localObject1 = (com.tencent.mm.media.widget.c.b)this.hbn.KUQ;
      if (localObject1 == null) {
        break label442;
      }
    }
    label437:
    label442:
    for (localObject1 = ((com.tencent.mm.media.widget.c.b)localObject1).getFilePath();; localObject1 = null)
    {
      localObject2 = (com.tencent.mm.media.widget.c.b)this.hbn.KUQ;
      if (localObject2 != null) {
        str = ((com.tencent.mm.media.widget.c.b)localObject2).auN();
      }
      if ((localObject1 == null) || (str == null)) {
        break label475;
      }
      localObject2 = e.asx((String)localObject1);
      if (localObject2 == null) {
        break label475;
      }
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).hbH = true;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).vt((String)localObject1);
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).vu(str);
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).cSh = 0;
      ((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ).hbI = ((com.tencent.mm.plugin.sight.base.a)localObject2).videoDuration;
      localObject1 = this.hbq;
      ((v.d)localObject1).KUO += 1;
      ac.i("MicroMsg.CameraPreviewContainer", "record video info main: ".concat(String.valueOf(localObject2)));
      localObject1 = d.gWO;
      d.asB();
      localObject1 = d.gWO;
      d.pv(((com.tencent.mm.plugin.sight.base.a)localObject2).videoBitrate);
      localObject1 = d.gWO;
      d.pw(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate);
      if (((!this.hbl.hbj.auY()) || (this.hbq.KUO != 2)) && (this.hbl.hbj.auY())) {
        break label453;
      }
      if ((this.hbl.hbj.auY()) && (this.hbq.KUO == 2))
      {
        localObject1 = d.gWO;
        d.asp();
      }
      ap.aB((Runnable)this.hbr.KUQ);
      a.g(this.hbl);
      localObject1 = this.fPt;
      if (localObject1 == null) {
        break label447;
      }
      ((d.g.a.b)localObject1).ay((com.tencent.mm.media.widget.camerarecordview.b.b)this.hbp.KUQ);
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
    ap.n((Runnable)this.hbr.KUQ, 3000L);
    AppMethodBeat.o(94219);
    return;
    label475:
    AppMethodBeat.o(94219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.f
 * JD-Core Version:    0.7.0.1
 */