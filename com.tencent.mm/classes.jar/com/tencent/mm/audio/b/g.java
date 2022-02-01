package com.tencent.mm.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class g
{
  public static final String diP;
  public static final String diQ;
  
  static
  {
    AppMethodBeat.i(130009);
    diP = b.asj() + "test.wav";
    diQ = b.asj() + "test.pcm";
    AppMethodBeat.o(130009);
  }
  
  public static int A(String paramString, int paramInt)
  {
    AppMethodBeat.i(130008);
    try
    {
      int i = bu.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue(paramString), paramInt);
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(paramString)));
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        ae.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(paramString)));
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