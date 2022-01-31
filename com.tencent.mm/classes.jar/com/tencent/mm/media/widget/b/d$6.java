package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(12786);
    synchronized (this.fcZ.fbZ)
    {
      boolean bool = d.a(this.fcZ);
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      Object localObject2;
      if (bool)
      {
        localObject2 = c.eZC;
        c.VE();
        d.a(this.fcZ, com.tencent.mm.plugin.mmsight.d.ut(this.fcZ.fca));
      }
      try
      {
        localObject2 = com.tencent.mm.plugin.sight.base.d.Zo(this.fcZ.fca);
        if (localObject2 != null)
        {
          c localc = c.eZC;
          c.co(((a)localObject2).videoBitrate, ((a)localObject2).eRw);
        }
      }
      catch (Exception localException)
      {
        label101:
        break label101;
      }
      if (this.fcZ.fcA != null)
      {
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "call stopCallback");
        al.d(this.fcZ.fcA);
      }
      do
      {
        localObject2 = c.eZC;
        c.VC();
        AppMethodBeat.o(12786);
        return;
        localObject2 = c.eZC;
        c.VD();
        SightVideoJNI.releaseBigSightDataBufferLock(this.fcZ.eRm);
      } while (this.fcZ.fcz == null);
      al.d(new d.6.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d.6
 * JD-Core Version:    0.7.0.1
 */