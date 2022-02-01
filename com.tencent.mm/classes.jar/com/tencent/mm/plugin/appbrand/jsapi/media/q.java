package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.io.InputStream;

public final class q
  implements e
{
  public static final q shw;
  
  static
  {
    AppMethodBeat.i(46601);
    shw = new q();
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
    AppMethodBeat.i(329303);
    paramInputStream = BitmapUtil.decodeStream(paramInputStream);
    AppMethodBeat.o(329303);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q
 * JD-Core Version:    0.7.0.1
 */