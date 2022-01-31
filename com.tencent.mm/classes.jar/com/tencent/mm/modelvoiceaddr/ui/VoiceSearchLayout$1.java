package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceSearchLayout$1
  implements am.a
{
  VoiceSearchLayout$1(VoiceSearchLayout paramVoiceSearchLayout) {}
  
  public final boolean tC()
  {
    if (VoiceSearchLayout.a(this.eNc) == null) {
      return true;
    }
    if (VoiceSearchLayout.b(this.eNc) < VoiceSearchLayout.TH().length)
    {
      VoiceSearchLayout.a(this.eNc, VoiceSearchLayout.TH()[VoiceSearchLayout.c(this.eNc)]);
      return true;
    }
    f localf = VoiceSearchLayout.a(this.eNc);
    y.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + localf.eLJ);
    int i = localf.eLJ;
    localf.eLJ = 0;
    if (i > f.bEl) {
      f.bEl = i;
    }
    y.d("getMaxAmplitude", " map: " + i + " max:" + f.bEl + " per:" + i * 100 / f.bEl);
    i = i * 100 / f.bEl;
    y.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i);
    int k = VoiceSearchLayout.d(this.eNc);
    if (VoiceSearchLayout.d(this.eNc) == VoiceSearchLayout.e(this.eNc))
    {
      if (i <= 10)
      {
        VoiceSearchLayout.f(this.eNc);
        if (VoiceSearchLayout.g(this.eNc) >= VoiceSearchLayout.TI().length) {
          VoiceSearchLayout.h(this.eNc);
        }
        VoiceSearchLayout.a(this.eNc, VoiceSearchLayout.TI()[VoiceSearchLayout.g(this.eNc)]);
        return true;
      }
      int j = i / 5;
      i = j;
      if (j >= VoiceSearchLayout.TJ().length) {
        i = VoiceSearchLayout.TJ().length - 1;
      }
      y.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i);
      VoiceSearchLayout.b(this.eNc, i);
    }
    for (;;)
    {
      VoiceSearchLayout.a(this.eNc, VoiceSearchLayout.TJ()[k]);
      return true;
      if (VoiceSearchLayout.d(this.eNc) > VoiceSearchLayout.e(this.eNc)) {
        VoiceSearchLayout.i(this.eNc);
      } else {
        VoiceSearchLayout.j(this.eNc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.1
 * JD-Core Version:    0.7.0.1
 */