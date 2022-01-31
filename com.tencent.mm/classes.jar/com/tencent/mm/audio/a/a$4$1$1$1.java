package com.tencent.mm.audio.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ay.a;

final class a$4$1$1$1
  implements ay.a
{
  a$4$1$1$1(a.4.1.1 param1) {}
  
  public final void Es()
  {
    AppMethodBeat.i(116452);
    ab.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
    if (!this.ciB.ciA.ciz.ciw.isPlaying())
    {
      g.KC().b(this.ciB.ciA.ciz.ciw);
      ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.m(this.ciB.ciA.ciz.ciw)) });
      if (!a.m(this.ciB.ciA.ciz.ciw)) {
        g.KC().KF();
      }
      a.n(this.ciB.ciA.ciz.ciw);
      a.c(this.ciB.ciA.ciz.ciw);
      g.KC().setMode(0);
      ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(this.ciB.ciA.ciz.ciw)), Boolean.valueOf(a.e(this.ciB.ciA.ciz.ciw)) });
      if (a.e(this.ciB.ciA.ciz.ciw))
      {
        a.f(this.ciB.ciA.ciz.ciw).Mh();
        a.g(this.ciB.ciA.ciz.ciw);
      }
      ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
    }
    AppMethodBeat.o(116452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.a.a.4.1.1.1
 * JD-Core Version:    0.7.0.1
 */