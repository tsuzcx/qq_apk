package com.tencent.mm.audio.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class a$3
  implements d.b
{
  a$3(a parama) {}
  
  public final void onError()
  {
    AppMethodBeat.i(116451);
    g.KC().b(this.ciw);
    if (a.b(this.ciw))
    {
      g.KC().KF();
      a.c(this.ciw);
    }
    g.KC().setMode(0);
    ab.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(this.ciw)), Boolean.valueOf(a.e(this.ciw)) });
    if (a.e(this.ciw))
    {
      a.f(this.ciw).Mh();
      a.g(this.ciw);
    }
    if (a.h(this.ciw) != null) {
      al.d(new a.3.1(this));
    }
    AppMethodBeat.o(116451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.a.a.3
 * JD-Core Version:    0.7.0.1
 */