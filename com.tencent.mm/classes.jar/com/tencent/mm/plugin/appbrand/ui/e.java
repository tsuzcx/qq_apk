package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.f.a;

public final class e
{
  private static final a<com.tencent.mm.plugin.appbrand.i, Bitmap> hdf = new a();
  
  public static void a(com.tencent.mm.plugin.appbrand.i parami, Bitmap paramBitmap)
  {
    if ((parami == null) || (paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    hdf.put(parami, paramBitmap);
  }
  
  public static n b(Context paramContext, com.tencent.mm.plugin.appbrand.i parami)
  {
    Bitmap localBitmap = (Bitmap)hdf.remove(parami);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      return new g(paramContext, parami, localBitmap);
    }
    if (parami.ZG()) {
      return new f(paramContext, parami);
    }
    if (parami.ZH()) {
      return new b(paramContext, parami);
    }
    return new i(paramContext, parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e
 * JD-Core Version:    0.7.0.1
 */