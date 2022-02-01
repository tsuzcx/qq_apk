package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  public final int[] uzU;
  
  public f(String paramString)
  {
    AppMethodBeat.i(104654);
    this.uzU = new int[6];
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(q.k(paramString, false), this.uzU));
      ad.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.uzU[0]), Integer.valueOf(this.uzU[1]) });
      AppMethodBeat.o(104654);
      return;
    }
    catch (MMGIFException paramString)
    {
      ad.e("MMGIFInfo", bt.n(paramString));
      AppMethodBeat.o(104654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.f
 * JD-Core Version:    0.7.0.1
 */