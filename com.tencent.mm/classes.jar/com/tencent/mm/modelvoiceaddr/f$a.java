package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.e.a;
import com.tencent.mm.audio.e.d;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class f$a
  implements Runnable
{
  public f$a(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(116695);
    for (;;)
    {
      synchronized (this.gbz)
      {
        ab.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
        try
        {
          new File(f.d(this.gbz)).delete();
          if (f.c(this.gbz))
          {
            i = 8000;
            this.gbz.ciR = new com.tencent.mm.audio.b.c(i, 1, 3);
            this.gbz.ciR.cjs = -19;
            this.gbz.ciR.bz(false);
            if (!f.c(this.gbz))
            {
              this.gbz.gbw = new d();
              if (!this.gbz.gbw.eN(f.d(this.gbz)))
              {
                ab.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                this.gbz.gbw.Fb();
                this.gbz.gbw = null;
              }
            }
            if ((f.c(this.gbz)) || (ac.erF.eoW <= 0)) {
              break label332;
            }
            this.gbz.ciR.t(ac.erF.eoW, true);
            this.gbz.ciR.bA(false);
            this.gbz.gbx = new com.tencent.qqpinyin.voicerecoapi.c(f.f(this.gbz));
            i = this.gbz.gbx.dUg();
            if (i == 0) {
              break label347;
            }
            ab.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :".concat(String.valueOf(i)));
            f.g(this.gbz);
            AppMethodBeat.o(116695);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(this.gbz), new Object[] { localException });
          continue;
        }
      }
      int i = 16000;
      continue;
      label332:
      this.gbz.ciR.t(5, false);
      continue;
      label347:
      this.gbz.ciR.cjD = f.h(this.gbz);
      if (!this.gbz.ciR.EC())
      {
        ab.e("MicroMsg.SceneVoiceAddr", "start record failed");
        f.g(this.gbz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f.a
 * JD-Core Version:    0.7.0.1
 */