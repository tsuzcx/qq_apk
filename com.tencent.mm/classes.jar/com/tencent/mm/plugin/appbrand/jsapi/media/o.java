package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends a
{
  public static final int CTRL_INDEX = 216;
  public static final String NAME = "saveVideoToPhotosAlbum";
  
  final boolean PQ(String paramString)
  {
    AppMethodBeat.i(139885);
    boolean bool = bt.nullAsNil(paramString).toLowerCase().contains("video");
    AppMethodBeat.o(139885);
    return bool;
  }
  
  final String PR(String paramString)
  {
    AppMethodBeat.i(139886);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "mp4";
    }
    paramString = b.aqN(str);
    AppMethodBeat.o(139886);
    return paramString;
  }
  
  final void PS(final String paramString)
  {
    AppMethodBeat.i(139887);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139884);
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131764683, new Object[] { b.aRB(paramString) }), 1).show();
        AppMethodBeat.o(139884);
      }
    });
    AppMethodBeat.o(139887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.o
 * JD-Core Version:    0.7.0.1
 */