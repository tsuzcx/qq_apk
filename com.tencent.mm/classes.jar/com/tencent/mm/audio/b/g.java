package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class g
{
  public static final String dhM;
  public static final String dhN;
  
  static
  {
    AppMethodBeat.i(130009);
    dhM = b.arU() + "test.wav";
    dhN = b.arU() + "test.pcm";
    AppMethodBeat.o(130009);
  }
  
  public static int z(String paramString, int paramInt)
  {
    AppMethodBeat.i(130008);
    try
    {
      int i = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue(paramString), paramInt);
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