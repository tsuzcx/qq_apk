package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class j$13$1
  implements Runnable
{
  j$13$1(j.13 param13) {}
  
  public final void run()
  {
    if ((!bk.bl(j.e(this.iGe.iFU))) && (j.a(this.iGe.iFU) == j.c.iGu))
    {
      j.f(this.iGe.iFU).reset(j.e(this.iGe.iFU));
      j.f(this.iGe.iFU).a(j.e(this.iGe.iFU), new l.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousk != null) && (paramAnonymousk.isValid()))
          {
            g.zu(paramAnonymousk.iGw);
            return;
          }
          y.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: refresh session key error!");
          j.a(j.13.1.this.iGe.iFU, j.a.iGp);
        }
      });
      return;
    }
    y.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.13.1
 * JD-Core Version:    0.7.0.1
 */