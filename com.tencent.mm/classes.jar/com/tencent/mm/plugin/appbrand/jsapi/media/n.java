package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class n
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  final String QA(String paramString)
  {
    AppMethodBeat.i(139882);
    paramString = b.arS(paramString);
    AppMethodBeat.o(139882);
    return paramString;
  }
  
  final void QB(String paramString)
  {
    AppMethodBeat.i(139883);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139880);
        Toast.makeText(ak.getContext(), ak.getContext().getString(2131757969, new Object[] { b.fjf() }), 1).show();
        AppMethodBeat.o(139880);
      }
    });
    AppMethodBeat.o(139883);
  }
  
  final boolean Qz(String paramString)
  {
    AppMethodBeat.i(139881);
    boolean bool = bu.nullAsNil(paramString).toLowerCase().contains("image");
    AppMethodBeat.o(139881);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.n
 * JD-Core Version:    0.7.0.1
 */