package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.a.b;
import java.io.InputStream;

public abstract interface d
  extends b
{
  public static final d hQB = new d.1();
  
  public abstract Bitmap b(InputStream paramInputStream, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.d
 * JD-Core Version:    0.7.0.1
 */