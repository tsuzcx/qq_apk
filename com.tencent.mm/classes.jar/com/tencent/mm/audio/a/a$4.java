package com.tencent.mm.audio.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.b;
import com.tencent.mm.sdk.platformtools.bo;

final class a$4
  implements d.a
{
  a$4(a parama) {}
  
  public final void Es()
  {
    AppMethodBeat.i(116455);
    d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116454);
        try
        {
          if (ac.erv.emM == 1) {
            Thread.sleep(300L);
          }
          ab.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.i(a.4.this.ciw), Boolean.valueOf(a.j(a.4.this.ciw)) });
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116453);
              g.KC().d(a.k(a.4.this.ciw), false, false);
              ay.b localb;
              if (a.j(a.4.this.ciw))
              {
                Context localContext = a.l(a.4.this.ciw);
                boolean bool = a.k(a.4.this.ciw);
                a.4.1.1.1 local1 = new a.4.1.1.1(this);
                if (bool)
                {
                  localb = ay.b.ypz;
                  ay.a(localContext, 2131302099, localb, local1);
                }
              }
              for (;;)
              {
                if (a.i(a.4.this.ciw) == null) {
                  break label385;
                }
                ab.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                a.i(a.4.this.ciw).Es();
                AppMethodBeat.o(116453);
                return;
                localb = ay.b.ypA;
                break;
                ab.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                if (!a.4.this.ciw.isPlaying())
                {
                  ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(a.4.this.ciw)), Boolean.valueOf(a.e(a.4.this.ciw)) });
                  if (a.e(a.4.this.ciw))
                  {
                    a.f(a.4.this.ciw).Mh();
                    a.g(a.4.this.ciw);
                  }
                  g.KC().b(a.4.this.ciw);
                  ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.m(a.4.this.ciw)) });
                  if (!a.m(a.4.this.ciw)) {
                    g.KC().KF();
                  }
                  a.n(a.4.this.ciw);
                  a.c(a.4.this.ciw);
                  g.KC().setMode(0);
                  ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                }
              }
              label385:
              ab.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
              AppMethodBeat.o(116453);
            }
          });
          AppMethodBeat.o(116454);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bo.l(localException) });
          AppMethodBeat.o(116454);
        }
      }
    }, "SceneVoice_onCompletion");
    AppMethodBeat.o(116455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.a.a.4
 * JD-Core Version:    0.7.0.1
 */