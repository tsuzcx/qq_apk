package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
{
  public final int[] uLz;
  
  public f(String paramString)
  {
    AppMethodBeat.i(104654);
    this.uLz = new int[6];
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(q.k(paramString, false), this.uLz));
      ae.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.uLz[0]), Integer.valueOf(this.uLz[1]) });
      AppMethodBeat.o(104654);
      return;
    }
    catch (MMGIFException paramString)
    {
      ae.e("MMGIFInfo", bu.o(paramString));
      AppMethodBeat.o(104654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.f
 * JD-Core Version:    0.7.0.1
 */