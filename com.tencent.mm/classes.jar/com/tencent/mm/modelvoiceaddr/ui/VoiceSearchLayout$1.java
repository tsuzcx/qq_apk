package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoiceSearchLayout$1
  implements ap.a
{
  VoiceSearchLayout$1(VoiceSearchLayout paramVoiceSearchLayout) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116764);
    if (VoiceSearchLayout.a(this.gcH) == null)
    {
      AppMethodBeat.o(116764);
      return true;
    }
    if (VoiceSearchLayout.b(this.gcH) < VoiceSearchLayout.amU().length)
    {
      VoiceSearchLayout.a(this.gcH, VoiceSearchLayout.amU()[VoiceSearchLayout.c(this.gcH)]);
      AppMethodBeat.o(116764);
      return true;
    }
    f localf = VoiceSearchLayout.a(this.gcH);
    ab.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.gbq);
    int i = localf.gbq;
    localf.gbq = 0;
    if (i > f.ckX) {
      f.ckX = i;
    }
    ab.d("getMaxAmplitude", " map: " + i + " max:" + f.ckX + " per:" + i * 100 / f.ckX);
    i = i * 100 / f.ckX;
    ab.d("MicroMsg.VoiceSearchLayout", "addr vol:".concat(String.valueOf(i)));
    int k = VoiceSearchLayout.d(this.gcH);
    if (VoiceSearchLayout.d(this.gcH) == VoiceSearchLayout.e(this.gcH))
    {
      if (i <= 10)
      {
        VoiceSearchLayout.f(this.gcH);
        if (VoiceSearchLayout.g(this.gcH) >= VoiceSearchLayout.amV().length) {
          VoiceSearchLayout.h(this.gcH);
        }
        VoiceSearchLayout.a(this.gcH, VoiceSearchLayout.amV()[VoiceSearchLayout.g(this.gcH)]);
        AppMethodBeat.o(116764);
        return true;
      }
      int j = i / 5;
      i = j;
      if (j >= VoiceSearchLayout.amW().length) {
        i = VoiceSearchLayout.amW().length - 1;
      }
      ab.d("MicroMsg.VoiceSearchLayout", "addr mvol:".concat(String.valueOf(i)));
      VoiceSearchLayout.b(this.gcH, i);
    }
    for (;;)
    {
      VoiceSearchLayout.a(this.gcH, VoiceSearchLayout.amW()[k]);
      AppMethodBeat.o(116764);
      return true;
      if (VoiceSearchLayout.d(this.gcH) > VoiceSearchLayout.e(this.gcH)) {
        VoiceSearchLayout.i(this.gcH);
      } else {
        VoiceSearchLayout.j(this.gcH);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.1
 * JD-Core Version:    0.7.0.1
 */