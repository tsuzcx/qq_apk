package com.tencent.mm.plugin.appbrand.widget.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class c
{
  public void a(String paramString, d paramd)
  {
    AppMethodBeat.i(87563);
    ab.d("IconLoadErrorHandler ", "setTabBarFail: ".concat(String.valueOf(paramString)));
    if (paramd.jxe != null) {
      paramd.jxe.destroy(paramd.index);
    }
    AppMethodBeat.o(87563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.c
 * JD-Core Version:    0.7.0.1
 */