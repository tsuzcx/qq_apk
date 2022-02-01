package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  final boolean PQ(String paramString)
  {
    AppMethodBeat.i(139881);
    boolean bool = bt.nullAsNil(paramString).toLowerCase().contains("image");
    AppMethodBeat.o(139881);
    return bool;
  }
  
  final String PR(String paramString)
  {
    AppMethodBeat.i(139882);
    paramString = b.aqN(paramString);
    AppMethodBeat.o(139882);
    return paramString;
  }
  
  final void PS(String paramString)
  {
    AppMethodBeat.i(139883);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139880);
        Toast.makeText(aj.getContext(), aj.getContext().getString(2131757969, new Object[] { b.ffp() }), 1).show();
        AppMethodBeat.o(139880);
      }
    });
    AppMethodBeat.o(139883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.n
 * JD-Core Version:    0.7.0.1
 */