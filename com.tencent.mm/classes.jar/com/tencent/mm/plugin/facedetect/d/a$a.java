package com.tencent.mm.plugin.facedetect.d;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.c.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class a$a
  implements Runnable
{
  private Runnable jOX = null;
  
  private a$a(a parama, Runnable paramRunnable)
  {
    this.jOX = paramRunnable;
  }
  
  public final void run()
  {
    for (;;)
    {
      synchronized (this.jOW)
      {
        if (a.a(this.jOW)) {
          break label536;
        }
        y.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
        a.a(this.jOW, a.BG() + bk.UZ() + ".spx");
        try
        {
          e.deleteFile(a.b(this.jOW));
          a.a(this.jOW, new com.tencent.mm.f.b.c(16000, 1, 3));
          a.c(this.jOW).bCE = -19;
          a.c(this.jOW).aX(false);
          a.a(this.jOW, new d());
          if (!a.d(this.jOW).cG(a.b(this.jOW)))
          {
            y.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
            a.d(this.jOW).uE();
            a.a(this.jOW, null);
            if (a.e(this.jOW) != null) {
              a.e(this.jOW).onError(5);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "hy: delete file failed", new Object[0]);
          continue;
        }
      }
      if (q.dyn.dwY > 0)
      {
        a.c(this.jOW).t(q.dyn.dwY, true);
        a.c(this.jOW).ey(50);
        a.c(this.jOW).aY(false);
      }
      try
      {
        a.a(this.jOW, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.dnD.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.dnD.getFloat("s_n_ration", 2.5F), com.tencent.mm.modelvoiceaddr.a.c.dnD.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.dnD.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.dnD.getInt("s_delay_time", 20), false, false));
        a.g(this.jOW).eMI = a.f(this.jOW);
        a.c(this.jOW).bCP = this.jOW.jOV;
        this.jOW.a(a.h(this.jOW));
        if (!a.c(this.jOW).uq())
        {
          y.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
          if (a.e(this.jOW) == null) {
            continue;
          }
          a.e(this.jOW).onError(7);
          continue;
          a.c(this.jOW).t(5, false);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          y.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + localThrowable.getMessage());
          if (a.e(this.jOW) != null) {
            a.e(this.jOW).onError(6);
          }
        }
      }
      if (this.jOX != null)
      {
        this.jOX.run();
        continue;
        label536:
        y.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a.a
 * JD-Core Version:    0.7.0.1
 */