package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(12748);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stopImpl status:%s", new Object[] { this.fcQ.fcm.oJP });
    if (this.fcQ.fcm.oJP == d.c.oIJ)
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stopImp, already stop");
      if (this.fcQ.fcf != null) {
        this.fcQ.fcf.clear();
      }
      AppMethodBeat.o(12748);
      return;
    }
    boolean bool = c.f(this.fcQ);
    ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[] { Boolean.valueOf(bool) });
    Object localObject;
    if (bool)
    {
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VM();
      c.a(this.fcQ, com.tencent.mm.plugin.mmsight.d.ut(this.fcQ.fca));
    }
    try
    {
      localObject = com.tencent.mm.plugin.sight.base.d.Zo(this.fcQ.fca);
      if (localObject != null)
      {
        com.tencent.mm.media.i.c localc = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.cp(((a)localObject).videoBitrate, ((a)localObject).eRw);
      }
    }
    catch (Exception localException)
    {
      label166:
      break label166;
    }
    if (this.fcQ.fcA != null)
    {
      ab.i("MicroMsg.Media.MediaCodecMP4MuxRecorder", "call stopCallback");
      al.d(this.fcQ.fcA);
    }
    for (;;)
    {
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VK();
      AppMethodBeat.o(12748);
      return;
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VL();
      SightVideoJNI.releaseBigSightDataBufferLock(this.fcQ.eRm);
      if (this.fcQ.fcz != null) {
        al.d(new c.7.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c.7
 * JD-Core Version:    0.7.0.1
 */