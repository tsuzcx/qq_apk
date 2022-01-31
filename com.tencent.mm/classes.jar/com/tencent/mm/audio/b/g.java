package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class g
{
  public static final String ckh;
  public static final String cki;
  
  static
  {
    AppMethodBeat.i(55760);
    ckh = com.tencent.mm.compatible.util.e.eQz + "test.wav";
    cki = com.tencent.mm.compatible.util.e.eQz + "test.pcm";
    AppMethodBeat.o(55760);
  }
  
  public static int x(String paramString, int paramInt)
  {
    AppMethodBeat.i(55759);
    try
    {
      int i = bo.getInt(((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue(paramString), paramInt);
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(paramString)));
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        ab.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(55759);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.g
 * JD-Core Version:    0.7.0.1
 */