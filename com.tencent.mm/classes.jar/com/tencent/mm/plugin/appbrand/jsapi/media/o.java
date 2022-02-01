package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public final class o
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  final boolean aaP(String paramString)
  {
    AppMethodBeat.i(139881);
    boolean bool = Util.nullAsNil(paramString).toLowerCase().contains("image");
    AppMethodBeat.o(139881);
    return bool;
  }
  
  final String aaQ(String paramString)
  {
    AppMethodBeat.i(139882);
    paramString = AndroidMediaUtil.getExportImagePath(paramString);
    AppMethodBeat.o(139882);
    return paramString;
  }
  
  final void aaR(String paramString)
  {
    AppMethodBeat.i(139883);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139880);
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.g.cropimage_saved, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }), 1).show();
        AppMethodBeat.o(139880);
      }
    });
    AppMethodBeat.o(139883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.o
 * JD-Core Version:    0.7.0.1
 */