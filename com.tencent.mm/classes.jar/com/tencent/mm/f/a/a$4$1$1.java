package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.e.a.f;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$4$1$1
  implements Runnable
{
  a$4$1$1(a.4.1 param1) {}
  
  public final void run()
  {
    f.yi().f(a.k(this.bBL.bBK.bBH), false, false);
    au.b localb;
    if (a.j(this.bBL.bBK.bBH))
    {
      Context localContext = a.l(this.bBL.bBK.bBH);
      int i = a.f.play_completed;
      boolean bool = a.k(this.bBL.bBK.bBH);
      a.4.1.1.1 local1 = new a.4.1.1.1(this);
      if (bool)
      {
        localb = au.b.uhu;
        au.a(localContext, i, localb, local1);
      }
    }
    for (;;)
    {
      if (a.i(this.bBL.bBK.bBH) == null) {
        break label380;
      }
      y.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
      a.i(this.bBL.bBK.bBH).ug();
      return;
      localb = au.b.uhv;
      break;
      y.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
      if (!this.bBL.bBK.bBH.isPlaying())
      {
        y.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(this.bBL.bBK.bBH)), Boolean.valueOf(a.e(this.bBL.bBK.bBH)) });
        if (a.e(this.bBL.bBK.bBH))
        {
          a.f(this.bBL.bBK.bBH).zE();
          a.g(this.bBL.bBK.bBH);
        }
        f.yi().b(this.bBL.bBK.bBH);
        y.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.m(this.bBL.bBK.bBH)) });
        if (!a.m(this.bBL.bBK.bBH)) {
          f.yi().yl();
        }
        a.n(this.bBL.bBK.bBH);
        a.c(this.bBL.bBK.bBH);
        f.yi().setMode(0);
        y.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
      }
    }
    label380:
    y.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.a.4.1.1
 * JD-Core Version:    0.7.0.1
 */