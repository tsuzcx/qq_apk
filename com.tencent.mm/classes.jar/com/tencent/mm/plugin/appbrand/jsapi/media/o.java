package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class o
  extends a
{
  public static final int CTRL_INDEX = 216;
  public static final String NAME = "saveVideoToPhotosAlbum";
  
  final String QA(String paramString)
  {
    AppMethodBeat.i(139886);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "mp4";
    }
    paramString = b.arS(str);
    AppMethodBeat.o(139886);
    return paramString;
  }
  
  final void QB(final String paramString)
  {
    AppMethodBeat.i(139887);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139884);
        Toast.makeText(ak.getContext(), ak.getContext().getString(2131764683, new Object[] { b.aSY(paramString) }), 1).show();
        AppMethodBeat.o(139884);
      }
    });
    AppMethodBeat.o(139887);
  }
  
  final boolean Qz(String paramString)
  {
    AppMethodBeat.i(139885);
    boolean bool = bu.nullAsNil(paramString).toLowerCase().contains("video");
    AppMethodBeat.o(139885);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.o
 * JD-Core Version:    0.7.0.1
 */