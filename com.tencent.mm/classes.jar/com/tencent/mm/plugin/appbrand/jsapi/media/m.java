package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class m
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  final boolean Ms(String paramString)
  {
    AppMethodBeat.i(139881);
    boolean bool = bs.nullAsNil(paramString).toLowerCase().contains("image");
    AppMethodBeat.o(139881);
    return bool;
  }
  
  final String Mt(String paramString)
  {
    AppMethodBeat.i(139882);
    paramString = b.alY(paramString);
    AppMethodBeat.o(139882);
    return paramString;
  }
  
  final void Mu(String paramString)
  {
    AppMethodBeat.i(139883);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139880);
        Toast.makeText(ai.getContext(), ai.getContext().getString(2131757969, new Object[] { b.eQn() }), 1).show();
        AppMethodBeat.o(139880);
      }
    });
    AppMethodBeat.o(139883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m
 * JD-Core Version:    0.7.0.1
 */