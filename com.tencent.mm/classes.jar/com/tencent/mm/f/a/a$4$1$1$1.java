package com.tencent.mm.f.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$4$1$1$1
  implements au.a
{
  a$4$1$1$1(a.4.1.1 param1) {}
  
  public final void ug()
  {
    y.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
    if (!this.bBM.bBL.bBK.bBH.isPlaying())
    {
      f.yi().b(this.bBM.bBL.bBK.bBH);
      y.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.m(this.bBM.bBL.bBK.bBH)) });
      if (!a.m(this.bBM.bBL.bBK.bBH)) {
        f.yi().yl();
      }
      a.n(this.bBM.bBL.bBK.bBH);
      a.c(this.bBM.bBL.bBK.bBH);
      f.yi().setMode(0);
      y.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(this.bBM.bBL.bBK.bBH)), Boolean.valueOf(a.e(this.bBM.bBL.bBK.bBH)) });
      if (a.e(this.bBM.bBL.bBK.bBH))
      {
        a.f(this.bBM.bBL.bBK.bBH).zE();
        a.g(this.bBM.bBL.bBK.bBH);
      }
      y.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.a.4.1.1.1
 * JD-Core Version:    0.7.0.1
 */