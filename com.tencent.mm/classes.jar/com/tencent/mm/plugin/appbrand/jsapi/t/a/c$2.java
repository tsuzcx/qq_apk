package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.a.a.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class c$2
  implements a.a
{
  c$2(c paramc) {}
  
  public final void e(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(145928);
    d.v("MicroMsg.DefaultLuggageRecorder", "onFrameRecorded buffSize:%d isLastFrame:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    paramArrayOfByte = this.ifw.ifp.values().iterator();
    while (paramArrayOfByte.hasNext()) {
      ((e.c)paramArrayOfByte.next()).b(arrayOfByte, paramBoolean);
    }
    AppMethodBeat.o(145928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.c.2
 * JD-Core Version:    0.7.0.1
 */