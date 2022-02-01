package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class g
{
  public static final String dAa;
  public static final String dAb;
  
  static
  {
    AppMethodBeat.i(130009);
    dAa = b.aKJ() + "test.wav";
    dAb = b.aKJ() + "test.pcm";
    AppMethodBeat.o(130009);
  }
  
  public static int B(String paramString, int paramInt)
  {
    AppMethodBeat.i(130008);
    try
    {
      int i = Util.getInt(((a)com.tencent.mm.kernel.g.af(a.class)).aqJ().getValue(paramString), paramInt);
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(paramString)));
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        Log.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(paramString)));
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