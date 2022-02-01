package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.io.InputStream;

public final class p
  implements e
{
  public static final p meq;
  
  static
  {
    AppMethodBeat.i(46601);
    meq = new p();
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
    AppMethodBeat.i(204362);
    paramInputStream = BitmapUtil.decodeStream(paramInputStream);
    AppMethodBeat.o(204362);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p
 * JD-Core Version:    0.7.0.1
 */