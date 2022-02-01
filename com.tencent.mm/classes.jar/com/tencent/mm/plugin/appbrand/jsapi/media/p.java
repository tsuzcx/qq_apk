package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

public final class p
  extends a
{
  public static final int CTRL_INDEX = 216;
  public static final String NAME = "saveVideoToPhotosAlbum";
  
  final boolean aaP(String paramString)
  {
    AppMethodBeat.i(139885);
    boolean bool = Util.nullAsNil(paramString).toLowerCase().contains("video");
    AppMethodBeat.o(139885);
    return bool;
  }
  
  final String aaQ(String paramString)
  {
    AppMethodBeat.i(139886);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "mp4";
    }
    paramString = AndroidMediaUtil.getExportImagePath(str);
    AppMethodBeat.o(139886);
    return paramString;
  }
  
  final void aaR(final String paramString)
  {
    AppMethodBeat.i(139887);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139884);
        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.g.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString) }), 1).show();
        AppMethodBeat.o(139884);
      }
    });
    AppMethodBeat.o(139887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p
 * JD-Core Version:    0.7.0.1
 */