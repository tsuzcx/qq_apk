package com.tencent.mm.f.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements d.b
{
  a$3(a parama) {}
  
  public final void onError()
  {
    f.yi().b(this.bBH);
    if (a.b(this.bBH))
    {
      f.yi().yl();
      a.c(this.bBH);
    }
    f.yi().setMode(0);
    y.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(this.bBH)), Boolean.valueOf(a.e(this.bBH)) });
    if (a.e(this.bBH))
    {
      a.f(this.bBH).zE();
      a.g(this.bBH);
    }
    if (a.h(this.bBH) != null) {
      ai.d(new a.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.a.3
 * JD-Core Version:    0.7.0.1
 */