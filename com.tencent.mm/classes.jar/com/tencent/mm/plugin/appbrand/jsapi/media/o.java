package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.f;
import java.io.InputStream;

public final class o
  implements d
{
  public static final o jYz;
  
  static
  {
    AppMethodBeat.i(46601);
    jYz = new o();
    AppMethodBeat.o(46601);
  }
  
  public final Bitmap b(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(46600);
    paramInputStream = MMBitmapFactory.decodeStream(paramInputStream, null, paramOptions);
    AppMethodBeat.o(46600);
    return paramInputStream;
  }
  
  public final Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(46599);
    paramString = MMBitmapFactory.decodeFile(paramString, paramOptions);
    AppMethodBeat.o(46599);
    return paramString;
  }
  
  public final Bitmap decodeStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(192556);
    paramInputStream = f.decodeStream(paramInputStream);
    AppMethodBeat.o(192556);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.o
 * JD-Core Version:    0.7.0.1
 */