package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;

public final class a
{
  public static boolean E(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137135);
    if (!gu(paramInt1))
    {
      AppMethodBeat.o(137135);
      return false;
    }
    if (!gv(paramInt2))
    {
      AppMethodBeat.o(137135);
      return false;
    }
    if (!gw(paramInt3))
    {
      AppMethodBeat.o(137135);
      return false;
    }
    AppMethodBeat.o(137135);
    return true;
  }
  
  private static boolean gu(int paramInt)
  {
    AppMethodBeat.i(137136);
    if (paramInt <= 0)
    {
      b.e("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137136);
      return false;
    }
    if (paramInt == 44100)
    {
      AppMethodBeat.o(137136);
      return true;
    }
    AppMethodBeat.o(137136);
    return false;
  }
  
  private static boolean gv(int paramInt)
  {
    AppMethodBeat.i(137137);
    if (paramInt <= 0)
    {
      b.e("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137137);
      return false;
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(137137);
      return true;
    }
    AppMethodBeat.o(137137);
    return false;
  }
  
  private static boolean gw(int paramInt)
  {
    AppMethodBeat.i(137138);
    if (paramInt <= 0) {
      b.e("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(137138);
      return true;
    }
    AppMethodBeat.o(137138);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a
 * JD-Core Version:    0.7.0.1
 */