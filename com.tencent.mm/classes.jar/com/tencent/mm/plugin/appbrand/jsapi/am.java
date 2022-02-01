package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;

public class am<S extends q>
  extends a<S>
{
  public static final int CTRL_INDEX = 250;
  public static final String NAME = "captureScreen";
  
  public Bitmap g(final S paramS)
  {
    AppMethodBeat.i(139839);
    paramS = paramS.getCurrentPageView();
    if (paramS == null)
    {
      AppMethodBeat.o(139839);
      return null;
    }
    paramS = (Bitmap)new bn()new ao {}.b(new ao(Looper.getMainLooper()));
    AppMethodBeat.o(139839);
    return paramS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.am
 * JD-Core Version:    0.7.0.1
 */