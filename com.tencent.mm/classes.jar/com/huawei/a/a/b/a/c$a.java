package com.huawei.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  String dXR;
  
  static
  {
    AppMethodBeat.i(208273);
    dXO = new a("CMD_SET_AUDIO_EFFECT_MODE_BASE", 0, "Karaoke_reverb_mode=");
    dXP = new a("CMD_SET_VOCAL_VOLUME_BASE", 1, "Karaoke_volume=");
    dXQ = new a("CMD_SET_VOCAL_EQUALIZER_MODE", 2, "Karaoke_eq_mode=");
    dXS = new a[] { dXO, dXP, dXQ };
    AppMethodBeat.o(208273);
  }
  
  private c$a(String paramString)
  {
    this.dXR = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.huawei.a.a.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */