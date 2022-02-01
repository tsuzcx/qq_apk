package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public final int[] JgK;
  
  public f(String paramString)
  {
    AppMethodBeat.i(104654);
    this.JgK = new int[6];
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(q.n(paramString, false), this.JgK));
      Log.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.JgK[0]), Integer.valueOf(this.JgK[1]) });
      AppMethodBeat.o(104654);
      return;
    }
    catch (MMGIFException paramString)
    {
      Log.e("MMGIFInfo", Util.stackTraceToString(paramString));
      AppMethodBeat.o(104654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.f
 * JD-Core Version:    0.7.0.1
 */