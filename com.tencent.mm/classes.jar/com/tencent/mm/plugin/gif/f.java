package com.tencent.mm.plugin.gif;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
{
  public final int[] lhL = new int[6];
  
  public f(String paramString)
  {
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(paramString, this.lhL));
      y.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.lhL[0]), Integer.valueOf(this.lhL[1]) });
      return;
    }
    catch (MMGIFException paramString)
    {
      y.e("MMGIFInfo", bk.j(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.f
 * JD-Core Version:    0.7.0.1
 */