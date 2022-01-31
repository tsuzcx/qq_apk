package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.c.a;
import com.tencent.mm.f.c.d;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class f$a
  implements Runnable
{
  public f$a(f paramf) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized (this.eLS)
      {
        y.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
        try
        {
          new File(f.d(this.eLS)).delete();
          if (f.c(this.eLS))
          {
            i = 8000;
            this.eLS.bCc = new com.tencent.mm.f.b.c(i, 1, 3);
            this.eLS.bCc.bCE = -19;
            this.eLS.bCc.aX(false);
            if (!f.c(this.eLS))
            {
              this.eLS.eLP = new d();
              if (!this.eLS.eLP.cG(f.d(this.eLS)))
              {
                y.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                this.eLS.eLP.uE();
                this.eLS.eLP = null;
              }
            }
            if ((f.c(this.eLS)) || (q.dyn.dwY <= 0)) {
              break label324;
            }
            this.eLS.bCc.t(q.dyn.dwY, true);
            this.eLS.bCc.aY(false);
            this.eLS.eLQ = new com.tencent.qqpinyin.voicerecoapi.c(f.f(this.eLS));
            i = this.eLS.eLQ.start();
            if (i == 0) {
              break label339;
            }
            y.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + i);
            f.g(this.eLS);
            return;
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + f.d(this.eLS), new Object[] { localException });
          continue;
        }
      }
      int i = 16000;
      continue;
      label324:
      this.eLS.bCc.t(5, false);
      continue;
      label339:
      this.eLS.bCc.bCP = f.h(this.eLS);
      if (!this.eLS.bCc.uq())
      {
        y.e("MicroMsg.SceneVoiceAddr", "start record failed");
        f.g(this.eLS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f.a
 * JD-Core Version:    0.7.0.1
 */