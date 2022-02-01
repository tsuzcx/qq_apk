package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;

public final class f
  extends c
{
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(136780);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioVariableConvertProcess", "AudioVariableConvertProcess src:%s, srcSampleRate:%d, srcChannels:%d, srcBitDepth:%d, desSampleRate:%d, desChannels:%d, desBitDepth:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) });
    this.cTT = paramString;
    this.cTU = a.fK(paramString);
    b.MR();
    int i;
    if (paramInt4 <= 0)
    {
      i = 0;
      if (i != 0) {
        this.cTN = paramInt4;
      }
      if (paramInt5 > 0) {
        break label169;
      }
      i = 0;
      label118:
      if (i != 0) {
        this.cTO = paramInt5;
      }
      if (paramInt4 > 0) {
        break label175;
      }
    }
    label169:
    label175:
    for (paramInt4 = j;; paramInt4 = 1)
    {
      if (paramInt4 != 0) {
        this.cTP = paramInt6;
      }
      F(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(136780);
      return;
      i = 1;
      break;
      i = 1;
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.f
 * JD-Core Version:    0.7.0.1
 */