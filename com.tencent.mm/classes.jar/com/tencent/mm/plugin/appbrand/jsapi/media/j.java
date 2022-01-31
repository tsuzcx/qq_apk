package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  final boolean Ck(String paramString)
  {
    AppMethodBeat.i(114367);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().contains("image");
    AppMethodBeat.o(114367);
    return bool;
  }
  
  final String Cl(String paramString)
  {
    AppMethodBeat.i(114368);
    paramString = b.TY(paramString);
    AppMethodBeat.o(114368);
    return paramString;
  }
  
  final void Cm(String paramString)
  {
    AppMethodBeat.i(114369);
    al.d(new j.1(this));
    AppMethodBeat.o(114369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j
 * JD-Core Version:    0.7.0.1
 */