package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class g
{
  public static final String cZa;
  public static final String cZb;
  
  static
  {
    AppMethodBeat.i(130009);
    cZa = b.aih() + "test.wav";
    cZb = b.aih() + "test.pcm";
    AppMethodBeat.o(130009);
  }
  
  public static int x(String paramString, int paramInt)
  {
    AppMethodBeat.i(130008);
    try
    {
      int i = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getValue(paramString), paramInt);
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(paramString)));
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        ad.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(130008);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.g
 * JD-Core Version:    0.7.0.1
 */