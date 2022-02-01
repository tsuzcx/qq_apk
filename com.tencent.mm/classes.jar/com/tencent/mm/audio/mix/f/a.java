package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;

public final class a
{
  public static boolean ab(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136884);
    if (!of(paramInt1))
    {
      AppMethodBeat.o(136884);
      return false;
    }
    if (!og(paramInt2))
    {
      AppMethodBeat.o(136884);
      return false;
    }
    if (!oh(paramInt3))
    {
      AppMethodBeat.o(136884);
      return false;
    }
    AppMethodBeat.o(136884);
    return true;
  }
  
  private static boolean of(int paramInt)
  {
    AppMethodBeat.i(136885);
    if (paramInt <= 0)
    {
      b.e("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136885);
      return false;
    }
    if (paramInt == 44100)
    {
      AppMethodBeat.o(136885);
      return true;
    }
    AppMethodBeat.o(136885);
    return false;
  }
  
  private static boolean og(int paramInt)
  {
    AppMethodBeat.i(136886);
    if (paramInt <= 0)
    {
      b.e("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136886);
      return false;
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(136886);
      return true;
    }
    AppMethodBeat.o(136886);
    return false;
  }
  
  private static boolean oh(int paramInt)
  {
    AppMethodBeat.i(136887);
    if (paramInt <= 0) {
      b.e("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(136887);
      return true;
    }
    AppMethodBeat.o(136887);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.a
 * JD-Core Version:    0.7.0.1
 */