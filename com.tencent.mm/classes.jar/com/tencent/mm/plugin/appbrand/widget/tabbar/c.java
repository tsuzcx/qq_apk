package com.tencent.mm.plugin.appbrand.widget.tabbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class c
{
  public void a(String paramString, d paramd)
  {
    AppMethodBeat.i(135542);
    Log.d("IconLoadErrorHandler ", "setTabBarFail: ".concat(String.valueOf(paramString)));
    if (paramd.rGQ != null) {
      paramd.rGQ.destroy(paramd.index);
    }
    AppMethodBeat.o(135542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.c
 * JD-Core Version:    0.7.0.1
 */