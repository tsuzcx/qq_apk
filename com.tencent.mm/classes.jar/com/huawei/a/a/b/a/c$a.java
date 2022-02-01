package com.huawei.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  String chJ;
  
  static
  {
    AppMethodBeat.i(213648);
    chG = new a("CMD_SET_AUDIO_EFFECT_MODE_BASE", 0, "Karaoke_reverb_mode=");
    chH = new a("CMD_SET_VOCAL_VOLUME_BASE", 1, "Karaoke_volume=");
    chI = new a("CMD_SET_VOCAL_EQUALIZER_MODE", 2, "Karaoke_eq_mode=");
    chK = new a[] { chG, chH, chI };
    AppMethodBeat.o(213648);
  }
  
  private c$a(String paramString)
  {
    this.chJ = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.huawei.a.a.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */