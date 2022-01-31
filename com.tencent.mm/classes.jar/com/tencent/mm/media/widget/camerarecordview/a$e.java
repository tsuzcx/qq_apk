package com.tencent.mm.media.widget.camerarecordview;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$e
  implements Runnable
{
  a$e(a parama, com.tencent.mm.media.i.a parama1, a.f.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(13232);
    Object localObject2 = new StringBuilder("stopRecord ");
    Object localObject1 = a.b(this.fbe);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.b.b)localObject1).getFilePath();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      localObject1 = a.b(this.fbe);
      if (localObject1 == null) {
        break label191;
      }
      localObject1 = ((com.tencent.mm.media.widget.b.b)localObject1).Xi();
      label65:
      com.tencent.luggage.g.d.b("MicroMsg.CameraPreviewContainer", (String)localObject1, new Object[0]);
      this.fbh.SS();
      localObject1 = a.b(this.fbe);
      if (localObject1 == null) {
        break label196;
      }
      localObject1 = ((com.tencent.mm.media.widget.b.b)localObject1).getFilePath();
      label108:
      localObject2 = a.b(this.fbe);
      if (localObject2 == null) {
        break label201;
      }
    }
    label191:
    label196:
    label201:
    for (localObject2 = ((com.tencent.mm.media.widget.b.b)localObject2).Xi();; localObject2 = null)
    {
      if ((localObject1 == null) || (localObject2 == null)) {
        break label206;
      }
      com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo((String)localObject1);
      if (locala == null) {
        break label206;
      }
      localObject1 = new com.tencent.mm.media.widget.camerarecordview.a.b((String)localObject1, (String)localObject2, true, locala.eVA, null, 32);
      localObject2 = this.evA;
      if (localObject2 == null) {
        break label206;
      }
      ((a.f.a.b)localObject2).S(localObject1);
      AppMethodBeat.o(13232);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label65;
      localObject1 = null;
      break label108;
    }
    label206:
    AppMethodBeat.o(13232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.e
 * JD-Core Version:    0.7.0.1
 */