package com.tencent.mm.media.widget.b;

import a.f.a.b;
import a.f.b.j;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.g;
import com.tencent.mm.media.d.g.c;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.nio.IntBuffer;

final class d$4
  implements b<Boolean, y>
{
  d$4(d paramd) {}
  
  private y XG()
  {
    AppMethodBeat.i(12782);
    for (;;)
    {
      Object localObject2;
      g localg;
      int i;
      int j;
      synchronized (this.fcZ.fbZ)
      {
        if (this.fcZ.fcW != null)
        {
          ??? = this.fcZ.fcX.Vg();
          if (??? != null)
          {
            ((IntBuffer)???).position(0);
            localObject2 = new int[((IntBuffer)???).remaining()];
            ((IntBuffer)???).get((int[])localObject2);
            localg = this.fcZ.fcW;
            i = this.fcZ.fch;
            j = this.fcZ.fci;
            j.q(localObject2, "data");
            if (localg.eRm >= 0) {
              break label256;
            }
            ab.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
          }
        }
        if ((this.fcZ.fcW != null) && (this.fcZ.fcm.oJP == d.c.oII))
        {
          this.fcZ.fcW.stop(false);
          if (this.fcZ.fcf != null) {
            this.fcZ.fcf.a(new d.4.1(this));
          }
          this.fcZ.fcG.release();
          localObject2 = this.fcZ;
          ab.b("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
          com.tencent.mm.sdk.g.d.post(new d.6((d)localObject2), "X264MP4MuxRecorder_stop");
          if (this.fcZ.fcm != null) {
            this.fcZ.fcm.a(d.c.oIJ);
          }
        }
        AppMethodBeat.o(12782);
        return null;
      }
      label256:
      synchronized (localg.eRH)
      {
        localg.eUI.ac((Runnable)new g.c(localg, i, j, (int[])localObject2));
        continue;
        localObject3 = finally;
        AppMethodBeat.o(12782);
        throw localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d.4
 * JD-Core Version:    0.7.0.1
 */