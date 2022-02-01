package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public abstract interface d
  extends b
{
  public static final d kxc = new d()
  {
    public final Bitmap b(InputStream paramAnonymousInputStream, BitmapFactory.Options paramAnonymousOptions)
    {
      AppMethodBeat.i(139866);
      paramAnonymousInputStream = BitmapFactory.decodeStream(paramAnonymousInputStream, null, paramAnonymousOptions);
      AppMethodBeat.o(139866);
      return paramAnonymousInputStream;
    }
    
    public final Bitmap decodeFile(String paramAnonymousString, BitmapFactory.Options paramAnonymousOptions)
    {
      AppMethodBeat.i(139865);
      paramAnonymousString = BitmapFactory.decodeFile(paramAnonymousString, paramAnonymousOptions);
      AppMethodBeat.o(139865);
      return paramAnonymousString;
    }
    
    public final Bitmap decodeStream(InputStream paramAnonymousInputStream)
    {
      AppMethodBeat.i(200946);
      paramAnonymousInputStream = BitmapFactory.decodeStream(paramAnonymousInputStream);
      AppMethodBeat.o(200946);
      return paramAnonymousInputStream;
    }
  };
  
  public abstract Bitmap b(InputStream paramInputStream, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap decodeStream(InputStream paramInputStream);
  
  public static final class a
  {
    public static d a(d paramd)
    {
      d locald = paramd;
      if (paramd == null) {
        locald = d.kxc;
      }
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.d
 * JD-Core Version:    0.7.0.1
 */