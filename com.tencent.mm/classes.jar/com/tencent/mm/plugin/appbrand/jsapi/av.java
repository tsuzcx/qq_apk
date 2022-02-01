package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;

public class av<S extends y>
  extends c<S>
{
  public static final int CTRL_INDEX = 250;
  public static final String NAME = "captureScreen";
  
  public Bitmap j(final S paramS)
  {
    AppMethodBeat.i(139839);
    paramS = paramS.getCurrentPageView();
    if (paramS == null)
    {
      AppMethodBeat.o(139839);
      return null;
    }
    paramS = (Bitmap)new SyncTask()new MMHandler {}.exec(new MMHandler(Looper.getMainLooper()));
    AppMethodBeat.o(139839);
    return paramS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.av
 * JD-Core Version:    0.7.0.1
 */