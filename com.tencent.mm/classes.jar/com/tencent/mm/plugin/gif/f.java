package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
{
  public final int[] nFh;
  
  public f(String paramString)
  {
    AppMethodBeat.i(62420);
    this.nFh = new int[6];
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(paramString, this.nFh));
      ab.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.nFh[0]), Integer.valueOf(this.nFh[1]) });
      AppMethodBeat.o(62420);
      return;
    }
    catch (MMGIFException paramString)
    {
      ab.e("MMGIFInfo", bo.l(paramString));
      AppMethodBeat.o(62420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.f
 * JD-Core Version:    0.7.0.1
 */