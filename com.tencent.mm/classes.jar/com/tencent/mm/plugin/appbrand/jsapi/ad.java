package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;

public class ad<S extends r>
  extends a<S>
{
  public static final int CTRL_INDEX = 250;
  public static final String NAME = "captureScreen";
  
  public Bitmap g(S paramS)
  {
    AppMethodBeat.i(114321);
    paramS = paramS.getCurrentPageView();
    if (paramS == null)
    {
      AppMethodBeat.o(114321);
      return null;
    }
    paramS = (Bitmap)new ad.1(this, paramS).b(new ak(Looper.getMainLooper()));
    AppMethodBeat.o(114321);
    return paramS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad
 * JD-Core Version:    0.7.0.1
 */