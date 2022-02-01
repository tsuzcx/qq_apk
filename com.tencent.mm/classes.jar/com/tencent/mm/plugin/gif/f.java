package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
{
  public final int[] txk;
  
  public f(String paramString)
  {
    AppMethodBeat.i(104654);
    this.txk = new int[6];
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(q.k(paramString, false), this.txk));
      ac.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.txk[0]), Integer.valueOf(this.txk[1]) });
      AppMethodBeat.o(104654);
      return;
    }
    catch (MMGIFException paramString)
    {
      ac.e("MMGIFInfo", bs.m(paramString));
      AppMethodBeat.o(104654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.f
 * JD-Core Version:    0.7.0.1
 */