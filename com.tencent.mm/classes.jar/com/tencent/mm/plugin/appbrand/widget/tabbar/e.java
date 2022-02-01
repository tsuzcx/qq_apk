package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  public void a(Bitmap paramBitmap, d paramd)
  {
    AppMethodBeat.i(135543);
    if ((paramd != null) && (paramd.mPv != null)) {
      paramd.mPv.destroy(paramd.index);
    }
    AppMethodBeat.o(135543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.e
 * JD-Core Version:    0.7.0.1
 */