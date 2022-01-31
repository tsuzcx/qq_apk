package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
  extends a
{
  public static final int CTRL_INDEX = 216;
  public static final String NAME = "saveVideoToPhotosAlbum";
  
  final boolean Ck(String paramString)
  {
    AppMethodBeat.i(114371);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().contains("video");
    AppMethodBeat.o(114371);
    return bool;
  }
  
  final String Cl(String paramString)
  {
    AppMethodBeat.i(114372);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "mp4";
    }
    paramString = b.TY(str);
    AppMethodBeat.o(114372);
    return paramString;
  }
  
  final void Cm(String paramString)
  {
    AppMethodBeat.i(114373);
    al.d(new k.1(this, paramString));
    AppMethodBeat.o(114373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.k
 * JD-Core Version:    0.7.0.1
 */